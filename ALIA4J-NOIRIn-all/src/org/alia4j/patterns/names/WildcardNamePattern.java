package org.alia4j.patterns.names;

import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.alia4j.patterns.NamePattern;

public class WildcardNamePattern extends NamePattern {
    
    final private Matcher matcher;
    
    private final String expression;
    
    public WildcardNamePattern(final List<NameElement> namePatternElements) {
        final StringBuilder regularExpression = new StringBuilder();
        int wildcards = 0;
        final ListIterator<NameElement> iter = namePatternElements.listIterator();
        boolean previousWasWildcard = false;
        while (iter.hasNext()) {
            final NameElement current = iter.next();
            if (current.isWildcard()) {
                if (previousWasWildcard) {
                    // ignore several sequential wildcards
                } else {
                    regularExpression.append("[\\d\\w]*");
                    previousWasWildcard = true;
                    wildcards++;
                }
            } else {
                regularExpression.append(current.getIdentifier());
                previousWasWildcard = false;
            }
        }
        this.expression = regularExpression.toString();
        final Pattern pattern = Pattern.compile(this.expression);
        this.matcher = pattern.matcher("");
    }
    
    @Override
    public boolean matches(final CharSequence name) {
        synchronized (this.matcher) {
            this.matcher.reset(name);
            return this.matcher.matches();
        }
    }
    
    @Override
    public String toString() {
        return this.matcher.pattern().pattern();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.expression == null) ? 0 : this.expression.hashCode());
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
        final WildcardNamePattern other = (WildcardNamePattern) obj;
        if (this.expression == null) {
            if (other.expression != null)
                return false;
        } else if (!this.expression.equals(other.expression))
            return false;
        return true;
    }
    
}
