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

import org.emftext.language.aspectbind.patterns.AbstractMethodPattern;

import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;
import org.emftext.language.aspectbind.pointcuts.WithinCodePointcut;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Within Code Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.impl.WithinCodePointcutImpl#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class WithinCodePointcutImpl extends PrimitivePointcutImpl implements WithinCodePointcut
{
  /**
   * The cached value of the '{@link #getSignature() <em>Signature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignature()
   * @generated
   * @ordered
   */
  protected AbstractMethodPattern signature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WithinCodePointcutImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return PointcutsPackage.Literals.WITHIN_CODE_POINTCUT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractMethodPattern getSignature()
  {
    if (signature != null && signature.eIsProxy())
    {
      InternalEObject oldSignature = (InternalEObject)signature;
      signature = (AbstractMethodPattern)eResolveProxy(oldSignature);
      if (signature != oldSignature)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PointcutsPackage.WITHIN_CODE_POINTCUT__SIGNATURE, oldSignature, signature));
      }
    }
    return signature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractMethodPattern basicGetSignature()
  {
    return signature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignature(AbstractMethodPattern newSignature)
  {
    AbstractMethodPattern oldSignature = signature;
    signature = newSignature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PointcutsPackage.WITHIN_CODE_POINTCUT__SIGNATURE, oldSignature, signature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PointcutsPackage.WITHIN_CODE_POINTCUT__SIGNATURE:
        if (resolve) return getSignature();
        return basicGetSignature();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PointcutsPackage.WITHIN_CODE_POINTCUT__SIGNATURE:
        setSignature((AbstractMethodPattern)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PointcutsPackage.WITHIN_CODE_POINTCUT__SIGNATURE:
        setSignature((AbstractMethodPattern)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PointcutsPackage.WITHIN_CODE_POINTCUT__SIGNATURE:
        return signature != null;
    }
    return super.eIsSet(featureID);
  }

} //WithinCodePointcutImpl
