/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.declaration;

import org.eclipse.emf.common.util.EList;

import org.emftext.language.aspectbind.patterns.TypePattern;
import org.emftext.language.java.commons.NamedElement;

import org.emftext.language.java.generics.ExtendsTypeArgument;

import org.emftext.language.java.modifiers.Abstract;

import org.emftext.language.java.types.TypeReference;
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
 *   <li>{@link org.emftext.language.aspectbind.declaration.Adapter#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.declaration.Adapter#getExtend <em>Extend</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.declaration.DeclarationPackage#getAdapter()
 * @model
 * @generated
 */
public interface Adapter extends NamedElement {
	/**
   * Returns the value of the '<em><b>References</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.aspectbind.patterns.TypePattern}.
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
	EList<TypePattern> getReferences();

	/**
   * Returns the value of the '<em><b>Abstract</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' containment reference.
   * @see #setAbstract(Abstract)
   * @see org.emftext.language.aspectbind.declaration.DeclarationPackage#getAdapter_Abstract()
   * @model containment="true"
   * @generated
   */
	Abstract getAbstract();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.declaration.Adapter#getAbstract <em>Abstract</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' containment reference.
   * @see #getAbstract()
   * @generated
   */
	void setAbstract(Abstract value);

	/**
   * Returns the value of the '<em><b>Extend</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extend</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Extend</em>' reference.
   * @see #setExtend(Adapter)
   * @see org.emftext.language.aspectbind.declaration.DeclarationPackage#getAdapter_Extend()
   * @model
   * @generated
   */
	Adapter getExtend();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.declaration.Adapter#getExtend <em>Extend</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extend</em>' reference.
   * @see #getExtend()
   * @generated
   */
  void setExtend(Adapter value);

} // Adapter
