package org.alia4j.liam;

import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

public abstract class Context extends ManageableInstance {
    
    protected Context(final List<? extends Context> contexts) {
        super(contexts);
    }
    
    @Override
    protected final CharSequence getMethodName(final Signed<?> genericFunction) {
        switch (this.getDeclaredResultType(genericFunction)) {
        case REFERENCE:
            return "getObjectValue";
        case INT:
            return "getIntValue";
        case LONG:
            return "getLongValue";
        case FLOAT:
            return "getFloatValue";
        case DOUBLE:
            return "getDoubleValue";
        case BOOLEAN:
            return "getBooleanValue";
        case BYTE:
            return "getByteValue";
        case SHORT:
            return "getShortValue";
        case CHAR:
            return "getCharValue";
        default:
            throw new AssertionError("Declared result type not supported by protocol. ("
                            + this.getDeclaredResultType(genericFunction) + ")");
        }
    }
    
    /**
     * @param callStack the first element in the list is the top element in the stack.
     * @return
     */
    public abstract Maybe<? extends Object> computeValueStatically(List<? extends Signed<?>> callStack);
    
    /**
     * Approximates the type of the value that will be returned by this Context at runtime. It may not be identical to the
     * dynamic type of the actually returned value. This method is used by the computeGetValueStatically method and should
     * return the most specific type possible.
     * 
     * @param callStack
     * @return
     */
    public TypeDescriptor approximateValueTypeStatically(final List<? extends Signed<?>> callStack) {
        return this.getDeclaredResultType(callStack.get(0)).getTypeReference();
    }
    
    public boolean dependsOnEvent() {
        return false;
    }
    
    public EventSignature getDependedOnEvent() {
        return null;
    }
    
}
