/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.binding;

import org.emftext.language.aspectbind.patterns.TypePattern;

import org.emftext.language.aspectbind.pointcuts.Pointcut;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.binding.InstancePointcut#getInstanceType <em>Instance Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.binding.BindingPackage#getInstancePointcut()
 * @model
 * @generated
 */
public interface InstancePointcut extends Pointcut
{
  /**
   * Returns the value of the '<em><b>Instance Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instance Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance Type</em>' containment reference.
   * @see #setInstanceType(TypePattern)
   * @see org.emftext.language.aspectbind.binding.BindingPackage#getInstancePointcut_InstanceType()
   * @model containment="true" required="true"
   * @generated
   */
  TypePattern getInstanceType();

  /**
   * Sets the value of the '{@link org.emftext.language.aspectbind.binding.InstancePointcut#getInstanceType <em>Instance Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance Type</em>' containment reference.
   * @see #getInstanceType()
   * @generated
   */
  void setInstanceType(TypePattern value);

} // InstancePointcut
