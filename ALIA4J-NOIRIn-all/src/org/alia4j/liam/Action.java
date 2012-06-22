package org.alia4j.liam;

import java.util.Collections;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.liam.signature.Signed;

public abstract class Action extends ManageableInstance {
    
    protected Action() {
        super(Collections.singletonList(AllExposedContextsContext.SINGLETON_INSTANCE));
    }
    
    @Override
    protected CharSequence getMethodName(final Signed<?> genericFunction) {
        switch (this.getDeclaredResultType(genericFunction)) {
        case REFERENCE:
            return "performObject";
        case INT:
            return "performInt";
        case LONG:
            return "performLong";
        case FLOAT:
            return "performFloat";
        case DOUBLE:
            return "performDouble";
        case BOOLEAN:
            return "performBoolean";
        case BYTE:
            return "performByte";
        case SHORT:
            return "performShort";
        case CHAR:
            return "performChar";
        case VOID:
            return "perform";
        default:
            throw new AssertionError("Declared result type not supported by protocol. ("
                            + this.getDeclaredResultType(genericFunction) + ")");
        }
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> genericFunction) {
        return SimpleType.get(this.getResultType());
    }
    
    abstract public TypeDescriptor getResultType();
    
    // TODO These ought to be supplanted by a better mechanism.
    public AtomicPredicate forcesAtomicPredicateTrue() {
        return null;
    }
    
    // TODO These ought to be supplanted by a better mechanism.
    public AtomicPredicate forcesAtomicPredicateFalse() {
        return null;
    }
    
    abstract public TypeDescriptor getRequiredParameterType(int parameterPosition);
    
    public boolean triggersEvent() {
        return false;
    }
    
    public EventSignature getTriggeredEventSignature() {
        return null;
    }
}
