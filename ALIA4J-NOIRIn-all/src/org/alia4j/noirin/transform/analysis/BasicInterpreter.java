package org.alia4j.noirin.transform.analysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.TryCatchBlockNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.analysis.AnalyzerException;

/**
 * An {@link Interpreter} for {@link BasicValue} values.
 * 
 * @author Eric Bruneton
 * @author Bing Ran
 */
public class BasicInterpreter implements Opcodes, Interpreter<BasicValue> {
    
    private BasicValue createUninitializedSlotValue() {
        return new BasicValue((Type) null, ValueKind.UNINITIALIZED_SLOT);
    }
    
    private BasicValue createUninitializedThisValue(Type type) {
        return new BasicValue(type, ValueKind.UNINITIALIZED_THIS);
    }
    
    private BasicValue createUninitializedNewObjectValue(AbstractInsnNode sourceInsn, Type type) {
        return new BasicValue(type, ValueKind.UNINITIALIZED_NEW_OBJECT, sourceInsn);
    }
    
    private BasicValue createIntValue(AbstractInsnNode sourceInsn) {
        return new BasicValue(Type.INT_TYPE, ValueKind.VALUE, sourceInsn);
    }
    
    private BasicValue createFloatValue(AbstractInsnNode sourceInsn) {
        return new BasicValue(Type.FLOAT_TYPE, ValueKind.VALUE, sourceInsn);
    }
    
    private BasicValue createLongValue(AbstractInsnNode sourceInsn) {
        return new BasicValue(Type.LONG_TYPE, ValueKind.VALUE, sourceInsn);
    }
    
    private BasicValue createDoubleValue(AbstractInsnNode sourceInsn) {
        return new BasicValue(Type.DOUBLE_TYPE, ValueKind.VALUE, sourceInsn);
    }
    
    private BasicValue createReferenceValue(AbstractInsnNode sourceInsn) {
        return new BasicValue(Type.getObjectType("java/lang/Object"), ValueKind.VALUE, sourceInsn);
    }
    
    private BasicValue createValue(AbstractInsnNode sourceInsn, Type type) {
        return new BasicValue(type, ValueKind.VALUE, sourceInsn);
    }
    
    private BasicValue createReturnAddressValue(AbstractInsnNode sourceInsn) {
        return new BasicValue(Type.VOID_TYPE, ValueKind.RETURN_ADDRESS, sourceInsn);
    }
    
    private BasicValue createNullValue(AbstractInsnNode sourceInsn) {
        return new BasicValue(Type.getObjectType("null"), ValueKind.NULL, sourceInsn);
    }
    
    public BasicValue newOperation(final Frame<BasicValue> frame, final AbstractInsnNode insn) throws AnalyzerException {
        switch (insn.getOpcode()) {
        case ACONST_NULL:
            return this.createNullValue(insn);
        case ICONST_M1:
        case ICONST_0:
        case ICONST_1:
        case ICONST_2:
        case ICONST_3:
        case ICONST_4:
        case ICONST_5:
            return this.createIntValue(insn);
        case LCONST_0:
        case LCONST_1:
            return this.createLongValue(insn);
        case FCONST_0:
        case FCONST_1:
        case FCONST_2:
            return this.createFloatValue(insn);
        case DCONST_0:
        case DCONST_1:
            return this.createDoubleValue(insn);
        case BIPUSH:
        case SIPUSH:
            return this.createIntValue(insn);
        case LDC:
            Object cst = ((LdcInsnNode) insn).cst;
            if (cst instanceof Integer) {
                return this.createIntValue(insn);
            } else if (cst instanceof Float) {
                return this.createFloatValue(insn);
            } else if (cst instanceof Long) {
                return this.createLongValue(insn);
            } else if (cst instanceof Double) {
                return this.createDoubleValue(insn);
            } else if (cst instanceof Type) {
                return this.createValue(insn, Type.getObjectType("java/lang/Class"));
            } else {
                return this.createValue(insn, Type.getType(cst.getClass()));
            }
        case JSR:
            return this.createReturnAddressValue(insn);
        case GETSTATIC:
            return this.createValue(insn, Type.getType(((FieldInsnNode) insn).desc));
        case NEW:
            return this.createUninitializedNewObjectValue(insn, Type.getObjectType(((TypeInsnNode) insn).desc));
        default:
            throw new Error("Internal error.");
        }
    }
    
    public BasicValue copyOperation(final Frame<BasicValue> frame, final AbstractInsnNode insn, final BasicValue value)
                    throws AnalyzerException {
        return new BasicValue(insn, value);
    }
    
    public BasicValue unaryOperation(final Frame<BasicValue> frame, final AbstractInsnNode insn, final BasicValue value)
                    throws AnalyzerException {
        switch (insn.getOpcode()) {
        case INEG:
        case IINC:
        case L2I:
        case F2I:
        case D2I:
        case I2B:
        case I2C:
        case I2S:
            return this.createIntValue(insn);
        case FNEG:
        case I2F:
        case L2F:
        case D2F:
            return this.createFloatValue(insn);
        case LNEG:
        case I2L:
        case F2L:
        case D2L:
            return this.createLongValue(insn);
        case DNEG:
        case I2D:
        case L2D:
        case F2D:
            return this.createDoubleValue(insn);
        case IFEQ:
        case IFNE:
        case IFLT:
        case IFGE:
        case IFGT:
        case IFLE:
        case TABLESWITCH:
        case LOOKUPSWITCH:
        case IRETURN:
        case LRETURN:
        case FRETURN:
        case DRETURN:
        case ARETURN:
        case PUTSTATIC:
            return null;
        case GETFIELD:
            return this.createValue(insn, Type.getType(((FieldInsnNode) insn).desc));
        case NEWARRAY:
            switch (((IntInsnNode) insn).operand) {
            case T_BOOLEAN:
                return this.createValue(insn, Type.getType("[Z"));
            case T_CHAR:
                return this.createValue(insn, Type.getType("[C"));
            case T_BYTE:
                return this.createValue(insn, Type.getType("[B"));
            case T_SHORT:
                return this.createValue(insn, Type.getType("[S"));
            case T_INT:
                return this.createValue(insn, Type.getType("[I"));
            case T_FLOAT:
                return this.createValue(insn, Type.getType("[F"));
            case T_DOUBLE:
                return this.createValue(insn, Type.getType("[D"));
            case T_LONG:
                return this.createValue(insn, Type.getType("[J"));
            default:
                throw new AnalyzerException(insn, "Invalid array type");
            }
        case ANEWARRAY:
            String desc = ((TypeInsnNode) insn).desc;
            return this.createValue(insn, Type.getType("[" + Type.getObjectType(desc)));
        case ARRAYLENGTH:
            return this.createIntValue(insn);
        case ATHROW:
            return null;
        case CHECKCAST:
            desc = ((TypeInsnNode) insn).desc;
            return this.createValue(insn, Type.getObjectType(desc));
        case INSTANCEOF:
            return this.createIntValue(insn);
        case MONITORENTER:
        case MONITOREXIT:
        case IFNULL:
        case IFNONNULL:
            return null;
        default:
            throw new Error("Internal error.");
        }
    }
    
    public BasicValue binaryOperation(final Frame<BasicValue> frame, final AbstractInsnNode insn, final BasicValue value1,
                    final BasicValue value2) throws AnalyzerException {
        switch (insn.getOpcode()) {
        case IALOAD:
        case BALOAD:
        case CALOAD:
        case SALOAD:
        case IADD:
        case ISUB:
        case IMUL:
        case IDIV:
        case IREM:
        case ISHL:
        case ISHR:
        case IUSHR:
        case IAND:
        case IOR:
        case IXOR:
            return this.createIntValue(insn);
        case FALOAD:
        case FADD:
        case FSUB:
        case FMUL:
        case FDIV:
        case FREM:
            return this.createFloatValue(insn);
        case LALOAD:
        case LADD:
        case LSUB:
        case LMUL:
        case LDIV:
        case LREM:
        case LSHL:
        case LSHR:
        case LUSHR:
        case LAND:
        case LOR:
        case LXOR:
            return this.createLongValue(insn);
        case DALOAD:
        case DADD:
        case DSUB:
        case DMUL:
        case DDIV:
        case DREM:
            return this.createDoubleValue(insn);
        case AALOAD:
            return this.createReferenceValue(insn);
        case LCMP:
        case FCMPL:
        case FCMPG:
        case DCMPL:
        case DCMPG:
            return this.createIntValue(insn);
        case IF_ICMPEQ:
        case IF_ICMPNE:
        case IF_ICMPLT:
        case IF_ICMPGE:
        case IF_ICMPGT:
        case IF_ICMPLE:
        case IF_ACMPEQ:
        case IF_ACMPNE:
        case PUTFIELD:
            return null;
        default:
            throw new Error("Internal error.");
        }
    }
    
    public BasicValue ternaryOperation(final Frame<BasicValue> frame, final AbstractInsnNode insn, final BasicValue value1,
                    final BasicValue value2, final BasicValue value3) throws AnalyzerException {
        return null;
    }
    
    public BasicValue naryOperation(final Frame<BasicValue> frame, final AbstractInsnNode insn, final List<BasicValue> values)
                    throws AnalyzerException {
        if (insn.getOpcode() == Opcodes.INVOKESPECIAL && ((MethodInsnNode) insn).name.equals("<init>")) {
            this.makeAliasesProperObject(values.get(0), frame);
        }
        if (insn.getOpcode() == Opcodes.MULTIANEWARRAY) {
            return this.createValue(insn, Type.getType(((MultiANewArrayInsnNode) insn).desc));
        } else {
            return this.createValue(insn, Type.getReturnType(((MethodInsnNode) insn).desc));
        }
    }
    
    private void makeAliasesProperObject(BasicValue basicValue, Frame<BasicValue> frame) {
        for (int i = 0; i < frame.getLocals(); i++) {
            if (frame.getLocal(i).valueID == basicValue.valueID) {
                frame.setLocal(i, new BasicValue(basicValue, ValueKind.VALUE));
            }
        }
        List<BasicValue> temp = new ArrayList<BasicValue>();
        for (int i = 0; i < frame.getStackSize(); i++) {
            temp.add(0, frame.pop());
        }
        for (BasicValue currentStackItem : temp) {
            if (currentStackItem.valueID == basicValue.valueID) {
                frame.push(new BasicValue(basicValue, ValueKind.VALUE));
            } else {
                frame.push(currentStackItem);
            }
        }
    }
    
    public void returnOperation(final Frame<BasicValue> frame, final AbstractInsnNode insn, final BasicValue value,
                    final BasicValue expected) throws AnalyzerException {}
    
    public BasicValue merge(final BasicValue v, final BasicValue w) {
        if (!v.valueEquals(w)) {
            return this.createUninitializedSlotValue();
        }
        if (v.equals(w))
            return v;
        Set<AbstractInsnNode> combinedInsns = new HashSet<AbstractInsnNode>();
        combinedInsns.addAll(v.insns);
        combinedInsns.addAll(w.insns);
        Set<BasicValue> combinedSourceValues = new HashSet<BasicValue>();
        combinedSourceValues.addAll(v.sourceValues);
        combinedSourceValues.addAll(w.sourceValues);
        return new BasicValue(v.type, v.valueKind, combinedInsns, combinedSourceValues);
    }
    
    public BasicValue getThisValue(String owner, MethodNode m) {
        if (m.name.equals("<init>"))
            return this.createUninitializedThisValue(Type.getObjectType(owner));
        else
            return this.createValue(null, Type.getObjectType(owner));
    }
    
    public BasicValue getArgumentValue(String owner, MethodNode method, int argumentIndex, Type argumentType) {
        return this.createValue(null, argumentType);
    }
    
    public BasicValue newUninitializedSlotValue() {
        return this.createUninitializedSlotValue();
    }
    
    public BasicValue getHandledExceptionValue(String owner, MethodNode m, TryCatchBlockNode tcb, Type type) {
        return this.createValue(null, type);
    }
    
    public BasicValue getReturnValue(String owner, MethodNode m, Type returnType) {
        if (returnType.equals(Type.VOID_TYPE))
            return null;
        else
            return this.createValue(null, returnType);
    }
}
