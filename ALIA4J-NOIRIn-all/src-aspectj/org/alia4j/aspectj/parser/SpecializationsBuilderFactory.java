package org.alia4j.aspectj.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.alia4j.liam.AndPredicate;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.BasicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.OrPredicate;
import org.alia4j.liam.Predicate;
import org.alia4j.liam.pattern.Pattern;

class SpecializationsBuilderFactory {
    
    private final Context aspectInstanceContext;
    
    protected SpecializationsBuilderFactory(final Context aspectInstanceContext) {
        this.aspectInstanceContext = aspectInstanceContext;
    }
    
    protected SpecializationBuilder createSpecializationBuilder(final int numberOfAdviceArguments, final Pattern<?> pattern) {
        return new SingleSpecializationBuilder(numberOfAdviceArguments, pattern, null, this.aspectInstanceContext);
    }
    
    protected SpecializationBuilder createSpecializationBuilder(final int numberOfAdviceArguments,
                    final AtomicPredicate atomicPredicate) {
        return new SingleSpecializationBuilder(numberOfAdviceArguments, null, new BasicPredicate<AtomicPredicate>(
                        atomicPredicate, true), this.aspectInstanceContext);
    }
    
    /**
     * Creates a new specialization builder with an initial predicate that is the conjunction of all passed atomic
     * predicates.
     * 
     * @param numberOfAdviceArguments
     * @param atomicPredicates may not be <code>null</code>
     * @return
     */
    protected SpecializationBuilder createSpecializationBuilder(final int numberOfAdviceArguments,
                    final Set<AtomicPredicate> atomicPredicates) {
        if (atomicPredicates == null)
            throw new NullPointerException("Atomic predicates may not be null.");
        if (atomicPredicates.isEmpty()) {
            return new SingleSpecializationBuilder(numberOfAdviceArguments, this.aspectInstanceContext);
        }
        
        final Iterator<AtomicPredicate> it = atomicPredicates.iterator();
        Predicate<AtomicPredicate> atomicPredicatesExpression = new BasicPredicate<AtomicPredicate>(it.next(), true);
        while (it.hasNext()) {
            atomicPredicatesExpression =
                            new AndPredicate<AtomicPredicate>(atomicPredicatesExpression,
                                            new BasicPredicate<AtomicPredicate>(it.next(), true));
        }
        return new SingleSpecializationBuilder(numberOfAdviceArguments, null, atomicPredicatesExpression,
                        this.aspectInstanceContext);
    }
    
    protected SpecializationBuilder and(final SpecializationBuilder firstOperand, final SpecializationBuilder secondOperand) {
        if (firstOperand instanceof SingleSpecializationBuilder && secondOperand instanceof SingleSpecializationBuilder) {
            final SingleSpecializationBuilder first = (SingleSpecializationBuilder) firstOperand;
            final SingleSpecializationBuilder second = (SingleSpecializationBuilder) secondOperand;
            
            Predicate<AtomicPredicate> combinedAtomicPredicatesExpression;
            if (first.getPredicate() == null)
                combinedAtomicPredicatesExpression = second.getPredicate();
            else if (second.getPredicate() == null)
                combinedAtomicPredicatesExpression = first.getPredicate();
            else if (first.getPredicate() != null && second.getPredicate() != null) {
                combinedAtomicPredicatesExpression =
                                new AndPredicate<AtomicPredicate>(first.getPredicate(), second.getPredicate());
            } else
                combinedAtomicPredicatesExpression = null;
            
            final List<Context> combinedContexts = this.combineContexts(first, second);
            
            if (first.hasPattern() && !second.hasPattern()) {
                return new SingleSpecializationBuilder(first.getPattern(), combinedAtomicPredicatesExpression,
                                combinedContexts);
            } else if (!first.hasPattern() && second.hasPattern()) {
                return new SingleSpecializationBuilder(second.getPattern(), combinedAtomicPredicatesExpression,
                                combinedContexts);
            } else if (first.hasPattern() && second.hasPattern()) {
                throw new UnsupportedOperationException("Can not perform && (and) operation for two patterns.");
                // TODO need to check, if patterns are compatible and patterns can be merged
            } else {
                return new SingleSpecializationBuilder(null, combinedAtomicPredicatesExpression, combinedContexts);
            }
        } else if (firstOperand instanceof SingleSpecializationBuilder
                        && secondOperand instanceof MultipleSpecializationsBuilder) {
            final SingleSpecializationBuilder first = (SingleSpecializationBuilder) firstOperand;
            final MultipleSpecializationsBuilder second = (MultipleSpecializationsBuilder) secondOperand;
            
            if (first.hasPattern()) {
                throw new UnsupportedOperationException("Can not perform && (and) operation for two patterns.");
                // TODO need to check, if patterns are compatible and patterns can be merged
            } else {
                // and the dynamic property of first to all single builders in second
                final List<SingleSpecializationBuilder> newSingleBuilders = new ArrayList<SingleSpecializationBuilder>(); // will
                // grow
                // to
                // size:
                // second.singleBuilders.size()
                final Iterator<SingleSpecializationBuilder> it = second.buildersIterator();
                while (it.hasNext()) {
                    final SingleSpecializationBuilder current = it.next();
                    newSingleBuilders.add(new SingleSpecializationBuilder(current.getPattern(),
                                    new AndPredicate<AtomicPredicate>(first.getPredicate(), current.getPredicate()), this
                                                    .combineContexts(first, current)));
                }
                return new MultipleSpecializationsBuilder(newSingleBuilders);
            }
        } else if (firstOperand instanceof MultipleSpecializationsBuilder
                        && secondOperand instanceof SingleSpecializationBuilder) {
            final MultipleSpecializationsBuilder first = (MultipleSpecializationsBuilder) firstOperand;
            final SingleSpecializationBuilder second = (SingleSpecializationBuilder) secondOperand;
            
            if (second.hasPattern()) {
                throw new UnsupportedOperationException("Can not perform && (and) operation for two patterns.");
                // TODO need to check, if patterns are compatible and patterns can be merged
            } else {
                // and the dynamic property of first to all single builders in second
                final List<SingleSpecializationBuilder> newSingleBuilders = new ArrayList<SingleSpecializationBuilder>(); // will
                // grow
                // to
                // size
                // first.singleBuilders.size()
                final Iterator<SingleSpecializationBuilder> it = first.buildersIterator();
                while (it.hasNext()) {
                    final SingleSpecializationBuilder current = it.next();
                    newSingleBuilders.add(new SingleSpecializationBuilder(current.getPattern(),
                                    new AndPredicate<AtomicPredicate>(second.getPredicate(), current.getPredicate()), this
                                                    .combineContexts(second, current)));
                }
                return new MultipleSpecializationsBuilder(newSingleBuilders);
            }
        } else {
            throw new UnsupportedOperationException("Can not perform && (and) operation for two patterns.");
            // TODO need to check, if patterns are compatible and patterns can be merged
        }
    }
    
    private List<Context> combineContexts(final SingleSpecializationBuilder first, final SingleSpecializationBuilder second) {
        final List<Context> combinedContexts = new ArrayList<Context>(first.getContexts().size());
        for (int index = 0; index < second.getContexts().size(); index++) {
            if (first.getContexts().get(index) == null) {
                combinedContexts.add(second.getContexts().get(index));
            } else if (second.getContexts().get(index) == null) {
                combinedContexts.add(first.getContexts().get(index));
            } else {
                if (!first.getContexts().get(index).equals(second.getContexts().get(index)))
                    throw new UnsupportedOperationException("Could not merge contexts.");
                combinedContexts.add(first.getContexts().get(index));
            }
        }
        return combinedContexts;
    }
    
    protected SpecializationBuilder or(final SpecializationBuilder firstOperand, final SpecializationBuilder secondOperand) {
        if (firstOperand instanceof SingleSpecializationBuilder && secondOperand instanceof SingleSpecializationBuilder) {
            final SingleSpecializationBuilder first = (SingleSpecializationBuilder) firstOperand;
            final SingleSpecializationBuilder second = (SingleSpecializationBuilder) secondOperand;
            if (first.hasPattern() && second.hasPattern()) {
                final List<SingleSpecializationBuilder> singleBuilders = new ArrayList<SingleSpecializationBuilder>();
                singleBuilders.add(first);
                singleBuilders.add(second);
                return new MultipleSpecializationsBuilder(singleBuilders);
            } else if (first.hasPattern() && !second.hasPattern()) {
                throw new UnsupportedOperationException("Pointcut sub-predicate must contain pattern.");
            } else if (!first.hasPattern() && second.hasPattern()) {
                throw new UnsupportedOperationException("Pointcut sub-predicate must contain pattern.");
            } else {
                final Predicate<AtomicPredicate> combinedAtomicPredicateExpression =
                                new OrPredicate<AtomicPredicate>(first.getPredicate(), second.getPredicate());
                final List<Context> combinedContexts = this.combineContexts(first, second);
                return new SingleSpecializationBuilder(null, combinedAtomicPredicateExpression, combinedContexts);
            }
        } else if (firstOperand instanceof SingleSpecializationBuilder
                        && secondOperand instanceof MultipleSpecializationsBuilder) {
            final SingleSpecializationBuilder first = (SingleSpecializationBuilder) firstOperand;
            final MultipleSpecializationsBuilder second = (MultipleSpecializationsBuilder) secondOperand;
            if (first.hasPattern()) {
                final List<SingleSpecializationBuilder> newSingleBuilders = second.getCopyOfBuilders();
                newSingleBuilders.add(0, first); // prepend
                return new MultipleSpecializationsBuilder(newSingleBuilders);
            } else {
                final List<SingleSpecializationBuilder> newSingleBuilders = new ArrayList<SingleSpecializationBuilder>();
                final Iterator<SingleSpecializationBuilder> it = second.buildersIterator();
                while (it.hasNext()) {
                    final SingleSpecializationBuilder current = it.next();
                    newSingleBuilders.add(new SingleSpecializationBuilder(current.getPattern(),
                                    new OrPredicate<AtomicPredicate>(first.getPredicate(), current.getPredicate()), this
                                                    .combineContexts(first, current))); // TODO: why not?
                }
                return new MultipleSpecializationsBuilder(newSingleBuilders);
            }
        } else if (firstOperand instanceof MultipleSpecializationsBuilder
                        && secondOperand instanceof SingleSpecializationBuilder) {
            final MultipleSpecializationsBuilder first = (MultipleSpecializationsBuilder) firstOperand;
            final SingleSpecializationBuilder second = (SingleSpecializationBuilder) secondOperand;
            if (second.hasPattern()) {
                final List<SingleSpecializationBuilder> newSingleBuilders = first.getCopyOfBuilders();
                newSingleBuilders.add(second); // append
                return new MultipleSpecializationsBuilder(newSingleBuilders);
            } else {
                final List<SingleSpecializationBuilder> newSingleBuilders = new ArrayList<SingleSpecializationBuilder>();
                final Iterator<SingleSpecializationBuilder> it = first.buildersIterator();
                while (it.hasNext()) {
                    final SingleSpecializationBuilder current = it.next();
                    newSingleBuilders.add(new SingleSpecializationBuilder(current.getPattern(),
                                    new OrPredicate<AtomicPredicate>(second.getPredicate(), current.getPredicate()), this
                                                    .combineContexts(second, current)));
                }
                return new MultipleSpecializationsBuilder(newSingleBuilders);
            }
        } else {
            final MultipleSpecializationsBuilder first = (MultipleSpecializationsBuilder) firstOperand;
            final MultipleSpecializationsBuilder second = (MultipleSpecializationsBuilder) secondOperand;
            
            final List<SingleSpecializationBuilder> newSingleBuilder = new ArrayList<SingleSpecializationBuilder>(); // size
            // will
            // grow
            // to
            // first.singleBuilders.size() +
            // second.singleBuilders.size()
            Iterator<SingleSpecializationBuilder> it = first.buildersIterator();
            while (it.hasNext()) {
                newSingleBuilder.add(it.next());
            }
            it = second.buildersIterator();
            while (it.hasNext()) {
                newSingleBuilder.add(it.next());
            }
            return new MultipleSpecializationsBuilder(newSingleBuilder);
        }
        
    }
    
    protected SpecializationBuilder not(final SpecializationBuilder operand) {
        if (operand instanceof SingleSpecializationBuilder) {
            final SingleSpecializationBuilder op = (SingleSpecializationBuilder) operand;
            if (op.hasPattern())
                throw new UnsupportedOperationException("Cannot perform ! (not) operation for pattern.");
            return new SingleSpecializationBuilder(null, op.getPredicate().negate(), op.getContexts());
        } else {
            throw new UnsupportedOperationException("Cannot perform ! (not) operation for pattern.");
        }
    }
    
}
