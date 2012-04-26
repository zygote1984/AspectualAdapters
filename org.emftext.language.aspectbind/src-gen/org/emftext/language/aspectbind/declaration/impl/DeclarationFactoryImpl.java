/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.declaration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.aspectbind.declaration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeclarationFactoryImpl extends EFactoryImpl implements DeclarationFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static DeclarationFactory init() {
    try
    {
      DeclarationFactory theDeclarationFactory = (DeclarationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/bindingAspect/declaration"); 
      if (theDeclarationFactory != null)
      {
        return theDeclarationFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DeclarationFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public DeclarationFactoryImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public EObject create(EClass eClass) {
    switch (eClass.getClassifierID())
    {
      case DeclarationPackage.ADAPTER_DECLARATION: return createAdapterDeclaration();
      case DeclarationPackage.PRECEDENCE_DECLARATION: return createPrecedenceDeclaration();
      case DeclarationPackage.INTER_TYPE_DECLARATION: return createInterTypeDeclaration();
      case DeclarationPackage.ADAPTER: return createAdapter();
      case DeclarationPackage.ADAPTEE: return createAdaptee();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AdapterDeclaration createAdapterDeclaration() {
    AdapterDeclarationImpl adapterDeclaration = new AdapterDeclarationImpl();
    return adapterDeclaration;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PrecedenceDeclaration createPrecedenceDeclaration() {
    PrecedenceDeclarationImpl precedenceDeclaration = new PrecedenceDeclarationImpl();
    return precedenceDeclaration;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public InterTypeDeclaration createInterTypeDeclaration() {
    InterTypeDeclarationImpl interTypeDeclaration = new InterTypeDeclarationImpl();
    return interTypeDeclaration;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Adapter createAdapter() {
    AdapterImpl adapter = new AdapterImpl();
    return adapter;
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Adaptee createAdaptee()
  {
    AdapteeImpl adaptee = new AdapteeImpl();
    return adaptee;
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public DeclarationPackage getDeclarationPackage() {
    return (DeclarationPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static DeclarationPackage getPackage() {
    return DeclarationPackage.eINSTANCE;
  }

} //DeclarationFactoryImpl
