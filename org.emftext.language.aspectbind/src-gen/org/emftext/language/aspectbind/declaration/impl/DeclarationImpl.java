/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.declaration.impl;

import org.eclipse.emf.ecore.EClass;

import org.emftext.language.aspectbind.commons.impl.AspectMemberImpl;

import org.emftext.language.aspectbind.declaration.Declaration;
import org.emftext.language.aspectbind.declaration.DeclarationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class DeclarationImpl extends AspectMemberImpl implements Declaration {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected DeclarationImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return DeclarationPackage.Literals.DECLARATION;
  }

} //DeclarationImpl
