package org.alia4j.noirin.context;

import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.CallSiteInfo;
import org.alia4j.liam.signature.ResolutionStrategy;
import org.alia4j.liam.signature.Signature;
import org.alia4j.liam.signature.Signed;
import org.alia4j.noirin.CallContext;
import org.alia4j.noirin.SystemImpl;
import org.alia4j.util.Maybe;
import org.objectweb.asm.Opcodes;

public class CallApproximationContext extends Context {
    
    protected CallApproximationContext() {
        super(Collections.singletonList(ContextFactory.findOrCreateSignatureContext()));
    }
    
    @Override
    public Maybe<? extends Object> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<CallSiteInfo>();
    }
    
    @Override
    public TypeDescriptor approximateValueTypeStatically(final List<? extends Signed<?>> callStack) {
        return TypeHierarchyProvider.findOrCreateFromClass(CallSiteInfo.class);
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    public Object getObjectValue(Object signatureObject) {
        ResolutionStrategy resolutionStrategy;
        CallContext callContext = SystemImpl.getSingletonSystemImpl().getCallStackTop();
        switch (callContext.callOpcode) {
        case Opcodes.INVOKEVIRTUAL:
        case Opcodes.PUTFIELD:
        case Opcodes.GETFIELD:
            resolutionStrategy = ResolutionStrategy.VIRTUAL;
            break;
        case Opcodes.INVOKESTATIC:
        case Opcodes.PUTSTATIC:
        case Opcodes.GETSTATIC:
            resolutionStrategy = ResolutionStrategy.STATIC;
            break;
        case Opcodes.INVOKESPECIAL:
            resolutionStrategy = ResolutionStrategy.SPECIAL;
            break;
        case Opcodes.INVOKEINTERFACE:
            resolutionStrategy = ResolutionStrategy.INTERFACE;
            break;
        default:
            throw new Error("Unsupported bytecode instruction at dispatch call site.");
        }
        
        return new CallSiteInfo(resolutionStrategy, (Signature) signatureObject,
                        TypeHierarchyProvider.findOrCreateFromClass(callContext.callerClass),
                        TypeHierarchyProvider.findOrCreateFromTypeDescriptor(callContext.calleeClassDescriptor));
    }
    
}
