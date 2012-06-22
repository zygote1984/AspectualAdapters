package org.alia4j.liam.predicate;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public class MethodPredicate extends AtomicPredicate {
    
    private final TypeDescriptor fullyQualifiedDeclaringClass;
    
    private final CharSequence methodName;
    
    private Method method;
    
    private Object receiver;
    
    private final TypeDescriptor factoryClassName;
    
    private final CharSequence factoryMethodName;
    
    protected MethodPredicate(final TypeDescriptor declaringClass, final CharSequence methodName,
                    final TypeDescriptor factoryClassName, final CharSequence factoryMethodName) {
        super(Collections.<Context>emptyList());
        this.fullyQualifiedDeclaringClass = declaringClass;
        this.methodName = methodName;
        this.factoryClassName = factoryClassName;
        this.factoryMethodName = factoryMethodName;
    }
    
    public boolean isSatisfied() {
        if (this.method == null) {
            try {
                final Class<?> clazz = this.fullyQualifiedDeclaringClass.asClass();
                this.method = clazz.getDeclaredMethod(this.methodName.toString());
                
                final Class<?> factoryClass = this.factoryClassName.asClass();
                // the factory method is supposed to be static and taking no arguments
                this.receiver = factoryClass.getDeclaredMethod(this.factoryMethodName.toString()).invoke(null);
            } catch (final Exception exception) {
                throw new RuntimeException(exception);
            }
        }
        try {
            return (Boolean) this.method.invoke(this.receiver);
        } catch (final Exception exception) {
            throw new RuntimeException(exception);
        }
    }
    
    @Override
    public Maybe<Boolean> computeIsSatisfiedStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Boolean>();
    }
    
    @Override
    public int estimateRuntimeCost() {
        return 1;
    }
    
    @Override
    public String toString() {
        return "((" + this.fullyQualifiedDeclaringClass + ") " + this.factoryClassName + "." + this.factoryMethodName
                        + "())." + this.methodName;
    }
}
