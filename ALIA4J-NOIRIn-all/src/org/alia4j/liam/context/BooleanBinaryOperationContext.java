package org.alia4j.liam.context;

import java.util.List;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Christoph Bockisch
 */
public abstract class BooleanBinaryOperationContext extends BinaryOperationContext {
    
    BooleanBinaryOperationContext(final Context firstOperand, final Context secondOperand) {
        super(firstOperand, secondOperand);
    }
    
    @Override
    public Maybe<Boolean> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getFirstOperandContext().computeValueStatically(callStack);
        final Maybe<?> v2 = this.getSecondOperandContext().computeValueStatically(callStack);
        
        if (!v1.isUnknown() && !v2.isUnknown()) {
            return Maybe.fromBoolean(this.getBooleanValue(((Boolean) v1.getValue()).booleanValue(),
                            ((Boolean) v2.getValue()).booleanValue()));
        } else {
            return Maybe.unknownBoolean();
        }
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        return SimpleType.BOOLEAN;
    }
    
    public abstract boolean getBooleanValue(boolean v1, boolean v2);
}
