package org.alia4j.liam;

/**
 * @author Andreas Sewe
 */
public final class BasicPredicate<X> extends Predicate<X> {
    
    public BasicPredicate(final X atomicPredicate, final boolean positive) {
        if (atomicPredicate == null)
            throw new IllegalArgumentException();
        this.atomicPredicate = atomicPredicate;
        this.positive = positive;
    }
    
    public X getAtomicPredicate() {
        return this.atomicPredicate;
    }
    
    private final X atomicPredicate;
    
    public boolean isPositive() {
        return this.positive;
    }
    
    public boolean isNegative() {
        return !this.positive;
    }
    
    private final boolean positive;
    
    @Override
    public Predicate<X> negate() {
        return new BasicPredicate<X>(this.getAtomicPredicate(), this.isNegative());
    }
    
    @Override
    public <T> T accept(final PredicateProcessor<T, X> processor) {
        return processor.process(this);
    }
    
    @Override
    public String toString() {
        return (this.isPositive() ? "" : "!") + this.getAtomicPredicate().toString();
    }
    
    @Override
    public boolean equals(final Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (this.getClass() != other.getClass())
            return false;
        
        final BasicPredicate<?> that = (BasicPredicate<?>) other;
        return this.positive == that.positive && this.atomicPredicate.equals(that.atomicPredicate);
    }
    
    @Override
    public int hashCode() {
        return this.positive ? this.atomicPredicate.hashCode() : -this.atomicPredicate.hashCode();
    }
}
