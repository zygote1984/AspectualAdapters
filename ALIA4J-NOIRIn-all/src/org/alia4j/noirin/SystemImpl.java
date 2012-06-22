package org.alia4j.noirin;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.alia4j.addb.util.AddbEvent;
import org.alia4j.fial.ActionOrderElement;
import org.alia4j.fial.AttachedAction;
import org.alia4j.fial.GenericFunction;
import org.alia4j.fial.System;
import org.alia4j.hierarchy.TypeDescriptorConstants;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.AllExposedContextsContext;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.ManageableInstance;
import org.alia4j.liam.Predicate;
import org.alia4j.liam.signature.ConstructorSignature;
import org.alia4j.liam.signature.FieldReadSignature;
import org.alia4j.liam.signature.FieldWriteSignature;
import org.alia4j.liam.signature.MethodSignature;
import org.alia4j.liam.signature.ResolutionStrategy;
import org.alia4j.liam.signature.SignatureFactory;
import org.alia4j.liam.signature.Signed;
import org.alia4j.noirin.context.ToArrayContext;
import org.alia4j.noirin.debug.connection.AddbServerAgent;
import org.alia4j.noirin.debug.data.ADBreakpointException;
import org.alia4j.noirin.debug.data.ADBreakpointManager;
import org.alia4j.noirin.debug.data.DebugDataStore;
import org.alia4j.noirin.debug.data.DispatchFrame;
import org.alia4j.util.ClassLoading;
import org.alia4j.util.Pair;
import org.alia4j.util.PairHashMap;
import org.objectweb.asm.Opcodes;

public class SystemImpl extends System {
    
    private static SystemImpl singletonSystemImpl;
    
    private final DebugDataStore debugDataStore = DebugDataStore.s();
    
    public static void initialize() {
        new SystemImpl();
    }
    
    private SystemImpl() {
        super();
        SystemImpl.singletonSystemImpl = this;
        this.debugDataStore.setSystem(this);
        new InterpreterImpl();
    }
    
    public static SystemImpl getSingletonSystemImpl() {
        return SystemImpl.singletonSystemImpl;
    }
    
    public class InterpreterImpl extends Interpreter {
        
        @Override
        protected Object interpretCallSite(Object callee, Object[] arguments, Object[] localVariables,
                        String declaringClassName, String name, String[] argumentTypes, String returnTypeName,
                        String[] localVariableTypeNames, String[] localVariableNames, final int[] localVariableIndexes,
                        final Object[] rawLocalVariables, int lineNumber, Class<?> callingClass, String callingMethodName,
                        String[] callingMethodArgumentTypeNames, String callingMethodReturnTypeName,
                        int callingMethodModifiers, String callingFileName, Thread thread, int callOpcode) throws Throwable {
            final CallContext callContext =
                            new CallContext(callee, arguments, localVariables, declaringClassName, name, argumentTypes,
                                            returnTypeName, localVariableTypeNames, localVariableNames,
                                            localVariableIndexes, rawLocalVariables, lineNumber, callingClass,
                                            callingMethodName, callingMethodArgumentTypeNames, callingMethodReturnTypeName,
                                            callingMethodModifiers, callingFileName, thread, callOpcode);
            return SystemImpl.this.interpretCallSite(callContext);
        }
    }
    
    // this call stack should be
    private final ThreadLocal<Stack<CallContext>> callStack = new ThreadLocal<Stack<CallContext>>() {
        
        @Override
        protected java.util.Stack<CallContext> initialValue() {
            return new Stack<CallContext>();
        }
    };
    
    public CallContext getCallStackTop() throws EmptyStackException {
        return this.callStack.get().peek();
    }
    
    private void pushCallContext(final CallContext callContext) {
        this.callStack.get().push(callContext);
    }
    
    private CallContext popCallContext() {
        return this.callStack.get().pop();
    }
    
    private Object interpretCallSite(final CallContext callContext) throws Throwable {
        final GenericFunction<?, ?> gf = this.findOrCreateGenericFunction(callContext);
        
        callContext.setCalleeGenericFunction(gf);
        
        this.pushCallContext(callContext);
        
        try {
            final DispatchFunctionEvaluator evaluator = new DispatchFunctionEvaluator(gf);
            
            final Set<AttachedAction> actionsToPerform;
            try {
                for (Pair<Predicate<AtomicPredicate>, AttachedAction> eventTriggeringAction : gf.getEventTriggeringActions()) {
                    boolean eventDetectorApplicable =
                                    eventTriggeringAction.getLeft().accept(new PredicateEvaluator(gf)).booleanValue();
                    if (eventDetectorApplicable)
                        this.interpretAttachedAction(eventTriggeringAction.getRight(), gf);
                }
                
                actionsToPerform = gf.getDispatchStrategy().accept(evaluator);
            } catch (final NOIRInSoftException e) {
                throw e.getCause();
            }
            
            // place where breakpoints can be set
            // callContext, gf, actionsToPerform
            if (AddbServerAgent.DEBUG_MODE) {
                this.debugDataStore.getThread().pushFrame(new DispatchFrame(callContext, gf, actionsToPerform, evaluator));
                if (ADBreakpointManager.instance().matched(callContext)) {
                    AddbServerAgent.instance().getPacketSendManager().sendEvent(AddbEvent.REFRESH_DISPATCH);
                    try {
                        this.breakpointShadow();
                    } catch (ADBreakpointException e) {
                        // e.printStackTrace();
                    }
                }
            }
            
            final Object result = this.interpretAttachedActions(System.getInstance().schedule(actionsToPerform), gf);
            
            // place where the current liam model should be discarded
            if (AddbServerAgent.DEBUG_MODE) {
                this.debugDataStore.getThread().popFrame();
            }
            return result;
        } finally {
            this.popCallContext();
        }
    }
    
    private void breakpointShadow() throws ADBreakpointException {
        throw new ADBreakpointException();
    }
    
    private final ThreadLocal<Stack<ProceedClosure>> proceedToActionOrderElement = new ThreadLocal<Stack<ProceedClosure>>() {
        
        @Override
        protected Stack<ProceedClosure> initialValue() {
            return new Stack<ProceedClosure>();
        }
    };
    
    private Object interpretAttachedActions(final ActionOrderElement actions, final GenericFunction<?, ?> gf)
                    throws Throwable {
        Object result;
        for (final AttachedAction attachedAction : actions.getBefore()) {
            this.interpretAttachedAction(attachedAction, gf);
        }
        
        if (actions.getAround() != null) {
            this.proceedToActionOrderElement.get().push(new ProceedClosure(gf, actions.getInner(), this.getCallStackTop()));
            try {
                result = this.interpretAttachedAction(actions.getAround(), gf);
            } finally {
                this.proceedToActionOrderElement.get().pop();
            }
        } else if (actions.getInner() != null) {
            result = this.interpretAttachedActions(actions.getInner(), gf);
        } else {
            if (gf.getSignature().getReturnType() != TypeDescriptorConstants.VOID_PRIMITIVE)
                throw new UnsupportedOperationException(
                                "It is illegal to remove the 'around' action from a generic function call that has a return type other than void. ("
                                                + gf.getSignature() + ")");
            else
                result = null;
        }
        this.callStack.get().peek().setReturnValue(result);
        
        for (final AttachedAction attachedAction : actions.getAfter()) {
            this.interpretAttachedAction(attachedAction, gf);
        }
        
        return result;
    }
    
    private final Stack<AttachedAction> currentAttachedAction = new Stack<AttachedAction>();
    
    private Object interpretAttachedAction(final AttachedAction attachedAction, final GenericFunction<?, ?> gf)
                    throws Throwable {
        try {
            this.currentAttachedAction.push(attachedAction);
            
            // place where the debug liam model should be updated
            if (AddbServerAgent.DEBUG_MODE) {
                this.debugDataStore.getThread().peekFrame().setExecutingAction(attachedAction);
                if (!AddbServerAgent.hasWaited) {
                    synchronized (AddbServerAgent.lock) {
                        AddbServerAgent.instance().getPacketSendManager().sendEvent(AddbEvent.WAIT);
                        AddbServerAgent.lock.wait();
                    }
                } else {
                    AddbServerAgent.instance().getPacketSendManager().sendEvent(AddbEvent.REFRESH_ACTION);
                }
            }
            
            return this.compute(attachedAction.getAction(), gf);
        } finally {
            this.currentAttachedAction.pop();
        }
    }
    
    private GenericFunction<?, ?> findOrCreateGenericFunction(final CallContext callContext) {
        Member gfMember = null;
        if (callContext.callOpcode == Opcodes.INVOKEVIRTUAL) {
            final Class<?>[] parameterTypes = ClassLoading.classesFor(callContext.calleeArgumentTypes);
            Class<?> gfClass = ClassLoading.classFor(callContext.calleeClassDescriptor);
            while (gfClass != null) {
                try {
                    // if the class does not declare the method, an exception is thrown
                    // and no assignment is made
                    gfMember = gfClass.getDeclaredMethod(callContext.calleeName, parameterTypes);
                    // TODO: is this correct? we must go one level down in the hierarchy, assume: class A {private m;} class
                    // B extends A {public m;}
                    // B b; b.m(). Then B.m is the generic function
                    if (Modifier.isPrivate(gfMember.getModifiers()))
                        break;
                } catch (final SecurityException e) {
                    throw new RuntimeException(e);
                } catch (final NoSuchMethodException e) {
                    // ignore, this is OK
                }
                gfClass = gfClass.getSuperclass();
            }
        } else if (callContext.callOpcode == Opcodes.INVOKEINTERFACE) {
            final Class<?>[] parameterTypes = ClassLoading.classesFor(callContext.calleeArgumentTypes);
            Class<?> gfClass = ClassLoading.classFor(callContext.calleeClassDescriptor);
            try {
                // if the class does not declare the method, an exception is thrown
                // and no assignment is made
                gfMember = gfClass.getMethod(callContext.calleeName, parameterTypes);
            } catch (final SecurityException e) {
                throw new RuntimeException(e);
            } catch (final NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        } else if (callContext.callOpcode == Opcodes.INVOKESTATIC) {
            final Class<?>[] parameterTypes = ClassLoading.classesFor(callContext.calleeArgumentTypes);
            Class<?> gfClass = ClassLoading.classFor(callContext.calleeClassDescriptor);
            while (gfClass != null && gfMember == null) {
                try {
                    // if the class does not declare the method, an exception is thrown
                    // and no assignment is made
                    gfMember = gfClass.getDeclaredMethod(callContext.calleeName, parameterTypes);
                } catch (final SecurityException e) {
                    throw new RuntimeException(e);
                } catch (final NoSuchMethodException e) {
                    // ignore, this is OK
                }
                gfClass = gfClass.getSuperclass();
            }
        } else if (callContext.callOpcode == Opcodes.INVOKESPECIAL && !callContext.calleeName.equals("<init>")) {
            final Class<?>[] parameterTypes = ClassLoading.classesFor(callContext.calleeArgumentTypes);
            Class<?> gfClass = ClassLoading.classFor(callContext.calleeClassDescriptor);
            while (gfClass != null && gfMember == null) {
                try {
                    // if the class does not declare the method, an exception is thrown
                    // and no assignment is made
                    gfMember = gfClass.getDeclaredMethod(callContext.calleeName, parameterTypes);
                } catch (final SecurityException e) {
                    throw new RuntimeException(e);
                } catch (final NoSuchMethodException e) {
                    // ignore, this is OK
                }
                gfClass = gfClass.getSuperclass();
            }
        } else if (callContext.callOpcode == Opcodes.INVOKESPECIAL && callContext.calleeName.equals("<init>")) {
            try {
                Class<?>[] parameterTypes = ClassLoading.classesFor(callContext.calleeArgumentTypes);
                Class<?> gfClass = ClassLoading.classFor(callContext.calleeClassDescriptor);
                gfMember = gfClass.getDeclaredConstructor(parameterTypes);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        } else if (callContext.callOpcode == Opcodes.GETSTATIC || callContext.callOpcode == Opcodes.GETFIELD
                        || callContext.callOpcode == Opcodes.PUTSTATIC || callContext.callOpcode == Opcodes.PUTFIELD) {
            Class<?> gfClass = ClassLoading.classFor(callContext.calleeClassDescriptor);
            while (gfClass != null && gfMember == null) {
                try {
                    // if the class does not declare the method, an exception is thrown
                    // and no assignment is made
                    gfMember = gfClass.getDeclaredField(callContext.calleeName);
                } catch (final SecurityException e) {
                    throw new RuntimeException(e);
                } catch (final NoSuchFieldException e) {
                    // ignore, this is OK
                }
                gfClass = gfClass.getSuperclass();
            }
        } else {
            // not supported yet
            throw new UnsupportedOperationException();
        }
        if (!this.genericFunctions.containsKeys(gfMember, callContext.callOpcode)) {
            GenericFunction<?, ?> genericFunction;
            // TODO: if (callContext.callOpcode == Opcodes.INVOKESPECIAL && callContext.calleeName.equals("<init>"))
            if (callContext.callOpcode == Opcodes.INVOKEVIRTUAL || callContext.callOpcode == Opcodes.INVOKEINTERFACE
                            || (callContext.callOpcode == Opcodes.INVOKESPECIAL && !callContext.calleeName.equals("<init>"))
                            || callContext.callOpcode == Opcodes.INVOKESTATIC) {
                final Method gfMethod = (Method) gfMember;
                final MethodSignature signature =
                                SignatureFactory.findOrCreateMethodSignature(gfMethod.getModifiers(),
                                                TypeHierarchyProvider.findOrCreateFromClass(gfMethod.getDeclaringClass()),
                                                gfMethod.getName(),
                                                TypeHierarchyProvider.findOrCreateFromClass(gfMethod.getReturnType()),
                                                TypeHierarchyProvider.findOrCreateFromClasses(gfMethod.getParameterTypes()),
                                                TypeHierarchyProvider.findOrCreateFromClasses(gfMethod.getExceptionTypes()));
                ResolutionStrategy resolutionStrategy;
                if (callContext.callOpcode == Opcodes.INVOKESTATIC)
                    resolutionStrategy = ResolutionStrategy.STATIC;
                else if (callContext.callOpcode == Opcodes.INVOKESPECIAL)
                    resolutionStrategy = ResolutionStrategy.SPECIAL;
                else
                    resolutionStrategy = ResolutionStrategy.VIRTUAL;
                
                final GenericFunctionImpl<MethodSignature> gf =
                                new GenericFunctionImpl<MethodSignature>(signature, resolutionStrategy);
                this.addMethodCalls(Collections.<GenericFunction<MethodSignature, ?>>singleton(gf));
                genericFunction = gf;
            } else if (callContext.callOpcode == Opcodes.INVOKESPECIAL && callContext.calleeName.equals("<init>")) {
                final Constructor<?> gfConstructor = (Constructor<?>) gfMember;
                final ConstructorSignature signature =
                                SignatureFactory.findOrCreateConstructorSignature(gfConstructor.getModifiers(),
                                                TypeHierarchyProvider.findOrCreateFromClass(gfConstructor
                                                                .getDeclaringClass()), TypeHierarchyProvider
                                                                .findOrCreateFromClasses(gfConstructor.getParameterTypes()),
                                                TypeHierarchyProvider.findOrCreateFromClasses(gfConstructor
                                                                .getExceptionTypes()));
                ResolutionStrategy resolutionStrategy = ResolutionStrategy.SPECIAL;
                
                final GenericFunctionImpl<ConstructorSignature> gf =
                                new GenericFunctionImpl<ConstructorSignature>(signature, resolutionStrategy);
                this.addConstructorCalls(Collections.<GenericFunction<ConstructorSignature, ?>>singleton(gf));
                genericFunction = gf;
            } else if (callContext.callOpcode == Opcodes.GETFIELD || callContext.callOpcode == Opcodes.GETSTATIC) {
                final Field gfField = (Field) gfMember;
                final FieldReadSignature signature =
                                SignatureFactory.findOrCreateFieldReadSignature(gfField.getModifiers(),
                                                TypeHierarchyProvider.findOrCreateFromClass(gfField.getDeclaringClass()),
                                                gfField.getName(),
                                                TypeHierarchyProvider.findOrCreateFromClass(gfField.getType()));
                ResolutionStrategy resolutionStrategy;
                if (callContext.callOpcode == Opcodes.GETFIELD)
                    resolutionStrategy = ResolutionStrategy.VIRTUAL;
                else if (callContext.callOpcode == Opcodes.GETSTATIC)
                    resolutionStrategy = ResolutionStrategy.STATIC;
                else
                    throw new UnsupportedOperationException();
                final GenericFunctionImpl<FieldReadSignature> gf =
                                new GenericFunctionImpl<FieldReadSignature>(signature, resolutionStrategy);
                this.addFieldReads(Collections.<GenericFunction<FieldReadSignature, ?>>singleton(gf));
                genericFunction = gf;
            } else if (callContext.callOpcode == Opcodes.PUTFIELD || callContext.callOpcode == Opcodes.PUTSTATIC) {
                final Field gfField = (Field) gfMember;
                final FieldWriteSignature signature =
                                SignatureFactory.findOrCreateFieldWriteSignature(gfField.getModifiers(),
                                                TypeHierarchyProvider.findOrCreateFromClass(gfField.getDeclaringClass()),
                                                gfField.getName(),
                                                TypeHierarchyProvider.findOrCreateFromClass(gfField.getType()));
                ResolutionStrategy resolutionStrategy;
                if (callContext.callOpcode == Opcodes.PUTFIELD)
                    resolutionStrategy = ResolutionStrategy.VIRTUAL;
                else if (callContext.callOpcode == Opcodes.PUTSTATIC)
                    resolutionStrategy = ResolutionStrategy.STATIC;
                else
                    throw new UnsupportedOperationException();
                final GenericFunctionImpl<FieldWriteSignature> gf =
                                new GenericFunctionImpl<FieldWriteSignature>(signature, resolutionStrategy);
                this.addFieldWrites(Collections.<GenericFunction<FieldWriteSignature, ?>>singleton(gf));
                genericFunction = gf;
            } else {
                throw new UnsupportedOperationException();
            }
            this.genericFunctions.put(gfMember, callContext.callOpcode, genericFunction);
        }
        return this.genericFunctions.get(gfMember, callContext.callOpcode);
    }
    
    private final PairHashMap<Member, Integer, GenericFunction<?, ?>> genericFunctions =
                    new PairHashMap<Member, Integer, GenericFunction<?, ?>>();
    
    @Override
    public void substituteModifiedGenericFunctions(final Set<GenericFunction<?, ?>> affectedGenericFunctions) {
        // nothing to be done
    }
    
    public Object[] computeMultiple(final List<? extends ManageableInstance> entities, final Signed<?> genericFunctionCall)
                    throws Throwable {
        final List<Object> values = new ArrayList<Object>();
        for (final ManageableInstance entity : entities) {
            values.add(this.compute(entity, genericFunctionCall));
        }
        final Object[] result = new Object[values.size()];
        return values.toArray(result);
    }
    
    public Object compute(final ManageableInstance entity, final Signed<?> genericFunctionCall) throws Throwable {
        // possibly overridden by modified value in proceed
        if (entity instanceof Context) {
            try {
                return this.getCallStackTop().getModifiedValue((Context) entity);
            } catch (IllegalArgumentException e) {
                // No error, but the value for this context is not overridden
            }
        }
        
        // special cases
        if (entity instanceof ToArrayContext) {
            return this.computeMultiple(entity.getContexts(), genericFunctionCall);
        }
        if (entity instanceof Context && AllExposedContextsContext.isAllExposedContextsContext((Context) entity)) {
            return this.compute(this.currentAttachedAction.peek().getToArrayContextForExposedContexts(), genericFunctionCall);
        }
        // normal case
        final Method computeMethod;
        final Object[] arguments;
        try {
            final MethodSignature signature = entity.getMethodSignature(genericFunctionCall);
            computeMethod =
                            entity.getClass().getMethod(signature.getName().toString(),
                                            TypeHierarchyProvider.asClasses(signature.getParameterTypes()));
            computeMethod.setAccessible(true);
            arguments = this.computeMultiple(entity.getContexts(), genericFunctionCall);
        } catch (final NoSuchMethodException e) {
            throw new Error(e);
        } catch (final SecurityException e) {
            throw new Error(e);
        } catch (final ClassNotFoundException e) {
            throw new Error(e);
        }
        
        Object result;
        try {
            result = computeMethod.invoke(entity, arguments);
        } catch (final IllegalArgumentException e) {
            throw new Error(e);
        } catch (final IllegalAccessException e) {
            throw new Error(e);
        } catch (final InvocationTargetException e) {
            throw e.getTargetException();
        }
        return result;
    }
    
    @Override
    protected Object proceedImpl(Map<Context, ? extends Object> modifiedContexts) throws Throwable {
        ProceedClosure proceedActions = this.proceedToActionOrderElement.get().peek();
        if (this.getCallStackTop() != proceedActions.expectedCallContext)
            throw new IllegalStateException("Must only use proceed directly within an around advice.");
        this.getCallStackTop().pushModifiedContexts(modifiedContexts);
        try {
            return this.interpretAttachedActions(proceedActions.proceedToActionOrderElement, proceedActions.callSite);
        } finally {
            this.getCallStackTop().popModifiedContexts();
        }
    }
    
}
