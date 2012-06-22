package org.alia4j.liam.predicate;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.AtomicPredicateFactory;
import org.alia4j.liam.Context;
import org.alia4j.liam.event.EventSignature;

/**
 * An Abstract Factory providing default implementations of various <code>AtomicPredicate</code>s for the benefit of all FIAL
 * instantiations.
 * 
 * @author Andreas Sewe
 */
public abstract class AtomicPredicateFactoryDef extends AtomicPredicateFactory {
    
    protected AtomicPredicateFactoryDef() {}
    
    @Override
    protected AtomicPredicate createContextValuePredicate(final Context context) {
        return new ContextValuePredicate(context);
    }
    
    @Override
    protected AtomicPredicate createExactTypePredicate(final Context context, final TypeDescriptor expectedType) {
        return new ExactTypePredicate(context, expectedType);
    }
    
    @Override
    protected AtomicPredicate createInstanceofPredicate(final Context context, final TypeDescriptor expectedType) {
        return new InstanceofPredicate(context, expectedType);
    }
    
    @Override
    protected AtomicPredicate createMethodPredicate(final TypeDescriptor fullyQualifiedDeclaringClass,
                    final CharSequence methodName, final TypeDescriptor factoryClassName,
                    final CharSequence factoryMethodName) {
        return new MethodPredicate(fullyQualifiedDeclaringClass, methodName, factoryClassName, factoryMethodName);
    }
    
    @Override
    protected AtomicPredicate createEventTriggeredPredicate(EventSignature eventSignature) {
        return new EventTriggeredPredicate(eventSignature);
    }
}
