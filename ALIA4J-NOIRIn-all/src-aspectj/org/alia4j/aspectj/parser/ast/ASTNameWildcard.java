/* Generated By:JJTree: Do not edit this line. ASTNameWildcard.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTNameWildcard extends SimpleNode {
  public ASTNameWildcard(int id) {
    super(id);
  }

  public ASTNameWildcard(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=251794d675014701633409f66e45c8ff (do not edit this line) */