package org.alia4j.liam.signature;

import java.util.HashMap;
import java.util.Map;
import org.alia4j.hierarchy.TypeDescriptor;

public final class SignatureFactory {
    
    private static Map<ConstructorSignature, ConstructorSignature> canonizedConstructorSignatures =
                    new HashMap<ConstructorSignature, ConstructorSignature>();
    
    public static ConstructorSignature findOrCreateConstructorSignature(final int modifiers,
                    final TypeDescriptor declaringClassDescriptor, final TypeDescriptor[] parameterTypeDescriptors,
                    final TypeDescriptor[] exceptionTypeDescriptors) {
        final ConstructorSignature candidate =
                        new ConstructorSignature(modifiers, declaringClassDescriptor, parameterTypeDescriptors,
                                        exceptionTypeDescriptors);
        if (SignatureFactory.canonizedConstructorSignatures.containsKey(candidate))
            return SignatureFactory.canonizedConstructorSignatures.get(candidate);
        else {
            SignatureFactory.canonizedConstructorSignatures.put(candidate, candidate);
            return candidate;
        }
    }
    
    private static Map<FieldReadSignature, FieldReadSignature> canonizedFieldReadSignatures =
                    new HashMap<FieldReadSignature, FieldReadSignature>();
    
    public static FieldReadSignature findOrCreateFieldReadSignature(final int modifiers,
                    final TypeDescriptor declaringClassDescriptor, final CharSequence fieldName,
                    final TypeDescriptor fieldTypeDescriptor) {
        final FieldReadSignature candidate =
                        new FieldReadSignature(modifiers, declaringClassDescriptor, fieldName, fieldTypeDescriptor);
        if (SignatureFactory.canonizedFieldReadSignatures.containsKey(candidate))
            return SignatureFactory.canonizedFieldReadSignatures.get(candidate);
        else {
            SignatureFactory.canonizedFieldReadSignatures.put(candidate, candidate);
            return candidate;
        }
    }
    
    private static Map<FieldWriteSignature, FieldWriteSignature> canonizedFieldWriteSignatures =
                    new HashMap<FieldWriteSignature, FieldWriteSignature>();
    
    public static FieldWriteSignature findOrCreateFieldWriteSignature(final int modifiers,
                    final TypeDescriptor declaringClassDescriptor, final CharSequence fieldName,
                    final TypeDescriptor fieldTypeDescriptor) {
        final FieldWriteSignature candidate =
                        new FieldWriteSignature(modifiers, declaringClassDescriptor, fieldName, fieldTypeDescriptor);
        if (SignatureFactory.canonizedFieldWriteSignatures.containsKey(candidate))
            return SignatureFactory.canonizedFieldWriteSignatures.get(candidate);
        else {
            SignatureFactory.canonizedFieldWriteSignatures.put(candidate, candidate);
            return candidate;
        }
    }
    
    private static Map<MethodSignature, MethodSignature> canonizedMethodSignatures =
                    new HashMap<MethodSignature, MethodSignature>();
    
    public static MethodSignature findOrCreateMethodSignature(final int modifiers,
                    final TypeDescriptor declaringClassDescriptor, final CharSequence methodName,
                    final TypeDescriptor resultType, final TypeDescriptor[] parameterTypeDescriptors,
                    final TypeDescriptor[] exceptionTypeDescriptors) {
        final MethodSignature candidate =
                        new MethodSignature(modifiers, declaringClassDescriptor, methodName, resultType,
                                        parameterTypeDescriptors, exceptionTypeDescriptors);
        if (SignatureFactory.canonizedMethodSignatures.containsKey(candidate))
            return SignatureFactory.canonizedMethodSignatures.get(candidate);
        else {
            SignatureFactory.canonizedMethodSignatures.put(candidate, candidate);
            return candidate;
        }
    }
    
    private static Map<TypeDescriptor, StaticInitializerSignature> canonizedStaticInitializers =
                    new HashMap<TypeDescriptor, StaticInitializerSignature>();
    
    public static StaticInitializerSignature findOrCreateStaticInitializerSignature(
                    final TypeDescriptor declaringClassDescriptor) {
        if (!SignatureFactory.canonizedStaticInitializers.containsKey(declaringClassDescriptor)) {
            SignatureFactory.canonizedStaticInitializers.put(declaringClassDescriptor, new StaticInitializerSignature(
                            declaringClassDescriptor));
        }
        return SignatureFactory.canonizedStaticInitializers.get(declaringClassDescriptor);
    }
    
}
