package org.alia4j.liam.signature;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeDescriptorConstants;

public final class MethodSignature extends Signature {
    
    /**
     * @param modifiers see {@link Modifier}
     * @param declaringClass may not be {@code null}
     * @param name may not be {@code null}
     * @param returnType may not be {@code null}
     * @param parameterTypes may be {@code null}, which is equivalent to passing an empty array.
     * @param exceptionTypes may be {@code null}, which is equivalent to passing an empty array.
     */
    MethodSignature(final int modifiers, final TypeDescriptor declaringClass, final CharSequence name,
                    final TypeDescriptor returnType, final TypeDescriptor[] parameterTypes,
                    final TypeDescriptor[] exceptionTypes) {
        super(modifiers, declaringClass, name);
        this.returnType = returnType;
        this.parameterTypes = parameterTypes == null ? TypeDescriptorConstants.NO_ARG : parameterTypes;
        this.exceptionTypes = exceptionTypes == null ? TypeDescriptorConstants.NO_ARG : exceptionTypes;
    }
    
    @Override
    public TypeDescriptor getReturnType() {
        return this.returnType;
    }
    
    private final TypeDescriptor returnType;
    
    public TypeDescriptor[] getParameterTypes() {
        return this.parameterTypes;
    }
    
    private final TypeDescriptor[] parameterTypes;
    
    public TypeDescriptor[] getExceptionTypes() {
        return this.exceptionTypes;
    }
    
    private final TypeDescriptor[] exceptionTypes;
    
    @Override
    public String toString() {
        String result =
                        Modifier.toString(this.getModifiers()) + " " + this.getReturnType() + " " + this.getDeclaringClass()
                                        + "." + this.getName() + "(";
        for (int i = 0; i < this.parameterTypes.length; i++) {
            result += this.parameterTypes[i];
            if (i + 1 < this.parameterTypes.length)
                result += ", ";
        }
        result += ")";
        for (int i = 0; i < this.exceptionTypes.length; i++) {
            if (i == 0)
                result += " throws ";
            else
                result += ", ";
            result += this.exceptionTypes[i];
        }
        return result;
    }
    
    @Override
    public <T> T accept(final SignatureProcessor<T> processor) {
        return processor.process(this);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(this.exceptionTypes);
        result = prime * result + Arrays.hashCode(this.parameterTypes);
        result = prime * result + ((this.returnType == null) ? 0 : this.returnType.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        final MethodSignature other = (MethodSignature) obj;
        if (!Arrays.equals(this.exceptionTypes, other.exceptionTypes))
            return false;
        if (!Arrays.equals(this.parameterTypes, other.parameterTypes))
            return false;
        if (this.returnType == null) {
            if (other.returnType != null)
                return false;
        } else if (!this.returnType.equals(other.returnType))
            return false;
        return true;
    }
    
}
