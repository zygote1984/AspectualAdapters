package org.alia4j.liam;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.util.PairHashMap;

/**
 * @author Andreas Sewe
 */
public abstract class AtomicPredicateFactory {
    
    protected AtomicPredicateFactory() {
        if (AtomicPredicateFactory.singleton != null)
            throw new IllegalStateException();
        AtomicPredicateFactory.singleton = this;
    }
    
    private static AtomicPredicateFactory getInstance() {
        return AtomicPredicateFactory.singleton;
    }
    
    private static AtomicPredicateFactory singleton;
    
    public static final AtomicPredicate findOrCreateContextValuePredicate(final Context context) {
        if (!AtomicPredicateFactory.canonicalContextValuePredicates.containsKey(context))
            AtomicPredicateFactory.canonicalContextValuePredicates.put(context, AtomicPredicateFactory.getInstance()
                            .createContextValuePredicate(context));
        return AtomicPredicateFactory.canonicalContextValuePredicates.get(context);
    }
    
    private static HashMap<Context, AtomicPredicate> canonicalContextValuePredicates =
                    new HashMap<Context, AtomicPredicate>();
    
    public static final AtomicPredicate findOrCreateCFlowPredicate(
                    final Set<Specialization> constitutingGenericFunctionSpecializations) {
        return AtomicPredicateFactory.getInstance().createCFlowPredicate(constitutingGenericFunctionSpecializations);
    }
    
    public static final AtomicPredicate findOrCreateCFlowBelowPredicate(
                    final Set<Specialization> constitutingGenericFunctionSpecializations) {
        return AtomicPredicateFactory.getInstance().createCFlowBelowPredicate(constitutingGenericFunctionSpecializations);
    }
    
    public static final AtomicPredicate findOrCreateExactTypePredicate(final Context context,
                    final TypeDescriptor expectedType) {
        if (!AtomicPredicateFactory.canonicalExpectedExactTypeAtomicPredicates.containsKeys(context, expectedType))
            AtomicPredicateFactory.canonicalExpectedExactTypeAtomicPredicates.put(context, expectedType,
                            AtomicPredicateFactory.getInstance().createExactTypePredicate(context, expectedType));
        return AtomicPredicateFactory.canonicalExpectedExactTypeAtomicPredicates.get(context, expectedType);
    }
    
    private static PairHashMap<Context, TypeDescriptor, AtomicPredicate> canonicalExpectedExactTypeAtomicPredicates =
                    new PairHashMap<Context, TypeDescriptor, AtomicPredicate>();
    
    public static final AtomicPredicate findOrCreateInstanceofPredicate(final Context context,
                    final TypeDescriptor expectedType) {
        if (!AtomicPredicateFactory.canonicalExpectedTypeAtomicPredicates.containsKeys(context, expectedType))
            AtomicPredicateFactory.canonicalExpectedTypeAtomicPredicates.put(context, expectedType, AtomicPredicateFactory
                            .getInstance().createInstanceofPredicate(context, expectedType));
        return AtomicPredicateFactory.canonicalExpectedTypeAtomicPredicates.get(context, expectedType);
    }
    
    private static PairHashMap<Context, TypeDescriptor, AtomicPredicate> canonicalExpectedTypeAtomicPredicates =
                    new PairHashMap<Context, TypeDescriptor, AtomicPredicate>();
    
    /**
     * Generates an atomic predicate that calls a method (which must return a boolean) and returns the result. The method
     * must have not parameters. The factoryClassName is the fully qualified name of a class that contains a public static
     * method with the name specified by factoryMethodName. This method must not take any arguments. This method is called to
     * retrieve the receiver object for the condition method. The factory method is only called once, just before the atomic
     * predicate is evaluated.
     * 
     * @return
     */
    public static final AtomicPredicate findOrCreateMethodPredicate(final String fullyQualifiedDeclaringClass,
                    final String methodName, final String factoryClassName, final String factoryMethodName) {
        // TODO this should be canonized
        return AtomicPredicateFactory.getInstance().createMethodPredicate(
                        TypeHierarchyProvider.findOrCreateFromNormalTypeName(fullyQualifiedDeclaringClass), methodName,
                        TypeHierarchyProvider.findOrCreateFromNormalTypeName(factoryClassName), factoryMethodName);
    }
    
    public static final AtomicPredicate findOrCreateEventTriggeredPredicate(EventSignature eventSignature) {
        if (!AtomicPredicateFactory.canonicalEventTriggeredAtomicPredicates.containsKey(eventSignature)) {
            AtomicPredicateFactory.canonicalEventTriggeredAtomicPredicates.put(eventSignature, AtomicPredicateFactory
                            .getInstance().createEventTriggeredPredicate(eventSignature));
        }
        return AtomicPredicateFactory.canonicalEventTriggeredAtomicPredicates.get(eventSignature);
    }
    
    private static Map<EventSignature, AtomicPredicate> canonicalEventTriggeredAtomicPredicates =
                    new HashMap<EventSignature, AtomicPredicate>();
    
    protected abstract AtomicPredicate createContextValuePredicate(Context context);
    
    protected abstract AtomicPredicate createCFlowPredicate(Set<Specialization> constitutingGenericFunctionSpecializations);
    
    protected abstract AtomicPredicate createCFlowBelowPredicate(
                    Set<Specialization> constitutingGenericFunctionSpecializations);
    
    protected abstract AtomicPredicate createExactTypePredicate(Context context, TypeDescriptor expectedType);
    
    protected abstract AtomicPredicate createInstanceofPredicate(Context context, TypeDescriptor expectedType);
    
    protected abstract AtomicPredicate createMethodPredicate(TypeDescriptor declaringClass, CharSequence methodName,
                    TypeDescriptor factoryClass, CharSequence factoryMethodName);
    
    protected abstract AtomicPredicate createEventTriggeredPredicate(EventSignature eventSignature);
}
