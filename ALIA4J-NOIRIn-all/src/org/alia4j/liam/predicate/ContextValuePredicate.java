/**
 * 
 */
package org.alia4j.liam.predicate;

import java.util.Collections;
import java.util.List;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Andreas Sewe
 */
public final class ContextValuePredicate extends AtomicPredicate {
    
    protected ContextValuePredicate(final Context context) {
        super(Collections.singletonList(context));
    }
    
    public boolean isSatisfied(final boolean contextValue) {
        return contextValue;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Maybe<Boolean> computeIsSatisfiedStatically(final List<? extends Signed<?>> callStack) {
        return (Maybe<Boolean>) this.getContexts().get(0).computeValueStatically(callStack);
    }
    
    @Override
    public int estimateRuntimeCost() {
        return 1;
    }
    
    @Override
    public String toString() {
        return "context value predicate" + this.getContexts().get(0).toString();
    }
}
