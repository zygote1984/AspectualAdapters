/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.binding.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.aspectbind.binding.BindingPackage;
import org.emftext.language.aspectbind.binding.InstancePointcut;

import org.emftext.language.aspectbind.patterns.TypePattern;

import org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.binding.impl.InstancePointcutImpl#getInstanceType <em>Instance Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstancePointcutImpl extends PointcutImpl implements InstancePointcut {
	/**
   * The cached value of the '{@link #getInstanceType() <em>Instance Type</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getInstanceType()
   * @generated
   * @ordered
   */
	protected TypePattern instanceType;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected InstancePointcutImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return BindingPackage.Literals.INSTANCE_POINTCUT;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TypePattern getInstanceType() {
    return instanceType;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetInstanceType(TypePattern newInstanceType, NotificationChain msgs) {
    TypePattern oldInstanceType = instanceType;
    instanceType = newInstanceType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BindingPackage.INSTANCE_POINTCUT__INSTANCE_TYPE, oldInstanceType, newInstanceType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setInstanceType(TypePattern newInstanceType) {
    if (newInstanceType != instanceType)
    {
      NotificationChain msgs = null;
      if (instanceType != null)
        msgs = ((InternalEObject)instanceType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BindingPackage.INSTANCE_POINTCUT__INSTANCE_TYPE, null, msgs);
      if (newInstanceType != null)
        msgs = ((InternalEObject)newInstanceType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BindingPackage.INSTANCE_POINTCUT__INSTANCE_TYPE, null, msgs);
      msgs = basicSetInstanceType(newInstanceType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.INSTANCE_POINTCUT__INSTANCE_TYPE, newInstanceType, newInstanceType));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case BindingPackage.INSTANCE_POINTCUT__INSTANCE_TYPE:
        return basicSetInstanceType(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case BindingPackage.INSTANCE_POINTCUT__INSTANCE_TYPE:
        return getInstanceType();
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
      case BindingPackage.INSTANCE_POINTCUT__INSTANCE_TYPE:
        setInstanceType((TypePattern)newValue);
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
      case BindingPackage.INSTANCE_POINTCUT__INSTANCE_TYPE:
        setInstanceType((TypePattern)null);
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
      case BindingPackage.INSTANCE_POINTCUT__INSTANCE_TYPE:
        return instanceType != null;
    }
    return super.eIsSet(featureID);
  }

} //InstancePointcutImpl
