/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts;

import org.emftext.language.aspectbind.patterns.TypePattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>This Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.ThisPointcut#getTypePattern <em>Type Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getThisPointcut()
 * @model
 * @generated
 */
public interface ThisPointcut extends PrimitivePointcut
{
  /**
   * Returns the value of the '<em><b>Type Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Pattern</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Pattern</em>' containment reference.
   * @see #setTypePattern(TypePattern)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getThisPointcut_TypePattern()
   * @model containment="true" required="true"
   * @generated
   */
  TypePattern getTypePattern();

  /**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.ThisPointcut#getTypePattern <em>Type Pattern</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Pattern</em>' containment reference.
   * @see #getTypePattern()
   * @generated
   */
  void setTypePattern(TypePattern value);

} // ThisPointcut
