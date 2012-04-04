/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pcexp.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.aspectbind.binding.BindingPackage;

import org.emftext.language.aspectbind.binding.impl.BindingPackageImpl;

import org.emftext.language.aspectbind.commons.impl.CommonsPackageImpl;

import org.emftext.language.aspectbind.declaration.DeclarationPackage;

import org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl;

import org.emftext.language.aspectbind.patterns.PatternsPackage;

import org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl;

import org.emftext.language.aspectbind.pcexp.PcexpFactory;
import org.emftext.language.aspectbind.pcexp.PcexpPackage;
import org.emftext.language.aspectbind.pcexp.PointcutExpression;
import org.emftext.language.aspectbind.pcexp.PointcutExpressionType;

import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;

import org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl;

import org.emftext.language.java.annotations.AnnotationsPackage;

import org.emftext.language.java.arrays.ArraysPackage;

import org.emftext.language.java.classifiers.ClassifiersPackage;

import org.emftext.language.java.commons.CommonsPackage;

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
public class PcexpPackageImpl extends EPackageImpl implements PcexpPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pointcutExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pointcutExpressionTypeEClass = null;

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
   * @see org.emftext.language.aspectbind.pcexp.PcexpPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PcexpPackageImpl()
  {
    super(eNS_URI, PcexpFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link PcexpPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PcexpPackage init()
  {
    if (isInited) return (PcexpPackage)EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI);

    // Obtain or create and register package
    PcexpPackageImpl thePcexpPackage = (PcexpPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PcexpPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PcexpPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    AnnotationsPackage.eINSTANCE.eClass();
    ArraysPackage.eINSTANCE.eClass();
    ClassifiersPackage.eINSTANCE.eClass();
    CommonsPackage.eINSTANCE.eClass();
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
    CommonsPackageImpl theCommonsPackage_1 = (CommonsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.emftext.language.aspectbind.commons.CommonsPackage.eNS_URI) instanceof CommonsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.emftext.language.aspectbind.commons.CommonsPackage.eNS_URI) : org.emftext.language.aspectbind.commons.CommonsPackage.eINSTANCE);
    BindingPackageImpl theBindingPackage = (BindingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) : BindingPackage.eINSTANCE);
    DeclarationPackageImpl theDeclarationPackage = (DeclarationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) instanceof DeclarationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) : DeclarationPackage.eINSTANCE);
    PatternsPackageImpl thePatternsPackage = (PatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI) instanceof PatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI) : PatternsPackage.eINSTANCE);

    // Create package meta-data objects
    thePcexpPackage.createPackageContents();
    thePointcutsPackage.createPackageContents();
    theCommonsPackage_1.createPackageContents();
    theBindingPackage.createPackageContents();
    theDeclarationPackage.createPackageContents();
    thePatternsPackage.createPackageContents();

    // Initialize created meta-data
    thePcexpPackage.initializePackageContents();
    thePointcutsPackage.initializePackageContents();
    theCommonsPackage_1.initializePackageContents();
    theBindingPackage.initializePackageContents();
    theDeclarationPackage.initializePackageContents();
    thePatternsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePcexpPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PcexpPackage.eNS_URI, thePcexpPackage);
    return thePcexpPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPointcutExpression()
  {
    return pointcutExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPointcutExpression_Children()
  {
    return (EReference)pointcutExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPointcutExpressionType()
  {
    return pointcutExpressionTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PcexpFactory getPcexpFactory()
  {
    return (PcexpFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    pointcutExpressionEClass = createEClass(POINTCUT_EXPRESSION);
    createEReference(pointcutExpressionEClass, POINTCUT_EXPRESSION__CHILDREN);

    pointcutExpressionTypeEClass = createEClass(POINTCUT_EXPRESSION_TYPE);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    org.emftext.language.aspectbind.commons.CommonsPackage theCommonsPackage_1 = (org.emftext.language.aspectbind.commons.CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(org.emftext.language.aspectbind.commons.CommonsPackage.eNS_URI);
    ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    pointcutExpressionEClass.getESuperTypes().add(theCommonsPackage_1.getAspectMember());
    pointcutExpressionEClass.getESuperTypes().add(theExpressionsPackage.getConditionalExpression());
    pointcutExpressionTypeEClass.getESuperTypes().add(theExpressionsPackage.getConditionalExpressionChild());

    // Initialize classes and features; add operations and parameters
    initEClass(pointcutExpressionEClass, PointcutExpression.class, "PointcutExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPointcutExpression_Children(), this.getPointcutExpressionType(), null, "children", null, 1, -1, PointcutExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pointcutExpressionTypeEClass, PointcutExpressionType.class, "PointcutExpressionType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //PcexpPackageImpl
