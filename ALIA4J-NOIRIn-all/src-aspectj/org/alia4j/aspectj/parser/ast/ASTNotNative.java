/* Generated By:JJTree: Do not edit this line. ASTNotNative.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTNotNative extends SimpleNode {
  public ASTNotNative(int id) {
    super(id);
  }

  public ASTNotNative(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=5609e0a78740f2584c4739648c6580f6 (do not edit this line) */
