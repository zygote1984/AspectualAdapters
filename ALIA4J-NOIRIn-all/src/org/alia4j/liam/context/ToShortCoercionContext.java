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
public class ToShortCoercionContext extends UnaryOperationContext {
    
    protected ToShortCoercionContext(final Context operand) {
        super(operand);
    }
    
    @Override
    public Maybe<Short> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getOperand().computeValueStatically(callStack);
        if (!v1.isUnknown()) {
            return new Maybe<Short>(MaybeUtilities.numberForValue(v1).shortValue());
        }
        return new Maybe<Short>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        return SimpleType.SHORT;
    }
    
    public final short getShortValue(final char v) {
        return (short) v;
    }
    
    public final short getShortValue(final byte v) {
        return v;
    }
    
    public final short getShortValue(final short v) {
        return v;
    }
    
    public final short getShortValue(final int v) {
        return (short) v;
    }
    
    public final short getShortValue(final long v) {
        return (short) v;
    }
    
    public final short getShortValue(final float v) {
        return (short) v;
    }
    
    public final short getShortValue(final double v) {
        return (short) v;
    }
    
    @Override
    public String toString() {
        return "${(short) " + this.getOperand() + "}";
    }
}
