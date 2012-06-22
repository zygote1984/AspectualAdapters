package org.alia4j.hierarchy;

import org.alia4j.util.BytecodeConstants;
import org.alia4j.util.ClassLoading;

public abstract class AbstractTypeDescriptor implements TypeDescriptor {
    
    private Class<?> clazz;
    
    @Override
    public Class<?> asClass() throws ClassNotFoundException {
        if (this.clazz == null)
            this.clazz = ClassLoading.classFor(this.toInternalTypeDescriptor());
        return this.clazz;
    }
    
    @Override
    public boolean isPrimitiveType() {
        return this.isIntType() || this.isLongType() || this.isFloatType() || this.isDoubleType() || this.isBooleanType()
                        || this.isByteType() || this.isCharType() || this.isShortType();
    }
    
    @Override
    public boolean isReferenceType() {
        return this.isClassType() || this.isArrayType();
    }
    
    @Override
    public boolean isIntLikeType() {
        return this.isIntType() || this.isBooleanType() || this.isByteType() || this.isCharType() || this.isShortType();
    }
    
    @Override
    public int getStackWords() {
        if (this.isVoidType())
            return 0;
        if (this.isLongType() || this.isDoubleType())
            return 2;
        else
            return 1;
    }
    
    private String internalClassName;
    
    @Override
    public String toInternalClassName() {
        if (!this.isClassType())
            throw new UnsupportedOperationException(
                            "This method may only be called for class or interface types (not for arrays or primitives).");
        if (this.internalClassName == null) {
            final StringBuilder result = new StringBuilder();
            for (int i = 0; i < this.getNameElements().length; i++) {
                result.append(this.getNameElements()[i]);
                if (i < this.getNameElements().length - 1)
                    result.append('/');
            }
            this.internalClassName = result.toString().intern();
        }
        return this.internalClassName;
    }
    
    @Override
    public abstract String toInternalTypeDescriptor();
    
    private String normalTypeName;
    
    @Override
    public String toNormalTypeName() {
        if (this.normalTypeName == null) {
            if (this.isClassType()) {
                final StringBuilder result = new StringBuilder();
                for (int i = 0; i < this.getNameElements().length; i++) {
                    result.append(this.getNameElements()[i]);
                    if (i < this.getNameElements().length - 1)
                        result.append('.');
                }
                this.normalTypeName = result.toString();
            } else if (this.isArrayType()) {
                final StringBuilder result = new StringBuilder();
                result.append(this.getInnermostElementType().toNormalTypeName());
                for (int i = 0; i < this.getDimensionality(); i++)
                    result.append("[]");
                this.normalTypeName = result.toString().intern();
            } else {
                if (this.isBooleanType())
                    this.normalTypeName = BytecodeConstants.NORMAL_TYPE_BOOLEAN;
                else if (this.isCharType())
                    this.normalTypeName = BytecodeConstants.NORMAL_TYPE_CHAR;
                else if (this.isByteType())
                    this.normalTypeName = BytecodeConstants.NORMAL_TYPE_BYTE;
                else if (this.isShortType())
                    this.normalTypeName = BytecodeConstants.NORMAL_TYPE_SHORT;
                else if (this.isIntType())
                    this.normalTypeName = BytecodeConstants.NORMAL_TYPE_INT;
                else if (this.isLongType())
                    this.normalTypeName = BytecodeConstants.NORMAL_TYPE_LONG;
                else if (this.isFloatType())
                    this.normalTypeName = BytecodeConstants.NORMAL_TYPE_FLOAT;
                else if (this.isDoubleType())
                    this.normalTypeName = BytecodeConstants.NORMAL_TYPE_DOUBLE;
                else if (this.isVoidType())
                    this.normalTypeName = BytecodeConstants.NORMAL_TYPE_VOID;
            }
        }
        return this.normalTypeName;
    }
    
    @Override
    public String toString() {
        return this.toNormalTypeName();
    }
    
    @Override
    final public boolean equals(final Object obj) {
        return obj == this;
    }
    
    @Override
    final public int hashCode() {
        return System.identityHashCode(this);
    }
}
