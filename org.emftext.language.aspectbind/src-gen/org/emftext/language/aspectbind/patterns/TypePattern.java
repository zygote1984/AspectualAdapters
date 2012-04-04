/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.patterns;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.java.types.TypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.patterns.TypePattern#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.patterns.PatternsPackage#getTypePattern()
 * @model
 * @generated
 */
public interface TypePattern extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeReference)
   * @see org.emftext.language.aspectbind.patterns.PatternsPackage#getTypePattern_Type()
   * @model containment="true" required="true"
   * @generated
   */
  TypeReference getType();

  /**
   * Sets the value of the '{@link org.emftext.language.aspectbind.patterns.TypePattern#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeReference value);

} // TypePattern
