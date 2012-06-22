package org.alia4j.aspectj.model.context;

import java.lang.reflect.Constructor;
import org.aspectj.lang.reflect.ConstructorSignature;

/**
 * @author Andreas Sewe
 */
class ConstructorSignatureImpl implements ConstructorSignature {
    
    private final Constructor<?> constructor;
    
    protected ConstructorSignatureImpl(final Constructor<?> constructor) {
        this.constructor = constructor;
    }
    
    public Constructor<?> getConstructor() {
        return this.constructor;
    }
    
    public Class<?>[] getExceptionTypes() {
        return this.constructor.getExceptionTypes();
    }
    
    public String[] getParameterNames() {
        throw new UnsupportedOperationException();
    }
    
    public Class<?>[] getParameterTypes() {
        return this.constructor.getParameterTypes();
    }
    
    public Class<?> getDeclaringType() {
        return this.constructor.getDeclaringClass();
    }
    
    public String getDeclaringTypeName() {
        return this.constructor.getDeclaringClass().getName();
    }
    
    public int getModifiers() {
        return this.constructor.getModifiers();
    }
    
    public String getName() {
        return this.constructor.getName();
    }
    
    public String toLongString() {
        return this.toString();
    }
    
    public String toShortString() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        return this.constructor.toString();
    }
}
