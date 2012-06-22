package org.alia4j.noirin.typehierarchy;

import org.alia4j.hierarchy.CanonizingTypeHierarchyProvider;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.noirin.Agent;

public class TypeHierarchyProviderImpl extends CanonizingTypeHierarchyProvider {
    
    public static void initialize() {
        new TypeHierarchyProviderImpl();
    }
    
    private TypeHierarchyProviderImpl() {}
    
    @Override
    protected Class<?> getLoadedClassImpl(final TypeDescriptor typeDescriptor) throws IllegalStateException {
        for (final Class<?> current : Agent.getLoadedClasses()) {
            if (TypeHierarchyProvider.findOrCreateFromClass(current).equals(typeDescriptor))
                return current;
        }
        throw new IllegalStateException("Class not yet loaded (" + typeDescriptor + ").");
    }
    
}
