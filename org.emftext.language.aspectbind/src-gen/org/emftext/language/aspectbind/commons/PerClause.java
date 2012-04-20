/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.commons;

import org.emftext.language.aspectbind.pointcuts.Pointcut;

import org.emftext.language.java.commons.Commentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Per Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.commons.PerClause#getClause <em>Clause</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.PerClause#getPointcut <em>Pointcut</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.commons.CommonsPackage#getPerClause()
 * @model
 * @generated
 */
public interface PerClause extends Commentable {
	/**
   * Returns the value of the '<em><b>Clause</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clause</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Clause</em>' attribute.
   * @see #setClause(String)
   * @see org.emftext.language.aspectbind.commons.CommonsPackage#getPerClause_Clause()
   * @model required="true"
   * @generated
   */
	String getClause();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.commons.PerClause#getClause <em>Clause</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clause</em>' attribute.
   * @see #getClause()
   * @generated
   */
	void setClause(String value);

	/**
   * Returns the value of the '<em><b>Pointcut</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pointcut</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Pointcut</em>' reference.
   * @see #setPointcut(Pointcut)
   * @see org.emftext.language.aspectbind.commons.CommonsPackage#getPerClause_Pointcut()
   * @model
   * @generated
   */
	Pointcut getPointcut();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.commons.PerClause#getPointcut <em>Pointcut</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pointcut</em>' reference.
   * @see #getPointcut()
   * @generated
   */
	void setPointcut(Pointcut value);

} // PerClause
