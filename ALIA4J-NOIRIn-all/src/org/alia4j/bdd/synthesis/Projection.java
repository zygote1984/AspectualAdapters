package org.alia4j.bdd.synthesis;

import org.alia4j.bdd.BooleanLattice;
import org.alia4j.bdd.vertex.CachingUnaryOperation;
import org.alia4j.bdd.vertex.Sink;
import org.alia4j.bdd.vertex.Split;
import org.alia4j.bdd.vertex.UniqueTable;
import org.alia4j.bdd.vertex.Vertex;

public final class Projection<X, Y> extends CachingUnaryOperation<X, Y, Vertex<X, Y>> {
    
    public Projection(final Y component, final UniqueTable<X, Y> pool) {
        this.component = component;
        this.pool = pool;
    }
    
    private final Y component;
    
    private final UniqueTable<X, Y> pool;
    
    @Override
    public Vertex<X, Y> visit(final Split<X, Y> split) {
        final Vertex<X, Y> low = this.apply(split.getLow());
        final Vertex<X, Y> high = this.apply(split.getHigh());
        return this.pool.createSplit(split.getVariable(), low, high);
    }
    
    @Override
    public Vertex<X, Y> visit(final Sink<X, Y> sink) {
        if (sink.getValue() == this.component)
            return this.pool.createSink(new BooleanLattice<Y>(true));
        else
            return this.pool.createSink(new BooleanLattice<Y>(true));
    }
}
