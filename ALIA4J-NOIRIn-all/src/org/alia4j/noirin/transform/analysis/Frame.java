package org.alia4j.noirin.transform.analysis;

import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.tree.analysis.Value;

/**
 * A symbolic execution stack frame. A stack frame contains a set of local variable slots, and an operand stack. Warning:
 * long and double values are represented by <i>two</i> slots in local variables, and by <i>one</i> slot in the operand
 * stack.
 *
 * @author Eric Bruneton
 */
public class Frame<V extends Value> {

    /**
     * The expected return type of the analyzed method, or <tt>null</tt> if the method returns void.
     */
    private V returnValue;

    /**
     * The local variables and operand stack of this frame.
     */
    private final V[] values;

    /**
     * The number of local variables of this frame.
     */
    private final int locals;

    /**
     * The number of elements in the operand stack.
     */
    private int top;

    /**
     * Constructs a new frame with the given size.
     *
     * @param nLocals the maximum number of local variables of the frame.
     * @param nStack the maximum stack size of the frame.
     */
    @SuppressWarnings("unchecked")
    public Frame(final int nLocals, final int nStack) {
        this.values = (V[]) new Value[nLocals + nStack];
        this.locals = nLocals;
    }

    /**
     * Constructs a new frame that is identical to the given frame.
     *
     * @param src a frame.
     */
    public Frame(final Frame<V> src) {
        this(src.locals, src.values.length - src.locals);
        this.init(src);
    }

    /**
     * Copies the state of the given frame into this frame.
     *
     * @param src a frame.
     * @return this frame.
     */
    public Frame<V> init(final Frame<V> src) {
        this.returnValue = src.returnValue;
        System.arraycopy(src.values, 0, this.values, 0, this.values.length);
        this.top = src.top;
        return this;
    }

    /**
     * Sets the expected return type of the analyzed method.
     *
     * @param v the expected return type of the analyzed method, or <tt>null</tt> if the method returns void.
     */
    public void setReturn(final V v) {
        this.returnValue = v;
    }

    /**
     * Returns the maximum number of local variables of this frame.
     *
     * @return the maximum number of local variables of this frame.
     */
    public int getLocals() {
        return this.locals;
    }

    /**
     * Returns the value of the given local variable.
     *
     * @param i a local variable index.
     * @return the value of the given local variable.
     * @throws IndexOutOfBoundsException if the variable does not exist.
     */
    public V getLocal(final int i) throws IndexOutOfBoundsException {
        if (i >= this.locals) {
            throw new IndexOutOfBoundsException("Trying to access an inexistant local variable");
        }
        return this.values[i];
    }

    /**
     * Sets the value of the given local variable.
     *
     * @param i a local variable index.
     * @param value the new value of this local variable.
     * @throws IndexOutOfBoundsException if the variable does not exist.
     */
    public void setLocal(final int i, final V value) throws IndexOutOfBoundsException {
        if (i >= this.locals) {
            throw new IndexOutOfBoundsException("Trying to access an inexistant local variable " + i);
        }
        this.values[i] = value;
    }

    /**
     * Returns the number of values in the operand stack of this frame. Long and double values are treated as single values.
     *
     * @return the number of values in the operand stack of this frame.
     */
    public int getStackSize() {
        return this.top;
    }

    /**
     * Returns the value of the given operand stack slot.
     *
     * @param i the index of an operand stack slot.
     * @return the value of the given operand stack slot.
     * @throws IndexOutOfBoundsException if the operand stack slot does not exist.
     */
    public V getStack(final int i) throws IndexOutOfBoundsException {
        return this.values[i + this.locals];
    }

    /**
     * Clears the operand stack of this frame.
     */
    public void clearStack() {
        this.top = 0;
    }

    /**
     * Pops a value from the operand stack of this frame.
     *
     * @return the value that has been popped from the stack.
     * @throws IndexOutOfBoundsException if the operand stack is empty.
     */
    public V pop() throws IndexOutOfBoundsException {
        if (this.top == 0) {
            throw new IndexOutOfBoundsException("Cannot pop operand off an empty stack.");
        }
        return this.values[--this.top + this.locals];
    }

    /**
     * Pushes a value into the operand stack of this frame.
     *
     * @param value the value that must be pushed into the stack.
     * @throws IndexOutOfBoundsException if the operand stack is full.
     */
    public void push(final V value) throws IndexOutOfBoundsException {
        if (this.top + this.locals >= this.values.length) {
            throw new IndexOutOfBoundsException("Insufficient maximum stack size.");
        }
        this.values[this.top++ + this.locals] = value;
    }

    public void execute(final AbstractInsnNode insn, final Interpreter<V> interpreter) throws AnalyzerException {
        V value1, value2, value3, value4;
        List<V> values;
        int var;

        switch (insn.getOpcode()) {
        case Opcodes.NOP:
            break;
        case Opcodes.ACONST_NULL:
        case Opcodes.ICONST_M1:
        case Opcodes.ICONST_0:
        case Opcodes.ICONST_1:
        case Opcodes.ICONST_2:
        case Opcodes.ICONST_3:
        case Opcodes.ICONST_4:
        case Opcodes.ICONST_5:
        case Opcodes.LCONST_0:
        case Opcodes.LCONST_1:
        case Opcodes.FCONST_0:
        case Opcodes.FCONST_1:
        case Opcodes.FCONST_2:
        case Opcodes.DCONST_0:
        case Opcodes.DCONST_1:
        case Opcodes.BIPUSH:
        case Opcodes.SIPUSH:
        case Opcodes.LDC:
            this.push(interpreter.newOperation(this, insn));
            break;
        case Opcodes.ILOAD:
        case Opcodes.LLOAD:
        case Opcodes.FLOAD:
        case Opcodes.DLOAD:
        case Opcodes.ALOAD:
            this.push(interpreter.copyOperation(this, insn, this.getLocal(((VarInsnNode) insn).var)));
            break;
        case Opcodes.IALOAD:
        case Opcodes.LALOAD:
        case Opcodes.FALOAD:
        case Opcodes.DALOAD:
        case Opcodes.AALOAD:
        case Opcodes.BALOAD:
        case Opcodes.CALOAD:
        case Opcodes.SALOAD:
            value2 = this.pop();
            value1 = this.pop();
            this.push(interpreter.binaryOperation(this, insn, value1, value2));
            break;
        case Opcodes.ISTORE:
        case Opcodes.LSTORE:
        case Opcodes.FSTORE:
        case Opcodes.DSTORE:
        case Opcodes.ASTORE:
            value1 = interpreter.copyOperation(this, insn, this.pop());
            var = ((VarInsnNode) insn).var;
            this.setLocal(var, value1);
            if (value1.getSize() == 2) {
                this.setLocal(var + 1, interpreter.newUninitializedSlotValue());
            }
            if (var > 0) {
                V local = this.getLocal(var - 1);
                if (local != null && local.getSize() == 2) {
                    this.setLocal(var - 1, interpreter.newUninitializedSlotValue());
                }
            }
            break;
        case Opcodes.IASTORE:
        case Opcodes.LASTORE:
        case Opcodes.FASTORE:
        case Opcodes.DASTORE:
        case Opcodes.AASTORE:
        case Opcodes.BASTORE:
        case Opcodes.CASTORE:
        case Opcodes.SASTORE:
            value3 = this.pop();
            value2 = this.pop();
            value1 = this.pop();
            interpreter.ternaryOperation(this, insn, value1, value2, value3);
            break;
        case Opcodes.POP:
            if (this.pop().getSize() == 2) {
                throw new AnalyzerException(insn, "Illegal use of POP");
            }
            break;
        case Opcodes.POP2:
            if (this.pop().getSize() == 1) {
                if (this.pop().getSize() != 1) {
                    throw new AnalyzerException(insn, "Illegal use of POP2");
                }
            }
            break;
        case Opcodes.DUP:
            value1 = this.pop();
            if (value1.getSize() != 1) {
                throw new AnalyzerException(insn, "Illegal use of DUP");
            }
            this.push(value1);
            this.push(interpreter.copyOperation(this, insn, value1));
            break;
        case Opcodes.DUP_X1:
            value1 = this.pop();
            value2 = this.pop();
            if (value1.getSize() != 1 || value2.getSize() != 1) {
                throw new AnalyzerException(insn, "Illegal use of DUP_X1");
            }
            this.push(interpreter.copyOperation(this, insn, value1));
            this.push(value2);
            this.push(value1);
            break;
        case Opcodes.DUP_X2:
            value1 = this.pop();
            if (value1.getSize() == 1) {
                value2 = this.pop();
                if (value2.getSize() == 1) {
                    value3 = this.pop();
                    if (value3.getSize() == 1) {
                        this.push(interpreter.copyOperation(this, insn, value1));
                        this.push(value3);
                        this.push(value2);
                        this.push(value1);
                        break;
                    }
                } else {
                    this.push(interpreter.copyOperation(this, insn, value1));
                    this.push(value2);
                    this.push(value1);
                    break;
                }
            }
            throw new AnalyzerException(insn, "Illegal use of DUP_X2");
        case Opcodes.DUP2:
            value1 = this.pop();
            if (value1.getSize() == 1) {
                value2 = this.pop();
                if (value2.getSize() == 1) {
                    this.push(value2);
                    this.push(value1);
                    this.push(interpreter.copyOperation(this, insn, value2));
                    this.push(interpreter.copyOperation(this, insn, value1));
                    break;
                }
            } else {
                this.push(value1);
                this.push(interpreter.copyOperation(this, insn, value1));
                break;
            }
            throw new AnalyzerException(insn, "Illegal use of DUP2");
        case Opcodes.DUP2_X1:
            value1 = this.pop();
            if (value1.getSize() == 1) {
                value2 = this.pop();
                if (value2.getSize() == 1) {
                    value3 = this.pop();
                    if (value3.getSize() == 1) {
                        this.push(interpreter.copyOperation(this, insn, value2));
                        this.push(interpreter.copyOperation(this, insn, value1));
                        this.push(value3);
                        this.push(value2);
                        this.push(value1);
                        break;
                    }
                }
            } else {
                value2 = this.pop();
                if (value2.getSize() == 1) {
                    this.push(interpreter.copyOperation(this, insn, value1));
                    this.push(value2);
                    this.push(value1);
                    break;
                }
            }
            throw new AnalyzerException(insn, "Illegal use of DUP2_X1");
        case Opcodes.DUP2_X2:
            value1 = this.pop();
            if (value1.getSize() == 1) {
                value2 = this.pop();
                if (value2.getSize() == 1) {
                    value3 = this.pop();
                    if (value3.getSize() == 1) {
                        value4 = this.pop();
                        if (value4.getSize() == 1) {
                            this.push(interpreter.copyOperation(this, insn, value2));
                            this.push(interpreter.copyOperation(this, insn, value1));
                            this.push(value4);
                            this.push(value3);
                            this.push(value2);
                            this.push(value1);
                            break;
                        }
                    } else {
                        this.push(interpreter.copyOperation(this, insn, value2));
                        this.push(interpreter.copyOperation(this, insn, value1));
                        this.push(value3);
                        this.push(value2);
                        this.push(value1);
                        break;
                    }
                }
            } else {
                value2 = this.pop();
                if (value2.getSize() == 1) {
                    value3 = this.pop();
                    if (value3.getSize() == 1) {
                        this.push(interpreter.copyOperation(this, insn, value1));
                        this.push(value3);
                        this.push(value2);
                        this.push(value1);
                        break;
                    }
                } else {
                    this.push(interpreter.copyOperation(this, insn, value1));
                    this.push(value2);
                    this.push(value1);
                    break;
                }
            }
            throw new AnalyzerException(insn, "Illegal use of DUP2_X2");
        case Opcodes.SWAP:
            value2 = this.pop();
            value1 = this.pop();
            if (value1.getSize() != 1 || value2.getSize() != 1) {
                throw new AnalyzerException(insn, "Illegal use of SWAP");
            }
            this.push(interpreter.copyOperation(this, insn, value2));
            this.push(interpreter.copyOperation(this, insn, value1));
            break;
        case Opcodes.IADD:
        case Opcodes.LADD:
        case Opcodes.FADD:
        case Opcodes.DADD:
        case Opcodes.ISUB:
        case Opcodes.LSUB:
        case Opcodes.FSUB:
        case Opcodes.DSUB:
        case Opcodes.IMUL:
        case Opcodes.LMUL:
        case Opcodes.FMUL:
        case Opcodes.DMUL:
        case Opcodes.IDIV:
        case Opcodes.LDIV:
        case Opcodes.FDIV:
        case Opcodes.DDIV:
        case Opcodes.IREM:
        case Opcodes.LREM:
        case Opcodes.FREM:
        case Opcodes.DREM:
            value2 = this.pop();
            value1 = this.pop();
            this.push(interpreter.binaryOperation(this, insn, value1, value2));
            break;
        case Opcodes.INEG:
        case Opcodes.LNEG:
        case Opcodes.FNEG:
        case Opcodes.DNEG:
            this.push(interpreter.unaryOperation(this, insn, this.pop()));
            break;
        case Opcodes.ISHL:
        case Opcodes.LSHL:
        case Opcodes.ISHR:
        case Opcodes.LSHR:
        case Opcodes.IUSHR:
        case Opcodes.LUSHR:
        case Opcodes.IAND:
        case Opcodes.LAND:
        case Opcodes.IOR:
        case Opcodes.LOR:
        case Opcodes.IXOR:
        case Opcodes.LXOR:
            value2 = this.pop();
            value1 = this.pop();
            this.push(interpreter.binaryOperation(this, insn, value1, value2));
            break;
        case Opcodes.IINC:
            var = ((IincInsnNode) insn).var;
            this.setLocal(var, interpreter.unaryOperation(this, insn, this.getLocal(var)));
            break;
        case Opcodes.I2L:
        case Opcodes.I2F:
        case Opcodes.I2D:
        case Opcodes.L2I:
        case Opcodes.L2F:
        case Opcodes.L2D:
        case Opcodes.F2I:
        case Opcodes.F2L:
        case Opcodes.F2D:
        case Opcodes.D2I:
        case Opcodes.D2L:
        case Opcodes.D2F:
        case Opcodes.I2B:
        case Opcodes.I2C:
        case Opcodes.I2S:
            this.push(interpreter.unaryOperation(this, insn, this.pop()));
            break;
        case Opcodes.LCMP:
        case Opcodes.FCMPL:
        case Opcodes.FCMPG:
        case Opcodes.DCMPL:
        case Opcodes.DCMPG:
            value2 = this.pop();
            value1 = this.pop();
            this.push(interpreter.binaryOperation(this, insn, value1, value2));
            break;
        case Opcodes.IFEQ:
        case Opcodes.IFNE:
        case Opcodes.IFLT:
        case Opcodes.IFGE:
        case Opcodes.IFGT:
        case Opcodes.IFLE:
            interpreter.unaryOperation(this, insn, this.pop());
            break;
        case Opcodes.IF_ICMPEQ:
        case Opcodes.IF_ICMPNE:
        case Opcodes.IF_ICMPLT:
        case Opcodes.IF_ICMPGE:
        case Opcodes.IF_ICMPGT:
        case Opcodes.IF_ICMPLE:
        case Opcodes.IF_ACMPEQ:
        case Opcodes.IF_ACMPNE:
            value2 = this.pop();
            value1 = this.pop();
            interpreter.binaryOperation(this, insn, value1, value2);
            break;
        case Opcodes.GOTO:
            break;
        case Opcodes.JSR:
            this.push(interpreter.newOperation(this, insn));
            break;
        case Opcodes.RET:
            break;
        case Opcodes.TABLESWITCH:
        case Opcodes.LOOKUPSWITCH:
            interpreter.unaryOperation(this, insn, this.pop());
            break;
        case Opcodes.IRETURN:
        case Opcodes.LRETURN:
        case Opcodes.FRETURN:
        case Opcodes.DRETURN:
        case Opcodes.ARETURN:
            value1 = this.pop();
            interpreter.unaryOperation(this, insn, value1);
            interpreter.returnOperation(this, insn, value1, this.returnValue);
            break;
        case Opcodes.RETURN:
            if (this.returnValue != null) {
                throw new AnalyzerException(insn, "Incompatible return type");
            }
            break;
        case Opcodes.GETSTATIC:
            this.push(interpreter.newOperation(this, insn));
            break;
        case Opcodes.PUTSTATIC:
            interpreter.unaryOperation(this, insn, this.pop());
            break;
        case Opcodes.GETFIELD:
            this.push(interpreter.unaryOperation(this, insn, this.pop()));
            break;
        case Opcodes.PUTFIELD:
            value2 = this.pop();
            value1 = this.pop();
            interpreter.binaryOperation(this, insn, value1, value2);
            break;
        case Opcodes.INVOKEVIRTUAL:
        case Opcodes.INVOKESPECIAL:
        case Opcodes.INVOKESTATIC:
        case Opcodes.INVOKEINTERFACE:
        case Opcodes.INVOKEDYNAMIC:
            values = new ArrayList<V>();
            String desc = ((MethodInsnNode) insn).desc;
            for (int i = Type.getArgumentTypes(desc).length; i > 0; --i) {
                values.add(0, this.pop());
            }
            if (insn.getOpcode() != Opcodes.INVOKESTATIC && insn.getOpcode() != Opcodes.INVOKEDYNAMIC) {
                values.add(0, this.pop());
            }
            if (Type.getReturnType(desc) == Type.VOID_TYPE) {
                interpreter.naryOperation(this, insn, values);
            } else {
                this.push(interpreter.naryOperation(this, insn, values));
            }
            break;
        case Opcodes.NEW:
            this.push(interpreter.newOperation(this, insn));
            break;
        case Opcodes.NEWARRAY:
        case Opcodes.ANEWARRAY:
        case Opcodes.ARRAYLENGTH:
            this.push(interpreter.unaryOperation(this, insn, this.pop()));
            break;
        case Opcodes.ATHROW:
            interpreter.unaryOperation(this, insn, this.pop());
            break;
        case Opcodes.CHECKCAST:
        case Opcodes.INSTANCEOF:
            this.push(interpreter.unaryOperation(this, insn, this.pop()));
            break;
        case Opcodes.MONITORENTER:
        case Opcodes.MONITOREXIT:
            interpreter.unaryOperation(this, insn, this.pop());
            break;
        case Opcodes.MULTIANEWARRAY:
            values = new ArrayList<V>();
            for (int i = ((MultiANewArrayInsnNode) insn).dims; i > 0; --i) {
                values.add(0, this.pop());
            }
            this.push(interpreter.naryOperation(this, insn, values));
            break;
        case Opcodes.IFNULL:
        case Opcodes.IFNONNULL:
            interpreter.unaryOperation(this, insn, this.pop());
            break;
        default:
            throw new RuntimeException("Illegal opcode " + insn.getOpcode());
        }
    }

    /**
     * Merges this frame with the given frame.
     *
     * @param frame a frame.
     * @param interpreter the interpreter used to merge values.
     * @return <tt>true</tt> if this frame has been changed as a result of the merge operation, or <tt>false</tt> otherwise.
     * @throws AnalyzerException if the frames have incompatible sizes.
     */
    public boolean merge(final Frame<V> frame, final Interpreter<V> interpreter) throws AnalyzerException {
        if (this.top != frame.top) {
            throw new AnalyzerException(null, "Incompatible stack heights");
        }
        boolean changes = false;
        for (int i = 0; i < this.locals + this.top; ++i) {
            V v = interpreter.merge(this.values[i], frame.values[i]);
            if (v != this.values[i]) {
                this.values[i] = v;
                changes |= true;
            }
        }
        return changes;
    }

    /**
     * Merges this frame with the given frame (case of a RET instruction).
     *
     * @param frame a frame
     * @param access the local variables that have been accessed by the subroutine to which the RET instruction corresponds.
     * @return <tt>true</tt> if this frame has been changed as a result of the merge operation, or <tt>false</tt> otherwise.
     */
    public boolean merge(final Frame<V> frame, final boolean[] access) {
        boolean changes = false;
        for (int i = 0; i < this.locals; ++i) {
            if (!access[i] && !this.values[i].equals(frame.values[i])) {
                this.values[i] = frame.values[i];
                changes = true;
            }
        }
        return changes;
    }

    /**
     * Returns a string representation of this frame.
     *
     * @return a string representation of this frame.
     */
    @Override
    public String toString() {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < this.getLocals(); ++i) {
            b.append(this.getLocal(i));
        }
        b.append(' ');
        for (int i = 0; i < this.getStackSize(); ++i) {
            b.append(this.getStack(i).toString());
        }
        return b.toString();
    }
}
