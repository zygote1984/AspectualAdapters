/* Generated By:JJTree: Do not edit this line. ASTPrimitiveArrayType.java Version 4.1 */
/*
 * JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=
 */
package org.alia4j.aspectj.parser.ast;

public class ASTPrimitiveArrayType extends SimpleNode {
    
    public ASTPrimitiveArrayType(final int id) {
        super(id);
    }
    
    public ASTPrimitiveArrayType(final AJPointcutParser p, final int id) {
        super(p, id);
    }
    
    /** Accept the visitor. **/
    @Override
    public Object jjtAccept(final AJPointcutParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
    
    public int dimension;
    
    public int getDimension() {
        return this.dimension;
    }
    
}
/* JavaCC - OriginalChecksum=d9deaa344d987901985e9a4b053bb85e (do not edit this line) */
