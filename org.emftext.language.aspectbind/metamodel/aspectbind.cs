SYNTAXDEF aspectbind
FOR <http://www.emftext.org/language/aspectbind>
START commons.Aspect

IMPORTS{
	 java : <http://www.emftext.org/java> WITH SYNTAX java </org.emftext.language.java/metamodel/java.cs>
	 commons:<http://www.emftext.org/language/bindingAspect/commons>
	 instancepointcut:<http://www.emftext.org/language/bindingAspect/instancepointcut>
	 ipcomposition:<http://www.emftext.org/language/bindingAspect/instancepointcut/composition>
	 iprelationship:<http://www.emftext.org/language/bindingAspect/instancepointcut/relationship>
	 declaration:<http://www.emftext.org/language/bindingAspect/declaration>
	 pcexp:<http://www.emftext.org/language/bindingAspect/pcexp>
	 patterns:<http://www.emftext.org/language/bindingAspect/patterns>
	 pointcuts:<http://www.emftext.org/language/bindingAspect/pointcuts>
	 reference:<http://www.emftext.org/language/bindingAspect/reference>
}


OPTIONS {	
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
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
	"returning" COLOR #FF0011, BOLD;
	"args" COLOR #FF0011, BOLD;
	"target" COLOR #FF0011, BOLD;
	"within" COLOR #FF0011, BOLD;
	"adapts" COLOR #FF00AA, BOLD;
	"instance" COLOR #114466, ITALIC;
	"adaptee" COLOR #11FF66, ITALIC;
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
	 pointcuts.IfPointcut ::= "if"#0"("exp")";
	 pointcuts.AspectJPointcut ::= abstract? "pointcut" name[]#0"(" #0 (parameters ("," parameters)* )? #0 ")" (assign:pcexp.PcAssignmentOperator exp:pcexp.PointcutExpression)? ";";
	 
	 commons.PerClause ::= clause[] "("pointcut[]")";
	 
	 instancepointcut.InstancePointcut ::= "instance pointcut" name[]#0"<" #0 instanceType #0">" assign addExp ("UNTIL" removeExp)?";";
	 instancepointcut.IpExpressionAll ::=  before "||" after | after "||" before ;
	 instancepointcut.BeforeElement ::= "before""(" pcexp: pcexp.PointcutExpression")";
	 instancepointcut.AfterElement ::= "after""(" pcexp: pcexp.PointcutExpression")";
	 instancepointcut.Instance ::= "instance";
	 instancepointcut.IpReturning ::= "returning" "("instance")";
	
	 reference.InstancePointcutReference ::= ipc[]("<"refinement">");
	 
	
	 patterns.FieldPattern ::= modifiers* fieldType declaringType"."name[];
	 patterns.ConstructorPattern ::= modifiers* declaringType#0"->"#0"new"#0"("parameters? (","parameters)*")";
	 patterns.MethodPattern ::= modifiers* returnType declaringType #0 "->" #0 name[] #0 "("parameters? (","parameters)* ")";
	 patterns.TypePattern ::=  type#0subtypes?;
	 patterns.IdPattern ::= id[];
	 patterns.ParameterWildcard ::= "..";

	 
	 declaration.AdapterDeclaration ::= "declare adapter:" adapter "adapts" adaptee[] ("<"adapteeSub">")? !1 "{" members* "}";
	 declaration.Adapter::= abstract? name[] "{" references ("," references)* "}" ("extends" extend[])?;
	 declaration.PrecedenceDeclaration ::= "declare precedence";
	 declaration.InterTypeDeclaration ::= "declare parents";
	 declaration.Adaptee ::= "adaptee";
	 //JAVA SYNTAX
	pcexp.PointcutExpression ::= child:pcexp.PointcutOrExpression;
	pcexp.PointcutOrExpression ::= children:pcexp.PointcutAndExpression ( "||" children:pcexp.PointcutAndExpression )*;
	pcexp.PointcutAndExpression ::= children:pointcuts.PrimitivePointcut ( "&&" children:pointcuts.PrimitivePointcut )*;
	pcexp.PcAssignmentOperator ::= ":";
	
	
	
}