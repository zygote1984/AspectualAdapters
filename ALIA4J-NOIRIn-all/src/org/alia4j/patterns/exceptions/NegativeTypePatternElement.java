package org.alia4j.patterns.exceptions;

import org.alia4j.patterns.TypePattern;

public class NegativeTypePatternElement implements ExceptionsPatternElement {
    
    private final TypePattern pattern;
    
    public NegativeTypePatternElement(final TypePattern pattern) {
        this.pattern = pattern;
    }
    
    public boolean isNegative() {
        return true;
    }
    
    public boolean isPositive() {
        return false;
    }
    
    public TypePattern getTypePattern() {
        return this.pattern;
    }
    
    @Override
    public String toString() {
        return this.pattern.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.pattern == null) ? 0 : this.pattern.hashCode());
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
        final NegativeTypePatternElement other = (NegativeTypePatternElement) obj;
        if (this.pattern == null) {
            if (other.pattern != null)
                return false;
        } else if (!this.pattern.equals(other.pattern))
            return false;
        return true;
    }
    
}
