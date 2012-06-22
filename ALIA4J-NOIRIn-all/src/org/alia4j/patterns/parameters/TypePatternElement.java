package org.alia4j.patterns.parameters;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.patterns.TypePattern;

public class TypePatternElement implements ParametersPatternElement {
    
    private final TypePattern pattern;
    
    public TypePatternElement(final TypePattern pattern) {
        this.pattern = pattern;
    }
    
    public boolean isRest() {
        return false;
    }
    
    public boolean isTypePattern() {
        return true;
    }
    
    public boolean matches(final TypeDescriptor typeName) {
        return this.pattern.matches(typeName);
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
        final TypePatternElement other = (TypePatternElement) obj;
        if (this.pattern == null) {
            if (other.pattern != null)
                return false;
        } else if (!this.pattern.equals(other.pattern))
            return false;
        return true;
    }
    
}
