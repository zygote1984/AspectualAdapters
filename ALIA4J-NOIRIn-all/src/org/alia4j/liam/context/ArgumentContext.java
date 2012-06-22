package org.alia4j.liam.context;

import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.ConstructorSignature;
import org.alia4j.liam.signature.FieldWriteSignature;
import org.alia4j.liam.signature.MethodSignature;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Andreas Sewe
 */
public final class ArgumentContext extends Context {
    
    private final int index;
    
    private final int minimumRestArguments;
    
    /**
     * @param index the index of the argument to be bound. (Negative indices are used to refer to arguments from the right.
     *            Thus, -1 refers to the last argument.)
     * @param minimumRestArguments
     */
    protected ArgumentContext(final int index, final int minimumRestArguments) {
        super(Collections.singletonList(ContextFactory.findOrCreateArgumentsContext()));
        this.index = index;
        this.minimumRestArguments = minimumRestArguments;
    }
    
    @Override
    public TypeDescriptor approximateValueTypeStatically(final java.util.List<? extends Signed<?>> callStack) {
        final int absoluteIndex;
        final int argumentsNumber;
        
        TypeDescriptor typeName;
        if (callStack.get(0).getSignature() instanceof ConstructorSignature) {
            final TypeDescriptor[] parameterTypes =
                            ((ConstructorSignature) callStack.get(0).getSignature()).getParameterTypes();
            absoluteIndex = this.index < 0 ? parameterTypes.length + this.index : this.index;
            typeName = parameterTypes[absoluteIndex];
            argumentsNumber = parameterTypes.length;
        } else if (callStack.get(0).getSignature() instanceof MethodSignature) {
            final TypeDescriptor[] parameterTypes = ((MethodSignature) callStack.get(0).getSignature()).getParameterTypes();
            absoluteIndex = this.index < 0 ? parameterTypes.length + this.index : this.index;
            typeName = parameterTypes[absoluteIndex];
            argumentsNumber = parameterTypes.length;
        } else if (callStack.get(0).getSignature() instanceof FieldWriteSignature && this.index == 0) {
            typeName = ((FieldWriteSignature) callStack.get(0).getSignature()).getType();
            argumentsNumber = 1;
            absoluteIndex = 0;
        } else {
            throw new IllegalArgumentException("Can not reify " + this.index + "th argument for generic function "
                            + callStack.get(0));
        }
        
        if (this.minimumRestArguments != -1 && this.index < 0) {
            if (absoluteIndex < this.minimumRestArguments)
                throw new IllegalArgumentException("Can not reify " + this.index
                                + "th argument for generic function because \"minumumRestArguments\" ("
                                + this.minimumRestArguments + ")constraint is violated at " + callStack.get(0));
        } else {
            if (absoluteIndex >= argumentsNumber - this.minimumRestArguments)
                throw new IllegalArgumentException("Can not reify " + Math.abs(this.index)
                                + "th last argument generic function because \"minumumRestArguments\" ("
                                + this.minimumRestArguments + ")constraint is violated at " + callStack.get(0));
        }
        
        return typeName;
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.get(this.approximateValueTypeStatically(Collections.singletonList(call)));
    }
    
    public Object getObjectValue(final Object argumentsObject) {
        final Object[] arguments = (Object[]) argumentsObject;
        return this.index < 0 ? arguments[arguments.length + this.index] : arguments[this.index];
    }
    
    public byte getByteValue(final Object argumentsObject) {
        final Object[] arguments = (Object[]) argumentsObject;
        return ((Byte) (this.index < 0 ? arguments[arguments.length + this.index] : arguments[this.index])).byteValue();
    }
    
    public short getShortValue(final Object argumentsObject) {
        final Object[] arguments = (Object[]) argumentsObject;
        return ((Short) (this.index < 0 ? arguments[arguments.length + this.index] : arguments[this.index])).shortValue();
    }
    
    public int getIntValue(final Object argumentsObject) {
        final Object[] arguments = (Object[]) argumentsObject;
        return ((Integer) (this.index < 0 ? arguments[arguments.length + this.index] : arguments[this.index])).intValue();
    }
    
    public long getLongValue(final Object argumentsObject) {
        final Object[] arguments = (Object[]) argumentsObject;
        return ((Long) (this.index < 0 ? arguments[arguments.length + this.index] : arguments[this.index])).longValue();
    }
    
    public float getFloatValue(final Object argumentsObject) {
        final Object[] arguments = (Object[]) argumentsObject;
        return ((Float) (this.index < 0 ? arguments[arguments.length + this.index] : arguments[this.index])).floatValue();
    }
    
    public double getDoubleValue(final Object argumentsObject) {
        final Object[] arguments = (Object[]) argumentsObject;
        return ((Double) (this.index < 0 ? arguments[arguments.length + this.index] : arguments[this.index])).doubleValue();
    }
    
    public char getCharValue(final Object argumentsObject) {
        final Object[] arguments = (Object[]) argumentsObject;
        return ((Character) (this.index < 0 ? arguments[arguments.length + this.index] : arguments[this.index])).charValue();
    }
    
    public boolean getBooleanValue(final Object argumentsObject) {
        final Object[] arguments = (Object[]) argumentsObject;
        return ((Boolean) (this.index < 0 ? arguments[arguments.length + this.index] : arguments[this.index]))
                        .booleanValue();
    }
    
    @Override
    public Maybe<Object> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Object>();
    }
    
    @Override
    public String toString() {
        return "${args[" + this.index + "]}";
    }
}
