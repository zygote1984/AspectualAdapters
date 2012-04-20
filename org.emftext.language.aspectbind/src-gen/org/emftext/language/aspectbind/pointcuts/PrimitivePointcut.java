/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts;

import org.emftext.language.aspectbind.commons.AspectMember;

import org.emftext.language.aspectbind.patterns.Pattern;

import org.emftext.language.aspectbind.pcexp.PointcutAndExpressionChild;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.PrimitivePointcut#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getPrimitivePointcut()
 * @model abstract="true"
 * @generated
 */
public interface PrimitivePointcut extends AspectMember, PointcutAndExpressionChild {
	/**
   * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern</em>' containment reference.
   * @see #setPattern(Pattern)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getPrimitivePointcut_Pattern()
   * @model containment="true" required="true"
   * @generated
   */
	Pattern getPattern();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.PrimitivePointcut#getPattern <em>Pattern</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern</em>' containment reference.
   * @see #getPattern()
   * @generated
   */
	void setPattern(Pattern value);

} // PrimitivePointcut
