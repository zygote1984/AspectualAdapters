package org.alia4j.liam.context;

import org.alia4j.liam.Context;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class AndContext extends BooleanBinaryOperationContext {
    
    AndContext(final Context firstOperand, final Context secondOperand) {
        super(firstOperand, secondOperand);
    }
    
    @Override
    public boolean getBooleanValue(final boolean v1, final boolean v2) {
        return v1 && v2;
    }
    
    @Override
    public String toString() {
        return "${" + this.getFirstOperandContext() + " && " + this.getSecondOperandContext() + "}";
    }
}
