package org.alia4j.liam.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import org.alia4j.util.Tuple;
import org.apache.commons.collections.map.MultiValueMap;

public class StoreHandleDef implements StoreHandle {
    
    protected StoreHandleDef() {}
    
    private final MultiValueMap map = new MultiValueMap();

    public Object[] getMatched(final Object[] tuple, final int[] wildcardPositions) {
        final List<Object> result = new ArrayList<Object>();
        
        outer_loop: for (final Object rowObject : this.map.entrySet()) {
            Entry<Tuple<Object>, Collection<Object>> row = (Entry<Tuple<Object>, Collection<Object>>) rowObject;
            final Tuple<Object> key = row.getKey();
            int boundIndex = 0;
            for (int i = 0; i < key.size(); i++) {
                if (Arrays.binarySearch(wildcardPositions, i) < 0) {
                    if (!key.get(i).equals(tuple[boundIndex]))
                        continue outer_loop;
                    boundIndex++;
                }
            }
            // has matched
            result.addAll(row.getValue());
        }
        return result.toArray();
    }
    
    public void add(final Tuple<Object> key, final Object value) {
        this.map.put(key, value);
    }

}
