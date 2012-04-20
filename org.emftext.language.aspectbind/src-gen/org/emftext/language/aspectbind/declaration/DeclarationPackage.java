/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.declaration;

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
 * @see org.emftext.language.aspectbind.declaration.DeclarationFactory
 * @model kind="package"
 * @generated
 */
public interface DeclarationPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "declaration";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.emftext.org/language/bindingAspect/declaration";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "declaration";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	DeclarationPackage eINSTANCE = org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl.init();

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.declaration.impl.DeclarationImpl <em>Declaration</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.declaration.impl.DeclarationImpl
   * @see org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl#getDeclaration()
   * @generated
   */
	int DECLARATION = 3;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DECLARATION__COMMENTS = CommonsPackage.ASPECT_MEMBER__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DECLARATION__NAMESPACES = CommonsPackage.ASPECT_MEMBER__NAMESPACES;

	/**
   * The number of structural features of the '<em>Declaration</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DECLARATION_FEATURE_COUNT = CommonsPackage.ASPECT_MEMBER_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.declaration.impl.AdapterDeclarationImpl <em>Adapter Declaration</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.declaration.impl.AdapterDeclarationImpl
   * @see org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl#getAdapterDeclaration()
   * @generated
   */
	int ADAPTER_DECLARATION = 0;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER_DECLARATION__COMMENTS = DECLARATION__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER_DECLARATION__NAMESPACES = DECLARATION__NAMESPACES;

	/**
   * The feature id for the '<em><b>Adapter</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER_DECLARATION__ADAPTER = DECLARATION_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Adaptee</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER_DECLARATION__ADAPTEE = DECLARATION_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER_DECLARATION__MEMBERS = DECLARATION_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Adaptee Sub</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER_DECLARATION__ADAPTEE_SUB = DECLARATION_FEATURE_COUNT + 3;

	/**
   * The number of structural features of the '<em>Adapter Declaration</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER_DECLARATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 4;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.declaration.impl.PrecedenceDeclarationImpl <em>Precedence Declaration</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.declaration.impl.PrecedenceDeclarationImpl
   * @see org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl#getPrecedenceDeclaration()
   * @generated
   */
	int PRECEDENCE_DECLARATION = 1;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRECEDENCE_DECLARATION__COMMENTS = DECLARATION__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRECEDENCE_DECLARATION__NAMESPACES = DECLARATION__NAMESPACES;

	/**
   * The number of structural features of the '<em>Precedence Declaration</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PRECEDENCE_DECLARATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.declaration.impl.InterTypeDeclarationImpl <em>Inter Type Declaration</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.declaration.impl.InterTypeDeclarationImpl
   * @see org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl#getInterTypeDeclaration()
   * @generated
   */
	int INTER_TYPE_DECLARATION = 2;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INTER_TYPE_DECLARATION__COMMENTS = DECLARATION__COMMENTS;

	/**
   * The feature id for the '<em><b>Namespaces</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INTER_TYPE_DECLARATION__NAMESPACES = DECLARATION__NAMESPACES;

	/**
   * The number of structural features of the '<em>Inter Type Declaration</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INTER_TYPE_DECLARATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.aspectbind.declaration.impl.AdapterImpl <em>Adapter</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.aspectbind.declaration.impl.AdapterImpl
   * @see org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl#getAdapter()
   * @generated
   */
	int ADAPTER = 4;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER__COMMENTS = org.emftext.language.java.commons.CommonsPackage.NAMED_ELEMENT__COMMENTS;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER__NAME = org.emftext.language.java.commons.CommonsPackage.NAMED_ELEMENT__NAME;

	/**
   * The feature id for the '<em><b>References</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER__REFERENCES = org.emftext.language.java.commons.CommonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Abstract</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER__ABSTRACT = org.emftext.language.java.commons.CommonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Extend</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER__EXTEND = org.emftext.language.java.commons.CommonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>Adapter</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ADAPTER_FEATURE_COUNT = org.emftext.language.java.commons.CommonsPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;


	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration <em>Adapter Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Adapter Declaration</em>'.
   * @see org.emftext.language.aspectbind.declaration.AdapterDeclaration
   * @generated
   */
	EClass getAdapterDeclaration();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdapter <em>Adapter</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Adapter</em>'.
   * @see org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdapter()
   * @see #getAdapterDeclaration()
   * @generated
   */
	EReference getAdapterDeclaration_Adapter();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdaptee <em>Adaptee</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Adaptee</em>'.
   * @see org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdaptee()
   * @see #getAdapterDeclaration()
   * @generated
   */
	EReference getAdapterDeclaration_Adaptee();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see org.emftext.language.aspectbind.declaration.AdapterDeclaration#getMembers()
   * @see #getAdapterDeclaration()
   * @generated
   */
	EReference getAdapterDeclaration_Members();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdapteeSub <em>Adaptee Sub</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Adaptee Sub</em>'.
   * @see org.emftext.language.aspectbind.declaration.AdapterDeclaration#getAdapteeSub()
   * @see #getAdapterDeclaration()
   * @generated
   */
	EReference getAdapterDeclaration_AdapteeSub();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.declaration.PrecedenceDeclaration <em>Precedence Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Precedence Declaration</em>'.
   * @see org.emftext.language.aspectbind.declaration.PrecedenceDeclaration
   * @generated
   */
	EClass getPrecedenceDeclaration();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.declaration.InterTypeDeclaration <em>Inter Type Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inter Type Declaration</em>'.
   * @see org.emftext.language.aspectbind.declaration.InterTypeDeclaration
   * @generated
   */
	EClass getInterTypeDeclaration();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.declaration.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration</em>'.
   * @see org.emftext.language.aspectbind.declaration.Declaration
   * @generated
   */
	EClass getDeclaration();

	/**
   * Returns the meta object for class '{@link org.emftext.language.aspectbind.declaration.Adapter <em>Adapter</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Adapter</em>'.
   * @see org.emftext.language.aspectbind.declaration.Adapter
   * @generated
   */
	EClass getAdapter();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.aspectbind.declaration.Adapter#getReferences <em>References</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>References</em>'.
   * @see org.emftext.language.aspectbind.declaration.Adapter#getReferences()
   * @see #getAdapter()
   * @generated
   */
	EReference getAdapter_References();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.declaration.Adapter#getAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Abstract</em>'.
   * @see org.emftext.language.aspectbind.declaration.Adapter#getAbstract()
   * @see #getAdapter()
   * @generated
   */
	EReference getAdapter_Abstract();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.aspectbind.declaration.Adapter#getExtend <em>Extend</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Extend</em>'.
   * @see org.emftext.language.aspectbind.declaration.Adapter#getExtend()
   * @see #getAdapter()
   * @generated
   */
	EReference getAdapter_Extend();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	DeclarationFactory getDeclarationFactory();

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
     * The meta object literal for the '{@link org.emftext.language.aspectbind.declaration.impl.AdapterDeclarationImpl <em>Adapter Declaration</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.declaration.impl.AdapterDeclarationImpl
     * @see org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl#getAdapterDeclaration()
     * @generated
     */
		EClass ADAPTER_DECLARATION = eINSTANCE.getAdapterDeclaration();

		/**
     * The meta object literal for the '<em><b>Adapter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ADAPTER_DECLARATION__ADAPTER = eINSTANCE.getAdapterDeclaration_Adapter();

		/**
     * The meta object literal for the '<em><b>Adaptee</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ADAPTER_DECLARATION__ADAPTEE = eINSTANCE.getAdapterDeclaration_Adaptee();

		/**
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ADAPTER_DECLARATION__MEMBERS = eINSTANCE.getAdapterDeclaration_Members();

		/**
     * The meta object literal for the '<em><b>Adaptee Sub</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ADAPTER_DECLARATION__ADAPTEE_SUB = eINSTANCE.getAdapterDeclaration_AdapteeSub();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.declaration.impl.PrecedenceDeclarationImpl <em>Precedence Declaration</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.declaration.impl.PrecedenceDeclarationImpl
     * @see org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl#getPrecedenceDeclaration()
     * @generated
     */
		EClass PRECEDENCE_DECLARATION = eINSTANCE.getPrecedenceDeclaration();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.declaration.impl.InterTypeDeclarationImpl <em>Inter Type Declaration</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.declaration.impl.InterTypeDeclarationImpl
     * @see org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl#getInterTypeDeclaration()
     * @generated
     */
		EClass INTER_TYPE_DECLARATION = eINSTANCE.getInterTypeDeclaration();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.declaration.impl.DeclarationImpl <em>Declaration</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.declaration.impl.DeclarationImpl
     * @see org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl#getDeclaration()
     * @generated
     */
		EClass DECLARATION = eINSTANCE.getDeclaration();

		/**
     * The meta object literal for the '{@link org.emftext.language.aspectbind.declaration.impl.AdapterImpl <em>Adapter</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.aspectbind.declaration.impl.AdapterImpl
     * @see org.emftext.language.aspectbind.declaration.impl.DeclarationPackageImpl#getAdapter()
     * @generated
     */
		EClass ADAPTER = eINSTANCE.getAdapter();

		/**
     * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ADAPTER__REFERENCES = eINSTANCE.getAdapter_References();

		/**
     * The meta object literal for the '<em><b>Abstract</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ADAPTER__ABSTRACT = eINSTANCE.getAdapter_Abstract();

		/**
     * The meta object literal for the '<em><b>Extend</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ADAPTER__EXTEND = eINSTANCE.getAdapter_Extend();

	}

} //DeclarationPackage
