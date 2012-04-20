/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pcexp.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.aspectbind.pcexp.*;

import org.emftext.language.java.annotations.AnnotationValue;

import org.emftext.language.java.arrays.ArrayInitializationValue;

import org.emftext.language.java.commons.Commentable;

import org.emftext.language.java.expressions.AssignmentExpressionChild;
import org.emftext.language.java.expressions.ConditionalExpression;
import org.emftext.language.java.expressions.ConditionalExpressionChild;
import org.emftext.language.java.expressions.ConditionalOrExpressionChild;
import org.emftext.language.java.expressions.Expression;

import org.emftext.language.java.operators.AssignmentOperator;
import org.emftext.language.java.operators.Operator;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.pcexp.PcexpPackage
 * @generated
 */
public class PcexpAdapterFactory extends AdapterFactoryImpl {
	/**
   * The cached model package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static PcexpPackage modelPackage;

	/**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PcexpAdapterFactory() {
    if (modelPackage == null)
    {
      modelPackage = PcexpPackage.eINSTANCE;
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
	protected PcexpSwitch<Adapter> modelSwitch =
		new PcexpSwitch<Adapter>()
    {
      @Override
      public Adapter casePointcutExpressionChild(PointcutExpressionChild object)
      {
        return createPointcutExpressionChildAdapter();
      }
      @Override
      public Adapter casePointcutExpression(PointcutExpression object)
      {
        return createPointcutExpressionAdapter();
      }
      @Override
      public Adapter casePointcutOrExpression(PointcutOrExpression object)
      {
        return createPointcutOrExpressionAdapter();
      }
      @Override
      public Adapter casePointcutOrExpressionChild(PointcutOrExpressionChild object)
      {
        return createPointcutOrExpressionChildAdapter();
      }
      @Override
      public Adapter casePointcutAndExpression(PointcutAndExpression object)
      {
        return createPointcutAndExpressionAdapter();
      }
      @Override
      public Adapter casePointcutAndExpressionChild(PointcutAndExpressionChild object)
      {
        return createPointcutAndExpressionChildAdapter();
      }
      @Override
      public Adapter casePcAssignmentOperator(PcAssignmentOperator object)
      {
        return createPcAssignmentOperatorAdapter();
      }
      @Override
      public Adapter caseCommentable(Commentable object)
      {
        return createCommentableAdapter();
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
      public Adapter caseAssignmentExpressionChild(AssignmentExpressionChild object)
      {
        return createAssignmentExpressionChildAdapter();
      }
      @Override
      public Adapter caseConditionalExpressionChild(ConditionalExpressionChild object)
      {
        return createConditionalExpressionChildAdapter();
      }
      @Override
      public Adapter caseConditionalExpression(ConditionalExpression object)
      {
        return createConditionalExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalOrExpressionChild(ConditionalOrExpressionChild object)
      {
        return createConditionalOrExpressionChildAdapter();
      }
      @Override
      public Adapter caseOperator(Operator object)
      {
        return createOperatorAdapter();
      }
      @Override
      public Adapter caseAssignmentOperator(AssignmentOperator object)
      {
        return createAssignmentOperatorAdapter();
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
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.pcexp.PointcutExpressionChild <em>Pointcut Expression Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.pcexp.PointcutExpressionChild
   * @generated
   */
	public Adapter createPointcutExpressionChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.pcexp.PointcutExpression <em>Pointcut Expression</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.pcexp.PointcutExpression
   * @generated
   */
	public Adapter createPointcutExpressionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.pcexp.PointcutOrExpression <em>Pointcut Or Expression</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.pcexp.PointcutOrExpression
   * @generated
   */
	public Adapter createPointcutOrExpressionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.pcexp.PointcutOrExpressionChild <em>Pointcut Or Expression Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.pcexp.PointcutOrExpressionChild
   * @generated
   */
	public Adapter createPointcutOrExpressionChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.pcexp.PointcutAndExpression <em>Pointcut And Expression</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.pcexp.PointcutAndExpression
   * @generated
   */
	public Adapter createPointcutAndExpressionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.pcexp.PointcutAndExpressionChild <em>Pointcut And Expression Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.pcexp.PointcutAndExpressionChild
   * @generated
   */
	public Adapter createPointcutAndExpressionChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.aspectbind.pcexp.PcAssignmentOperator <em>Pc Assignment Operator</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.aspectbind.pcexp.PcAssignmentOperator
   * @generated
   */
	public Adapter createPcAssignmentOperatorAdapter() {
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
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.expressions.AssignmentExpressionChild <em>Assignment Expression Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.expressions.AssignmentExpressionChild
   * @generated
   */
	public Adapter createAssignmentExpressionChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.expressions.ConditionalExpressionChild <em>Conditional Expression Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.expressions.ConditionalExpressionChild
   * @generated
   */
	public Adapter createConditionalExpressionChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.expressions.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.expressions.ConditionalExpression
   * @generated
   */
	public Adapter createConditionalExpressionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.expressions.ConditionalOrExpressionChild <em>Conditional Or Expression Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.expressions.ConditionalOrExpressionChild
   * @generated
   */
	public Adapter createConditionalOrExpressionChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.operators.Operator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.operators.Operator
   * @generated
   */
	public Adapter createOperatorAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.java.operators.AssignmentOperator <em>Assignment Operator</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.java.operators.AssignmentOperator
   * @generated
   */
	public Adapter createAssignmentOperatorAdapter() {
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

} //PcexpAdapterFactory
