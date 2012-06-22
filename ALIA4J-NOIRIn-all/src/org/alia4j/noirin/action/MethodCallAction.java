package org.alia4j.noirin.action;

import java.lang.reflect.Method;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.liam.event.EventTriggering;
import org.alia4j.liam.signature.ResolutionStrategy;
import org.alia4j.noirin.transform.InterpreterCallbackInserter;

public class MethodCallAction extends org.alia4j.liam.action.MethodCallAction {
    
    private static final TypeDescriptor EVENT_TRIGGERING_TYPE = TypeHierarchyProvider
                    .findOrCreateFromClass(EventTriggering.class);
    
    private Method specialMethod;
    
    private final EventSignature triggeredEventSignature;
    
    protected MethodCallAction(final TypeDescriptor declaringClass, final CharSequence methodName,
                    final TypeDescriptor[] typeDescriptors, final TypeDescriptor resultType,
                    final ResolutionStrategy resolutionStrategy, EventSignature triggeredEvent) {
        super(declaringClass, methodName, typeDescriptors, resultType, resolutionStrategy);
        if (triggeredEvent != null
                        && (typeDescriptors.length == 0 || typeDescriptors[typeDescriptors.length - 1] != MethodCallAction.EVENT_TRIGGERING_TYPE))
            throw new IllegalArgumentException(
                            "Actions that declare to trigger an event must accept an EventTriggering object as last argument.");
        this.triggeredEventSignature = triggeredEvent;
    }
    
    @Override
    protected Object invokeSpecialReflectively(final Method method, final Object owner, final Object[] arguments)
                    throws Throwable {
        if (this.specialMethod == null) {
            final Class<?>[] specialParameterTypes = new Class<?>[method.getParameterTypes().length + 1];
            specialParameterTypes[0] = method.getDeclaringClass();
            System.arraycopy(method.getParameterTypes(), 0, specialParameterTypes, 1, method.getParameterTypes().length);
            this.specialMethod =
                            method.getDeclaringClass().getDeclaredMethod(
                                            InterpreterCallbackInserter.getInvokeSpecialName(method.getName()),
                                            specialParameterTypes);
            this.specialMethod.setAccessible(true);
        }
        final Object[] specialArguments = new Object[arguments.length + 1];
        specialArguments[0] = owner;
        System.arraycopy(arguments, 0, specialArguments, 1, arguments.length);
        return this.specialMethod.invoke(null, specialArguments);
    }
    
    @Override
    public boolean triggersEvent() {
        return this.triggeredEventSignature != null;
    }
    
    @Override
    public EventSignature getTriggeredEventSignature() {
        return this.triggeredEventSignature;
    }
    
}
