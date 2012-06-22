package org.alia4j.aspectj.model.context;

import java.lang.reflect.Method;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author Andreas Sewe
 */
class MethodSignatureImpl implements MethodSignature {
    
    private final Method method;
    
    protected MethodSignatureImpl(final Method method) {
        this.method = method;
    }
    
    public Method getMethod() {
        return this.method;
    }
    
    public Class<?> getReturnType() {
        return this.method.getReturnType();
    }
    
    public Class<?>[] getExceptionTypes() {
        return this.method.getExceptionTypes();
    }
    
    public String[] getParameterNames() {
        throw new UnsupportedOperationException();
    }
    
    public Class<?>[] getParameterTypes() {
        return this.method.getParameterTypes();
    }
    
    public Class<?> getDeclaringType() {
        return this.method.getDeclaringClass();
    }
    
    public String getDeclaringTypeName() {
        return this.method.getDeclaringClass().getName();
    }
    
    public int getModifiers() {
        return this.method.getModifiers();
    }
    
    public String getName() {
        return this.method.getName();
    }
    
    public String toLongString() {
        return this.toString();
    }
    
    public String toShortString() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        return this.method.toString();
    }
}
