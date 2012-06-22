package org.alia4j.liam.context;

import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
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
public class ObjectConstantContext extends Context {
    
    private final Object value;
    
    protected ObjectConstantContext(final Object value) {
        super(Collections.<Context>emptyList());
        this.value = value;
    }
    
    @Override
    public Maybe<Object> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Object>(this.value);
    }
    
    @Override
    public TypeDescriptor approximateValueTypeStatically(final List<? extends Signed<?>> callStack) {
        return TypeHierarchyProvider.findOrCreateFromClass(this.value.getClass());
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    public final Object getObjectValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return "${" + this.value + "}";
    }
}
