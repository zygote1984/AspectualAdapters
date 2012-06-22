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
public final class BitwiseComplementContext extends UnaryOperationContext {
    
    protected BitwiseComplementContext(final Context operand) {
        super(operand);
    }
    
    @Override
    public Maybe<? extends Number> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getOperand().computeValueStatically(callStack);
        if (!v1.isUnknown()) {
            final Number numberV1 = MaybeUtilities.numberForValue(v1);
            
            if (Long.class == numberV1.getClass()) {
                return new Maybe<Long>(this.getLongValue(numberV1.longValue()));
            } else {
                return new Maybe<Integer>(this.getIntValue(numberV1.intValue()));
            }
        }
        return new Maybe<Number>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        if (this.getOperand().getDeclaredResultType(signed) == SimpleType.LONG)
            return SimpleType.LONG;
        else
            return SimpleType.INT;
    }
    
    public int getIntValue(final char v) {
        return this.getIntValue((int) v);
    }
    
    public int getIntValue(final byte v) {
        return this.getIntValue((int) v);
    }
    
    public int getIntValue(final short v) {
        return this.getIntValue((int) v);
    }
    
    public int getIntValue(final int v) {
        return ~v;
    }
    
    public long getLongValue(final long v) {
        return ~v;
    }
    
    @Override
    public String toString() {
        return "${~" + this.getContexts().get(0) + "}";
    }
}
