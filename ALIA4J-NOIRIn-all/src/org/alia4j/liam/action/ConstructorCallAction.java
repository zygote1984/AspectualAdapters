package org.alia4j.liam.action;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public class ConstructorCallAction extends MemberAction {
    
    private final TypeDescriptor[] parameterTypes;
    
    private Constructor<?> constructor;
    
    protected ConstructorCallAction(final TypeDescriptor declaringClass, final TypeDescriptor[] parameterTypes) {
        super(declaringClass, "<init>");
        this.parameterTypes = parameterTypes;
    }
    
    public TypeDescriptor[] getParameterTypeNames() {
        return this.parameterTypes;
    }
    
    @Override
    public TypeDescriptor getRequiredParameterType(final int parameterPosition) {
        assert parameterPosition >= 0 && parameterPosition < this.parameterTypes.length;
        return this.parameterTypes[parameterPosition];
    }
    
    private Constructor<?> getConstructor() throws SecurityException, NoSuchMethodException, ClassNotFoundException {
        if (this.constructor == null) {
            this.constructor =
                            this.getDeclaringClass().getDeclaredConstructor(
                                            TypeHierarchyProvider.asClasses(this.parameterTypes));
            this.constructor.setAccessible(true);
        }
        return this.constructor;
    }
    
    public Object performObject(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        return this.invokeReflectively(exposedContextValues);
    }
    
    private Object invokeReflectively(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        try {
            return this.getConstructor().newInstance((Object[]) exposedContextValues);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
    
    @Override
    public TypeDescriptor getResultType() {
        return this.getDeclaringClassName();
    }
    
}
