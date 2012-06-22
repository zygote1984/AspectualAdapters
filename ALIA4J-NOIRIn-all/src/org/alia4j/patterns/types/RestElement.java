package org.alia4j.patterns.types;

public class RestElement implements NamespaceElement {
    
    public static final RestElement INSTANCE = new RestElement();
    
    private RestElement() {}
    
    public boolean isNamePattern() {
        return false;
    }
    
    public boolean isRest() {
        return true;
    }
    
    public boolean matches(final CharSequence name) {
        throw new UnsupportedOperationException();
    }
    
    public boolean isTypePattern() {
        return false;
    }
    
    @Override
    public String toString() {
        return "..";
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
