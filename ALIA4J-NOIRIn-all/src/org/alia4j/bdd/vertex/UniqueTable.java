package org.alia4j.bdd.vertex;

import java.util.HashMap;
import org.alia4j.bdd.BooleanLattice;

/**
 * @author Andreas Sewe
 */
public class UniqueTable<X, Y> {
    
    public Split<X, Y> createSplit(final X variable, final Vertex<X, Y> low, final Vertex<X, Y> high) {
        final Split<X, Y> key = new Split<X, Y>(variable, low, high);
        
        Split<X, Y> split;
        if ((split = this.splits.get(key)) == null) {
            this.splits.put(key, split = key);
        }
        
        return split;
    }
    
    private final HashMap<Split<X, Y>, Split<X, Y>> splits = new HashMap<Split<X, Y>, Split<X, Y>>();
    
    public Sink<X, Y> createSink(final BooleanLattice<Y> value) {
        final Sink<X, Y> key = new Sink<X, Y>(value);
        
        Sink<X, Y> sink;
        if ((sink = this.sinks.get(key)) == null) {
            this.sinks.put(key, sink = key);
        }
        
        return sink;
    }
    
    private final HashMap<Sink<X, Y>, Sink<X, Y>> sinks = new HashMap<Sink<X, Y>, Sink<X, Y>>();
}
