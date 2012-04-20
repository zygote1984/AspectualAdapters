/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.aspectbind.pointcuts.IfPointcut;
import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;

import org.emftext.language.java.expressions.ConditionalExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.impl.IfPointcutImpl#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfPointcutImpl extends PrimitivePointcutImpl implements IfPointcut {
	/**
   * The cached value of the '{@link #getExp() <em>Exp</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getExp()
   * @generated
   * @ordered
   */
	protected ConditionalExpression exp;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected IfPointcutImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PointcutsPackage.Literals.IF_POINTCUT;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ConditionalExpression getExp() {
    if (exp != null && exp.eIsProxy())
    {
      InternalEObject oldExp = (InternalEObject)exp;
      exp = (ConditionalExpression)eResolveProxy(oldExp);
      if (exp != oldExp)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PointcutsPackage.IF_POINTCUT__EXP, oldExp, exp));
      }
    }
    return exp;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ConditionalExpression basicGetExp() {
    return exp;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setExp(ConditionalExpression newExp) {
    ConditionalExpression oldExp = exp;
    exp = newExp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PointcutsPackage.IF_POINTCUT__EXP, oldExp, exp));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case PointcutsPackage.IF_POINTCUT__EXP:
        if (resolve) return getExp();
        return basicGetExp();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case PointcutsPackage.IF_POINTCUT__EXP:
        setExp((ConditionalExpression)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case PointcutsPackage.IF_POINTCUT__EXP:
        setExp((ConditionalExpression)null);
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case PointcutsPackage.IF_POINTCUT__EXP:
        return exp != null;
    }
    return super.eIsSet(featureID);
  }

} //IfPointcutImpl
