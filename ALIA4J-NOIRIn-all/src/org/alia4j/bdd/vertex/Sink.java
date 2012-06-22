package org.alia4j.bdd.vertex;

import org.alia4j.bdd.BooleanLattice;

/**
 * @author Andreas Sewe
 * @param <X> the variables' type
 * @param <Y> the values' type
 */
public class Sink<X, Y> extends Vertex<X, Y> {
    
    Sink(final BooleanLattice<Y> value) {
        this.value = value;
    }
    
    public BooleanLattice<Y> getValue() {
        return this.value;
    }
    
    private final BooleanLattice<Y> value;
    
    @Override
    public <W> W accept(final UnaryOperation<X, Y, W> op) {
        return op.visit(this);
    }
    
    @Override
    public <W> W acceptLeft(final BinaryOperation<X, Y, W> op, final Vertex<X, Y> right) {
        return op.visit(this, right);
    }
    
    @Override
    public <W> W acceptRight(final BinaryOperation<X, Y, W> op, final Sink<X, Y> left) {
        return op.visit(left, this);
    }
    
    @Override
    public <W> W acceptRight(final BinaryOperation<X, Y, W> op, final Split<X, Y> left) {
        return op.visit(left, this);
    }
    
    @Override
    public int hashCode() {
        return this.getValue().hashCode();
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
        
        final Sink<X, Y> that = (Sink) other;
        
        return this.getValue().equals(that.getValue());
    }
}
