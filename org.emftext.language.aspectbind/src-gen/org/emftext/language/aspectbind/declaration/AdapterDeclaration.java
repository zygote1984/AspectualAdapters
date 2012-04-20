/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.declaration;

import org.eclipse.emf.common.util.EList;

import org.emftext.language.aspectbind.binding.InstancePointcut;

import org.emftext.language.aspectbind.patterns.TypePattern;

import org.emftext.language.java.members.Member;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adapter Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdapter <em>Adapter</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdaptee <em>Adaptee</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration#getMembers <em>Members</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdapteeSub <em>Adaptee Sub</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.declaration.DeclarationPackage#getAdapterDeclaration()
 * @model
 * @generated
 */
public interface AdapterDeclaration extends Declaration {
	/**
   * Returns the value of the '<em><b>Adapter</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Adapter</em>' containment reference.
   * @see #setAdapter(Adapter)
   * @see org.emftext.language.aspectbind.declaration.DeclarationPackage#getAdapterDeclaration_Adapter()
   * @model containment="true" required="true"
   * @generated
   */
	Adapter getAdapter();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdapter <em>Adapter</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Adapter</em>' containment reference.
   * @see #getAdapter()
   * @generated
   */
	void setAdapter(Adapter value);

	/**
   * Returns the value of the '<em><b>Adaptee</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adaptee</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Adaptee</em>' reference.
   * @see #setAdaptee(InstancePointcut)
   * @see org.emftext.language.aspectbind.declaration.DeclarationPackage#getAdapterDeclaration_Adaptee()
   * @model required="true"
   * @generated
   */
	InstancePointcut getAdaptee();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdaptee <em>Adaptee</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Adaptee</em>' reference.
   * @see #getAdaptee()
   * @generated
   */
	void setAdaptee(InstancePointcut value);

	/**
   * Returns the value of the '<em><b>Members</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.java.members.Member}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Members</em>' containment reference list.
   * @see org.emftext.language.aspectbind.declaration.DeclarationPackage#getAdapterDeclaration_Members()
   * @model containment="true"
   * @generated
   */
	EList<Member> getMembers();

	/**
   * Returns the value of the '<em><b>Adaptee Sub</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adaptee Sub</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Adaptee Sub</em>' containment reference.
   * @see #setAdapteeSub(TypePattern)
   * @see org.emftext.language.aspectbind.declaration.DeclarationPackage#getAdapterDeclaration_AdapteeSub()
   * @model containment="true"
   * @generated
   */
	TypePattern getAdapteeSub();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdapteeSub <em>Adaptee Sub</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Adaptee Sub</em>' containment reference.
   * @see #getAdapteeSub()
   * @generated
   */
	void setAdapteeSub(TypePattern value);

} // AdapterDeclaration
