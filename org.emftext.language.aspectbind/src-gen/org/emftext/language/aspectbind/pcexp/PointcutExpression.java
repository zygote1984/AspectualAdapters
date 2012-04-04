/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pcexp;

import org.eclipse.emf.common.util.EList;

import org.emftext.language.aspectbind.commons.AspectMember;

import org.emftext.language.java.expressions.ConditionalExpression;
import org.emftext.language.java.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pointcut Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pcexp.PointcutExpression#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.aspectbind.pcexp.PcexpPackage#getPointcutExpression()
 * @model
 * @generated
 */
public interface PointcutExpression extends AspectMember, ConditionalExpression
{
  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.aspectbind.pcexp.PointcutExpressionType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see org.emftext.language.aspectbind.pcexp.PcexpPackage#getPointcutExpression_Children()
   * @model containment="true" required="true"
   * @generated
   */
  EList<PointcutExpressionType> getChildren();

} // PointcutExpression
