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
public class FloatConstantContext extends Context {
    
    protected FloatConstantContext(final float value) {
        super(Collections.<Context>emptyList());
        this.value = value;
    }
    
    private final float value;
    
    @Override
    public Maybe<Float> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Float>(this.value);
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.FLOAT;
    }
    
    public final float getFloatValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return "${" + Float.toString(this.value) + "}";
    }
}
