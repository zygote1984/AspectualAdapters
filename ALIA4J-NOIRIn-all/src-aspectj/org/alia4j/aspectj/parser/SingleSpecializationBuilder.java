package org.alia4j.aspectj.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.Predicate;
import org.alia4j.liam.Specialization;
import org.alia4j.liam.pattern.Pattern;

class SingleSpecializationBuilder extends SpecializationBuilder {
    
    private Predicate<AtomicPredicate> predicate;
    
    private Pattern<?> pattern;
    
    private final List<Context> contexts;
    
    protected SingleSpecializationBuilder(final int numberOfAdviceArguments, final Context aspectInstanceContext) {
        this.contexts = new ArrayList<Context>(numberOfAdviceArguments + 1);
        this.contexts.add(aspectInstanceContext);
        for (int i = 0; i < numberOfAdviceArguments; i++)
            this.contexts.add(null);
    }
    
    protected SingleSpecializationBuilder(final int numberOfAdviceArguments, final Pattern<?> pattern,
                    final Predicate<AtomicPredicate> predicate, final Context aspectInstanceContext) {
        this(numberOfAdviceArguments, aspectInstanceContext);
        this.pattern = pattern;
        this.predicate = predicate;
    }
    
    /**
     * @param pattern
     * @param predicate
     * @param contexts the list of contexts must also contain the aspect-instance context.
     */
    protected SingleSpecializationBuilder(final Pattern<?> pattern, final Predicate<AtomicPredicate> predicate,
                    final List<Context> contexts) {
        this.pattern = pattern;
        this.predicate = predicate;
        this.contexts = contexts;
    }
    
    @Override
    protected Set<Specialization> getSpecializations() {
        final Specialization v = new Specialization(this.getPattern(), this.getPredicate(), this.getContexts());
        return Collections.singleton(v);
    }
    
    @Override
    protected void setContext(final int index, final Context context) {
        // the index refers to the position of the advice parameter. The first
        // Context in the list is the aspect instance. Therefore the position
        // in the list is the parameter position + 1
        this.contexts.set(index + 1, context);
    }
    
    protected boolean hasPattern() {
        return this.getPattern() != null;
    }
    
    public Predicate<AtomicPredicate> getPredicate() {
        return this.predicate;
    }
    
    public Pattern<?> getPattern() {
        return this.pattern;
    }
    
    public List<Context> getContexts() {
        return this.contexts;
    }
}
