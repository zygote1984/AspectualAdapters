package org.alia4j.liam.signature;

import java.lang.reflect.Modifier;
import org.alia4j.hierarchy.TypeDescriptor;

public final class FieldReadSignature extends FieldSignature {
    
    /**
     * @param modifiers see {@link Modifier}
     * @param declaringClass may not be {@code null}
     * @param name may not be {@code null}
     * @param type may not be {@code null}
     */
    FieldReadSignature(final int modifiers, final TypeDescriptor declaringClass, final CharSequence name,
                    final TypeDescriptor type) {
        super(modifiers, declaringClass, name, type);
    }
    
    @Override
    public TypeDescriptor getReturnType() {
        return this.getType();
    }
    
    @Override
    public String toString() {
        return "Read: " + super.toString();
    }
    
    @Override
    public <T> T accept(final SignatureProcessor<T> processor) {
        return processor.process(this);
    }
    
}
