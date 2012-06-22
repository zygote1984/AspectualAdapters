package org.alia4j.liam;

import java.util.Set;

public final class PrecedenceRule {
    
    private final Set<Attachment> preceeding;
    
    private final Set<Attachment> preceeded;
    
    public PrecedenceRule(Set<Attachment> preceeding, Set<Attachment> preceeded) {
        super();
        this.preceeding = preceeding;
        this.preceeded = preceeded;
    }
    
    public Set<Attachment> getPreceeding() {
        return this.preceeding;
    }
    
    public Set<Attachment> getPreceeded() {
        return this.preceeded;
    }
    
}
