/**
 * 
 */
package org.alia4j.liam.context;

import java.util.List;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Andreas Sewe
 */
public class WrappingContext extends UnaryOperationContext {
    
    protected WrappingContext(final Context operand) {
        super(operand);
    }
    
    @Override
    public Maybe<? extends Object> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Object>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    public final Object getObjectValue(final int unwrappedValue) {
        return Integer.valueOf(unwrappedValue);
    }
    
    public final Object getObjectValue(final long unwrappedValue) {
        return Long.valueOf(unwrappedValue);
    }
    
    public final Object getObjectValue(final float unwrappedValue) {
        return Float.valueOf(unwrappedValue);
    }
    
    public final Object getObjectValue(final double unwrappedValue) {
        return Double.valueOf(unwrappedValue);
    }
    
    public final Object getObjectValue(final boolean unwrappedValue) {
        return Boolean.valueOf(unwrappedValue);
    }
    
    public final Object getObjectValue(final byte unwrappedValue) {
        return Byte.valueOf(unwrappedValue);
    }
    
    public final Object getObjectValue(final char unwrappedValue) {
        return Character.valueOf(unwrappedValue);
    }
    
    public final Object getObjectValue(final short unwrappedValue) {
        return Short.valueOf(unwrappedValue);
    }
    
    public final Object getObjectValue(final Object unwrappedValue) {
        return unwrappedValue;
    }
    
    @Override
    public String toString() {
        return "${Wrapper.valueOf(" + this.getOperand().toString() + ")}";
    }
}
