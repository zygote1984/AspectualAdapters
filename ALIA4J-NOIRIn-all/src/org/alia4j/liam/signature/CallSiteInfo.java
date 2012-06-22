package org.alia4j.liam.signature;

import org.alia4j.hierarchy.TypeDescriptor;

public class CallSiteInfo {
    
    private final ResolutionStrategy resolutionStrategy;
    
    private final Signature signature;
    
    private final TypeDescriptor callerType;
    
    private final TypeDescriptor calleeType;
    
    public CallSiteInfo(ResolutionStrategy resolutionStrategy, Signature signature, TypeDescriptor callerType,
                    TypeDescriptor calleeType) {
        super();
        this.resolutionStrategy = resolutionStrategy;
        this.signature = signature;
        this.callerType = callerType;
        this.calleeType = calleeType;
    }
    
    public ResolutionStrategy getResolutionStrategy() {
        return this.resolutionStrategy;
    }
    
    public Signature getSignature() {
        return this.signature;
    }
    
    public TypeDescriptor getCallerType() {
        return this.callerType;
    }
    
    public TypeDescriptor getCalleeType() {
        return this.calleeType;
    }
}
