package org.alia4j.patterns.parameters;

import org.alia4j.hierarchy.TypeDescriptor;

public interface ParametersPatternElement {
    
    public boolean isRest();
    
    public boolean isTypePattern();
    
    public boolean matches(TypeDescriptor typePattern);
}
