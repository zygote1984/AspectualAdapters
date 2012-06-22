package org.alia4j.liam.signature;

import java.lang.reflect.Modifier;
import org.alia4j.hierarchy.TypeDescriptor;

public abstract class Signature {
    
    /**
     * @param modifiers see {@link Modifier}
     * @param declaringClass may not be {@code null}
     * @param name may not be {@code null}
     */
    Signature(final int modifiers, final TypeDescriptor declaringClass, final CharSequence name) {
        if (declaringClass == null)
            throw new IllegalArgumentException("Declaring class may not be null.");
        if (name == null)
            throw new IllegalArgumentException("Name may not be null.");
        this.modifiers = modifiers;
        this.declaringClass = declaringClass;
        this.name = name.toString();
    }
    
    public int getModifiers() {
        return this.modifiers;
    }
    
    private final int modifiers;
    
    public TypeDescriptor getDeclaringClass() {
        return this.declaringClass;
    }
    
    private final TypeDescriptor declaringClass;
    
    public CharSequence getName() {
        return this.name;
    }
    
    private final String name;
    
    public boolean isStatic() {
        return Modifier.isStatic(this.modifiers);
    }
    
    abstract public TypeDescriptor getReturnType();
    
    abstract public <T> T accept(SignatureProcessor<T> processor);
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.declaringClass == null) ? 0 : this.declaringClass.hashCode());
        result = prime * result + this.modifiers;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
        final Signature other = (Signature) obj;
        if (this.declaringClass == null) {
            if (other.declaringClass != null)
                return false;
        } else if (!this.declaringClass.equals(other.declaringClass))
            return false;
        if (this.modifiers != other.modifiers)
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        } else if (!this.name.equals(other.name))
            return false;
        return true;
    }
    
}
