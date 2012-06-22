package org.alia4j.patterns.names;

public class IdentifierWildcard implements NameElement {
    
    public static IdentifierWildcard INSTANCE = new IdentifierWildcard();
    
    private IdentifierWildcard() {}
    
    public String getIdentifier() {
        throw new UnsupportedOperationException();
    }
    
    public boolean isIdentifier() {
        return false;
    }
    
    public boolean isWildcard() {
        return true;
    }
    
    @Override
    public String toString() {
        return "*";
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }
}
