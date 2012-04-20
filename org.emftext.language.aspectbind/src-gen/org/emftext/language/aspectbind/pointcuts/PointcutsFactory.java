/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage
 * @generated
 */
public interface PointcutsFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	PointcutsFactory eINSTANCE = org.emftext.language.aspectbind.pointcuts.impl.PointcutsFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Call Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Call Pointcut</em>'.
   * @generated
   */
	CallPointcut createCallPointcut();

	/**
   * Returns a new object of class '<em>Execution Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Execution Pointcut</em>'.
   * @generated
   */
	ExecutionPointcut createExecutionPointcut();

	/**
   * Returns a new object of class '<em>Get Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Get Pointcut</em>'.
   * @generated
   */
	GetPointcut createGetPointcut();

	/**
   * Returns a new object of class '<em>Within Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Within Pointcut</em>'.
   * @generated
   */
	WithinPointcut createWithinPointcut();

	/**
   * Returns a new object of class '<em>Within Code Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Within Code Pointcut</em>'.
   * @generated
   */
	WithinCodePointcut createWithinCodePointcut();

	/**
   * Returns a new object of class '<em>This Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>This Pointcut</em>'.
   * @generated
   */
	ThisPointcut createThisPointcut();

	/**
   * Returns a new object of class '<em>Target Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Target Pointcut</em>'.
   * @generated
   */
	TargetPointcut createTargetPointcut();

	/**
   * Returns a new object of class '<em>Args Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Args Pointcut</em>'.
   * @generated
   */
	ArgsPointcut createArgsPointcut();

	/**
   * Returns a new object of class '<em>CFlow Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>CFlow Pointcut</em>'.
   * @generated
   */
	CFlowPointcut createCFlowPointcut();

	/**
   * Returns a new object of class '<em>CFlow Below Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>CFlow Below Pointcut</em>'.
   * @generated
   */
	CFlowBelowPointcut createCFlowBelowPointcut();

	/**
   * Returns a new object of class '<em>If Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>If Pointcut</em>'.
   * @generated
   */
	IfPointcut createIfPointcut();

	/**
   * Returns a new object of class '<em>Aspect JPointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Aspect JPointcut</em>'.
   * @generated
   */
	AspectJPointcut createAspectJPointcut();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	PointcutsPackage getPointcutsPackage();

} //PointcutsFactory
