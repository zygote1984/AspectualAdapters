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
public class BooleanConstantContext extends Context {
    
    protected BooleanConstantContext(final boolean value) {
        super(Collections.<Context>emptyList());
        this.value = value;
    }
    
    private final boolean value;
    
    @Override
    public Maybe<Boolean> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Boolean>(this.value);
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.BOOLEAN;
    }
    
    public final boolean getBooleanValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return "${" + Boolean.toString(this.value) + "}";
    }
}
