package org.alia4j.liam;

import java.util.Arrays;
import java.util.HashMap;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.liam.predicate.ThresholdPredicate;
import org.alia4j.liam.signature.ResolutionStrategy;

/**
 * @author Andreas Sewe
 */
// TODO canonize actions
public abstract class ActionFactory {
    
    private static final class ArrayBasedKey {
        
        private final Object[] keyArray;
        
        private ArrayBasedKey(Object[] keyArray) {
            this.keyArray = keyArray;
        }
        
        @Override
        public int hashCode() {
            return Arrays.hashCode(this.keyArray);
        }
        
        @Override
        public boolean equals(final Object obj) {
            if (!(obj instanceof ArrayBasedKey))
                return false;
            return Arrays.equals(this.keyArray, ((ArrayBasedKey) obj).keyArray);
        }
    }
    
    protected ActionFactory() {
        if (ActionFactory.singleton != null)
            throw new IllegalStateException();
        ActionFactory.singleton = this;
    }
    
    private static ActionFactory getInstance() {
        return ActionFactory.singleton;
    }
    
    private static ActionFactory singleton;
    
    /**
     * Creates an action which may trigger an event (see Bockisch et al. 2011 @ AOSD). When using this factory method, a
     * method must be specified that is exectued as action; it must accept an argument of type
     * org.alia4j.liam.event.EventTriggering in the last argument position. The passed EventTriggering object can be used to
     * actually trigger the event. This method expects the declaring class name in Java representation (i.e., '.' as package
     * separator) and method descriptor in virtual machine internal representation (i.e., all types concatenated, '/' as
     * package separator, reference types start with '[' or 'L', ...) the descriptor also comprises the result type.
     * 
     * @param instantiationStrategy
     * @param declaringClassName
     * @param methodName
     * @param methodDescriptor
     * @param triggeredEventSignature may not be null
     * @return
     */
    public static final Action findOrCreateEventTriggeringAction(final String declaringClassName, final String methodName,
                    final String methodDescriptor, EventSignature triggeredEventSignature) {
        if (triggeredEventSignature == null)
            throw new IllegalArgumentException("triggeredEventName must not be null.");
        return ActionFactory.findOrCreateMethodCallAction(TypeHierarchyProvider
                        .findOrCreateFromNormalTypeName(declaringClassName), methodName, TypeHierarchyProvider
                        .findOrCreateFromTypeDescriptors(methodDescriptor.substring(1, methodDescriptor.indexOf(')'))),
                        TypeHierarchyProvider.findOrCreateFromTypeDescriptor(methodDescriptor.substring(methodDescriptor
                                        .indexOf(')') + 1)), ResolutionStrategy.VIRTUAL, triggeredEventSignature);
    }
    
    /**
     * This method expects the declaring class name in Java representation (i.e., '.' as package separator) and method
     * descriptor in virtual machine internal representation (i.e., all types concatenated, '/' as package separator,
     * reference types start with '[' or 'L', ...) the descriptor also comprises the result type.
     * 
     * @param instantiationStrategy
     * @param declaringClassName
     * @param methodName
     * @param methodDescriptor
     * @return
     */
    public static final Action findOrCreateMethodCallAction(final String declaringClassName, final String methodName,
                    final String methodDescriptor) {
        return ActionFactory.findOrCreateMethodCallAction(TypeHierarchyProvider
                        .findOrCreateFromNormalTypeName(declaringClassName), methodName, TypeHierarchyProvider
                        .findOrCreateFromTypeDescriptors(methodDescriptor.substring(1, methodDescriptor.indexOf(')'))),
                        TypeHierarchyProvider.findOrCreateFromTypeDescriptor(methodDescriptor.substring(methodDescriptor
                                        .indexOf(')') + 1)), ResolutionStrategy.VIRTUAL, null);
    }
    
    /**
     * This method expects all type names in Java language representation.
     * 
     * @param instantiationStrategy
     * @param declaringClassName
     * @param methodName
     * @param argumentTypeNames
     * @return
     */
    public static final Action findOrCreateMethodCallAction(final String declaringClassName, final String methodName,
                    final String[] parameterTypeNames, final String resultTypeName) {
        return ActionFactory.findOrCreateMethodCallAction(
                        TypeHierarchyProvider.findOrCreateFromNormalTypeName(declaringClassName), methodName,
                        TypeHierarchyProvider.findOrCreateFromNormalTypeNames(parameterTypeNames),
                        TypeHierarchyProvider.findOrCreateFromNormalTypeName(resultTypeName), ResolutionStrategy.VIRTUAL,
                        null);
    }
    
    /**
     * @param declaringClass
     * @param methodName
     * @param parameterTypes
     * @param resultType
     * @param invocationType
     * @return
     */
    public static final Action findOrCreateMethodCallAction(final TypeDescriptor declaringClass,
                    final CharSequence methodName, final TypeDescriptor[] parameterTypes, final TypeDescriptor resultType,
                    final ResolutionStrategy invocationType) {
        return ActionFactory.findOrCreateMethodCallAction(declaringClass, methodName, parameterTypes, resultType,
                        invocationType, null);
    }
    
    /**
     * @param declaringClass
     * @param methodName
     * @param parameterTypes
     * @param resultType
     * @param invocationType
     * @param triggeredEventSignature if this action can trigger an event, the name of the triggered event must be specified,
     *            otherwise, this argument must be {@code null}.
     * @return
     */
    public static final Action findOrCreateMethodCallAction(final TypeDescriptor declaringClass,
                    final CharSequence methodName, final TypeDescriptor[] parameterTypes, final TypeDescriptor resultType,
                    final ResolutionStrategy invocationType, EventSignature triggeredEventSignature) {
        final Object[] keyArray = new Object[5 + parameterTypes.length];
        keyArray[0] = declaringClass;
        keyArray[1] = methodName.toString();
        keyArray[2] = resultType;
        keyArray[3] = invocationType;
        keyArray[4] = triggeredEventSignature;
        System.arraycopy(parameterTypes, 0, keyArray, 5, parameterTypes.length);
        
        final ArrayBasedKey key = new ArrayBasedKey(keyArray);
        
        if (!ActionFactory.canonicalMethodCallActions.containsKey(key)) {
            ActionFactory.canonicalMethodCallActions.put(
                            key,
                            ActionFactory.getInstance().createMethodCallAction(declaringClass, methodName, parameterTypes,
                                            resultType, invocationType, triggeredEventSignature));
        }
        return ActionFactory.canonicalMethodCallActions.get(key);
    }
    
    private static HashMap<ArrayBasedKey, Action> canonicalMethodCallActions = new HashMap<ArrayBasedKey, Action>();
    
    /**
     * @param declaringClass
     * @param methodName
     * @param parameterTypes
     * @param resultType
     * @param invocationType
     * @param triggeredEventSignature if this action can trigger an event, the name of the triggered event must be specified,
     *            otherwise, this argument must be {@code null}.
     * @return
     */
    public static final Action findOrCreateConstructorCallAction(final TypeDescriptor declaringClass,
                    final TypeDescriptor[] parameterTypes) {
        final Object[] keyArray = new Object[1 + parameterTypes.length];
        keyArray[0] = declaringClass;
        System.arraycopy(parameterTypes, 0, keyArray, 1, parameterTypes.length);
        
        final ArrayBasedKey key = new ArrayBasedKey(keyArray);
        
        if (!ActionFactory.canonicalConstructorCallActions.containsKey(key)) {
            ActionFactory.canonicalConstructorCallActions.put(key,
                            ActionFactory.getInstance().createConstructorCallAction(declaringClass, parameterTypes));
        }
        return ActionFactory.canonicalConstructorCallActions.get(key);
    }
    
    private static HashMap<ArrayBasedKey, Action> canonicalConstructorCallActions = new HashMap<ArrayBasedKey, Action>();
    
    public static final Action findOrCreateFieldReadAction(final TypeDescriptor declaringClass, final CharSequence name,
                    final TypeDescriptor fieldType, final ResolutionStrategy resolutionStrategy) {
        final Object[] keyArray = new Object[4];
        keyArray[0] = declaringClass;
        keyArray[1] = name.toString();
        keyArray[2] = fieldType;
        keyArray[3] = resolutionStrategy;
        final Object key = new Object() {
            
            @Override
            public int hashCode() {
                return Arrays.hashCode(keyArray);
            }
            
            @Override
            public boolean equals(final Object obj) {
                if (!(obj instanceof Object[]))
                    return false;
                return Arrays.equals(keyArray, (Object[]) obj);
            }
            
        };
        if (!ActionFactory.canonicalFieldReadActions.containsKey(key)) {
            ActionFactory.canonicalFieldReadActions.put(
                            key,
                            ActionFactory.getInstance().createFieldReadAction(declaringClass, name, fieldType,
                                            resolutionStrategy));
        }
        return ActionFactory.canonicalFieldReadActions.get(key);
    }
    
    private static HashMap<Object, Action> canonicalFieldReadActions = new HashMap<Object, Action>();
    
    public static final Action findOrCreateFieldWriteAction(final TypeDescriptor declaringClass, final CharSequence name,
                    final TypeDescriptor fieldType, final ResolutionStrategy resolutionStrategy) {
        final Object[] keyArray = new Object[4];
        keyArray[0] = declaringClass;
        keyArray[1] = name.toString();
        keyArray[2] = fieldType;
        keyArray[3] = resolutionStrategy;
        final Object key = new Object() {
            
            @Override
            public int hashCode() {
                return Arrays.hashCode(keyArray);
            }
            
            @Override
            public boolean equals(final Object obj) {
                if (!(obj instanceof Object[]))
                    return false;
                return Arrays.equals(keyArray, (Object[]) obj);
            }
            
        };
        if (!ActionFactory.canonicalFieldWriteActions.containsKey(key)) {
            ActionFactory.canonicalFieldWriteActions.put(
                            key,
                            ActionFactory.getInstance().createFieldWriteAction(declaringClass, name, fieldType,
                                            resolutionStrategy));
        }
        return ActionFactory.canonicalFieldWriteActions.get(key);
    }
    
    private static HashMap<Object, Action> canonicalFieldWriteActions = new HashMap<Object, Action>();
    
    public static final Action findOrCreateErrorAction(final TypeDescriptor throwableType) {
        if (!ActionFactory.canonicalErrorActions.containsKey(throwableType)) {
            ActionFactory.canonicalErrorActions.put(throwableType,
                            ActionFactory.getInstance().createErrorAction(throwableType));
        }
        return ActionFactory.canonicalErrorActions.get(throwableType);
    }
    
    private static HashMap<TypeDescriptor, Action> canonicalErrorActions = new HashMap<TypeDescriptor, Action>();
    
    public static final Action findOrCreateNoOpAction() {
        if (ActionFactory.singletonNoOpAction == null)
            ActionFactory.singletonNoOpAction = ActionFactory.getInstance().createNoOpAction();;
        return ActionFactory.singletonNoOpAction;
    }
    
    private static Action singletonNoOpAction = null;
    
    public static final Action findOrCreateCFlowEnterAction(final ThresholdPredicate property) {
        if (!ActionFactory.canonicalCFlowEnterActions.containsKey(property)) {
            ActionFactory.canonicalCFlowEnterActions.put(property,
                            ActionFactory.getInstance().createCFlowEnterAction(property));
        }
        return ActionFactory.canonicalCFlowEnterActions.get(property);
    }
    
    private static HashMap<ThresholdPredicate, Action> canonicalCFlowEnterActions =
                    new HashMap<ThresholdPredicate, Action>();
    
    public static final Action findOrCreateCFlowExitAction(final ThresholdPredicate property) {
        if (!ActionFactory.canonicalCFlowExitActions.containsKey(property)) {
            ActionFactory.canonicalCFlowExitActions.put(property, ActionFactory.getInstance()
                            .createCFlowExitAction(property));
        }
        return ActionFactory.canonicalCFlowExitActions.get(property);
    }
    
    private static HashMap<ThresholdPredicate, Action> canonicalCFlowExitActions = new HashMap<ThresholdPredicate, Action>();
    
    abstract protected Action createCFlowExitAction(ThresholdPredicate property);
    
    abstract protected Action createCFlowEnterAction(ThresholdPredicate property);
    
    abstract protected Action createErrorAction(TypeDescriptor throwableType);
    
    abstract protected Action createNoOpAction();
    
    abstract protected Action createFieldReadAction(TypeDescriptor declaringClass, CharSequence fieldName,
                    TypeDescriptor type, ResolutionStrategy resolutionStrategy);
    
    abstract protected Action createFieldWriteAction(TypeDescriptor declaringClass, CharSequence fieldName,
                    TypeDescriptor type, ResolutionStrategy resolutionStrategy);
    
    /**
     * @param declaringClass
     * @param methodName
     * @param typeDescriptors
     * @param resultType
     * @param invocationType
     * @param triggeredEventSignature if this action can trigger an event, the signature of the triggered event must be
     *            specified, otherwise, this argument must be {@code null}.
     * @return
     */
    abstract protected Action createMethodCallAction(TypeDescriptor declaringClass, CharSequence methodName,
                    TypeDescriptor[] typeDescriptors, TypeDescriptor resultType, ResolutionStrategy invocationType,
                    EventSignature triggeredEventSignature);
    
    abstract protected Action createConstructorCallAction(TypeDescriptor declaringClass, TypeDescriptor[] parameterTypes);
}
