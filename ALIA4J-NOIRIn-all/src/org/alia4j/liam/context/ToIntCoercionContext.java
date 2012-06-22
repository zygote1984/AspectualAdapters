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
public class ToIntCoercionContext extends UnaryOperationContext {
    
    protected ToIntCoercionContext(final Context operand) {
        super(operand);
    }
    
    @Override
    public Maybe<Integer> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getOperand().computeValueStatically(callStack);
        if (!v1.isUnknown()) {
            return new Maybe<Integer>(MaybeUtilities.numberForValue(v1).intValue());
        }
        return new Maybe<Integer>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        return SimpleType.INT;
    }
    
    public final int getIntValue(final char v) {
        return v;
    }
    
    public final int getIntValue(final byte v) {
        return v;
    }
    
    public final int getIntValue(final short v) {
        return v;
    }
    
    public final int getIntValue(final int v) {
        return v;
    }
    
    public final int getIntValue(final long v) {
        return (int) v;
    }
    
    public final int getIntValue(final float v) {
        return (int) v;
    }
    
    public final int getIntValue(final double v) {
        return (int) v;
    }
    
    @Override
    public String toString() {
        return "${(int) " + this.getOperand() + "}";
    }
}
