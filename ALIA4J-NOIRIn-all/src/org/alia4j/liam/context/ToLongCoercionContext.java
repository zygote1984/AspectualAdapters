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
public class ToLongCoercionContext extends UnaryOperationContext {
    
    protected ToLongCoercionContext(final Context operand) {
        super(operand);
    }
    
    @Override
    public Maybe<Long> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getOperand().computeValueStatically(callStack);
        if (!v1.isUnknown()) {
            return new Maybe<Long>(MaybeUtilities.numberForValue(v1).longValue());
        }
        return new Maybe<Long>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        return SimpleType.LONG;
    }
    
    public final long getLongValue(final char v) {
        return v;
    }
    
    public final long getLongValue(final byte v) {
        return v;
    }
    
    public final long getLongValue(final short v) {
        return v;
    }
    
    public final long getLongValue(final int v) {
        return v;
    }
    
    public final long getLongValue(final long v) {
        return v;
    }
    
    public final long getLongValue(final float v) {
        return (long) v;
    }
    
    public final long getLongValue(final double v) {
        return (long) v;
    }
    
    @Override
    public String toString() {
        return "${(long) " + this.getOperand() + "}";
    }
}
