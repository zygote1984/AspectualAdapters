/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.binding.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.aspectbind.binding.BindingFactory;
import org.emftext.language.aspectbind.binding.BindingPackage;
import org.emftext.language.aspectbind.binding.Instance;
import org.emftext.language.aspectbind.binding.InstancePointcut;

import org.emftext.language.aspectbind.commons.impl.CommonsPackageImpl;

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
public class BindingPackageImpl extends EPackageImpl implements BindingPackage {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass instancePointcutEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass instanceEClass = null;

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
   * @see org.emftext.language.aspectbind.binding.BindingPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private BindingPackageImpl() {
    super(eNS_URI, BindingFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link BindingPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static BindingPackage init() {
    if (isInited) return (BindingPackage)EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI);

    // Obtain or create and register package
    BindingPackageImpl theBindingPackage = (BindingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BindingPackageImpl());

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
    DeclarationPackageImpl theDeclarationPackage = (DeclarationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) instanceof DeclarationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) : DeclarationPackage.eINSTANCE);
    PcexpPackageImpl thePcexpPackage = (PcexpPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI) instanceof PcexpPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI) : PcexpPackage.eINSTANCE);
    PatternsPackageImpl thePatternsPackage = (PatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI) instanceof PatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI) : PatternsPackage.eINSTANCE);

    // Create package meta-data objects
    theBindingPackage.createPackageContents();
    thePointcutsPackage.createPackageContents();
    theCommonsPackage_1.createPackageContents();
    theDeclarationPackage.createPackageContents();
    thePcexpPackage.createPackageContents();
    thePatternsPackage.createPackageContents();

    // Initialize created meta-data
    theBindingPackage.initializePackageContents();
    thePointcutsPackage.initializePackageContents();
    theCommonsPackage_1.initializePackageContents();
    theDeclarationPackage.initializePackageContents();
    thePcexpPackage.initializePackageContents();
    thePatternsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBindingPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(BindingPackage.eNS_URI, theBindingPackage);
    return theBindingPackage;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getInstancePointcut() {
    return instancePointcutEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getInstancePointcut_InstanceType() {
    return (EReference)instancePointcutEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getInstance() {
    return instanceEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public BindingFactory getBindingFactory() {
    return (BindingFactory)getEFactoryInstance();
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
    instancePointcutEClass = createEClass(INSTANCE_POINTCUT);
    createEReference(instancePointcutEClass, INSTANCE_POINTCUT__INSTANCE_TYPE);

    instanceEClass = createEClass(INSTANCE);
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
    PointcutsPackage thePointcutsPackage = (PointcutsPackage)EPackage.Registry.INSTANCE.getEPackage(PointcutsPackage.eNS_URI);
    PatternsPackage thePatternsPackage = (PatternsPackage)EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    instancePointcutEClass.getESuperTypes().add(thePointcutsPackage.getPointcut());
    instanceEClass.getESuperTypes().add(thePatternsPackage.getTypePattern());

    // Initialize classes and features; add operations and parameters
    initEClass(instancePointcutEClass, InstancePointcut.class, "InstancePointcut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInstancePointcut_InstanceType(), thePatternsPackage.getTypePattern(), null, "instanceType", null, 1, 1, InstancePointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instanceEClass, Instance.class, "Instance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //BindingPackageImpl
