/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.patterns;

import org.eclipse.emf.common.util.EList;

import org.emftext.language.java.modifiers.Modifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.patterns.MethodPattern#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.MethodPattern#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.MethodPattern#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.MethodPattern#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.patterns.MethodPattern#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.patterns.PatternsPackage#getMethodPattern()
 * @model
 * @generated
 */
public interface MethodPattern extends AbstractMethodPattern {
	/**
   * Returns the value of the '<em><b>Modifiers</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.java.modifiers.Modifier}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Modifiers</em>' containment reference list.
   * @see org.emftext.language.aspectbind.patterns.PatternsPackage#getMethodPattern_Modifiers()
   * @model containment="true"
   * @generated
   */
	EList<Modifier> getModifiers();

	/**
   * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Return Type</em>' containment reference.
   * @see #setReturnType(TypePattern)
   * @see org.emftext.language.aspectbind.patterns.PatternsPackage#getMethodPattern_ReturnType()
   * @model containment="true" required="true"
   * @generated
   */
	TypePattern getReturnType();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.patterns.MethodPattern#getReturnType <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return Type</em>' containment reference.
   * @see #getReturnType()
   * @generated
   */
	void setReturnType(TypePattern value);

	/**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.emftext.language.aspectbind.patterns.PatternsPackage#getMethodPattern_Name()
   * @model required="true"
   * @generated
   */
	String getName();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.patterns.MethodPattern#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
	void setName(String value);

	/**
   * Returns the value of the '<em><b>Declaring Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaring Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Declaring Type</em>' containment reference.
   * @see #setDeclaringType(TypePattern)
   * @see org.emftext.language.aspectbind.patterns.PatternsPackage#getMethodPattern_DeclaringType()
   * @model containment="true" required="true"
   * @generated
   */
	TypePattern getDeclaringType();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.patterns.MethodPattern#getDeclaringType <em>Declaring Type</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declaring Type</em>' containment reference.
   * @see #getDeclaringType()
   * @generated
   */
	void setDeclaringType(TypePattern value);

	/**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.aspectbind.patterns.TypePattern}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.emftext.language.aspectbind.patterns.PatternsPackage#getMethodPattern_Parameters()
   * @model containment="true"
   * @generated
   */
	EList<TypePattern> getParameters();

} // MethodPattern
