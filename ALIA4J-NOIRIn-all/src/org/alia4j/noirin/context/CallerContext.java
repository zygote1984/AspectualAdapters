package org.alia4j.noirin.context;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.noirin.CallContext;
import org.alia4j.noirin.SystemImpl;
import org.alia4j.util.Maybe;

public class CallerContext extends Context {
    
    protected CallerContext() {
        super(Collections.<Context>emptyList());
    }
    
    @Override
    public Maybe<? extends Object> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Object>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    public Object getObjectValue() {
        final CallContext callContext = SystemImpl.getSingletonSystemImpl().getCallStackTop();
        if (Modifier.isStatic(callContext.callerMethodModifiers))
            return null;
        else
            return callContext.callerRawLocals[0];
    }
    
}
