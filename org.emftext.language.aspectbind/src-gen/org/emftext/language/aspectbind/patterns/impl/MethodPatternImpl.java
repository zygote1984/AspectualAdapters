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

import org.emftext.language.aspectbind.patterns.MethodPattern;
import org.emftext.language.aspectbind.patterns.PatternsPackage;
import org.emftext.language.aspectbind.patterns.TypePattern;

import org.emftext.language.java.modifiers.Modifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.MethodPatternImpl#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.MethodPatternImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.MethodPatternImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.MethodPatternImpl#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.MethodPatternImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodPatternImpl extends AbstractMethodPatternImpl implements MethodPattern {
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
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
	protected TypePattern returnType;

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
   * The cached value of the '{@link #getDeclaringType() <em>Declaring Type</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDeclaringType()
   * @generated
   * @ordered
   */
	protected TypePattern declaringType;

	/**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
	protected EList<TypePattern> parameters;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected MethodPatternImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PatternsPackage.Literals.METHOD_PATTERN;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Modifier> getModifiers() {
    if (modifiers == null)
    {
      modifiers = new EObjectContainmentEList<Modifier>(Modifier.class, this, PatternsPackage.METHOD_PATTERN__MODIFIERS);
    }
    return modifiers;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TypePattern getReturnType() {
    return returnType;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetReturnType(TypePattern newReturnType, NotificationChain msgs) {
    TypePattern oldReturnType = returnType;
    returnType = newReturnType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternsPackage.METHOD_PATTERN__RETURN_TYPE, oldReturnType, newReturnType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setReturnType(TypePattern newReturnType) {
    if (newReturnType != returnType)
    {
      NotificationChain msgs = null;
      if (returnType != null)
        msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.METHOD_PATTERN__RETURN_TYPE, null, msgs);
      if (newReturnType != null)
        msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.METHOD_PATTERN__RETURN_TYPE, null, msgs);
      msgs = basicSetReturnType(newReturnType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternsPackage.METHOD_PATTERN__RETURN_TYPE, newReturnType, newReturnType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, PatternsPackage.METHOD_PATTERN__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternsPackage.METHOD_PATTERN__DECLARING_TYPE, oldDeclaringType, newDeclaringType);
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
        msgs = ((InternalEObject)declaringType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.METHOD_PATTERN__DECLARING_TYPE, null, msgs);
      if (newDeclaringType != null)
        msgs = ((InternalEObject)newDeclaringType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternsPackage.METHOD_PATTERN__DECLARING_TYPE, null, msgs);
      msgs = basicSetDeclaringType(newDeclaringType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternsPackage.METHOD_PATTERN__DECLARING_TYPE, newDeclaringType, newDeclaringType));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<TypePattern> getParameters() {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<TypePattern>(TypePattern.class, this, PatternsPackage.METHOD_PATTERN__PARAMETERS);
    }
    return parameters;
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
      case PatternsPackage.METHOD_PATTERN__MODIFIERS:
        return ((InternalEList<?>)getModifiers()).basicRemove(otherEnd, msgs);
      case PatternsPackage.METHOD_PATTERN__RETURN_TYPE:
        return basicSetReturnType(null, msgs);
      case PatternsPackage.METHOD_PATTERN__DECLARING_TYPE:
        return basicSetDeclaringType(null, msgs);
      case PatternsPackage.METHOD_PATTERN__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
      case PatternsPackage.METHOD_PATTERN__MODIFIERS:
        return getModifiers();
      case PatternsPackage.METHOD_PATTERN__RETURN_TYPE:
        return getReturnType();
      case PatternsPackage.METHOD_PATTERN__NAME:
        return getName();
      case PatternsPackage.METHOD_PATTERN__DECLARING_TYPE:
        return getDeclaringType();
      case PatternsPackage.METHOD_PATTERN__PARAMETERS:
        return getParameters();
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
      case PatternsPackage.METHOD_PATTERN__MODIFIERS:
        getModifiers().clear();
        getModifiers().addAll((Collection<? extends Modifier>)newValue);
        return;
      case PatternsPackage.METHOD_PATTERN__RETURN_TYPE:
        setReturnType((TypePattern)newValue);
        return;
      case PatternsPackage.METHOD_PATTERN__NAME:
        setName((String)newValue);
        return;
      case PatternsPackage.METHOD_PATTERN__DECLARING_TYPE:
        setDeclaringType((TypePattern)newValue);
        return;
      case PatternsPackage.METHOD_PATTERN__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends TypePattern>)newValue);
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
      case PatternsPackage.METHOD_PATTERN__MODIFIERS:
        getModifiers().clear();
        return;
      case PatternsPackage.METHOD_PATTERN__RETURN_TYPE:
        setReturnType((TypePattern)null);
        return;
      case PatternsPackage.METHOD_PATTERN__NAME:
        setName(NAME_EDEFAULT);
        return;
      case PatternsPackage.METHOD_PATTERN__DECLARING_TYPE:
        setDeclaringType((TypePattern)null);
        return;
      case PatternsPackage.METHOD_PATTERN__PARAMETERS:
        getParameters().clear();
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
      case PatternsPackage.METHOD_PATTERN__MODIFIERS:
        return modifiers != null && !modifiers.isEmpty();
      case PatternsPackage.METHOD_PATTERN__RETURN_TYPE:
        return returnType != null;
      case PatternsPackage.METHOD_PATTERN__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case PatternsPackage.METHOD_PATTERN__DECLARING_TYPE:
        return declaringType != null;
      case PatternsPackage.METHOD_PATTERN__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
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

} //MethodPatternImpl
