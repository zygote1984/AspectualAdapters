/* Generated By:JJTree: Do not edit this line. ASTBasicTypePattern.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTBasicTypePattern extends SimpleNode {
  public ASTBasicTypePattern(int id) {
    super(id);
  }

  public ASTBasicTypePattern(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=73c3d0c65585a37384520df461e844b7 (do not edit this line) */
