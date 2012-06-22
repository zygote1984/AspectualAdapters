package org.alia4j.hierarchy;

import java.util.HashMap;
import java.util.Map;

public abstract class CanonizingTypeHierarchyProvider extends TypeHierarchyProvider {
    
    @Override
    protected void initializeCanonization() {
        this.canonizedTypeDescriptors = new HashMap<String, TypeDescriptor>();
    }
    
    @Override
    protected TypeDescriptor findOrCreateCanonizedTypeDescriptor(final String typeDescriptor) {
        if (!this.canonizedTypeDescriptors.containsKey(typeDescriptor)) {
            final TypeDescriptor typeDescriptorObject = this.createTypeDescriptor(typeDescriptor);
            this.canonizedTypeDescriptors.put(typeDescriptor, typeDescriptorObject);
        }
        return this.canonizedTypeDescriptors.get(typeDescriptor);
    }
    
    private Map<String, TypeDescriptor> canonizedTypeDescriptors;
    
    protected TypeDescriptor createTypeDescriptor(final String typeDescriptor) {
        return new TypeDescriptorDef(typeDescriptor);
    }
    
}
