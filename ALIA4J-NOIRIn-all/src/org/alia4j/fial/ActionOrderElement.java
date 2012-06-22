package org.alia4j.fial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class ActionOrderElement implements Iterable<ActionOrderElement> {
    
    ActionOrderElement inner;
    
    private final List<AttachedAction> before = new ArrayList<AttachedAction>();
    
    AttachedAction around;
    
    private final List<AttachedAction> after = new ArrayList<AttachedAction>();
    
    public ActionOrderElement() {
        this(null);
    }
    
    protected ActionOrderElement(final ActionOrderElement inner) {
        this.inner = inner;
    }
    
    public List<AttachedAction> getBefore() {
        return this.before;
    }
    
    public AttachedAction getAround() {
        return this.around;
    }
    
    public List<AttachedAction> getAfter() {
        return this.after;
    }
    
    public ActionOrderElement getInner() {
        return this.inner;
    }
    
    @Override
    public String toString() {
        final StringBuffer buffer = new StringBuffer();
        
        for (final ActionOrderElement element : this) {
            buffer.append('(');
            for (final AttachedAction action : element.getBefore()) {
                buffer.append(action);
                buffer.append(',');
                buffer.append(' ');
            }
            buffer.append(element.getAround());
        }
        
        for (final ActionOrderElement element : this) {
            for (final AttachedAction action : element.getAfter()) {
                buffer.append(',');
                buffer.append(' ');
                buffer.append(action);
            }
            buffer.append(')');
        }
        
        return buffer.toString();
    }
    
    // TODO: iterator semantics not correctly implemented
    public Iterator<ActionOrderElement> iterator() {
        return new ElementIterator();
    }
    
    private final class ElementIterator implements Iterator<ActionOrderElement> {
        
        private ActionOrderElement next = ActionOrderElement.this;
        
        public boolean hasNext() {
            return this.next != null;
        }
        
        public ActionOrderElement next() {
            if (this.next == null)
                throw new NoSuchElementException();
            
            final ActionOrderElement result = this.next;
            this.next = this.next.inner;
            return result;
        }
        
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }
}
