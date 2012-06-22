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
public final class NegationContext extends UnaryOperationContext {
    
    protected NegationContext(final Context operand) {
        super(operand);
    }
    
    @Override
    public Maybe<? extends Number> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getOperand().computeValueStatically(callStack);
        if (!v1.isUnknown()) {
            final Number numberV1 = MaybeUtilities.numberForValue(v1);
            if (numberV1.getClass() == Double.class) {
                return new Maybe<Double>(this.getDoubleValue(numberV1.doubleValue()));
            }
            if (numberV1.getClass() == Float.class) {
                return new Maybe<Float>(this.getFloatValue(numberV1.floatValue()));
            }
            if (numberV1.getClass() == Long.class) {
                return new Maybe<Long>(this.getLongValue(numberV1.longValue()));
            } else {
                return new Maybe<Integer>(this.getIntValue(numberV1.intValue()));
            }
        }
        return new Maybe<Number>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        final SimpleType valueType = this.getOperand().getDeclaredResultType(signed);
        if (valueType == SimpleType.DOUBLE)
            return SimpleType.DOUBLE;
        else if (valueType == SimpleType.FLOAT)
            return SimpleType.FLOAT;
        else if (valueType == SimpleType.LONG)
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
        return -v;
    }
    
    public long getLongValue(final long v) {
        return -v;
    }
    
    public float getFloatValue(final float v) {
        return -v;
    }
    
    public double getDoubleValue(final double v) {
        return -v;
    }
    
    @Override
    public String toString() {
        return "${-" + this.getOperand() + "}";
    }
}
