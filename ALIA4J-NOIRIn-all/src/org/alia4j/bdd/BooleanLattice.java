package org.alia4j.bdd;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A Boolean lattice. It supports the usual operations: meet, join, and complement.
 * 
 * @author Andreas Sewe
 * @param <M> the lattice's member type
 */
public class BooleanLattice<M> {
    
    @SuppressWarnings("unchecked")
    public static final <T> BooleanLattice<T> bottom() {
        return BooleanLattice.BOTTOM;
    }
    
    @SuppressWarnings("unchecked")
    private static final BooleanLattice BOTTOM = new BooleanLattice(false);
    
    @SuppressWarnings("unchecked")
    public static final <T> BooleanLattice<T> top() {
        return BooleanLattice.TOP;
    }
    
    @SuppressWarnings("unchecked")
    private static final BooleanLattice TOP = new BooleanLattice(true);
    
    public BooleanLattice(final boolean top) {
        this.components = Collections.emptySet();
        this.complemented = top;
    }
    
    public BooleanLattice(final M unit, final boolean complemented) {
        this.components = Collections.singleton(unit);
        this.complemented = complemented;
    }
    
    public BooleanLattice(final M unit) {
        this(unit, false);
    }
    
    public BooleanLattice(final Set<M> components, final boolean complemented) {
        this.components = components;
        this.complemented = complemented;
    }
    
    public BooleanLattice(final Set<M> components) {
        this(components, false);
    }
    
    public final BooleanLattice<M> join(final BooleanLattice<M> that) {
        final Set<M> components = new HashSet<M>();
        
        if (this.isComplemented()) {
            if (that.isComplemented()) {
                components.addAll(this.getComponents());
                components.retainAll(that.getComponents());
            } else {
                components.addAll(this.getComponents());
                components.removeAll(that.getComponents());
            }
        } else {
            if (that.isComplemented()) {
                components.addAll(that.getComponents());
                components.removeAll(this.getComponents());
            } else {
                components.addAll(this.getComponents());
                components.addAll(that.getComponents());
            }
        }
        
        return new BooleanLattice<M>(components, this.isComplemented() || that.isComplemented());
    }
    
    public final BooleanLattice<M> meet(final BooleanLattice<M> that) {
        final Set<M> components = new HashSet<M>();
        
        if (this.isComplemented()) {
            if (that.isComplemented()) {
                components.addAll(this.getComponents());
                components.addAll(that.getComponents());
            } else {
                components.addAll(that.getComponents());
                components.removeAll(this.getComponents());
            }
        } else {
            if (that.isComplemented()) {
                components.addAll(this.getComponents());
                components.removeAll(that.getComponents());
            } else {
                components.addAll(this.getComponents());
                components.retainAll(that.getComponents());
            }
        }
        
        return new BooleanLattice<M>(components, this.isComplemented() && that.isComplemented());
    }
    
    public final BooleanLattice<M> complement() {
        final Set<M> components = new HashSet<M>();
        
        components.addAll(this.getComponents());
        
        return new BooleanLattice<M>(components, !this.isComplemented());
    }
    
    public boolean isTop() {
        return this.components.isEmpty() && this.complemented;
    }
    
    public boolean isBottom() {
        return this.components.isEmpty() && !this.complemented;
    }
    
    public final Set<M> getComponents() {
        return Collections.unmodifiableSet(this.components);
    }
    
    private final Set<M> components;
    
    public final boolean isComplemented() {
        return this.complemented;
    }
    
    private final boolean complemented;
    
    @Override
    public String toString() {
        return this.isComplemented() ? "!" + this.getComponents().toString() : this.getComponents().toString();
    }
    
    @Override
    public int hashCode() {
        return this.isComplemented() ? ~this.getComponents().hashCode() : this.getComponents().hashCode();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(final Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (this.getClass() != other.getClass())
            return false;
        
        final BooleanLattice<M> that = (BooleanLattice) other;
        if (this.complemented != that.complemented)
            return false;
        if (this.components == null)
            return false;
        return this.components.equals(that.components);
    }
}
