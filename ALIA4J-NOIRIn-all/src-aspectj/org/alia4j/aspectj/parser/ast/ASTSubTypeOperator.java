/* Generated By:JJTree: Do not edit this line. ASTSubTypeOperator.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTSubTypeOperator extends SimpleNode {
  public ASTSubTypeOperator(int id) {
    super(id);
  }

  public ASTSubTypeOperator(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=c9e50d593242835e14a3d6cd2dc90746 (do not edit this line) */
