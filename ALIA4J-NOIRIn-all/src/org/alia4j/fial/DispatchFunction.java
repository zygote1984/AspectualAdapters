package org.alia4j.fial;

import org.alia4j.bdd.vertex.Vertex;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Predicate;

/**
 * @author Andreas Sewe
 */
public abstract class DispatchFunction {
    
    public abstract void add(AttachedAction action, Predicate<AtomicPredicate> expression);
    
    public abstract void remove(AttachedAction action);
    
    public abstract Vertex<AtomicPredicate, AttachedAction> getDispatchStrategy();
}
