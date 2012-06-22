package org.alia4j.aspectj.model.context;

import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.ConstructorSignature;
import org.alia4j.liam.signature.FieldReadSignature;
import org.alia4j.liam.signature.FieldSignature;
import org.alia4j.liam.signature.FieldWriteSignature;
import org.alia4j.liam.signature.MethodSignature;
import org.alia4j.liam.signature.Signed;
import org.alia4j.liam.signature.StaticInitializerSignature;
import org.alia4j.util.Maybe;
import org.aspectj.lang.Signature;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class AspectJSignatureContext extends Context {
    
    protected AspectJSignatureContext() {
        super(Collections.singletonList(ContextFactory.findOrCreateSignatureContext()));
    }
    
    @Override
    public TypeDescriptor approximateValueTypeStatically(final List<? extends Signed<?>> callStack) {
        final TypeDescriptor liamSignatureType = this.getContexts().get(0).approximateValueTypeStatically(callStack);
        if (liamSignatureType == TypeHierarchyProvider.findOrCreateFromClass(FieldReadSignature.class)
                        || liamSignatureType == TypeHierarchyProvider.findOrCreateFromClass(FieldWriteSignature.class)) {
            return TypeHierarchyProvider.findOrCreateFromClass(org.aspectj.lang.reflect.FieldSignature.class);
        } else if (liamSignatureType == TypeHierarchyProvider.findOrCreateFromClass(MethodSignature.class)) {
            return TypeHierarchyProvider.findOrCreateFromClass(org.aspectj.lang.reflect.MethodSignature.class);
        } else if (liamSignatureType == TypeHierarchyProvider.findOrCreateFromClass(ConstructorSignature.class)) {
            return TypeHierarchyProvider.findOrCreateFromClass(org.aspectj.lang.reflect.ConstructorSignature.class);
        } else {
            throw new IllegalArgumentException("LIAM Signature type not supported.");
        }
    }
    
    public Object getObjectValue(final Object liamSignatureObject) throws SecurityException, NoSuchFieldException,
                    ClassNotFoundException, NoSuchMethodException {
        final org.alia4j.liam.signature.Signature liamSignature = (org.alia4j.liam.signature.Signature) liamSignatureObject;
        if (liamSignature instanceof FieldSignature) {
            return new FieldSignatureImpl(liamSignature.getDeclaringClass().asClass().getDeclaredField(
                            liamSignature.getName().toString()));
        } else if (liamSignature instanceof MethodSignature) {
            return new MethodSignatureImpl(liamSignature.getDeclaringClass().asClass().getDeclaredMethod(
                            liamSignature.getName().toString(),
                            TypeHierarchyProvider.asClasses(((MethodSignature) liamSignature).getParameterTypes())));
        } else if (liamSignature instanceof ConstructorSignature) {
            return new ConstructorSignatureImpl(liamSignature.getDeclaringClass().asClass().getDeclaredConstructor(
                            TypeHierarchyProvider.asClasses(((MethodSignature) liamSignature).getParameterTypes())));
        } else if (liamSignature instanceof StaticInitializerSignature) {
            return new InitializerSignatureImpl(liamSignature.getDeclaringClass().asClass());
        } else {
            throw new IllegalArgumentException("Cannot translate signature of type " + liamSignature.getClass() + " ("
                            + liamSignature + ").");
        }
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    @Override
    public Maybe<Signature> computeValueStatically(final List<? extends Signed<?>> callStack) {
        if (this.getContexts().get(0).computeValueStatically(callStack).isUnknown())
            return new Maybe<Signature>();
        
        final Object value = this.getContexts().get(0).computeValueStatically(callStack).getValue();
        try {
            return new Maybe<Signature>((Signature) this.getObjectValue(value));
        } catch (final SecurityException e) {
            return new Maybe<Signature>();
        } catch (final NoSuchFieldException e) {
            return new Maybe<Signature>();
        } catch (final ClassNotFoundException e) {
            return new Maybe<Signature>();
        } catch (final NoSuchMethodException e) {
            return new Maybe<Signature>();
        }
    }
    
    @Override
    public String toString() {
        return "AspectJ signature context";
    }
}
