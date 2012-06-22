package org.alia4j.liam;

import java.util.Collections;
import java.util.List;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;


final public class AllExposedContextsContext extends Context {
    
    
    protected static final AllExposedContextsContext SINGLETON_INSTANCE = new AllExposedContextsContext();
    
    public static boolean isAllExposedContextsContext(Context other) {
        return other == SINGLETON_INSTANCE;
    }
    
    private AllExposedContextsContext() {
        super(Collections.<Context>emptyList());
    }

    @Override
    public Maybe<? extends Object> computeValueStatically(List<? extends Signed<?>> callStack) {
        return new Maybe<Object>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(Signed<?> genericFunction) {
        return SimpleType.REFERENCE;
    }
    
}
