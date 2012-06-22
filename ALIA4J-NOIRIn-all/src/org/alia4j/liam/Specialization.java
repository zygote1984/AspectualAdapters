package org.alia4j.liam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.alia4j.liam.pattern.Pattern;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class Specialization {
    
    private static final MultiMap EMPTY_MULTI_MAP = new MultiValueMap();
    
    private final MultiMap detailedDebugInfo;
    
    private final List<DebugInfo> defaultDebugInfo;
    
    /**
     * @param pattern may not be <code>null</code>.
     * @param predicate may be <code>null</code>. This corresponds to the predicate TRUE.
     * @param contexts may not be <code>null</code>. Use {@link java.util.Collections#emptyList()} if no context values are
     *            exposed. Sometimes, the type parameter cannot be inferred, used
     *            <code>Collections.&lt;Context&gt;emptyList()</code> in this case.
     */
    public Specialization(final Pattern<?> pattern, final Predicate<AtomicPredicate> predicate,
                    final List<? extends Context> contexts) {
        this(pattern, predicate, contexts, null, null);
    }
    
    /**
     * @param pattern may not be <code>null</code>.
     * @param predicate may be <code>null</code>. This corresponds to the predicate TRUE.
     * @param contexts may not be <code>null</code>. Use {@link java.util.Collections#emptyList()} if no context values are
     *            exposed. Sometimes, the type parameter cannot be inferred, used
     *            <code>Collections.&lt;Context&gt;emptyList()</code> in this case.
     */
    public Specialization(final Pattern<?> pattern, final Predicate<AtomicPredicate> predicate,
                    final List<? extends Context> contexts, final DebugInfo defaultDebugInfo) {
        this(pattern, predicate, contexts, defaultDebugInfo, null);
    }
    
    /**
     * @param pattern may not be <code>null</code>.
     * @param predicate may be <code>null</code>. This corresponds to the predicate TRUE.
     * @param contexts may not be <code>null</code>. Use {@link java.util.Collections#emptyList()} if no context values are
     *            exposed. Sometimes, the type parameter cannot be inferred, used
     *            <code>Collections.&lt;Context&gt;emptyList()</code> in this case.
     */
    public Specialization(final Pattern<?> pattern, final Predicate<AtomicPredicate> predicate,
                    final List<? extends Context> contexts, final DebugInfo defaultDebugInfo,
                    final MultiMap detailedDebugInfo) {
        if (pattern == null)
            throw new IllegalArgumentException();
        this.pattern = pattern;
        this.predicate = predicate == null ? TruePredicate.<AtomicPredicate>truePredicate() : predicate;
        if (contexts == null)
            throw new IllegalArgumentException();
        this.contexts = Collections.unmodifiableList(contexts);
        this.detailedDebugInfo = detailedDebugInfo == null ? Specialization.EMPTY_MULTI_MAP : detailedDebugInfo;
        
        this.defaultDebugInfo =
                        defaultDebugInfo == null ? Collections.singletonList(DebugInfo.UNKNOWN_INFO) : Collections
                                        .singletonList(defaultDebugInfo);
    }
    
    public Pattern<?> getPattern() {
        return this.pattern;
    }
    
    private final Pattern<?> pattern;
    
    public List<? extends Context> getContexts() {
        return this.contexts;
    }
    
    public Context[] getContextArray() {
        return this.contexts.toArray(new Context[this.contexts.size()]);
    }
    
    private final List<? extends Context> contexts;
    
    public Predicate<AtomicPredicate> getPredicate() {
        return this.predicate;
    }
    
    private final Predicate<AtomicPredicate> predicate;
    
    // @Override
    // public int hashCode() {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + ((this.contexts == null) ? 0 : this.contexts.hashCode());
    // result = prime * result + ((this.pattern == null) ? 0 : this.pattern.hashCode());
    // result = prime * result + ((this.predicate == null) ? 0 : this.predicate.hashCode());
    // return result;
    // }
    //
    // @Override
    // public boolean equals(final Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (this.getClass() != obj.getClass())
    // return false;
    // final Specialization other = (Specialization) obj;
    // if (this.contexts == null) {
    // if (other.contexts != null)
    // return false;
    // } else if (!this.contexts.equals(other.contexts))
    // return false;
    // if (this.pattern == null) {
    // if (other.pattern != null)
    // return false;
    // } else if (!this.pattern.equals(other.pattern))
    // return false;
    // if (this.predicate == null) {
    // if (other.predicate != null)
    // return false;
    // } else if (!this.predicate.equals(other.predicate))
    // return false;
    // return true;
    // }
    
    @Override
    public String toString() {
        final StringBuffer buffer = new StringBuffer();
        
        buffer.append(this.getPattern());
        buffer.append(" exposes");
        buffer.append(this.contexts.toString());
        buffer.append(" when ");
        buffer.append(this.getPredicate());
        
        return buffer.toString();
    }
    
    public static boolean areEqual(Specialization first, Specialization second) {
        if (first == second)
            return true;
        if (first == null || second == null)
            return false;
        
        if (first.contexts == null) {
            if (second.contexts != null)
                return false;
        } else if (!first.contexts.equals(second.contexts))
            return false;
        
        if (first.pattern == null) {
            if (second.pattern != null)
                return false;
        } else if (!first.pattern.equals(second.pattern))
            return false;
        
        if (first.predicate == null) {
            if (second.predicate != null)
                return false;
        } else if (!first.predicate.equals(second.predicate))
            return false;
        
        return true;
    }
    
    /**
     * For an object which is part of this Specialization, return the source locations from which it is compiled. If no
     * detailed info was defined for the entity or is {@code null} is passed as entity, the default debug info is returned.
     * 
     * @see Attachment#getDebugInfo(Object)
     * @param entity an object which is part of this Specialization (or null to get the default info). I.e., a Context,
     *            Predicate, AtomicPredicate or Pattern, or ScheduleInfo, or objects referenced by them.
     * @return
     */
    public List<DebugInfo> getDebugInfo(Object entity) {
        if (entity == null || !this.detailedDebugInfo.containsKey(entity)) {
            return this.defaultDebugInfo;
        } else {
            return (List<DebugInfo>) this.detailedDebugInfo.get(entity);
        }
    }
    
    /**
     * Returns a list of all debug information stored for objects which are part of this Specialization. If no detailed
     * information is stored, this method returns either a singleton list of the default info or an empty list if the default
     * info is {@link DebugInfo#UNKNOWN_INFO}.
     * 
     * @return
     */
    public List<DebugInfo> getAllDebugInfo() {
        if (this.detailedDebugInfo.isEmpty()) {
            if (this.defaultDebugInfo.size() == 1 && this.defaultDebugInfo.get(0) == DebugInfo.UNKNOWN_INFO)
                return Collections.emptyList();
            else
                return this.defaultDebugInfo;
        } else {
            List<DebugInfo> result = new ArrayList<DebugInfo>();
            Collection<List<DebugInfo>> allValues = this.detailedDebugInfo.values();
            for (List<DebugInfo> current : allValues) {
                result.addAll(current);
            }
            return result;
        }
    }
    
}
