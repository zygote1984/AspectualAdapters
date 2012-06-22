package org.alia4j.noirin.action;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.Action;
import org.alia4j.liam.action.ActionFactoryDef;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.liam.signature.ResolutionStrategy;

public class ActionFactoryImpl extends ActionFactoryDef {
    
    public static void initialize() {
        new ActionFactoryImpl();
    }
    
    private ActionFactoryImpl() {}
    
    @Override
    protected Action createMethodCallAction(final TypeDescriptor declaringClass, final CharSequence methodName,
                    final TypeDescriptor[] typeDescriptors, final TypeDescriptor resultType,
                    final ResolutionStrategy resolutionStrategy, final EventSignature triggeredEvent) {
        return new MethodCallAction(declaringClass, methodName, typeDescriptors, resultType, resolutionStrategy,
                        triggeredEvent);
    }
    
}
