package org.alia4j.bdd.synthesis;

import java.util.Comparator;
import org.alia4j.bdd.BooleanLattice;
import org.alia4j.bdd.vertex.CachingBinaryOperation;
import org.alia4j.bdd.vertex.Sink;
import org.alia4j.bdd.vertex.Split;
import org.alia4j.bdd.vertex.UniqueTable;
import org.alia4j.bdd.vertex.Vertex;

public final class Conjunction<X, Y> extends CachingBinaryOperation<X, Y, Vertex<X, Y>> {
    
    public Conjunction(final Comparator<X> order, final UniqueTable<X, Y> pool) {
        this.order = order;
        this.pool = pool;
    }
    
    private final Comparator<X> order;
    
    private final UniqueTable<X, Y> pool;
    
    @Override
    public Vertex<X, Y> visit(final Sink<X, Y> left, final Vertex<X, Y> right) {
        // Short-circuit, if left is bottom sink
        if (left.getValue().isBottom())
            return this.pool.createSink(new BooleanLattice<Y>(false));
        
        return right.acceptRight(this, left);
    }
    
    @Override
    public Vertex<X, Y> visit(final Sink<X, Y> left, final Sink<X, Y> right) {
        return this.pool.createSink(left.getValue().meet(right.getValue()));
    }
    
    @Override
    public Vertex<X, Y> visit(final Sink<X, Y> left, final Split<X, Y> right) {
        final Vertex<X, Y> low = this.apply(left, right.getLow());
        final Vertex<X, Y> high = this.apply(left, right.getHigh());
        
        if (low == high)
            return low;
        else
            return this.pool.createSplit(right.getVariable(), low, high);
    }
    
    @Override
    public Vertex<X, Y> visit(final Split<X, Y> left, final Sink<X, Y> right) {
        // Short-circuit, if right is bottom sink
        if (right.getValue().isBottom())
            return this.pool.createSink(new BooleanLattice<Y>(false));
        
        final Vertex<X, Y> low = this.apply(left.getLow(), right);
        final Vertex<X, Y> high = this.apply(left.getHigh(), right);
        
        if (low == high)
            return low;
        else
            return this.pool.createSplit(left.getVariable(), low, high);
    }
    
    @Override
    public Vertex<X, Y> visit(final Split<X, Y> left, final Split<X, Y> right) {
        final X variable;
        final Vertex<X, Y> low, high;
        
        final int comparison = this.order.compare(left.getVariable(), right.getVariable());
        
        if (comparison < 0) {
            variable = left.getVariable();
            low = this.apply(left.getLow(), right);
            high = this.apply(left.getHigh(), right);
        } else if (comparison > 0) {
            variable = right.getVariable();
            low = this.apply(left, right.getLow());
            high = this.apply(left, right.getHigh());
        } else {
            variable = left.getVariable();
            low = this.apply(left.getLow(), right.getLow());
            high = this.apply(left.getHigh(), right.getHigh());
        }
        
        if (low == high)
            return low;
        else
            return this.pool.createSplit(variable, low, high);
    }
}
