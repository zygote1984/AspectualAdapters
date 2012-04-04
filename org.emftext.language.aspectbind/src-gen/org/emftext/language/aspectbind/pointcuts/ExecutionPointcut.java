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
 * A representation of the model object '<em><b>Execution Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.ExecutionPointcut#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getExecutionPointcut()
 * @model abstract="true"
 * @generated
 */
public interface ExecutionPointcut extends PrimitivePointcut
{
  /**
   * Returns the value of the '<em><b>Signature</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signature</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signature</em>' containment reference.
   * @see #setSignature(AbstractMethodPattern)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getExecutionPointcut_Signature()
   * @model containment="true" required="true"
   * @generated
   */
  AbstractMethodPattern getSignature();

  /**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.ExecutionPointcut#getSignature <em>Signature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signature</em>' containment reference.
   * @see #getSignature()
   * @generated
   */
  void setSignature(AbstractMethodPattern value);

} // ExecutionPointcut
