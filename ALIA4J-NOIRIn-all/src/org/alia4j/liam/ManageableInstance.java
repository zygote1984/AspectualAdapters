package org.alia4j.liam;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.signature.MethodSignature;
import org.alia4j.liam.signature.SignatureFactory;
import org.alia4j.liam.signature.Signed;

/**
 * @author Andreas Sewe
 */
public abstract class ManageableInstance {
    
    public ManageableInstance(final List<? extends Context> contexts) {
        if (contexts == null)
            throw new IllegalArgumentException();
        this.contexts = Collections.unmodifiableList(contexts);
        this.id = EntityRegistry.storeInstanceAtId(this);
    }
    
    public List<? extends Context> getContexts() {
        return this.contexts;
    }
    
    private final List<? extends Context> contexts;
    
    public final MethodSignature getMethodSignature(final Signed<?> genericFunction) {
        final TypeDescriptor declaringClass = TypeHierarchyProvider.findOrCreateFromClass(this.getClass());
        final CharSequence methodName = this.getMethodName(genericFunction);
        final TypeDescriptor resultType = this.getDeclaredResultType(genericFunction).getTypeReference();
        final TypeDescriptor[] parameterTypes = this.getDeclaredParameterTypes(genericFunction);
        return SignatureFactory.findOrCreateMethodSignature(Modifier.PUBLIC, declaringClass, methodName, resultType,
                        parameterTypes, null);
    }
    
    protected abstract CharSequence getMethodName(Signed<?> genericFunction);
    
    private final TypeDescriptor[] getDeclaredParameterTypes(final Signed<?> genericFunction) {
        final TypeDescriptor[] result = new TypeDescriptor[this.getContexts().size()];
        for (int i = 0; i < this.getContexts().size(); i++)
            result[i] = this.getContexts().get(i).getDeclaredResultType(genericFunction).getTypeReference();
        return result;
    }
    
    /**
     * Returns the simple type (i.e., one of the primitives or reference type) of value returned by the method. It may depend
     * on the generic function at whose dispatch the value is to be retrieved.
     * 
     * @param genericFunction the generic function at whose dispatch the value is to be retrieved
     * @return the value type.
     */
    public abstract SimpleType getDeclaredResultType(Signed<?> genericFunction);
    
    public int getId() {
        return this.id;
    }
    
    private final int id;
    
    @Override
    /**
     * Manageable instance must be canonized by their respective factory.
     */
    final public boolean equals(final Object obj) {
        return super.equals(obj);
    }
    
    @Override
    /**
     * Manageable instance must be canonized by their respective factory.
     */
    final public int hashCode() {
        return super.hashCode();
    }
}
