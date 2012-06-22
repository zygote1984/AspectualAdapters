package org.alia4j.noirin.context;

import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeDescriptorConstants;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.noirin.SystemImpl;
import org.alia4j.util.Maybe;

public class ArgumentsContext extends Context {
    
    protected ArgumentsContext() {
        super(Collections.<Context>emptyList());
    }
    
    @Override
    public Maybe<? extends Object> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Object>();
    }
    
    @Override
    public TypeDescriptor approximateValueTypeStatically(final List<? extends Signed<?>> callStack) {
        return TypeDescriptorConstants.OBJECTARRAY_CLASS;
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    public Object getObjectValue() {
        return SystemImpl.getSingletonSystemImpl().getCallStackTop().calleeArguments;
    }
    
}
