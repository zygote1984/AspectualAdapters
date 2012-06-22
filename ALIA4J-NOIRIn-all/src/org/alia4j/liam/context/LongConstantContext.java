package org.alia4j.liam.context;

import java.util.Collections;
import java.util.List;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public class LongConstantContext extends Context {
    
    protected LongConstantContext(final long value) {
        super(Collections.<Context>emptyList());
        this.value = value;
    }
    
    private final long value;
    
    @Override
    public Maybe<Long> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Long>(this.value);
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.LONG;
    }
    
    public final long getLongValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return "${(long) " + Long.toString(this.value) + "}";
    }
}
