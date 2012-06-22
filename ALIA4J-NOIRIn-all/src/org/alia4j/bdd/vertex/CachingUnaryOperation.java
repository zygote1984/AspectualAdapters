package org.alia4j.bdd.vertex;

import java.util.HashMap;

/**
 * A caching unary operation from <code>Vertex&lt;X, Y&gt;</code> to <code>W</code>. This operation employs memoization in
 * conjunction with the Visitor pattern.
 * 
 * @author Andreas Sewe
 * @param <X> the variable type
 * @param <Y> the value type
 * @param <W> the operation's result type
 */
public abstract class CachingUnaryOperation<X, Y, W> extends UnaryOperation<X, Y, W> {
    
    @Override
    public W apply(final Vertex<X, Y> vertex) {
        final W result;
        
        if (!this.cache.containsKey(vertex)) {
            result = super.apply(vertex);
            this.cache.put(vertex, result);
        } else {
            result = this.cache.get(vertex);
        }
        
        return result;
    }
    
    private final HashMap<Vertex<X, Y>, W> cache = new HashMap<Vertex<X, Y>, W>();
}
