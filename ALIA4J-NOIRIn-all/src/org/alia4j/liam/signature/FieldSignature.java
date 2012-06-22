package org.alia4j.liam.signature;

import java.lang.reflect.Modifier;
import org.alia4j.hierarchy.TypeDescriptor;

public abstract class FieldSignature extends Signature {
    
    /**
     * @param modifiers see {@link Modifier}
     * @param declaringClass may not be {@code null}
     * @param name may not be {@code null}
     * @param type may not be {@code null}
     */
    FieldSignature(final int modifiers, final TypeDescriptor declaringClass, final CharSequence name,
                    final TypeDescriptor type) {
        super(modifiers, declaringClass, name);
        if (type == null)
            throw new RuntimeException("Type may not be null.");
        this.type = type;
    }
    
    public TypeDescriptor getType() {
        return this.type;
    }
    
    private final TypeDescriptor type;
    
    @Override
    public String toString() {
        return Modifier.toString(this.getModifiers()) + " " + this.getType() + " " + this.getDeclaringClass() + "."
                        + this.getName();
    }
    
}
