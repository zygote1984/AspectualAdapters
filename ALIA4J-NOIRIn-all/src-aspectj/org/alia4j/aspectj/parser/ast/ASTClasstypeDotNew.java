/* Generated By:JJTree: Do not edit this line. ASTClasstypeDotNew.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTClasstypeDotNew extends SimpleNode {
  public ASTClasstypeDotNew(int id) {
    super(id);
  }

  public ASTClasstypeDotNew(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=67289ced2003ceda6132d9dab9b9238d (do not edit this line) */