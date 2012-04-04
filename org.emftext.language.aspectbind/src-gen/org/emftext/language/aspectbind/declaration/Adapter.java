/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.declaration;

import org.eclipse.emf.common.util.EList;

import org.emftext.language.java.commons.NamedElement;

import org.emftext.language.java.references.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adapter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.declaration.Adapter#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.declaration.DeclarationPackage#getAdapter()
 * @model
 * @generated
 */
public interface Adapter extends NamedElement
{
  /**
   * Returns the value of the '<em><b>References</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.java.references.Reference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>References</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>References</em>' containment reference list.
   * @see org.emftext.language.aspectbind.declaration.DeclarationPackage#getAdapter_References()
   * @model containment="true" required="true"
   * @generated
   */
  EList<Reference> getReferences();

} // Adapter
