/* Generated By:JJTree: Do not edit this line. ASTAndTypePatternExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTAndTypePatternExpression extends SimpleNode {
  public ASTAndTypePatternExpression(int id) {
    super(id);
  }

  public ASTAndTypePatternExpression(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=0ceef2ff802864723f93ee391d83ea7f (do not edit this line) */
