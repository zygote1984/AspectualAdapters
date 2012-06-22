package org.alia4j.liam.action;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeDescriptorConstants;
import org.alia4j.liam.Action;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.predicate.ThresholdPredicate;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class CFlowEnterAction extends Action {
    
    /**
     * @param dependingAtomicPredicate the atomic predicate which checks for the threshold maintained by this action. May not
     *            be {@code null}.
     */
    protected CFlowEnterAction(final ThresholdPredicate dependingAtomicPredicate) {
        this.affectedAtomicPredicate = dependingAtomicPredicate;
    }
    
    private final ThresholdPredicate affectedAtomicPredicate;
    
    @Override
    public AtomicPredicate forcesAtomicPredicateTrue() {
        return this.affectedAtomicPredicate;
    }
    
    @Override
    public TypeDescriptor getRequiredParameterType(final int parameterPosition) {
        throw new IllegalArgumentException("This action may not be passed any argument values");
    }
    
    @Override
    public TypeDescriptor getResultType() {
        return TypeDescriptorConstants.VOID_PRIMITIVE;
    }
    
    public void perform(final Object passedContextValues) {
        this.affectedAtomicPredicate.enter();
    }
}
