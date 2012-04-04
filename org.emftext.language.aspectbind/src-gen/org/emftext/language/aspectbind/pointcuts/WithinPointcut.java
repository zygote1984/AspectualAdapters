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
 * A representation of the model object '<em><b>Within Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.WithinPointcut#getTypePattern <em>Type Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getWithinPointcut()
 * @model abstract="true"
 * @generated
 */
public interface WithinPointcut extends PrimitivePointcut
{
  /**
   * Returns the value of the '<em><b>Type Pattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Pattern</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Pattern</em>' reference.
   * @see #setTypePattern(TypePattern)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getWithinPointcut_TypePattern()
   * @model required="true"
   * @generated
   */
  TypePattern getTypePattern();

  /**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.WithinPointcut#getTypePattern <em>Type Pattern</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Pattern</em>' reference.
   * @see #getTypePattern()
   * @generated
   */
  void setTypePattern(TypePattern value);

} // WithinPointcut
