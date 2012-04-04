/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.commons.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.aspectbind.commons.Aspect;
import org.emftext.language.aspectbind.commons.AspectMember;
import org.emftext.language.aspectbind.commons.CommonsPackage;
import org.emftext.language.aspectbind.commons.PerClause;

import org.emftext.language.java.containers.impl.CompilationUnitImpl;

import org.emftext.language.java.generics.ExtendsTypeArgument;

import org.emftext.language.java.modifiers.Modifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aspect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.commons.impl.AspectImpl#getMembers <em>Members</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.impl.AspectImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.impl.AspectImpl#isPriviliged <em>Priviliged</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.impl.AspectImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.impl.AspectImpl#getExtend <em>Extend</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.impl.AspectImpl#getImplement <em>Implement</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.impl.AspectImpl#getPerclause <em>Perclause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AspectImpl extends CompilationUnitImpl implements Aspect
{
  /**
   * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMembers()
   * @generated
   * @ordered
   */
  protected EList<AspectMember> members;

  /**
   * The cached value of the '{@link #getPackage() <em>Package</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected org.emftext.language.java.containers.Package package_;

  /**
   * The default value of the '{@link #isPriviliged() <em>Priviliged</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPriviliged()
   * @generated
   * @ordered
   */
  protected static final boolean PRIVILIGED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPriviliged() <em>Priviliged</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPriviliged()
   * @generated
   * @ordered
   */
  protected boolean priviliged = PRIVILIGED_EDEFAULT;

  /**
   * The cached value of the '{@link #getModifier() <em>Modifier</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier()
   * @generated
   * @ordered
   */
  protected EList<Modifier> modifier;

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
   * The cached value of the '{@link #getImplement() <em>Implement</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplement()
   * @generated
   * @ordered
   */
  protected EList<ExtendsTypeArgument> implement;

  /**
   * The cached value of the '{@link #getPerclause() <em>Perclause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPerclause()
   * @generated
   * @ordered
   */
  protected PerClause perclause;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AspectImpl()
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
    return CommonsPackage.Literals.ASPECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AspectMember> getMembers()
  {
    if (members == null)
    {
      members = new EObjectContainmentEList<AspectMember>(AspectMember.class, this, CommonsPackage.ASPECT__MEMBERS);
    }
    return members;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.emftext.language.java.containers.Package getPackage()
  {
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPackage(org.emftext.language.java.containers.Package newPackage, NotificationChain msgs)
  {
    org.emftext.language.java.containers.Package oldPackage = package_;
    package_ = newPackage;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonsPackage.ASPECT__PACKAGE, oldPackage, newPackage);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackage(org.emftext.language.java.containers.Package newPackage)
  {
    if (newPackage != package_)
    {
      NotificationChain msgs = null;
      if (package_ != null)
        msgs = ((InternalEObject)package_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonsPackage.ASPECT__PACKAGE, null, msgs);
      if (newPackage != null)
        msgs = ((InternalEObject)newPackage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonsPackage.ASPECT__PACKAGE, null, msgs);
      msgs = basicSetPackage(newPackage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ASPECT__PACKAGE, newPackage, newPackage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPriviliged()
  {
    return priviliged;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriviliged(boolean newPriviliged)
  {
    boolean oldPriviliged = priviliged;
    priviliged = newPriviliged;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ASPECT__PRIVILIGED, oldPriviliged, priviliged));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Modifier> getModifier()
  {
    if (modifier == null)
    {
      modifier = new EObjectContainmentEList<Modifier>(Modifier.class, this, CommonsPackage.ASPECT__MODIFIER);
    }
    return modifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendsTypeArgument getExtend()
  {
    return extend;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtend(ExtendsTypeArgument newExtend, NotificationChain msgs)
  {
    ExtendsTypeArgument oldExtend = extend;
    extend = newExtend;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonsPackage.ASPECT__EXTEND, oldExtend, newExtend);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtend(ExtendsTypeArgument newExtend)
  {
    if (newExtend != extend)
    {
      NotificationChain msgs = null;
      if (extend != null)
        msgs = ((InternalEObject)extend).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonsPackage.ASPECT__EXTEND, null, msgs);
      if (newExtend != null)
        msgs = ((InternalEObject)newExtend).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonsPackage.ASPECT__EXTEND, null, msgs);
      msgs = basicSetExtend(newExtend, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ASPECT__EXTEND, newExtend, newExtend));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExtendsTypeArgument> getImplement()
  {
    if (implement == null)
    {
      implement = new EObjectContainmentEList<ExtendsTypeArgument>(ExtendsTypeArgument.class, this, CommonsPackage.ASPECT__IMPLEMENT);
    }
    return implement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PerClause getPerclause()
  {
    return perclause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPerclause(PerClause newPerclause, NotificationChain msgs)
  {
    PerClause oldPerclause = perclause;
    perclause = newPerclause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommonsPackage.ASPECT__PERCLAUSE, oldPerclause, newPerclause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPerclause(PerClause newPerclause)
  {
    if (newPerclause != perclause)
    {
      NotificationChain msgs = null;
      if (perclause != null)
        msgs = ((InternalEObject)perclause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommonsPackage.ASPECT__PERCLAUSE, null, msgs);
      if (newPerclause != null)
        msgs = ((InternalEObject)newPerclause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommonsPackage.ASPECT__PERCLAUSE, null, msgs);
      msgs = basicSetPerclause(newPerclause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.ASPECT__PERCLAUSE, newPerclause, newPerclause));
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
      case CommonsPackage.ASPECT__MEMBERS:
        return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
      case CommonsPackage.ASPECT__PACKAGE:
        return basicSetPackage(null, msgs);
      case CommonsPackage.ASPECT__MODIFIER:
        return ((InternalEList<?>)getModifier()).basicRemove(otherEnd, msgs);
      case CommonsPackage.ASPECT__EXTEND:
        return basicSetExtend(null, msgs);
      case CommonsPackage.ASPECT__IMPLEMENT:
        return ((InternalEList<?>)getImplement()).basicRemove(otherEnd, msgs);
      case CommonsPackage.ASPECT__PERCLAUSE:
        return basicSetPerclause(null, msgs);
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
      case CommonsPackage.ASPECT__MEMBERS:
        return getMembers();
      case CommonsPackage.ASPECT__PACKAGE:
        return getPackage();
      case CommonsPackage.ASPECT__PRIVILIGED:
        return isPriviliged();
      case CommonsPackage.ASPECT__MODIFIER:
        return getModifier();
      case CommonsPackage.ASPECT__EXTEND:
        return getExtend();
      case CommonsPackage.ASPECT__IMPLEMENT:
        return getImplement();
      case CommonsPackage.ASPECT__PERCLAUSE:
        return getPerclause();
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
      case CommonsPackage.ASPECT__MEMBERS:
        getMembers().clear();
        getMembers().addAll((Collection<? extends AspectMember>)newValue);
        return;
      case CommonsPackage.ASPECT__PACKAGE:
        setPackage((org.emftext.language.java.containers.Package)newValue);
        return;
      case CommonsPackage.ASPECT__PRIVILIGED:
        setPriviliged((Boolean)newValue);
        return;
      case CommonsPackage.ASPECT__MODIFIER:
        getModifier().clear();
        getModifier().addAll((Collection<? extends Modifier>)newValue);
        return;
      case CommonsPackage.ASPECT__EXTEND:
        setExtend((ExtendsTypeArgument)newValue);
        return;
      case CommonsPackage.ASPECT__IMPLEMENT:
        getImplement().clear();
        getImplement().addAll((Collection<? extends ExtendsTypeArgument>)newValue);
        return;
      case CommonsPackage.ASPECT__PERCLAUSE:
        setPerclause((PerClause)newValue);
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
      case CommonsPackage.ASPECT__MEMBERS:
        getMembers().clear();
        return;
      case CommonsPackage.ASPECT__PACKAGE:
        setPackage((org.emftext.language.java.containers.Package)null);
        return;
      case CommonsPackage.ASPECT__PRIVILIGED:
        setPriviliged(PRIVILIGED_EDEFAULT);
        return;
      case CommonsPackage.ASPECT__MODIFIER:
        getModifier().clear();
        return;
      case CommonsPackage.ASPECT__EXTEND:
        setExtend((ExtendsTypeArgument)null);
        return;
      case CommonsPackage.ASPECT__IMPLEMENT:
        getImplement().clear();
        return;
      case CommonsPackage.ASPECT__PERCLAUSE:
        setPerclause((PerClause)null);
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
      case CommonsPackage.ASPECT__MEMBERS:
        return members != null && !members.isEmpty();
      case CommonsPackage.ASPECT__PACKAGE:
        return package_ != null;
      case CommonsPackage.ASPECT__PRIVILIGED:
        return priviliged != PRIVILIGED_EDEFAULT;
      case CommonsPackage.ASPECT__MODIFIER:
        return modifier != null && !modifier.isEmpty();
      case CommonsPackage.ASPECT__EXTEND:
        return extend != null;
      case CommonsPackage.ASPECT__IMPLEMENT:
        return implement != null && !implement.isEmpty();
      case CommonsPackage.ASPECT__PERCLAUSE:
        return perclause != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (priviliged: ");
    result.append(priviliged);
    result.append(')');
    return result.toString();
  }

} //AspectImpl
