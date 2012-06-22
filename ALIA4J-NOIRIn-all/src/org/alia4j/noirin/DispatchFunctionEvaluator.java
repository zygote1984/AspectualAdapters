package org.alia4j.noirin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.alia4j.bdd.vertex.Sink;
import org.alia4j.bdd.vertex.Split;
import org.alia4j.bdd.vertex.UnaryOperation;
import org.alia4j.fial.AttachedAction;
import org.alia4j.fial.GenericFunction;
import org.alia4j.liam.AtomicPredicate;

public class DispatchFunctionEvaluator extends UnaryOperation<AtomicPredicate, AttachedAction, Set<AttachedAction>> {
    
    private final GenericFunction<?, ?> gf;
    
    private Map<AtomicPredicate, Boolean> evaluationMap;
    
    protected DispatchFunctionEvaluator(final GenericFunction<?, ?> gf) {
        this.gf = gf;
        evaluationMap = new HashMap<AtomicPredicate, Boolean>();
    }
    
    @Override
    public Set<AttachedAction> visit(final Split<AtomicPredicate, AttachedAction> split) {
        final boolean satisfied;
        try {
            satisfied =
                            ((Boolean) SystemImpl.getSingletonSystemImpl().compute(split.getVariable(), this.gf))
                                            .booleanValue();
            evaluationMap.put(split.getVariable(), satisfied);
            
        } catch (final Throwable e) {
            throw new NOIRInSoftException(e);
        }
        
        Set<AttachedAction> result;
        if (satisfied)
            result = split.getHigh().accept(this);
        else
            result = split.getLow().accept(this);
        
        return result;
    }
    
    @Override
    public Set<AttachedAction> visit(final Sink<AtomicPredicate, AttachedAction> sink) {
        return sink.getValue().getComponents();
    }
    
    public Boolean getEvaluationResult(AtomicPredicate ap) {
    	return evaluationMap.get(ap);
    }
}
