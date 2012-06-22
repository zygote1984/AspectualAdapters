package org.alia4j.patterns.parameters;

import org.alia4j.hierarchy.TypeDescriptor;

public class ParametersRest implements ParametersPatternElement {
    
    public static final ParametersRest INSTANCE = new ParametersRest();
    
    private ParametersRest() {}
    
    @Override
    public boolean isRest() {
        return true;
    }
    
    @Override
    public boolean isTypePattern() {
        return false;
    }
    
    @Override
    public boolean matches(final TypeDescriptor typePattern) {
        throw new UnsupportedOperationException();
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
