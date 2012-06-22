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
public class DoubleConstantContext extends Context {
    
    protected DoubleConstantContext(final double value) {
        super(Collections.<Context>emptyList());
        this.value = value;
    }
    
    private final double value;
    
    @Override
    public Maybe<Double> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Double>(this.value);
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.DOUBLE;
    }
    
    public final double getDoubleValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return "${" + Double.toString(this.value) + "}";
    }
}
