/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.commons.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.aspectbind.commons.CommonsPackage;
import org.emftext.language.aspectbind.commons.PerClause;

import org.emftext.language.aspectbind.pointcuts.Pointcut;

import org.emftext.language.java.commons.impl.CommentableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Per Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.commons.impl.PerClauseImpl#getClause <em>Clause</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.impl.PerClauseImpl#getPointcut <em>Pointcut</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PerClauseImpl extends CommentableImpl implements PerClause
{
  /**
   * The default value of the '{@link #getClause() <em>Clause</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClause()
   * @generated
   * @ordered
   */
  protected static final String CLAUSE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getClause() <em>Clause</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClause()
   * @generated
   * @ordered
   */
  protected String clause = CLAUSE_EDEFAULT;

  /**
   * The cached value of the '{@link #getPointcut() <em>Pointcut</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPointcut()
   * @generated
   * @ordered
   */
  protected Pointcut pointcut;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PerClauseImpl()
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
    return CommonsPackage.Literals.PER_CLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getClause()
  {
    return clause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClause(String newClause)
  {
    String oldClause = clause;
    clause = newClause;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PER_CLAUSE__CLAUSE, oldClause, clause));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pointcut getPointcut()
  {
    if (pointcut != null && pointcut.eIsProxy())
    {
      InternalEObject oldPointcut = (InternalEObject)pointcut;
      pointcut = (Pointcut)eResolveProxy(oldPointcut);
      if (pointcut != oldPointcut)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommonsPackage.PER_CLAUSE__POINTCUT, oldPointcut, pointcut));
      }
    }
    return pointcut;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pointcut basicGetPointcut()
  {
    return pointcut;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPointcut(Pointcut newPointcut)
  {
    Pointcut oldPointcut = pointcut;
    pointcut = newPointcut;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonsPackage.PER_CLAUSE__POINTCUT, oldPointcut, pointcut));
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
      case CommonsPackage.PER_CLAUSE__CLAUSE:
        return getClause();
      case CommonsPackage.PER_CLAUSE__POINTCUT:
        if (resolve) return getPointcut();
        return basicGetPointcut();
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
      case CommonsPackage.PER_CLAUSE__CLAUSE:
        setClause((String)newValue);
        return;
      case CommonsPackage.PER_CLAUSE__POINTCUT:
        setPointcut((Pointcut)newValue);
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
      case CommonsPackage.PER_CLAUSE__CLAUSE:
        setClause(CLAUSE_EDEFAULT);
        return;
      case CommonsPackage.PER_CLAUSE__POINTCUT:
        setPointcut((Pointcut)null);
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
      case CommonsPackage.PER_CLAUSE__CLAUSE:
        return CLAUSE_EDEFAULT == null ? clause != null : !CLAUSE_EDEFAULT.equals(clause);
      case CommonsPackage.PER_CLAUSE__POINTCUT:
        return pointcut != null;
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
    result.append(" (clause: ");
    result.append(clause);
    result.append(')');
    return result.toString();
  }

} //PerClauseImpl
