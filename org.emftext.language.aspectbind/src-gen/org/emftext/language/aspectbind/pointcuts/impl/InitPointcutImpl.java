/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts.impl;

import org.eclipse.emf.ecore.EClass;

import org.emftext.language.aspectbind.pointcuts.InitPointcut;
import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Init Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class InitPointcutImpl extends PrimitivePointcutImpl implements InitPointcut {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected InitPointcutImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PointcutsPackage.Literals.INIT_POINTCUT;
  }

} //InitPointcutImpl
