package org.alia4j.noirin.transform.analysis;

import java.util.Collections;
import java.util.Set;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.analysis.Value;

/**
 * A {@link BasicValue} that is represented by its type in a seven types type system. This type system distinguishes the
 * UNINITIALZED, INT, FLOAT, LONG, DOUBLE, REFERENCE and RETURNADDRESS types.
 * 
 * @author Eric Bruneton
 */
public class BasicValue implements Value {
    
    private static int nextValueID = 0;
    
    private static int newValueID() {
        int result = BasicValue.nextValueID;
        BasicValue.nextValueID++;
        return result;
    }
    
    public final int valueID;
    
    public final Type type;
    
    public final ValueKind valueKind;
    
    /**
     * The instructions that can produce this value. For example, for the Java code below, the instructions that can produce
     * the value of <tt>i</tt> at line 5 are the two ISTORE instructions at line 1 and 3:
     * 
     * <pre>
     * 1: i = 0;
     * 2: if (...) {
     * 3:   i = 1;
     * 4: }
     * 5: return i;
     * </pre>
     * 
     * This field is a set of {@link AbstractInsnNode} objects.
     */
    public final Set<AbstractInsnNode> insns;
    
    public final Set<BasicValue> sourceValues;
    
    protected BasicValue(final Type type, final ValueKind valueKind, final Set<AbstractInsnNode> insns) {
        this(type, valueKind, insns, Collections.<BasicValue>emptySet());
    }
    
    protected BasicValue(final Type type, final ValueKind valueKind, final Set<AbstractInsnNode> insns,
                    final Set<BasicValue> sourceValues) {
        this(type, valueKind, insns, sourceValues, BasicValue.newValueID());
    }
    
    protected BasicValue(final Type type, final ValueKind valueKind, final Set<AbstractInsnNode> insns,
                    final Set<BasicValue> sourceValues, int valueID) {
        this.type = type;
        this.valueKind = valueKind;
        this.insns = insns;
        this.sourceValues = sourceValues;
        this.valueID = valueID;
    }
    
    public BasicValue(final Type type, ValueKind valueKind) {
        this(type, valueKind, Collections.<AbstractInsnNode>emptySet());
    }
    
    public BasicValue(final Type type, ValueKind valueKind, final AbstractInsnNode insn) {
        this(type, valueKind, insn == null ? Collections.<AbstractInsnNode>emptySet() : Collections.singleton(insn));
    }
    
    public BasicValue(AbstractInsnNode insn, BasicValue value) {
        this(value.type, value.valueKind, Collections.singleton(insn), Collections.singleton(value), value.valueID);
    }
    
    public BasicValue(BasicValue value, ValueKind valueKind) {
        this(value.type, valueKind, value.insns, value.sourceValues, value.valueID);
    }
    
    public int getSize() {
        return this.type == Type.LONG_TYPE || this.type == Type.DOUBLE_TYPE ? 2 : 1;
    }
    
    public boolean isReference() {
        return this.type != null && (this.type.getSort() == Type.OBJECT || this.type.getSort() == Type.ARRAY);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.insns == null) ? 0 : this.insns.hashCode());
        result = prime * result + ((this.sourceValues == null) ? 0 : this.sourceValues.hashCode());
        result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
        result = prime * result + ((this.valueKind == null) ? 0 : this.valueKind.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        BasicValue other = (BasicValue) obj;
        if (this.insns == null) {
            if (other.insns != null)
                return false;
        } else if (!this.insns.equals(other.insns))
            return false;
        if (this.sourceValues == null) {
            if (other.sourceValues != null)
                return false;
        } else if (!this.sourceValues.equals(other.sourceValues))
            return false;
        if (this.type == null) {
            if (other.type != null)
                return false;
        } else if (!this.type.equals(other.type))
            return false;
        if (this.valueKind != other.valueKind)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "BasicValue [type=" + this.type + ", valueKind=" + this.valueKind + ", insns=" + this.insns
                        + ", sourceValues=" + this.sourceValues + "]";
    }
    
    public boolean valueEquals(BasicValue other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (this.type == null) {
            if (other.type != null)
                return false;
        } else if (!this.type.equals(other.type))
            return false;
        if (this.valueKind != other.valueKind)
            return false;
        return true;
    }
    
}
