package org.alia4j.aspectj.model.context;

import java.lang.reflect.Field;
import org.aspectj.lang.reflect.FieldSignature;

/**
 * @author Andreas Sewe
 */
class FieldSignatureImpl implements FieldSignature {
    
    private final Field field;
    
    protected FieldSignatureImpl(final Field field) {
        this.field = field;
    }
    
    @Override
    public Field getField() {
        return this.field;
    }
    
    @Override
    public Class<?> getFieldType() {
        return this.field.getType();
    }
    
    @Override
    public Class<?> getDeclaringType() {
        return this.field.getDeclaringClass();
    }
    
    @Override
    public String getDeclaringTypeName() {
        return this.field.getDeclaringClass().getName();
    }
    
    @Override
    public int getModifiers() {
        return this.field.getModifiers();
    }
    
    @Override
    public String getName() {
        return this.field.getName();
    }
    
    @Override
    public String toLongString() {
        return this.toString();
    }
    
    @Override
    public String toShortString() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        return this.field.toString();
    }
}
