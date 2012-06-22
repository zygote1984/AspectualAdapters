package org.alia4j.liam;

import java.util.List;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * Implementors must have a method named <code>isSatisfied</code> with return type <code>boolean</code> and parameter types
 * matching the result values of required {@code Context}s (i.e., primitive types for primitive values,
 * {@code java.lang.Object} for reference values.
 * 
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public abstract class AtomicPredicate extends ManageableInstance implements Comparable<AtomicPredicate> {
    
    protected AtomicPredicate(final List<? extends Context> contexts) {
        super(contexts);
    }
    
    @Override
    protected final CharSequence getMethodName(final Signed<?> call) {
        return "isSatisfied";
    }
    
    @Override
    public final SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.BOOLEAN;
    }
    
    /* public abstract boolean isSatisfied(..); */

    /**
     * @param callStack the top levels of the call stack that are known statically. (The currently dispatched generic
     *            function resides at index 0.)
     * @return the statically computed value of <code>isSatisfied</code> if known, wrapped in a <code>Maybe</code> object.
     */
    public abstract Maybe<Boolean> computeIsSatisfiedStatically(List<? extends Signed<?>> callStack);
    
    public abstract int estimateRuntimeCost();
    
    @Override
    public int compareTo(final AtomicPredicate that) {
        return this.getId() - that.getId();
    }
    
    public boolean dependsOnEvent() {
        return false;
    }
    
    public EventSignature getDependedOnEvent() {
        return null;
    }
    
}
