package org.alia4j.liam.context;

import java.util.List;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;
import org.alia4j.util.MaybeUtilities;

/**
 * @author Christoph Bockisch
 */
public abstract class BitwiseBinaryOperationContext extends BinaryOperationContext {
    
    BitwiseBinaryOperationContext(final Context firstOperand, final Context secondOperand) {
        super(firstOperand, secondOperand);
    }
    
    @Override
    public Maybe<? extends Number> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getFirstOperandContext().computeValueStatically(callStack);
        final Maybe<?> v2 = this.getSecondOperandContext().computeValueStatically(callStack);
        
        if (!v1.isUnknown() && !v2.isUnknown()) {
            final Number numberV1 = MaybeUtilities.numberForValue(v1);
            final Number numberV2 = MaybeUtilities.numberForValue(v2);
            
            if (Long.class == numberV1.getClass() && Long.class == numberV2.getClass())
                return new Maybe<Long>(this.getLongValue(numberV1.longValue(), numberV2.longValue()));
            else if (Long.class == numberV1.getClass())
                return new Maybe<Long>(this.getLongValue(numberV1.longValue(), numberV2.intValue()));
            else if (Long.class == numberV2.getClass())
                return new Maybe<Long>(this.getLongValue(numberV1.intValue(), numberV2.longValue()));
            else
                return new Maybe<Integer>(this.getIntValue(numberV1.intValue(), numberV2.intValue()));
            
        }
        return new Maybe<Number>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        final SimpleType firstType = this.getFirstOperandContext().getDeclaredResultType(signed);
        final SimpleType secondType = this.getSecondOperandContext().getDeclaredResultType(signed);
        if (firstType == SimpleType.LONG || secondType == SimpleType.LONG)
            return SimpleType.LONG;
        else
            return SimpleType.INT;
    }
    
    public int getIntValue(final char v1, final char v2) {
        return this.getIntValue((int) v1, (int) v2);
    }
    
    public int getIntValue(final char v1, final byte v2) {
        return this.getIntValue((int) v1, (int) v2);
    }
    
    public int getIntValue(final char v1, final short v2) {
        return this.getIntValue((int) v1, (int) v2);
    }
    
    public int getIntValue(final char v1, final int v2) {
        return this.getIntValue((int) v1, v2);
    }
    
    public long getLongValue(final char v1, final long v2) {
        return this.getLongValue((int) v1, v2);
    }
    
    public int getIntValue(final byte v1, final char v2) {
        return this.getIntValue((int) v1, (int) v2);
    }
    
    public int getIntValue(final byte v1, final byte v2) {
        return this.getIntValue((int) v1, (int) v2);
    }
    
    public int getIntValue(final byte v1, final short v2) {
        return this.getIntValue((int) v1, (int) v2);
    }
    
    public int getIntValue(final byte v1, final int v2) {
        return this.getIntValue((int) v1, v2);
    }
    
    public long getLongValue(final byte v1, final long v2) {
        return this.getLongValue((int) v1, v2);
    }
    
    public int getIntValue(final short v1, final char v2) {
        return this.getIntValue((int) v1, (int) v2);
    }
    
    public int getIntValue(final short v1, final byte v2) {
        return this.getIntValue((int) v1, (int) v2);
    }
    
    public int getIntValue(final short v1, final short v2) {
        return this.getIntValue((int) v1, (int) v2);
    }
    
    public int getIntValue(final short v1, final int v2) {
        return this.getIntValue((int) v1, v2);
    }
    
    public long getLongValue(final short v1, final long v2) {
        return this.getLongValue((int) v1, v2);
    }
    
    public int getIntValue(final int v1, final char v2) {
        return this.getIntValue(v1, (int) v2);
    }
    
    public int getIntValue(final int v1, final byte v2) {
        return this.getIntValue(v1, (int) v2);
    }
    
    public int getIntValue(final int v1, final short v2) {
        return this.getIntValue(v1, (int) v2);
    }
    
    public long getLongValue(final long v1, final char v2) {
        return this.getLongValue(v1, (int) v2);
    }
    
    public long getLongValue(final long v1, final byte v2) {
        return this.getLongValue(v1, (int) v2);
    }
    
    public long getLongValue(final long v1, final short v2) {
        return this.getLongValue(v1, (int) v2);
    }
    
    public long getLongValue(final long v1, final int v2) {
        return this.getLongValue(v2, v1);
    }
    
    public abstract int getIntValue(int v1, int v2);
    
    public abstract long getLongValue(int v1, long v2);
    
    public abstract long getLongValue(long v1, long v2);
}
