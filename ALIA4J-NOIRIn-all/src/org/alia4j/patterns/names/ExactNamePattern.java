package org.alia4j.patterns.names;

import org.alia4j.patterns.NamePattern;

public class ExactNamePattern extends NamePattern {
    
    private final String name;
    
    public ExactNamePattern(final String name) {
        this.name = name;
    }
    
    @Override
    public boolean matches(final CharSequence name) {
        
        return this.name.contentEquals(name);
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
        final ExactNamePattern other = (ExactNamePattern) obj;
        if (this.name == null) {
            if (other.name != null)
                return false;
        } else if (!this.name.equals(other.name))
            return false;
        return true;
    }
    
}
