package org.alia4j.bdd.vertex;

/**
 * @author Andreas Sewe
 * @param <X> the variables' type
 * @param <Y> the values' type
 */
public class Split<X, Y> extends Vertex<X, Y> {
    
    Split(final X variable, final Vertex<X, Y> low, final Vertex<X, Y> high) {
        this.variable = variable;
        this.low = low;
        this.high = high;
    }
    
    public X getVariable() {
        return this.variable;
    }
    
    private final X variable;
    
    public Vertex<X, Y> getLow() {
        return this.low;
    }
    
    private final Vertex<X, Y> low;
    
    public Vertex<X, Y> getHigh() {
        return this.high;
    }
    
    private final Vertex<X, Y> high;
    
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
        int hashCode = this.getVariable().hashCode();
        
        hashCode ^= System.identityHashCode(this.getLow());
        hashCode ^= System.identityHashCode(this.getHigh());
        
        return hashCode;
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
        
        final Split<X, Y> that = (Split) other;
        
        if (!this.getVariable().equals(that.getVariable()))
            return false;
        if (this.getLow() != that.getLow())
            return false;
        if (this.getHigh() != that.getHigh())
            return false;
        
        return true;
    }
}
