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

import org.emftext.language.aspectbind.pointcuts.CFlowBelowPointcut;
import org.emftext.language.aspectbind.pointcuts.Pointcut;
import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CFlow Below Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.impl.CFlowBelowPointcutImpl#getPointcut <em>Pointcut</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CFlowBelowPointcutImpl extends PrimitivePointcutImpl implements CFlowBelowPointcut {
	/**
   * The cached value of the '{@link #getPointcut() <em>Pointcut</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getPointcut()
   * @generated
   * @ordered
   */
	protected Pointcut pointcut;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected CFlowBelowPointcutImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PointcutsPackage.Literals.CFLOW_BELOW_POINTCUT;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Pointcut getPointcut() {
    if (pointcut != null && pointcut.eIsProxy())
    {
      InternalEObject oldPointcut = (InternalEObject)pointcut;
      pointcut = (Pointcut)eResolveProxy(oldPointcut);
      if (pointcut != oldPointcut)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PointcutsPackage.CFLOW_BELOW_POINTCUT__POINTCUT, oldPointcut, pointcut));
      }
    }
    return pointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Pointcut basicGetPointcut() {
    return pointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setPointcut(Pointcut newPointcut) {
    Pointcut oldPointcut = pointcut;
    pointcut = newPointcut;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PointcutsPackage.CFLOW_BELOW_POINTCUT__POINTCUT, oldPointcut, pointcut));
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
      case PointcutsPackage.CFLOW_BELOW_POINTCUT__POINTCUT:
        if (resolve) return getPointcut();
        return basicGetPointcut();
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
      case PointcutsPackage.CFLOW_BELOW_POINTCUT__POINTCUT:
        setPointcut((Pointcut)newValue);
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
      case PointcutsPackage.CFLOW_BELOW_POINTCUT__POINTCUT:
        setPointcut((Pointcut)null);
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
      case PointcutsPackage.CFLOW_BELOW_POINTCUT__POINTCUT:
        return pointcut != null;
    }
    return super.eIsSet(featureID);
  }

} //CFlowBelowPointcutImpl
