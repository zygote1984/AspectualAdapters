package org.alia4j.liam;

/**
 * @author Andreas Sewe
 */
public final class OrPredicate<X> extends Predicate<X> {
    
    public OrPredicate(final Predicate<X> lhs, final Predicate<X> rhs) {
        if (lhs == null || rhs == null)
            throw new IllegalArgumentException();
        this.lhs = lhs;
        this.rhs = rhs;
    }
    
    public Predicate<X> getLeftHandSide() {
        return this.lhs;
    }
    
    private final Predicate<X> lhs;
    
    public Predicate<X> getRightHandSide() {
        return this.rhs;
    }
    
    private final Predicate<X> rhs;
    
    @Override
    public Predicate<X> negate() {
        return new AndPredicate<X>(this.getLeftHandSide().negate(), this.getRightHandSide().negate());
    }
    
    @Override
    public <T> T accept(final PredicateProcessor<T, X> processor) {
        return processor.process(this);
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        
        builder.append('(');
        builder.append(this.getLeftHandSide());
        builder.append(" || ");
        builder.append(this.getRightHandSide());
        builder.append(')');
        
        return builder.toString();
    }
    
    @Override
    public boolean equals(final Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (this.getClass() != other.getClass())
            return false;
        
        final OrPredicate<?> that = (OrPredicate<?>) other;
        return this.lhs.equals(that.lhs) && this.rhs.equals(that.rhs);
    }
    
    @Override
    public int hashCode() {
        return this.lhs.hashCode() ^ this.rhs.hashCode();
    }
}
