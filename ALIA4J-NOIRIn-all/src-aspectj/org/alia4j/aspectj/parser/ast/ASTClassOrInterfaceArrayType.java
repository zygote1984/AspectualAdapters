/* Generated By:JJTree: Do not edit this line. ASTClassOrInterfaceArrayType.java Version 4.1 */
/*
 * JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=
 */
package org.alia4j.aspectj.parser.ast;

public class ASTClassOrInterfaceArrayType extends SimpleNode {
    
    public ASTClassOrInterfaceArrayType(final int id) {
        super(id);
    }
    
    public ASTClassOrInterfaceArrayType(final AJPointcutParser p, final int id) {
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
/* JavaCC - OriginalChecksum=9123dbda4f500d70777aab112f764715 (do not edit this line) */
