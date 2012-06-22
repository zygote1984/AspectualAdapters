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
public class ToCharCoercionContext extends UnaryOperationContext {
    
    protected ToCharCoercionContext(final Context operand) {
        super(operand);
    }
    
    @Override
    public Maybe<Character> computeValueStatically(final List<? extends Signed<?>> callStack) {
        final Maybe<?> v1 = this.getOperand().computeValueStatically(callStack);
        if (!v1.isUnknown()) {
            return new Maybe<Character>((char) MaybeUtilities.numberForValue(v1).intValue());
        }
        return new Maybe<Character>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> signed) {
        return SimpleType.CHAR;
    }
    
    public final char getCharValue(final char v) {
        return v;
    }
    
    public final char getCharValue(final byte v) {
        return (char) v;
    }
    
    public final char getCharValue(final short v) {
        return (char) v;
    }
    
    public final char getCharValue(final int v) {
        return (char) v;
    }
    
    public final char getCharValue(final long v) {
        return (char) v;
    }
    
    public final char getCharValue(final float v) {
        return (char) v;
    }
    
    public final char getCharValue(final double v) {
        return (char) v;
    }
    
    @Override
    public String toString() {
        return "${(char) " + this.getOperand() + "}";
    }
}
