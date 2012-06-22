package org.alia4j.liam.event;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.alia4j.util.Pair;

public class EventSignature {
    
    private final String eventName;
    
    private final Pair<Class<?>, String>[] eventParameters;
    
    private final Map<String, Pair<Class<?>, Integer>> parameterName2TypePosition =
                    new HashMap<String, Pair<Class<?>, Integer>>();
    
    public EventSignature(String eventName, Pair<Class<?>, String>... eventParameters) {
        this.eventName = eventName;
        this.eventParameters = eventParameters;
        int index = 0;
        for (Pair<Class<?>, String> pair : eventParameters) {
            this.parameterName2TypePosition.put(pair.getRight(), new Pair<Class<?>, Integer>(pair.getLeft(), index));
            index++;
        }
    }
    
    public String getEventName() {
        return this.eventName;
    }
    
    public int getNumberOfParameters() {
        return this.eventParameters.length;
    }
    
    public Class<?> getParameterType(String parameterName) {
        return this.parameterName2TypePosition.get(parameterName).getLeft();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.eventName == null) ? 0 : this.eventName.hashCode());
        result = prime * result + Arrays.hashCode(this.eventParameters);
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        EventSignature other = (EventSignature) obj;
        if (this.eventName == null) {
            if (other.eventName != null)
                return false;
        } else if (!this.eventName.equals(other.eventName))
            return false;
        if (!Arrays.equals(this.eventParameters, other.eventParameters))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "EventSignature [eventName=" + this.eventName + ", eventParameters=" + Arrays.toString(this.eventParameters)
                        + "]";
    }
    
}
