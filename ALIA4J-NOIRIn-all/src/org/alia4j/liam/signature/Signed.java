package org.alia4j.liam.signature;

public interface Signed<S extends Signature> {
    
    public abstract S getSignature();
}
