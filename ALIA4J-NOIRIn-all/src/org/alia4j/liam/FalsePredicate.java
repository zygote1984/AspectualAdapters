package org.alia4j.liam;

final public class FalsePredicate<X> extends Predicate<X> {
    
    @SuppressWarnings("rawtypes")
    public static FalsePredicate INSTANCE = new FalsePredicate();
    
    @SuppressWarnings("unchecked")
    public static <X> FalsePredicate<X> falsePredicate() {
        return FalsePredicate.INSTANCE;
    }
    
    private FalsePredicate() {

    }
    
    @Override
    public Predicate<X> negate() {
        return TruePredicate.truePredicate();
    }
    
    @Override
    public <T> T accept(PredicateProcessor<T, X> processor) {
        return processor.process(this);
    }
    
}
