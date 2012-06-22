package org.alia4j.liam.action;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeDescriptorConstants;
import org.alia4j.liam.signature.ResolutionStrategy;

/**
 * @author Christoph Bockisch
 */
public class FieldWriteAction extends FieldAction {
    
    protected FieldWriteAction(final TypeDescriptor declaringClassName, final CharSequence fieldName,
                    final TypeDescriptor fieldTypeName, final ResolutionStrategy resolutionStrategy) {
        super(declaringClassName, fieldName, fieldTypeName, resolutionStrategy);
    }
    
    @Override
    public TypeDescriptor getResultType() {
        return TypeDescriptorConstants.VOID_PRIMITIVE;
    }
    
    @Override
    public TypeDescriptor getRequiredParameterType(final int parameterPosition) {
        assert (!this.isStaticAccess() && parameterPosition >= 0 && parameterPosition < 2)
                        || (this.isStaticAccess() && parameterPosition == 0);
        if (this.isStaticAccess()) {
            return this.getFieldTypeName();
        } else {
            if (parameterPosition == 0)
                return this.getDeclaringClassName();
            else
                return this.getFieldTypeName();
        }
    }
    
    public void perform(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, ClassNotFoundException, NoSuchFieldException {
        final Object owner;
        final Object newValue;
        if (this.isStaticAccess()) {
            owner = null;
            newValue = ((Object[]) exposedContextValues)[0];
        } else {
            owner = ((Object[]) exposedContextValues)[0];
            newValue = ((Object[]) exposedContextValues)[1];
        }
        this.getField().set(owner, newValue);
    }
}
