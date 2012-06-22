package org.alia4j.liam;

/**
 * @author Andreas Sewe
 */
public interface PredicateProcessor<T, X> {
    
    public T process(BasicPredicate<X> predicate);
    
    public T process(AndPredicate<X> predicate);
    
    public T process(OrPredicate<X> predicate);
    
    public T process(TruePredicate<X> predicate);
    
    public T process(FalsePredicate<X> predicate);
}
