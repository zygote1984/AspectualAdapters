package org.alia4j.hierarchy;

import org.alia4j.util.BytecodeConstants;

public class TypeDescriptorConstants {
    
    static {
        if (!TypeHierarchyProvider.initialized())
            throw new IllegalStateException(
                            "The class TypeConstants must not be loaded (i.e., used) before the TypeHierarchyProvider is initialized.");
    }
    
    private TypeDescriptorConstants() {
        // not meant to be instantiated.
    }
    
    public static final TypeDescriptor BOOLEAN_PRIMITIVE = TypeHierarchyProvider
                    .findOrCreateFromTypeDescriptor(BytecodeConstants.TYPE_DESC_STRING_BOOLEAN);
    
    public static final TypeDescriptor CHAR_PRIMITIVE = TypeHierarchyProvider
                    .findOrCreateFromTypeDescriptor(BytecodeConstants.TYPE_DESC_STRING_CHAR);
    
    public static final TypeDescriptor BYTE_PRIMITIVE = TypeHierarchyProvider
                    .findOrCreateFromTypeDescriptor(BytecodeConstants.TYPE_DESC_STRING_BYTE);
    
    public static final TypeDescriptor SHORT_PRIMITIVE = TypeHierarchyProvider
                    .findOrCreateFromTypeDescriptor(BytecodeConstants.TYPE_DESC_STRING_SHORT);
    
    public static final TypeDescriptor INT_PRIMITIVE = TypeHierarchyProvider
                    .findOrCreateFromTypeDescriptor(BytecodeConstants.TYPE_DESC_STRING_INT);
    
    public static final TypeDescriptor LONG_PRIMITIVE = TypeHierarchyProvider
                    .findOrCreateFromTypeDescriptor(BytecodeConstants.TYPE_DESC_STRING_LONG);
    
    public static final TypeDescriptor FLOAT_PRIMITIVE = TypeHierarchyProvider
                    .findOrCreateFromTypeDescriptor(BytecodeConstants.TYPE_DESC_STRING_FLOAT);
    
    public static final TypeDescriptor DOUBLE_PRIMITIVE = TypeHierarchyProvider
                    .findOrCreateFromTypeDescriptor(BytecodeConstants.TYPE_DESC_STRING_DOUBLE);
    
    public static final TypeDescriptor VOID_PRIMITIVE = TypeHierarchyProvider
                    .findOrCreateFromTypeDescriptor(BytecodeConstants.TYPE_DESC_STRING_VOID);
    
    public static final TypeDescriptor INTEGER_CLASS = TypeHierarchyProvider.findOrCreateFromClass(Integer.class);
    
    public static final TypeDescriptor LONG_CLASS = TypeHierarchyProvider.findOrCreateFromClass(Long.class);
    
    public static final TypeDescriptor FLOAT_CLASS = TypeHierarchyProvider.findOrCreateFromClass(Float.class);
    
    public static final TypeDescriptor DOUBLE_CLASS = TypeHierarchyProvider.findOrCreateFromClass(Double.class);
    
    public static final TypeDescriptor BOOLEAN_CLASS = TypeHierarchyProvider.findOrCreateFromClass(Boolean.class);
    
    public static final TypeDescriptor BYTE_CLASS = TypeHierarchyProvider.findOrCreateFromClass(Byte.class);
    
    public static final TypeDescriptor CHAR_CLASS = TypeHierarchyProvider.findOrCreateFromClass(Character.class);
    
    public static final TypeDescriptor SHORT_CLASS = TypeHierarchyProvider.findOrCreateFromClass(Short.class);
    
    public static final TypeDescriptor VOID_CLASS = TypeHierarchyProvider.findOrCreateFromClass(Void.class);
    
    public static final TypeDescriptor OBJECT_CLASS = TypeHierarchyProvider
                    .findOrCreateFromTypeDescriptor("Ljava/lang/Object;");
    
    public static final TypeDescriptor OBJECTARRAY_CLASS = TypeHierarchyProvider
                    .findOrCreateFromTypeDescriptor("[Ljava/lang/Object;");
    
    public static final TypeDescriptor STRING_CLASS = TypeHierarchyProvider.findOrCreateFromClass(String.class);
    
    public static final TypeDescriptor THROWABLE_CLASS = TypeHierarchyProvider.findOrCreateFromClass(Throwable.class);
    
    public static final TypeDescriptor[] INT_PRIMITIVE_ARG = new TypeDescriptor[] { TypeDescriptorConstants.INT_PRIMITIVE };
    
    public static final TypeDescriptor[] LONG_PRIMITIVE_ARG =
                    new TypeDescriptor[] { TypeDescriptorConstants.LONG_PRIMITIVE };
    
    public static final TypeDescriptor[] FLOAT_PRIMITIVE_ARG =
                    new TypeDescriptor[] { TypeDescriptorConstants.FLOAT_PRIMITIVE };
    
    public static final TypeDescriptor[] DOUBLE_PRIMITIVE_ARG =
                    new TypeDescriptor[] { TypeDescriptorConstants.DOUBLE_PRIMITIVE };
    
    public static final TypeDescriptor[] BOOLEAN_PRIMITIVE_ARG =
                    new TypeDescriptor[] { TypeDescriptorConstants.BOOLEAN_PRIMITIVE };
    
    public static final TypeDescriptor[] BYTE_PRIMITIVE_ARG =
                    new TypeDescriptor[] { TypeDescriptorConstants.BYTE_PRIMITIVE };
    
    public static final TypeDescriptor[] CHAR_PRIMITIVE_ARG =
                    new TypeDescriptor[] { TypeDescriptorConstants.CHAR_PRIMITIVE };
    
    public static final TypeDescriptor[] SHORT_PRIMITIVE_ARG =
                    new TypeDescriptor[] { TypeDescriptorConstants.SHORT_PRIMITIVE };
    
    public static final TypeDescriptor[] NO_ARG = new TypeDescriptor[0];
    
}
