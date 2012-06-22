package org.alia4j.liam.context;

import java.util.List;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;
import org.alia4j.util.MaybeUtilities;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public class ToByteCoercionContext extends UnaryOperationContext {
    
    protected ToByteCoercionContext(final Context operand) {
        super(operand);
    }
    
    @Override
    public Maybe<Byte> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getOperand().computeValueStatically(callStack);
        if (!v1.isUnknown()) {
            return new Maybe<Byte>(MaybeUtilities.numberForValue(v1).byteValue());
        }
        return new Maybe<Byte>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        return SimpleType.BYTE;
    }
    
    public final byte getByteValue(final char v) {
        return (byte) v;
    }
    
    public final byte getByteValue(final byte v) {
        return v;
    }
    
    public final byte getByteValue(final short v) {
        return (byte) v;
    }
    
    public final byte getByteValue(final int v) {
        return (byte) v;
    }
    
    public final byte getByteValue(final long v) {
        return (byte) v;
    }
    
    public final byte getByteValue(final float v) {
        return (byte) v;
    }
    
    public final byte getByteValue(final double v) {
        return (byte) v;
    }
    
    @Override
    public String toString() {
        return "${(byte) " + this.getOperand() + "}";
    }
}
