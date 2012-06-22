package org.alia4j.noirin;

import java.util.HashMap;
import java.util.Map;
import org.alia4j.liam.event.EventAccessing;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.liam.event.EventTriggering;
import org.alia4j.util.Pair;

public class EventTriggeringInfo implements EventTriggering, EventAccessing {
    
    private final EventSignature eventSignature;
    
    private boolean isTriggered;
    
    private final Map<String, Object> parameterValues = new HashMap<String, Object>();
    
    public EventTriggeringInfo(EventSignature eventSignature) {
        this.eventSignature = eventSignature;
    }
    
    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }
    
    @Override
    public boolean getBooleanValue(String parameterName) {
        return (Boolean) this.parameterValues.get(parameterName);
    }
    
    @Override
    public char getCharValue(String parameterName) {
        return (Character) this.parameterValues.get(parameterName);
    }
    
    @Override
    public byte getByteValue(String parameterName) {
        return (Byte) this.parameterValues.get(parameterName);
    }
    
    @Override
    public short getShortValue(String parameterName) {
        return (Short) this.parameterValues.get(parameterName);
    }
    
    @Override
    public int getIntValue(String parameterName) {
        return (Integer) this.parameterValues.get(parameterName);
    }
    
    @Override
    public long getLongValue(String parameterName) {
        return (Long) this.parameterValues.get(parameterName);
    }
    
    @Override
    public float getFloatValue(String parameterName) {
        return (Float) this.parameterValues.get(parameterName);
    }
    
    @Override
    public double getDoubleValue(String parameterName) {
        return (Double) this.parameterValues.get(parameterName);
    }
    
    @Override
    public Object getObjectValue(String parameterName) {
        return this.parameterValues.get(parameterName);
    }
    
    @Override
    public void trigger(Pair<String, Object>... eventParameters) {
        if (this.isTriggered)
            throw new IllegalStateException("Cannot trigger an event twice.");
        this.isTriggered = true;
        for (Pair<String, Object> pair : eventParameters) {
            this.parameterValues.put(pair.getLeft(), pair.getRight());
        }
    }
    
}
