package org.alia4j.liam.context;

import org.alia4j.liam.Context;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public class RemainderContext extends ArithmeticBinaryOperationContext {
    
    protected RemainderContext(final Context firstOperand, final Context secondOperand) {
        super(firstOperand, secondOperand);
    }
    
    @Override
    public final double getDoubleValue(final int v1, final double v2) {
        return v1 % v2;
    }
    
    @Override
    public final double getDoubleValue(final long v1, final double v2) {
        return v1 % v2;
    }
    
    @Override
    public final double getDoubleValue(final float v1, final double v2) {
        return v1 % v2;
    }
    
    @Override
    public final double getDoubleValue(final double v1, final double v2) {
        return v1 % v2;
    }
    
    @Override
    public final float getFloatValue(final int v1, final float v2) {
        return v1 % v2;
    }
    
    @Override
    public final float getFloatValue(final long v1, final float v2) {
        return v1 % v2;
    }
    
    @Override
    public final float getFloatValue(final float v1, final float v2) {
        return v1 % v2;
    }
    
    @Override
    public final int getIntValue(final int v1, final int v2) {
        return v1 % v2;
    }
    
    @Override
    public final long getLongValue(final int v1, final long v2) {
        return v1 % v2;
    }
    
    @Override
    public final long getLongValue(final long v1, final long v2) {
        return v1 % v2;
    }
    
    @Override
    public final double getDoubleValue(final double v1, final int v2) {
        return v1 % v2;
    }
    
    @Override
    public final double getDoubleValue(final double v1, final long v2) {
        return v1 % v2;
    }
    
    @Override
    public final double getDoubleValue(final double v1, final float v2) {
        return v1 % v2;
    }
    
    @Override
    public final float getFloatValue(final float v1, final int v2) {
        return v1 % v2;
    }
    
    @Override
    public final float getFloatValue(final float v1, final long v2) {
        return v1 % v2;
    }
    
    @Override
    public final long getLongValue(final long v1, final int v2) {
        return v1 % v2;
    }
    
    @Override
    public String toString() {
        return "${" + this.getFirstOperandContext() + " % " + this.getSecondOperandContext() + "}";
    }
}
