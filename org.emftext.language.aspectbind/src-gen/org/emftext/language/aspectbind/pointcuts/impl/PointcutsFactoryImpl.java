/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.aspectbind.pointcuts.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PointcutsFactoryImpl extends EFactoryImpl implements PointcutsFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static PointcutsFactory init() {
    try
    {
      PointcutsFactory thePointcutsFactory = (PointcutsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/bindingAspect/pointcuts"); 
      if (thePointcutsFactory != null)
      {
        return thePointcutsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PointcutsFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PointcutsFactoryImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public EObject create(EClass eClass) {
    switch (eClass.getClassifierID())
    {
      case PointcutsPackage.CALL_POINTCUT: return createCallPointcut();
      case PointcutsPackage.EXECUTION_POINTCUT: return createExecutionPointcut();
      case PointcutsPackage.GET_POINTCUT: return createGetPointcut();
      case PointcutsPackage.WITHIN_POINTCUT: return createWithinPointcut();
      case PointcutsPackage.WITHIN_CODE_POINTCUT: return createWithinCodePointcut();
      case PointcutsPackage.THIS_POINTCUT: return createThisPointcut();
      case PointcutsPackage.TARGET_POINTCUT: return createTargetPointcut();
      case PointcutsPackage.ARGS_POINTCUT: return createArgsPointcut();
      case PointcutsPackage.CFLOW_POINTCUT: return createCFlowPointcut();
      case PointcutsPackage.CFLOW_BELOW_POINTCUT: return createCFlowBelowPointcut();
      case PointcutsPackage.IF_POINTCUT: return createIfPointcut();
      case PointcutsPackage.ASPECT_JPOINTCUT: return createAspectJPointcut();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CallPointcut createCallPointcut() {
    CallPointcutImpl callPointcut = new CallPointcutImpl();
    return callPointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ExecutionPointcut createExecutionPointcut() {
    ExecutionPointcutImpl executionPointcut = new ExecutionPointcutImpl();
    return executionPointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public GetPointcut createGetPointcut() {
    GetPointcutImpl getPointcut = new GetPointcutImpl();
    return getPointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public WithinPointcut createWithinPointcut() {
    WithinPointcutImpl withinPointcut = new WithinPointcutImpl();
    return withinPointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public WithinCodePointcut createWithinCodePointcut() {
    WithinCodePointcutImpl withinCodePointcut = new WithinCodePointcutImpl();
    return withinCodePointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ThisPointcut createThisPointcut() {
    ThisPointcutImpl thisPointcut = new ThisPointcutImpl();
    return thisPointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TargetPointcut createTargetPointcut() {
    TargetPointcutImpl targetPointcut = new TargetPointcutImpl();
    return targetPointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ArgsPointcut createArgsPointcut() {
    ArgsPointcutImpl argsPointcut = new ArgsPointcutImpl();
    return argsPointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CFlowPointcut createCFlowPointcut() {
    CFlowPointcutImpl cFlowPointcut = new CFlowPointcutImpl();
    return cFlowPointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CFlowBelowPointcut createCFlowBelowPointcut() {
    CFlowBelowPointcutImpl cFlowBelowPointcut = new CFlowBelowPointcutImpl();
    return cFlowBelowPointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IfPointcut createIfPointcut() {
    IfPointcutImpl ifPointcut = new IfPointcutImpl();
    return ifPointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AspectJPointcut createAspectJPointcut() {
    AspectJPointcutImpl aspectJPointcut = new AspectJPointcutImpl();
    return aspectJPointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PointcutsPackage getPointcutsPackage() {
    return (PointcutsPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static PointcutsPackage getPackage() {
    return PointcutsPackage.eINSTANCE;
  }

} //PointcutsFactoryImpl
