package org.alia4j.liam.pattern;

import org.alia4j.liam.signature.StaticInitializerSignature;
import org.alia4j.patterns.ClassTypePattern;

public class StaticInitializerPattern extends Pattern<StaticInitializerSignature> {
    
    public static final StaticInitializerPattern ANY = new StaticInitializerPattern(ClassTypePattern.ANY);
    
    private final ClassTypePattern declaringClassPattern;
    
    public StaticInitializerPattern(final ClassTypePattern declaringClassPattern) {
        super();
        this.declaringClassPattern = declaringClassPattern;
    }
    
    public ClassTypePattern getDeclaringClassPattern() {
        return this.declaringClassPattern;
    }
    
    @Override
    public boolean match(final StaticInitializerSignature signature) {
        return this.declaringClassPattern.matches(signature.getDeclaringClass());
    }
    
    @Override
    public String toString() {
        return this.declaringClassPattern.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.declaringClassPattern == null) ? 0 : this.declaringClassPattern.hashCode());
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
        final StaticInitializerPattern other = (StaticInitializerPattern) obj;
        if (this.declaringClassPattern == null) {
            if (other.declaringClassPattern != null)
                return false;
        } else if (!this.declaringClassPattern.equals(other.declaringClassPattern))
            return false;
        return true;
    }
    
}
