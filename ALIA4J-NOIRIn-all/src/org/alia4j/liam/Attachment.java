package org.alia4j.liam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class Attachment implements AttachmentReference {
    
    private static final MultiMap EMPTY_MULTI_MAP = new MultiValueMap();
    
    private final MultiMap detailedDebugInfo;
    
    /**
     * @param specializations may not be {@code null}
     * @param target may not be {@code null}
     * @param action may not be {@code null}
     * @param scheduleInfo may not be {@code null}
     * @throws IllegalArgumentException
     */
    public Attachment(final Set<Specialization> specializations, final Action action, final ScheduleInfo scheduleInfo)
                    throws IllegalArgumentException {
        this(specializations, action, scheduleInfo, null, null);
    }
    
    /**
     * @param specializations may not be {@code null}
     * @param target may not be {@code null}
     * @param action may not be {@code null}
     * @param scheduleInfo may not be {@code null}
     * @param defaultDebugInfo this info will be used as default, see {@link Attachment#getDebugInfo(Object)}.
     * @throws IllegalArgumentException
     */
    public Attachment(final Set<Specialization> specializations, final Action action, final ScheduleInfo scheduleInfo,
                    final DebugInfo defaultDebugInfo) throws IllegalArgumentException {
        this(specializations, action, scheduleInfo, defaultDebugInfo, null);
    }
    
    /**
     * @param specializations may not be {@code null}
     * @param target may not be {@code null}
     * @param action may not be {@code null}
     * @param scheduleInfo may not be {@code null}
     * @param defaultDebugInfo this info will be used as default, see {@link Attachment#getDebugInfo(Object)}.
     * @param detailedDebugInfo mapping for objects (specifically LIAM entities) that comprise this Attachment to where they
     *            are compiled from. See {@link Attachment#getDebugInfo(Object)}.
     * @throws IllegalArgumentException
     */
    public Attachment(final Set<Specialization> specializations, final Action action, final ScheduleInfo scheduleInfo,
                    final DebugInfo defaultDebugInfo, final MultiMap detailedDebugInfo) throws IllegalArgumentException {
        this.detailedDebugInfo = detailedDebugInfo == null ? Attachment.EMPTY_MULTI_MAP : detailedDebugInfo;
        if (specializations == null)
            throw new IllegalArgumentException();
        this.specializations = specializations;
        if (action == null)
            throw new IllegalArgumentException();
        this.action = action;
        if (scheduleInfo == null)
            throw new IllegalArgumentException();
        this.scheduleInfo = scheduleInfo;
        this.defaultDebugInfo =
                        defaultDebugInfo == null ? Collections.singletonList(DebugInfo.UNKNOWN_INFO) : Collections
                                        .singletonList(defaultDebugInfo);
        
        if (action.triggersEvent() && scheduleInfo.getTime() != ActionTime.WHEN) {
            throw new IllegalArgumentException("Event triggering actions may only be used with 'when' schedule info.");
        }
        
        // TODO more appropriate check necessary. Arguments must be compatible
        int contextCount = -1;
        for (final Specialization currentSpecialization : this.getSpecializations()) {
            if (contextCount == -1) {
                contextCount = currentSpecialization.getContexts().size();
            } else {
                if (contextCount != currentSpecialization.getContexts().size())
                    throw new IllegalArgumentException("Specialization (" + currentSpecialization
                                    + ") has inappropriate number of context values ("
                                    + currentSpecialization.getContexts().size() + " instead of " + contextCount + ").");
            }
        }
        
        // TODO check that all specializations have distinct kinds of patterns
        // if this is not the case, check that specializations for the same kind of
        // patterns are compatible and merge the
    }
    
    public Set<Specialization> getSpecializations() {
        return this.specializations;
    }
    
    public Specialization[] getSpecializationArray() {
        return this.specializations.toArray(new Specialization[this.specializations.size()]);
    }
    
    private final Set<Specialization> specializations;
    
    public Action getAction() {
        return this.action;
    }
    
    private final Action action;
    
    public ScheduleInfo getScheduleInfo() {
        return this.scheduleInfo;
    }
    
    private final ScheduleInfo scheduleInfo;
    
    /**
     * For an object which is part of this Attachment, return the source locations from which it is compiled. If no detailed
     * info was defined for the entity or is {@code null} is passed as entity, the default debug info is returned.
     * 
     * @see Specialization#getDebugInfo(Object)
     * @param entity an object which is part of this Attachment (or null to get the default info). I.e., an Action or
     *            ScheduleInfo, or objects referenced by them.
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
     * Returns a list of all debug information stored for objects which are part of this Attachment. If no debug info is
     * stored for the Attachment's Specializations and no detailed information is stored for this Attachment, this method
     * returns either a singleton list of the default info or an empty list if the default info is
     * {@link DebugInfo#UNKNOWN_INFO}.
     * 
     * @return
     */
    public List<DebugInfo> getAllDebugInfo() {
        List<DebugInfo> result = new ArrayList<DebugInfo>();
        for (Specialization specialization : this.getSpecializations()) {
            result.addAll(specialization.getAllDebugInfo());
        }
        if (result.isEmpty() && this.detailedDebugInfo.isEmpty()) {
            if (this.defaultDebugInfo.size() == 1 && this.defaultDebugInfo.get(0) == DebugInfo.UNKNOWN_INFO)
                return Collections.emptyList();
            else
                return this.defaultDebugInfo;
        } else {
            Collection<List<DebugInfo>> allValues = this.detailedDebugInfo.values();
            for (List<DebugInfo> current : allValues) {
                result.addAll(current);
            }
            return result;
        }
    }
    
    private final List<DebugInfo> defaultDebugInfo;
    
    // @Override
    // public int hashCode() {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + ((this.action == null) ? 0 : this.action.hashCode());
    // result = prime * result + ((this.debugInfo == null) ? 0 : this.debugInfo.hashCode());
    // result = prime * result + ((this.scheduleInfo == null) ? 0 : this.scheduleInfo.hashCode());
    // result = prime * result + ((this.specializations == null) ? 0 : this.specializations.hashCode());
    // return result;
    // }
    //
    
    public static boolean areEqual(final Attachment first, final Attachment second) {
        if (first == second)
            return true;
        if (first == null || second == null)
            return false;
        
        if (first.action == null) {
            if (second.action != null)
                return false;
        } else if (!first.action.equals(second.action))
            return false;
        
        if (first.defaultDebugInfo == null) {
            if (second.defaultDebugInfo != null)
                return false;
        } else if (!first.defaultDebugInfo.equals(second.defaultDebugInfo))
            return false;
        
        if (first.scheduleInfo == null) {
            if (second.scheduleInfo != null)
                return false;
        } else if (!first.scheduleInfo.equals(second.scheduleInfo))
            return false;
        
        if (first.specializations == null) {
            if (second.specializations != null)
                return false;
        } else {
            if (first.specializations.size() != second.specializations.size())
                return false;
            loopFirst: for (Specialization firstSpec : first.specializations) {
                for (Specialization secondSpec : second.specializations) {
                    if (Specialization.areEqual(firstSpec, secondSpec))
                        // we found a match for firstSpec, continue iterating first.specializations
                        continue loopFirst;
                }
                // we did not find a match for firstSpec, therefore the specialization sets cannot be equal
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuffer result = new StringBuffer();
        
        result.append(this.action.toString());
        result.append('\t');
        result.append(this.specializations.toString());
        result.append('\n');
        result.append(this.getScheduleInfo());
        
        return result.toString();
    }
    
    @Override
    public boolean references(Attachment attachment) {
        return attachment == this;
    }
}
