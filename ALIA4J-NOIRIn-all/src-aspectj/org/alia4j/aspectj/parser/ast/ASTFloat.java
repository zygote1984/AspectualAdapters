/* Generated By:JJTree: Do not edit this line. ASTFloat.java Version 4.1 */
/*
 * JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=
 */
package org.alia4j.aspectj.parser.ast;

import org.alia4j.aspectj.parser.PrimitiveType;

public class ASTFloat extends SimpleNode implements PrimitiveType {
    
    public ASTFloat(final int id) {
        super(id);
    }
    
    public ASTFloat(final AJPointcutParser p, final int id) {
        super(p, id);
    }
    
    /** Accept the visitor. **/
    @Override
    public Object jjtAccept(final AJPointcutParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
    
    public String getTypeName() {
        return "float";
    }
    
}
/* JavaCC - OriginalChecksum=773f38fec592bb0c40b209fff56c6c86 (do not edit this line) */