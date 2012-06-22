package org.alia4j.liam.signature;

public enum SignatureKind {
    
    CONSTRUCTOR_CALL, STATICINITIALIZATION, METHOD_CALL, FIELD_GET, FIELD_SET;
    
    @Override
    public String toString() {
        switch (this) {
        case CONSTRUCTOR_CALL:
            return "constructor-call";
            
        case STATICINITIALIZATION:
            return "staticinitialization";
            
        case METHOD_CALL:
            return "method-call";
            
        case FIELD_GET:
            return "field-get";
            
        case FIELD_SET:
            return "field-set";
        default:
            throw new IllegalStateException();
        }
    };
    
}
