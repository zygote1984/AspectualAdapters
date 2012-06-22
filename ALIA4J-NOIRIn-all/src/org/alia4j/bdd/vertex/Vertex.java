package org.alia4j.bdd.vertex;

/**
 * @author Andreas Sewe
 * @param <X> the variables' type
 * @param <Y> the values' type
 */
public abstract class Vertex<X, Y> {
    
    public abstract <W> W accept(UnaryOperation<X, Y, W> unaryOperation);
    
    public abstract <W> W acceptLeft(BinaryOperation<X, Y, W> operation, Vertex<X, Y> right);
    
    public abstract <W> W acceptRight(BinaryOperation<X, Y, W> operation, Sink<X, Y> left);
    
    public abstract <W> W acceptRight(BinaryOperation<X, Y, W> operation, Split<X, Y> left);
}
