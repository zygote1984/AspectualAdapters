package org.alia4j.aspectj.model.context;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.aspectj.lang.reflect.InitializerSignature;

/**
 * AspectJ uses InitializerSignature for instance and static initializers; in the AspectJ LIAM model it is only used for
 * static initializers.
 * 
 * @author Christoph Bockisch, Andreas Sewe
 */
class InitializerSignatureImpl implements InitializerSignature {
    
    private final Class<?> declaringClass;
    
    protected InitializerSignatureImpl(final Class<?> declaringClass) {
        this.declaringClass = declaringClass;
    }
    
    public Constructor<?> getConstructor() {
        return null;
    }
    
    public Class<?>[] getExceptionTypes() {
        return new Class<?>[0];
    }
    
    public String[] getParameterNames() {
        return new String[0];
    }
    
    public Class<?>[] getParameterTypes() {
        return new Class<?>[0];
    }
    
    public Class<?> getDeclaringType() {
        return this.declaringClass;
    }
    
    public String getDeclaringTypeName() {
        return this.declaringClass.getName();
    }
    
    public int getModifiers() {
        return Modifier.STATIC;
    }
    
    public String getName() {
        return "<clinit>";
    }
    
    public String toLongString() {
        return this.toString();
    }
    
    public String toShortString() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        return this.declaringClass.toString() + ".static {}";
    }
    
    /**
     * As this class is only used for static initializers, this method will always return {@code null}.
     */
    @Override
    public Constructor<?> getInitializer() {
        return null;
    }
    
}
