/* Generated By:JJTree: Do not edit this line. ASTThrowsPatternList.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTThrowsPatternList extends SimpleNode {
  public ASTThrowsPatternList(int id) {
    super(id);
  }

  public ASTThrowsPatternList(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=c69780311e37caf0266ef6a9e376cb4f (do not edit this line) */
