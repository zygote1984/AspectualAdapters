/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.commons;

import org.eclipse.emf.common.util.EList;

import org.emftext.language.java.containers.CompilationUnit;

import org.emftext.language.java.generics.ExtendsTypeArgument;

import org.emftext.language.java.modifiers.Modifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.commons.Aspect#getMembers <em>Members</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.Aspect#getPackage <em>Package</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.Aspect#isPriviliged <em>Priviliged</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.Aspect#getModifier <em>Modifier</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.Aspect#getExtend <em>Extend</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.Aspect#getImplement <em>Implement</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.commons.Aspect#getPerclause <em>Perclause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.commons.CommonsPackage#getAspect()
 * @model
 * @generated
 */
public interface Aspect extends CompilationUnit {
	/**
   * Returns the value of the '<em><b>Members</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.aspectbind.commons.AspectMember}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Members</em>' containment reference list.
   * @see org.emftext.language.aspectbind.commons.CommonsPackage#getAspect_Members()
   * @model containment="true"
   * @generated
   */
	EList<AspectMember> getMembers();

	/**
   * Returns the value of the '<em><b>Package</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' containment reference.
   * @see #setPackage(org.emftext.language.java.containers.Package)
   * @see org.emftext.language.aspectbind.commons.CommonsPackage#getAspect_Package()
   * @model containment="true"
   * @generated
   */
	org.emftext.language.java.containers.Package getPackage();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.commons.Aspect#getPackage <em>Package</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' containment reference.
   * @see #getPackage()
   * @generated
   */
	void setPackage(org.emftext.language.java.containers.Package value);

	/**
   * Returns the value of the '<em><b>Priviliged</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priviliged</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Priviliged</em>' attribute.
   * @see #setPriviliged(boolean)
   * @see org.emftext.language.aspectbind.commons.CommonsPackage#getAspect_Priviliged()
   * @model default="false"
   * @generated
   */
	boolean isPriviliged();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.commons.Aspect#isPriviliged <em>Priviliged</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priviliged</em>' attribute.
   * @see #isPriviliged()
   * @generated
   */
	void setPriviliged(boolean value);

	/**
   * Returns the value of the '<em><b>Modifier</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.java.modifiers.Modifier}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Modifier</em>' containment reference list.
   * @see org.emftext.language.aspectbind.commons.CommonsPackage#getAspect_Modifier()
   * @model containment="true"
   * @generated
   */
	EList<Modifier> getModifier();

	/**
   * Returns the value of the '<em><b>Extend</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extend</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Extend</em>' containment reference.
   * @see #setExtend(ExtendsTypeArgument)
   * @see org.emftext.language.aspectbind.commons.CommonsPackage#getAspect_Extend()
   * @model containment="true"
   * @generated
   */
	ExtendsTypeArgument getExtend();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.commons.Aspect#getExtend <em>Extend</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extend</em>' containment reference.
   * @see #getExtend()
   * @generated
   */
	void setExtend(ExtendsTypeArgument value);

	/**
   * Returns the value of the '<em><b>Implement</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.java.generics.ExtendsTypeArgument}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implement</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Implement</em>' containment reference list.
   * @see org.emftext.language.aspectbind.commons.CommonsPackage#getAspect_Implement()
   * @model containment="true"
   * @generated
   */
	EList<ExtendsTypeArgument> getImplement();

	/**
   * Returns the value of the '<em><b>Perclause</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Perclause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Perclause</em>' containment reference.
   * @see #setPerclause(PerClause)
   * @see org.emftext.language.aspectbind.commons.CommonsPackage#getAspect_Perclause()
   * @model containment="true"
   * @generated
   */
	PerClause getPerclause();

	/**
   * Sets the value of the '{@link org.emftext.language.aspectbind.commons.Aspect#getPerclause <em>Perclause</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Perclause</em>' containment reference.
   * @see #getPerclause()
   * @generated
   */
	void setPerclause(PerClause value);

} // Aspect
