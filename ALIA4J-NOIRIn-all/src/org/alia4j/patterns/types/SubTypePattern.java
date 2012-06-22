package org.alia4j.patterns.types;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.patterns.ClassTypePattern;

public class SubTypePattern extends ClassTypePattern {
    
    private final ClassTypePattern baseTypePattern;
    
    private final boolean includeSubtypes;
    
    public SubTypePattern(final ClassTypePattern baseTypePattern) {
        this.baseTypePattern = baseTypePattern;
        this.includeSubtypes = true;
    }
    
    public SubTypePattern(final ClassTypePattern baseTypePattern, final boolean includeSubtypes) {
        this.baseTypePattern = baseTypePattern;
        this.includeSubtypes = includeSubtypes;
    }
    
    @Override
    public boolean matches(final TypeDescriptor typeDescriptor) {
        if (this.baseTypePattern.matches(typeDescriptor))
            return true;
        if (!this.includeSubtypes)
            return false;
        final TypeDescriptor[] superClassnames = TypeHierarchyProvider.getSuperTypes(typeDescriptor);
        for (final TypeDescriptor element : superClassnames) {
            if (this.baseTypePattern.matches(element))
                return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append(this.baseTypePattern.toString());
        if (this.includeSubtypes)
            result.append('+');
        return result.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.baseTypePattern == null) ? 0 : this.baseTypePattern.hashCode());
        result = prime * result + (this.includeSubtypes ? 1231 : 1237);
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
        final SubTypePattern other = (SubTypePattern) obj;
        if (this.baseTypePattern == null) {
            if (other.baseTypePattern != null)
                return false;
        } else if (!this.baseTypePattern.equals(other.baseTypePattern))
            return false;
        if (this.includeSubtypes != other.includeSubtypes)
            return false;
        return true;
    }
    
}
