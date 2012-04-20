/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.patterns;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.emftext.language.java.commons.CommonsPackage;

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
 * @see org.emftext.language.aspectbind.patterns.PatternsFactory
 * @model kind="package"
 * @generated
 */
public interface PatternsPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "patterns";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.emftext.org/language/bindingAspect/patterns";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "patterns";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	PatternsPackage eINSTANCE = org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl.init();

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.patterns.impl.PatternImpl <em>Pattern</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.patterns.impl.PatternImpl
   * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getPattern()
   * @generated
   */
	int PATTERN = 0;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PATTERN__COMMENTS = CommonsPackage.COMMENTABLE__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PATTERN__NAMESPACES = CommonsPackage.COMMENTABLE_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Pattern</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PATTERN_FEATURE_COUNT = CommonsPackage.COMMENTABLE_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.patterns.impl.AbstractMethodPatternImpl <em>Abstract Method Pattern</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.patterns.impl.AbstractMethodPatternImpl
   * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getAbstractMethodPattern()
   * @generated
   */
	int ABSTRACT_METHOD_PATTERN = 1;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABSTRACT_METHOD_PATTERN__COMMENTS = PATTERN__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABSTRACT_METHOD_PATTERN__NAMESPACES = PATTERN__NAMESPACES;

	/**
   * The number of structural features of the '<em>Abstract Method Pattern</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABSTRACT_METHOD_PATTERN_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.patterns.impl.FieldPatternImpl <em>Field Pattern</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.patterns.impl.FieldPatternImpl
   * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getFieldPattern()
   * @generated
   */
	int FIELD_PATTERN = 2;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FIELD_PATTERN__COMMENTS = PATTERN__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FIELD_PATTERN__NAMESPACES = PATTERN__NAMESPACES;

	/**
   * The feature id for the '<em><b>Modifiers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FIELD_PATTERN__MODIFIERS = PATTERN_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Declaring Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FIELD_PATTERN__DECLARING_TYPE = PATTERN_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Field Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FIELD_PATTERN__FIELD_TYPE = PATTERN_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FIELD_PATTERN__NAME = PATTERN_FEATURE_COUNT + 3;

	/**
   * The number of structural features of the '<em>Field Pattern</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FIELD_PATTERN_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 4;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.patterns.impl.ConstructorPatternImpl <em>Constructor Pattern</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.patterns.impl.ConstructorPatternImpl
   * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getConstructorPattern()
   * @generated
   */
	int CONSTRUCTOR_PATTERN = 3;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONSTRUCTOR_PATTERN__COMMENTS = ABSTRACT_METHOD_PATTERN__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONSTRUCTOR_PATTERN__NAMESPACES = ABSTRACT_METHOD_PATTERN__NAMESPACES;

	/**
   * The feature id for the '<em><b>Modifiers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONSTRUCTOR_PATTERN__MODIFIERS = ABSTRACT_METHOD_PATTERN_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Declaring Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONSTRUCTOR_PATTERN__DECLARING_TYPE = ABSTRACT_METHOD_PATTERN_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONSTRUCTOR_PATTERN__PARAMETERS = ABSTRACT_METHOD_PATTERN_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>Constructor Pattern</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONSTRUCTOR_PATTERN_FEATURE_COUNT = ABSTRACT_METHOD_PATTERN_FEATURE_COUNT + 3;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.patterns.impl.MethodPatternImpl <em>Method Pattern</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.patterns.impl.MethodPatternImpl
   * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getMethodPattern()
   * @generated
   */
	int METHOD_PATTERN = 4;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int METHOD_PATTERN__COMMENTS = ABSTRACT_METHOD_PATTERN__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int METHOD_PATTERN__NAMESPACES = ABSTRACT_METHOD_PATTERN__NAMESPACES;

	/**
   * The feature id for the '<em><b>Modifiers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int METHOD_PATTERN__MODIFIERS = ABSTRACT_METHOD_PATTERN_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int METHOD_PATTERN__RETURN_TYPE = ABSTRACT_METHOD_PATTERN_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int METHOD_PATTERN__NAME = ABSTRACT_METHOD_PATTERN_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Declaring Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int METHOD_PATTERN__DECLARING_TYPE = ABSTRACT_METHOD_PATTERN_FEATURE_COUNT + 3;

	/**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int METHOD_PATTERN__PARAMETERS = ABSTRACT_METHOD_PATTERN_FEATURE_COUNT + 4;

	/**
   * The number of structural features of the '<em>Method Pattern</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int METHOD_PATTERN_FEATURE_COUNT = ABSTRACT_METHOD_PATTERN_FEATURE_COUNT + 5;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.patterns.impl.TypeOrIdPatternImpl <em>Type Or Id Pattern</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.patterns.impl.TypeOrIdPatternImpl
   * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getTypeOrIdPattern()
   * @generated
   */
	int TYPE_OR_ID_PATTERN = 7;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPE_OR_ID_PATTERN__COMMENTS = PATTERN__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPE_OR_ID_PATTERN__NAMESPACES = PATTERN__NAMESPACES;

	/**
   * The number of structural features of the '<em>Type Or Id Pattern</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPE_OR_ID_PATTERN_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.patterns.impl.TypePatternImpl <em>Type Pattern</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.patterns.impl.TypePatternImpl
   * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getTypePattern()
   * @generated
   */
	int TYPE_PATTERN = 5;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPE_PATTERN__COMMENTS = TYPE_OR_ID_PATTERN__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPE_PATTERN__NAMESPACES = TYPE_OR_ID_PATTERN__NAMESPACES;

	/**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPE_PATTERN__TYPE = TYPE_OR_ID_PATTERN_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Type Pattern</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TYPE_PATTERN_FEATURE_COUNT = TYPE_OR_ID_PATTERN_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.patterns.impl.IdPatternImpl <em>Id Pattern</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.patterns.impl.IdPatternImpl
   * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getIdPattern()
   * @generated
   */
	int ID_PATTERN = 6;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ID_PATTERN__COMMENTS = TYPE_OR_ID_PATTERN__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ID_PATTERN__NAMESPACES = TYPE_OR_ID_PATTERN__NAMESPACES;

	/**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ID_PATTERN__ID = TYPE_OR_ID_PATTERN_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Id Pattern</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ID_PATTERN_FEATURE_COUNT = TYPE_OR_ID_PATTERN_FEATURE_COUNT + 1;


	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.patterns.Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern</em>'.
   * @see org.emftext.language.aspectbind.patterns.Pattern
   * @generated
   */
	EClass getPattern();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.patterns.AbstractMethodPattern <em>Abstract Method Pattern</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Method Pattern</em>'.
   * @see org.emftext.language.aspectbind.patterns.AbstractMethodPattern
   * @generated
   */
	EClass getAbstractMethodPattern();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.patterns.FieldPattern <em>Field Pattern</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Pattern</em>'.
   * @see org.emftext.language.aspectbind.patterns.FieldPattern
   * @generated
   */
	EClass getFieldPattern();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.aspectbind.patterns.FieldPattern#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modifiers</em>'.
   * @see org.emftext.language.aspectbind.patterns.FieldPattern#getModifiers()
   * @see #getFieldPattern()
   * @generated
   */
	EReference getFieldPattern_Modifiers();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.patterns.FieldPattern#getDeclaringType <em>Declaring Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declaring Type</em>'.
   * @see org.emftext.language.aspectbind.patterns.FieldPattern#getDeclaringType()
   * @see #getFieldPattern()
   * @generated
   */
	EReference getFieldPattern_DeclaringType();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.patterns.FieldPattern#getFieldType <em>Field Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Field Type</em>'.
   * @see org.emftext.language.aspectbind.patterns.FieldPattern#getFieldType()
   * @see #getFieldPattern()
   * @generated
   */
	EReference getFieldPattern_FieldType();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.aspectbind.patterns.FieldPattern#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.emftext.language.aspectbind.patterns.FieldPattern#getName()
   * @see #getFieldPattern()
   * @generated
   */
	EAttribute getFieldPattern_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.patterns.ConstructorPattern <em>Constructor Pattern</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constructor Pattern</em>'.
   * @see org.emftext.language.aspectbind.patterns.ConstructorPattern
   * @generated
   */
	EClass getConstructorPattern();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.aspectbind.patterns.ConstructorPattern#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modifiers</em>'.
   * @see org.emftext.language.aspectbind.patterns.ConstructorPattern#getModifiers()
   * @see #getConstructorPattern()
   * @generated
   */
	EReference getConstructorPattern_Modifiers();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.patterns.ConstructorPattern#getDeclaringType <em>Declaring Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declaring Type</em>'.
   * @see org.emftext.language.aspectbind.patterns.ConstructorPattern#getDeclaringType()
   * @see #getConstructorPattern()
   * @generated
   */
	EReference getConstructorPattern_DeclaringType();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.aspectbind.patterns.ConstructorPattern#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.emftext.language.aspectbind.patterns.ConstructorPattern#getParameters()
   * @see #getConstructorPattern()
   * @generated
   */
	EReference getConstructorPattern_Parameters();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.patterns.MethodPattern <em>Method Pattern</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Pattern</em>'.
   * @see org.emftext.language.aspectbind.patterns.MethodPattern
   * @generated
   */
	EClass getMethodPattern();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.aspectbind.patterns.MethodPattern#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modifiers</em>'.
   * @see org.emftext.language.aspectbind.patterns.MethodPattern#getModifiers()
   * @see #getMethodPattern()
   * @generated
   */
	EReference getMethodPattern_Modifiers();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.patterns.MethodPattern#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return Type</em>'.
   * @see org.emftext.language.aspectbind.patterns.MethodPattern#getReturnType()
   * @see #getMethodPattern()
   * @generated
   */
	EReference getMethodPattern_ReturnType();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.aspectbind.patterns.MethodPattern#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.emftext.language.aspectbind.patterns.MethodPattern#getName()
   * @see #getMethodPattern()
   * @generated
   */
	EAttribute getMethodPattern_Name();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.patterns.MethodPattern#getDeclaringType <em>Declaring Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declaring Type</em>'.
   * @see org.emftext.language.aspectbind.patterns.MethodPattern#getDeclaringType()
   * @see #getMethodPattern()
   * @generated
   */
	EReference getMethodPattern_DeclaringType();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.aspectbind.patterns.MethodPattern#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.emftext.language.aspectbind.patterns.MethodPattern#getParameters()
   * @see #getMethodPattern()
   * @generated
   */
	EReference getMethodPattern_Parameters();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.patterns.TypePattern <em>Type Pattern</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Pattern</em>'.
   * @see org.emftext.language.aspectbind.patterns.TypePattern
   * @generated
   */
	EClass getTypePattern();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.patterns.TypePattern#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.emftext.language.aspectbind.patterns.TypePattern#getType()
   * @see #getTypePattern()
   * @generated
   */
	EReference getTypePattern_Type();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.patterns.IdPattern <em>Id Pattern</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Id Pattern</em>'.
   * @see org.emftext.language.aspectbind.patterns.IdPattern
   * @generated
   */
	EClass getIdPattern();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.aspectbind.patterns.IdPattern#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see org.emftext.language.aspectbind.patterns.IdPattern#getId()
   * @see #getIdPattern()
   * @generated
   */
	EReference getIdPattern_Id();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.patterns.TypeOrIdPattern <em>Type Or Id Pattern</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Or Id Pattern</em>'.
   * @see org.emftext.language.aspectbind.patterns.TypeOrIdPattern
   * @generated
   */
	EClass getTypeOrIdPattern();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	PatternsFactory getPatternsFactory();

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
     * The meta object literal for the '{@link org.emftext.language.aspectbind.patterns.impl.PatternImpl <em>Pattern</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.patterns.impl.PatternImpl
     * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getPattern()
     * @generated
     */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.patterns.impl.AbstractMethodPatternImpl <em>Abstract Method Pattern</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.patterns.impl.AbstractMethodPatternImpl
     * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getAbstractMethodPattern()
     * @generated
     */
		EClass ABSTRACT_METHOD_PATTERN = eINSTANCE.getAbstractMethodPattern();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.patterns.impl.FieldPatternImpl <em>Field Pattern</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.patterns.impl.FieldPatternImpl
     * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getFieldPattern()
     * @generated
     */
		EClass FIELD_PATTERN = eINSTANCE.getFieldPattern();

		/**
     * The meta object literal for the '<em><b>Modifiers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference FIELD_PATTERN__MODIFIERS = eINSTANCE.getFieldPattern_Modifiers();

		/**
     * The meta object literal for the '<em><b>Declaring Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference FIELD_PATTERN__DECLARING_TYPE = eINSTANCE.getFieldPattern_DeclaringType();

		/**
     * The meta object literal for the '<em><b>Field Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference FIELD_PATTERN__FIELD_TYPE = eINSTANCE.getFieldPattern_FieldType();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute FIELD_PATTERN__NAME = eINSTANCE.getFieldPattern_Name();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.patterns.impl.ConstructorPatternImpl <em>Constructor Pattern</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.patterns.impl.ConstructorPatternImpl
     * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getConstructorPattern()
     * @generated
     */
		EClass CONSTRUCTOR_PATTERN = eINSTANCE.getConstructorPattern();

		/**
     * The meta object literal for the '<em><b>Modifiers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CONSTRUCTOR_PATTERN__MODIFIERS = eINSTANCE.getConstructorPattern_Modifiers();

		/**
     * The meta object literal for the '<em><b>Declaring Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CONSTRUCTOR_PATTERN__DECLARING_TYPE = eINSTANCE.getConstructorPattern_DeclaringType();

		/**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CONSTRUCTOR_PATTERN__PARAMETERS = eINSTANCE.getConstructorPattern_Parameters();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.patterns.impl.MethodPatternImpl <em>Method Pattern</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.patterns.impl.MethodPatternImpl
     * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getMethodPattern()
     * @generated
     */
		EClass METHOD_PATTERN = eINSTANCE.getMethodPattern();

		/**
     * The meta object literal for the '<em><b>Modifiers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference METHOD_PATTERN__MODIFIERS = eINSTANCE.getMethodPattern_Modifiers();

		/**
     * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference METHOD_PATTERN__RETURN_TYPE = eINSTANCE.getMethodPattern_ReturnType();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute METHOD_PATTERN__NAME = eINSTANCE.getMethodPattern_Name();

		/**
     * The meta object literal for the '<em><b>Declaring Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference METHOD_PATTERN__DECLARING_TYPE = eINSTANCE.getMethodPattern_DeclaringType();

		/**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference METHOD_PATTERN__PARAMETERS = eINSTANCE.getMethodPattern_Parameters();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.patterns.impl.TypePatternImpl <em>Type Pattern</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.patterns.impl.TypePatternImpl
     * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getTypePattern()
     * @generated
     */
		EClass TYPE_PATTERN = eINSTANCE.getTypePattern();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TYPE_PATTERN__TYPE = eINSTANCE.getTypePattern_Type();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.patterns.impl.IdPatternImpl <em>Id Pattern</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.patterns.impl.IdPatternImpl
     * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getIdPattern()
     * @generated
     */
		EClass ID_PATTERN = eINSTANCE.getIdPattern();

		/**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ID_PATTERN__ID = eINSTANCE.getIdPattern_Id();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.patterns.impl.TypeOrIdPatternImpl <em>Type Or Id Pattern</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.patterns.impl.TypeOrIdPatternImpl
     * @see org.emftext.language.aspectbind.patterns.impl.PatternsPackageImpl#getTypeOrIdPattern()
     * @generated
     */
		EClass TYPE_OR_ID_PATTERN = eINSTANCE.getTypeOrIdPattern();

	}

} //PatternsPackage
