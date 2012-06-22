package org.alia4j.noirin.context;

import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.noirin.SystemImpl;
import org.alia4j.util.Maybe;

public class MethodResultContext extends Context {
    
    protected MethodResultContext() {
        super(Collections.<Context>emptyList());
    }
    
    @Override
    public Maybe<? extends Object> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Object>();
    }
    
    @Override
    public TypeDescriptor approximateValueTypeStatically(final List<? extends Signed<?>> callStack) {
        return callStack.get(0).getSignature().getReturnType();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        final SimpleType simpleResultType = SimpleType.get(call.getSignature().getReturnType());
        if (simpleResultType == SimpleType.VOID)
            // must return null in this case
            return SimpleType.REFERENCE;
        else
            return simpleResultType;
    }
    
    public Object getObjectValue() {
        return SystemImpl.getSingletonSystemImpl().getCallStackTop().getReturnValue();
    }
    
    public boolean getBooleanValue() {
        return ((Boolean) SystemImpl.getSingletonSystemImpl().getCallStackTop().getReturnValue()).booleanValue();
    }
    
    public char getCharValue() {
        return ((Character) SystemImpl.getSingletonSystemImpl().getCallStackTop().getReturnValue()).charValue();
    }
    
    public byte getByteValue() {
        return ((Byte) SystemImpl.getSingletonSystemImpl().getCallStackTop().getReturnValue()).byteValue();
    }
    
    public short getShortValue() {
        return ((Short) SystemImpl.getSingletonSystemImpl().getCallStackTop().getReturnValue()).shortValue();
    }
    
    public int getIntValue() {
        return ((Integer) SystemImpl.getSingletonSystemImpl().getCallStackTop().getReturnValue()).intValue();
    }
    
    public long getLongValue() {
        return ((Long) SystemImpl.getSingletonSystemImpl().getCallStackTop().getReturnValue()).longValue();
    }
    
    public float getFloatValue() {
        return ((Float) SystemImpl.getSingletonSystemImpl().getCallStackTop().getReturnValue()).floatValue();
    }
    
    public double getDoubleValue() {
        return ((Double) SystemImpl.getSingletonSystemImpl().getCallStackTop().getReturnValue()).doubleValue();
    }
    
}
