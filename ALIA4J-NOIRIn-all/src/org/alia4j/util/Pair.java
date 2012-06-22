package org.alia4j.util;

/**
 * An immutable pair or tuple.
 * 
 * @author Andreas Sewe
 * @param <L> the type of the left (or first) element
 * @param <R> the type of the right (or second) element
 */
public final class Pair<L, R> {
    
    /**
     * Constructs a new <code>Pair</code>.
     * 
     * @param left the left (or first) element of the <code>Pair</code>
     * @param right the right (or second) element of the <code>Pair</code>
     */
    public Pair(final L left, final R right) {
        this.left = left;
        this.right = right;
    }
    
    private final L left;
    
    private final R right;
    
    /**
     * @return the left (or first) element of this <code>Pair</code>
     */
    public final L getLeft() {
        return this.left;
    }
    
    /**
     * @return the right (or second) element of this <code>Pair</code>
     */
    public final R getRight() {
        return this.right;
    }
    
    @Override
    public final boolean equals(final Object other) {
        if (!(other instanceof Pair<?, ?>))
            return false;
        
        final Pair<?, ?> that = (Pair<?, ?>) other;
        
        return (this.getLeft() == null ? that.getLeft() == null : this.getLeft().equals(that.getLeft()))
                        && (this.getRight() == null ? that.getRight() == null : this.getRight().equals(that.getRight()));
    }
    
    @Override
    public final int hashCode() {
        final int leftCode = (this.getLeft() == null) ? 0 : this.getLeft().hashCode();
        final int rightCode = (this.getRight() == null) ? 0 : this.getRight().hashCode();
        
        return leftCode ^ rightCode;
    }
    
    @Override
    public final String toString() {
        return "(" + this.left + ", " + this.right + ")";
    }
}
