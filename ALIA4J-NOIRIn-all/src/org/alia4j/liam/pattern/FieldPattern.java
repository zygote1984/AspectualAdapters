package org.alia4j.liam.pattern;

import org.alia4j.liam.signature.FieldSignature;
import org.alia4j.patterns.ClassTypePattern;
import org.alia4j.patterns.ModifiersPattern;
import org.alia4j.patterns.NamePattern;
import org.alia4j.patterns.TypePattern;

public abstract class FieldPattern<TFieldSignature extends FieldSignature> extends Pattern<TFieldSignature> {
    
    private final ModifiersPattern modifiersPattern;
    
    private final TypePattern typePattern;
    
    private final ClassTypePattern declaringClassPattern;
    
    private final NamePattern namePattern;
    
    public FieldPattern(final ModifiersPattern modifiersPattern, final TypePattern typePattern,
                    final ClassTypePattern declaringClassPattern, final NamePattern namePattern) {
        super();
        this.modifiersPattern = modifiersPattern;
        this.typePattern = typePattern;
        this.declaringClassPattern = declaringClassPattern;
        this.namePattern = namePattern;
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
    
    public TypePattern getTypePattern() {
        return this.typePattern;
    }
    
    @Override
    public boolean match(final TFieldSignature signature) {
        return this.modifiersPattern.matches(signature.getModifiers()) && this.typePattern.matches(signature.getType())
                        && this.declaringClassPattern.matches(signature.getDeclaringClass())
                        && this.namePattern.matches(signature.getName());
    }
    
    @Override
    public String toString() {
        return this.modifiersPattern + " " + this.typePattern + " " + this.declaringClassPattern + "." + this.namePattern;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.declaringClassPattern == null) ? 0 : this.declaringClassPattern.hashCode());
        result = prime * result + ((this.modifiersPattern == null) ? 0 : this.modifiersPattern.hashCode());
        result = prime * result + ((this.namePattern == null) ? 0 : this.namePattern.hashCode());
        result = prime * result + ((this.typePattern == null) ? 0 : this.typePattern.hashCode());
        return result;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        final FieldPattern other = (FieldPattern) obj;
        if (this.declaringClassPattern == null) {
            if (other.declaringClassPattern != null)
                return false;
        } else if (!this.declaringClassPattern.equals(other.declaringClassPattern))
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
        if (this.typePattern == null) {
            if (other.typePattern != null)
                return false;
        } else if (!this.typePattern.equals(other.typePattern))
            return false;
        return true;
    }
    
}
