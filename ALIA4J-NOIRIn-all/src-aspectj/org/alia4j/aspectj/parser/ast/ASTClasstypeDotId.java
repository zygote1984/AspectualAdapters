/* Generated By:JJTree: Do not edit this line. ASTClasstypeDotId.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.alia4j.aspectj.parser.ast;

public
class ASTClasstypeDotId extends SimpleNode {
  public ASTClasstypeDotId(int id) {
    super(id);
  }

  public ASTClasstypeDotId(AJPointcutParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AJPointcutParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=6accf2e2c429e0e439cf0a987a64aa78 (do not edit this line) */