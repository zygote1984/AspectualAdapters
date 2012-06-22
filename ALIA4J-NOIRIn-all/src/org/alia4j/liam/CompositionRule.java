package org.alia4j.liam;

import java.util.Set;

public final class CompositionRule {
    
    private final Set<? extends AttachmentReference> present;
    
    private final Set<? extends AttachmentReference> absent;
    
    private final Set<? extends AttachmentReference> required;
    
    private final Set<? extends AttachmentReference> forbidden;
    
    private final boolean healing;
    
    public CompositionRule(Set<? extends AttachmentReference> present, Set<? extends AttachmentReference> absent,
                    Set<? extends AttachmentReference> required, Set<? extends AttachmentReference> forbidden,
                    boolean healing) {
        super();
        this.present = present;
        this.absent = absent;
        this.required = required;
        this.forbidden = forbidden;
        this.healing = healing;
    }
    
    public Set<? extends AttachmentReference> getPresent() {
        return this.present;
    }
    
    public Set<? extends AttachmentReference> getAbsent() {
        return this.absent;
    }
    
    public Set<? extends AttachmentReference> getRequired() {
        return this.required;
    }
    
    public Set<? extends AttachmentReference> getForbidden() {
        return this.forbidden;
    }
    
    public boolean isHealing() {
        return this.healing;
    }
    
}
