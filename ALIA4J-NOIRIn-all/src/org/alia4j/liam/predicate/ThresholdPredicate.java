package org.alia4j.liam.predicate;

import java.util.Collections;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Context;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
abstract public class ThresholdPredicate extends AtomicPredicate {
    
    protected ThresholdPredicate(final int threshold) {
        super(Collections.<Context>emptyList());
        this.threshold = threshold;
    }
    
    protected boolean isSatisfied() {
        return this.counter.get() == null ? false : this.counter.get() > this.threshold;
    }
    
    private final ThreadLocal<Integer> counter = new ThreadLocal<Integer>();
    
    private final int threshold;
    
    public void enter() {
        if (this.counter.get() == null)
            this.counter.set(1);
        else
            this.counter.set(this.counter.get() + 1);
    }
    
    public void exit() {
        this.counter.set(this.counter.get() - 1);
    }
}
