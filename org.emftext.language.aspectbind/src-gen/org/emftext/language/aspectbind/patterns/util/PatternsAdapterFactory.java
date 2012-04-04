/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.patterns.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.aspectbind.commons.AspectMember;

import org.emftext.language.aspectbind.patterns.*;

import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.commons.NamespaceAwareElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.patterns.PatternsPackage
 * @generated
 */
public class PatternsAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PatternsPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternsAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PatternsPackage.eINSTANCE;
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
  public boolean isFactoryForType(Object object)
  {
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
  protected PatternsSwitch<Adapter> modelSwitch =
    new PatternsSwitch<Adapter>()
    {
      @Override
      public Adapter casePattern(Pattern object)
      {
        return createPatternAdapter();
      }
      @Override
      public Adapter caseAbstractMethodPattern(AbstractMethodPattern object)
      {
        return createAbstractMethodPatternAdapter();
      }
      @Override
      public Adapter caseFieldPattern(FieldPattern object)
      {
        return createFieldPatternAdapter();
      }
      @Override
      public Adapter caseConstructorPattern(ConstructorPattern object)
      {
        return createConstructorPatternAdapter();
      }
      @Override
      public Adapter caseMethodPattern(MethodPattern object)
      {
        return createMethodPatternAdapter();
      }
      @Override
      public Adapter caseTypePattern(TypePattern object)
      {
        return createTypePatternAdapter();
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
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.patterns.Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.patterns.Pattern
   * @generated
   */
  public Adapter createPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.patterns.AbstractMethodPattern <em>Abstract Method Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.patterns.AbstractMethodPattern
   * @generated
   */
  public Adapter createAbstractMethodPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.patterns.FieldPattern <em>Field Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.patterns.FieldPattern
   * @generated
   */
  public Adapter createFieldPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.patterns.ConstructorPattern <em>Constructor Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.patterns.ConstructorPattern
   * @generated
   */
  public Adapter createConstructorPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.patterns.MethodPattern <em>Method Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.patterns.MethodPattern
   * @generated
   */
  public Adapter createMethodPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.patterns.TypePattern <em>Type Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.patterns.TypePattern
   * @generated
   */
  public Adapter createTypePatternAdapter()
  {
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
  public Adapter createCommentableAdapter()
  {
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
  public Adapter createNamespaceAwareElementAdapter()
  {
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
  public Adapter createAspectMemberAdapter()
  {
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
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //PatternsAdapterFactory
