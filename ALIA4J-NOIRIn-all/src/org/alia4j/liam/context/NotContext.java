package org.alia4j.liam.context;

import java.util.List;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class NotContext extends UnaryOperationContext {
    
    protected NotContext(final Context operand) {
        super(operand);
    }
    
    @Override
    public Maybe<Boolean> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getOperand().computeValueStatically(callStack);
        if (!v1.isUnknown()) {
            return Maybe.fromBoolean(this.getBooleanValue(((Boolean) v1.getValue()).booleanValue()));
        } else {
            return new Maybe<Boolean>();
        }
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        return SimpleType.BOOLEAN;
    }
    
    public boolean getBooleanValue(final boolean v) {
        return !v;
    }
    
    @Override
    public String toString() {
        return "${!" + this.getOperand() + "}";
    }
}
