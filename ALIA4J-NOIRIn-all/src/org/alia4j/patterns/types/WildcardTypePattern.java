package org.alia4j.patterns.types;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.patterns.ClassTypePattern;

public class WildcardTypePattern extends ClassTypePattern {
    
    private final List<NamespaceElement> elementList;
    
    public WildcardTypePattern(final List<NamespaceElement> namespacePatternElements) {
        this.elementList = namespacePatternElements;
    }
    
    @Override
    public boolean matches(final TypeDescriptor typeDescriptor) {
        if (!typeDescriptor.isClassType())
            return false;
        
        return this.matchesRek(new ListIterator<CharSequence>() {
            
            private int nextCursor = 0;
            
            private final CharSequence[] array = typeDescriptor.getNameElements();
            
            @Override
            public void set(final CharSequence e) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public CharSequence previous() {
                final CharSequence result = this.array[this.nextCursor - 1];
                this.nextCursor--;
                return result;
            }
            
            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public CharSequence next() {
                final CharSequence result = this.array[this.nextCursor];
                this.nextCursor++;
                return result;
            }
            
            @Override
            public boolean hasPrevious() {
                return this.nextCursor > 0;
            }
            
            @Override
            public boolean hasNext() {
                return this.nextCursor < this.array.length;
            }
            
            @Override
            public void add(final CharSequence e) {
                throw new UnsupportedOperationException();
            }
        }, this.elementList.listIterator());
    }
    
    private boolean matchesRek(final ListIterator<CharSequence> targetIt, final ListIterator<NamespaceElement> elementsIt) {
        
        while (elementsIt.hasNext() && targetIt.hasNext()) {
            NamespaceElement element = elementsIt.next();
            CharSequence target = targetIt.next();
            if (element.isRest()) {
                if (elementsIt.hasNext()) {
                    element = elementsIt.next();
                    if (!elementsIt.hasNext()) {
                        while (targetIt.hasNext())
                            target = targetIt.next();
                    }
                }
                boolean match = false;
                if (element.matches(target))
                    match = true;
                
                while (!match && targetIt.hasNext()) {
                    target = targetIt.next();
                    if (element.matches(target)) {
                        targetIt.previous();
                        if (this.matchesRek(targetIt, this.elementList.listIterator(elementsIt.nextIndex() - 1)))
                            return true;
                    }
                }
                if (!match)
                    return false;
            }
            if (!element.matches(target))
                return false;
        }
        if (!elementsIt.hasNext() && !targetIt.hasNext())
            return true;
        else
            return false;
    }
    
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        final Iterator<NamespaceElement> it = this.elementList.iterator();
        while (it.hasNext()) {
            result.append(it.next().toString());
            if (it.hasNext())
                result.append('.');
        }
        return result.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.elementList == null) ? 0 : this.elementList.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        final WildcardTypePattern other = (WildcardTypePattern) obj;
        if (this.elementList == null) {
            if (other.elementList != null)
                return false;
        } else if (!this.elementList.equals(other.elementList))
            return false;
        return true;
    }
    
}
