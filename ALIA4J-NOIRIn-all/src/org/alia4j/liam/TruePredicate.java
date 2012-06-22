package org.alia4j.liam;

final public class TruePredicate<X> extends Predicate<X> {
    
    @SuppressWarnings("rawtypes")
    public static TruePredicate INSTANCE = new TruePredicate();
    
    @SuppressWarnings("unchecked")
    public static <X> TruePredicate<X> truePredicate() {
        return TruePredicate.INSTANCE;
    }
    
    private TruePredicate() {

    }
    
    @Override
    public Predicate<X> negate() {
        return FalsePredicate.falsePredicate();
    }
    
    @Override
    public <T> T accept(PredicateProcessor<T, X> processor) {
        return processor.process(this);
    }
    
}
