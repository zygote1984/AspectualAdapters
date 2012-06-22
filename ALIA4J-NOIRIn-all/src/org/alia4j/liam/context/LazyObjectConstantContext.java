package org.alia4j.liam.context;

import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * Note that two object constant contexts are equal iff if the refer to the <em>same</em> object.
 * 
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public class LazyObjectConstantContext extends Context {
    
    protected LazyObjectConstantContext(final TypeDescriptor classDescriptor) {
        super(Collections.<Context>emptyList());
        if (classDescriptor == null)
            throw new IllegalArgumentException();
        this.classDescriptor = classDescriptor;
    }
    
    private final TypeDescriptor classDescriptor;
    
    private Object singleton;
    
    @Override
    public Maybe<Object> computeValueStatically(final List<? extends Signed<?>> callStack) {
        if (this.singleton == null) {
            return new Maybe<Object>();
        } else {
            return new Maybe<Object>(this.singleton);
        }
    }
    
    @Override
    public TypeDescriptor approximateValueTypeStatically(final List<? extends Signed<?>> callStack) {
        return this.classDescriptor;
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    public final Object getObjectValue() {
        if (this.singleton == null) {
            try {
                // XXX Add class loader awareness.
                final Class<?> clazz = this.classDescriptor.asClass();
                this.singleton = clazz.newInstance();
            } catch (final ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (final IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (final InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
        return this.singleton;
    }
    
    @Override
    public String toString() {
        return "${" + this.classDescriptor + "}";
    }
    
}
