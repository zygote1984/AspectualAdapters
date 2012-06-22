package org.alia4j.liam.signature;

/**
 * @author Andreas Sewe
 */
public final class SignatureKindProcessor implements SignatureProcessor<SignatureKind> {
    
    @Override
    public SignatureKind process(final ConstructorSignature signature) {
        return SignatureKind.CONSTRUCTOR_CALL;
    }
    
    @Override
    public SignatureKind process(final StaticInitializerSignature signature) {
        return SignatureKind.STATICINITIALIZATION;
    }
    
    @Override
    public SignatureKind process(final MethodSignature signature) {
        return SignatureKind.METHOD_CALL;
    }
    
    @Override
    public SignatureKind process(final FieldReadSignature signature) {
        return SignatureKind.FIELD_GET;
    }
    
    @Override
    public SignatureKind process(final FieldWriteSignature signature) {
        return SignatureKind.FIELD_SET;
    }
    
}
