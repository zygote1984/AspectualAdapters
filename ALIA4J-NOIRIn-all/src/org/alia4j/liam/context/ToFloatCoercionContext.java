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
public class ToFloatCoercionContext extends UnaryOperationContext {
    
    protected ToFloatCoercionContext(final Context operand) {
        super(operand);
    }
    
    @Override
    public Maybe<Float> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getOperand().computeValueStatically(callStack);
        if (!v1.isUnknown()) {
            return new Maybe<Float>(MaybeUtilities.numberForValue(v1).floatValue());
        }
        return new Maybe<Float>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        return SimpleType.FLOAT;
    }
    
    public final float getFloatValue(final char v) {
        return v;
    }
    
    public final float getFloatValue(final byte v) {
        return v;
    }
    
    public final float getFloatValue(final short v) {
        return v;
    }
    
    public final float getFloatValue(final int v) {
        return v;
    }
    
    public final float getFloatValue(final long v) {
        return v;
    }
    
    public final float getFloatValue(final float v) {
        return v;
    }
    
    public final float getFloatValue(final double v) {
        return (float) v;
    }
    
    @Override
    public String toString() {
        return "${(float) " + this.getOperand() + "}";
    }
}
