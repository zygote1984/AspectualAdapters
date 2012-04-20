/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.binding;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.binding.BindingPackage
 * @generated
 */
public interface BindingFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	BindingFactory eINSTANCE = org.emftext.language.aspectbind.binding.impl.BindingFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Instance Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Pointcut</em>'.
   * @generated
   */
	InstancePointcut createInstancePointcut();

	/**
   * Returns a new object of class '<em>Instance</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance</em>'.
   * @generated
   */
	Instance createInstance();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	BindingPackage getBindingPackage();

} //BindingFactory
