/* Generated By:JJTree: Do not edit this line. ASTAndPointcutExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTAndPointcutExpression extends SimpleNode {
  public ASTAndPointcutExpression(int id) {
    super(id);
  }

  public ASTAndPointcutExpression(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=2afdcf363e0a61642b90b2e4b33cd9c5 (do not edit this line) */