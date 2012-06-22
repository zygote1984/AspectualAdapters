package org.alia4j.aspectj.model.context;

import java.lang.reflect.Modifier;
import org.aspectj.lang.Signature;

class SignatureImpl implements Signature {
    
    private final int modifiers;
    
    private final Class<?> declaringClassType;
    
    private final String name;
    
    protected SignatureImpl(final int modifiers, final Class<?> declaringClassType, final String name) {
        this.modifiers = modifiers;
        this.declaringClassType = declaringClassType;
        this.name = name;
    }
    
    public Class<?> getDeclaringType() {
        return this.declaringClassType;
    }
    
    public String getDeclaringTypeName() {
        return this.declaringClassType.getName();
    }
    
    public int getModifiers() {
        return this.modifiers;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toLongString() {
        return this.toString();
    }
    
    public String toShortString() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        return Modifier.toString(this.getModifiers()) + " " + this.getDeclaringTypeName() + "." + this.getName();
    }
}
