package org.alia4j.bdd.vertex;

/**
 * A binary operation from (<code>Vertex&lt;X, Y&gt;</code>, <code>Vertex&lt;X, Y&gt;</code>) to <code>W</code>. This
 * operation employs the Visitor pattern.
 * 
 * @author Andreas Sewe
 * @param <X> the variable type
 * @param <Y> the value type
 * @param <W> the operation's result type
 */
public abstract class BinaryOperation<X, Y, W> {
    
    public W apply(final Vertex<X, Y> left, final Vertex<X, Y> right) {
        return left.acceptLeft(this, right); // by default, simply dispatch on left vertex
    }
    
    public W visit(final Sink<X, Y> left, final Vertex<X, Y> right) {
        return right.acceptRight(this, left); // by default, simply dispatch on right vertex
    }
    
    public W visit(final Split<X, Y> left, final Vertex<X, Y> right) {
        return right.acceptRight(this, left); // by default, simply dispatch on right vertex
    }
    
    public abstract W visit(Sink<X, Y> left, Sink<X, Y> right);
    
    public abstract W visit(Sink<X, Y> left, Split<X, Y> right);
    
    public abstract W visit(Split<X, Y> left, Sink<X, Y> right);
    
    public abstract W visit(Split<X, Y> left, Split<X, Y> right);
}
