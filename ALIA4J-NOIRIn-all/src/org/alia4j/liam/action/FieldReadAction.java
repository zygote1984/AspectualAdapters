package org.alia4j.liam.action;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.signature.ResolutionStrategy;

/**
 * @author Christoph Bockisch
 */
public class FieldReadAction extends FieldAction {
    
    protected FieldReadAction(final TypeDescriptor declaringClassName, final CharSequence fieldName,
                    final TypeDescriptor fieldTypeName, final ResolutionStrategy resolutionStrategy) {
        super(declaringClassName, fieldName, fieldTypeName, resolutionStrategy);
    }
    
    @Override
    public TypeDescriptor getResultType() {
        return this.getFieldTypeName();
    }
    
    @Override
    public TypeDescriptor getRequiredParameterType(final int parameterPosition) {
        assert !this.isStaticAccess() && parameterPosition == 0;
        return this.getDeclaringClassName();
    }
    
    public boolean performBoolean(Object exposedContextValues) throws SecurityException, IllegalArgumentException,
                    ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return ((Boolean) this.readReflectively(exposedContextValues)).booleanValue();
    }
    
    public char performChar(Object exposedContextValues) throws SecurityException, IllegalArgumentException,
                    ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return ((Character) this.readReflectively(exposedContextValues)).charValue();
    }
    
    public byte performByte(Object exposedContextValues) throws SecurityException, IllegalArgumentException,
                    ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return ((Byte) this.readReflectively(exposedContextValues)).byteValue();
    }
    
    public short performShort(Object exposedContextValues) throws SecurityException, IllegalArgumentException,
                    ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return ((Short) this.readReflectively(exposedContextValues)).shortValue();
    }
    
    public int performInt(Object exposedContextValues) throws SecurityException, IllegalArgumentException,
                    ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return ((Integer) this.readReflectively(exposedContextValues)).intValue();
    }
    
    public long performLong(Object exposedContextValues) throws SecurityException, IllegalArgumentException,
                    ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return ((Long) this.readReflectively(exposedContextValues)).longValue();
    }
    
    public float performFloat(Object exposedContextValues) throws SecurityException, IllegalArgumentException,
                    ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return ((Float) this.readReflectively(exposedContextValues)).floatValue();
    }
    
    public double performDouble(Object exposedContextValues) throws SecurityException, IllegalArgumentException,
                    ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return ((Double) this.readReflectively(exposedContextValues)).doubleValue();
    }
    
    public Object performObject(Object exposedContextValues) throws SecurityException, IllegalArgumentException,
                    ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return this.readReflectively(exposedContextValues);
    }
    
    private Object readReflectively(Object exposedContextValues) throws ClassNotFoundException, SecurityException,
                    NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        final Object owner;
        if (this.isStaticAccess())
            owner = null;
        else
            owner = ((Object[]) exposedContextValues)[0];
        return this.getField().get(owner);
    }
    
}
