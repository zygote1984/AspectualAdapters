package org.alia4j.noirin;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.alia4j.fial.GenericFunction;
import org.alia4j.liam.Context;
import org.alia4j.liam.event.EventSignature;

final public class CallContext {
    
    final public Object callee;
    
    final public Object[] calleeArguments;
    
    final public Object[] callerLocals;
    
    final public String calleeClassDescriptor;
    
    final public String calleeName;
    
    final public String[] calleeArgumentTypes;
    
    final public String calleeReturnTypeName;
    
    final public String[] callerLocalsTypes;
    
    final public String[] callerLocalsNames;
    
    final public int callLineNumber;
    
    final public Class<?> callerClass;
    
    final public String callerName;
    
    final public String[] callerArgumentTypes;
    
    final public String callerReturnType;
    
    final public String callerFileName;
    
    final public Thread callThread;
    
    final public int callOpcode;
    
    public final int callerMethodModifiers;
    
    public final int[] callerLocalsIndexes;
    
    public final Object[] callerRawLocals;
    
    public CallContext(final Object callee, final Object[] arguments, final Object[] localVariables,
                    final String declaringClassName, final String name, final String[] argumentTypes,
                    final String returnTypeName, final String[] localVariableTypeNames, final String[] localVariableNames,
                    int[] localVariableIndexes, Object[] rawLocalVariables, final int lineNumber,
                    final Class<?> callingClass, final String callingMethodName,
                    final String[] callingMethodArgumentTypeNames, final String callingMethodReturnTypeName,
                    final int callingMethodModifiers, final String callingFileName, final Thread thread, final int callOpcode) {
        this.callee = callee;
        this.calleeArguments = arguments;
        this.callerLocals = localVariables;
        this.calleeClassDescriptor = declaringClassName;
        this.calleeName = name;
        this.calleeArgumentTypes = argumentTypes;
        this.calleeReturnTypeName = returnTypeName;
        this.callerLocalsTypes = localVariableTypeNames;
        this.callerLocalsNames = localVariableNames;
        this.callerLocalsIndexes = localVariableIndexes;
        this.callerRawLocals = rawLocalVariables;
        this.callLineNumber = lineNumber;
        this.callerClass = callingClass;
        this.callerName = callingMethodName;
        this.callerArgumentTypes = callingMethodArgumentTypeNames;
        this.callerReturnType = callingMethodReturnTypeName;
        this.callerMethodModifiers = callingMethodModifiers;
        this.callerFileName = callingFileName;
        this.callThread = thread;
        this.callOpcode = callOpcode;
    }
    
    private Object returnValue;
    
    private boolean returnValueSet;
    
    public Object getReturnValue() {
        if (!this.returnValueSet)
            throw new IllegalStateException("Not yet in the returning flow.");
        return this.returnValue;
    }
    
    void setReturnValue(final Object v) {
        this.returnValue = v;
        this.returnValueSet = true;
    }
    
    private GenericFunction<?, ?> calleeGenericFunction;
    
    private boolean calleeGenericFunctionSet;
    
    public GenericFunction<?, ?> getCalleeGenericFunction() {
        if (!this.calleeGenericFunctionSet)
            throw new IllegalStateException();
        return this.calleeGenericFunction;
    }
    
    void setCalleeGenericFunction(final GenericFunction<?, ?> calleeGenericFunction) {
        this.calleeGenericFunction = calleeGenericFunction;
        this.calleeGenericFunctionSet = true;
    }
    
    public EventTriggeringInfo findOrCreateEventTriggerInfo(EventSignature eventSignature) {
        if (!this.eventTriggeringInfos.containsKey(eventSignature)) {
            this.eventTriggeringInfos.put(eventSignature, new EventTriggeringInfo(eventSignature));
        }
        return this.eventTriggeringInfos.get(eventSignature);
    }
    
    private final Map<EventSignature, EventTriggeringInfo> eventTriggeringInfos =
                    new HashMap<EventSignature, EventTriggeringInfo>();
    
    private Stack<Map<Context, ? extends Object>> proceedModifications = null;
    
    public void pushModifiedContexts(Map<Context, ? extends Object> modifiedContexts) {
        if (this.proceedModifications == null)
            this.proceedModifications = new Stack<Map<Context, ? extends Object>>();
        this.proceedModifications.push(modifiedContexts);
    }
    
    public void popModifiedContexts() {
        if (this.proceedModifications == null)
            throw new IllegalStateException();
        this.proceedModifications.pop();
    }
    
    public Object getModifiedValue(Context context) throws IllegalArgumentException {
        if (this.proceedModifications == null)
            throw new IllegalArgumentException("No modification for passed Context.");
        
        for (int i = this.proceedModifications.size() - 1; i >= 0; i--) {
            Map<Context, ? extends Object> map = this.proceedModifications.get(i);
            if (map.containsKey(context))
                return map.get(context);
        }
        throw new IllegalArgumentException("No modification for passed Context.");
    }
    
}
