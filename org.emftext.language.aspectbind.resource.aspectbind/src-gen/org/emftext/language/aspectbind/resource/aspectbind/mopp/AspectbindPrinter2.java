/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

public class AspectbindPrinter2 implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextPrinter {
	
	protected class PrintToken {
		
		private String text;
		private String tokenName;
		
		public PrintToken(String text, String tokenName) {
			this.text = text;
			this.tokenName = tokenName;
		}
		
		public String getText() {
			return text;
		}
		
		public String getTokenName() {
			return tokenName;
		}
		
	}
	
	public final static String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	
	private final PrintToken SPACE_TOKEN = new PrintToken(" ", null);
	private final PrintToken TAB_TOKEN = new PrintToken("\t", null);
	private final PrintToken NEW_LINE_TOKEN = new PrintToken(NEW_LINE, null);
	
	/**
	 * Holds the resource that is associated with this printer. May be null if the
	 * printer is used stand alone.
	 */
	private org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource resource;
	
	private java.util.Map<?, ?> options;
	private java.io.OutputStream outputStream;
	protected java.util.List<PrintToken> tokenOutputStream;
	private org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolverFactory tokenResolverFactory = new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenResolverFactory();
	private boolean handleTokenSpaceAutomatically = true;
	private int tokenSpace = 1;
	/**
	 * A flag that indicates whether tokens have already been printed for some object.
	 * The flag is set to false whenever printing of an EObject tree is started. The
	 * status of the flag is used to avoid printing default token space in front of
	 * the root object.
	 */
	private boolean startedPrintingObject = false;
	/**
	 * The number of tab characters that were printed before the current line. This
	 * number is used to calculate the relative indentation when printing contained
	 * objects, because all contained objects must start with this indentation
	 * (tabsBeforeCurrentObject + currentTabs).
	 */
	private int currentTabs;
	/**
	 * The number of tab characters that must be printed before the current object.
	 * This number is used to calculate the indentation of new lines, when line breaks
	 * are printed within one object.
	 */
	private int tabsBeforeCurrentObject;
	/**
	 * This flag is used to indicate whether the number of tabs before the current
	 * object has been set for the current object. The flag is needed, because setting
	 * the number of tabs must be performed when the first token of the contained
	 * element is printed.
	 */
	private boolean startedPrintingContainedObject;
	
	public AspectbindPrinter2(java.io.OutputStream outputStream, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		tokenOutputStream = new java.util.ArrayList<PrintToken>();
		currentTabs = 0;
		tabsBeforeCurrentObject = 0;
		startedPrintingObject = true;
		startedPrintingContainedObject = false;
		java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement>  formattingElements = new java.util.ArrayList<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement>();
		doPrint(element, formattingElements);
		// print all remaining formatting elements
		java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations = getCopyOfLayoutInformation(element);
		org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation eofLayoutInformation = getLayoutInformation(layoutInformations, null, null, null);
		printFormattingElements(formattingElements, layoutInformations, eofLayoutInformation);
		java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		if (handleTokenSpaceAutomatically) {
			printSmart(writer);
		} else {
			printBasic(writer);
		}
		writer.flush();
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> foundFormattingElements) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (outputStream == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.emftext.language.aspectbind.commons.Aspect) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_0, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.pointcuts.CallPointcut) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_1, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.pointcuts.ThisPointcut) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_2, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.pointcuts.AspectJPointcut) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_3, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.commons.PerClause) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_4, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.binding.InstancePointcut) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_5, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.patterns.FieldPattern) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_6, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.patterns.ConstructorPattern) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_7, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.patterns.MethodPattern) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_8, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.patterns.TypePattern) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_9, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.declaration.AdapterDeclaration) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_10, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.declaration.Adapter) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_11, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.declaration.PrecedenceDeclaration) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_12, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.declaration.InterTypeDeclaration) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_13, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.aspectbind.pcexp.PointcutExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ASPECTBIND_14, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.containers.EmptyModel) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_0, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.containers.Package) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_1, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.containers.CompilationUnit) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_2, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.imports.ClassifierImport) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_3, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.imports.PackageImport) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_4, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.imports.StaticMemberImport) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_5, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.imports.StaticClassifierImport) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_6, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.classifiers.Class) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_7, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.classifiers.AnonymousClass) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_8, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.classifiers.Interface) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_9, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.classifiers.Enumeration) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_10, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.classifiers.Annotation) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_11, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.annotations.AnnotationInstance) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_12, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.annotations.SingleAnnotationParameter) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_13, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.annotations.AnnotationParameterList) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_14, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.annotations.AnnotationAttributeSetting) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_15, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.generics.TypeParameter) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_16, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.members.EnumConstant) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_17, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.Block) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_18, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.members.Constructor) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_19, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.members.ClassMethod) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_21, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.annotations.AnnotationAttribute) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_22, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.parameters.OrdinaryParameter) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_23, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.parameters.VariableLengthParameter) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_24, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.variables.LocalVariable) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_25, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.LocalVariableStatement) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_26, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.variables.AdditionalLocalVariable) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_27, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.members.Field) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_28, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.members.AdditionalField) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_29, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.members.EmptyMember) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_30, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.instantiations.NewConstructorCall) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_31, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.instantiations.ExplicitConstructorCall) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_32, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.arrays.ArrayInstantiationByValues) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_33, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.arrays.ArrayInstantiationBySize) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_34, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.arrays.ArrayInitializer) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_35, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.arrays.ArraySelector) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_36, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.types.NamespaceClassifierReference) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_37, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.types.ClassifierReference) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_38, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.references.MethodCall) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_39, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.references.IdentifierReference) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_40, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.references.ReflectiveClassReference) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_41, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.references.SelfReference) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_42, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.references.PrimitiveTypeReference) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_43, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.This) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_44, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.Super) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_45, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.references.StringReference) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_46, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.generics.QualifiedTypeArgument) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_47, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.generics.UnknownTypeArgument) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_48, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.generics.ExtendsTypeArgument) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_49, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.generics.SuperTypeArgument) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_50, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.Assert) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_51, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.Condition) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_52, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.ForLoop) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_53, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.ForEachLoop) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_54, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.DoWhileLoop) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_56, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.EmptyStatement) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_57, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.SynchronizedBlock) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_58, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.TryBlock) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_59, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.CatchBlock) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_60, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.Switch) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_61, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.NormalSwitchCase) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_62, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.DefaultSwitchCase) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_63, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.Return) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_64, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.Throw) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_65, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.Break) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_66, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.Continue) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_67, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.JumpLabel) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_68, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.ExpressionStatement) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_69, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.ExpressionList) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_70, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.AssignmentExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_71, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.ConditionalExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_72, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.ConditionalOrExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_73, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.ConditionalAndExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_74, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.InclusiveOrExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_75, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.ExclusiveOrExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_76, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.AndExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_77, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.EqualityExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_78, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.InstanceOfExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_79, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.RelationExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_80, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.ShiftExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_81, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.AdditiveExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_82, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.MultiplicativeExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_83, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.UnaryExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_84, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.SuffixUnaryModificationExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_85, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.PrefixUnaryModificationExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_86, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.CastExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_87, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.expressions.NestedExpression) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_88, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.Assignment) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_89, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.AssignmentPlus) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_90, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.AssignmentMinus) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_91, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.AssignmentMultiplication) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_92, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.AssignmentDivision) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_93, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.AssignmentAnd) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_94, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.AssignmentOr) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_95, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.AssignmentExclusiveOr) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_96, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.AssignmentModulo) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_97, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.AssignmentLeftShift) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_98, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.AssignmentRightShift) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_99, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.AssignmentUnsignedRightShift) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_100, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.Addition) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_101, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.Subtraction) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_102, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.Multiplication) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_103, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.Division) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_104, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.Remainder) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_105, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.LessThan) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_106, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.LessThanOrEqual) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_107, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.GreaterThan) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_108, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.GreaterThanOrEqual) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_109, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.LeftShift) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_110, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.RightShift) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_111, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.UnsignedRightShift) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_112, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.Equal) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_113, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.NotEqual) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_114, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.PlusPlus) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_115, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.MinusMinus) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_116, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.Complement) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_117, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.operators.Negate) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_118, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.arrays.ArrayDimension) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_119, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.NullLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_120, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.modifiers.Public) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_121, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.modifiers.Abstract) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_122, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.modifiers.Protected) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_123, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.modifiers.Private) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_124, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.modifiers.Final) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_125, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.modifiers.Static) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_126, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.modifiers.Native) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_127, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.modifiers.Synchronized) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_128, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.modifiers.Transient) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_129, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.modifiers.Volatile) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_130, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.modifiers.Strictfp) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_131, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.types.Void) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_132, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.types.Boolean) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_133, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.types.Char) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_134, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.types.Byte) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_135, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.types.Short) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_136, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.types.Int) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_137, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.types.Long) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_138, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.types.Float) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_139, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.types.Double) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_140, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.DecimalLongLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_141, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.DecimalFloatLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_142, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.DecimalIntegerLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_143, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.DecimalDoubleLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_144, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.HexLongLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_145, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.HexFloatLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_146, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.HexDoubleLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_147, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.HexIntegerLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_148, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.OctalLongLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_149, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.OctalIntegerLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_150, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.CharacterLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_151, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.literals.BooleanLiteral) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_152, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.members.InterfaceMethod) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_20, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.language.java.statements.WhileLoop) {
			printInternal(element, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.JAVA_55, foundFormattingElements);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	public void printInternal(org.eclipse.emf.ecore.EObject eObject, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement ruleElement, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> foundFormattingElements) {
		java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations = getCopyOfLayoutInformation(eObject);
		org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator decoratorTree = getDecoratorTree(ruleElement);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, foundFormattingElements, layoutInformations);
	}
	
	/**
	 * creates a tree of decorator objects which reflects the syntax tree that is
	 * attached to the given syntax element
	 */
	public org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator getDecoratorTree(org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement syntaxElement) {
		org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement[] children = syntaxElement.getChildren();
		int childCount = children.length;
		org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator[] childDecorators = new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator[childCount];
		for (int i = 0; i < childCount; i++) {
			childDecorators[i] = getDecoratorTree(children[i]);
		}
		org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator decorator = new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator(syntaxElement, childDecorators);
		return decorator;
	}
	
	public void decorateTree(org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject) {
		java.util.Map<String, Integer> printCountingMap = initializePrintCountingMap(eObject);
		java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator> keywordsToPrint = new java.util.ArrayList<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator>();
		decorateTreeBasic(decorator, eObject, printCountingMap, keywordsToPrint);
		for (org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator keywordToPrint : keywordsToPrint) {
			// for keywords the concrete index does not matter, but we must add one to
			// indicate that the keyword needs to be printed here. Thus, we use 0 as index.
			keywordToPrint.addIndexToPrint(0);
		}
	}
	
	/**
	 * Tries to decorate the decorator with an attribute value, or reference holded by
	 * eObject. Returns true if an attribute value or reference was found.
	 */
	public boolean decorateTreeBasic(org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.Map<String, Integer> printCountingMap, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator> keywordsToPrint) {
		boolean foundFeatureToPrint = false;
		org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement syntaxElement = decorator.getDecoratedElement();
		org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality = syntaxElement.getCardinality();
		boolean isFirstIteration = true;
		while (true) {
			java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator> subKeywordsToPrint = new java.util.ArrayList<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator>();
			boolean keepDecorating = false;
			if (syntaxElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindKeyword) {
				subKeywordsToPrint.add(decorator);
			} else if (syntaxElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindTerminal) {
				org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindTerminal terminal = (org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindTerminal) syntaxElement;
				org.eclipse.emf.ecore.EStructuralFeature feature = terminal.getFeature();
				if (feature == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ANONYMOUS_FEATURE) {
					return false;
				}
				int countLeft = printCountingMap.get(feature.getName());
				if (countLeft > terminal.getMandatoryOccurencesAfter()) {
					decorator.addIndexToPrint(countLeft);
					printCountingMap.put(feature.getName(), countLeft - 1);
					keepDecorating = true;
				}
			}
			if (syntaxElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindChoice) {
				// for choices we do print only the choice which does print at least one feature
				org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator childToPrint = null;
				for (org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
					// pick first choice as default, will be overridden if a choice that prints a
					// feature is found
					if (childToPrint == null) {
						childToPrint = childDecorator;
					}
					if (doesPrintFeature(childDecorator, eObject, printCountingMap)) {
						childToPrint = childDecorator;
						break;
					}
				}
				keepDecorating |= decorateTreeBasic(childToPrint, eObject, printCountingMap, subKeywordsToPrint);
			} else {
				// for all other syntax element we do print all children
				for (org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
					keepDecorating |= decorateTreeBasic(childDecorator, eObject, printCountingMap, subKeywordsToPrint);
				}
			}
			foundFeatureToPrint |= keepDecorating;
			// only print keywords if a feature was printed or the syntax element is mandatory
			if (cardinality == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality.ONE) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			} else if (cardinality == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality.PLUS) {
				if (isFirstIteration) {
					keywordsToPrint.addAll(subKeywordsToPrint);
				} else {
					if (keepDecorating) {
						keywordsToPrint.addAll(subKeywordsToPrint);
					}
				}
			} else if (keepDecorating && (cardinality == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality.STAR || cardinality == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality.QUESTIONMARK)) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			}
			if (cardinality == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality.ONE || cardinality == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality.QUESTIONMARK) {
				break;
			} else if (!keepDecorating) {
				break;
			}
			isFirstIteration = false;
		}
		return foundFeatureToPrint;
	}
	
	/**
	 * Checks whether decorating the given node will use at least one attribute value,
	 * or reference holded by eObject. Returns true if a printable attribute value or
	 * reference was found. This method is used to decide which choice to pick, when
	 * multiple choices are available. We pick the choice that prints at least one
	 * attribute or reference.
	 */
	public boolean doesPrintFeature(org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.Map<String, Integer> printCountingMap) {
		org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement syntaxElement = decorator.getDecoratedElement();
		if (syntaxElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindTerminal) {
			org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindTerminal terminal = (org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindTerminal) syntaxElement;
			org.eclipse.emf.ecore.EStructuralFeature feature = terminal.getFeature();
			if (feature == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindGrammarInformationProvider.ANONYMOUS_FEATURE) {
				return false;
			}
			int countLeft = printCountingMap.get(feature.getName());
			if (countLeft > terminal.getMandatoryOccurencesAfter()) {
				// found a feature to print
				return true;
			}
		}
		for (org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
			if (doesPrintFeature(childDecorator, eObject, printCountingMap)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean printTree(org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> foundFormattingElements, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations) {
		org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement printElement = decorator.getDecoratedElement();
		org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality = printElement.getCardinality();
		java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> cloned = new java.util.ArrayList<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement>();
		cloned.addAll(foundFormattingElements);
		boolean foundSomethingAtAll = false;
		boolean foundSomethingToPrint;
		while (true) {
			foundSomethingToPrint = false;
			Integer indexToPrint = decorator.getNextIndexToPrint();
			if (indexToPrint != null) {
				if (printElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindKeyword) {
					printKeyword(eObject, (org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindKeyword) printElement, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindPlaceholder) {
					org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindPlaceholder placeholder = (org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindPlaceholder) printElement;
					printFeature(eObject, placeholder, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindContainment) {
					org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindContainment containment = (org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindContainment) printElement;
					printContainedObject(eObject, containment, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindBooleanTerminal) {
					org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindBooleanTerminal booleanTerminal = (org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindBooleanTerminal) printElement;
					printBooleanTerminal(eObject, booleanTerminal, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindEnumerationTerminal) {
					org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindEnumerationTerminal enumTerminal = (org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindEnumerationTerminal) printElement;
					printEnumerationTerminal(eObject, enumTerminal, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				}
			}
			if (foundSomethingToPrint) {
				foundSomethingAtAll = true;
			}
			if (printElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindWhiteSpace) {
				foundFormattingElements.add((org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindWhiteSpace) printElement);
			}
			if (printElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindLineBreak) {
				foundFormattingElements.add((org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindLineBreak) printElement);
			}
			for (org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
				foundSomethingToPrint |= printTree(childDecorator, eObject, foundFormattingElements, layoutInformations);
				org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement decoratedElement = decorator.getDecoratedElement();
				if (foundSomethingToPrint && decoratedElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindChoice) {
					break;
				}
			}
			if (cardinality == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality.ONE || cardinality == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality.QUESTIONMARK) {
				break;
			} else if (!foundSomethingToPrint) {
				break;
			}
		}
		// only print formatting elements if a feature was printed or the syntax element
		// is mandatory
		if (!foundSomethingAtAll && (cardinality == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality.STAR || cardinality == org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality.QUESTIONMARK)) {
			foundFormattingElements.clear();
			foundFormattingElements.addAll(cloned);
		}
		return foundSomethingToPrint;
	}
	
	public void printKeyword(org.eclipse.emf.ecore.EObject eObject, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindKeyword keyword, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> foundFormattingElements, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations) {
		org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, keyword, null, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		String value = keyword.getValue();
		tokenOutputStream.add(new PrintToken(value, "'" + org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindStringUtil.escapeToANTLRKeyword(value) + "'"));
	}
	
	public void printFeature(org.eclipse.emf.ecore.EObject eObject, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindPlaceholder placeholder, int count, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> foundFormattingElements, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature feature = placeholder.getFeature();
		if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
			printAttribute(eObject, (org.eclipse.emf.ecore.EAttribute) feature, placeholder, count, foundFormattingElements, layoutInformations);
		} else {
			printReference(eObject, (org.eclipse.emf.ecore.EReference) feature, placeholder, count, foundFormattingElements, layoutInformations);
		}
	}
	
	public void printAttribute(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EAttribute attribute, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindPlaceholder placeholder, int count, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> foundFormattingElements, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations) {
		String result;
		Object attributeValue = getValue(eObject, attribute, count);
		org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, placeholder, attributeValue, eObject);
		String visibleTokenText = getVisibleTokenText(layoutInformation);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		} else {
			// if no text is available, the attribute is deresolved to obtain its textual
			// representation
			org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(placeholder.getTokenName());
			tokenResolver.setOptions(getOptions());
			String deResolvedValue = tokenResolver.deResolve(attributeValue, attribute, eObject);
			result = deResolvedValue;
		}
		if (result != null && !"".equals(result)) {
			printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
			// write result to the output stream
			tokenOutputStream.add(new PrintToken(result, placeholder.getTokenName()));
		}
	}
	
	
	public void printBooleanTerminal(org.eclipse.emf.ecore.EObject eObject, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindBooleanTerminal booleanTerminal, int count, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> foundFormattingElements, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EAttribute attribute = booleanTerminal.getAttribute();
		String result;
		Object attributeValue = getValue(eObject, attribute, count);
		org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, booleanTerminal, attributeValue, eObject);
		String visibleTokenText = getVisibleTokenText(layoutInformation);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		} else {
			// if no text is available, the boolean attribute is converted to its textual
			// representation using the literals of the boolean terminal
			if (Boolean.TRUE.equals(attributeValue)) {
				result = booleanTerminal.getTrueLiteral();
			} else {
				result = booleanTerminal.getFalseLiteral();
			}
		}
		if (result != null && !"".equals(result)) {
			printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
			// write result to the output stream
			tokenOutputStream.add(new PrintToken(result, "'" + org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindStringUtil.escapeToANTLRKeyword(result) + "'"));
		}
	}
	
	
	public void printEnumerationTerminal(org.eclipse.emf.ecore.EObject eObject, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindEnumerationTerminal enumTerminal, int count, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> foundFormattingElements, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EAttribute attribute = enumTerminal.getAttribute();
		String result;
		Object attributeValue = getValue(eObject, attribute, count);
		org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, enumTerminal, attributeValue, eObject);
		String visibleTokenText = getVisibleTokenText(layoutInformation);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		} else {
			// if no text is available, the enumeration attribute is converted to its textual
			// representation using the literals of the enumeration terminal
			assert attributeValue instanceof org.eclipse.emf.common.util.Enumerator;
			result = enumTerminal.getText(((org.eclipse.emf.common.util.Enumerator) attributeValue).getName());
		}
		if (result != null && !"".equals(result)) {
			printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
			// write result to the output stream
			tokenOutputStream.add(new PrintToken(result, "'" + org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindStringUtil.escapeToANTLRKeyword(result) + "'"));
		}
	}
	
	
	public void printContainedObject(org.eclipse.emf.ecore.EObject eObject, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindContainment containment, int count, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> foundFormattingElements, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature reference = containment.getFeature();
		Object o = getValue(eObject, reference, count);
		// save current number of tabs to restore them after printing the contained object
		int oldTabsBeforeCurrentObject = tabsBeforeCurrentObject;
		int oldCurrentTabs = currentTabs;
		// use current number of tabs to indent contained object. we do not directly set
		// 'tabsBeforeCurrentObject' because the first element of the new object must be
		// printed with the old number of tabs.
		startedPrintingContainedObject = false;
		currentTabs = 0;
		doPrint((org.eclipse.emf.ecore.EObject) o, foundFormattingElements);
		// restore number of tabs after printing the contained object
		tabsBeforeCurrentObject = oldTabsBeforeCurrentObject;
		currentTabs = oldCurrentTabs;
	}
	
	public void printFormattingElements(java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> foundFormattingElements, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations, org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation layoutInformation) {
		String hiddenTokenText = getHiddenTokenText(layoutInformation);
		if (hiddenTokenText != null) {
			// removed used information
			if (layoutInformations != null) {
				layoutInformations.remove(layoutInformation);
			}
			tokenOutputStream.add(new PrintToken(hiddenTokenText, null));
			foundFormattingElements.clear();
			startedPrintingObject = false;
			setTabsBeforeCurrentObject(0);
			return;
		}
		int printedTabs = 0;
		if (foundFormattingElements.size() > 0) {
			for (org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement foundFormattingElement : foundFormattingElements) {
				if (foundFormattingElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindWhiteSpace) {
					int amount = ((org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindWhiteSpace) foundFormattingElement).getAmount();
					for (int i = 0; i < amount; i++) {
						tokenOutputStream.add(SPACE_TOKEN);
					}
				}
				if (foundFormattingElement instanceof org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindLineBreak) {
					currentTabs = ((org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindLineBreak) foundFormattingElement).getTabs();
					printedTabs += currentTabs;
					tokenOutputStream.add(NEW_LINE_TOKEN);
					for (int i = 0; i < tabsBeforeCurrentObject + currentTabs; i++) {
						tokenOutputStream.add(TAB_TOKEN);
					}
				}
			}
			foundFormattingElements.clear();
			startedPrintingObject = false;
		} else {
			if (startedPrintingObject) {
				// if no elements have been printed yet, we do not add the default token space,
				// because spaces before the first element are not desired.
				startedPrintingObject = false;
			} else {
				if (!handleTokenSpaceAutomatically) {
					tokenOutputStream.add(new PrintToken(getWhiteSpaceString(tokenSpace), null));
				}
			}
		}
		// after printing the first element, we can use the new number of tabs.
		setTabsBeforeCurrentObject(printedTabs);
	}
	
	private void setTabsBeforeCurrentObject(int tabs) {
		if (startedPrintingContainedObject) {
			return;
		}
		tabsBeforeCurrentObject = tabsBeforeCurrentObject + tabs;
		startedPrintingContainedObject = true;
	}
	
	private Object getValue(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, int count) {
		// get value of feature
		Object o = eObject.eGet(feature);
		if (o instanceof java.util.List<?>) {
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			o = list.get(index);
		}
		return o;
	}
	
	@SuppressWarnings("unchecked")	
	public void printReference(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EReference reference, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindPlaceholder placeholder, int count, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement> foundFormattingElements, java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations) {
		String tokenName = placeholder.getTokenName();
		Object referencedObject = getValue(eObject, reference, count);
		// first add layout before the reference
		org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, placeholder, referencedObject, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		// proxy objects must be printed differently
		String deresolvedReference = null;
		if (referencedObject instanceof org.eclipse.emf.ecore.EObject) {
			org.eclipse.emf.ecore.EObject eObjectToDeResolve = (org.eclipse.emf.ecore.EObject) referencedObject;
			if (eObjectToDeResolve.eIsProxy()) {
				deresolvedReference = ((org.eclipse.emf.ecore.InternalEObject) eObjectToDeResolve).eProxyURI().fragment();
				if (deresolvedReference != null && deresolvedReference.startsWith(org.emftext.language.aspectbind.resource.aspectbind.IAspectbindContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
					deresolvedReference = deresolvedReference.substring(org.emftext.language.aspectbind.resource.aspectbind.IAspectbindContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
					deresolvedReference = deresolvedReference.substring(deresolvedReference.indexOf("_") + 1);
				}
			}
		}
		if (deresolvedReference == null) {
			// NC-References must always be printed by deresolving the reference. We cannot
			// use the visible token information, because deresolving usually depends on
			// attribute values of the referenced object instead of the object itself.
			@SuppressWarnings("rawtypes")			
			org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolver referenceResolver = getReferenceResolverSwitch().getResolver(reference);
			referenceResolver.setOptions(getOptions());
			deresolvedReference = referenceResolver.deResolve((org.eclipse.emf.ecore.EObject) referencedObject, eObject, reference);
		}
		org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
		tokenResolver.setOptions(getOptions());
		String deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);
		// write result to output stream
		tokenOutputStream.add(new PrintToken(deresolvedToken, tokenName));
	}
	
	public java.util.Map<String, Integer> initializePrintCountingMap(org.eclipse.emf.ecore.EObject eObject) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>();
		java.util.List<org.eclipse.emf.ecore.EStructuralFeature> features = eObject.eClass().getEAllStructuralFeatures();
		for (org.eclipse.emf.ecore.EStructuralFeature feature : features) {
			int count = 0;
			Object featureValue = eObject.eGet(feature);
			if (featureValue != null) {
				if (featureValue instanceof java.util.List<?>) {
					count = ((java.util.List<?>) featureValue).size();
				} else {
					count = 1;
				}
			}
			printCountingMap.put(feature.getName(), count);
		}
		return printCountingMap;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource getResource() {
		return resource;
	}
	
	protected org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindReferenceResolverSwitch) new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindProblem(errorMessage, org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemType.PRINT_PROBLEM, org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemSeverity.WARNING), cause);
	}
	
	protected org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformationAdapter getLayoutInformationAdapter(org.eclipse.emf.ecore.EObject element) {
		for (org.eclipse.emf.common.notify.Adapter adapter : element.eAdapters()) {
			if (adapter instanceof org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformationAdapter) {
				return (org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformationAdapter) adapter;
			}
		}
		org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformationAdapter newAdapter = new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
	}
	
	private org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation getLayoutInformation(java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement syntaxElement, Object object, org.eclipse.emf.ecore.EObject container) {
		for (org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation layoutInformation : layoutInformations) {
			if (syntaxElement == layoutInformation.getSyntaxElement()) {
				if (object == null) {
					return layoutInformation;
				} else if (object == layoutInformation.getObject(container)) {
					return layoutInformation;
				}
			}
		}
		return null;
	}
	
	public java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> getCopyOfLayoutInformation(org.eclipse.emf.ecore.EObject eObject) {
		org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// create a copy of the original list of layout information object in order to be
		// able to remove used informations during printing
		java.util.List<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		return layoutInformations;
	}
	
	private String getHiddenTokenText(org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getHiddenTokenText();
		} else {
			return null;
		}
	}
	
	private String getVisibleTokenText(org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getVisibleTokenText();
		} else {
			return null;
		}
	}
	
	protected String getWhiteSpaceString(int count) {
		return getRepeatingString(count, ' ');
	}
	
	private String getRepeatingString(int count, char character) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < count; i++) {
			result.append(character);
		}
		return result.toString();
	}
	
	public void setHandleTokenSpaceAutomatically(boolean handleTokenSpaceAutomatically) {
		this.handleTokenSpaceAutomatically = handleTokenSpaceAutomatically;
	}
	
	public void setTokenSpace(int tokenSpace) {
		this.tokenSpace = tokenSpace;
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer (as it is).
	 */
	public void printBasic(java.io.PrintWriter writer) throws java.io.IOException {
		for (PrintToken nextToken : tokenOutputStream) {
			writer.write(nextToken.getText());
		}
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer.
	 * 
	 * This methods implements smart whitespace printing. It does so by writing output
	 * to a token stream instead of printing the raw token text to a PrintWriter.
	 * Tokens in this stream hold both the text and the type of the token (i.e., its
	 * name).
	 * 
	 * To decide where whitespace is needed, sequences of successive tokens are
	 * searched that can be printed without separating whitespace. To determine such
	 * groups we start with two successive non-whitespace tokens, concatenate their
	 * text and use the generated ANTLR lexer to split the text. If the resulting
	 * token sequence of the concatenated text is exactly the same as the one that is
	 * to be printed, no whitespace is needed. The tokens in the sequence are checked
	 * both regarding their type and their text. If two tokens successfully form a
	 * group a third one is added and so on.
	 */
	public void printSmart(java.io.PrintWriter writer) throws java.io.IOException {
		// stores the text of the current group of tokens. this text is given to the lexer
		// to check whether it can be correctly scanned.
		StringBuilder currentBlock = new StringBuilder();
		// stores the index of the first token of the current group.
		int currentBlockStart = 0;
		// stores the text that was already successfully checked (i.e., is can be scanned
		// correctly and can thus be printed).
		String validBlock = "";
		for (int i = 0; i < tokenOutputStream.size(); i++) {
			PrintToken tokenI = tokenOutputStream.get(i);
			currentBlock.append(tokenI.getText());
			// if declared or preserved whitespace is found - print block
			if (tokenI.getTokenName() == null) {
				writer.write(currentBlock.toString());
				// reset all values
				currentBlock = new StringBuilder();
				currentBlockStart = i + 1;
				validBlock = "";
				continue;
			}
			// now check whether the current block can be scanned
			org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextScanner scanner = new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindMetaInformation().createLexer();
			scanner.setText(currentBlock.toString());
			// retrieve all tokens from scanner and add them to list 'tempTokens'
			java.util.List<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextToken> tempTokens = new java.util.ArrayList<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextToken>();
			org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextToken nextToken = scanner.getNextToken();
			while (nextToken != null && nextToken.getText() != null) {
				tempTokens.add(nextToken);
				nextToken = scanner.getNextToken();
			}
			boolean sequenceIsValid = true;
			// check whether the current block was scanned to the same token sequence
			for (int t = 0; t < tempTokens.size(); t++) {
				PrintToken printTokenT = tokenOutputStream.get(currentBlockStart + t);
				org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextToken tempToken = tempTokens.get(t);
				if (!tempToken.getText().equals(printTokenT.getText())) {
					sequenceIsValid = false;
					break;
				}
				String commonTokenName = tempToken.getName();
				String printTokenName = printTokenT.getTokenName();
				if (printTokenName.length() > 2 && printTokenName.startsWith("'") && printTokenName.endsWith("'")) {
					printTokenName = printTokenName.substring(1, printTokenName.length() - 1);
				}
				if (!commonTokenName.equals(printTokenName)) {
					sequenceIsValid = false;
					break;
				}
			}
			if (sequenceIsValid) {
				// sequence is still valid, try adding one more token in the next iteration of the
				// loop
				validBlock += tokenI.getText();
			} else {
				// sequence is not valid, must print whitespace to separate tokens
				// print text that is valid so far
				writer.write(validBlock);
				// print separating whitespace
				writer.write(" ");
				// add current token as initial value for next iteration
				currentBlock = new StringBuilder(tokenI.getText());
				currentBlockStart = i;
				validBlock = tokenI.getText();
			}
		}
		// flush remaining valid text to writer
		writer.write(validBlock);
	}
	
}
