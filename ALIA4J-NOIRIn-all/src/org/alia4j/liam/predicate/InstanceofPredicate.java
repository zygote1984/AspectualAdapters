package org.alia4j.liam.predicate;

import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class InstanceofPredicate extends AtomicPredicate {
    
    private final TypeDescriptor requiredTypeName;
    
    private Class<?> requiredType;
    
    private final Context context;
    
    protected InstanceofPredicate(final Context context, final TypeDescriptor requiredTypeName) {
        super(Collections.singletonList(context));
        this.requiredTypeName = requiredTypeName;
        this.context = context;
    }
    
    public boolean isSatisfied(final Object value) throws ClassNotFoundException {
        if (this.requiredType == null)
            this.requiredType = this.requiredTypeName.asClass();
        
        return this.requiredType.isInstance(value);
    }
    
    @Override
    public Maybe<Boolean> computeIsSatisfiedStatically(final List<? extends Signed<?>> callStack) {
        if (callStack.isEmpty())
            return new Maybe<Boolean>();
        
        switch (this.context.getDeclaredResultType(callStack.get(0))) {
        case INT:
            return new Maybe<Boolean>(this.requiredTypeName.isIntType());
        case LONG:
            return new Maybe<Boolean>(this.requiredTypeName.isLongType());
        case FLOAT:
            return new Maybe<Boolean>(this.requiredTypeName.isFloatType());
        case DOUBLE:
            return new Maybe<Boolean>(this.requiredTypeName.isDoubleType());
        case BOOLEAN:
            return new Maybe<Boolean>(this.requiredTypeName.isBooleanType());
        case BYTE:
            return new Maybe<Boolean>(this.requiredTypeName.isByteType());
        case CHAR:
            return new Maybe<Boolean>(this.requiredTypeName.isCharType());
        case SHORT:
            return new Maybe<Boolean>(this.requiredTypeName.isShortType());
        case REFERENCE:
            if (!this.context.computeValueStatically(callStack).isUnknown()) {
                final Object value = this.context.computeValueStatically(callStack).getValue();
                try {
                    return new Maybe<Boolean>(this.isSatisfied(value));
                } catch (final ClassNotFoundException e) {
                    // isSatisfied performs lay class loading.
                    // if class cannot be found, this exception is thrown, but we don't want
                    // to escalate the exception during partial evaluation
                }
            }
            return new Maybe<Boolean>();
        default:
            throw new UnsupportedOperationException("Context's result type not supported by protocol.");
        }
    }
    
    public boolean isSatisfied(final boolean value) {
        return this.requiredTypeName.isBooleanType();
    }
    
    public boolean isSatisfied(final char value) {
        return this.requiredTypeName.isCharType();
    }
    
    public boolean isSatisfied(final byte value) {
        return this.requiredTypeName.isByteType();
    }
    
    public boolean isSatisfied(final short value) {
        return this.requiredTypeName.isShortType();
    }
    
    public boolean isSatisfied(final int value) {
        return this.requiredTypeName.isIntType();
    }
    
    public boolean isSatisfied(final long value) {
        return this.requiredTypeName.isLongType();
    }
    
    public boolean isSatisfied(final float value) {
        return this.requiredTypeName.isFloatType();
    }
    
    public boolean isSatisfied(final double value) {
        return this.requiredTypeName.isDoubleType();
    }
    
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("type of ");
        result.append(this.context);
        result.append(" must either be equal or a sub type of: ");
        result.append(this.requiredTypeName);
        return result.toString();
    }
    
    @Override
    public int estimateRuntimeCost() {
        return InstanceofPredicate.ESTIMATED_RUNTIME_COST;
    }
    
    public TypeDescriptor getRequiredTypeName() {
    	return this.requiredTypeName;
    }
    
    private static final int ESTIMATED_RUNTIME_COST = 2;
    
}
