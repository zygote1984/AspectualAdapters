package org.alia4j.liam.context;

import java.util.List;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;
import org.alia4j.util.MaybeUtilities;

/**
 * @author Christoph Bockisch
 */
public abstract class RelationalBinaryOperation extends BinaryOperationContext {
    
    RelationalBinaryOperation(final Context firstOperand, final Context secondOperand) {
        super(firstOperand, secondOperand);
    }
    
    @Override
    public Maybe<Boolean> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getFirstOperandContext().computeValueStatically(callStack);
        final Maybe<?> v2 = this.getSecondOperandContext().computeValueStatically(callStack);
        
        if (!v1.isUnknown() && !v2.isUnknown()) {
            final Number numberV1 = MaybeUtilities.numberForValue(v1);
            final Number numberV2 = MaybeUtilities.numberForValue(v2);
            
            if (Double.class == numberV1.getClass() || Double.class == numberV2.getClass()) {
                return Maybe.fromBoolean(this.getBooleanValue(numberV1.doubleValue(), numberV2.doubleValue()));
            } else if (Float.class == numberV1.getClass() || Float.class == numberV2.getClass()) {
                return Maybe.fromBoolean(this.getBooleanValue(numberV1.floatValue(), numberV2.floatValue()));
            } else if (Long.class == numberV1.getClass() || Long.class == numberV2.getClass()) {
                return Maybe.fromBoolean(this.getBooleanValue(numberV1.longValue(), numberV2.longValue()));
            } else {
                return Maybe.fromBoolean(this.getBooleanValue(numberV1.intValue(), numberV2.intValue()));
            }
        }
        return Maybe.unknownBoolean();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.BOOLEAN;
    }
    
    public boolean getBooleanValue(final char v1, final char v2) {
        return this.getBooleanValue((int) v1, (int) v2);
    }
    
    public boolean getBooleanValue(final char v1, final byte v2) {
        return this.getBooleanValue((int) v1, (int) v2);
    }
    
    public boolean getBooleanValue(final char v1, final short v2) {
        return this.getBooleanValue((int) v1, (int) v2);
    }
    
    public boolean getBooleanValue(final char v1, final int v2) {
        return this.getBooleanValue((int) v1, v2);
    }
    
    public boolean getBooleanValue(final char v1, final long v2) {
        return this.getBooleanValue((long) v1, v2);
    }
    
    public boolean getBooleanValue(final char v1, final float v2) {
        return this.getBooleanValue((float) v1, v2);
    }
    
    public boolean getBooleanValue(final char v1, final double v2) {
        return this.getBooleanValue((double) v1, v2);
    }
    
    public boolean getBooleanValue(final byte v1, final char v2) {
        return this.getBooleanValue((int) v1, (int) v2);
    }
    
    public boolean getBooleanValue(final byte v1, final byte v2) {
        return this.getBooleanValue((int) v1, (int) v2);
    }
    
    public boolean getBooleanValue(final byte v1, final short v2) {
        return this.getBooleanValue((int) v1, (int) v2);
    }
    
    public boolean getBooleanValue(final byte v1, final int v2) {
        return this.getBooleanValue((int) v1, v2);
    }
    
    public boolean getBooleanValue(final byte v1, final long v2) {
        return this.getBooleanValue((long) v1, v2);
    }
    
    public boolean getBooleanValue(final byte v1, final float v2) {
        return this.getBooleanValue((float) v1, v2);
    }
    
    public boolean getBooleanValue(final byte v1, final double v2) {
        return this.getBooleanValue((double) v1, v2);
    }
    
    public boolean getBooleanValue(final short v1, final char v2) {
        return this.getBooleanValue((int) v1, (int) v2);
    }
    
    public boolean getBooleanValue(final short v1, final byte v2) {
        return this.getBooleanValue((int) v1, (int) v2);
    }
    
    public boolean getBooleanValue(final short v1, final short v2) {
        return this.getBooleanValue((int) v1, (int) v2);
    }
    
    public boolean getBooleanValue(final short v1, final int v2) {
        return this.getBooleanValue((int) v1, v2);
    }
    
    public boolean getBooleanValue(final short v1, final long v2) {
        return this.getBooleanValue((long) v1, v2);
    }
    
    public boolean getBooleanValue(final short v1, final float v2) {
        return this.getBooleanValue((float) v1, v2);
    }
    
    public boolean getBooleanValue(final short v1, final double v2) {
        return this.getBooleanValue((double) v1, v2);
    }
    
    public boolean getBooleanValue(final int v1, final char v2) {
        return this.getBooleanValue(v1, (int) v2);
    }
    
    public boolean getBooleanValue(final int v1, final byte v2) {
        return this.getBooleanValue(v1, (int) v2);
    }
    
    public boolean getBooleanValue(final int v1, final short v2) {
        return this.getBooleanValue(v1, (int) v2);
    }
    
    public boolean getBooleanValue(final int v1, final long v2) {
        return this.getBooleanValue((long) v1, v2);
    }
    
    public boolean getBooleanValue(final int v1, final float v2) {
        return this.getBooleanValue((float) v1, v2);
    }
    
    public boolean getBooleanValue(final int v1, final double v2) {
        return this.getBooleanValue((double) v1, v2);
    }
    
    public boolean getBooleanValue(final long v1, final char v2) {
        return this.getBooleanValue(v1, (long) v2);
    }
    
    public boolean getBooleanValue(final long v1, final byte v2) {
        return this.getBooleanValue(v1, (long) v2);
    }
    
    public boolean getBooleanValue(final long v1, final short v2) {
        return this.getBooleanValue(v1, (long) v2);
    }
    
    public boolean getBooleanValue(final long v1, final int v2) {
        return this.getBooleanValue(v1, (long) v2);
    }
    
    public boolean getBooleanValue(final long v1, final float v2) {
        return this.getBooleanValue((float) v1, v2);
    }
    
    public boolean getBooleanValue(final long v1, final double v2) {
        return this.getBooleanValue((double) v1, v2);
    }
    
    public boolean getBooleanValue(final float v1, final char v2) {
        return this.getBooleanValue(v1, (float) v2);
    }
    
    public boolean getBooleanValue(final float v1, final byte v2) {
        return this.getBooleanValue(v1, (float) v2);
    }
    
    public boolean getBooleanValue(final float v1, final short v2) {
        return this.getBooleanValue(v1, (float) v2);
    }
    
    public boolean getBooleanValue(final float v1, final int v2) {
        return this.getBooleanValue(v1, (float) v2);
    }
    
    public boolean getBooleanValue(final float v1, final long v2) {
        return this.getBooleanValue(v1, (float) v2);
    }
    
    public boolean getBooleanValue(final float v1, final double v2) {
        return this.getBooleanValue((double) v1, v2);
    }
    
    public boolean getBooleanValue(final double v1, final char v2) {
        return this.getBooleanValue(v1, (double) v2);
    }
    
    public boolean getBooleanValue(final double v1, final byte v2) {
        return this.getBooleanValue(v1, (double) v2);
    }
    
    public boolean getBooleanValue(final double v1, final short v2) {
        return this.getBooleanValue(v1, (double) v2);
    }
    
    public boolean getBooleanValue(final double v1, final int v2) {
        return this.getBooleanValue(v1, (double) v2);
    }
    
    public boolean getBooleanValue(final double v1, final long v2) {
        return this.getBooleanValue(v1, (double) v2);
    }
    
    public boolean getBooleanValue(final double v1, final float v2) {
        return this.getBooleanValue(v1, (double) v2);
    }
    
    public abstract boolean getBooleanValue(long v1, long v2);
    
    public abstract boolean getBooleanValue(float v1, float v2);
    
    public abstract boolean getBooleanValue(int v1, int v2);
    
    public abstract boolean getBooleanValue(double v1, double v2);
}
