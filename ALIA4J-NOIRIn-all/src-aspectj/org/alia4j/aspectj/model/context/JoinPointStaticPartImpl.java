package org.alia4j.aspectj.model.context;

import org.aspectj.lang.Signature;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.reflect.SourceLocation;

class JoinPointStaticPartImpl implements StaticPart {
    
    private final String kind;
    
    private final Signature signature;
    
    private final SourceLocation sourceLocation;
    
    protected JoinPointStaticPartImpl(final String kind, final Signature signature, final SourceLocation sourceLocation) {
        super();
        this.kind = kind;
        this.signature = signature;
        this.sourceLocation = sourceLocation;
    }
    
    public String getKind() {
        return this.kind;
    }
    
    public Signature getSignature() {
        return this.signature;
    }
    
    public SourceLocation getSourceLocation() {
        return this.sourceLocation;
    }
    
    public String toLongString() {
        return this.toString();
    }
    
    public String toShortString() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        return this.kind + " " + this.signature + " " + this.sourceLocation;
    }
    
    @Override
    public int getId() {
        throw new UnsupportedOperationException();
    }
}
