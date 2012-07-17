package org.alia4j.aspectj.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.alia4j.aspectj.model.context.AspectJContextFactory;
import org.alia4j.aspectj.parser.ast.*;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.AtomicPredicateFactory;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.Specialization;
import org.alia4j.liam.pattern.FieldReadPattern;
import org.alia4j.liam.pattern.FieldWritePattern;
import org.alia4j.liam.pattern.MethodPattern;
import org.alia4j.liam.pattern.Pattern;
import org.alia4j.liam.pattern.StaticInitializerPattern;
import org.alia4j.patterns.ClassTypePattern;
import org.alia4j.patterns.ExceptionsPattern;
import org.alia4j.patterns.ModifiersPattern;
import org.alia4j.patterns.NamePattern;
import org.alia4j.patterns.ParametersPattern;
import org.alia4j.patterns.TypePattern;
import org.alia4j.patterns.exceptions.ExceptionsPatternElement;
import org.alia4j.patterns.exceptions.NegativeTypePatternElement;
import org.alia4j.patterns.exceptions.PositiveTypePatternElement;
import org.alia4j.patterns.exceptions.WildcardExceptionsPattern;
import org.alia4j.patterns.modifiers.WildcardModifiersPattern;
import org.alia4j.patterns.names.IdentifierElement;
import org.alia4j.patterns.names.IdentifierWildcard;
import org.alia4j.patterns.names.NameElement;
import org.alia4j.patterns.names.WildcardNamePattern;
import org.alia4j.patterns.parameters.ParametersPatternElement;
import org.alia4j.patterns.parameters.ParametersRest;
import org.alia4j.patterns.parameters.TypePatternElement;
import org.alia4j.patterns.parameters.WildcardParametersPattern;
import org.alia4j.patterns.types.ArrayTypePattern;
import org.alia4j.patterns.types.ExactTypePattern;
import org.alia4j.patterns.types.NamePatternElement;
import org.alia4j.patterns.types.NamespaceElement;
import org.alia4j.patterns.types.RestElement;
import org.alia4j.patterns.types.SubTypePattern;
import org.alia4j.patterns.types.WildcardTypePattern;
import org.alia4j.util.Pair;

/**
 * Translates the parse-tree of AJPointcutParser into a set of Specialization (see project alia4j-liam). The root of the tree
 * should be an ASTPointcutExpression. This visitor can also be used to translate the parse tree for a pattern into Pattern
 * objects (see project alia4j-patterns). Pass a mapping for the pointcut's arguments to the constructor to allow correct
 * handling of context reification.
 *
 * @author Christoph Bockisch
 */
public class AJPointcutToLIAMVisitor implements AJPointcutParserVisitor {

    private Map<String, Pair<Integer, TypeDescriptor>> argName2IndexType;

    private final int numberOfArguments;

    private final SpecializationsBuilderFactory specializationsBuilderFactory;

    /**
     * Requires a mapping for the pointcut arguments, i.e., context values that are bound by the parsed pointcut and should
     * be passed to the advice. The first mapping maps the argument name as used in the pointcut to the index of the argument
     * as which the value should be passed to the adavice. The second mapping maps the name to the type of the argument. Both
     * mappings must have the same size and the same keys.
     *
     * @param argName2IndexType may be <code>null</code>, this is equivalent to passing an empty map.
     * @param importer
     * @param aspectInstanceContext
     */
    public AJPointcutToLIAMVisitor(final Map<String, Pair<Integer, TypeDescriptor>> argName2IndexType,
                    final Context aspectInstanceContext) {
        this.specializationsBuilderFactory = new SpecializationsBuilderFactory(aspectInstanceContext);
        this.argName2IndexType = argName2IndexType;
        if (this.argName2IndexType == null)
            this.argName2IndexType = Collections.emptyMap();
        this.numberOfArguments = this.argName2IndexType.size();
    }

    // ------------------------------------------
    // class name pattern expressions
    // ------------------------------------------

    public ClassTypePattern visit(final ASTOrClassnamePatternExpression node, final Object data) {
        // an or node must have exactly two children
        final Node firstChild = node.jjtGetChild(0);
        final Node secondChild = node.jjtGetChild(1);
        final ClassTypePattern firstTypePattern = (ClassTypePattern) firstChild.jjtAccept(this, null);
        final ClassTypePattern secondTypePattern = (ClassTypePattern) secondChild.jjtAccept(this, null);
        return firstTypePattern.or(secondTypePattern);
    }

    public ClassTypePattern visit(final ASTAndClassnamePatternExpression node, final Object data) {
        // an and node must have exactly two children
        final Node firstChild = node.jjtGetChild(0);
        final Node secondChild = node.jjtGetChild(1);
        final ClassTypePattern firstTypePattern = (ClassTypePattern) firstChild.jjtAccept(this, null);
        final ClassTypePattern secondTypePattern = (ClassTypePattern) secondChild.jjtAccept(this, null);
        return firstTypePattern.and(secondTypePattern);
    }

    public ClassTypePattern visit(final ASTNegatedClassnamePatternExpression node, final Object data) {
        // a not node must have exactly two children
        final Node child = node.jjtGetChild(0);
        final ClassTypePattern typePattern = (ClassTypePattern) child.jjtAccept(this, null);
        return typePattern.not();
    }

    public ClassTypePattern visit(final ASTOrClassnamePatternExpressionNobang node, final Object data) {
        // an or node must have exactly two children
        final Node firstChild = node.jjtGetChild(0);
        final Node secondChild = node.jjtGetChild(1);
        final ClassTypePattern firstTypePattern = (ClassTypePattern) firstChild.jjtAccept(this, null);
        final ClassTypePattern secondTypePattern = (ClassTypePattern) secondChild.jjtAccept(this, null);
        return firstTypePattern.or(secondTypePattern);
    }

    public ClassTypePattern visit(final ASTAndClassnamePatternExpressionNobang node, final Object data) {
        // an and node must have exactly two children
        final Node firstChild = node.jjtGetChild(0);
        final Node secondChild = node.jjtGetChild(1);
        final ClassTypePattern firstTypePattern = (ClassTypePattern) firstChild.jjtAccept(this, null);
        final ClassTypePattern secondTypePattern = (ClassTypePattern) secondChild.jjtAccept(this, null);
        return firstTypePattern.and(secondTypePattern);
    }

    public ClassTypePattern visit(final ASTBasicClassnamePattern node, final Object data) {
        final ClassTypePattern classnamePattern = this.visit((ASTNamePattern) node.jjtGetChild(0), null);
        boolean inculdeSubTypes = false;
        if (node.jjtGetNumChildren() == 2 && node.jjtGetChild(1) instanceof ASTSubTypeOperator) {
            inculdeSubTypes = true;
        }
        return new SubTypePattern(classnamePattern, inculdeSubTypes);
    }

    public Object visit(final ASTSubTypeOperator node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    // ------------------------------------------
    // type pattern expressions
    // ------------------------------------------

    public TypePattern visit(final ASTAndTypePatternExpression node, final Object data) {
        // an and node must have exactly two children
        final Node firstChild = node.jjtGetChild(0);
        final Node secondChild = node.jjtGetChild(1);
        final TypePattern firstTypePattern = (TypePattern) firstChild.jjtAccept(this, null);
        final TypePattern secondTypePattern = (TypePattern) secondChild.jjtAccept(this, null);
        return firstTypePattern.and(secondTypePattern);
    }

    public TypePattern visit(final ASTOrTypePatternExpression node, final Object data) {
        // an or node must have exactly two children
        final Node firstChild = node.jjtGetChild(0);
        final Node secondChild = node.jjtGetChild(1);
        final TypePattern firstTypePattern = (TypePattern) firstChild.jjtAccept(this, null);
        final TypePattern secondTypePattern = (TypePattern) secondChild.jjtAccept(this, null);
        return firstTypePattern.or(secondTypePattern);
    }

    public TypePattern visit(final ASTNegatedTypePatternExpression node, final Object data) {
        // a not node must have exactly one child
        final Node child = node.jjtGetChild(0);
        final TypePattern typePattern = (TypePattern) child.jjtAccept(this, null);
        return typePattern.not();
    }

    // "void" #Void
    // |
    // ( BaseTypePattern() ( "[" "]" { arrayDimension++; } )* { jjtThis.arrayDimension=arrayDimension; } )
    // #ArrayTypePatternExpression(arrayDimension > 0)
    // |
    // "(" TypePatternExpression() ")"
    public TypePattern visit(final ASTBasicTypePattern node, final Object data) {
        if (node.jjtGetChild(0) instanceof ASTVoid)
            return new ExactTypePattern(TypeHierarchyProvider.findOrCreateFromNormalTypeName(((ASTVoid) node.jjtGetChild(0))
                            .getTypeName()));
        // otherwise, it is a BaseTypePattern, an ArrayTypePatternExpression or a TypePattern
        // all of them have visit methods that return a type-pattern
        TypePattern result = (TypePattern) node.jjtGetChild(0).jjtAccept(this, null);
        if (result == ClassTypePattern.ANY)
        	return TypePattern.ANY;
        else
        	return result;
    }

    // PrimitiveType()
    // |
    // NamePattern() [ "+" #SubTypeOperator ]
    public TypePattern visit(final ASTBaseTypePattern node, final Object data) {
        // can be a primitive type, a name pattern or a name pattern with sub type operator
        if (node.jjtGetChild(0) instanceof PrimitiveType) {
            return new ExactTypePattern(TypeHierarchyProvider.findOrCreateFromNormalTypeName(((PrimitiveType) node
                            .jjtGetChild(0)).getTypeName()));
        }
        // first node must be a name pattern
        final ClassTypePattern namePattern = this.visit((ASTNamePattern) node.jjtGetChild(0), null);
        if (node.jjtGetNumChildren() == 2) {
            // second node must be the sub type operator
            return new SubTypePattern(namePattern);
        } else {
            return namePattern;
        }
    }

    // ( BaseTypePattern() ( "[" "]" { arrayDimension++; } )* { jjtThis.arrayDimension=arrayDimension; } )
    // #ArrayTypePatternExpression(arrayDimension > 0)
    public TypePattern visit(final ASTArrayTypePatternExpression node, final Object data) {
        // single child node is a BaseTypePattern
        final TypePattern baseTypePattern = this.visit((ASTBaseTypePattern) node.jjtGetChild(0), null);
        return new ArrayTypePattern(baseTypePattern, node.getArrayDimension());
    }

    // ------------------------------------------
    // primitive type names
    // ------------------------------------------

    public String visit(final ASTBoolean node, final Object data) {
        return node.getTypeName();
    }

    public String visit(final ASTChar node, final Object data) {
        return node.getTypeName();
    }

    public String visit(final ASTByte node, final Object data) {
        return node.getTypeName();
    }

    public String visit(final ASTShort node, final Object data) {
        return node.getTypeName();
    }

    public String visit(final ASTInt node, final Object data) {
        return node.getTypeName();
    }

    public String visit(final ASTLong node, final Object data) {
        return node.getTypeName();
    }

    public String visit(final ASTFloat node, final Object data) {
        return node.getTypeName();
    }

    public String visit(final ASTDouble node, final Object data) {
        return node.getTypeName();
    }

    public String visit(final ASTVoid node, final Object data) {
        return node.getTypeName();
    }

    // ------------------------------------------
    // NAME PATTERN
    // ------------------------------------------

    public ClassTypePattern visit(final ASTNamePattern node, final Object data) {
        final List<Node> children = new ArrayList<Node>(3);
        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            if (node.jjtGetChild(i).jjtGetNumChildren() > 0
                            && node.jjtGetChild(i).jjtGetChild(0) instanceof ASTClinitIdentifier) {
                // this is the name of the <clinit> method. Just ignore it, then
                // the name pattern only consists of the type name which is
                // expected by the "staticinitialization" pointcut designator
                // "staticinitialization" is the only context in which
                // "<clinit>" can occur
            } else {
                children.add(node.jjtGetChild(i));
            }
        }
        return this.classTypePatternFromAST(children);
    }

    private ClassTypePattern classTypePatternFromAST(final List<Node> nodes) {
        // special case the type name pattern is "*" then the pattern is ANY
        if (nodes.size() == 1 && nodes.get(0) instanceof ASTSimpleNamePattern) {
            final ASTSimpleNamePattern simplePattern = (ASTSimpleNamePattern) nodes.get(0);
            if (simplePattern.jjtGetNumChildren() == 1 && simplePattern.jjtGetChild(0) instanceof ASTNameWildcard) {
                return ClassTypePattern.ANY;
            }
        }
        final List<NamespaceElement> namespaceElements = new ArrayList<NamespaceElement>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) instanceof ASTPackageRest) {
                namespaceElements.add(RestElement.INSTANCE);
            } else {
                namespaceElements.add(new NamePatternElement(this.visit(((ASTSimpleNamePattern) nodes.get(i)), null)));
            }
        }
        return new WildcardTypePattern(namespaceElements);
    }

    public NamePattern visit(final ASTSimpleNamePattern node, final Object data) {
        final int numPatternElements = node.jjtGetNumChildren();

        if (numPatternElements == 1 && node.jjtGetChild(0) instanceof ASTNameWildcard) {
            return NamePattern.ANY;
        } else {
            final List<NameElement> namePatternElements = new ArrayList<NameElement>();
            for (int i = 0; i < numPatternElements; i++) {
                if (node.jjtGetChild(i) instanceof ASTNameWildcard) {
                    namePatternElements.add(IdentifierWildcard.INSTANCE);
                } else { // must be identifier
                    namePatternElements.add(new IdentifierElement(((ASTIdentifier) node.jjtGetChild(i)).getIdentifier()));
                }
            }
            return new WildcardNamePattern(namePatternElements);
        }
    }

    public Object visit(final ASTPackageRest node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNameWildcard node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public String visit(final ASTIdentifier node, final Object data) {
        return node.getIdentifier();
    }

    // ------------------------------------------
    // ABSTRACT SUPER NODE
    // ------------------------------------------

    public ModifiersPattern visit(final SimpleNode node, final Object data) {
        throw new UnsupportedOperationException("All node types must be handled specially.");
    }

    // ------------------------------------------
    // FOR JAVA 5 SIGNATURES: GENERIC TYPE ARGUMENTS
    // ------------------------------------------

    public Object visit(final ASTTypeArgumentList node, final Object data) {
        throw new UnsupportedOperationException("Generic types not yet supported.");

    }

    public Object visit(final ASTUnknownTypeArgument node, final Object data) {
        throw new UnsupportedOperationException("Generic types not yet supported.");
    }

    public Object visit(final ASTUnknownBoundedTypeArgument node, final Object data) {
        throw new UnsupportedOperationException("Generic types not yet supported.");
    }

    public Object visit(final ASTWildcardBoundsExtends node, final Object data) {
        throw new UnsupportedOperationException("Generic types not yet supported.");
    }

    public Object visit(final ASTWildcardBoundsSuper node, final Object data) {
        throw new UnsupportedOperationException("Generic types not yet supported.");
    }

    // ------------------------------------------
    // FOR NAMED POINTCUTS AND SIGNATURES
    // ------------------------------------------

    public String visit(final ASTName node, final Object data) {
        final StringBuilder fullyQualifiedName = new StringBuilder();

        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            fullyQualifiedName.append((String) node.jjtGetChild(i).jjtAccept(this, null));
            if (i < node.jjtGetNumChildren() - 1)
                fullyQualifiedName.append('.');
        }

        return fullyQualifiedName.toString();
    }

    // ------------------------------------------
    // POINTCUTS
    // ------------------------------------------

    public Set<Specialization> visit(final ASTPointcutExpression node, final Object data) {
        // has exactly one child, may be a basic pointcut designator or a boolean pointcut designator
        final SpecializationBuilder specializationBuilder =
                        (SpecializationBuilder) node.jjtGetChild(0).jjtAccept(this, null);

        for (final String key : this.argName2IndexType.keySet()) {
            if (key.equals("thisJoinPoint")) {

                specializationBuilder.setContext(this.argName2IndexType.get(key).getLeft(), AspectJContextFactory
                                .findOrCreateThisJoinPointContext());
            } else if (key.equals("thisJoinPointStaticPart")) {
                specializationBuilder.setContext(this.argName2IndexType.get(key).getLeft(), AspectJContextFactory
                                .findOrCreateThisJoinPointStaticPartContext());
            }
        }

        return specializationBuilder.getSpecializations();
    }

    // ------------------------------------------
    // boolean designators
    // ------------------------------------------

    public SpecializationBuilder visit(final ASTAndPointcutExpression node, final Object data) {
        // has two children
        final SpecializationBuilder firstOperand = (SpecializationBuilder) node.jjtGetChild(0).jjtAccept(this, null);
        final SpecializationBuilder secondOperand = (SpecializationBuilder) node.jjtGetChild(1).jjtAccept(this, null);
        return this.specializationsBuilderFactory.and(firstOperand, secondOperand);
    }

    public SpecializationBuilder visit(final ASTOrPointcutExpression node, final Object data) {
        // has two children
        final SpecializationBuilder firstOperand = (SpecializationBuilder) node.jjtGetChild(0).jjtAccept(this, null);
        final SpecializationBuilder secondOperand = (SpecializationBuilder) node.jjtGetChild(1).jjtAccept(this, null);
        return this.specializationsBuilderFactory.or(firstOperand, secondOperand);
    }

    public SpecializationBuilder visit(final ASTNegatedPointcutExpression node, final Object data) {
        // has one child
        final SpecializationBuilder operand = (SpecializationBuilder) node.jjtGetChild(0).jjtAccept(this, null);
        return this.specializationsBuilderFactory.not(operand);
    }

    // ------------------------------------------
    // designators
    // ------------------------------------------
    // static designators
    // ------------------------------------------

    public SpecializationBuilder visit(final ASTCallPointcut node, final Object data) {
        // has one child, i.e., the method pattern
        final MethodPatternElements methodPattern = (MethodPatternElements) node.jjtGetChild(0).jjtAccept(this, null);
        final Pattern<?> pattern =
                        new MethodPattern(methodPattern.getModifiersPattern(), methodPattern.getResultTypePattern(),
                                        methodPattern.getDeclaringClassTypePattern(), methodPattern.getFieldNamePattern(),
                                        methodPattern.getParametersPattern(), methodPattern.getExceptionsPattern());
        return this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments, pattern);
    }

    public SpecializationBuilder visit(final ASTExecutionPointcut node, final Object data) {
        // has one child, i.e., the method pattern
        final MethodPatternElements methodPattern = (MethodPatternElements) node.jjtGetChild(0).jjtAccept(this, null);
        final Pattern<?> pattern =
                        new MethodPattern(methodPattern.getModifiersPattern(), methodPattern.getResultTypePattern(),
                                        methodPattern.getDeclaringClassTypePattern(), methodPattern.getFieldNamePattern(),
                                        methodPattern.getParametersPattern(), methodPattern.getExceptionsPattern());
        return this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments, pattern);
    }

    public SpecializationBuilder visit(final ASTInitializationPointcut node, final Object data) {
        // has one child, i.e., the constructor pattern
        // see visit for call or execution pointcut
        // TODO support constructor call pointcut designator
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public SpecializationBuilder visit(final ASTPreinitializationPointcut node, final Object data) {
        // TODO support constructor call pointcut designator
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public SpecializationBuilder visit(final ASTStaticinitializationPointcut node, final Object data) {
        // has one child, i.e., the class name pattern
        final ClassTypePattern typePattern = (ClassTypePattern) node.jjtGetChild(0).jjtAccept(this, null);
        final Pattern<?> pattern = new StaticInitializerPattern(typePattern);
        return this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments, pattern);
    }

    public SpecializationBuilder visit(final ASTGetPointcut node, final Object data) {
        // has one child, i.e., the field pattern
        final FieldPatternElements fieldPattern = (FieldPatternElements) node.jjtGetChild(0).jjtAccept(this, null);
        final Pattern<?> pattern =
                        new FieldReadPattern(fieldPattern.getModifiersPattern(), fieldPattern.getResultTypePattern(),
                                        fieldPattern.getDeclaringClassTypePattern(), fieldPattern.getFieldNamePattern());
        return this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments, pattern);
    }

    public SpecializationBuilder visit(final ASTSetPointcut node, final Object data) {
        // has one child, i.e., the field pattern
        final FieldPatternElements fieldPattern = (FieldPatternElements) node.jjtGetChild(0).jjtAccept(this, null);
        final Pattern<?> pattern =
                        new FieldWritePattern(fieldPattern.getModifiersPattern(), fieldPattern.getResultTypePattern(),
                                        fieldPattern.getDeclaringClassTypePattern(), fieldPattern.getFieldNamePattern());
        return this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments, pattern);
    }

    public SpecializationBuilder visit(final ASTHandlerPointcut node, final Object data) {
        // has one child, i.e., the class name pattern
        // ClassTypePattern typePattern = (ClassTypePattern) node.jjtGetChild(0).jjtAccept(this, null);
        throw new UnsupportedOperationException("Not implemented.");
    }

    public SpecializationBuilder visit(final ASTAdviceExecutionPointcut node, final Object data) {
        // TODO support advice execution pointcut designator
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    // ------------------------------------------
    // dynamic
    // ------------------------------------------

    public SpecializationBuilder visit(final ASTWithinPointcut node, final Object data) {
        // TODO support within PCD
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public SpecializationBuilder visit(final ASTWithincodePointcut node, final Object data) {
        // TODO support withincode PCD
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public SpecializationBuilder visit(final ASTCflowPointcut node, final Object data) {
        // has one child: a pointcut predicate

        final Set<Specialization> constitutuents = this.visit(((ASTPointcutExpression) node.jjtGetChild(0)), null);

        final AtomicPredicate cFlowAtomicPredicate = AtomicPredicateFactory.findOrCreateCFlowPredicate(constitutuents);
        final SpecializationBuilder result =
                        this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments,
                                        cFlowAtomicPredicate);

        return result;
    }

    public SpecializationBuilder visit(final ASTCflowbelowPointcut node, final Object data) {
        // has one child: a pointcut predicate

        final Set<Specialization> constituents = this.visit(((ASTPointcutExpression) node.jjtGetChild(0)), null);

        final AtomicPredicate cFlowBelowAtomicPredicate =
                        AtomicPredicateFactory.findOrCreateCFlowBelowPredicate(constituents);
        final SpecializationBuilder result =
                        this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments,
                                        cFlowBelowAtomicPredicate);

        return result;
    }

    public SpecializationBuilder visit(final ASTIfPointcut node, final Object data) {
        // see public Object visit(ASTMethodSignature node, Object data)
        // Object methodSignature = (Object) node.jjtGetChild(0).jjtAccept(this, null);
        // TODO support if PCD
        this.visit(((ASTMethodCall) node.jjtGetChild(0)), null);

        throw new UnsupportedOperationException();
    }

    public SpecializationBuilder visit(final ASTThisPointcut node, final Object data) {
        // has one child: a typeIdStar, which may by "*", a typename or a typename with the "+" operator

        final TypeOrIdOrStar typeIdStar = this.visit(((ASTTypeIdStar) node.jjtGetChild(0)), null);

        if (typeIdStar.isWildcard()) {
            return null;
        } else {
            if (this.argName2IndexType.keySet().contains(typeIdStar.getTypeOrId())) {
                final TypeDescriptor expectedCallerType = this.argName2IndexType.get(typeIdStar.getTypeOrId()).getRight();
                final int argumentIndex = this.argName2IndexType.get(typeIdStar.getTypeOrId()).getLeft();

                // it is actually an argument, so generate a dynamic property and a context
                final Context callerContext = ContextFactory.findOrCreateCallerContext();

                // no matter if the "+" operator was used or not, target is always supposed to match on sub types
                final AtomicPredicate expectedCallerTypeAtomicPredicate =
                                AtomicPredicateFactory.findOrCreateInstanceofPredicate(callerContext, expectedCallerType);
                final SpecializationBuilder result =
                                this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments,
                                                expectedCallerTypeAtomicPredicate);
                result.setContext(argumentIndex, callerContext);
                return result;
            } else {
                final String typeName = typeIdStar.getTypeOrId();

                // no matter if the "+" operator was used or not, this is always supposed to match on sub types (?)
                final AtomicPredicate expectedCallerTypeAtomicPredicate =
                                AtomicPredicateFactory.findOrCreateInstanceofPredicate(ContextFactory
                                                .findOrCreateCallerContext(), TypeHierarchyProvider
                                                .findOrCreateFromNormalTypeName(typeName));
                return this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments,
                                expectedCallerTypeAtomicPredicate);
            }
        }
    }

    public SpecializationBuilder visit(final ASTReturningPointcut node, final Object data) {
        // has one child: a typeIdStar, which may by "*", a typename or a typename with the "+" operator

        final TypeOrIdOrStar typeIdStar = this.visit(((ASTTypeIdStar) node.jjtGetChild(0)), null);

        if (typeIdStar.isWildcard()) {
            return null;
        } else {
            if (this.argName2IndexType.keySet().contains(typeIdStar.getTypeOrId())) {
                final TypeDescriptor expectedCallerType = this.argName2IndexType.get(typeIdStar.getTypeOrId()).getRight();
                final int argumentIndex = this.argName2IndexType.get(typeIdStar.getTypeOrId()).getLeft();

                // it is actually an argument, so generate a dynamic property and a context
                final Context callerContext = ContextFactory.findOrCreateMethodResultContext();

                // no matter if the "+" operator was used or not, target is always supposed to match on sub types
                final SpecializationBuilder result =
                                this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments, Collections.<AtomicPredicate>emptySet());
                result.setContext(argumentIndex, callerContext);
                return result;
            } else {
            	throw new UnsupportedOperationException();
//                final String typeName = typeIdStar.getTypeOrId();
//
//                // no matter if the "+" operator was used or not, this is always supposed to match on sub types (?)
//                final AtomicPredicate expectedCallerTypeAtomicPredicate =
//                                AtomicPredicateFactory.findOrCreateInstanceofPredicate(ContextFactory
//                                                .findOrCreateCallerContext(), TypeHierarchyProvider
//                                                .findOrCreateFromNormalTypeName(typeName));
//                return this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments,
//                                expectedCallerTypeAtomicPredicate);
            }
        }
    }

    public SpecializationBuilder visit(final ASTTargetPointcut node, final Object data) {
        // has one child: a typeIdStar, which may by "*", a typename or a typename with the "+" operator

        final TypeOrIdOrStar typeIdStar = this.visit(((ASTTypeIdStar) node.jjtGetChild(0)), null);

        if (typeIdStar.isWildcard()) {
            return null;
        } else {
            if (this.argName2IndexType.keySet().contains(typeIdStar.getTypeOrId())) {
                final TypeDescriptor expectedCalleeType = this.argName2IndexType.get(typeIdStar.getTypeOrId()).getRight();
                final int argumentIndex = this.argName2IndexType.get(typeIdStar.getTypeOrId()).getLeft();

                // it is actually an argument, so generate a dynamic property and a context
                final Context calleeContext = ContextFactory.findOrCreateCalleeContext();

                // no matter if the "+" operator was used or not, target is always supposed to match on sub types
                final AtomicPredicate expectedCalleeTypeAtomicPredicate =
                                AtomicPredicateFactory.findOrCreateInstanceofPredicate(calleeContext, expectedCalleeType);
                final SpecializationBuilder result =
                                this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments,
                                                expectedCalleeTypeAtomicPredicate);
                result.setContext(argumentIndex, calleeContext);
                return result;
            } else {
                final String typeName = typeIdStar.getTypeOrId();

                // no matter if the "+" operator was used or not, target is always supposed to match on sub types
                final AtomicPredicate expectedCalleeTypeAtomicPredicate =
                                AtomicPredicateFactory.findOrCreateInstanceofPredicate(ContextFactory
                                                .findOrCreateCalleeContext(), TypeHierarchyProvider
                                                .findOrCreateFromNormalTypeName(typeName));
                return this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments,
                                expectedCalleeTypeAtomicPredicate);
            }
        }
    }

    public SpecializationBuilder visit(final ASTArgsPointcut node, final Object data) {
        // has one child: a typeIdStarList, consisting of "*", "..", typenames and identifiers (there may be at most one
        // "..")

        final Pair<List<TypeOrIdOrStar>, List<TypeOrIdOrStar>> lists =
                        this.visit(((ASTTypeIdStarList) node.jjtGetChild(0)), null);
        final List<TypeOrIdOrStar> frontList = lists.getLeft();
        final List<TypeOrIdOrStar> backList = lists.getRight();

        // 1.) Build AtomicArgDynamicProperties for each pattern in both list, i.e., to the left and the right of "..".

        final Set<AtomicPredicate> atomicPredicates = new HashSet<AtomicPredicate>();

        for (int i = 0; i < frontList.size(); i++) {
            final TypeOrIdOrStar typeIdStar = frontList.get(i);

            if (!typeIdStar.isWildcard()) {
                final TypeDescriptor expectedArgumentType;
                final boolean allowSubtypes;

                if (this.argName2IndexType.keySet().contains(typeIdStar.getTypeOrId())) {
                    expectedArgumentType = this.argName2IndexType.get(typeIdStar.getTypeOrId()).getRight();
                    allowSubtypes = true; // Bound arguments always match subtypes
                } else {
                    expectedArgumentType = TypeHierarchyProvider.findOrCreateFromNormalTypeName(typeIdStar.getTypeOrId());
                    allowSubtypes = true; // Always match subtypes
                }

                final Context argumentContext = ContextFactory.findOrCreateArgumentContext(i, backList.size());
                if (allowSubtypes) {
                    atomicPredicates.add(AtomicPredicateFactory.findOrCreateInstanceofPredicate(argumentContext,
                                    expectedArgumentType));
                } else {
                    atomicPredicates.add(AtomicPredicateFactory.findOrCreateExactTypePredicate(argumentContext,
                                    expectedArgumentType));
                }
            }
        }

        for (int i = 0; i < backList.size(); i++) {
            final TypeOrIdOrStar typeIdStar = backList.get(i);
            if (!typeIdStar.isWildcard()) {
                final TypeDescriptor expectedArgumentType;
                final boolean allowSubtypes;

                if (this.argName2IndexType.keySet().contains(typeIdStar.getTypeOrId())) {
                    expectedArgumentType = this.argName2IndexType.get(typeIdStar.getTypeOrId()).getRight();
                    allowSubtypes = true; // Bound arguments always match subtypes
                } else {
                    expectedArgumentType = TypeHierarchyProvider.findOrCreateFromNormalTypeName(typeIdStar.getTypeOrId());
                    allowSubtypes = true; // Always match subtypes
                }

                final Context argumentContext = ContextFactory.findOrCreateArgumentContext((i - backList.size()));
                if (allowSubtypes) {
                    atomicPredicates.add(AtomicPredicateFactory.findOrCreateInstanceofPredicate(argumentContext,
                                    expectedArgumentType));
                } else {
                    atomicPredicates.add(AtomicPredicateFactory.findOrCreateExactTypePredicate(argumentContext,
                                    expectedArgumentType));
                }

            }
        }

        final SpecializationBuilder result =
                        this.specializationsBuilderFactory.createSpecializationBuilder(this.numberOfArguments,
                                        atomicPredicates);

        // 2.) Add Contexts for each bound parameter

        for (int i = 0; i < frontList.size(); i++) {
            final TypeOrIdOrStar typeIdStar = frontList.get(i);
            if (!typeIdStar.isWildcard() && this.argName2IndexType.keySet().contains(typeIdStar.getTypeOrId())) {

                final Context argumentContext = ContextFactory.findOrCreateArgumentContext(i);
                result.setContext(this.argName2IndexType.get(typeIdStar.getTypeOrId()).getLeft(), argumentContext);
            }
        }

        for (int i = 0; i < backList.size(); i++) {
            final TypeOrIdOrStar typeIdStar = backList.get(i);
            if (!typeIdStar.isWildcard() && this.argName2IndexType.keySet().contains(typeIdStar.getTypeOrId())) {

                final Context argumentContext = ContextFactory.findOrCreateArgumentContext((i - backList.size()));
                result.setContext(this.argName2IndexType.get(typeIdStar.getTypeOrId()).getLeft(), argumentContext);
            }
        }

        return result;
    }

    public SpecializationBuilder visit(final ASTNamedPointcut node, final Object data) {
        // TODO suppprt named pointcuts
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    // ------------------------------------------
    // method signature (if PCD)
    // ------------------------------------------

    // ResultType()
    // Name()
    // "("
    // [ Name()
    // ( "," Name() )*
    // ]
    // ")"
    // public Object visit(ASTMethodSignature node, Object data) {
    // Node resultType = node.jjtGetChild(0);
    // Node name = node.jjtGetChild(1);
    // List<Node> arguments = new ArrayList<Node>();
    // for(int i = 2; i < node.jjtGetNumChildren(); i++) {
    // arguments.add(node.jjtGetChild(i));
    // }
    // TODO add support
    // throw new UnsupportedOperationException("Not yet implemented.");
    // }s

    // ------------------------------------------
    // field pattern (get/set)
    // ------------------------------------------

    private static class FieldPatternElements {

        private final ModifiersPattern modifiersPattern;

        private final TypePattern resultTypePattern;

        private final ClassTypePattern declaringClassTypePattern;

        private final NamePattern fieldNamePattern;

        public FieldPatternElements(final ModifiersPattern modifiersPattern, final TypePattern resultTypePattern,
                        final ClassTypePattern declaringClassTypePattern, final NamePattern methodNamePattern) {
            super();
            this.modifiersPattern = modifiersPattern;
            this.resultTypePattern = resultTypePattern;
            this.declaringClassTypePattern = declaringClassTypePattern;
            this.fieldNamePattern = methodNamePattern;
        }

        public ModifiersPattern getModifiersPattern() {
            return this.modifiersPattern;
        }

        public TypePattern getResultTypePattern() {
            return this.resultTypePattern;
        }

        public ClassTypePattern getDeclaringClassTypePattern() {
            return this.declaringClassTypePattern;
        }

        public NamePattern getFieldNamePattern() {
            return this.fieldNamePattern;
        }
    }

    private static class MethodPatternElements {

        private final ModifiersPattern modifiersPattern;

        private final TypePattern resultTypePattern;

        private final ClassTypePattern declaringClassTypePattern;

        private final NamePattern fieldNamePattern;

        private final ParametersPattern parametersPattern;

        private final ExceptionsPattern exceptionsPattern;

        public MethodPatternElements(final ModifiersPattern modifiersPattern, final TypePattern resultTypePattern,
                        final ClassTypePattern declaringClassTypePattern, final NamePattern fieldNamePattern,
                        final ParametersPattern parametersPattern, final ExceptionsPattern exceptionsPattern) {
            super();
            this.modifiersPattern = modifiersPattern;
            this.resultTypePattern = resultTypePattern;
            this.declaringClassTypePattern = declaringClassTypePattern;
            this.fieldNamePattern = fieldNamePattern;
            this.parametersPattern = parametersPattern;
            this.exceptionsPattern = exceptionsPattern;
        }

        public ModifiersPattern getModifiersPattern() {
            return this.modifiersPattern;
        }

        public TypePattern getResultTypePattern() {
            return this.resultTypePattern;
        }

        public ClassTypePattern getDeclaringClassTypePattern() {
            return this.declaringClassTypePattern;
        }

        public NamePattern getFieldNamePattern() {
            return this.fieldNamePattern;
        }

        public ParametersPattern getParametersPattern() {
            return this.parametersPattern;
        }

        public ExceptionsPattern getExceptionsPattern() {
            return this.exceptionsPattern;
        }
    }

    @SuppressWarnings("unused")
    private static class ConstructorPatternElements {

        private final ModifiersPattern modifiersPattern;

        private final ClassTypePattern declaringClassTypePattern;

        private final ParametersPattern parametersPattern;

        private final ExceptionsPattern exceptionsPattern;

        public ConstructorPatternElements(final ModifiersPattern modifiersPattern,
                        final ClassTypePattern declaringClassTypePattern, final ParametersPattern parametersPattern,
                        final ExceptionsPattern exceptionsPattern) {
            super();
            this.modifiersPattern = modifiersPattern;
            this.declaringClassTypePattern = declaringClassTypePattern;
            this.parametersPattern = parametersPattern;
            this.exceptionsPattern = exceptionsPattern;
        }

        public ModifiersPattern getModifiersPattern() {
            return this.modifiersPattern;
        }

        public ClassTypePattern getDeclaringClassTypePattern() {
            return this.declaringClassTypePattern;
        }

        public ParametersPattern getParametersPattern() {
            return this.parametersPattern;
        }

        public ExceptionsPattern getExceptionsPattern() {
            return this.exceptionsPattern;
        }
    }

    // ModifierPatternExpression()
    // TypePatternExpression()
    // ClasstypeDotId()
    public FieldPatternElements visit(final ASTFieldPattern node, final Object data) {
        final ModifiersPattern modifiersPattern = this.visit((ASTModifiersPattern) node.jjtGetChild(0), null);
        final TypePattern resultTypePattern = (TypePattern) node.jjtGetChild(1).jjtAccept(this, null);

        final FullyQualifiedMemberPattern fullyQualifiedFieldPattern =
                        this.visit((ASTClasstypeDotId) node.jjtGetChild(2), null);
        final ClassTypePattern declaringClassTypePattern = fullyQualifiedFieldPattern.getDeclaringClassTypePattern();
        final NamePattern fieldNamePattern = fullyQualifiedFieldPattern.getMethodNamePattern();

        return new FieldPatternElements(modifiersPattern, resultTypePattern, declaringClassTypePattern, fieldNamePattern);
    }

    // ------------------------------------------
    // method/constructor pattern (call/execution/initialization/preinitialization)
    // ------------------------------------------

    // ModifierPatternExpression()
    // ClasstypeDotNew()
    // "(" FormalPatternListOpt() ")"
    // ThrowsPatternListOpt()

    public ConstructorPatternElements visit(final ASTConstructorPattern node, final Object data) {
        final ModifiersPattern modifiersPattern = this.visit((ASTModifiersPattern) node.jjtGetChild(0), null);

        final ClassTypePattern declaringClassTypePattern = this.visit((ASTClasstypeDotNew) node.jjtGetChild(2), null);

        final ParametersPattern parametersPattern = this.visit((ASTFormalPatternList) node.jjtGetChild(3), null);
        final ExceptionsPattern throwsPattern = this.visit((ASTThrowsPatternList) node.jjtGetChild(4), null);

        return new ConstructorPatternElements(modifiersPattern, declaringClassTypePattern, parametersPattern, throwsPattern);
    }

    // ModifierPatternExpression()
    // TypePatternExpression()
    // ClasstypeDotId()
    // "(" FormalPatternListOpt() ")"
    // ThrowsPatternListOpt()
    public MethodPatternElements visit(final ASTMethodPattern node, final Object data) {
        final ModifiersPattern modifiersPattern = this.visit((ASTModifiersPattern) node.jjtGetChild(0), null);
        final TypePattern resultTypePattern = (TypePattern) node.jjtGetChild(1).jjtAccept(this, null);
        final FullyQualifiedMemberPattern fullyQualifiedMethodPattern =
                        this.visit((ASTClasstypeDotId) node.jjtGetChild(2), null);
        final ClassTypePattern declaringClassTypePattern = fullyQualifiedMethodPattern.getDeclaringClassTypePattern();
        final NamePattern methodNamePattern = fullyQualifiedMethodPattern.getMethodNamePattern();
        final ParametersPattern parametersPattern = this.visit((ASTFormalPatternList) node.jjtGetChild(3), null);
        final ExceptionsPattern exceptionsPattern = this.visit((ASTThrowsPatternList) node.jjtGetChild(4), null);

        return new MethodPatternElements(modifiersPattern, resultTypePattern, declaringClassTypePattern, methodNamePattern,
                        parametersPattern, exceptionsPattern);
    }

    public ModifiersPattern visit(final ASTModifiersPattern node, final Object data) {
        int modifiersFlags = 0;
        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            if (node.jjtGetChild(i) instanceof ASTNotPublic)
                modifiersFlags |= WildcardModifiersPattern.NOT_PUBLIC;
            else if (node.jjtGetChild(i) instanceof ASTNotStatic)
                modifiersFlags |= WildcardModifiersPattern.NOT_STATIC;
            else if (node.jjtGetChild(i) instanceof ASTNotProtected)
                modifiersFlags |= WildcardModifiersPattern.NOT_PROTECTED;
            else if (node.jjtGetChild(i) instanceof ASTNotPrivate)
                modifiersFlags |= WildcardModifiersPattern.NOT_PRIVATE;
            else if (node.jjtGetChild(i) instanceof ASTNotFinal)
                modifiersFlags |= WildcardModifiersPattern.NOT_FINAL;
            else if (node.jjtGetChild(i) instanceof ASTNotAbstract)
                modifiersFlags |= WildcardModifiersPattern.NOT_ABSTRACT;
            else if (node.jjtGetChild(i) instanceof ASTNotSynchronized)
                modifiersFlags |= WildcardModifiersPattern.NOT_SYNCHRONIZED;
            else if (node.jjtGetChild(i) instanceof ASTNotNative)
                modifiersFlags |= WildcardModifiersPattern.NOT_NATIVE;
            else if (node.jjtGetChild(i) instanceof ASTNotTransient)
                modifiersFlags |= WildcardModifiersPattern.NOT_TRANSIENT;
            else if (node.jjtGetChild(i) instanceof ASTNotVolatile)
                modifiersFlags |= WildcardModifiersPattern.NOT_VOLATILE;
            else if (node.jjtGetChild(i) instanceof ASTNotStrictfp)
                modifiersFlags |= WildcardModifiersPattern.NOT_STRICT;

            if (node.jjtGetChild(i) instanceof ASTPublic)
                modifiersFlags |= WildcardModifiersPattern.PUBLIC;
            else if (node.jjtGetChild(i) instanceof ASTStatic)
                modifiersFlags |= WildcardModifiersPattern.STATIC;
            else if (node.jjtGetChild(i) instanceof ASTProtected)
                modifiersFlags |= WildcardModifiersPattern.PROTECTED;
            else if (node.jjtGetChild(i) instanceof ASTPrivate)
                modifiersFlags |= WildcardModifiersPattern.PRIVATE;
            else if (node.jjtGetChild(i) instanceof ASTFinal)
                modifiersFlags |= WildcardModifiersPattern.FINAL;
            else if (node.jjtGetChild(i) instanceof ASTAbstract)
                modifiersFlags |= WildcardModifiersPattern.ABSTRACT;
            else if (node.jjtGetChild(i) instanceof ASTSynchronized)
                modifiersFlags |= WildcardModifiersPattern.SYNCHRONIZED;
            else if (node.jjtGetChild(i) instanceof ASTNative)
                modifiersFlags |= WildcardModifiersPattern.NATIVE;
            else if (node.jjtGetChild(i) instanceof ASTTransient)
                modifiersFlags |= WildcardModifiersPattern.TRANSIENT;
            else if (node.jjtGetChild(i) instanceof ASTVolatile)
                modifiersFlags |= WildcardModifiersPattern.VOLATILE;
            else if (node.jjtGetChild(i) instanceof ASTStrictfp)
                modifiersFlags |= WildcardModifiersPattern.STRICT;
        }

        if (modifiersFlags == 0)
            return ModifiersPattern.ANY;
        else
            return new WildcardModifiersPattern(modifiersFlags);
    }

    // "new" #New
    // |
    // NamePattern()
    // ("+" #SubTypeOperator "." | ".." #PackageRest | ".") "new" #New
    // |
    // "(" TypePatternExpression() ")" "." "new" #New

    public ClassTypePattern visit(final ASTClasstypeDotNew node, final Object data) {
        // three alternatives:
        // only one new keyword,
        if (node.jjtGetNumChildren() == 1 && node.jjtGetChild(0) instanceof ASTNew) {
            return ClassTypePattern.ANY;
        } else if (node.jjtGetNumChildren() == 2) {
            // it is either the second or the third alternative
            // in any case the first node represents the declaring class type pattern
            // without any modification
            // the second node is the "new"
            return (ClassTypePattern) node.jjtGetChild(0).jjtAccept(this, null);
        } else {
            // it is the second alternative
            // again we have three choices:
            // if the type pattern was followed by a ".", the second node is "New"
            // but this was already covered in the previous if-block
            // if the second node is SubTypeOperator, we can simply wrap the name pattern
            if (node.jjtGetChild(1) instanceof ASTSubTypeOperator) {
                return new SubTypePattern(this.visit((ASTNamePattern) node.jjtGetChild(0), null));
            }
            // if the second node is a ".." we must add this to the name pattern
            else {

                final List<Node> patternElements = new ArrayList<Node>();
                for (int i = 0; i < node.jjtGetChild(0).jjtGetNumChildren(); i++) {
                    patternElements.add(node.jjtGetChild(0).jjtGetChild(i));
                }
                // second node must be a PackageRest
                patternElements.add(node.jjtGetChild(1));
                return this.classTypePatternFromAST(patternElements);
            }
        }

    }

    // (
    // NamePattern()
    // [ "+" #SubTypeOperator "." SimpleNamePattern() ]
    // )
    // |
    // "(" TypePatternExpression() ")" "." SimpleNamePattern()
    public FullyQualifiedMemberPattern visit(final ASTClasstypeDotId node, final Object data) {
        ClassTypePattern declaringClassTypePattern;
        NamePattern methodNamePattern;
        // first child may either be a NamePattern, or some type pattern (AndTypePattern, OrTypePattern, BasicTypePattern,
        // ...)
        if (node.jjtGetChild(0) instanceof ASTNamePattern) {
            final ASTNamePattern namePattern = (ASTNamePattern) node.jjtGetChild(0);
            // first case: we have a name pattern, optionally followed by a sub type operator and a simple name pattern
            if (node.jjtGetNumChildren() > 1) {
                // there is the sub type operator and the simple name pattern
                // first child was the first name pattern
                // second child is the sub type operator
                // third child is the simple name pattern
                final ASTSimpleNamePattern identifierPattern = (ASTSimpleNamePattern) node.jjtGetChild(2);
                // the name pattern represents the declaring class type
                final ClassTypePattern baseTypePattern = this.visit(namePattern, null);
                declaringClassTypePattern = new SubTypePattern(baseTypePattern);
                // the simple name pattern represents the method name pattern
                methodNamePattern = this.visit(identifierPattern, null);
            } else {
                // the name pattern contains the declaring class type pattern
                // but also the method name pattern (after the last ".")

                // first children of (only) node represent the declaring class type pattern
                // last children of (only) node represents the method name pattern (must be a simple name pattern)
                final Node onlyNode = node.jjtGetChild(0);

                final List<Node> declaringClassTypeNodes = new ArrayList<Node>();
                for (int i = 0; i < onlyNode.jjtGetNumChildren() - 1; i++) {
                    declaringClassTypeNodes.add(onlyNode.jjtGetChild(i));
                }
                declaringClassTypePattern = this.classTypePatternFromAST(declaringClassTypeNodes);
                methodNamePattern =
                                this.visit((ASTSimpleNamePattern) onlyNode.jjtGetChild(onlyNode.jjtGetNumChildren() - 1),
                                                null);
            }
        } else {
            // first child is some type pattern predicate (don't know exactly which)
            // second child is the method name pattern
            declaringClassTypePattern = (ClassTypePattern) node.jjtGetChild(0).jjtAccept(this, null);
            methodNamePattern = this.visit((ASTSimpleNamePattern) node.jjtGetChild(1), null);
        }
        return new FullyQualifiedMemberPattern(declaringClassTypePattern, methodNamePattern);
    }

    // [
    // FormalPattern()
    // ("," FormalPattern())*
    // ]
    //
    //
    // void FormalPattern():
    // {}
    // {
    // ".." #PackageRest
    // |
    // "." "." #PackageRest
    // |
    // TypePatternExpression()
    // }
    public ParametersPattern visit(final ASTFormalPatternList node, final Object data) {
        // contains a possibly empty list of children which are either a type pattern or the PackageRest operator

        final List<ParametersPatternElement> patternElements = new ArrayList<ParametersPatternElement>();
        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            if (node.jjtGetChild(i) instanceof ASTPackageRest) {
                patternElements.add(ParametersRest.INSTANCE);
            } else {
                patternElements.add(new TypePatternElement((TypePattern) node.jjtGetChild(i).jjtAccept(this, null)));
            }
        }
        return new WildcardParametersPattern(patternElements);
    }

    // [
    // "throws"
    // ThrowsPattern()
    // ("," ThrowsPattern()
    // )*
    // ]
    // #ThrowsPatternList
    //
    // void ThrowsPattern():
    // {}
    // {
    // ClassnamePatternExpressionNobang()
    // |
    // "!" ClassnamePatternExpression() #NegatedClassnamePattern
    // }
    public ExceptionsPattern visit(final ASTThrowsPatternList node, final Object data) {
        // potentially empty list of either (some type pattern) or (a negated class name pattern)
        if (node.jjtGetNumChildren() == 0)
            return ExceptionsPattern.ANY;

        // A ThrowsClausePattern matches the throws clause of any code member signature. To match, each
        // ThrowsClausePatternItem
        // must match the throws clause of the member in question. If any item doesn't match, then the whole pattern doesn't
        // match.
        // If a ThrowsClausePatternItem begins with "!", then it matches a particular throws clause if and only if none of
        // the
        // types named in the throws clause is matched by the TypeNamePattern.
        // If a ThrowsClausePatternItem does not begin with "!", then it matches a throws clause if and only if any of the
        // types
        // named in the throws clause is matched by the TypeNamePattern.
        final List<ExceptionsPatternElement> patternElements = new ArrayList<ExceptionsPatternElement>();
        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            if (node.jjtGetChild(i) instanceof ASTNegativeClassnamePattern) {
                // a negated class name pattern has one child which is the base type pattern
                final TypePattern baseTypePattern = (TypePattern) node.jjtGetChild(i).jjtGetChild(0).jjtAccept(this, null);
                patternElements.add(new NegativeTypePatternElement(baseTypePattern));
            } else {
                // a normal class name pattern
                final TypePattern baseTypePattern = (TypePattern) node.jjtGetChild(i).jjtAccept(this, null);
                patternElements.add(new PositiveTypePatternElement(baseTypePattern));
            }
        }
        return new WildcardExceptionsPattern(patternElements);
    }

    public Object visit(final ASTNegativeClassnamePattern node, final Object data) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public Object visit(final ASTNew node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    // ------------------------------------------
    // modifiers for modifiers pattern
    // ------------------------------------------

    public Object visit(final ASTNotPublic node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNotStatic node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNotProtected node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNotPrivate node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNotFinal node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNotAbstract node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNotSynchronized node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNotNative node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNotTransient node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNotStrictfp node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNotVolatile node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTPublic node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTStatic node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTProtected node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTPrivate node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTFinal node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTAbstract node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTSynchronized node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTNative node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTTransient node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTVolatile node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    public Object visit(final ASTStrictfp node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }

    // ------------------------------------------
    // TYPES
    // ------------------------------------------

    public String visit(final ASTClassOrInterfaceType node, final Object data) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            if (node.jjtGetChild(i) instanceof ASTTypeArgumentList) {
                throw new UnsupportedOperationException("Generic types not yet supported.");
            } else {
                result.append(((ASTIdentifier) node.jjtGetChild(i)).getIdentifier());
                if (i < node.jjtGetNumChildren() - 1)
                    result.append('.');
            }
        }
        return result.toString();
    }

    public String visit(final ASTPrimitiveArrayType node, final Object data) {
        final StringBuilder result = new StringBuilder();
        result.append(node.jjtGetChild(0).jjtAccept(this, null));
        for (int i = 0; i < node.getDimension(); i++)
            result.append("[]");
        return result.toString();
    }

    public String visit(final ASTClassOrInterfaceArrayType node, final Object data) {
        final StringBuilder result = new StringBuilder();
        result.append(node.jjtGetChild(0).jjtAccept(this, null));
        for (int i = 0; i < node.getDimension(); i++)
            result.append("[]");
        return result.toString();
    }

    // ------------------------------------------
    //
    // ------------------------------------------

    public Pair<List<TypeOrIdOrStar>, List<TypeOrIdOrStar>> visit(final ASTTypeIdStarList node, final Object data) {

        final List<TypeOrIdOrStar> frontList = new ArrayList<TypeOrIdOrStar>();

        final List<TypeOrIdOrStar> backList = new ArrayList<TypeOrIdOrStar>();

        List<TypeOrIdOrStar> currentList = frontList;

        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            if (node.jjtGetChild(i) instanceof ASTPackageRest) {
                if (currentList == backList)
                    throw new IllegalArgumentException("Multiple occurrences of \"..\" pattern are prohibited.");
                currentList = backList;
                continue;
            }
            final Object typeIdStar = node.jjtGetChild(i).jjtAccept(this, null);
            currentList.add((TypeOrIdOrStar) typeIdStar);
        }

        return new Pair<List<TypeOrIdOrStar>, List<TypeOrIdOrStar>>(frontList, backList);
    }

    // "*" #NameWildcard
    // |
    // Type() [ "+" #SubTypeOperator ]
    public TypeOrIdOrStar visit(final ASTTypeIdStar node, final Object data) {
        // three cases:
        // 1. "*"
        if (node.jjtGetChild(0) instanceof ASTNameWildcard)
            return new TypeOrIdOrStar();
        // 2. type
        final String typeName = (String) node.jjtGetChild(0).jjtAccept(this, null);
        if (node.jjtGetNumChildren() == 1) {
            return new TypeOrIdOrStar(typeName, false);
        }
        // 3. type "+"
        return new TypeOrIdOrStar(typeName, true);

    }

    @SuppressWarnings("unchecked")
    public Object visit(final ASTMethodCall node, final Object data) {
        final String fullyQualifiedMethodName = (String) node.jjtGetChild(0).jjtAccept(this, null);
        final List<String> arguments = (List) node.jjtGetChild(1).jjtAccept(this, null);

        return new MethodCall(fullyQualifiedMethodName, arguments);
    }

    public Object visit(final ASTIdList node, final Object data) {
        final List<String> identifiers = new ArrayList<String>();

        for (int i = 0; i < node.jjtGetNumChildren(); i++) {
            identifiers.add((String) node.jjtGetChild(i).jjtAccept(this, null));
        }

        return identifiers;
    }

    public Object visit(final ASTClinitIdentifier node, final Object data) {
        throw new UnsupportedOperationException("This leaf node has only a marking purpose; don't call visit on it.");
    }
}
