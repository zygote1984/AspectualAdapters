package org.alia4j.aspectj.parser;

/**
 * Used during the translation of a parse tree for a pointcut to an Execution Model pattern. Used as result for parsing the
 * TypeIdStar rule.
 * 
 * @author Christoph Bockisch
 */
class TypeOrIdOrStar {
    
    private String typeOrId;
    
    private boolean includeSubTypes;
    
    private boolean isWildcard;
    
    protected TypeOrIdOrStar(final String typeOrId, final boolean includeSubTypes) {
        this.typeOrId = typeOrId;
        this.includeSubTypes = includeSubTypes;
    }
    
    protected TypeOrIdOrStar() {
        this.isWildcard = true;
    }
    
    protected String getTypeOrId() {
        return this.typeOrId;
    }
    
    protected boolean includeSubTypes() {
        return this.includeSubTypes;
    }
    
    protected boolean isWildcard() {
        return this.isWildcard;
    }
    
    protected boolean isTypeOrId() {
        return this.typeOrId == null;
    }
}
