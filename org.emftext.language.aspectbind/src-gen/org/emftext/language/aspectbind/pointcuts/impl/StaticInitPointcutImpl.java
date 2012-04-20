/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts.impl;

import org.eclipse.emf.ecore.EClass;

import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;
import org.emftext.language.aspectbind.pointcuts.StaticInitPointcut;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Init Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class StaticInitPointcutImpl extends PrimitivePointcutImpl implements StaticInitPointcut {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected StaticInitPointcutImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PointcutsPackage.Literals.STATIC_INIT_POINTCUT;
  }

} //StaticInitPointcutImpl
