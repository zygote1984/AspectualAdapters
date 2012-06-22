package org.alia4j.aspectj.model.context;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;

class JoinPointImpl implements JoinPoint {
    
    private final StaticPart staticPart;
    
    private final Object thiz;
    
    private final Object target;
    
    private final Object[] arguments;
    
    protected JoinPointImpl(final StaticPart staticPart, final Object thiz, final Object target, final Object[] arguments) {
        this.staticPart = staticPart;
        this.thiz = thiz;
        this.target = target;
        this.arguments = arguments;
    }
    
    public Object[] getArgs() {
        return this.arguments;
    }
    
    public String getKind() {
        return this.staticPart.getKind();
    }
    
    public Signature getSignature() {
        return this.staticPart.getSignature();
    }
    
    public SourceLocation getSourceLocation() {
        return this.staticPart.getSourceLocation();
    }
    
    public StaticPart getStaticPart() {
        return this.staticPart;
    }
    
    public Object getTarget() {
        return this.target;
    }
    
    public Object getThis() {
        return this.thiz;
    }
    
    public String toLongString() {
        return this.staticPart.toLongString();
    }
    
    public String toShortString() {
        return this.staticPart.toShortString();
    }
    
    @Override
    public String toString() {
        return this.staticPart.toString();
    }
    
}
