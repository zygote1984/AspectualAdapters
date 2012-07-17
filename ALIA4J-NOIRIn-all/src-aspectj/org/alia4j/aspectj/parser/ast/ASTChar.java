/* Generated By:JJTree: Do not edit this line. ASTChar.java Version 4.1 */
/*
 * JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=
 */
package org.alia4j.aspectj.parser.ast;

import org.alia4j.aspectj.parser.PrimitiveType;

public class ASTChar extends SimpleNode implements PrimitiveType {
    
    public ASTChar(final int id) {
        super(id);
    }
    
    public ASTChar(final AJPointcutParser p, final int id) {
        super(p, id);
    }
    
    /** Accept the visitor. **/
    @Override
    public Object jjtAccept(final AJPointcutParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
    
    public String getTypeName() {
        return "char";
    }
    
}
/* JavaCC - OriginalChecksum=e86b5254058da284707048b78baf90f7 (do not edit this line) */