package org.alia4j.bdd.synthesis;

import org.alia4j.bdd.vertex.CachingUnaryOperation;
import org.alia4j.bdd.vertex.Sink;
import org.alia4j.bdd.vertex.Split;
import org.alia4j.bdd.vertex.UniqueTable;
import org.alia4j.bdd.vertex.Vertex;

public final class ReplacementByConstant<X, Y> extends CachingUnaryOperation<X, Y, Vertex<X, Y>> {
    
    public ReplacementByConstant(final X variable, final boolean constant, final UniqueTable<X, Y> pool) {
        this.variable = variable;
        this.constant = constant;
        this.pool = pool;
    }
    
    private final X variable;
    
    private final boolean constant;
    
    private final UniqueTable<X, Y> pool;
    
    @Override
    public Vertex<X, Y> visit(final Split<X, Y> split) {
        if (split.getVariable().equals(this.variable)) {
            return this.constant == false ? this.apply(split.getLow()) : this.apply(split.getHigh());
        } else {
            final Vertex<X, Y> low = this.apply(split.getLow());
            final Vertex<X, Y> high = this.apply(split.getHigh());
            return this.pool.createSplit(split.getVariable(), low, high);
        }
    }
    
    @Override
    public Vertex<X, Y> visit(final Sink<X, Y> sink) {
        return this.pool.createSink(sink.getValue());
    }
}
