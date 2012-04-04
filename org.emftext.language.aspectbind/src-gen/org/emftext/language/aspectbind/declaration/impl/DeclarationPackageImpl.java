/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.declaration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.aspectbind.binding.BindingPackage;

import org.emftext.language.aspectbind.binding.impl.BindingPackageImpl;

import org.emftext.language.aspectbind.commons.impl.CommonsPackageImpl;

import org.emftext.language.aspectbind.declaration.Adapter;
import org.emftext.language.aspectbind.declaration.AdapterDeclaration;
import org.emftext.language.aspectbind.declaration.Declaration;
import org.emftext.language.aspectbind.declaration.DeclarationFactory;
import org.emftext.language.aspectbind.declaration.DeclarationPackage;
import org.emftext.language.aspectbind.declaration.InterTypeDeclaration;
import org.emftext.language.aspectbind.declaration.PrecedenceDeclaration;

import org.emftext.language.aspectbind.patterns.PatternsPackage;

import org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl;

import org.emftext.language.aspectbind.pcexp.PcexpPackage;

import org.emftext.language.aspectbind.pcexp.impl.PcexpPackageImpl;

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
public class DeclarationPackageImpl extends EPackageImpl implements DeclarationPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass adapterDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass precedenceDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interTypeDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass declarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass adapterEClass = null;

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
   * @see org.emftext.language.aspectbind.declaration.DeclarationPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DeclarationPackageImpl()
  {
    super(eNS_URI, DeclarationFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link DeclarationPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DeclarationPackage init()
  {
    if (isInited) return (DeclarationPackage)EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI);

    // Obtain or create and register package
    DeclarationPackageImpl theDeclarationPackage = (DeclarationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DeclarationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DeclarationPackageImpl());

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
    PcexpPackageImpl thePcexpPackage = (PcexpPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI) instanceof PcexpPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI) : PcexpPackage.eINSTANCE);
    PatternsPackageImpl thePatternsPackage = (PatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI) instanceof PatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI) : PatternsPackage.eINSTANCE);

    // Create package meta-data objects
    theDeclarationPackage.createPackageContents();
    thePointcutsPackage.createPackageContents();
    theCommonsPackage_1.createPackageContents();
    theBindingPackage.createPackageContents();
    thePcexpPackage.createPackageContents();
    thePatternsPackage.createPackageContents();

    // Initialize created meta-data
    theDeclarationPackage.initializePackageContents();
    thePointcutsPackage.initializePackageContents();
    theCommonsPackage_1.initializePackageContents();
    theBindingPackage.initializePackageContents();
    thePcexpPackage.initializePackageContents();
    thePatternsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDeclarationPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DeclarationPackage.eNS_URI, theDeclarationPackage);
    return theDeclarationPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdapterDeclaration()
  {
    return adapterDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdapterDeclaration_Adapter()
  {
    return (EReference)adapterDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdapterDeclaration_Adaptee()
  {
    return (EReference)adapterDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdapterDeclaration_Members()
  {
    return (EReference)adapterDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrecedenceDeclaration()
  {
    return precedenceDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterTypeDeclaration()
  {
    return interTypeDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeclaration()
  {
    return declarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdapter()
  {
    return adapterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdapter_References()
  {
    return (EReference)adapterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclarationFactory getDeclarationFactory()
  {
    return (DeclarationFactory)getEFactoryInstance();
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
    adapterDeclarationEClass = createEClass(ADAPTER_DECLARATION);
    createEReference(adapterDeclarationEClass, ADAPTER_DECLARATION__ADAPTER);
    createEReference(adapterDeclarationEClass, ADAPTER_DECLARATION__ADAPTEE);
    createEReference(adapterDeclarationEClass, ADAPTER_DECLARATION__MEMBERS);

    precedenceDeclarationEClass = createEClass(PRECEDENCE_DECLARATION);

    interTypeDeclarationEClass = createEClass(INTER_TYPE_DECLARATION);

    declarationEClass = createEClass(DECLARATION);

    adapterEClass = createEClass(ADAPTER);
    createEReference(adapterEClass, ADAPTER__REFERENCES);
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
    BindingPackage theBindingPackage = (BindingPackage)EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI);
    MembersPackage theMembersPackage = (MembersPackage)EPackage.Registry.INSTANCE.getEPackage(MembersPackage.eNS_URI);
    org.emftext.language.aspectbind.commons.CommonsPackage theCommonsPackage_1 = (org.emftext.language.aspectbind.commons.CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(org.emftext.language.aspectbind.commons.CommonsPackage.eNS_URI);
    CommonsPackage theCommonsPackage = (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);
    ReferencesPackage theReferencesPackage = (ReferencesPackage)EPackage.Registry.INSTANCE.getEPackage(ReferencesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    adapterDeclarationEClass.getESuperTypes().add(this.getDeclaration());
    precedenceDeclarationEClass.getESuperTypes().add(this.getDeclaration());
    interTypeDeclarationEClass.getESuperTypes().add(this.getDeclaration());
    declarationEClass.getESuperTypes().add(theCommonsPackage_1.getAspectMember());
    adapterEClass.getESuperTypes().add(theCommonsPackage.getNamedElement());

    // Initialize classes and features; add operations and parameters
    initEClass(adapterDeclarationEClass, AdapterDeclaration.class, "AdapterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdapterDeclaration_Adapter(), this.getAdapter(), null, "adapter", null, 1, 1, AdapterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAdapterDeclaration_Adaptee(), theBindingPackage.getInstancePointcut(), null, "adaptee", null, 1, 1, AdapterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAdapterDeclaration_Members(), theMembersPackage.getMember(), null, "members", null, 0, -1, AdapterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(precedenceDeclarationEClass, PrecedenceDeclaration.class, "PrecedenceDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(interTypeDeclarationEClass, InterTypeDeclaration.class, "InterTypeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(declarationEClass, Declaration.class, "Declaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(adapterEClass, Adapter.class, "Adapter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdapter_References(), theReferencesPackage.getReference(), null, "references", null, 1, -1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //DeclarationPackageImpl
