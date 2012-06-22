package org.alia4j.fial.predicate;

import java.util.Set;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Specialization;
import org.alia4j.liam.predicate.AtomicPredicateFactoryDef;

/**
 * @author Christoph Bockisch
 */
public class AtomicPredicateFactoryImpl extends AtomicPredicateFactoryDef {
    
    protected AtomicPredicateFactoryImpl() {}
    
    public static void initialize() {
        new AtomicPredicateFactoryImpl();
    }
    
    @Override
    protected AtomicPredicate createCFlowBelowPredicate(final Set<Specialization> constitutingGenericFunctionSpecializations) {
        return new CFlowBelowPredicate(constitutingGenericFunctionSpecializations);
    }
    
    @Override
    protected AtomicPredicate createCFlowPredicate(final Set<Specialization> constitutingGenericFunctionSpecializations) {
        return new CFlowPredicate(constitutingGenericFunctionSpecializations);
    }
}
