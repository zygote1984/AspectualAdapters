/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.binding;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;

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
 * @see org.emftext.language.aspectbind.binding.BindingFactory
 * @model kind="package"
 * @generated
 */
public interface BindingPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "binding";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.emftext.org/language/bindingAspect/binding";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "binding";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BindingPackage eINSTANCE = org.emftext.language.aspectbind.binding.impl.BindingPackageImpl.init();

  /**
   * The meta object id for the '{@link org.emftext.language.aspectbind.binding.impl.InstancePointcutImpl <em>Instance Pointcut</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.binding.impl.InstancePointcutImpl
   * @see org.emftext.language.aspectbind.binding.impl.BindingPackageImpl#getInstancePointcut()
   * @generated
   */
  int INSTANCE_POINTCUT = 0;

  /**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_POINTCUT__COMMENTS = PointcutsPackage.POINTCUT__COMMENTS;

  /**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_POINTCUT__NAMESPACES = PointcutsPackage.POINTCUT__NAMESPACES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_POINTCUT__NAME = PointcutsPackage.POINTCUT__NAME;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_POINTCUT__EXP = PointcutsPackage.POINTCUT__EXP;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_POINTCUT__ABSTRACT = PointcutsPackage.POINTCUT__ABSTRACT;

  /**
   * The feature id for the '<em><b>Assign</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_POINTCUT__ASSIGN = PointcutsPackage.POINTCUT__ASSIGN;

  /**
   * The feature id for the '<em><b>Instance Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_POINTCUT__INSTANCE_TYPE = PointcutsPackage.POINTCUT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Instance Pointcut</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_POINTCUT_FEATURE_COUNT = PointcutsPackage.POINTCUT_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.binding.InstancePointcut <em>Instance Pointcut</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance Pointcut</em>'.
   * @see org.emftext.language.aspectbind.binding.InstancePointcut
   * @generated
   */
  EClass getInstancePointcut();

  /**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.binding.InstancePointcut#getInstanceType <em>Instance Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Instance Type</em>'.
   * @see org.emftext.language.aspectbind.binding.InstancePointcut#getInstanceType()
   * @see #getInstancePointcut()
   * @generated
   */
  EReference getInstancePointcut_InstanceType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  BindingFactory getBindingFactory();

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
     * The meta object literal for the '{@link org.emftext.language.aspectbind.binding.impl.InstancePointcutImpl <em>Instance Pointcut</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.binding.impl.InstancePointcutImpl
     * @see org.emftext.language.aspectbind.binding.impl.BindingPackageImpl#getInstancePointcut()
     * @generated
     */
    EClass INSTANCE_POINTCUT = eINSTANCE.getInstancePointcut();

    /**
     * The meta object literal for the '<em><b>Instance Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_POINTCUT__INSTANCE_TYPE = eINSTANCE.getInstancePointcut_InstanceType();

  }

} //BindingPackage
