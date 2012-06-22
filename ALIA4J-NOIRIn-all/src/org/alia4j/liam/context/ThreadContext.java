package org.alia4j.liam.context;

import java.util.Collections;
import java.util.List;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Christoph Bockisch
 */
public final class ThreadContext extends Context {
    
    protected ThreadContext() {
        super(Collections.<Context>emptyList());
    }
    
    @Override
    public Maybe<? extends Object> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Thread>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    public Object getObjectValue() {
        return Thread.currentThread();
    }
    
    @Override
    public String toString() {
        return "${currentThread}";
    }
}
