package org.alia4j.liam;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeDescriptorConstants;

public enum SimpleType {
    
    BOOLEAN, CHAR, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, REFERENCE, VOID;
    
    public TypeDescriptor getTypeReference() {
        switch (this) {
        case BOOLEAN:
            return TypeDescriptorConstants.BOOLEAN_PRIMITIVE;
        case CHAR:
            return TypeDescriptorConstants.CHAR_PRIMITIVE;
        case BYTE:
            return TypeDescriptorConstants.BYTE_PRIMITIVE;
        case SHORT:
            return TypeDescriptorConstants.SHORT_PRIMITIVE;
        case INT:
            return TypeDescriptorConstants.INT_PRIMITIVE;
        case LONG:
            return TypeDescriptorConstants.LONG_PRIMITIVE;
        case FLOAT:
            return TypeDescriptorConstants.FLOAT_PRIMITIVE;
        case DOUBLE:
            return TypeDescriptorConstants.DOUBLE_PRIMITIVE;
        case REFERENCE:
            return TypeDescriptorConstants.OBJECT_CLASS;
        case VOID:
            return TypeDescriptorConstants.VOID_PRIMITIVE;
        default:
            throw new UnsupportedOperationException("SimpleType not supported by protocol.");
        }
    }
    
    public static SimpleType get(final TypeDescriptor type) {
        if (type.isBooleanType())
            return BOOLEAN;
        else if (type.isCharType())
            return CHAR;
        else if (type.isByteType())
            return BYTE;
        else if (type.isShortType())
            return SHORT;
        else if (type.isIntType())
            return INT;
        else if (type.isLongType())
            return LONG;
        else if (type.isFloatType())
            return FLOAT;
        else if (type.isDoubleType())
            return DOUBLE;
        else if (type.isReferenceType())
            return REFERENCE;
        else
            return VOID;
    }
    
    public Context getCoercionContext(final Context operand) {
        switch (this) {
        case CHAR:
            return ContextFactory.findOrCreateToCharCoercionContext(operand);
        case BYTE:
            return ContextFactory.findOrCreateToByteCoercionContext(operand);
        case SHORT:
            return ContextFactory.findOrCreateToShortCoercionContext(operand);
        case INT:
            return ContextFactory.findOrCreateToIntCoercionContext(operand);
        case LONG:
            return ContextFactory.findOrCreateToLongCoercionContext(operand);
        case FLOAT:
            return ContextFactory.findOrCreateToFloatCoercionContext(operand);
        case DOUBLE:
            return ContextFactory.findOrCreateToDoubleCoercionContext(operand);
        case REFERENCE:
        case VOID:
        case BOOLEAN:
            throw new IllegalArgumentException("Not meaningful");
        default:
            throw new UnsupportedOperationException("SimpleType not supported by protocol.");
        }
    }
}
