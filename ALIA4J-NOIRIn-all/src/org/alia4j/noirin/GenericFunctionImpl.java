package org.alia4j.noirin;

import org.alia4j.fial.GenericFunction;
import org.alia4j.liam.Action;
import org.alia4j.liam.ActionFactory;
import org.alia4j.liam.signature.ConstructorSignature;
import org.alia4j.liam.signature.FieldReadSignature;
import org.alia4j.liam.signature.FieldWriteSignature;
import org.alia4j.liam.signature.MethodSignature;
import org.alia4j.liam.signature.ResolutionStrategy;
import org.alia4j.liam.signature.Signature;
import org.alia4j.liam.signature.SignatureProcessor;
import org.alia4j.liam.signature.StaticInitializerSignature;

class GenericFunctionImpl<S extends Signature> extends GenericFunction<S, ResolutionStrategy> {
    
    protected GenericFunctionImpl(final S signature, final ResolutionStrategy ResolutionStrategy) {
        super(signature, ResolutionStrategy);
    }
    
    @Override
    protected SignatureProcessor<Action> getSignatureToImplicitActionProcessor() {
        return new SignatureProcessor<Action>() {
            
            @Override
            public Action process(ConstructorSignature signature) {
                return ActionFactory.findOrCreateConstructorCallAction(signature.getDeclaringClass(),
                                signature.getParameterTypes());
            }
            
            @Override
            public Action process(StaticInitializerSignature signature) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public Action process(MethodSignature signature) {
                return ActionFactory.findOrCreateMethodCallAction(signature.getDeclaringClass(), signature.getName(),
                                signature.getParameterTypes(), signature.getReturnType(),
                                GenericFunctionImpl.this.getImplementationSpecificInfo(), null);
            }
            
            @Override
            public Action process(FieldReadSignature signature) {
                return ActionFactory.findOrCreateFieldReadAction(signature.getDeclaringClass(), signature.getName(),
                                signature.getType(), GenericFunctionImpl.this.getImplementationSpecificInfo());
            }
            
            @Override
            public Action process(FieldWriteSignature signature) {
                return ActionFactory.findOrCreateFieldWriteAction(signature.getDeclaringClass(), signature.getName(),
                                signature.getType(), GenericFunctionImpl.this.getImplementationSpecificInfo());
            }
        };
    }
    
}
