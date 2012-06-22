package org.alia4j.patterns.names;

public interface NameElement {
    
    public boolean isWildcard();
    
    public boolean isIdentifier();
    
    public String getIdentifier();
}
