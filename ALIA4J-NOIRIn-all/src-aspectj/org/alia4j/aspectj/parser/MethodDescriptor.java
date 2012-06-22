package org.alia4j.aspectj.parser;

class MethodDescriptor {
    
    private final int access;
    
    private final String name;
    
    private final String descriptor;
    
    private final String genericTypeSignature;
    
    private final String[] exceptions;
    
    protected MethodDescriptor(final int access, final String name, final String desc, final String signature,
                    final String[] exceptions) {
        this.access = access;
        this.name = name;
        this.descriptor = desc;
        this.genericTypeSignature = signature;
        this.exceptions = exceptions;
    }
    
    public int getAccess() {
        return this.access;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescriptor() {
        return this.descriptor;
    }
    
    public String getGenericTypeSignature() {
        return this.genericTypeSignature;
    }
    
    public String[] getExceptions() {
        return this.exceptions;
    }
    
}
