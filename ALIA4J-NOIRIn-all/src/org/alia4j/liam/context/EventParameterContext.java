package org.alia4j.liam.context;

import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.event.EventAccessing;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public class EventParameterContext extends Context {
    
    private final String parameterName;
    
    private final EventSignature eventSignature;
    
    protected EventParameterContext(final EventSignature eventSignature, final String parameterName) {
        super(Collections.singletonList(ContextFactory.findOrCreateEventAccessingContext(eventSignature)));
        this.eventSignature = eventSignature;
        this.parameterName = parameterName;
    }
    
    @Override
    public Maybe<? extends Object> computeValueStatically(List<? extends Signed<?>> callStack) {
        return new Maybe<Object>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(Signed<?> genericFunction) {
        return SimpleType.get(TypeHierarchyProvider.findOrCreateFromClass(this.eventSignature
                        .getParameterType(this.parameterName)));
    }
    
    public boolean getBooleanValue(Object eventAccessing) {
        return ((EventAccessing) eventAccessing).getBooleanValue(this.parameterName);
    }
    
    public char getCharValue(Object eventAccessing) {
        return ((EventAccessing) eventAccessing).getCharValue(this.parameterName);
    }
    
    public byte getByteValue(Object eventAccessing) {
        return ((EventAccessing) eventAccessing).getByteValue(this.parameterName);
    }
    
    public short getShortValue(Object eventAccessing) {
        return ((EventAccessing) eventAccessing).getShortValue(this.parameterName);
    }
    
    public int getIntValue(Object eventAccessing) {
        return ((EventAccessing) eventAccessing).getIntValue(this.parameterName);
    }
    
    public long getLongValue(Object eventAccessing) {
        return ((EventAccessing) eventAccessing).getLongValue(this.parameterName);
    }
    
    public float getFloatValue(Object eventAccessing) {
        return ((EventAccessing) eventAccessing).getFloatValue(this.parameterName);
    }
    
    public double getDoubleValue(Object eventAccessing) {
        return ((EventAccessing) eventAccessing).getDoubleValue(this.parameterName);
    }
    
    public Object getObjectValue(Object eventAccessing) {
        return ((EventAccessing) eventAccessing).getObjectValue(this.parameterName);
    }
    
    @Override
    public boolean dependsOnEvent() {
        return true;
    }
    
    @Override
    public EventSignature getDependedOnEvent() {
        return this.eventSignature;
    }
    
}
