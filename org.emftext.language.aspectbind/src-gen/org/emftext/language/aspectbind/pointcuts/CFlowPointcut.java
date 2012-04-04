/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CFlow Pointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.CFlowPointcut#getPointcut <em>Pointcut</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getCFlowPointcut()
 * @model abstract="true"
 * @generated
 */
public interface CFlowPointcut extends PrimitivePointcut
{
  /**
   * Returns the value of the '<em><b>Pointcut</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pointcut</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pointcut</em>' reference.
   * @see #setPointcut(Pointcut)
   * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage#getCFlowPointcut_Pointcut()
   * @model required="true"
   * @generated
   */
  Pointcut getPointcut();

  /**
   * Sets the value of the '{@link org.emftext.language.aspectbind.pointcuts.CFlowPointcut#getPointcut <em>Pointcut</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pointcut</em>' reference.
   * @see #getPointcut()
   * @generated
   */
  void setPointcut(Pointcut value);

} // CFlowPointcut
