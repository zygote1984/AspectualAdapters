package org.alia4j.patterns.exceptions;

import org.alia4j.patterns.TypePattern;

public interface ExceptionsPatternElement {
    
    boolean isPositive();
    
    boolean isNegative();
    
    TypePattern getTypePattern();
}
