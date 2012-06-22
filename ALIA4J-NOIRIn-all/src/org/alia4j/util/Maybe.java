package org.alia4j.util;

/**
 * @author Andreas Sewe
 */
public final class Maybe<T> {
    
    public Maybe() {
        this.unknown = true;
    }
    
    public Maybe(final T value) {
        this.value = value;
        this.unknown = false;
    }
    
    public T getValue() {
        if (this.isUnknown())
            throw new IllegalStateException();
        return this.value;
    }
    
    private T value;
    
    public boolean isUnknown() {
        return this.unknown;
    }
    
    private final boolean unknown;
    
    public static Maybe<Boolean> fromBoolean(final boolean value) {
        return value ? Maybe.TRUE : Maybe.FALSE;
    }
    
    public static Maybe<Boolean> unknownBoolean() {
        return Maybe.NIL;
    }
    
    private static final Maybe<Boolean> TRUE = new Maybe<Boolean>(true);
    
    private static final Maybe<Boolean> FALSE = new Maybe<Boolean>(false);
    
    private static final Maybe<Boolean> NIL = new Maybe<Boolean>();
}
