package org.alia4j.liam;

/**
 * @author Andreas Sewe
 */
public abstract class Predicate<X> {
    
    protected Predicate() {}
    
    public abstract Predicate<X> negate();
    
    abstract public <T> T accept(PredicateProcessor<T, X> processor);
}
