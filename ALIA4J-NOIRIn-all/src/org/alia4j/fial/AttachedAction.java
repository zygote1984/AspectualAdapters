package org.alia4j.fial;

import java.util.List;
import org.alia4j.liam.Action;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.ScheduleInfo;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class AttachedAction {
    
    /**
     * @param action may not be {@code null}.
     * @param contexts may not be {@code null}.
     * @param scheduleInfo may not be {@code null}.
     * @param attachment may not be {@code null}. The attachment that lead to this AttachedAction.
     * @throws IllegalArgumentException
     */
    public AttachedAction(final Action action, final List<? extends Context> contexts, final ScheduleInfo scheduleInfo,
                    Attachment attachment) throws IllegalArgumentException {
        if (action == null)
            throw new IllegalArgumentException("Action required");
        this.action = action;
        if (contexts == null)
            throw new IllegalArgumentException("Contexts required");
        this.contexts = contexts;
        if (scheduleInfo == null)
            throw new IllegalArgumentException("Contexts required");
        this.scheduleInfo = scheduleInfo;
        if (attachment == null)
            throw new IllegalArgumentException("Attachment required");
        this.attachment = attachment;
    }
    
    public Action getAction() {
        return this.action;
    }
    
    private final Action action;
    
    public List<? extends Context> getContexts() {
        return this.contexts;
    }
    
    public Context[] getContextArray() {
        return this.contexts.toArray(new Context[this.contexts.size()]);
    }
    
    private final List<? extends Context> contexts;
    
    public ScheduleInfo getScheduleInfo() {
        return this.scheduleInfo;
    }
    
    private final ScheduleInfo scheduleInfo;
    
    @Override
    public String toString() {
        return "AttachedAction [scheduleInfo=" + this.scheduleInfo + ", contexts=" + this.contexts + ", action="
                        + this.action + "]";
    }
    
    private final Attachment attachment;
    
    public Attachment getAttachment() {
        return this.attachment;
    }
    
    private Context toArrayContextForExposedContexts;
    
    public Context getToArrayContextForExposedContexts() {
        if (this.toArrayContextForExposedContexts == null) {
            Context[] expopsedContextsArray = new Context[this.contexts.size()];
            this.toArrayContextForExposedContexts =
                            ContextFactory.findOrCreateToArrayContext(this.contexts.toArray(expopsedContextsArray));
        }
        return this.toArrayContextForExposedContexts;
    }
}
