/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pcexp;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.pcexp.PcexpPackage
 * @generated
 */
public interface PcexpFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	PcexpFactory eINSTANCE = org.emftext.language.aspectbind.pcexp.impl.PcexpFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Pointcut Expression</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Pointcut Expression</em>'.
   * @generated
   */
	PointcutExpression createPointcutExpression();

	/**
   * Returns a new object of class '<em>Pointcut Or Expression</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Pointcut Or Expression</em>'.
   * @generated
   */
	PointcutOrExpression createPointcutOrExpression();

	/**
   * Returns a new object of class '<em>Pointcut And Expression</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Pointcut And Expression</em>'.
   * @generated
   */
	PointcutAndExpression createPointcutAndExpression();

	/**
   * Returns a new object of class '<em>Pc Assignment Operator</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Pc Assignment Operator</em>'.
   * @generated
   */
	PcAssignmentOperator createPcAssignmentOperator();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	PcexpPackage getPcexpPackage();

} //PcexpFactory
