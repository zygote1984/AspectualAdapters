package org.alia4j.util;

public final class MaybeUtilities {
    
    private MaybeUtilities() {}
    
    /**
     * Returns a java.lang.Number object representing the passed argument's value. This is either the value itself or, if it
     * is Character object, an Integer object that represents the same value. This is the same as if Java coerces a char
     * value to an int as in <code>int i = (int) 'c';</code>. It is assumed that the value is not unknown and that it is
     * either a subtype of Number or Character.
     * 
     * @param maybe
     * @return
     */
    public static final Number numberForValue(final Maybe<?> maybe) {
        assert !maybe.isUnknown();
        if (Character.class == maybe.getValue().getClass())
            return Integer.valueOf(((Character) maybe.getValue()).charValue());
        else {
            assert maybe.getValue() instanceof Number;
            return (Number) maybe.getValue();
        }
        
    }
    
}
