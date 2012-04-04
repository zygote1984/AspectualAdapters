/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pcexp;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.emftext.language.aspectbind.commons.CommonsPackage;
import org.emftext.language.java.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.pcexp.PcexpFactory
 * @model kind="package"
 * @generated
 */
public interface PcexpPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "pcexp";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.emftext.org/language/bindingAspect/pcexp";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "pcexp";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PcexpPackage eINSTANCE = org.emftext.language.aspectbind.pcexp.impl.PcexpPackageImpl.init();

  /**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionImpl <em>Pointcut Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionImpl
   * @see org.emftext.language.aspectbind.pcexp.impl.PcexpPackageImpl#getPointcutExpression()
   * @generated
   */
  int POINTCUT_EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT_EXPRESSION__COMMENTS = CommonsPackage.ASPECT_MEMBER__COMMENTS;

  /**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT_EXPRESSION__NAMESPACES = CommonsPackage.ASPECT_MEMBER__NAMESPACES;

  /**
   * The feature id for the '<em><b>Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT_EXPRESSION__CHILD = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression If</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT_EXPRESSION__EXPRESSION_IF = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expression Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT_EXPRESSION__EXPRESSION_ELSE = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT_EXPRESSION__CHILDREN = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Pointcut Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT_EXPRESSION_FEATURE_COUNT = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionTypeImpl <em>Pointcut Expression Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionTypeImpl
   * @see org.emftext.language.aspectbind.pcexp.impl.PcexpPackageImpl#getPointcutExpressionType()
   * @generated
   */
  int POINTCUT_EXPRESSION_TYPE = 1;

  /**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT_EXPRESSION_TYPE__COMMENTS = ExpressionsPackage.CONDITIONAL_EXPRESSION_CHILD__COMMENTS;

  /**
   * The number of structural features of the '<em>Pointcut Expression Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POINTCUT_EXPRESSION_TYPE_FEATURE_COUNT = ExpressionsPackage.CONDITIONAL_EXPRESSION_CHILD_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pcexp.PointcutExpression <em>Pointcut Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pointcut Expression</em>'.
   * @see org.emftext.language.aspectbind.pcexp.PointcutExpression
   * @generated
   */
  EClass getPointcutExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.aspectbind.pcexp.PointcutExpression#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.emftext.language.aspectbind.pcexp.PointcutExpression#getChildren()
   * @see #getPointcutExpression()
   * @generated
   */
  EReference getPointcutExpression_Children();

  /**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pcexp.PointcutExpressionType <em>Pointcut Expression Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pointcut Expression Type</em>'.
   * @see org.emftext.language.aspectbind.pcexp.PointcutExpressionType
   * @generated
   */
  EClass getPointcutExpressionType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PcexpFactory getPcexpFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionImpl <em>Pointcut Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionImpl
     * @see org.emftext.language.aspectbind.pcexp.impl.PcexpPackageImpl#getPointcutExpression()
     * @generated
     */
    EClass POINTCUT_EXPRESSION = eINSTANCE.getPointcutExpression();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POINTCUT_EXPRESSION__CHILDREN = eINSTANCE.getPointcutExpression_Children();

    /**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionTypeImpl <em>Pointcut Expression Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionTypeImpl
     * @see org.emftext.language.aspectbind.pcexp.impl.PcexpPackageImpl#getPointcutExpressionType()
     * @generated
     */
    EClass POINTCUT_EXPRESSION_TYPE = eINSTANCE.getPointcutExpressionType();

  }

} //PcexpPackage
