package org.alia4j.noirin.transform.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LookupSwitchInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;
import org.objectweb.asm.tree.TryCatchBlockNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.tree.analysis.Value;

/**
 * A semantic bytecode analyzer. <i>This class does not fully check that JSR and RET instructions are valid.</i>
 *
 * @author Eric Bruneton
 */
public class Analyzer<V extends Value> implements Opcodes {

    private final Interpreter<V> interpreter;

    private int n;

    private InsnList insns;

    private List<TryCatchBlockNode>[] handlers;

    private Frame<V>[] frames;

    private Subroutine[] subroutines;

    private boolean[] queued;

    private int[] queue;

    private int top;

    /**
     * Constructs a new {@link Analyzer}.
     *
     * @param interpreter the interpreter to be used to symbolically interpret the bytecode instructions.
     */
    public Analyzer(final Interpreter<V> interpreter) {
        this.interpreter = interpreter;
    }

    /**
     * Analyzes the given method.
     *
     * @param owner the internal name of the class to which the method belongs.
     * @param m the method to be analyzed.
     * @return the symbolic state of the execution stack frame at each bytecode instruction of the method. The size of the
     *         returned array is equal to the number of instructions (and labels) of the method. A given frame is
     *         <tt>null</tt> if and only if the corresponding instruction cannot be reached (dead code).
     * @throws AnalyzerException if a problem occurs during the analysis.
     */
    @SuppressWarnings("unchecked")
    public Frame<V>[] analyze(final String owner, final MethodNode m) throws AnalyzerException {
        if ((m.access & (Opcodes.ACC_ABSTRACT | Opcodes.ACC_NATIVE)) != 0) {
            this.frames = new Frame[0];
            return this.frames;
        }
        this.n = m.instructions.size();
        this.insns = m.instructions;
        this.handlers = new List[this.n];
        this.frames = new Frame[this.n];
        this.subroutines = new Subroutine[this.n];
        this.queued = new boolean[this.n];
        this.queue = new int[this.n];
        this.top = 0;

        // computes exception handlers for each instruction
        for (int i = 0; i < m.tryCatchBlocks.size(); ++i) {
            TryCatchBlockNode tcb = (TryCatchBlockNode) m.tryCatchBlocks.get(i);
            int begin = this.insns.indexOf(tcb.start);
            int end = this.insns.indexOf(tcb.end);
            for (int j = begin; j < end; ++j) {
                List<TryCatchBlockNode> insnHandlers = this.handlers[j];
                if (insnHandlers == null) {
                    insnHandlers = new ArrayList<TryCatchBlockNode>();
                    this.handlers[j] = insnHandlers;
                }
                insnHandlers.add(tcb);
            }
        }

        // computes the subroutine for each instruction:
        Subroutine main = new Subroutine(null, m.maxLocals, null);
        List<JumpInsnNode> subroutineCalls = new ArrayList<JumpInsnNode>();
        Map<LabelNode, Subroutine> subroutineHeads = new HashMap<LabelNode, Subroutine>();
        this.findSubroutine(0, main, subroutineCalls);
        while (!subroutineCalls.isEmpty()) {
            JumpInsnNode jsr = subroutineCalls.remove(0);
            Subroutine sub = subroutineHeads.get(jsr.label);
            if (sub == null) {
                sub = new Subroutine(jsr.label, m.maxLocals, jsr);
                subroutineHeads.put(jsr.label, sub);
                this.findSubroutine(this.insns.indexOf(jsr.label), sub, subroutineCalls);
            } else {
                sub.callers.add(jsr);
            }
        }
        for (int i = 0; i < this.n; ++i) {
            if (this.subroutines[i] != null && this.subroutines[i].start == null) {
                this.subroutines[i] = null;
            }
        }

        // initializes the data structures for the control flow analysis
        Frame<V> current = this.newFrame(m.maxLocals, m.maxStack);
        Frame<V> handler = this.newFrame(m.maxLocals, m.maxStack);
        current.setReturn(this.interpreter.getReturnValue(owner, m, Type.getReturnType(m.desc)));
        Type[] args = Type.getArgumentTypes(m.desc);
        int local = 0;
        if ((m.access & Opcodes.ACC_STATIC) == 0) {
            current.setLocal(local++, this.interpreter.getThisValue(owner, m));
        }
        for (int i = 0; i < args.length; ++i) {
            current.setLocal(local++, this.interpreter.getArgumentValue(owner, m, i, args[i]));
            if (args[i].getSize() == 2) {
                current.setLocal(local++, this.interpreter.newUninitializedSlotValue());
            }
        }
        while (local < m.maxLocals) {
            current.setLocal(local++, this.interpreter.newUninitializedSlotValue());
        }
        this.merge(0, current, null);

        this.init(owner, m);

        // control flow analysis
        while (this.top > 0) {
            int insn = this.queue[--this.top];
            Frame<V> f = this.frames[insn];
            Subroutine subroutine = this.subroutines[insn];
            this.queued[insn] = false;

            AbstractInsnNode insnNode = null;
            try {
                insnNode = m.instructions.get(insn);
                int insnOpcode = insnNode.getOpcode();
                int insnType = insnNode.getType();

                if (insnType == AbstractInsnNode.LABEL || insnType == AbstractInsnNode.LINE
                                || insnType == AbstractInsnNode.FRAME) {
                    this.merge(insn + 1, f, subroutine);
                    this.newControlFlowEdge(insn, insn + 1);
                } else {
                    current.init(f).execute(insnNode, this.interpreter);
                    subroutine = subroutine == null ? null : subroutine.copy();

                    if (insnNode instanceof JumpInsnNode) {
                        JumpInsnNode j = (JumpInsnNode) insnNode;
                        if (insnOpcode != Opcodes.GOTO && insnOpcode != Opcodes.JSR) {
                            this.merge(insn + 1, current, subroutine);
                            this.newControlFlowEdge(insn, insn + 1);
                        }
                        int jump = this.insns.indexOf(j.label);
                        if (insnOpcode == Opcodes.JSR) {
                            this.merge(jump, current, new Subroutine(j.label, m.maxLocals, j));
                        } else {
                            this.merge(jump, current, subroutine);
                        }
                        this.newControlFlowEdge(insn, jump);
                    } else if (insnNode instanceof LookupSwitchInsnNode) {
                        LookupSwitchInsnNode lsi = (LookupSwitchInsnNode) insnNode;
                        int jump = this.insns.indexOf(lsi.dflt);
                        this.merge(jump, current, subroutine);
                        this.newControlFlowEdge(insn, jump);
                        for (int j = 0; j < lsi.labels.size(); ++j) {
                            LabelNode label = (LabelNode) lsi.labels.get(j);
                            jump = this.insns.indexOf(label);
                            this.merge(jump, current, subroutine);
                            this.newControlFlowEdge(insn, jump);
                        }
                    } else if (insnNode instanceof TableSwitchInsnNode) {
                        TableSwitchInsnNode tsi = (TableSwitchInsnNode) insnNode;
                        int jump = this.insns.indexOf(tsi.dflt);
                        this.merge(jump, current, subroutine);
                        this.newControlFlowEdge(insn, jump);
                        for (int j = 0; j < tsi.labels.size(); ++j) {
                            LabelNode label = (LabelNode) tsi.labels.get(j);
                            jump = this.insns.indexOf(label);
                            this.merge(jump, current, subroutine);
                            this.newControlFlowEdge(insn, jump);
                        }
                    } else if (insnOpcode == Opcodes.RET) {
                        if (subroutine == null) {
                            throw new AnalyzerException(insnNode, "RET instruction outside of a sub routine");
                        }
                        for (int i = 0; i < subroutine.callers.size(); ++i) {
                            Object caller = subroutine.callers.get(i);
                            int call = this.insns.indexOf((AbstractInsnNode) caller);
                            if (this.frames[call] != null) {
                                this.merge(call + 1, this.frames[call], current, this.subroutines[call], subroutine.access);
                                this.newControlFlowEdge(insn, call + 1);
                            }
                        }
                    } else if (insnOpcode != Opcodes.ATHROW && (insnOpcode < Opcodes.IRETURN || insnOpcode > Opcodes.RETURN)) {
                        if (subroutine != null) {
                            if (insnNode instanceof VarInsnNode) {
                                int var = ((VarInsnNode) insnNode).var;
                                subroutine.access[var] = true;
                                if (insnOpcode == Opcodes.LLOAD || insnOpcode == Opcodes.DLOAD
                                                || insnOpcode == Opcodes.LSTORE || insnOpcode == Opcodes.DSTORE) {
                                    subroutine.access[var + 1] = true;
                                }
                            } else if (insnNode instanceof IincInsnNode) {
                                int var = ((IincInsnNode) insnNode).var;
                                subroutine.access[var] = true;
                            }
                        }
                        this.merge(insn + 1, current, subroutine);
                        this.newControlFlowEdge(insn, insn + 1);
                    }
                }

                List<TryCatchBlockNode> insnHandlers = this.handlers[insn];
                if (insnHandlers != null) {
                    for (int i = 0; i < insnHandlers.size(); ++i) {
                        TryCatchBlockNode tcb = insnHandlers.get(i);
                        Type type;
                        if (tcb.type == null) {
                            type = Type.getObjectType("java/lang/Throwable");
                        } else {
                            type = Type.getObjectType(tcb.type);
                        }
                        int jump = this.insns.indexOf(tcb.handler);
                        if (this.newControlFlowExceptionEdge(insn, jump)) {
                            handler.init(f);
                            handler.clearStack();
                            handler.push(this.interpreter.getHandledExceptionValue(owner, m, tcb, type));
                            this.merge(jump, handler, subroutine);
                        }
                    }
                }
            } catch (AnalyzerException e) {
                throw new AnalyzerException(e.node, "Error at instruction " + insn + ": " + e.getMessage(), e);
            } catch (Exception e) {
                throw new AnalyzerException(insnNode, "Error at instruction " + insn + ": " + e.getMessage(), e);
            }
        }

        return this.frames;
    }

    private void findSubroutine(int insn, final Subroutine sub, final List<JumpInsnNode> calls) throws AnalyzerException {
        while (true) {
            if (insn < 0 || insn >= this.n) {
                throw new AnalyzerException(null, "Execution can fall off end of the code");
            }
            if (this.subroutines[insn] != null) {
                return;
            }
            this.subroutines[insn] = sub.copy();
            AbstractInsnNode node = this.insns.get(insn);

            // calls findSubroutine recursively on normal successors
            if (node instanceof JumpInsnNode) {
                JumpInsnNode jnode = (JumpInsnNode) node;
                if (node.getOpcode() == Opcodes.JSR) {
                    // do not follow a JSR, it leads to another subroutine!
                    calls.add(jnode);
                } else {
                    this.findSubroutine(this.insns.indexOf(jnode.label), sub, calls);
                }
            } else if (node instanceof TableSwitchInsnNode) {
                TableSwitchInsnNode tsnode = (TableSwitchInsnNode) node;
                this.findSubroutine(this.insns.indexOf(tsnode.dflt), sub, calls);
                for (int i = tsnode.labels.size() - 1; i >= 0; --i) {
                    LabelNode l = (LabelNode) tsnode.labels.get(i);
                    this.findSubroutine(this.insns.indexOf(l), sub, calls);
                }
            } else if (node instanceof LookupSwitchInsnNode) {
                LookupSwitchInsnNode lsnode = (LookupSwitchInsnNode) node;
                this.findSubroutine(this.insns.indexOf(lsnode.dflt), sub, calls);
                for (int i = lsnode.labels.size() - 1; i >= 0; --i) {
                    LabelNode l = (LabelNode) lsnode.labels.get(i);
                    this.findSubroutine(this.insns.indexOf(l), sub, calls);
                }
            }

            // calls findSubroutine recursively on exception handler successors
            List<TryCatchBlockNode> insnHandlers = this.handlers[insn];
            if (insnHandlers != null) {
                for (int i = 0; i < insnHandlers.size(); ++i) {
                    TryCatchBlockNode tcb = insnHandlers.get(i);
                    this.findSubroutine(this.insns.indexOf(tcb.handler), sub, calls);
                }
            }

            // if insn does not falls through to the next instruction, return.
            switch (node.getOpcode()) {
            case GOTO:
            case RET:
            case TABLESWITCH:
            case LOOKUPSWITCH:
            case IRETURN:
            case LRETURN:
            case FRETURN:
            case DRETURN:
            case ARETURN:
            case RETURN:
            case ATHROW:
                return;
            }
            insn++;
        }
    }

    /**
     * Returns the symbolic stack frame for each instruction of the last recently analyzed method.
     *
     * @return the symbolic state of the execution stack frame at each bytecode instruction of the method. The size of the
     *         returned array is equal to the number of instructions (and labels) of the method. A given frame is
     *         <tt>null</tt> if the corresponding instruction cannot be reached, or if an error occured during the analysis
     *         of the method.
     */
    public Frame<V>[] getFrames() {
        return this.frames;
    }

    /**
     * Returns the exception handlers for the given instruction.
     *
     * @param insn the index of an instruction of the last recently analyzed method.
     * @return a list of {@link TryCatchBlockNode} objects.
     */
    public List<TryCatchBlockNode> getHandlers(final int insn) {
        return this.handlers[insn];
    }

    /**
     * Initializes this analyzer. This method is called just before the execution of control flow analysis loop in #analyze.
     * The default implementation of this method does nothing.
     *
     * @param owner the internal name of the class to which the method belongs.
     * @param m the method to be analyzed.
     * @throws AnalyzerException if a problem occurs.
     */
    protected void init(String owner, MethodNode m) throws AnalyzerException {}

    /**
     * Constructs a new frame with the given size.
     *
     * @param nLocals the maximum number of local variables of the frame.
     * @param nStack the maximum stack size of the frame.
     * @return the created frame.
     */
    protected Frame<V> newFrame(final int nLocals, final int nStack) {
        return new Frame<V>(nLocals, nStack + 1 /*quick hack: AspectJ produces static initializes with wrong max_stack*/);
    }

    /**
     * Constructs a new frame that is identical to the given frame.
     *
     * @param src a frame.
     * @return the created frame.
     */
    protected Frame<V> newFrame(final Frame<V> src) {
        return new Frame<V>(src);
    }

    /**
     * Creates a control flow graph edge. The default implementation of this method does nothing. It can be overriden in
     * order to construct the control flow graph of a method (this method is called by the {@link #analyze analyze} method
     * during its visit of the method's code).
     *
     * @param insn an instruction index.
     * @param successor index of a successor instruction.
     */
    protected void newControlFlowEdge(final int insn, final int successor) {}

    /**
     * Creates a control flow graph edge corresponding to an exception handler. The default implementation of this method
     * does nothing. It can be overriden in order to construct the control flow graph of a method (this method is called by
     * the {@link #analyze analyze} method during its visit of the method's code).
     *
     * @param insn an instruction index.
     * @param successor index of a successor instruction.
     * @return true if this edge must be considered in the data flow analysis performed by this analyzer, or false otherwise.
     *         The default implementation of this method always returns true.
     */
    protected boolean newControlFlowExceptionEdge(final int insn, final int successor) {
        return true;
    }

    // -------------------------------------------------------------------------

    private void merge(final int insn, final Frame<V> frame, final Subroutine subroutine) throws AnalyzerException {
        Frame<V> oldFrame = this.frames[insn];
        Subroutine oldSubroutine = this.subroutines[insn];
        boolean changes;

        if (oldFrame == null) {
            this.frames[insn] = this.newFrame(frame);
            changes = true;
        } else {
            changes = oldFrame.merge(frame, this.interpreter);
        }

        if (oldSubroutine == null) {
            if (subroutine != null) {
                this.subroutines[insn] = subroutine.copy();
                changes = true;
            }
        } else {
            if (subroutine != null) {
                changes |= oldSubroutine.merge(subroutine);
            }
        }
        if (changes && !this.queued[insn]) {
            this.queued[insn] = true;
            this.queue[this.top++] = insn;
        }
    }

    private void merge(final int insn, final Frame<V> beforeJSR, final Frame<V> afterRET,
                    final Subroutine subroutineBeforeJSR, final boolean[] access) throws AnalyzerException {
        Frame<V> oldFrame = this.frames[insn];
        Subroutine oldSubroutine = this.subroutines[insn];
        boolean changes;

        afterRET.merge(beforeJSR, access);

        if (oldFrame == null) {
            this.frames[insn] = this.newFrame(afterRET);
            changes = true;
        } else {
            changes = oldFrame.merge(afterRET, access);
        }

        if (oldSubroutine != null && subroutineBeforeJSR != null) {
            changes |= oldSubroutine.merge(subroutineBeforeJSR);
        }
        if (changes && !this.queued[insn]) {
            this.queued[insn] = true;
            this.queue[this.top++] = insn;
        }
    }
}
