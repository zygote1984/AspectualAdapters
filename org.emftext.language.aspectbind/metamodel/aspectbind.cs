SYNTAXDEF aspectbind
FOR <http://www.emftext.org/language/aspectbind>
START commons.Aspect

IMPORTS{
	 java : <http://www.emftext.org/java> WITH SYNTAX java </org.emftext.language.java/metamodel/java.cs>
	 commons:<http://www.emftext.org/language/bindingAspect/commons>
	 binding:<http://www.emftext.org/language/bindingAspect/binding>
	 declaration:<http://www.emftext.org/language/bindingAspect/declaration>
	 pcexp:<http://www.emftext.org/language/bindingAspect/pcexp>
	 patterns:<http://www.emftext.org/language/bindingAspect/patterns>
	 pointcuts:<http://www.emftext.org/language/bindingAspect/pointcuts>


}


OPTIONS {	
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
    resolveProxyElementsAfterParsing = "false";
	disableDebugSupport = "true";
	disableLaunchSupport = "true";
	generateCodeFromGeneratorModel = "true";
	overrideBuilder = "false";
}



TOKENSTYLES {
	
	"aspect" COLOR #FF0011, BOLD;
	"pointcut" COLOR #FF0011, BOLD;
	"instance pointcut" COLOR #FF00AA, BOLD;
	"call" COLOR #FF0011, BOLD;
	"this" COLOR #FF0011, BOLD;
	"args" COLOR #FF0011, BOLD;
	"target" COLOR #FF0011, BOLD;
	"within" COLOR #FF0011, BOLD;
	"adapts" COLOR #FF00AA, BOLD;
	"declare adapter:" COLOR #FF00AA, BOLD;
	"->" COLOR #000000, BOLD;
}



RULES {
	
	//ASPECTJ RULES
	 commons.Aspect ::= package? imports?  priviliged["privileged":""]? modifier? "aspect" name[] ("extends" extend)? ("implements")? implement*  perclause? "{" !1 members* "}";
	 // ******************** Pointcuts  **********************
	 pointcuts.CallPointcut ::= "call"#0"(" pattern:patterns.AbstractMethodPattern ")";
	 pointcuts.ThisPointcut ::= "this"#0"(" pattern:patterns.TypeOrIdPattern ")"; 
	 pointcuts.ArgsPointcut ::= "args"#0"(" pattern:patterns.TypeOrIdPattern")";
	 pointcuts.WithinPointcut ::= "within"#0"("pattern:patterns.IdPattern")";
	 pointcuts.TargetPointcut ::= "target"#0 "("pattern:patterns.TypeOrIdPattern ")";
	 pointcuts.AspectJPointcut ::= abstract? "pointcut" name[]#0"(" #0 (parameters ("," parameters)* )? #0 ")" (assign:pcexp.PcAssignmentOperator exp:pcexp.PointcutExpression)? ";";
	 
	 commons.PerClause ::= clause[] "("pointcut[]")";
	 
	 binding.InstancePointcut ::= abstract? "instance pointcut" name[]#0"(" #0 instanceType #0")" (assign exp:pcexp.PointcutExpression)?";";
	
	 patterns.FieldPattern ::= modifiers* fieldType declaringType"."name[];
	 patterns.ConstructorPattern ::= modifiers* declaringType#0"->"#0"new" "("parameters? (","parameters)*")";
	 patterns.MethodPattern ::= modifiers* returnType declaringType#0"->"#0name[]  "("parameters? (","parameters)* ")";
	 patterns.TypePattern ::=  type;
	 patterns.IdPattern ::= id[];
	 
	 declaration.AdapterDeclaration ::= "declare adapter:" adapter "adapts" adaptee[] ("<"adapteeSub">")? !1 "{" members* "}";
	 declaration.Adapter::= name[]"[" references ("," references)* "]";
	 declaration.PrecedenceDeclaration ::= "declare precedence";
	 declaration.InterTypeDeclaration ::= "declare parents";
	 //JAVA SYNTAX
	pcexp.PointcutExpression ::= child:pcexp.PointcutOrExpression;
	pcexp.PointcutOrExpression ::= children:pcexp.PointcutAndExpression ( "||" children:pcexp.PointcutAndExpression )*;
	pcexp.PointcutAndExpression ::= children:pointcuts.PrimitivePointcut ( "&&" children:pointcuts.PrimitivePointcut )*;
	pcexp.PcAssignmentOperator ::= ":";
	
	
}