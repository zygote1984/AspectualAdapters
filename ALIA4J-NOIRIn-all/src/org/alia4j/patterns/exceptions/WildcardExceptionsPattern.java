package org.alia4j.patterns.exceptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.patterns.ExceptionsPattern;
import org.alia4j.patterns.TypePattern;

public class WildcardExceptionsPattern extends ExceptionsPattern {
    
    private final List<TypePattern> positiveTypePatterns = new ArrayList<TypePattern>();
    
    private final List<TypePattern> negativeTypePatterns = new ArrayList<TypePattern>();
    
    public WildcardExceptionsPattern(final List<ExceptionsPatternElement> patternElements) {
        for (final ExceptionsPatternElement current : patternElements) {
            if (current.isNegative()) {
                this.negativeTypePatterns.add(current.getTypePattern());
            } else if (current.isPositive()) {
                this.positiveTypePatterns.add(current.getTypePattern());
            }
        }
    }
    
    @Override
    public boolean matches(final TypeDescriptor[] exceptionTypeNames) {
        if (exceptionTypeNames.length == 0 || (exceptionTypeNames.length == 1 && exceptionTypeNames[0].equals("")))
            throw new IllegalArgumentException("The Pattern cannot be empty");
        
        // check, if no absolutely negated exception is in the pattern.
        for (int i = 0; i < this.negativeTypePatterns.size(); i++) {
            for (final TypeDescriptor element : exceptionTypeNames) {
                if (this.negativeTypePatterns.get(i).matches(element))
                    return false;
            }
        }
        
        // check for occurrences of the exceptions which must be in the pattern.
        for (int i = 0; i < this.positiveTypePatterns.size(); i++) {
            boolean ok = false;
            for (final TypeDescriptor element : exceptionTypeNames) {
                if (this.positiveTypePatterns.get(i).matches(element)) {
                    ok = true;
                    break;
                }
            }
            if (!ok)
                return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        if (!this.positiveTypePatterns.isEmpty()) {
            final Iterator<TypePattern> it = this.positiveTypePatterns.iterator();
            while (it.hasNext()) {
                result.append(it.next().toString());
                if (it.hasNext())
                    result.append(", ");
            }
            if (!this.negativeTypePatterns.isEmpty())
                result.append(" ");
        }
        if (!this.negativeTypePatterns.isEmpty()) {
            result.append("!(");
            final Iterator<TypePattern> it = this.negativeTypePatterns.iterator();
            while (it.hasNext()) {
                result.append(it.next().toString());
                if (it.hasNext())
                    result.append(", ");
            }
            result.append(")");
        }
        return result.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.negativeTypePatterns == null) ? 0 : this.negativeTypePatterns.hashCode());
        result = prime * result + ((this.positiveTypePatterns == null) ? 0 : this.positiveTypePatterns.hashCode());
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
        final WildcardExceptionsPattern other = (WildcardExceptionsPattern) obj;
        if (this.negativeTypePatterns == null) {
            if (other.negativeTypePatterns != null)
                return false;
        } else if (!this.negativeTypePatterns.equals(other.negativeTypePatterns))
            return false;
        if (this.positiveTypePatterns == null) {
            if (other.positiveTypePatterns != null)
                return false;
        } else if (!this.positiveTypePatterns.equals(other.positiveTypePatterns))
            return false;
        return true;
    }
    
}
