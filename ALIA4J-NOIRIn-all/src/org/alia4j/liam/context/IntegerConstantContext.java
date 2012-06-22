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
public class IntegerConstantContext extends Context {
    
    protected IntegerConstantContext(final int value) {
        super(Collections.<Context>emptyList());
        this.value = value;
    }
    
    private final int value;
    
    @Override
    public Maybe<Integer> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Integer>(this.value);
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.INT;
    }
    
    public final int getIntValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return "${" + Integer.toString(this.value) + "}";
    }
}
