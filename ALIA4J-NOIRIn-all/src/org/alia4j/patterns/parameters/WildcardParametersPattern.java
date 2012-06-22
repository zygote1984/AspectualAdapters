package org.alia4j.patterns.parameters;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.patterns.ParametersPattern;

public class WildcardParametersPattern extends ParametersPattern {
    
    private int restPosition;
    
    private final List<? extends ParametersPatternElement> patterns;
    
    /**
     * @param parametersPatternElements may contain at most one "rest" element (multiple consecutive rest elements are
     *            regarded as one).
     */
    public WildcardParametersPattern(final List<? extends ParametersPatternElement> parametersPatternElements) {
        this.restPosition = -1;
        int numberOfRests = 0;
        int index = 0;
        boolean previousWasRest = false;
        final ListIterator<? extends ParametersPatternElement> iter = parametersPatternElements.listIterator();
        while (iter.hasNext()) {
            final ParametersPatternElement current = iter.next();
            if (current.isRest()) {
                if (previousWasRest) {
                    iter.remove();
                } else {
                    this.restPosition = index; // it is safe to overwrite this each time,
                    // because we will produce an exception is
                    // multiple rest operators are present
                    numberOfRests++;
                    previousWasRest = true;
                }
            } else
                previousWasRest = false;
            index++;
        }
        if (numberOfRests > 1)
            throw new IllegalArgumentException("Pattern contains " + numberOfRests
                            + " rest operators (..). Only one is allowed.");
        this.patterns = parametersPatternElements;
    }
    
    @Override
    public boolean matches(final TypeDescriptor[] typeDescriptors) {
        // special case: pattern is empty arguments list
        if (this.patterns.size() == 0 && typeDescriptors.length > 0)
            return false;
        
        for (int i = 0; i < this.restPosition; i++) {
            if (i >= typeDescriptors.length)
                return false;
            if (!this.patterns.get(i).matches(typeDescriptors[i]))
                return false;
        }
        final int patternAfterRest = this.restPosition + 1;
        final int remainingPatterns = this.patterns.size() - patternAfterRest;
        if (remainingPatterns == 0)
            return true;
        final int stringAfterRest = typeDescriptors.length - remainingPatterns;
        if (this.restPosition == -1 && stringAfterRest != 0)
            return false;
        if (stringAfterRest < this.restPosition)
            return false;
        for (int i = 0; i < remainingPatterns; i++) {
            if (!this.patterns.get(patternAfterRest + i).matches(typeDescriptors[stringAfterRest + i]))
                return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        final Iterator<? extends ParametersPatternElement> it = this.patterns.iterator();
        while (it.hasNext()) {
            result.append(it.next().toString());
            if (it.hasNext())
                result.append(", ");
        }
        return result.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.patterns == null) ? 0 : this.patterns.hashCode());
        result = prime * result + this.restPosition;
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
        final WildcardParametersPattern other = (WildcardParametersPattern) obj;
        if (this.patterns == null) {
            if (other.patterns != null)
                return false;
        } else if (!this.patterns.equals(other.patterns))
            return false;
        if (this.restPosition != other.restPosition)
            return false;
        return true;
    }
    
}
