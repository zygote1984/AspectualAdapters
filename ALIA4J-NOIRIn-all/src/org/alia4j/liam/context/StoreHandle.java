/**
 * 
 */
package org.alia4j.liam.context;

import org.alia4j.util.Tuple;

public interface StoreHandle {
    
    public Object[] getMatched(final Object[] tuple, final int[] wildcardPositions);
    
    /**
     * Associates a tuple of values (key) with an instance (value), this association is stored as a relation. This means, the
     * same key can be associated with zero or more values.
     * 
     * @param key
     * @param value
     */
    public void add(final Tuple<Object> key, final Object value);
    
}
