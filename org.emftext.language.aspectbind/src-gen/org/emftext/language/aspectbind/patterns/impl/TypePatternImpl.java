/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.patterns.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.aspectbind.patterns.PatternsPackage;
import org.emftext.language.aspectbind.patterns.TypePattern;

import org.emftext.language.java.operators.Addition;
import org.emftext.language.aspectbind.wildcard.SubtypeWC;
import org.emftext.language.java.types.TypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.TypePatternImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.TypePatternImpl#getSubtypes <em>Subtypes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypePatternImpl extends TypeOrIdPatternImpl implements TypePattern {
	/**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
	protected TypeReference type;

	/**
   * The cached value of the '{@link #getSubtypes() <em>Subtypes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubtypes()
   * @generated
   * @ordered
   */
  protected Addition subtypes;

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected TypePatternImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PatternsPackage.Literals.TYPE_PATTERN;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TypeReference getType() {
    return type;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetType(TypeReference newType, NotificationChain msgs) {
    TypeReference oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternsPackage.TYPE_PATTERN__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setType(TypeReference newType) {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.TYPE_PATTERN__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.TYPE_PATTERN__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternsPackage.TYPE_PATTERN__TYPE, newType, newType));
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Addition getSubtypes()
  {
    return subtypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubtypes(Addition newSubtypes, NotificationChain msgs)
  {
    Addition oldSubtypes = subtypes;
    subtypes = newSubtypes;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternsPackage.TYPE_PATTERN__SUBTYPES, oldSubtypes, newSubtypes);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubtypes(Addition newSubtypes)
  {
    if (newSubtypes != subtypes)
    {
      NotificationChain msgs = null;
      if (subtypes != null)
        msgs = ((InternalEObject)subtypes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.TYPE_PATTERN__SUBTYPES, null, msgs);
      if (newSubtypes != null)
        msgs = ((InternalEObject)newSubtypes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.TYPE_PATTERN__SUBTYPES, null, msgs);
      msgs = basicSetSubtypes(newSubtypes, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternsPackage.TYPE_PATTERN__SUBTYPES, newSubtypes, newSubtypes));
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
      case PatternsPackage.TYPE_PATTERN__TYPE:
        return basicSetType(null, msgs);
      case PatternsPackage.TYPE_PATTERN__SUBTYPES:
        return basicSetSubtypes(null, msgs);
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
      case PatternsPackage.TYPE_PATTERN__TYPE:
        return getType();
      case PatternsPackage.TYPE_PATTERN__SUBTYPES:
        return getSubtypes();
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
      case PatternsPackage.TYPE_PATTERN__TYPE:
        setType((TypeReference)newValue);
        return;
      case PatternsPackage.TYPE_PATTERN__SUBTYPES:
        setSubtypes((Addition)newValue);
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
      case PatternsPackage.TYPE_PATTERN__TYPE:
        setType((TypeReference)null);
        return;
      case PatternsPackage.TYPE_PATTERN__SUBTYPES:
        setSubtypes((Addition)null);
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
      case PatternsPackage.TYPE_PATTERN__TYPE:
        return type != null;
      case PatternsPackage.TYPE_PATTERN__SUBTYPES:
        return subtypes != null;
    }
    return super.eIsSet(featureID);
  }

} //TypePatternImpl
