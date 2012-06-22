package org.alia4j.patterns.types;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.patterns.TypePattern;

public class ExactTypePattern extends TypePattern {
    
    private final TypeDescriptor typeDescriptor;
    
    public ExactTypePattern(final TypeDescriptor typeDescriptor) {
        this.typeDescriptor = typeDescriptor;
    }
    
    @Override
    public boolean matches(final TypeDescriptor typeDescriptor) {
        return this.typeDescriptor.equals(typeDescriptor);
    }
    
    @Override
    public String toString() {
        return this.typeDescriptor.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.typeDescriptor == null) ? 0 : this.typeDescriptor.hashCode());
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
        final ExactTypePattern other = (ExactTypePattern) obj;
        if (this.typeDescriptor == null) {
            if (other.typeDescriptor != null)
                return false;
        } else if (!this.typeDescriptor.equals(other.typeDescriptor))
            return false;
        return true;
    }
    
}
