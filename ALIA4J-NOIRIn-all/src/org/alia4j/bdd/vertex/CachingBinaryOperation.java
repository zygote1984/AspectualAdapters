package org.alia4j.bdd.vertex;

import org.alia4j.util.PairHashMap;

/**
 * A caching binary operation from (<code>Vertex&lt;X, Y&gt;</code>, <code>Vertex&lt;X, Y&gt;</code>) to <code>W</code>. This
 * operation employs memoization in conjunction with the Visitor pattern.
 * 
 * @author Andreas Sewe
 * @param <X> the variable type
 * @param <Y> the value type
 * @param <W> the operation's result type
 */
public abstract class CachingBinaryOperation<X, Y, W> extends BinaryOperation<X, Y, W> {
    
    @Override
    public W apply(final Vertex<X, Y> left, final Vertex<X, Y> right) {
        final W result;
        
        if (!this.cache.containsKeys(left, right)) {
            result = super.apply(left, right);
            this.cache.put(left, right, result);
        } else {
            result = this.cache.get(left, right);
        }
        
        return result;
    }
    
    private final PairHashMap<Vertex<X, Y>, Vertex<X, Y>, W> cache = new PairHashMap<Vertex<X, Y>, Vertex<X, Y>, W>();
}
