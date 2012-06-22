package org.alia4j.liam.pattern;

import org.alia4j.liam.signature.MethodSignature;
import org.alia4j.patterns.ClassTypePattern;
import org.alia4j.patterns.ExceptionsPattern;
import org.alia4j.patterns.ModifiersPattern;
import org.alia4j.patterns.NamePattern;
import org.alia4j.patterns.ParametersPattern;
import org.alia4j.patterns.TypePattern;

public class MethodPattern extends Pattern<MethodSignature> {
    
    public static final MethodPattern ANY =
                    new MethodPattern(ModifiersPattern.ANY, TypePattern.ANY, ClassTypePattern.ANY, NamePattern.ANY,
                                    ParametersPattern.ANY, ExceptionsPattern.ANY);
    
    private final ModifiersPattern modifiersPattern;
    
    private final TypePattern returnTypePattern;
    
    private final ClassTypePattern declaringClassPattern;
    
    private final NamePattern namePattern;
    
    private final ParametersPattern parametersPattern;
    
    private final ExceptionsPattern exceptionsPattern;
    
    public MethodPattern(final ModifiersPattern modifiersPattern, final TypePattern returnTypePattern,
                    final ClassTypePattern declaringClassPattern, final NamePattern namePattern,
                    final ParametersPattern parametersPattern, final ExceptionsPattern exceptionsPattern) {
        super();
        this.modifiersPattern = modifiersPattern;
        this.returnTypePattern = returnTypePattern;
        this.declaringClassPattern = declaringClassPattern;
        this.namePattern = namePattern;
        this.parametersPattern = parametersPattern;
        this.exceptionsPattern = exceptionsPattern;
    }
    
    public ClassTypePattern getDeclaringClassPattern() {
        return this.declaringClassPattern;
    }
    
    public ModifiersPattern getModifiersPattern() {
        return this.modifiersPattern;
    }
    
    public NamePattern getNamePattern() {
        return this.namePattern;
    }
    
    public ParametersPattern getParametersPattern() {
        return this.parametersPattern;
    }
    
    public TypePattern getReturnTypePattern() {
        return this.returnTypePattern;
    }
    
    public ExceptionsPattern getExceptionsPattern() {
        return this.exceptionsPattern;
    }
    
    @Override
    public boolean match(final MethodSignature signature) {
        return this.modifiersPattern.matches(signature.getModifiers())
                        && this.returnTypePattern.matches(signature.getReturnType())
                        && this.declaringClassPattern.matches(signature.getDeclaringClass())
                        && this.namePattern.matches(signature.getName())
                        && this.parametersPattern.matches(signature.getParameterTypes())
                        && this.exceptionsPattern.matches(signature.getExceptionTypes());
    }
    
    @Override
    public String toString() {
        return this.modifiersPattern + " " + this.returnTypePattern + " " + this.declaringClassPattern + "."
                        + this.namePattern + "(" + this.parametersPattern + ") throws " + this.exceptionsPattern;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.declaringClassPattern == null) ? 0 : this.declaringClassPattern.hashCode());
        result = prime * result + ((this.exceptionsPattern == null) ? 0 : this.exceptionsPattern.hashCode());
        result = prime * result + ((this.modifiersPattern == null) ? 0 : this.modifiersPattern.hashCode());
        result = prime * result + ((this.namePattern == null) ? 0 : this.namePattern.hashCode());
        result = prime * result + ((this.parametersPattern == null) ? 0 : this.parametersPattern.hashCode());
        result = prime * result + ((this.returnTypePattern == null) ? 0 : this.returnTypePattern.hashCode());
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
        final MethodPattern other = (MethodPattern) obj;
        if (this.declaringClassPattern == null) {
            if (other.declaringClassPattern != null)
                return false;
        } else if (!this.declaringClassPattern.equals(other.declaringClassPattern))
            return false;
        if (this.exceptionsPattern == null) {
            if (other.exceptionsPattern != null)
                return false;
        } else if (!this.exceptionsPattern.equals(other.exceptionsPattern))
            return false;
        if (this.modifiersPattern == null) {
            if (other.modifiersPattern != null)
                return false;
        } else if (!this.modifiersPattern.equals(other.modifiersPattern))
            return false;
        if (this.namePattern == null) {
            if (other.namePattern != null)
                return false;
        } else if (!this.namePattern.equals(other.namePattern))
            return false;
        if (this.parametersPattern == null) {
            if (other.parametersPattern != null)
                return false;
        } else if (!this.parametersPattern.equals(other.parametersPattern))
            return false;
        if (this.returnTypePattern == null) {
            if (other.returnTypePattern != null)
                return false;
        } else if (!this.returnTypePattern.equals(other.returnTypePattern))
            return false;
        return true;
    }
    
}
