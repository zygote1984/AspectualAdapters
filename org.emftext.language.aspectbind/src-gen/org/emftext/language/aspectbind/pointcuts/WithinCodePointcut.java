/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts;

import org.emftext.language.aspectbind.patterns.AbstractMethodPattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Within Code Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.WithinCodePointcut#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getWithinCodePointcut()
 * @model abstract="true"
 * @generated
 */
public interface WithinCodePointcut extends PrimitivePointcut
{
  /**
   * Returns the value of the '<em><b>Signature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signature</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signature</em>' reference.
   * @see #setSignature(AbstractMethodPattern)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getWithinCodePointcut_Signature()
   * @model required="true"
   * @generated
   */
  AbstractMethodPattern getSignature();

  /**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.WithinCodePointcut#getSignature <em>Signature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signature</em>' reference.
   * @see #getSignature()
   * @generated
   */
  void setSignature(AbstractMethodPattern value);

} // WithinCodePointcut
