package org.alia4j.patterns.types;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.patterns.TypePattern;

public class ArrayTypePattern extends TypePattern {
    
    private final TypePattern baseTypePattern;
    
    private final int dimension;
    
    public ArrayTypePattern(final TypePattern baseTypePattern, final int dimension) {
        if (dimension <= 0)
            throw new IllegalArgumentException("An array type must have a dimension > 0");
        
        this.baseTypePattern = baseTypePattern;
        this.dimension = dimension;
    }
    
    @Override
    public boolean matches(final TypeDescriptor typeDescriptor) {
        if (typeDescriptor.getDimensionality() != this.dimension)
            return false;
        
        return this.baseTypePattern.matches(typeDescriptor.getInnermostElementType());
    }
    
    private String cachedString;
    
    @Override
    public String toString() {
        if (this.cachedString == null) {
            final StringBuilder result = new StringBuilder();
            result.append(this.baseTypePattern.toString());
            for (int i = 0; i < this.dimension; i++)
                result.append("[]");
            this.cachedString = result.toString();
        }
        return this.cachedString;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.baseTypePattern == null) ? 0 : this.baseTypePattern.hashCode());
        result = prime * result + ((this.cachedString == null) ? 0 : this.cachedString.hashCode());
        result = prime * result + this.dimension;
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
        final ArrayTypePattern other = (ArrayTypePattern) obj;
        if (this.baseTypePattern == null) {
            if (other.baseTypePattern != null)
                return false;
        } else if (!this.baseTypePattern.equals(other.baseTypePattern))
            return false;
        if (this.cachedString == null) {
            if (other.cachedString != null)
                return false;
        } else if (!this.cachedString.equals(other.cachedString))
            return false;
        if (this.dimension != other.dimension)
            return false;
        return true;
    }
    
}
