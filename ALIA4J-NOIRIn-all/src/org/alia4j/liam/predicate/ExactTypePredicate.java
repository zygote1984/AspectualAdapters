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
public final class ExactTypePredicate extends AtomicPredicate {
    
    private final TypeDescriptor requiredTypeName;
    
    private Class<?> requiredType;
    
    private final Context context;
    
    protected ExactTypePredicate(final Context context, final TypeDescriptor requiredTypeName) {
        super(Collections.singletonList(context));
        this.requiredTypeName = requiredTypeName;
        this.context = context;
    }
    
    public boolean isSatisfied(final Object value) throws ClassNotFoundException {
        if (this.requiredType == null)
            this.requiredType = this.requiredTypeName.asClass();
        
        return this.requiredType.equals(value.getClass());
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
    public Maybe<Boolean> computeIsSatisfiedStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Boolean>();
    }
    
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("type of ");
        result.append(this.context);
        result.append(" must exactly equal: ");
        result.append(this.requiredTypeName);
        return result.toString();
    }
    
    @Override
    public int estimateRuntimeCost() {
        return ExactTypePredicate.ESTIMATED_RUNTIME_COST;
    }
    
    private static final int ESTIMATED_RUNTIME_COST = 2;
}
