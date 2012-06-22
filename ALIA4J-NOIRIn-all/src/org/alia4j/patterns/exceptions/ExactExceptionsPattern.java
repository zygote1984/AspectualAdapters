package org.alia4j.patterns.exceptions;

import java.util.Arrays;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.patterns.ExceptionsPattern;

public class ExactExceptionsPattern extends ExceptionsPattern {
    
    private final TypeDescriptor[] typeDescriptors;
    
    public ExactExceptionsPattern(final TypeDescriptor[] typeDescriptors) {
        this.typeDescriptors = typeDescriptors;
        
    }
    
    @Override
    public boolean matches(final TypeDescriptor[] typeDescriptors) {
        if (typeDescriptors.length != this.typeDescriptors.length)
            return false;
        
        for (int i = 0; i < typeDescriptors.length; i++) {
            if (!typeDescriptors[i].equals(this.typeDescriptors[i]))
                return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(this.typeDescriptors);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(this.typeDescriptors);
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
        final ExactExceptionsPattern other = (ExactExceptionsPattern) obj;
        if (!Arrays.equals(this.typeDescriptors, other.typeDescriptors))
            return false;
        return true;
    }
    
}
