package org.alia4j.liam.action;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeDescriptorConstants;
import org.alia4j.liam.Action;


/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class NoOpAction extends Action {
    
    protected NoOpAction() {}
    
    public void perform(final Object passedContextValues) {
        return;
    }
    
    @Override
    public String toString() {
        return "noOp";
    }

    @Override
    public TypeDescriptor getRequiredParameterType(int parameterPosition) {
        throw new IllegalArgumentException("NoOp action does not accept arguments.");
    }

    @Override
    public TypeDescriptor getResultType() {
        return TypeDescriptorConstants.VOID_PRIMITIVE;
    }
}
