/* Generated By:JJTree: Do not edit this line. ASTNegatedClassnamePatternExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTNegatedClassnamePatternExpression extends SimpleNode {
  public ASTNegatedClassnamePatternExpression(int id) {
    super(id);
  }

  public ASTNegatedClassnamePatternExpression(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=801c63e76dfa9dd024b4c2c1767321fe (do not edit this line) */