/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts.impl;

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

import org.emftext.language.aspectbind.pcexp.PcexpPackage;

import org.emftext.language.aspectbind.pcexp.impl.PcexpPackageImpl;

import org.emftext.language.aspectbind.pointcuts.AdviceExecutionPointcut;
import org.emftext.language.aspectbind.pointcuts.ArgsPointcut;
import org.emftext.language.aspectbind.pointcuts.AspectJPointcut;
import org.emftext.language.aspectbind.pointcuts.CFlowBelowPointcut;
import org.emftext.language.aspectbind.pointcuts.CFlowPointcut;
import org.emftext.language.aspectbind.pointcuts.CallPointcut;
import org.emftext.language.aspectbind.pointcuts.ExecutionPointcut;
import org.emftext.language.aspectbind.pointcuts.GetPointcut;
import org.emftext.language.aspectbind.pointcuts.HandlerPointcut;
import org.emftext.language.aspectbind.pointcuts.IfPointcut;
import org.emftext.language.aspectbind.pointcuts.InitPointcut;
import org.emftext.language.aspectbind.pointcuts.Pointcut;
import org.emftext.language.aspectbind.pointcuts.PointcutsFactory;
import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;
import org.emftext.language.aspectbind.pointcuts.PreInitPointcut;
import org.emftext.language.aspectbind.pointcuts.PrimitivePointcut;
import org.emftext.language.aspectbind.pointcuts.SetPointcut;
import org.emftext.language.aspectbind.pointcuts.StaticInitPointcut;
import org.emftext.language.aspectbind.pointcuts.TargetPointcut;
import org.emftext.language.aspectbind.pointcuts.ThisPointcut;
import org.emftext.language.aspectbind.pointcuts.WithinCodePointcut;
import org.emftext.language.aspectbind.pointcuts.WithinPointcut;

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
public class PointcutsPackageImpl extends EPackageImpl implements PointcutsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primitivePointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass callPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass executionPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass getPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass setPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass handlerPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass adviceExecutionPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass staticInitPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preInitPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass withinPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass withinCodePointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thisPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass targetPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass argsPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cFlowPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cFlowBelowPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aspectJPointcutEClass = null;

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
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PointcutsPackageImpl()
  {
    super(eNS_URI, PointcutsFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link PointcutsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PointcutsPackage init()
  {
    if (isInited) return (PointcutsPackage)EPackage.Registry.INSTANCE.getEPackage(PointcutsPackage.eNS_URI);

    // Obtain or create and register package
    PointcutsPackageImpl thePointcutsPackage = (PointcutsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PointcutsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PointcutsPackageImpl());

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
    CommonsPackageImpl theCommonsPackage_1 = (CommonsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.emftext.language.aspectbind.commons.CommonsPackage.eNS_URI) instanceof CommonsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.emftext.language.aspectbind.commons.CommonsPackage.eNS_URI) : org.emftext.language.aspectbind.commons.CommonsPackage.eINSTANCE);
    BindingPackageImpl theBindingPackage = (BindingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) : BindingPackage.eINSTANCE);
    DeclarationPackageImpl theDeclarationPackage = (DeclarationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) instanceof DeclarationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) : DeclarationPackage.eINSTANCE);
    PcexpPackageImpl thePcexpPackage = (PcexpPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI) instanceof PcexpPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI) : PcexpPackage.eINSTANCE);
    PatternsPackageImpl thePatternsPackage = (PatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI) instanceof PatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI) : PatternsPackage.eINSTANCE);

    // Create package meta-data objects
    thePointcutsPackage.createPackageContents();
    theCommonsPackage_1.createPackageContents();
    theBindingPackage.createPackageContents();
    theDeclarationPackage.createPackageContents();
    thePcexpPackage.createPackageContents();
    thePatternsPackage.createPackageContents();

    // Initialize created meta-data
    thePointcutsPackage.initializePackageContents();
    theCommonsPackage_1.initializePackageContents();
    theBindingPackage.initializePackageContents();
    theDeclarationPackage.initializePackageContents();
    thePcexpPackage.initializePackageContents();
    thePatternsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePointcutsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PointcutsPackage.eNS_URI, thePointcutsPackage);
    return thePointcutsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimitivePointcut()
  {
    return primitivePointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCallPointcut()
  {
    return callPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCallPointcut_Signature()
  {
    return (EReference)callPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExecutionPointcut()
  {
    return executionPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExecutionPointcut_Signature()
  {
    return (EReference)executionPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGetPointcut()
  {
    return getPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGetPointcut_Signature()
  {
    return (EReference)getPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSetPointcut()
  {
    return setPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSetPointcut_Signature()
  {
    return (EReference)setPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHandlerPointcut()
  {
    return handlerPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHandlerPointcut_TypePattern()
  {
    return (EReference)handlerPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdviceExecutionPointcut()
  {
    return adviceExecutionPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStaticInitPointcut()
  {
    return staticInitPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStaticInitPointcut_TypePattern()
  {
    return (EReference)staticInitPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitPointcut()
  {
    return initPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInitPointcut_Signature()
  {
    return (EReference)initPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreInitPointcut()
  {
    return preInitPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreInitPointcut_Signature()
  {
    return (EReference)preInitPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWithinPointcut()
  {
    return withinPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWithinPointcut_TypePattern()
  {
    return (EReference)withinPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWithinCodePointcut()
  {
    return withinCodePointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWithinCodePointcut_Signature()
  {
    return (EReference)withinCodePointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThisPointcut()
  {
    return thisPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThisPointcut_TypePattern()
  {
    return (EReference)thisPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTargetPointcut()
  {
    return targetPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTargetPointcut_TypePattern()
  {
    return (EReference)targetPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArgsPointcut()
  {
    return argsPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArgsPointcut_TypePattern()
  {
    return (EReference)argsPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCFlowPointcut()
  {
    return cFlowPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCFlowPointcut_Pointcut()
  {
    return (EReference)cFlowPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCFlowBelowPointcut()
  {
    return cFlowBelowPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCFlowBelowPointcut_Pointcut()
  {
    return (EReference)cFlowBelowPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfPointcut()
  {
    return ifPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfPointcut_Exp()
  {
    return (EReference)ifPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPointcut()
  {
    return pointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPointcut_Exp()
  {
    return (EReference)pointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPointcut_Abstract()
  {
    return (EReference)pointcutEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPointcut_Assign()
  {
    return (EReference)pointcutEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAspectJPointcut()
  {
    return aspectJPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PointcutsFactory getPointcutsFactory()
  {
    return (PointcutsFactory)getEFactoryInstance();
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
    primitivePointcutEClass = createEClass(PRIMITIVE_POINTCUT);

    callPointcutEClass = createEClass(CALL_POINTCUT);
    createEReference(callPointcutEClass, CALL_POINTCUT__SIGNATURE);

    executionPointcutEClass = createEClass(EXECUTION_POINTCUT);
    createEReference(executionPointcutEClass, EXECUTION_POINTCUT__SIGNATURE);

    getPointcutEClass = createEClass(GET_POINTCUT);
    createEReference(getPointcutEClass, GET_POINTCUT__SIGNATURE);

    setPointcutEClass = createEClass(SET_POINTCUT);
    createEReference(setPointcutEClass, SET_POINTCUT__SIGNATURE);

    handlerPointcutEClass = createEClass(HANDLER_POINTCUT);
    createEReference(handlerPointcutEClass, HANDLER_POINTCUT__TYPE_PATTERN);

    adviceExecutionPointcutEClass = createEClass(ADVICE_EXECUTION_POINTCUT);

    staticInitPointcutEClass = createEClass(STATIC_INIT_POINTCUT);
    createEReference(staticInitPointcutEClass, STATIC_INIT_POINTCUT__TYPE_PATTERN);

    initPointcutEClass = createEClass(INIT_POINTCUT);
    createEReference(initPointcutEClass, INIT_POINTCUT__SIGNATURE);

    preInitPointcutEClass = createEClass(PRE_INIT_POINTCUT);
    createEReference(preInitPointcutEClass, PRE_INIT_POINTCUT__SIGNATURE);

    withinPointcutEClass = createEClass(WITHIN_POINTCUT);
    createEReference(withinPointcutEClass, WITHIN_POINTCUT__TYPE_PATTERN);

    withinCodePointcutEClass = createEClass(WITHIN_CODE_POINTCUT);
    createEReference(withinCodePointcutEClass, WITHIN_CODE_POINTCUT__SIGNATURE);

    thisPointcutEClass = createEClass(THIS_POINTCUT);
    createEReference(thisPointcutEClass, THIS_POINTCUT__TYPE_PATTERN);

    targetPointcutEClass = createEClass(TARGET_POINTCUT);
    createEReference(targetPointcutEClass, TARGET_POINTCUT__TYPE_PATTERN);

    argsPointcutEClass = createEClass(ARGS_POINTCUT);
    createEReference(argsPointcutEClass, ARGS_POINTCUT__TYPE_PATTERN);

    cFlowPointcutEClass = createEClass(CFLOW_POINTCUT);
    createEReference(cFlowPointcutEClass, CFLOW_POINTCUT__POINTCUT);

    cFlowBelowPointcutEClass = createEClass(CFLOW_BELOW_POINTCUT);
    createEReference(cFlowBelowPointcutEClass, CFLOW_BELOW_POINTCUT__POINTCUT);

    ifPointcutEClass = createEClass(IF_POINTCUT);
    createEReference(ifPointcutEClass, IF_POINTCUT__EXP);

    pointcutEClass = createEClass(POINTCUT);
    createEReference(pointcutEClass, POINTCUT__EXP);
    createEReference(pointcutEClass, POINTCUT__ABSTRACT);
    createEReference(pointcutEClass, POINTCUT__ASSIGN);

    aspectJPointcutEClass = createEClass(ASPECT_JPOINTCUT);
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
    PcexpPackage thePcexpPackage = (PcexpPackage)EPackage.Registry.INSTANCE.getEPackage(PcexpPackage.eNS_URI);
    PatternsPackage thePatternsPackage = (PatternsPackage)EPackage.Registry.INSTANCE.getEPackage(PatternsPackage.eNS_URI);
    ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
    CommonsPackage theCommonsPackage = (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);
    ModifiersPackage theModifiersPackage = (ModifiersPackage)EPackage.Registry.INSTANCE.getEPackage(ModifiersPackage.eNS_URI);
    OperatorsPackage theOperatorsPackage = (OperatorsPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI);
    ParametersPackage theParametersPackage = (ParametersPackage)EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    primitivePointcutEClass.getESuperTypes().add(theCommonsPackage_1.getAspectMember());
    primitivePointcutEClass.getESuperTypes().add(thePcexpPackage.getPointcutExpressionType());
    callPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    executionPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    getPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    setPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    handlerPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    adviceExecutionPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    staticInitPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    initPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    preInitPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    withinPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    withinCodePointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    thisPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    targetPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    argsPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    cFlowPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    cFlowBelowPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    ifPointcutEClass.getESuperTypes().add(this.getPrimitivePointcut());
    pointcutEClass.getESuperTypes().add(theCommonsPackage_1.getAspectMember());
    pointcutEClass.getESuperTypes().add(theCommonsPackage.getNamedElement());
    pointcutEClass.getESuperTypes().add(thePcexpPackage.getPointcutExpressionType());
    aspectJPointcutEClass.getESuperTypes().add(this.getPointcut());
    aspectJPointcutEClass.getESuperTypes().add(theParametersPackage.getParametrizable());

    // Initialize classes and features; add operations and parameters
    initEClass(primitivePointcutEClass, PrimitivePointcut.class, "PrimitivePointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(callPointcutEClass, CallPointcut.class, "CallPointcut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCallPointcut_Signature(), thePatternsPackage.getAbstractMethodPattern(), null, "signature", null, 1, 1, CallPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(executionPointcutEClass, ExecutionPointcut.class, "ExecutionPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExecutionPointcut_Signature(), thePatternsPackage.getAbstractMethodPattern(), null, "signature", null, 1, 1, ExecutionPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(getPointcutEClass, GetPointcut.class, "GetPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGetPointcut_Signature(), thePatternsPackage.getAbstractMethodPattern(), null, "signature", null, 1, 1, GetPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(setPointcutEClass, SetPointcut.class, "SetPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSetPointcut_Signature(), thePatternsPackage.getAbstractMethodPattern(), null, "signature", null, 1, 1, SetPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(handlerPointcutEClass, HandlerPointcut.class, "HandlerPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHandlerPointcut_TypePattern(), thePatternsPackage.getTypePattern(), null, "typePattern", null, 1, 1, HandlerPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(adviceExecutionPointcutEClass, AdviceExecutionPointcut.class, "AdviceExecutionPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(staticInitPointcutEClass, StaticInitPointcut.class, "StaticInitPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStaticInitPointcut_TypePattern(), thePatternsPackage.getTypePattern(), null, "typePattern", null, 1, 1, StaticInitPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initPointcutEClass, InitPointcut.class, "InitPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInitPointcut_Signature(), thePatternsPackage.getAbstractMethodPattern(), null, "signature", null, 1, 1, InitPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(preInitPointcutEClass, PreInitPointcut.class, "PreInitPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPreInitPointcut_Signature(), thePatternsPackage.getAbstractMethodPattern(), null, "signature", null, 1, 1, PreInitPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(withinPointcutEClass, WithinPointcut.class, "WithinPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWithinPointcut_TypePattern(), thePatternsPackage.getTypePattern(), null, "typePattern", null, 1, 1, WithinPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(withinCodePointcutEClass, WithinCodePointcut.class, "WithinCodePointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWithinCodePointcut_Signature(), thePatternsPackage.getAbstractMethodPattern(), null, "signature", null, 1, 1, WithinCodePointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thisPointcutEClass, ThisPointcut.class, "ThisPointcut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getThisPointcut_TypePattern(), thePatternsPackage.getTypePattern(), null, "typePattern", null, 1, 1, ThisPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(targetPointcutEClass, TargetPointcut.class, "TargetPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTargetPointcut_TypePattern(), thePatternsPackage.getTypePattern(), null, "typePattern", null, 1, 1, TargetPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(argsPointcutEClass, ArgsPointcut.class, "ArgsPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArgsPointcut_TypePattern(), thePatternsPackage.getTypePattern(), null, "typePattern", null, 1, 1, ArgsPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cFlowPointcutEClass, CFlowPointcut.class, "CFlowPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCFlowPointcut_Pointcut(), this.getPointcut(), null, "pointcut", null, 1, 1, CFlowPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cFlowBelowPointcutEClass, CFlowBelowPointcut.class, "CFlowBelowPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCFlowBelowPointcut_Pointcut(), this.getPointcut(), null, "pointcut", null, 1, 1, CFlowBelowPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifPointcutEClass, IfPointcut.class, "IfPointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfPointcut_Exp(), theExpressionsPackage.getExpression(), null, "exp", null, 0, 1, IfPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pointcutEClass, Pointcut.class, "Pointcut", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPointcut_Exp(), thePcexpPackage.getPointcutExpression(), null, "exp", null, 0, 1, Pointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPointcut_Abstract(), theModifiersPackage.getAbstract(), null, "abstract", null, 0, 1, Pointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPointcut_Assign(), theOperatorsPackage.getAssignment(), null, "assign", null, 0, 1, Pointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aspectJPointcutEClass, AspectJPointcut.class, "AspectJPointcut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //PointcutsPackageImpl
