/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.emftext.language.aspectbind.commons.CommonsPackage;

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
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsFactory
 * @model kind="package"
 * @generated
 */
public interface PointcutsPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "pointcuts";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.emftext.org/language/bindingAspect/pointcuts";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "pointcuts";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	PointcutsPackage eINSTANCE = org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl.init();

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.PrimitivePointcutImpl <em>Primitive Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.PrimitivePointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getPrimitivePointcut()
   * @generated
   */
	int PRIMITIVE_POINTCUT = 0;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRIMITIVE_POINTCUT__COMMENTS = CommonsPackage.ASPECT_MEMBER__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRIMITIVE_POINTCUT__NAMESPACES = CommonsPackage.ASPECT_MEMBER__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRIMITIVE_POINTCUT__PATTERN = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Primitive Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRIMITIVE_POINTCUT_FEATURE_COUNT = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.CallPointcutImpl <em>Call Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.CallPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getCallPointcut()
   * @generated
   */
	int CALL_POINTCUT = 1;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CALL_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CALL_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CALL_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Call Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CALL_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.ExecutionPointcutImpl <em>Execution Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.ExecutionPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getExecutionPointcut()
   * @generated
   */
	int EXECUTION_POINTCUT = 2;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXECUTION_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXECUTION_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXECUTION_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Execution Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXECUTION_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.GetPointcutImpl <em>Get Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.GetPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getGetPointcut()
   * @generated
   */
	int GET_POINTCUT = 3;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GET_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GET_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GET_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Get Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GET_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.SetPointcutImpl <em>Set Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.SetPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getSetPointcut()
   * @generated
   */
	int SET_POINTCUT = 4;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SET_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SET_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SET_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Set Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SET_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.HandlerPointcutImpl <em>Handler Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.HandlerPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getHandlerPointcut()
   * @generated
   */
	int HANDLER_POINTCUT = 5;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int HANDLER_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int HANDLER_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int HANDLER_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Handler Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int HANDLER_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.AdviceExecutionPointcutImpl <em>Advice Execution Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.AdviceExecutionPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getAdviceExecutionPointcut()
   * @generated
   */
	int ADVICE_EXECUTION_POINTCUT = 6;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADVICE_EXECUTION_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADVICE_EXECUTION_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADVICE_EXECUTION_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Advice Execution Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADVICE_EXECUTION_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.StaticInitPointcutImpl <em>Static Init Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.StaticInitPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getStaticInitPointcut()
   * @generated
   */
	int STATIC_INIT_POINTCUT = 7;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STATIC_INIT_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STATIC_INIT_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STATIC_INIT_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Static Init Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STATIC_INIT_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.InitPointcutImpl <em>Init Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.InitPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getInitPointcut()
   * @generated
   */
	int INIT_POINTCUT = 8;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INIT_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INIT_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INIT_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Init Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INIT_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.PreInitPointcutImpl <em>Pre Init Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.PreInitPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getPreInitPointcut()
   * @generated
   */
	int PRE_INIT_POINTCUT = 9;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRE_INIT_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRE_INIT_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRE_INIT_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Pre Init Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRE_INIT_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.WithinPointcutImpl <em>Within Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.WithinPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getWithinPointcut()
   * @generated
   */
	int WITHIN_POINTCUT = 10;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WITHIN_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WITHIN_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WITHIN_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Within Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WITHIN_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.WithinCodePointcutImpl <em>Within Code Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.WithinCodePointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getWithinCodePointcut()
   * @generated
   */
	int WITHIN_CODE_POINTCUT = 11;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WITHIN_CODE_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WITHIN_CODE_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WITHIN_CODE_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Within Code Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WITHIN_CODE_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.ThisPointcutImpl <em>This Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.ThisPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getThisPointcut()
   * @generated
   */
	int THIS_POINTCUT = 12;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int THIS_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int THIS_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int THIS_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>This Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int THIS_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.TargetPointcutImpl <em>Target Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.TargetPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getTargetPointcut()
   * @generated
   */
	int TARGET_POINTCUT = 13;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TARGET_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TARGET_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TARGET_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Target Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TARGET_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.ArgsPointcutImpl <em>Args Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.ArgsPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getArgsPointcut()
   * @generated
   */
	int ARGS_POINTCUT = 14;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ARGS_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ARGS_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ARGS_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The number of structural features of the '<em>Args Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ARGS_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.CFlowPointcutImpl <em>CFlow Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.CFlowPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getCFlowPointcut()
   * @generated
   */
	int CFLOW_POINTCUT = 15;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CFLOW_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CFLOW_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CFLOW_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The feature id for the '<em><b>Pointcut</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CFLOW_POINTCUT__POINTCUT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>CFlow Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CFLOW_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.CFlowBelowPointcutImpl <em>CFlow Below Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.CFlowBelowPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getCFlowBelowPointcut()
   * @generated
   */
	int CFLOW_BELOW_POINTCUT = 16;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CFLOW_BELOW_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CFLOW_BELOW_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CFLOW_BELOW_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The feature id for the '<em><b>Pointcut</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CFLOW_BELOW_POINTCUT__POINTCUT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>CFlow Below Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CFLOW_BELOW_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.IfPointcutImpl <em>If Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.IfPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getIfPointcut()
   * @generated
   */
	int IF_POINTCUT = 17;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_POINTCUT__COMMENTS = PRIMITIVE_POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_POINTCUT__NAMESPACES = PRIMITIVE_POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_POINTCUT__PATTERN = PRIMITIVE_POINTCUT__PATTERN;

	/**
   * The feature id for the '<em><b>Exp</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_POINTCUT__EXP = PRIMITIVE_POINTCUT_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>If Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_POINTCUT_FEATURE_COUNT = PRIMITIVE_POINTCUT_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl <em>Pointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getPointcut()
   * @generated
   */
	int POINTCUT = 18;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int POINTCUT__COMMENTS = CommonsPackage.ASPECT_MEMBER__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int POINTCUT__NAMESPACES = CommonsPackage.ASPECT_MEMBER__NAMESPACES;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int POINTCUT__NAME = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Abstract</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int POINTCUT__ABSTRACT = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Assign</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int POINTCUT__ASSIGN = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int POINTCUT__EXP = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 3;

	/**
   * The number of structural features of the '<em>Pointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int POINTCUT_FEATURE_COUNT = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 4;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.pointcuts.impl.AspectJPointcutImpl <em>Aspect JPointcut</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.pointcuts.impl.AspectJPointcutImpl
   * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getAspectJPointcut()
   * @generated
   */
	int ASPECT_JPOINTCUT = 19;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASPECT_JPOINTCUT__COMMENTS = POINTCUT__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASPECT_JPOINTCUT__NAMESPACES = POINTCUT__NAMESPACES;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASPECT_JPOINTCUT__NAME = POINTCUT__NAME;

	/**
   * The feature id for the '<em><b>Abstract</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASPECT_JPOINTCUT__ABSTRACT = POINTCUT__ABSTRACT;

	/**
   * The feature id for the '<em><b>Assign</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASPECT_JPOINTCUT__ASSIGN = POINTCUT__ASSIGN;

	/**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASPECT_JPOINTCUT__EXP = POINTCUT__EXP;

	/**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASPECT_JPOINTCUT__PARAMETERS = POINTCUT_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Aspect JPointcut</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASPECT_JPOINTCUT_FEATURE_COUNT = POINTCUT_FEATURE_COUNT + 1;


	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.PrimitivePointcut <em>Primitive Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.PrimitivePointcut
   * @generated
   */
	EClass getPrimitivePointcut();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.pointcuts.PrimitivePointcut#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pattern</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.PrimitivePointcut#getPattern()
   * @see #getPrimitivePointcut()
   * @generated
   */
	EReference getPrimitivePointcut_Pattern();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.CallPointcut <em>Call Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.CallPointcut
   * @generated
   */
	EClass getCallPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.ExecutionPointcut <em>Execution Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Execution Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.ExecutionPointcut
   * @generated
   */
	EClass getExecutionPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.GetPointcut <em>Get Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Get Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.GetPointcut
   * @generated
   */
	EClass getGetPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.SetPointcut <em>Set Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Set Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.SetPointcut
   * @generated
   */
	EClass getSetPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.HandlerPointcut <em>Handler Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Handler Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.HandlerPointcut
   * @generated
   */
	EClass getHandlerPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.AdviceExecutionPointcut <em>Advice Execution Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Advice Execution Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.AdviceExecutionPointcut
   * @generated
   */
	EClass getAdviceExecutionPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.StaticInitPointcut <em>Static Init Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Static Init Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.StaticInitPointcut
   * @generated
   */
	EClass getStaticInitPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.InitPointcut <em>Init Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.InitPointcut
   * @generated
   */
	EClass getInitPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.PreInitPointcut <em>Pre Init Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pre Init Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.PreInitPointcut
   * @generated
   */
	EClass getPreInitPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.WithinPointcut <em>Within Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Within Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.WithinPointcut
   * @generated
   */
	EClass getWithinPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.WithinCodePointcut <em>Within Code Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Within Code Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.WithinCodePointcut
   * @generated
   */
	EClass getWithinCodePointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.ThisPointcut <em>This Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>This Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.ThisPointcut
   * @generated
   */
	EClass getThisPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.TargetPointcut <em>Target Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Target Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.TargetPointcut
   * @generated
   */
	EClass getTargetPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.ArgsPointcut <em>Args Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Args Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.ArgsPointcut
   * @generated
   */
	EClass getArgsPointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.CFlowPointcut <em>CFlow Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>CFlow Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.CFlowPointcut
   * @generated
   */
	EClass getCFlowPointcut();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.aspectbind.pointcuts.CFlowPointcut#getPointcut <em>Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.CFlowPointcut#getPointcut()
   * @see #getCFlowPointcut()
   * @generated
   */
	EReference getCFlowPointcut_Pointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.CFlowBelowPointcut <em>CFlow Below Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>CFlow Below Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.CFlowBelowPointcut
   * @generated
   */
	EClass getCFlowBelowPointcut();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.aspectbind.pointcuts.CFlowBelowPointcut#getPointcut <em>Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.CFlowBelowPointcut#getPointcut()
   * @see #getCFlowBelowPointcut()
   * @generated
   */
	EReference getCFlowBelowPointcut_Pointcut();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.IfPointcut <em>If Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.IfPointcut
   * @generated
   */
	EClass getIfPointcut();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.aspectbind.pointcuts.IfPointcut#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Exp</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.IfPointcut#getExp()
   * @see #getIfPointcut()
   * @generated
   */
	EReference getIfPointcut_Exp();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.Pointcut <em>Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.Pointcut
   * @generated
   */
	EClass getPointcut();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Abstract</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.Pointcut#getAbstract()
   * @see #getPointcut()
   * @generated
   */
	EReference getPointcut_Abstract();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getAssign <em>Assign</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assign</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.Pointcut#getAssign()
   * @see #getPointcut()
   * @generated
   */
	EReference getPointcut_Assign();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.pointcuts.Pointcut#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.Pointcut#getExp()
   * @see #getPointcut()
   * @generated
   */
	EReference getPointcut_Exp();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.pointcuts.AspectJPointcut <em>Aspect JPointcut</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aspect JPointcut</em>'.
   * @see org.emftext.language.aspectbind.pointcuts.AspectJPointcut
   * @generated
   */
	EClass getAspectJPointcut();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	PointcutsFactory getPointcutsFactory();

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
	interface Literals {
		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.PrimitivePointcutImpl <em>Primitive Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.PrimitivePointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getPrimitivePointcut()
     * @generated
     */
		EClass PRIMITIVE_POINTCUT = eINSTANCE.getPrimitivePointcut();

		/**
     * The meta object literal for the '<em><b>Pattern</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference PRIMITIVE_POINTCUT__PATTERN = eINSTANCE.getPrimitivePointcut_Pattern();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.CallPointcutImpl <em>Call Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.CallPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getCallPointcut()
     * @generated
     */
		EClass CALL_POINTCUT = eINSTANCE.getCallPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.ExecutionPointcutImpl <em>Execution Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.ExecutionPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getExecutionPointcut()
     * @generated
     */
		EClass EXECUTION_POINTCUT = eINSTANCE.getExecutionPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.GetPointcutImpl <em>Get Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.GetPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getGetPointcut()
     * @generated
     */
		EClass GET_POINTCUT = eINSTANCE.getGetPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.SetPointcutImpl <em>Set Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.SetPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getSetPointcut()
     * @generated
     */
		EClass SET_POINTCUT = eINSTANCE.getSetPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.HandlerPointcutImpl <em>Handler Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.HandlerPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getHandlerPointcut()
     * @generated
     */
		EClass HANDLER_POINTCUT = eINSTANCE.getHandlerPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.AdviceExecutionPointcutImpl <em>Advice Execution Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.AdviceExecutionPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getAdviceExecutionPointcut()
     * @generated
     */
		EClass ADVICE_EXECUTION_POINTCUT = eINSTANCE.getAdviceExecutionPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.StaticInitPointcutImpl <em>Static Init Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.StaticInitPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getStaticInitPointcut()
     * @generated
     */
		EClass STATIC_INIT_POINTCUT = eINSTANCE.getStaticInitPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.InitPointcutImpl <em>Init Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.InitPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getInitPointcut()
     * @generated
     */
		EClass INIT_POINTCUT = eINSTANCE.getInitPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.PreInitPointcutImpl <em>Pre Init Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.PreInitPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getPreInitPointcut()
     * @generated
     */
		EClass PRE_INIT_POINTCUT = eINSTANCE.getPreInitPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.WithinPointcutImpl <em>Within Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.WithinPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getWithinPointcut()
     * @generated
     */
		EClass WITHIN_POINTCUT = eINSTANCE.getWithinPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.WithinCodePointcutImpl <em>Within Code Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.WithinCodePointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getWithinCodePointcut()
     * @generated
     */
		EClass WITHIN_CODE_POINTCUT = eINSTANCE.getWithinCodePointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.ThisPointcutImpl <em>This Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.ThisPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getThisPointcut()
     * @generated
     */
		EClass THIS_POINTCUT = eINSTANCE.getThisPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.TargetPointcutImpl <em>Target Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.TargetPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getTargetPointcut()
     * @generated
     */
		EClass TARGET_POINTCUT = eINSTANCE.getTargetPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.ArgsPointcutImpl <em>Args Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.ArgsPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getArgsPointcut()
     * @generated
     */
		EClass ARGS_POINTCUT = eINSTANCE.getArgsPointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.CFlowPointcutImpl <em>CFlow Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.CFlowPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getCFlowPointcut()
     * @generated
     */
		EClass CFLOW_POINTCUT = eINSTANCE.getCFlowPointcut();

		/**
     * The meta object literal for the '<em><b>Pointcut</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CFLOW_POINTCUT__POINTCUT = eINSTANCE.getCFlowPointcut_Pointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.CFlowBelowPointcutImpl <em>CFlow Below Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.CFlowBelowPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getCFlowBelowPointcut()
     * @generated
     */
		EClass CFLOW_BELOW_POINTCUT = eINSTANCE.getCFlowBelowPointcut();

		/**
     * The meta object literal for the '<em><b>Pointcut</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CFLOW_BELOW_POINTCUT__POINTCUT = eINSTANCE.getCFlowBelowPointcut_Pointcut();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.IfPointcutImpl <em>If Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.IfPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getIfPointcut()
     * @generated
     */
		EClass IF_POINTCUT = eINSTANCE.getIfPointcut();

		/**
     * The meta object literal for the '<em><b>Exp</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference IF_POINTCUT__EXP = eINSTANCE.getIfPointcut_Exp();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl <em>Pointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getPointcut()
     * @generated
     */
		EClass POINTCUT = eINSTANCE.getPointcut();

		/**
     * The meta object literal for the '<em><b>Abstract</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference POINTCUT__ABSTRACT = eINSTANCE.getPointcut_Abstract();

		/**
     * The meta object literal for the '<em><b>Assign</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference POINTCUT__ASSIGN = eINSTANCE.getPointcut_Assign();

		/**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference POINTCUT__EXP = eINSTANCE.getPointcut_Exp();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.pointcuts.impl.AspectJPointcutImpl <em>Aspect JPointcut</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.pointcuts.impl.AspectJPointcutImpl
     * @see org.emftext.language.aspectbind.pointcuts.impl.PointcutsPackageImpl#getAspectJPointcut()
     * @generated
     */
		EClass ASPECT_JPOINTCUT = eINSTANCE.getAspectJPointcut();

	}

} //PointcutsPackage
