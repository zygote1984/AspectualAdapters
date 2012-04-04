/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts;

import org.emftext.language.aspectbind.commons.AspectMember;

import org.emftext.language.aspectbind.pcexp.PointcutExpression;
import org.emftext.language.aspectbind.pcexp.PointcutExpressionType;

import org.emftext.language.java.commons.NamedElement;

import org.emftext.language.java.modifiers.Abstract;

import org.emftext.language.java.operators.Assignment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getExp <em>Exp</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getAssign <em>Assign</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getPointcut()
 * @model abstract="true"
 * @generated
 */
public interface Pointcut extends AspectMember, NamedElement, PointcutExpressionType
{
  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exp</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(PointcutExpression)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getPointcut_Exp()
   * @model containment="true"
   * @generated
   */
  PointcutExpression getExp();

  /**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(PointcutExpression value);

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' reference.
   * @see #setAbstract(Abstract)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getPointcut_Abstract()
   * @model
   * @generated
   */
  Abstract getAbstract();

  /**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getAbstract <em>Abstract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' reference.
   * @see #getAbstract()
   * @generated
   */
  void setAbstract(Abstract value);

  /**
   * Returns the value of the '<em><b>Assign</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assign</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assign</em>' containment reference.
   * @see #setAssign(Assignment)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getPointcut_Assign()
   * @model containment="true"
   * @generated
   */
  Assignment getAssign();

  /**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getAssign <em>Assign</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assign</em>' containment reference.
   * @see #getAssign()
   * @generated
   */
  void setAssign(Assignment value);

} // Pointcut
