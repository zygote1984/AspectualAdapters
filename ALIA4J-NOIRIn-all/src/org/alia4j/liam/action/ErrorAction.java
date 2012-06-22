package org.alia4j.liam.action;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeDescriptorConstants;
import org.alia4j.liam.Action;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class ErrorAction extends Action {
    
    private final TypeDescriptor throwableType;
    
    private Class<?> throwableClass;
    
    protected ErrorAction(final TypeDescriptor throwableType) {
        this.throwableType = throwableType;
    }
    
    @Override
    public TypeDescriptor getRequiredParameterType(final int parameterPosition) {
        throw new IllegalArgumentException("This action may not be passed any arguments.");
    }
    
    @Override
    public TypeDescriptor getResultType() {
        return TypeDescriptorConstants.VOID_PRIMITIVE;
    }
    
    public void perform(final Object exposedContextValues) throws InstantiationException, IllegalAccessException, Throwable {
        if (this.throwableClass == null)
            this.throwableClass = this.throwableType.asClass();
        throw (Throwable) this.throwableClass.newInstance();
    }
    
}
