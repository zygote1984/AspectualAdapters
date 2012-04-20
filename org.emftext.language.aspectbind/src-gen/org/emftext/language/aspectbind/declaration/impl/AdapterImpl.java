/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.declaration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.aspectbind.declaration.Adapter;
import org.emftext.language.aspectbind.declaration.DeclarationPackage;

import org.emftext.language.java.commons.impl.NamedElementImpl;

import org.emftext.language.java.generics.ExtendsTypeArgument;

import org.emftext.language.java.modifiers.Abstract;

import org.emftext.language.java.references.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adapter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.declaration.impl.AdapterImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.declaration.impl.AdapterImpl#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.declaration.impl.AdapterImpl#getExtend <em>Extend</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdapterImpl extends NamedElementImpl implements Adapter {
	/**
   * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getReferences()
   * @generated
   * @ordered
   */
	protected EList<Reference> references;

	/**
   * The cached value of the '{@link #getAbstract() <em>Abstract</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAbstract()
   * @generated
   * @ordered
   */
	protected Abstract abstract_;

	/**
   * The cached value of the '{@link #getExtend() <em>Extend</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getExtend()
   * @generated
   * @ordered
   */
	protected ExtendsTypeArgument extend;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected AdapterImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return DeclarationPackage.Literals.ADAPTER;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Reference> getReferences() {
    if (references == null)
    {
      references = new EObjectContainmentEList<Reference>(Reference.class, this, DeclarationPackage.ADAPTER__REFERENCES);
    }
    return references;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Abstract getAbstract() {
    return abstract_;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetAbstract(Abstract newAbstract, NotificationChain msgs) {
    Abstract oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeclarationPackage.ADAPTER__ABSTRACT, oldAbstract, newAbstract);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setAbstract(Abstract newAbstract) {
    if (newAbstract != abstract_)
    {
      NotificationChain msgs = null;
      if (abstract_ != null)
        msgs = ((InternalEObject)abstract_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeclarationPackage.ADAPTER__ABSTRACT, null, msgs);
      if (newAbstract != null)
        msgs = ((InternalEObject)newAbstract).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeclarationPackage.ADAPTER__ABSTRACT, null, msgs);
      msgs = basicSetAbstract(newAbstract, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DeclarationPackage.ADAPTER__ABSTRACT, newAbstract, newAbstract));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ExtendsTypeArgument getExtend() {
    return extend;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetExtend(ExtendsTypeArgument newExtend, NotificationChain msgs) {
    ExtendsTypeArgument oldExtend = extend;
    extend = newExtend;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeclarationPackage.ADAPTER__EXTEND, oldExtend, newExtend);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setExtend(ExtendsTypeArgument newExtend) {
    if (newExtend != extend)
    {
      NotificationChain msgs = null;
      if (extend != null)
        msgs = ((InternalEObject)extend).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeclarationPackage.ADAPTER__EXTEND, null, msgs);
      if (newExtend != null)
        msgs = ((InternalEObject)newExtend).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeclarationPackage.ADAPTER__EXTEND, null, msgs);
      msgs = basicSetExtend(newExtend, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DeclarationPackage.ADAPTER__EXTEND, newExtend, newExtend));
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
      case DeclarationPackage.ADAPTER__REFERENCES:
        return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
      case DeclarationPackage.ADAPTER__ABSTRACT:
        return basicSetAbstract(null, msgs);
      case DeclarationPackage.ADAPTER__EXTEND:
        return basicSetExtend(null, msgs);
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
      case DeclarationPackage.ADAPTER__REFERENCES:
        return getReferences();
      case DeclarationPackage.ADAPTER__ABSTRACT:
        return getAbstract();
      case DeclarationPackage.ADAPTER__EXTEND:
        return getExtend();
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
      case DeclarationPackage.ADAPTER__REFERENCES:
        getReferences().clear();
        getReferences().addAll((Collection<? extends Reference>)newValue);
        return;
      case DeclarationPackage.ADAPTER__ABSTRACT:
        setAbstract((Abstract)newValue);
        return;
      case DeclarationPackage.ADAPTER__EXTEND:
        setExtend((ExtendsTypeArgument)newValue);
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
      case DeclarationPackage.ADAPTER__REFERENCES:
        getReferences().clear();
        return;
      case DeclarationPackage.ADAPTER__ABSTRACT:
        setAbstract((Abstract)null);
        return;
      case DeclarationPackage.ADAPTER__EXTEND:
        setExtend((ExtendsTypeArgument)null);
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
      case DeclarationPackage.ADAPTER__REFERENCES:
        return references != null && !references.isEmpty();
      case DeclarationPackage.ADAPTER__ABSTRACT:
        return abstract_ != null;
      case DeclarationPackage.ADAPTER__EXTEND:
        return extend != null;
    }
    return super.eIsSet(featureID);
  }

} //AdapterImpl
