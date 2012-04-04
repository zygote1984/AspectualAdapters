/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts;

import org.emftext.language.java.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.IfPointcut#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getIfPointcut()
 * @model abstract="true"
 * @generated
 */
public interface IfPointcut extends PrimitivePointcut
{
  /**
   * Returns the value of the '<em><b>Exp</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exp</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' reference.
   * @see #setExp(Expression)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getIfPointcut_Exp()
   * @model
   * @generated
   */
  Expression getExp();

  /**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.IfPointcut#getExp <em>Exp</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' reference.
   * @see #getExp()
   * @generated
   */
  void setExp(Expression value);

} // IfPointcut
