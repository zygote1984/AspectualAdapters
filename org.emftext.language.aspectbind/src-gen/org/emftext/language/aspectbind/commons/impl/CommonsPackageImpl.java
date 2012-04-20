/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.commons.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.aspectbind.binding.BindingPackage;

import org.emftext.language.aspectbind.binding.impl.BindingPackageImpl;

import org.emftext.language.aspectbind.commons.Aspect;
import org.emftext.language.aspectbind.commons.AspectMember;
import org.emftext.language.aspectbind.commons.CommonsFactory;
import org.emftext.language.aspectbind.commons.CommonsPackage;
import org.emftext.language.aspectbind.commons.PerClause;

import org.emftext.language.aspectbind.declaration.DeclarationPackage;

import org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl;

import org.emftext.language.aspectbind.patterns.PatternsPackage;

import org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl;

import org.emftext.language.aspectbind.pcexp.PcexpPackage;

import org.emftext.language.aspectbind.pcexp.impl.PcexpPackageImpl;

import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;

import org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl;

import org.emftext.language.java.annotations.AnnotationsPackage;

import org.emftext.language.java.arrays.ArraysPackage;

import org.emftext.language.java.classifiers.ClassifiersPackage;

import org.emftext.language.java.containers.ContainersPackage;

import org.emftext.language.java.expressions.ExpressionsPackage;

import org.emftext.language.java.generics.GenericsPackage;

import org.emftext.language.java.imports.ImportsPackage;

import org.emftext.language.java.instantiations.InstantiationsPackage;

import org.emftext.language.java.literals.LiteralsPackage;

import org.emftext.language.java.members.MembersPackage;

import org.emftext.language.java.modifiers.ModifiersPackage;

import org.emftext.language.java.operators.OperatorsPackage;

import org.emftext.language.java.parameters.ParametersPackage;

import org.emftext.language.java.references.ReferencesPackage;

import org.emftext.language.java.statements.StatementsPackage;

import org.emftext.language.java.types.TypesPackage;

import org.emftext.language.java.variables.VariablesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonsPackageImpl extends EPackageImpl implements CommonsPackage {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass aspectMemberEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass aspectEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass perClauseEClass = null;

	/**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.emftext.language.aspectbind.commons.CommonsPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private CommonsPackageImpl() {
    super(eNS_URI, CommonsFactory.eINSTANCE);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static boolean isInited = false;

	/**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link CommonsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static CommonsPackage init() {
    if (isInited) return (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);

    // Obtain or create and register package
    CommonsPackageImpl theCommonsPackage = (CommonsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CommonsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CommonsPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    AnnotationsPackage.eINSTANCE.eClass();
    ArraysPackage.eINSTANCE.eClass();
    ClassifiersPackage.eINSTANCE.eClass();
    org.emftext.language.java.commons.CommonsPackage.eINSTANCE.eClass();
    ContainersPackage.eINSTANCE.eClass();
    ExpressionsPackage.eINSTANCE.eClass();
    GenericsPackage.eINSTANCE.eClass();
    ImportsPackage.eINSTANCE.eClass();
    InstantiationsPackage.eINSTANCE.eClass();
    LiteralsPackage.eINSTANCE.eClass();
    MembersPackage.eINSTANCE.eClass();
    ModifiersPackage.eINSTANCE.eClass();
    OperatorsPackage.eINSTANCE.eClass();
    ParametersPackage.eINSTANCE.eClass();
    ReferencesPackage.eINSTANCE.eClass();
    StatementsPackage.eINSTANCE.eClass();
    TypesPackage.eINSTANCE.eClass();
    VariablesPackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    PointcutsPackageImpl thePointcutsPackage = (PointcutsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PointcutsPackage.eNS_URI) instanceof PointcutsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PointcutsPackage.eNS_URI) : PointcutsPackage.eINSTANCE);
    BindingPackageImpl theBindingPackage = (BindingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) : BindingPackage.eINSTANCE);
    DeclarationPackageImpl theDeclarationPackage = (DeclarationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) instanceof DeclarationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) : DeclarationPackage.eINSTANCE);
    PcexpPackageImpl thePcexpPackage = (PcexpPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI) instanceof PcexpPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI) : PcexpPackage.eINSTANCE);
    PatternsPackageImpl thePatternsPackage = (PatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI) instanceof PatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI) : PatternsPackage.eINSTANCE);

    // Create package meta-data objects
    theCommonsPackage.createPackageContents();
    thePointcutsPackage.createPackageContents();
    theBindingPackage.createPackageContents();
    theDeclarationPackage.createPackageContents();
    thePcexpPackage.createPackageContents();
    thePatternsPackage.createPackageContents();

    // Initialize created meta-data
    theCommonsPackage.initializePackageContents();
    thePointcutsPackage.initializePackageContents();
    theBindingPackage.initializePackageContents();
    theDeclarationPackage.initializePackageContents();
    thePcexpPackage.initializePackageContents();
    thePatternsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCommonsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(CommonsPackage.eNS_URI, theCommonsPackage);
    return theCommonsPackage;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAspectMember() {
    return aspectMemberEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAspect() {
    return aspectEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAspect_Members() {
    return (EReference)aspectEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAspect_Package() {
    return (EReference)aspectEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getAspect_Priviliged() {
    return (EAttribute)aspectEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAspect_Modifier() {
    return (EReference)aspectEClass.getEStructuralFeatures().get(3);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAspect_Extend() {
    return (EReference)aspectEClass.getEStructuralFeatures().get(4);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAspect_Implement() {
    return (EReference)aspectEClass.getEStructuralFeatures().get(5);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getAspect_Perclause() {
    return (EReference)aspectEClass.getEStructuralFeatures().get(6);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getPerClause() {
    return perClauseEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getPerClause_Clause() {
    return (EAttribute)perClauseEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getPerClause_Pointcut() {
    return (EReference)perClauseEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CommonsFactory getCommonsFactory() {
    return (CommonsFactory)getEFactoryInstance();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isCreated = false;

	/**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    aspectMemberEClass = createEClass(ASPECT_MEMBER);

    aspectEClass = createEClass(ASPECT);
    createEReference(aspectEClass, ASPECT__MEMBERS);
    createEReference(aspectEClass, ASPECT__PACKAGE);
    createEAttribute(aspectEClass, ASPECT__PRIVILIGED);
    createEReference(aspectEClass, ASPECT__MODIFIER);
    createEReference(aspectEClass, ASPECT__EXTEND);
    createEReference(aspectEClass, ASPECT__IMPLEMENT);
    createEReference(aspectEClass, ASPECT__PERCLAUSE);

    perClauseEClass = createEClass(PER_CLAUSE);
    createEAttribute(perClauseEClass, PER_CLAUSE__CLAUSE);
    createEReference(perClauseEClass, PER_CLAUSE__POINTCUT);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isInitialized = false;

	/**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    org.emftext.language.java.commons.CommonsPackage theCommonsPackage_1 = (org.emftext.language.java.commons.CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(org.emftext.language.java.commons.CommonsPackage.eNS_URI);
    ContainersPackage theContainersPackage = (ContainersPackage)EPackage.Registry.INSTANCE.getEPackage(ContainersPackage.eNS_URI);
    ModifiersPackage theModifiersPackage = (ModifiersPackage)EPackage.Registry.INSTANCE.getEPackage(ModifiersPackage.eNS_URI);
    GenericsPackage theGenericsPackage = (GenericsPackage)EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI);
    PointcutsPackage thePointcutsPackage = (PointcutsPackage)EPackage.Registry.INSTANCE.getEPackage(PointcutsPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    aspectMemberEClass.getESuperTypes().add(theCommonsPackage_1.getNamespaceAwareElement());
    aspectEClass.getESuperTypes().add(theContainersPackage.getCompilationUnit());
    perClauseEClass.getESuperTypes().add(theCommonsPackage_1.getCommentable());

    // Initialize classes and features; add operations and parameters
    initEClass(aspectMemberEClass, AspectMember.class, "AspectMember", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(aspectEClass, Aspect.class, "Aspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAspect_Members(), this.getAspectMember(), null, "members", null, 0, -1, Aspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAspect_Package(), theContainersPackage.getPackage(), null, "package", null, 0, 1, Aspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAspect_Priviliged(), ecorePackage.getEBoolean(), "priviliged", "false", 0, 1, Aspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAspect_Modifier(), theModifiersPackage.getModifier(), null, "modifier", null, 0, -1, Aspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAspect_Extend(), theGenericsPackage.getExtendsTypeArgument(), null, "extend", null, 0, 1, Aspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAspect_Implement(), theGenericsPackage.getExtendsTypeArgument(), null, "implement", null, 0, -1, Aspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAspect_Perclause(), this.getPerClause(), null, "perclause", null, 0, 1, Aspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(perClauseEClass, PerClause.class, "PerClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPerClause_Clause(), ecorePackage.getEString(), "clause", null, 1, 1, PerClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPerClause_Pointcut(), thePointcutsPackage.getPointcut(), null, "pointcut", null, 0, 1, PerClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //CommonsPackageImpl
