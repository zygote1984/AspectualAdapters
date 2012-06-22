package org.alia4j.liam.context;

import org.alia4j.liam.Context;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class RightShiftZeroExtendContext extends ShiftContext {
    
    RightShiftZeroExtendContext(final Context firstOperand, final Context secondOperand) {
        super(firstOperand, secondOperand);
    }
    
    @Override
    public int getIntValue(final int v1, final int v2) {
        return v1 >>> v2;
    }
    
    @Override
    public int getIntValue(final int v1, final long v2) {
        return v1 >>> v2;
    }
    
    @Override
    public String toString() {
        return "${" + this.getFirstOperandContext() + " >>> " + this.getSecondOperandContext() + "}";
    }
}
