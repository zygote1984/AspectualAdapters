package org.alia4j.noirin;

import org.alia4j.fial.GenericFunction;
import org.alia4j.liam.AndPredicate;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.BasicPredicate;
import org.alia4j.liam.FalsePredicate;
import org.alia4j.liam.OrPredicate;
import org.alia4j.liam.PredicateProcessor;
import org.alia4j.liam.TruePredicate;

public class PredicateEvaluator implements PredicateProcessor<Boolean, AtomicPredicate> {
    
    private final GenericFunction<?, ?> genericFunction;
    
    public PredicateEvaluator(GenericFunction<?, ?> genericFunction) {
        this.genericFunction = genericFunction;
        
    }
    
    @Override
    public Boolean process(BasicPredicate<AtomicPredicate> predicate) {
        boolean satisfied;
        try {
            satisfied =
                            (Boolean) SystemImpl.getSingletonSystemImpl().compute(predicate.getAtomicPredicate(),
                                            this.genericFunction);
        } catch (final Throwable e) {
            throw new NOIRInSoftException(e);
        }
        return predicate.isPositive() ? satisfied : !satisfied;
    }
    
    @Override
    public Boolean process(AndPredicate<AtomicPredicate> predicate) {
        boolean leftSatisfied = predicate.accept(this);
        boolean rightSatisfied = predicate.accept(this);
        return leftSatisfied && rightSatisfied;
    }
    
    @Override
    public Boolean process(OrPredicate<AtomicPredicate> predicate) {
        boolean leftSatisfied = predicate.accept(this);
        boolean rightSatisfied = predicate.accept(this);
        return leftSatisfied || rightSatisfied;
    }
    
    @Override
    public Boolean process(TruePredicate<AtomicPredicate> predicate) {
        return Boolean.TRUE;
    }
    
    @Override
    public Boolean process(FalsePredicate<AtomicPredicate> predicate) {
        return Boolean.FALSE;
    }
}
