/* Generated By:JJTree: Do not edit this line. ASTUnknownTypeArgument.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTUnknownTypeArgument extends SimpleNode {
  public ASTUnknownTypeArgument(int id) {
    super(id);
  }

  public ASTUnknownTypeArgument(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=0dba2a7e06171a04c532e504f6131976 (do not edit this line) */
