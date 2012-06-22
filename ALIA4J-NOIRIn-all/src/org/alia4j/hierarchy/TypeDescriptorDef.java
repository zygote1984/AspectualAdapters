package org.alia4j.hierarchy;

import org.alia4j.util.BytecodeConstants;

public class TypeDescriptorDef extends AbstractTypeDescriptor {
    
    private final String typeDescriptor;
    
    protected TypeDescriptorDef(final String typeDescriptor) {
        this.typeDescriptor = typeDescriptor;
    }
    
    @Override
    public int getDimensionality() {
        return this.typeDescriptor.lastIndexOf('[') + 1;
    }
    
    @Override
    public TypeDescriptor getInnermostElementType() {
        if (this.getDimensionality() == 0)
            return this;
        return TypeHierarchyProvider.findOrCreateFromTypeDescriptor(this.typeDescriptor.substring(this.getDimensionality()));
    }
    
    @Override
    public CharSequence[] getNameElements() {
        if (this.typeDescriptor.length() == 1 || this.typeDescriptor.startsWith("["))
            throw new UnsupportedOperationException("Only supported for class or interface types.");
        return this.typeDescriptor.substring(1, this.typeDescriptor.length() - 1).split("/");
    }
    
    @Override
    public boolean isArrayType() {
        return this.typeDescriptor.startsWith("[");
    }
    
    @Override
    public boolean isBooleanType() {
        return this.typeDescriptor.equals(BytecodeConstants.TYPE_DESC_STRING_BOOLEAN);
    }
    
    @Override
    public boolean isByteType() {
        return this.typeDescriptor.equals(BytecodeConstants.TYPE_DESC_STRING_BYTE);
    }
    
    @Override
    public boolean isCharType() {
        return this.typeDescriptor.equals(BytecodeConstants.TYPE_DESC_STRING_CHAR);
    }
    
    @Override
    public boolean isClassType() {
        return this.typeDescriptor.startsWith(BytecodeConstants.TYPE_DESC_STRING_CLASSORINTERFACE);
    }
    
    @Override
    public boolean isDoubleType() {
        return this.typeDescriptor.equals(BytecodeConstants.TYPE_DESC_STRING_DOUBLE);
    }
    
    @Override
    public boolean isFloatType() {
        return this.typeDescriptor.equals(BytecodeConstants.TYPE_DESC_STRING_FLOAT);
    }
    
    @Override
    public boolean isIntType() {
        return this.typeDescriptor.equals(BytecodeConstants.TYPE_DESC_STRING_INT);
    }
    
    @Override
    public boolean isLongType() {
        return this.typeDescriptor.equals(BytecodeConstants.TYPE_DESC_STRING_LONG);
    }
    
    @Override
    public boolean isShortType() {
        return this.typeDescriptor.equals(BytecodeConstants.TYPE_DESC_STRING_SHORT);
    }
    
    @Override
    public boolean isVoidType() {
        return this.typeDescriptor.equals(BytecodeConstants.TYPE_DESC_STRING_VOID);
    }
    
    @Override
    public String toInternalTypeDescriptor() {
        return this.typeDescriptor;
    }
    
}
