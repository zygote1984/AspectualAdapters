package org.alia4j.liam.signature;

import java.lang.reflect.Modifier;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeDescriptorConstants;

public final class StaticInitializerSignature extends Signature {
    
    /**
     * @param declaringClass may not be {@code null}.
     */
    StaticInitializerSignature(final TypeDescriptor declaringClass) {
        super(Modifier.STATIC | Modifier.PUBLIC, declaringClass, "<clinit>");
    }
    
    @Override
    public TypeDescriptor getReturnType() {
        return TypeDescriptorConstants.VOID_PRIMITIVE;
    }
    
    @Override
    public String toString() {
        return "Static initializer: " + this.getDeclaringClass();
    }
    
    @Override
    public <T> T accept(final SignatureProcessor<T> processor) {
        return processor.process(this);
    }
    
}
