package org.alia4j.bdd.vertex;

/**
 * A unary operation from <code>Vertex&lt;X, Y&gt;</code> to <code>W</code>. This operation employs the Visitor pattern.
 * 
 * @author Andreas Sewe
 * @param <X> the variable type
 * @param <Y> the value type
 * @param <W> the operation's result type
 */
public abstract class UnaryOperation<X, Y, W> {
    
    public W apply(final Vertex<X, Y> vertex) {
        return vertex.accept(this); // by default, simply dispatch on vertex
    }
    
    public abstract W visit(Split<X, Y> split);
    
    public abstract W visit(Sink<X, Y> sink);
}
