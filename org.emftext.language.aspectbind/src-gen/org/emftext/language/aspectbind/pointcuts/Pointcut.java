/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts;

import org.emftext.language.aspectbind.commons.AspectMember;

import org.emftext.language.java.commons.NamedElement;

import org.emftext.language.java.expressions.ConditionalExpression;
import org.emftext.language.java.expressions.Expression;

import org.emftext.language.java.modifiers.Abstract;

import org.emftext.language.java.operators.AssignmentOperator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getAssign <em>Assign</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getPointcut()
 * @model abstract="true"
 * @generated
 */
public interface Pointcut extends AspectMember, NamedElement, Expression {
	/**
   * Returns the value of the '<em><b>Abstract</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' containment reference.
   * @see #setAbstract(Abstract)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getPointcut_Abstract()
   * @model containment="true"
   * @generated
   */
	Abstract getAbstract();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getAbstract <em>Abstract</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' containment reference.
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
   * @see #setAssign(AssignmentOperator)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getPointcut_Assign()
   * @model containment="true"
   * @generated
   */
	AssignmentOperator getAssign();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getAssign <em>Assign</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assign</em>' containment reference.
   * @see #getAssign()
   * @generated
   */
	void setAssign(AssignmentOperator value);

	/**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(ConditionalExpression)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getPointcut_Exp()
   * @model containment="true"
   * @generated
   */
	ConditionalExpression getExp();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
	void setExp(ConditionalExpression value);

} // Pointcut
