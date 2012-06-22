package org.alia4j.liam.predicate;

import java.util.Collections;
import java.util.List;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.event.EventAccessing;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class EventTriggeredPredicate extends AtomicPredicate {
    
    private final EventSignature eventSignature;
    
    protected EventTriggeredPredicate(final EventSignature eventSignature) {
        super(Collections.singletonList(ContextFactory.findOrCreateEventAccessingContext(eventSignature)));
        this.eventSignature = eventSignature;
    }
    
    public boolean isSatisfied(final Object eventAccessing) throws ClassNotFoundException {
        return (((EventAccessing) eventAccessing).isTriggered());
    }
    
    @Override
    public Maybe<Boolean> computeIsSatisfiedStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Boolean>();
    }
    
    @Override
    public String toString() {
        return "EventTriggeredPredicate [eventSignature=" + this.eventSignature + "]";
    }
    
    @Override
    public int estimateRuntimeCost() {
        return EventTriggeredPredicate.ESTIMATED_RUNTIME_COST;
    }
    
    private static final int ESTIMATED_RUNTIME_COST = 1;
    
    @Override
    public boolean dependsOnEvent() {
        return true;
    }
    
    @Override
    public EventSignature getDependedOnEvent() {
        return this.eventSignature;
    }
    
}
