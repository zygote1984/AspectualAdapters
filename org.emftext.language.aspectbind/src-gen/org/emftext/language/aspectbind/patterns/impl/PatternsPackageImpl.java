/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.patterns.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.aspectbind.binding.BindingPackage;

import org.emftext.language.aspectbind.binding.impl.BindingPackageImpl;

import org.emftext.language.aspectbind.commons.impl.CommonsPackageImpl;

import org.emftext.language.aspectbind.declaration.DeclarationPackage;

import org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl;

import org.emftext.language.aspectbind.patterns.AbstractMethodPattern;
import org.emftext.language.aspectbind.patterns.ConstructorPattern;
import org.emftext.language.aspectbind.patterns.FieldPattern;
import org.emftext.language.aspectbind.patterns.MethodPattern;
import org.emftext.language.aspectbind.patterns.Pattern;
import org.emftext.language.aspectbind.patterns.PatternsFactory;
import org.emftext.language.aspectbind.patterns.PatternsPackage;
import org.emftext.language.aspectbind.patterns.TypePattern;

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
public class PatternsPackageImpl extends EPackageImpl implements PatternsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass patternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractMethodPatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fieldPatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constructorPatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodPatternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typePatternEClass = null;

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
   * @see org.emftext.language.aspectbind.patterns.PatternsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PatternsPackageImpl()
  {
    super(eNS_URI, PatternsFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link PatternsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PatternsPackage init()
  {
    if (isInited) return (PatternsPackage)EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI);

    // Obtain or create and register package
    PatternsPackageImpl thePatternsPackage = (PatternsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PatternsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PatternsPackageImpl());

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
    PcexpPackageImpl thePcexpPackage = (PcexpPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI) instanceof PcexpPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI) : PcexpPackage.eINSTANCE);

    // Create package meta-data objects
    thePatternsPackage.createPackageContents();
    thePointcutsPackage.createPackageContents();
    theCommonsPackage_1.createPackageContents();
    theBindingPackage.createPackageContents();
    theDeclarationPackage.createPackageContents();
    thePcexpPackage.createPackageContents();

    // Initialize created meta-data
    thePatternsPackage.initializePackageContents();
    thePointcutsPackage.initializePackageContents();
    theCommonsPackage_1.initializePackageContents();
    theBindingPackage.initializePackageContents();
    theDeclarationPackage.initializePackageContents();
    thePcexpPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePatternsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PatternsPackage.eNS_URI, thePatternsPackage);
    return thePatternsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPattern()
  {
    return patternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractMethodPattern()
  {
    return abstractMethodPatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFieldPattern()
  {
    return fieldPatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldPattern_Modifiers()
  {
    return (EReference)fieldPatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldPattern_DeclaringType()
  {
    return (EReference)fieldPatternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldPattern_FieldType()
  {
    return (EReference)fieldPatternEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFieldPattern_Name()
  {
    return (EAttribute)fieldPatternEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstructorPattern()
  {
    return constructorPatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstructorPattern_Modifiers()
  {
    return (EReference)constructorPatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstructorPattern_DeclaringType()
  {
    return (EReference)constructorPatternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstructorPattern_Parameters()
  {
    return (EReference)constructorPatternEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethodPattern()
  {
    return methodPatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodPattern_Modifiers()
  {
    return (EReference)methodPatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodPattern_ReturnType()
  {
    return (EReference)methodPatternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMethodPattern_Name()
  {
    return (EAttribute)methodPatternEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodPattern_DeclaringType()
  {
    return (EReference)methodPatternEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodPattern_Parameters()
  {
    return (EReference)methodPatternEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypePattern()
  {
    return typePatternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypePattern_Type()
  {
    return (EReference)typePatternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternsFactory getPatternsFactory()
  {
    return (PatternsFactory)getEFactoryInstance();
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
    patternEClass = createEClass(PATTERN);

    abstractMethodPatternEClass = createEClass(ABSTRACT_METHOD_PATTERN);

    fieldPatternEClass = createEClass(FIELD_PATTERN);
    createEReference(fieldPatternEClass, FIELD_PATTERN__MODIFIERS);
    createEReference(fieldPatternEClass, FIELD_PATTERN__DECLARING_TYPE);
    createEReference(fieldPatternEClass, FIELD_PATTERN__FIELD_TYPE);
    createEAttribute(fieldPatternEClass, FIELD_PATTERN__NAME);

    constructorPatternEClass = createEClass(CONSTRUCTOR_PATTERN);
    createEReference(constructorPatternEClass, CONSTRUCTOR_PATTERN__MODIFIERS);
    createEReference(constructorPatternEClass, CONSTRUCTOR_PATTERN__DECLARING_TYPE);
    createEReference(constructorPatternEClass, CONSTRUCTOR_PATTERN__PARAMETERS);

    methodPatternEClass = createEClass(METHOD_PATTERN);
    createEReference(methodPatternEClass, METHOD_PATTERN__MODIFIERS);
    createEReference(methodPatternEClass, METHOD_PATTERN__RETURN_TYPE);
    createEAttribute(methodPatternEClass, METHOD_PATTERN__NAME);
    createEReference(methodPatternEClass, METHOD_PATTERN__DECLARING_TYPE);
    createEReference(methodPatternEClass, METHOD_PATTERN__PARAMETERS);

    typePatternEClass = createEClass(TYPE_PATTERN);
    createEReference(typePatternEClass, TYPE_PATTERN__TYPE);
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
    CommonsPackage theCommonsPackage = (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);
    org.emftext.language.aspectbind.commons.CommonsPackage theCommonsPackage_1 = (org.emftext.language.aspectbind.commons.CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(org.emftext.language.aspectbind.commons.CommonsPackage.eNS_URI);
    ModifiersPackage theModifiersPackage = (ModifiersPackage)EPackage.Registry.INSTANCE.getEPackage(ModifiersPackage.eNS_URI);
    TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    patternEClass.getESuperTypes().add(theCommonsPackage.getCommentable());
    patternEClass.getESuperTypes().add(theCommonsPackage_1.getAspectMember());
    abstractMethodPatternEClass.getESuperTypes().add(this.getPattern());
    fieldPatternEClass.getESuperTypes().add(this.getPattern());
    constructorPatternEClass.getESuperTypes().add(this.getAbstractMethodPattern());
    methodPatternEClass.getESuperTypes().add(this.getAbstractMethodPattern());

    // Initialize classes and features; add operations and parameters
    initEClass(patternEClass, Pattern.class, "Pattern", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractMethodPatternEClass, AbstractMethodPattern.class, "AbstractMethodPattern", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(fieldPatternEClass, FieldPattern.class, "FieldPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFieldPattern_Modifiers(), theModifiersPackage.getModifier(), null, "modifiers", null, 0, -1, FieldPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFieldPattern_DeclaringType(), this.getTypePattern(), null, "declaringType", null, 1, 1, FieldPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFieldPattern_FieldType(), this.getTypePattern(), null, "fieldType", null, 1, 1, FieldPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFieldPattern_Name(), ecorePackage.getEString(), "name", null, 1, 1, FieldPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constructorPatternEClass, ConstructorPattern.class, "ConstructorPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstructorPattern_Modifiers(), theModifiersPackage.getModifier(), null, "modifiers", null, 0, -1, ConstructorPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstructorPattern_DeclaringType(), this.getTypePattern(), null, "declaringType", null, 1, 1, ConstructorPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstructorPattern_Parameters(), this.getTypePattern(), null, "parameters", null, 0, -1, ConstructorPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(methodPatternEClass, MethodPattern.class, "MethodPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMethodPattern_Modifiers(), theModifiersPackage.getModifier(), null, "modifiers", null, 0, -1, MethodPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodPattern_ReturnType(), this.getTypePattern(), null, "returnType", null, 1, 1, MethodPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMethodPattern_Name(), ecorePackage.getEString(), "name", null, 1, 1, MethodPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodPattern_DeclaringType(), this.getTypePattern(), null, "declaringType", null, 1, 1, MethodPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodPattern_Parameters(), this.getTypePattern(), null, "parameters", null, 0, -1, MethodPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typePatternEClass, TypePattern.class, "TypePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypePattern_Type(), theTypesPackage.getTypeReference(), null, "type", null, 1, 1, TypePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //PatternsPackageImpl
