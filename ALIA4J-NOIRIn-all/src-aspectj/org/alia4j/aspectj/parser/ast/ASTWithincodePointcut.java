/* Generated By:JJTree: Do not edit this line. ASTWithincodePointcut.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTWithincodePointcut extends SimpleNode {
  public ASTWithincodePointcut(int id) {
    super(id);
  }

  public ASTWithincodePointcut(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=723472bb5ca69359cfbeb002fd5a0275 (do not edit this line) */
