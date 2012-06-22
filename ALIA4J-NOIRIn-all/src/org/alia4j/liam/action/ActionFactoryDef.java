package org.alia4j.liam.action;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.Action;
import org.alia4j.liam.ActionFactory;
import org.alia4j.liam.predicate.ThresholdPredicate;
import org.alia4j.liam.signature.ResolutionStrategy;

/**
 * An Abstract Factory providing default implementations of various <code>Action</code>s for the benefit of all FIAL
 * instantiations.
 * 
 * @author Andreas Sewe
 */
abstract public class ActionFactoryDef extends ActionFactory {
    
    protected ActionFactoryDef() {}
    
    @Override
    protected Action createCFlowExitAction(final ThresholdPredicate property) {
        return new CFlowExitAction(property);
    }
    
    @Override
    protected Action createCFlowEnterAction(final ThresholdPredicate property) {
        return new CFlowEnterAction(property);
    }
    
    @Override
    protected Action createErrorAction(final TypeDescriptor throwableType) {
        return new ErrorAction(throwableType);
    }
    
    @Override
    protected Action createNoOpAction() {
        return new NoOpAction();
    }
    
    @Override
    protected Action createFieldReadAction(final TypeDescriptor declaringClassName, final CharSequence fieldName,
                    final TypeDescriptor fieldTypeName, final ResolutionStrategy resolutionStrategy) {
        return new FieldReadAction(declaringClassName, fieldName, fieldTypeName, resolutionStrategy);
    }
    
    @Override
    protected Action createFieldWriteAction(final TypeDescriptor declaringClassName, final CharSequence fieldName,
                    final TypeDescriptor fieldTypeName, final ResolutionStrategy resolutionStrategy) {
        return new FieldWriteAction(declaringClassName, fieldName, fieldTypeName, resolutionStrategy);
    }
    
    @Override
    protected Action createConstructorCallAction(TypeDescriptor declaringClass, TypeDescriptor[] parameterTypes) {
        return new ConstructorCallAction(declaringClass, parameterTypes);
    }
    
}
