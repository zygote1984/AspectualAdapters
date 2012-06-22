package org.alia4j.liam.event;

import org.alia4j.util.Pair;

public interface EventTriggering {
    
    public void trigger(Pair<String, Object>... eventParameters);
    
}
