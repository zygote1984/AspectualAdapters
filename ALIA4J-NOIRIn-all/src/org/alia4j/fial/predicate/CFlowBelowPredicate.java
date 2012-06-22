package org.alia4j.fial.predicate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.alia4j.fial.System;
import org.alia4j.fial.SystemScheduleInfo;
import org.alia4j.liam.ActionFactory;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.DebugInfo;
import org.alia4j.liam.Specialization;
import org.alia4j.liam.predicate.ThresholdPredicate;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
final public class CFlowBelowPredicate extends ThresholdPredicate {
    
    private final Attachment increaseAdviceUnit;
    
    private final Attachment decreaseAdviceUnit;
    
    protected CFlowBelowPredicate(final Set<Specialization> constitutingGenericFunctionSpecializations) {
        super(1);
        final Context thresholdPredicateInstance = ContextFactory.findOrCreateObjectConstantContext(this);
        
        final Set<Specialization> specializations = new HashSet<Specialization>();
        for (final Specialization specialization : constitutingGenericFunctionSpecializations) {
            final List<Context> newContexts = new ArrayList<Context>();
            newContexts.add(thresholdPredicateInstance);
            newContexts.addAll(specialization.getContexts());
            specializations.add(new Specialization(specialization.getPattern(), specialization.getPredicate(), newContexts));
        }
        
        this.increaseAdviceUnit =
                        new Attachment(specializations, ActionFactory.findOrCreateCFlowEnterAction(this),
                                        SystemScheduleInfo.BEFORE_FARTHEST, new DebugInfo(
                                                        CFlowBelowPredicate.class.getName() + ".java"));
        this.decreaseAdviceUnit =
                        new Attachment(specializations, ActionFactory.findOrCreateCFlowExitAction(this),
                                        SystemScheduleInfo.AFTER_FARTHEST, new DebugInfo(CFlowBelowPredicate.class.getName()
                                                        + ".java"));
        
        System.deploy(this.increaseAdviceUnit, this.decreaseAdviceUnit);
    }
    
    @Override
    public boolean isSatisfied() {
        return super.isSatisfied();
    }
    
    @Override
    public Maybe<Boolean> computeIsSatisfiedStatically(final List<? extends Signed<?>> callStack) {
        return Maybe.unknownBoolean(); // FIXME We really can compute this.
    }
    
    @Override
    public int estimateRuntimeCost() {
        return CFlowBelowPredicate.ESTIMATED_RUNTIME_COST;
    }
    
    private static final int ESTIMATED_RUNTIME_COST = 2;
}
