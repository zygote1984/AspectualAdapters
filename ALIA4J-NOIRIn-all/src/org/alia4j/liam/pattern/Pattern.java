package org.alia4j.liam.pattern;

import org.alia4j.liam.signature.Signature;

public abstract class Pattern<S extends Signature> {
    
    public abstract boolean match(S signature);
    
    @Override
    abstract public boolean equals(Object obj);
    
    @Override
    abstract public int hashCode();
    
}
