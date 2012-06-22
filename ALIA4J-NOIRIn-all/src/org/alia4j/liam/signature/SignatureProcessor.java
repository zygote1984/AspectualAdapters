package org.alia4j.liam.signature;

public interface SignatureProcessor<T> {
    
    public T process(ConstructorSignature signature);
    
    public T process(StaticInitializerSignature signature);
    
    public T process(MethodSignature signature);
    
    public T process(FieldReadSignature signature);
    
    public T process(FieldWriteSignature signature);
}
