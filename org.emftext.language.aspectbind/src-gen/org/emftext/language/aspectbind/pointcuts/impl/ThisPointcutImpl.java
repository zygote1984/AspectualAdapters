/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.aspectbind.patterns.TypePattern;

import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;
import org.emftext.language.aspectbind.pointcuts.ThisPointcut;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>This Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.impl.ThisPointcutImpl#getTypePattern <em>Type Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThisPointcutImpl extends PrimitivePointcutImpl implements ThisPointcut
{
  /**
   * The cached value of the '{@link #getTypePattern() <em>Type Pattern</em>}' containment reference.
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
  protected ThisPointcutImpl()
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
    return PointcutsPackage.Literals.THIS_POINTCUT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypePattern getTypePattern()
  {
    return typePattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypePattern(TypePattern newTypePattern, NotificationChain msgs)
  {
    TypePattern oldTypePattern = typePattern;
    typePattern = newTypePattern;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PointcutsPackage.THIS_POINTCUT__TYPE_PATTERN, oldTypePattern, newTypePattern);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypePattern(TypePattern newTypePattern)
  {
    if (newTypePattern != typePattern)
    {
      NotificationChain msgs = null;
      if (typePattern != null)
        msgs = ((InternalEObject)typePattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PointcutsPackage.THIS_POINTCUT__TYPE_PATTERN, null, msgs);
      if (newTypePattern != null)
        msgs = ((InternalEObject)newTypePattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PointcutsPackage.THIS_POINTCUT__TYPE_PATTERN, null, msgs);
      msgs = basicSetTypePattern(newTypePattern, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PointcutsPackage.THIS_POINTCUT__TYPE_PATTERN, newTypePattern, newTypePattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PointcutsPackage.THIS_POINTCUT__TYPE_PATTERN:
        return basicSetTypePattern(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case PointcutsPackage.THIS_POINTCUT__TYPE_PATTERN:
        return getTypePattern();
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
      case PointcutsPackage.THIS_POINTCUT__TYPE_PATTERN:
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
      case PointcutsPackage.THIS_POINTCUT__TYPE_PATTERN:
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
      case PointcutsPackage.THIS_POINTCUT__TYPE_PATTERN:
        return typePattern != null;
    }
    return super.eIsSet(featureID);
  }

} //ThisPointcutImpl
