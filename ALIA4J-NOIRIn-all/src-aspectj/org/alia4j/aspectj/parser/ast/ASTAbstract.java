/* Generated By:JJTree: Do not edit this line. ASTAbstract.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTAbstract extends SimpleNode {
  public ASTAbstract(int id) {
    super(id);
  }

  public ASTAbstract(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=46a3d7c616a7e68063f8c4f3174974b8 (do not edit this line) */