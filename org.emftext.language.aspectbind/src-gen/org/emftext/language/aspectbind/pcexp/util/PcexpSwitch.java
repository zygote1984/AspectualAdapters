/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pcexp.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.pcexp.PcexpPackage
 * @generated
 */
public class PcexpSwitch<T> extends Switch<T> {
	/**
   * The cached model package
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static PcexpPackage modelPackage;

	/**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PcexpSwitch() {
    if (modelPackage == null)
    {
      modelPackage = PcexpPackage.eINSTANCE;
    }
  }

	/**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

	/**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID)
    {
      case PcexpPackage.POINTCUT_EXPRESSION_CHILD:
      {
        PointcutExpressionChild pointcutExpressionChild = (PointcutExpressionChild)theEObject;
        T result = casePointcutExpressionChild(pointcutExpressionChild);
        if (result == null) result = caseConditionalExpressionChild(pointcutExpressionChild);
        if (result == null) result = caseAssignmentExpressionChild(pointcutExpressionChild);
        if (result == null) result = caseExpression(pointcutExpressionChild);
        if (result == null) result = caseArrayInitializationValue(pointcutExpressionChild);
        if (result == null) result = caseAnnotationValue(pointcutExpressionChild);
        if (result == null) result = caseCommentable(pointcutExpressionChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PcexpPackage.POINTCUT_EXPRESSION:
      {
        PointcutExpression pointcutExpression = (PointcutExpression)theEObject;
        T result = casePointcutExpression(pointcutExpression);
        if (result == null) result = caseConditionalExpression(pointcutExpression);
        if (result == null) result = caseAssignmentExpressionChild(pointcutExpression);
        if (result == null) result = caseExpression(pointcutExpression);
        if (result == null) result = caseArrayInitializationValue(pointcutExpression);
        if (result == null) result = caseAnnotationValue(pointcutExpression);
        if (result == null) result = caseCommentable(pointcutExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PcexpPackage.POINTCUT_OR_EXPRESSION:
      {
        PointcutOrExpression pointcutOrExpression = (PointcutOrExpression)theEObject;
        T result = casePointcutOrExpression(pointcutOrExpression);
        if (result == null) result = casePointcutExpressionChild(pointcutOrExpression);
        if (result == null) result = caseConditionalExpressionChild(pointcutOrExpression);
        if (result == null) result = caseAssignmentExpressionChild(pointcutOrExpression);
        if (result == null) result = caseExpression(pointcutOrExpression);
        if (result == null) result = caseArrayInitializationValue(pointcutOrExpression);
        if (result == null) result = caseAnnotationValue(pointcutOrExpression);
        if (result == null) result = caseCommentable(pointcutOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PcexpPackage.POINTCUT_OR_EXPRESSION_CHILD:
      {
        PointcutOrExpressionChild pointcutOrExpressionChild = (PointcutOrExpressionChild)theEObject;
        T result = casePointcutOrExpressionChild(pointcutOrExpressionChild);
        if (result == null) result = caseConditionalOrExpressionChild(pointcutOrExpressionChild);
        if (result == null) result = caseConditionalExpressionChild(pointcutOrExpressionChild);
        if (result == null) result = caseAssignmentExpressionChild(pointcutOrExpressionChild);
        if (result == null) result = caseExpression(pointcutOrExpressionChild);
        if (result == null) result = caseArrayInitializationValue(pointcutOrExpressionChild);
        if (result == null) result = caseAnnotationValue(pointcutOrExpressionChild);
        if (result == null) result = caseCommentable(pointcutOrExpressionChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PcexpPackage.POINTCUT_AND_EXPRESSION:
      {
        PointcutAndExpression pointcutAndExpression = (PointcutAndExpression)theEObject;
        T result = casePointcutAndExpression(pointcutAndExpression);
        if (result == null) result = casePointcutOrExpressionChild(pointcutAndExpression);
        if (result == null) result = caseConditionalOrExpressionChild(pointcutAndExpression);
        if (result == null) result = caseConditionalExpressionChild(pointcutAndExpression);
        if (result == null) result = caseAssignmentExpressionChild(pointcutAndExpression);
        if (result == null) result = caseExpression(pointcutAndExpression);
        if (result == null) result = caseArrayInitializationValue(pointcutAndExpression);
        if (result == null) result = caseAnnotationValue(pointcutAndExpression);
        if (result == null) result = caseCommentable(pointcutAndExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PcexpPackage.POINTCUT_AND_EXPRESSION_CHILD:
      {
        PointcutAndExpressionChild pointcutAndExpressionChild = (PointcutAndExpressionChild)theEObject;
        T result = casePointcutAndExpressionChild(pointcutAndExpressionChild);
        if (result == null) result = casePointcutOrExpressionChild(pointcutAndExpressionChild);
        if (result == null) result = caseConditionalOrExpressionChild(pointcutAndExpressionChild);
        if (result == null) result = caseConditionalExpressionChild(pointcutAndExpressionChild);
        if (result == null) result = caseAssignmentExpressionChild(pointcutAndExpressionChild);
        if (result == null) result = caseExpression(pointcutAndExpressionChild);
        if (result == null) result = caseArrayInitializationValue(pointcutAndExpressionChild);
        if (result == null) result = caseAnnotationValue(pointcutAndExpressionChild);
        if (result == null) result = caseCommentable(pointcutAndExpressionChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PcexpPackage.PC_ASSIGNMENT_OPERATOR:
      {
        PcAssignmentOperator pcAssignmentOperator = (PcAssignmentOperator)theEObject;
        T result = casePcAssignmentOperator(pcAssignmentOperator);
        if (result == null) result = caseAssignmentOperator(pcAssignmentOperator);
        if (result == null) result = caseOperator(pcAssignmentOperator);
        if (result == null) result = caseCommentable(pcAssignmentOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Pointcut Expression Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pointcut Expression Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePointcutExpressionChild(PointcutExpressionChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Pointcut Expression</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pointcut Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePointcutExpression(PointcutExpression object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Pointcut Or Expression</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pointcut Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePointcutOrExpression(PointcutOrExpression object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Pointcut Or Expression Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pointcut Or Expression Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePointcutOrExpressionChild(PointcutOrExpressionChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Pointcut And Expression</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pointcut And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePointcutAndExpression(PointcutAndExpression object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Pointcut And Expression Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pointcut And Expression Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePointcutAndExpressionChild(PointcutAndExpressionChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Pc Assignment Operator</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pc Assignment Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePcAssignmentOperator(PcAssignmentOperator object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Commentable</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Commentable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseCommentable(Commentable object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Array Initialization Value</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Initialization Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseArrayInitializationValue(ArrayInitializationValue object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Annotation Value</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotation Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAnnotationValue(AnnotationValue object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseExpression(Expression object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Assignment Expression Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment Expression Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAssignmentExpressionChild(AssignmentExpressionChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Expression Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Expression Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseConditionalExpressionChild(ConditionalExpressionChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseConditionalExpression(ConditionalExpression object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Or Expression Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Or Expression Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseConditionalOrExpressionChild(ConditionalOrExpressionChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Operator</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseOperator(Operator object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Assignment Operator</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAssignmentOperator(AssignmentOperator object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
	@Override
	public T defaultCase(EObject object) {
    return null;
  }

} //PcexpSwitch
