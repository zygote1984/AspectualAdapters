/* Generated By:JavaCC: Do not edit this line. AJPointcutParserTreeConstants.java Version 5.0 */
package org.alia4j.aspectj.parser.ast;

public interface AJPointcutParserTreeConstants
{
  public int JJTVOID = 0;
  public int JJTPRIMITIVEARRAYTYPE = 1;
  public int JJTCLASSORINTERFACEARRAYTYPE = 2;
  public int JJTCLASSORINTERFACETYPE = 3;
  public int JJTIDENTIFIER = 4;
  public int JJTTYPEARGUMENTLIST = 5;
  public int JJTUNKNOWNTYPEARGUMENT = 6;
  public int JJTUNKNOWNBOUNDEDTYPEARGUMENT = 7;
  public int JJTWILDCARDBOUNDSEXTENDS = 8;
  public int JJTWILDCARDBOUNDSSUPER = 9;
  public int JJTBOOLEAN = 10;
  public int JJTCHAR = 11;
  public int JJTBYTE = 12;
  public int JJTSHORT = 13;
  public int JJTINT = 14;
  public int JJTLONG = 15;
  public int JJTFLOAT = 16;
  public int JJTDOUBLE = 17;
  public int JJTNAME = 18;
  public int JJTPOINTCUTEXPRESSION = 19;
  public int JJTORPOINTCUTEXPRESSION = 20;
  public int JJTANDPOINTCUTEXPRESSION = 21;
  public int JJTNEGATEDPOINTCUTEXPRESSION = 22;
  public int JJTCALLPOINTCUT = 23;
  public int JJTEXECUTIONPOINTCUT = 24;
  public int JJTINITIALIZATIONPOINTCUT = 25;
  public int JJTPREINITIALIZATIONPOINTCUT = 26;
  public int JJTSTATICINITIALIZATIONPOINTCUT = 27;
  public int JJTGETPOINTCUT = 28;
  public int JJTSETPOINTCUT = 29;
  public int JJTHANDLERPOINTCUT = 30;
  public int JJTADVICEEXECUTIONPOINTCUT = 31;
  public int JJTWITHINPOINTCUT = 32;
  public int JJTWITHINCODEPOINTCUT = 33;
  public int JJTCFLOWPOINTCUT = 34;
  public int JJTCFLOWBELOWPOINTCUT = 35;
  public int JJTIFPOINTCUT = 36;
  public int JJTTHISPOINTCUT = 37;
  public int JJTTARGETPOINTCUT = 38;
  public int JJTARGSPOINTCUT = 39;
  public int JJTRETURNINGPOINTCUT = 40;
  public int JJTNAMEDPOINTCUT = 41;
  public int JJTMETHODCALL = 42;
  public int JJTIDLIST = 43;
  public int JJTNAMEPATTERN = 44;
  public int JJTPACKAGEREST = 45;
  public int JJTSIMPLENAMEPATTERN = 46;
  public int JJTCLINITIDENTIFIER = 47;
  public int JJTNAMEWILDCARD = 48;
  public int JJTCLASSTYPEDOTID = 49;
  public int JJTSUBTYPEOPERATOR = 50;
  public int JJTCLASSTYPEDOTNEW = 51;
  public int JJTNEW = 52;
  public int JJTANDTYPEPATTERNEXPRESSION = 53;
  public int JJTORTYPEPATTERNEXPRESSION = 54;
  public int JJTNEGATEDTYPEPATTERNEXPRESSION = 55;
  public int JJTBASICTYPEPATTERN = 56;
  public int JJTARRAYTYPEPATTERNEXPRESSION = 57;
  public int JJTBASETYPEPATTERN = 58;
  public int JJTORCLASSNAMEPATTERNEXPRESSION = 59;
  public int JJTANDCLASSNAMEPATTERNEXPRESSION = 60;
  public int JJTNEGATEDCLASSNAMEPATTERNEXPRESSION = 61;
  public int JJTBASICCLASSNAMEPATTERN = 62;
  public int JJTORCLASSNAMEPATTERNEXPRESSIONNOBANG = 63;
  public int JJTANDCLASSNAMEPATTERNEXPRESSIONNOBANG = 64;
  public int JJTMETHODPATTERN = 65;
  public int JJTCONSTRUCTORPATTERN = 66;
  public int JJTFIELDPATTERN = 67;
  public int JJTMODIFIERSPATTERN = 68;
  public int JJTNOTPUBLIC = 69;
  public int JJTNOTSTATIC = 70;
  public int JJTNOTPROTECTED = 71;
  public int JJTNOTPRIVATE = 72;
  public int JJTNOTFINAL = 73;
  public int JJTNOTABSTRACT = 74;
  public int JJTNOTSYNCHRONIZED = 75;
  public int JJTNOTNATIVE = 76;
  public int JJTNOTTRANSIENT = 77;
  public int JJTNOTVOLATILE = 78;
  public int JJTNOTSTRICTFP = 79;
  public int JJTPUBLIC = 80;
  public int JJTSTATIC = 81;
  public int JJTPROTECTED = 82;
  public int JJTPRIVATE = 83;
  public int JJTFINAL = 84;
  public int JJTABSTRACT = 85;
  public int JJTSYNCHRONIZED = 86;
  public int JJTNATIVE = 87;
  public int JJTTRANSIENT = 88;
  public int JJTVOLATILE = 89;
  public int JJTSTRICTFP = 90;
  public int JJTTHROWSPATTERNLIST = 91;
  public int JJTNEGATIVECLASSNAMEPATTERN = 92;
  public int JJTFORMALPATTERNLIST = 93;
  public int JJTTYPEIDSTARLIST = 94;
  public int JJTTYPEIDSTAR = 95;


  public String[] jjtNodeName = {
    "void",
    "PrimitiveArrayType",
    "ClassOrInterfaceArrayType",
    "ClassOrInterfaceType",
    "Identifier",
    "TypeArgumentList",
    "UnknownTypeArgument",
    "UnknownBoundedTypeArgument",
    "WildcardBoundsExtends",
    "WildcardBoundsSuper",
    "Boolean",
    "Char",
    "Byte",
    "Short",
    "Int",
    "Long",
    "Float",
    "Double",
    "Name",
    "PointcutExpression",
    "OrPointcutExpression",
    "AndPointcutExpression",
    "NegatedPointcutExpression",
    "CallPointcut",
    "ExecutionPointcut",
    "InitializationPointcut",
    "PreinitializationPointcut",
    "StaticinitializationPointcut",
    "GetPointcut",
    "SetPointcut",
    "HandlerPointcut",
    "AdviceExecutionPointcut",
    "WithinPointcut",
    "WithincodePointcut",
    "CflowPointcut",
    "CflowbelowPointcut",
    "IfPointcut",
    "ThisPointcut",
    "TargetPointcut",
    "ArgsPointcut",
    "ReturningPointcut",
    "NamedPointcut",
    "MethodCall",
    "IdList",
    "NamePattern",
    "PackageRest",
    "SimpleNamePattern",
    "ClinitIdentifier",
    "NameWildcard",
    "ClasstypeDotId",
    "SubTypeOperator",
    "ClasstypeDotNew",
    "New",
    "AndTypePatternExpression",
    "OrTypePatternExpression",
    "NegatedTypePatternExpression",
    "BasicTypePattern",
    "ArrayTypePatternExpression",
    "BaseTypePattern",
    "OrClassnamePatternExpression",
    "AndClassnamePatternExpression",
    "NegatedClassnamePatternExpression",
    "BasicClassnamePattern",
    "OrClassnamePatternExpressionNobang",
    "AndClassnamePatternExpressionNobang",
    "MethodPattern",
    "ConstructorPattern",
    "FieldPattern",
    "ModifiersPattern",
    "NotPublic",
    "NotStatic",
    "NotProtected",
    "NotPrivate",
    "NotFinal",
    "NotAbstract",
    "NotSynchronized",
    "NotNative",
    "NotTransient",
    "NotVolatile",
    "NotStrictfp",
    "Public",
    "Static",
    "Protected",
    "Private",
    "Final",
    "Abstract",
    "Synchronized",
    "Native",
    "Transient",
    "Volatile",
    "Strictfp",
    "ThrowsPatternList",
    "NegativeClassnamePattern",
    "FormalPatternList",
    "TypeIdStarList",
    "TypeIdStar",
  };
}
/* JavaCC - OriginalChecksum=61f736ecda419d110df126e9c7a68269 (do not edit this line) */
