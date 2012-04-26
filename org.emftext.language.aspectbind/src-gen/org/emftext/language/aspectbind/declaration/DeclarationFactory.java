/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.declaration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.declaration.DeclarationPackage
 * @generated
 */
public interface DeclarationFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	DeclarationFactory eINSTANCE = org.emftext.language.aspectbind.declaration.impl.DeclarationFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Adapter Declaration</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Adapter Declaration</em>'.
   * @generated
   */
	AdapterDeclaration createAdapterDeclaration();

	/**
   * Returns a new object of class '<em>Precedence Declaration</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Precedence Declaration</em>'.
   * @generated
   */
	PrecedenceDeclaration createPrecedenceDeclaration();

	/**
   * Returns a new object of class '<em>Inter Type Declaration</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Inter Type Declaration</em>'.
   * @generated
   */
	InterTypeDeclaration createInterTypeDeclaration();

	/**
   * Returns a new object of class '<em>Adapter</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Adapter</em>'.
   * @generated
   */
	Adapter createAdapter();

	/**
   * Returns a new object of class '<em>Adaptee</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Adaptee</em>'.
   * @generated
   */
  Adaptee createAdaptee();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	DeclarationPackage getDeclarationPackage();

} //DeclarationFactory
