/* Generated By:JJTree: Do not edit this line. ASTNegatedPointcutExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTNegatedPointcutExpression extends SimpleNode {
  public ASTNegatedPointcutExpression(int id) {
    super(id);
  }

  public ASTNegatedPointcutExpression(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=325e4a38ecd1797477187cc84b0a4f6e (do not edit this line) */
