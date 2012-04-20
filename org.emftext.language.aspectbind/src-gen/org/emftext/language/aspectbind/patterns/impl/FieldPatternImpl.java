/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.patterns.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.aspectbind.patterns.FieldPattern;
import org.emftext.language.aspectbind.patterns.PatternsPackage;
import org.emftext.language.aspectbind.patterns.TypePattern;

import org.emftext.language.java.modifiers.Modifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.FieldPatternImpl#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.FieldPatternImpl#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.FieldPatternImpl#getFieldType <em>Field Type</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.FieldPatternImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FieldPatternImpl extends PatternImpl implements FieldPattern {
	/**
   * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getModifiers()
   * @generated
   * @ordered
   */
	protected EList<Modifier> modifiers;

	/**
   * The cached value of the '{@link #getDeclaringType() <em>Declaring Type</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDeclaringType()
   * @generated
   * @ordered
   */
	protected TypePattern declaringType;

	/**
   * The cached value of the '{@link #getFieldType() <em>Field Type</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getFieldType()
   * @generated
   * @ordered
   */
	protected TypePattern fieldType;

	/**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected static final String NAME_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected String name = NAME_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected FieldPatternImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PatternsPackage.Literals.FIELD_PATTERN;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Modifier> getModifiers() {
    if (modifiers == null)
    {
      modifiers = new EObjectContainmentEList<Modifier>(Modifier.class, this, PatternsPackage.FIELD_PATTERN__MODIFIERS);
    }
    return modifiers;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TypePattern getDeclaringType() {
    return declaringType;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetDeclaringType(TypePattern newDeclaringType, NotificationChain msgs) {
    TypePattern oldDeclaringType = declaringType;
    declaringType = newDeclaringType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternsPackage.FIELD_PATTERN__DECLARING_TYPE, oldDeclaringType, newDeclaringType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setDeclaringType(TypePattern newDeclaringType) {
    if (newDeclaringType != declaringType)
    {
      NotificationChain msgs = null;
      if (declaringType != null)
        msgs = ((InternalEObject)declaringType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.FIELD_PATTERN__DECLARING_TYPE, null, msgs);
      if (newDeclaringType != null)
        msgs = ((InternalEObject)newDeclaringType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.FIELD_PATTERN__DECLARING_TYPE, null, msgs);
      msgs = basicSetDeclaringType(newDeclaringType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternsPackage.FIELD_PATTERN__DECLARING_TYPE, newDeclaringType, newDeclaringType));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TypePattern getFieldType() {
    return fieldType;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetFieldType(TypePattern newFieldType, NotificationChain msgs) {
    TypePattern oldFieldType = fieldType;
    fieldType = newFieldType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternsPackage.FIELD_PATTERN__FIELD_TYPE, oldFieldType, newFieldType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setFieldType(TypePattern newFieldType) {
    if (newFieldType != fieldType)
    {
      NotificationChain msgs = null;
      if (fieldType != null)
        msgs = ((InternalEObject)fieldType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.FIELD_PATTERN__FIELD_TYPE, null, msgs);
      if (newFieldType != null)
        msgs = ((InternalEObject)newFieldType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.FIELD_PATTERN__FIELD_TYPE, null, msgs);
      msgs = basicSetFieldType(newFieldType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternsPackage.FIELD_PATTERN__FIELD_TYPE, newFieldType, newFieldType));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getName() {
    return name;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternsPackage.FIELD_PATTERN__NAME, oldName, name));
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
      case PatternsPackage.FIELD_PATTERN__MODIFIERS:
        return ((InternalEList<?>)getModifiers()).basicRemove(otherEnd, msgs);
      case PatternsPackage.FIELD_PATTERN__DECLARING_TYPE:
        return basicSetDeclaringType(null, msgs);
      case PatternsPackage.FIELD_PATTERN__FIELD_TYPE:
        return basicSetFieldType(null, msgs);
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
      case PatternsPackage.FIELD_PATTERN__MODIFIERS:
        return getModifiers();
      case PatternsPackage.FIELD_PATTERN__DECLARING_TYPE:
        return getDeclaringType();
      case PatternsPackage.FIELD_PATTERN__FIELD_TYPE:
        return getFieldType();
      case PatternsPackage.FIELD_PATTERN__NAME:
        return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case PatternsPackage.FIELD_PATTERN__MODIFIERS:
        getModifiers().clear();
        getModifiers().addAll((Collection<? extends Modifier>)newValue);
        return;
      case PatternsPackage.FIELD_PATTERN__DECLARING_TYPE:
        setDeclaringType((TypePattern)newValue);
        return;
      case PatternsPackage.FIELD_PATTERN__FIELD_TYPE:
        setFieldType((TypePattern)newValue);
        return;
      case PatternsPackage.FIELD_PATTERN__NAME:
        setName((String)newValue);
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
      case PatternsPackage.FIELD_PATTERN__MODIFIERS:
        getModifiers().clear();
        return;
      case PatternsPackage.FIELD_PATTERN__DECLARING_TYPE:
        setDeclaringType((TypePattern)null);
        return;
      case PatternsPackage.FIELD_PATTERN__FIELD_TYPE:
        setFieldType((TypePattern)null);
        return;
      case PatternsPackage.FIELD_PATTERN__NAME:
        setName(NAME_EDEFAULT);
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
      case PatternsPackage.FIELD_PATTERN__MODIFIERS:
        return modifiers != null && !modifiers.isEmpty();
      case PatternsPackage.FIELD_PATTERN__DECLARING_TYPE:
        return declaringType != null;
      case PatternsPackage.FIELD_PATTERN__FIELD_TYPE:
        return fieldType != null;
      case PatternsPackage.FIELD_PATTERN__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //FieldPatternImpl
