package org.alia4j.patterns.names;

public class IdentifierElement implements NameElement {
    
    private final String identifier;
    
    public IdentifierElement(final String identifier) {
        this.identifier = identifier;
    }
    
    public String getIdentifier() {
        return this.identifier;
    }
    
    public boolean isIdentifier() {
        return true;
    }
    
    public boolean isWildcard() {
        return false;
    }
    
    @Override
    public String toString() {
        return this.identifier;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.identifier == null) ? 0 : this.identifier.hashCode());
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
        final IdentifierElement other = (IdentifierElement) obj;
        if (this.identifier == null) {
            if (other.identifier != null)
                return false;
        } else if (!this.identifier.equals(other.identifier))
            return false;
        return true;
    }
    
}
