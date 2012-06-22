package org.alia4j.liam.signature;

import java.lang.reflect.Modifier;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeDescriptorConstants;

public final class FieldWriteSignature extends FieldSignature {
    
    /**
     * @param modifiers see {@link Modifier}
     * @param declaringClass may not be {@code null}
     * @param name may not be {@code null}
     * @param type may not be {@code null}
     */
    FieldWriteSignature(final int modifiers, final TypeDescriptor declaringClass, final CharSequence name,
                    final TypeDescriptor type) {
        super(modifiers, declaringClass, name, type);
    }
    
    @Override
    public TypeDescriptor getReturnType() {
        return TypeDescriptorConstants.VOID_PRIMITIVE;
    }
    
    @Override
    public String toString() {
        return "Write: " + super.toString();
    }
    
    @Override
    public <T> T accept(final SignatureProcessor<T> processor) {
        return processor.process(this);
    }
    
}
