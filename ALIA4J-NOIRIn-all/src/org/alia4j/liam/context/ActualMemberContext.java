package org.alia4j.liam.context;

import java.util.Arrays;
import java.util.List;
import org.alia4j.hierarchy.Resolution;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.CallSiteInfo;
import org.alia4j.liam.signature.ConstructorSignature;
import org.alia4j.liam.signature.FieldSignature;
import org.alia4j.liam.signature.MethodSignature;
import org.alia4j.liam.signature.Signed;
import org.alia4j.liam.signature.StaticInitializerSignature;
import org.alia4j.util.Maybe;

public class ActualMemberContext extends Context {
    
    protected ActualMemberContext() {
        super(Arrays.asList(ContextFactory.findOrCreateCallApproximationContext(), ContextFactory
                        .findOrCreateCalleeContext()));
    }
    
    @Override
    public Maybe<? extends Object> computeValueStatically(List<? extends Signed<?>> callStack) {
        return new Maybe<Object>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(Signed<?> genericFunction) {
        return SimpleType.REFERENCE;
    }
    
    public Object getObjectValue(Object callApproximationObject, Object callee) {
        CallSiteInfo callSiteInfo = (CallSiteInfo) callApproximationObject;
        
        Object result = null;
        try {
            if (callSiteInfo.getSignature() instanceof FieldSignature) {
                FieldSignature fieldSignature = (FieldSignature) callSiteInfo.getSignature();
                result = Resolution.resolveField(callee.getClass(), fieldSignature.getName(), fieldSignature.getType());
            } else if (callSiteInfo.getSignature() instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) callSiteInfo.getSignature();
                if (callSiteInfo.getCalleeType() == null)
                    throw new Error("Callee type not known.");
                result =
                                Resolution.resolveActualMethod(callSiteInfo.getCalleeType().asClass(),
                                                methodSignature.getName(), methodSignature.getReturnType(), methodSignature
                                                                .getParameterTypes());
            } else if (callSiteInfo.getSignature() instanceof ConstructorSignature) {
                ConstructorSignature constructorSignature = (ConstructorSignature) callSiteInfo.getSignature();
                result =
                                Resolution.resolveConstructor(constructorSignature.getDeclaringClass(), constructorSignature
                                                .getParameterTypes());
            } else if (callSiteInfo.getSignature() instanceof StaticInitializerSignature) {
                StaticInitializerSignature staticInitializerSignature =
                                (StaticInitializerSignature) callSiteInfo.getSignature();
                result = staticInitializerSignature.getDeclaringClass().asClass();
            } else {
                throw new Error("Unsupported signature: " + callSiteInfo.getSignature() + ".");
            }
            
            if (result == null)
                throw new Error("Cannot resolve top method for " + callSiteInfo + " in class " + callee.getClass()
                                + ".");
            
            return result;
        } catch (ClassNotFoundException e) {
            throw new Error(e);
        }
    }
    
}
