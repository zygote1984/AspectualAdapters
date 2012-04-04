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

import org.emftext.language.aspectbind.binding.InstancePointcut;

import org.emftext.language.aspectbind.declaration.Adapter;
import org.emftext.language.aspectbind.declaration.AdapterDeclaration;
import org.emftext.language.aspectbind.declaration.DeclarationPackage;

import org.emftext.language.java.members.Member;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adapter Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.declaration.impl.AdapterDeclarationImpl#getAdapter <em>Adapter</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.declaration.impl.AdapterDeclarationImpl#getAdaptee <em>Adaptee</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.declaration.impl.AdapterDeclarationImpl#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdapterDeclarationImpl extends DeclarationImpl implements AdapterDeclaration
{
  /**
   * The cached value of the '{@link #getAdapter() <em>Adapter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdapter()
   * @generated
   * @ordered
   */
  protected Adapter adapter;

  /**
   * The cached value of the '{@link #getAdaptee() <em>Adaptee</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdaptee()
   * @generated
   * @ordered
   */
  protected InstancePointcut adaptee;

  /**
   * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMembers()
   * @generated
   * @ordered
   */
  protected EList<Member> members;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AdapterDeclarationImpl()
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
    return DeclarationPackage.Literals.ADAPTER_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Adapter getAdapter()
  {
    return adapter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAdapter(Adapter newAdapter, NotificationChain msgs)
  {
    Adapter oldAdapter = adapter;
    adapter = newAdapter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeclarationPackage.ADAPTER_DECLARATION__ADAPTER, oldAdapter, newAdapter);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdapter(Adapter newAdapter)
  {
    if (newAdapter != adapter)
    {
      NotificationChain msgs = null;
      if (adapter != null)
        msgs = ((InternalEObject)adapter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeclarationPackage.ADAPTER_DECLARATION__ADAPTER, null, msgs);
      if (newAdapter != null)
        msgs = ((InternalEObject)newAdapter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeclarationPackage.ADAPTER_DECLARATION__ADAPTER, null, msgs);
      msgs = basicSetAdapter(newAdapter, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DeclarationPackage.ADAPTER_DECLARATION__ADAPTER, newAdapter, newAdapter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstancePointcut getAdaptee()
  {
    if (adaptee != null && adaptee.eIsProxy())
    {
      InternalEObject oldAdaptee = (InternalEObject)adaptee;
      adaptee = (InstancePointcut)eResolveProxy(oldAdaptee);
      if (adaptee != oldAdaptee)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeclarationPackage.ADAPTER_DECLARATION__ADAPTEE, oldAdaptee, adaptee));
      }
    }
    return adaptee;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstancePointcut basicGetAdaptee()
  {
    return adaptee;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdaptee(InstancePointcut newAdaptee)
  {
    InstancePointcut oldAdaptee = adaptee;
    adaptee = newAdaptee;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DeclarationPackage.ADAPTER_DECLARATION__ADAPTEE, oldAdaptee, adaptee));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Member> getMembers()
  {
    if (members == null)
    {
      members = new EObjectContainmentEList<Member>(Member.class, this, DeclarationPackage.ADAPTER_DECLARATION__MEMBERS);
    }
    return members;
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
      case DeclarationPackage.ADAPTER_DECLARATION__ADAPTER:
        return basicSetAdapter(null, msgs);
      case DeclarationPackage.ADAPTER_DECLARATION__MEMBERS:
        return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
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
      case DeclarationPackage.ADAPTER_DECLARATION__ADAPTER:
        return getAdapter();
      case DeclarationPackage.ADAPTER_DECLARATION__ADAPTEE:
        if (resolve) return getAdaptee();
        return basicGetAdaptee();
      case DeclarationPackage.ADAPTER_DECLARATION__MEMBERS:
        return getMembers();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DeclarationPackage.ADAPTER_DECLARATION__ADAPTER:
        setAdapter((Adapter)newValue);
        return;
      case DeclarationPackage.ADAPTER_DECLARATION__ADAPTEE:
        setAdaptee((InstancePointcut)newValue);
        return;
      case DeclarationPackage.ADAPTER_DECLARATION__MEMBERS:
        getMembers().clear();
        getMembers().addAll((Collection<? extends Member>)newValue);
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
      case DeclarationPackage.ADAPTER_DECLARATION__ADAPTER:
        setAdapter((Adapter)null);
        return;
      case DeclarationPackage.ADAPTER_DECLARATION__ADAPTEE:
        setAdaptee((InstancePointcut)null);
        return;
      case DeclarationPackage.ADAPTER_DECLARATION__MEMBERS:
        getMembers().clear();
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
      case DeclarationPackage.ADAPTER_DECLARATION__ADAPTER:
        return adapter != null;
      case DeclarationPackage.ADAPTER_DECLARATION__ADAPTEE:
        return adaptee != null;
      case DeclarationPackage.ADAPTER_DECLARATION__MEMBERS:
        return members != null && !members.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AdapterDeclarationImpl
