/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.binding.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.aspectbind.binding.*;

import org.emftext.language.aspectbind.commons.AspectMember;

import org.emftext.language.aspectbind.patterns.Pattern;
import org.emftext.language.aspectbind.patterns.TypeOrIdPattern;
import org.emftext.language.aspectbind.patterns.TypePattern;

import org.emftext.language.aspectbind.pointcuts.Pointcut;

import org.emftext.language.java.annotations.AnnotationValue;

import org.emftext.language.java.arrays.ArrayInitializationValue;

import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.commons.NamespaceAwareElement;

import org.emftext.language.java.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.binding.BindingPackage
 * @generated
 */
public class BindingAdapterFactory extends AdapterFactoryImpl {
	/**
   * The cached model package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static BindingPackage modelPackage;

	/**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public BindingAdapterFactory() {
    if (modelPackage == null)
    {
      modelPackage = BindingPackage.eINSTANCE;
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
	protected BindingSwitch<Adapter> modelSwitch =
		new BindingSwitch<Adapter>()
    {
      @Override
      public Adapter caseInstancePointcut(InstancePointcut object)
      {
        return createInstancePointcutAdapter();
      }
      @Override
      public Adapter caseInstance(Instance object)
      {
        return createInstanceAdapter();
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
      public Adapter caseArrayInitializationValue(ArrayInitializationValue object)
      {
        return createArrayInitializationValueAdapter();
      }
      @Override
      public Adapter caseAnnotationValue(AnnotationValue object)
      {
        return createAnnotationValueAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter casePointcut(Pointcut object)
      {
        return createPointcutAdapter();
      }
      @Override
      public Adapter casePattern(Pattern object)
      {
        return createPatternAdapter();
      }
      @Override
      public Adapter caseTypeOrIdPattern(TypeOrIdPattern object)
      {
        return createTypeOrIdPatternAdapter();
      }
      @Override
      public Adapter caseTypePattern(TypePattern object)
      {
        return createTypePatternAdapter();
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
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.binding.InstancePointcut <em>Instance Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.binding.InstancePointcut
   * @generated
   */
	public Adapter createInstancePointcutAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.binding.Instance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.binding.Instance
   * @generated
   */
	public Adapter createInstanceAdapter() {
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
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.arrays.ArrayInitializationValue <em>Array Initialization Value</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.arrays.ArrayInitializationValue
   * @generated
   */
	public Adapter createArrayInitializationValueAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.annotations.AnnotationValue <em>Annotation Value</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.annotations.AnnotationValue
   * @generated
   */
	public Adapter createAnnotationValueAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.expressions.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.expressions.Expression
   * @generated
   */
	public Adapter createExpressionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.pointcuts.Pointcut <em>Pointcut</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.pointcuts.Pointcut
   * @generated
   */
	public Adapter createPointcutAdapter() {
    return null;
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
	public Adapter createPatternAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.patterns.TypeOrIdPattern <em>Type Or Id Pattern</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.patterns.TypeOrIdPattern
   * @generated
   */
	public Adapter createTypeOrIdPatternAdapter() {
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
	public Adapter createTypePatternAdapter() {
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

} //BindingAdapterFactory
