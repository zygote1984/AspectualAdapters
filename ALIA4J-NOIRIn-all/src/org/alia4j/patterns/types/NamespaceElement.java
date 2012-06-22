package org.alia4j.patterns.types;

public interface NamespaceElement {
    
    public boolean isRest();
    
    public boolean isNamePattern();
    
    public boolean matches(CharSequence target);
}
