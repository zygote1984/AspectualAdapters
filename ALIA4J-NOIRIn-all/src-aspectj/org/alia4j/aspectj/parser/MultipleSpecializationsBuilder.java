package org.alia4j.aspectj.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.alia4j.liam.Context;
import org.alia4j.liam.Specialization;

/**
 * @author Christoph Bockisch
 */
public class MultipleSpecializationsBuilder extends SpecializationBuilder {
    
    public MultipleSpecializationsBuilder(final List<SingleSpecializationBuilder> singleBuilders) {
        this.singleBuilders = singleBuilders;
    }
    
    private final List<SingleSpecializationBuilder> singleBuilders;
    
    public Iterator<SingleSpecializationBuilder> buildersIterator() {
        return this.singleBuilders.iterator();
    }
    
    @Override
    public void setContext(final int index, final Context context) {
        for (final SingleSpecializationBuilder builder : this.singleBuilders)
            builder.setContext(index, context);
    }
    
    @Override
    public Set<Specialization> getSpecializations() {
        final Set<Specialization> result = new HashSet<Specialization>();
        for (final SingleSpecializationBuilder builder : this.singleBuilders)
            result.addAll(builder.getSpecializations());
        return result;
    }
    
    public List<SingleSpecializationBuilder> getCopyOfBuilders() {
        final List<SingleSpecializationBuilder> result =
                        new ArrayList<SingleSpecializationBuilder>(this.singleBuilders.size());
        Collections.copy(result, this.singleBuilders);
        return result;
    }
}
