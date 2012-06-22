package org.alia4j.liam.context;

import org.alia4j.liam.Context;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class GreaterContext extends RelationalBinaryOperation {
    
    GreaterContext(final Context firstOperand, final Context secondOperand) {
        super(firstOperand, secondOperand);
    }
    
    @Override
    public boolean getBooleanValue(final long v1, final long v2) {
        return v1 > v2;
    }
    
    @Override
    public boolean getBooleanValue(final float v1, final float v2) {
        return v1 > v2;
    }
    
    @Override
    public boolean getBooleanValue(final int v1, final int v2) {
        return v1 > v2;
    }
    
    @Override
    public boolean getBooleanValue(final double v1, final double v2) {
        return v1 > v2;
    }
    
    @Override
    public String toString() {
        return "${" + this.getFirstOperandContext() + " > " + this.getSecondOperandContext() + "}";
    }
}
