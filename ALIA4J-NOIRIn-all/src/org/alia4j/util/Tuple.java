package org.alia4j.util;

import java.util.Arrays;

public class Tuple<T> {
    
    private final T[] elements;
    
    public Tuple(final T... elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }
    
    public int size() {
        return this.elements.length;
    }
    
    public T get(final int index) {
        return this.elements[index];
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(this.elements);
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        final Tuple<?> other = (Tuple<?>) obj;
        if (!Arrays.equals(this.elements, other.elements))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append('[');
        if (this.elements.length > 0)
            result.append(this.elements[0]);
        for (int i = 1; i < this.elements.length; i++)
            result.append(", ").append(this.elements[i]);
        result.append(']');
        return result.toString();
    }
}
