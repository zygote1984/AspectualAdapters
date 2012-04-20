/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.commons;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.commons.CommonsPackage
 * @generated
 */
public interface CommonsFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	CommonsFactory eINSTANCE = org.emftext.language.aspectbind.commons.impl.CommonsFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Aspect</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Aspect</em>'.
   * @generated
   */
	Aspect createAspect();

	/**
   * Returns a new object of class '<em>Per Clause</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Per Clause</em>'.
   * @generated
   */
	PerClause createPerClause();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	CommonsPackage getCommonsPackage();

} //CommonsFactory
