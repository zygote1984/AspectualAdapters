package org.alia4j.patterns.types;

import org.alia4j.patterns.NamePattern;

public class NamePatternElement implements NamespaceElement {
    
    private final NamePattern pattern;
    
    public NamePatternElement(final NamePattern pattern) {
        this.pattern = pattern;
    }
    
    public boolean isNamePattern() {
        return true;
    }
    
    public boolean isRest() {
        return false;
    }
    
    public boolean matches(final CharSequence name) {
        return this.pattern.matches(name);
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
        final NamePatternElement other = (NamePatternElement) obj;
        if (this.pattern == null) {
            if (other.pattern != null)
                return false;
        } else if (!this.pattern.equals(other.pattern))
            return false;
        return true;
    }
    
}
