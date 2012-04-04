/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.commons;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.emftext.language.java.containers.ContainersPackage;

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
 * @see org.emftext.language.aspectbind.commons.CommonsFactory
 * @model kind="package"
 * @generated
 */
public interface CommonsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "commons";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.emftext.org/language/bindingAspect/commons";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "commons";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CommonsPackage eINSTANCE = org.emftext.language.aspectbind.commons.impl.CommonsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.emftext.language.aspectbind.commons.impl.AspectMemberImpl <em>Aspect Member</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.commons.impl.AspectMemberImpl
   * @see org.emftext.language.aspectbind.commons.impl.CommonsPackageImpl#getAspectMember()
   * @generated
   */
  int ASPECT_MEMBER = 0;

  /**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT_MEMBER__COMMENTS = org.emftext.language.java.commons.CommonsPackage.NAMESPACE_AWARE_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT_MEMBER__NAMESPACES = org.emftext.language.java.commons.CommonsPackage.NAMESPACE_AWARE_ELEMENT__NAMESPACES;

  /**
   * The number of structural features of the '<em>Aspect Member</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT_MEMBER_FEATURE_COUNT = org.emftext.language.java.commons.CommonsPackage.NAMESPACE_AWARE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.emftext.language.aspectbind.commons.impl.AspectImpl <em>Aspect</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.commons.impl.AspectImpl
   * @see org.emftext.language.aspectbind.commons.impl.CommonsPackageImpl#getAspect()
   * @generated
   */
  int ASPECT = 1;

  /**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__COMMENTS = ContainersPackage.COMPILATION_UNIT__COMMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__NAME = ContainersPackage.COMPILATION_UNIT__NAME;

  /**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__NAMESPACES = ContainersPackage.COMPILATION_UNIT__NAMESPACES;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__IMPORTS = ContainersPackage.COMPILATION_UNIT__IMPORTS;

  /**
   * The feature id for the '<em><b>Classifiers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__CLASSIFIERS = ContainersPackage.COMPILATION_UNIT__CLASSIFIERS;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__MEMBERS = ContainersPackage.COMPILATION_UNIT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Package</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__PACKAGE = ContainersPackage.COMPILATION_UNIT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Priviliged</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__PRIVILIGED = ContainersPackage.COMPILATION_UNIT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__MODIFIER = ContainersPackage.COMPILATION_UNIT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Extend</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__EXTEND = ContainersPackage.COMPILATION_UNIT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Implement</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__IMPLEMENT = ContainersPackage.COMPILATION_UNIT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Perclause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT__PERCLAUSE = ContainersPackage.COMPILATION_UNIT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Aspect</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASPECT_FEATURE_COUNT = ContainersPackage.COMPILATION_UNIT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.emftext.language.aspectbind.commons.impl.PerClauseImpl <em>Per Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.commons.impl.PerClauseImpl
   * @see org.emftext.language.aspectbind.commons.impl.CommonsPackageImpl#getPerClause()
   * @generated
   */
  int PER_CLAUSE = 2;

  /**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PER_CLAUSE__COMMENTS = org.emftext.language.java.commons.CommonsPackage.COMMENTABLE__COMMENTS;

  /**
   * The feature id for the '<em><b>Clause</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PER_CLAUSE__CLAUSE = org.emftext.language.java.commons.CommonsPackage.COMMENTABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Pointcut</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PER_CLAUSE__POINTCUT = org.emftext.language.java.commons.CommonsPackage.COMMENTABLE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Per Clause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PER_CLAUSE_FEATURE_COUNT = org.emftext.language.java.commons.CommonsPackage.COMMENTABLE_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.commons.AspectMember <em>Aspect Member</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aspect Member</em>'.
   * @see org.emftext.language.aspectbind.commons.AspectMember
   * @generated
   */
  EClass getAspectMember();

  /**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.commons.Aspect <em>Aspect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aspect</em>'.
   * @see org.emftext.language.aspectbind.commons.Aspect
   * @generated
   */
  EClass getAspect();

  /**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.aspectbind.commons.Aspect#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see org.emftext.language.aspectbind.commons.Aspect#getMembers()
   * @see #getAspect()
   * @generated
   */
  EReference getAspect_Members();

  /**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.commons.Aspect#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Package</em>'.
   * @see org.emftext.language.aspectbind.commons.Aspect#getPackage()
   * @see #getAspect()
   * @generated
   */
  EReference getAspect_Package();

  /**
   * Returns the meta object for the attribute '{@link org.emftext.language.aspectbind.commons.Aspect#isPriviliged <em>Priviliged</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priviliged</em>'.
   * @see org.emftext.language.aspectbind.commons.Aspect#isPriviliged()
   * @see #getAspect()
   * @generated
   */
  EAttribute getAspect_Priviliged();

  /**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.aspectbind.commons.Aspect#getModifier <em>Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modifier</em>'.
   * @see org.emftext.language.aspectbind.commons.Aspect#getModifier()
   * @see #getAspect()
   * @generated
   */
  EReference getAspect_Modifier();

  /**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.commons.Aspect#getExtend <em>Extend</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Extend</em>'.
   * @see org.emftext.language.aspectbind.commons.Aspect#getExtend()
   * @see #getAspect()
   * @generated
   */
  EReference getAspect_Extend();

  /**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.aspectbind.commons.Aspect#getImplement <em>Implement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Implement</em>'.
   * @see org.emftext.language.aspectbind.commons.Aspect#getImplement()
   * @see #getAspect()
   * @generated
   */
  EReference getAspect_Implement();

  /**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.commons.Aspect#getPerclause <em>Perclause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Perclause</em>'.
   * @see org.emftext.language.aspectbind.commons.Aspect#getPerclause()
   * @see #getAspect()
   * @generated
   */
  EReference getAspect_Perclause();

  /**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.commons.PerClause <em>Per Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Per Clause</em>'.
   * @see org.emftext.language.aspectbind.commons.PerClause
   * @generated
   */
  EClass getPerClause();

  /**
   * Returns the meta object for the attribute '{@link org.emftext.language.aspectbind.commons.PerClause#getClause <em>Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Clause</em>'.
   * @see org.emftext.language.aspectbind.commons.PerClause#getClause()
   * @see #getPerClause()
   * @generated
   */
  EAttribute getPerClause_Clause();

  /**
   * Returns the meta object for the reference '{@link org.emftext.language.aspectbind.commons.PerClause#getPointcut <em>Pointcut</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Pointcut</em>'.
   * @see org.emftext.language.aspectbind.commons.PerClause#getPointcut()
   * @see #getPerClause()
   * @generated
   */
  EReference getPerClause_Pointcut();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CommonsFactory getCommonsFactory();

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
     * The meta object literal for the '{@link org.emftext.language.aspectbind.commons.impl.AspectMemberImpl <em>Aspect Member</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.commons.impl.AspectMemberImpl
     * @see org.emftext.language.aspectbind.commons.impl.CommonsPackageImpl#getAspectMember()
     * @generated
     */
    EClass ASPECT_MEMBER = eINSTANCE.getAspectMember();

    /**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.commons.impl.AspectImpl <em>Aspect</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.commons.impl.AspectImpl
     * @see org.emftext.language.aspectbind.commons.impl.CommonsPackageImpl#getAspect()
     * @generated
     */
    EClass ASPECT = eINSTANCE.getAspect();

    /**
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASPECT__MEMBERS = eINSTANCE.getAspect_Members();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASPECT__PACKAGE = eINSTANCE.getAspect_Package();

    /**
     * The meta object literal for the '<em><b>Priviliged</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASPECT__PRIVILIGED = eINSTANCE.getAspect_Priviliged();

    /**
     * The meta object literal for the '<em><b>Modifier</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASPECT__MODIFIER = eINSTANCE.getAspect_Modifier();

    /**
     * The meta object literal for the '<em><b>Extend</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASPECT__EXTEND = eINSTANCE.getAspect_Extend();

    /**
     * The meta object literal for the '<em><b>Implement</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASPECT__IMPLEMENT = eINSTANCE.getAspect_Implement();

    /**
     * The meta object literal for the '<em><b>Perclause</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASPECT__PERCLAUSE = eINSTANCE.getAspect_Perclause();

    /**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.commons.impl.PerClauseImpl <em>Per Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.commons.impl.PerClauseImpl
     * @see org.emftext.language.aspectbind.commons.impl.CommonsPackageImpl#getPerClause()
     * @generated
     */
    EClass PER_CLAUSE = eINSTANCE.getPerClause();

    /**
     * The meta object literal for the '<em><b>Clause</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PER_CLAUSE__CLAUSE = eINSTANCE.getPerClause_Clause();

    /**
     * The meta object literal for the '<em><b>Pointcut</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PER_CLAUSE__POINTCUT = eINSTANCE.getPerClause_Pointcut();

  }

} //CommonsPackage
