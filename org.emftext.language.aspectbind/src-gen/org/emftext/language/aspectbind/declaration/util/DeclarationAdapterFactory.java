/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.declaration.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.aspectbind.commons.AspectMember;

import org.emftext.language.aspectbind.declaration.*;

import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.commons.NamespaceAwareElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.declaration.DeclarationPackage
 * @generated
 */
public class DeclarationAdapterFactory extends AdapterFactoryImpl {
	/**
   * The cached model package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static DeclarationPackage modelPackage;

	/**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public DeclarationAdapterFactory() {
    if (modelPackage == null)
    {
      modelPackage = DeclarationPackage.eINSTANCE;
    }
  }

	/**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
	@Override
	public boolean isFactoryForType(Object object) {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

	/**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected DeclarationSwitch<Adapter> modelSwitch =
		new DeclarationSwitch<Adapter>()
    {
      @Override
      public Adapter caseAdapterDeclaration(AdapterDeclaration object)
      {
        return createAdapterDeclarationAdapter();
      }
      @Override
      public Adapter casePrecedenceDeclaration(PrecedenceDeclaration object)
      {
        return createPrecedenceDeclarationAdapter();
      }
      @Override
      public Adapter caseInterTypeDeclaration(InterTypeDeclaration object)
      {
        return createInterTypeDeclarationAdapter();
      }
      @Override
      public Adapter caseDeclaration(Declaration object)
      {
        return createDeclarationAdapter();
      }
      @Override
      public Adapter caseAdapter(org.emftext.language.aspectbind.declaration.Adapter object)
      {
        return createAdapterAdapter();
      }
      @Override
      public Adapter caseCommentable(Commentable object)
      {
        return createCommentableAdapter();
      }
      @Override
      public Adapter caseNamespaceAwareElement(NamespaceAwareElement object)
      {
        return createNamespaceAwareElementAdapter();
      }
      @Override
      public Adapter caseAspectMember(AspectMember object)
      {
        return createAspectMemberAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object)
      {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

	/**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
	@Override
	public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.declaration.AdapterDeclaration <em>Adapter Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.declaration.AdapterDeclaration
   * @generated
   */
	public Adapter createAdapterDeclarationAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.declaration.PrecedenceDeclaration <em>Precedence Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.declaration.PrecedenceDeclaration
   * @generated
   */
	public Adapter createPrecedenceDeclarationAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.declaration.InterTypeDeclaration <em>Inter Type Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.declaration.InterTypeDeclaration
   * @generated
   */
	public Adapter createInterTypeDeclarationAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.declaration.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.declaration.Declaration
   * @generated
   */
	public Adapter createDeclarationAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.declaration.Adapter <em>Adapter</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.declaration.Adapter
   * @generated
   */
	public Adapter createAdapterAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.commons.Commentable <em>Commentable</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.commons.Commentable
   * @generated
   */
	public Adapter createCommentableAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.commons.NamespaceAwareElement <em>Namespace Aware Element</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.commons.NamespaceAwareElement
   * @generated
   */
	public Adapter createNamespaceAwareElementAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.commons.AspectMember <em>Aspect Member</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.commons.AspectMember
   * @generated
   */
	public Adapter createAspectMemberAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.commons.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.commons.NamedElement
   * @generated
   */
	public Adapter createNamedElementAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
	public Adapter createEObjectAdapter() {
    return null;
  }

} //DeclarationAdapterFactory
