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

import org.emftext.language.aspectbind.patterns.TypePattern;

import org.emftext.language.aspectbind.pointcuts.HandlerPointcut;
import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Handler Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.impl.HandlerPointcutImpl#getTypePattern <em>Type Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class HandlerPointcutImpl extends PrimitivePointcutImpl implements HandlerPointcut
{
  /**
   * The cached value of the '{@link #getTypePattern() <em>Type Pattern</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypePattern()
   * @generated
   * @ordered
   */
  protected TypePattern typePattern;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HandlerPointcutImpl()
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
    return PointcutsPackage.Literals.HANDLER_POINTCUT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypePattern getTypePattern()
  {
    if (typePattern != null && typePattern.eIsProxy())
    {
      InternalEObject oldTypePattern = (InternalEObject)typePattern;
      typePattern = (TypePattern)eResolveProxy(oldTypePattern);
      if (typePattern != oldTypePattern)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PointcutsPackage.HANDLER_POINTCUT__TYPE_PATTERN, oldTypePattern, typePattern));
      }
    }
    return typePattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypePattern basicGetTypePattern()
  {
    return typePattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypePattern(TypePattern newTypePattern)
  {
    TypePattern oldTypePattern = typePattern;
    typePattern = newTypePattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PointcutsPackage.HANDLER_POINTCUT__TYPE_PATTERN, oldTypePattern, typePattern));
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
      case PointcutsPackage.HANDLER_POINTCUT__TYPE_PATTERN:
        if (resolve) return getTypePattern();
        return basicGetTypePattern();
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
      case PointcutsPackage.HANDLER_POINTCUT__TYPE_PATTERN:
        setTypePattern((TypePattern)newValue);
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
      case PointcutsPackage.HANDLER_POINTCUT__TYPE_PATTERN:
        setTypePattern((TypePattern)null);
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
      case PointcutsPackage.HANDLER_POINTCUT__TYPE_PATTERN:
        return typePattern != null;
    }
    return super.eIsSet(featureID);
  }

} //HandlerPointcutImpl
