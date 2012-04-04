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
public interface PointcutsFactory extends EFactory
{
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
   * Returns a new object of class '<em>This Pointcut</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>This Pointcut</em>'.
   * @generated
   */
  ThisPointcut createThisPointcut();

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
