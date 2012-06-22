package org.alia4j.liam.context;

import java.util.List;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;
import org.alia4j.util.MaybeUtilities;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public class ToDoubleCoercionContext extends UnaryOperationContext {
    
    protected ToDoubleCoercionContext(final Context operand) {
        super(operand);
    }
    
    @Override
    public Maybe<Double> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getOperand().computeValueStatically(callStack);
        if (!v1.isUnknown()) {
            return new Maybe<Double>(MaybeUtilities.numberForValue(v1).doubleValue());
        }
        return new Maybe<Double>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        return SimpleType.DOUBLE;
    }
    
    public final double getDoubleValue(final char v) {
        return v;
    }
    
    public final double getDoubleValue(final byte v) {
        return v;
    }
    
    public final double getDoubleValue(final short v) {
        return v;
    }
    
    public final double getDoubleValue(final int v) {
        return v;
    }
    
    public final double getDoubleValue(final long v) {
        return v;
    }
    
    public final double getDoubleValue(final float v) {
        return v;
    }
    
    public final double getDoubleValue(final double v) {
        return v;
    }
    
    @Override
    public String toString() {
        return "${(double) " + this.getOperand() + "}";
    }
}
