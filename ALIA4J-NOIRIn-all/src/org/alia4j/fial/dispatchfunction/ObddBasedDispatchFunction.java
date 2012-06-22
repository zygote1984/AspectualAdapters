package org.alia4j.fial.dispatchfunction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.alia4j.bdd.BooleanLattice;
import org.alia4j.bdd.synthesis.Conjunction;
import org.alia4j.bdd.synthesis.Disjunction;
import org.alia4j.bdd.synthesis.Projection;
import org.alia4j.bdd.synthesis.ReplacementByConstant;
import org.alia4j.bdd.vertex.BinaryOperation;
import org.alia4j.bdd.vertex.UniqueTable;
import org.alia4j.bdd.vertex.Vertex;
import org.alia4j.fial.AttachedAction;
import org.alia4j.fial.DispatchFunction;
import org.alia4j.liam.AndPredicate;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.BasicPredicate;
import org.alia4j.liam.FalsePredicate;
import org.alia4j.liam.OrPredicate;
import org.alia4j.liam.Predicate;
import org.alia4j.liam.PredicateProcessor;
import org.alia4j.liam.TruePredicate;

/**
 * @author Andreas Sewe
 */
public class ObddBasedDispatchFunction extends DispatchFunction {
    
    public ObddBasedDispatchFunction() {
        this.source = this.getPool().createSink(BooleanLattice.<AttachedAction>bottom());
    }
    
    @Override
    public synchronized void add(final AttachedAction attachedAction, final Predicate<AtomicPredicate> predicate) {
        this.attachedActions.add(attachedAction);
        this.source = this.getDisjunction().apply(this.source, this.convert(predicate, attachedAction));
    }
    
    @Override
    public synchronized void remove(final AttachedAction attachedAction) {
        this.source =
                        this.getConjunction().apply(this.source,
                                        this.getPool().createSink(new BooleanLattice<AttachedAction>(attachedAction, true)));
        this.attachedActions.remove(attachedAction);
    }
    
    @Override
    public Vertex<AtomicPredicate, AttachedAction> getDispatchStrategy() {
        return this.getOverridingFunctionAsObdd();
    }
    
    private final List<AttachedAction> attachedActions = new ArrayList<AttachedAction>();
    
    protected synchronized Vertex<AtomicPredicate, AttachedAction> getApplicabilityFunctionAsObdd() {
        Vertex<AtomicPredicate, AttachedAction> obdd = this.source;
        
        for (final AttachedAction currentAttachedAction : this.attachedActions) {
            AtomicPredicate forcedAtomicPredicate;
            
            if ((forcedAtomicPredicate = currentAttachedAction.getAction().forcesAtomicPredicateFalse()) != null) {
                throw new UnsupportedOperationException();
            }
            if ((forcedAtomicPredicate = currentAttachedAction.getAction().forcesAtomicPredicateTrue()) != null) {
                obdd =
                                this.getDisjunction()
                                                .apply(this.getConjunction()
                                                                .apply(this.getPool()
                                                                                .createSplit(forcedAtomicPredicate,
                                                                                                this.getPool()
                                                                                                                .createSink(BooleanLattice
                                                                                                                                .<AttachedAction>top()),
                                                                                                this.getPool()
                                                                                                                .createSink(BooleanLattice
                                                                                                                                .<AttachedAction>bottom())),
                                                                                new ReplacementByConstant<AtomicPredicate, AttachedAction>(
                                                                                                forcedAtomicPredicate,
                                                                                                false, this.getPool())
                                                                                                .apply(obdd)),
                                                                this.getConjunction()
                                                                                .apply(this.getDisjunction()
                                                                                                .apply(this.getPool()
                                                                                                                .createSplit(forcedAtomicPredicate,
                                                                                                                                this.getPool()
                                                                                                                                                .createSink(BooleanLattice
                                                                                                                                                                .<AttachedAction>bottom()),
                                                                                                                                this.getPool()
                                                                                                                                                .createSink(BooleanLattice
                                                                                                                                                                .<AttachedAction>top())),
                                                                                                                new Projection<AtomicPredicate, AttachedAction>(
                                                                                                                                currentAttachedAction,
                                                                                                                                this.getPool())
                                                                                                                                .apply(obdd)),
                                                                                                new ReplacementByConstant<AtomicPredicate, AttachedAction>(
                                                                                                                forcedAtomicPredicate,
                                                                                                                true,
                                                                                                                this.getPool())
                                                                                                                .apply(obdd)));
            }
        }
        
        return obdd;
    }
    
    protected synchronized Vertex<AtomicPredicate, AttachedAction> getOverridingFunctionAsObdd() {
        Vertex<AtomicPredicate, AttachedAction> obdd;
        obdd = this.getApplicabilityFunctionAsObdd();
        return obdd;
    }
    
    private Vertex<AtomicPredicate, AttachedAction> source;
    
    private final Comparator<AtomicPredicate> order = new Comparator<AtomicPredicate>() {
        
        @Override
        public int compare(final AtomicPredicate p, final AtomicPredicate q) {
            if (p.estimateRuntimeCost() < q.estimateRuntimeCost())
                return -1;
            else if (p.estimateRuntimeCost() > q.estimateRuntimeCost())
                return +1;
            else
                return p.compareTo(q);
        }
    };
    
    protected final UniqueTable<AtomicPredicate, AttachedAction> getPool() {
        return ObddBasedDispatchFunction.pool;
    }
    
    private static final UniqueTable<AtomicPredicate, AttachedAction> pool =
                    new UniqueTable<AtomicPredicate, AttachedAction>();
    
    protected final BinaryOperation<AtomicPredicate, AttachedAction, Vertex<AtomicPredicate, AttachedAction>> getConjunction() {
        if (this.conjunction == null)
            synchronized (this) {
                if (this.conjunction == null)
                    this.conjunction =
                                    new Conjunction<AtomicPredicate, AttachedAction>(this.order,
                                                    ObddBasedDispatchFunction.pool);
            }
        return this.conjunction;
    }
    
    private volatile Conjunction<AtomicPredicate, AttachedAction> conjunction;
    
    protected final BinaryOperation<AtomicPredicate, AttachedAction, Vertex<AtomicPredicate, AttachedAction>> getDisjunction() {
        if (this.disjunction == null)
            synchronized (this) {
                if (this.disjunction == null)
                    this.disjunction =
                                    new Disjunction<AtomicPredicate, AttachedAction>(this.order,
                                                    ObddBasedDispatchFunction.pool);
            }
        return this.disjunction;
    }
    
    private volatile Disjunction<AtomicPredicate, AttachedAction> disjunction;
    
    private Vertex<AtomicPredicate, AttachedAction> convert(final Predicate<AtomicPredicate> predicate,
                    final AttachedAction attachedAction) {
        if (predicate == null) {
            return this.getPool().createSink(new BooleanLattice<AttachedAction>(attachedAction)); // No residue
        } else {
            return predicate.accept(new Converter(attachedAction));
        }
    }
    
    private class Converter implements PredicateProcessor<Vertex<AtomicPredicate, AttachedAction>, AtomicPredicate> {
        
        public Converter(final AttachedAction attachedAction) {
            this.attachedAction = attachedAction;
        }
        
        private final AttachedAction attachedAction;
        
        @Override
        public Vertex<AtomicPredicate, AttachedAction> process(final BasicPredicate<AtomicPredicate> predicate) {
            if (predicate.isPositive())
                return ObddBasedDispatchFunction.this.getPool().createSplit(
                                predicate.getAtomicPredicate(),
                                ObddBasedDispatchFunction.pool.createSink(BooleanLattice.<AttachedAction>bottom()),
                                ObddBasedDispatchFunction.pool.createSink(new BooleanLattice<AttachedAction>(
                                                this.attachedAction)));
            else
                return ObddBasedDispatchFunction.this.getPool().createSplit(
                                predicate.getAtomicPredicate(),
                                ObddBasedDispatchFunction.pool.createSink(new BooleanLattice<AttachedAction>(
                                                this.attachedAction)),
                                ObddBasedDispatchFunction.pool.createSink(BooleanLattice.<AttachedAction>bottom()));
        }
        
        @Override
        public Vertex<AtomicPredicate, AttachedAction> process(final AndPredicate<AtomicPredicate> predicate) {
            return ObddBasedDispatchFunction.this.getConjunction().apply(predicate.getLeftHandSide().accept(this),
                            predicate.getRightHandSide().accept(this));
        }
        
        @Override
        public Vertex<AtomicPredicate, AttachedAction> process(final OrPredicate<AtomicPredicate> predicate) {
            return ObddBasedDispatchFunction.this.getDisjunction().apply(predicate.getLeftHandSide().accept(this),
                            predicate.getRightHandSide().accept(this));
        }
        
        @Override
        public Vertex<AtomicPredicate, AttachedAction> process(TruePredicate<AtomicPredicate> predicate) {
            return ObddBasedDispatchFunction.this.getPool().createSink(
                            new BooleanLattice<AttachedAction>(this.attachedAction));
        }
        
        @Override
        public Vertex<AtomicPredicate, AttachedAction> process(FalsePredicate<AtomicPredicate> predicate) {
            return ObddBasedDispatchFunction.this.getPool().createSink(BooleanLattice.<AttachedAction>bottom());
        }
    }
    
}
