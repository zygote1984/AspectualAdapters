/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.emftext.language.aspectbind.commons.AspectMember;

import org.emftext.language.aspectbind.pcexp.PointcutExpressionType;

import org.emftext.language.aspectbind.pointcuts.*;

import org.emftext.language.java.annotations.AnnotationValue;

import org.emftext.language.java.arrays.ArrayInitializationValue;

import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.commons.NamespaceAwareElement;

import org.emftext.language.java.expressions.AssignmentExpressionChild;
import org.emftext.language.java.expressions.ConditionalExpressionChild;
import org.emftext.language.java.expressions.Expression;

import org.emftext.language.java.parameters.Parametrizable;

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
 * @see org.emftext.language.aspectbind.pointcuts.PointcutsPackage
 * @generated
 */
public class PointcutsSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PointcutsPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PointcutsSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = PointcutsPackage.eINSTANCE;
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
  protected boolean isSwitchFor(EPackage ePackage)
  {
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
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case PointcutsPackage.PRIMITIVE_POINTCUT:
      {
        PrimitivePointcut primitivePointcut = (PrimitivePointcut)theEObject;
        T result = casePrimitivePointcut(primitivePointcut);
        if (result == null) result = caseAspectMember(primitivePointcut);
        if (result == null) result = casePointcutExpressionType(primitivePointcut);
        if (result == null) result = caseNamespaceAwareElement(primitivePointcut);
        if (result == null) result = caseConditionalExpressionChild(primitivePointcut);
        if (result == null) result = caseAssignmentExpressionChild(primitivePointcut);
        if (result == null) result = caseExpression(primitivePointcut);
        if (result == null) result = caseArrayInitializationValue(primitivePointcut);
        if (result == null) result = caseAnnotationValue(primitivePointcut);
        if (result == null) result = caseCommentable(primitivePointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.CALL_POINTCUT:
      {
        CallPointcut callPointcut = (CallPointcut)theEObject;
        T result = caseCallPointcut(callPointcut);
        if (result == null) result = casePrimitivePointcut(callPointcut);
        if (result == null) result = caseAspectMember(callPointcut);
        if (result == null) result = casePointcutExpressionType(callPointcut);
        if (result == null) result = caseNamespaceAwareElement(callPointcut);
        if (result == null) result = caseConditionalExpressionChild(callPointcut);
        if (result == null) result = caseAssignmentExpressionChild(callPointcut);
        if (result == null) result = caseExpression(callPointcut);
        if (result == null) result = caseArrayInitializationValue(callPointcut);
        if (result == null) result = caseAnnotationValue(callPointcut);
        if (result == null) result = caseCommentable(callPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.EXECUTION_POINTCUT:
      {
        ExecutionPointcut executionPointcut = (ExecutionPointcut)theEObject;
        T result = caseExecutionPointcut(executionPointcut);
        if (result == null) result = casePrimitivePointcut(executionPointcut);
        if (result == null) result = caseAspectMember(executionPointcut);
        if (result == null) result = casePointcutExpressionType(executionPointcut);
        if (result == null) result = caseNamespaceAwareElement(executionPointcut);
        if (result == null) result = caseConditionalExpressionChild(executionPointcut);
        if (result == null) result = caseAssignmentExpressionChild(executionPointcut);
        if (result == null) result = caseExpression(executionPointcut);
        if (result == null) result = caseArrayInitializationValue(executionPointcut);
        if (result == null) result = caseAnnotationValue(executionPointcut);
        if (result == null) result = caseCommentable(executionPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.GET_POINTCUT:
      {
        GetPointcut getPointcut = (GetPointcut)theEObject;
        T result = caseGetPointcut(getPointcut);
        if (result == null) result = casePrimitivePointcut(getPointcut);
        if (result == null) result = caseAspectMember(getPointcut);
        if (result == null) result = casePointcutExpressionType(getPointcut);
        if (result == null) result = caseNamespaceAwareElement(getPointcut);
        if (result == null) result = caseConditionalExpressionChild(getPointcut);
        if (result == null) result = caseAssignmentExpressionChild(getPointcut);
        if (result == null) result = caseExpression(getPointcut);
        if (result == null) result = caseArrayInitializationValue(getPointcut);
        if (result == null) result = caseAnnotationValue(getPointcut);
        if (result == null) result = caseCommentable(getPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.SET_POINTCUT:
      {
        SetPointcut setPointcut = (SetPointcut)theEObject;
        T result = caseSetPointcut(setPointcut);
        if (result == null) result = casePrimitivePointcut(setPointcut);
        if (result == null) result = caseAspectMember(setPointcut);
        if (result == null) result = casePointcutExpressionType(setPointcut);
        if (result == null) result = caseNamespaceAwareElement(setPointcut);
        if (result == null) result = caseConditionalExpressionChild(setPointcut);
        if (result == null) result = caseAssignmentExpressionChild(setPointcut);
        if (result == null) result = caseExpression(setPointcut);
        if (result == null) result = caseArrayInitializationValue(setPointcut);
        if (result == null) result = caseAnnotationValue(setPointcut);
        if (result == null) result = caseCommentable(setPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.HANDLER_POINTCUT:
      {
        HandlerPointcut handlerPointcut = (HandlerPointcut)theEObject;
        T result = caseHandlerPointcut(handlerPointcut);
        if (result == null) result = casePrimitivePointcut(handlerPointcut);
        if (result == null) result = caseAspectMember(handlerPointcut);
        if (result == null) result = casePointcutExpressionType(handlerPointcut);
        if (result == null) result = caseNamespaceAwareElement(handlerPointcut);
        if (result == null) result = caseConditionalExpressionChild(handlerPointcut);
        if (result == null) result = caseAssignmentExpressionChild(handlerPointcut);
        if (result == null) result = caseExpression(handlerPointcut);
        if (result == null) result = caseArrayInitializationValue(handlerPointcut);
        if (result == null) result = caseAnnotationValue(handlerPointcut);
        if (result == null) result = caseCommentable(handlerPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.ADVICE_EXECUTION_POINTCUT:
      {
        AdviceExecutionPointcut adviceExecutionPointcut = (AdviceExecutionPointcut)theEObject;
        T result = caseAdviceExecutionPointcut(adviceExecutionPointcut);
        if (result == null) result = casePrimitivePointcut(adviceExecutionPointcut);
        if (result == null) result = caseAspectMember(adviceExecutionPointcut);
        if (result == null) result = casePointcutExpressionType(adviceExecutionPointcut);
        if (result == null) result = caseNamespaceAwareElement(adviceExecutionPointcut);
        if (result == null) result = caseConditionalExpressionChild(adviceExecutionPointcut);
        if (result == null) result = caseAssignmentExpressionChild(adviceExecutionPointcut);
        if (result == null) result = caseExpression(adviceExecutionPointcut);
        if (result == null) result = caseArrayInitializationValue(adviceExecutionPointcut);
        if (result == null) result = caseAnnotationValue(adviceExecutionPointcut);
        if (result == null) result = caseCommentable(adviceExecutionPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.STATIC_INIT_POINTCUT:
      {
        StaticInitPointcut staticInitPointcut = (StaticInitPointcut)theEObject;
        T result = caseStaticInitPointcut(staticInitPointcut);
        if (result == null) result = casePrimitivePointcut(staticInitPointcut);
        if (result == null) result = caseAspectMember(staticInitPointcut);
        if (result == null) result = casePointcutExpressionType(staticInitPointcut);
        if (result == null) result = caseNamespaceAwareElement(staticInitPointcut);
        if (result == null) result = caseConditionalExpressionChild(staticInitPointcut);
        if (result == null) result = caseAssignmentExpressionChild(staticInitPointcut);
        if (result == null) result = caseExpression(staticInitPointcut);
        if (result == null) result = caseArrayInitializationValue(staticInitPointcut);
        if (result == null) result = caseAnnotationValue(staticInitPointcut);
        if (result == null) result = caseCommentable(staticInitPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.INIT_POINTCUT:
      {
        InitPointcut initPointcut = (InitPointcut)theEObject;
        T result = caseInitPointcut(initPointcut);
        if (result == null) result = casePrimitivePointcut(initPointcut);
        if (result == null) result = caseAspectMember(initPointcut);
        if (result == null) result = casePointcutExpressionType(initPointcut);
        if (result == null) result = caseNamespaceAwareElement(initPointcut);
        if (result == null) result = caseConditionalExpressionChild(initPointcut);
        if (result == null) result = caseAssignmentExpressionChild(initPointcut);
        if (result == null) result = caseExpression(initPointcut);
        if (result == null) result = caseArrayInitializationValue(initPointcut);
        if (result == null) result = caseAnnotationValue(initPointcut);
        if (result == null) result = caseCommentable(initPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.PRE_INIT_POINTCUT:
      {
        PreInitPointcut preInitPointcut = (PreInitPointcut)theEObject;
        T result = casePreInitPointcut(preInitPointcut);
        if (result == null) result = casePrimitivePointcut(preInitPointcut);
        if (result == null) result = caseAspectMember(preInitPointcut);
        if (result == null) result = casePointcutExpressionType(preInitPointcut);
        if (result == null) result = caseNamespaceAwareElement(preInitPointcut);
        if (result == null) result = caseConditionalExpressionChild(preInitPointcut);
        if (result == null) result = caseAssignmentExpressionChild(preInitPointcut);
        if (result == null) result = caseExpression(preInitPointcut);
        if (result == null) result = caseArrayInitializationValue(preInitPointcut);
        if (result == null) result = caseAnnotationValue(preInitPointcut);
        if (result == null) result = caseCommentable(preInitPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.WITHIN_POINTCUT:
      {
        WithinPointcut withinPointcut = (WithinPointcut)theEObject;
        T result = caseWithinPointcut(withinPointcut);
        if (result == null) result = casePrimitivePointcut(withinPointcut);
        if (result == null) result = caseAspectMember(withinPointcut);
        if (result == null) result = casePointcutExpressionType(withinPointcut);
        if (result == null) result = caseNamespaceAwareElement(withinPointcut);
        if (result == null) result = caseConditionalExpressionChild(withinPointcut);
        if (result == null) result = caseAssignmentExpressionChild(withinPointcut);
        if (result == null) result = caseExpression(withinPointcut);
        if (result == null) result = caseArrayInitializationValue(withinPointcut);
        if (result == null) result = caseAnnotationValue(withinPointcut);
        if (result == null) result = caseCommentable(withinPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.WITHIN_CODE_POINTCUT:
      {
        WithinCodePointcut withinCodePointcut = (WithinCodePointcut)theEObject;
        T result = caseWithinCodePointcut(withinCodePointcut);
        if (result == null) result = casePrimitivePointcut(withinCodePointcut);
        if (result == null) result = caseAspectMember(withinCodePointcut);
        if (result == null) result = casePointcutExpressionType(withinCodePointcut);
        if (result == null) result = caseNamespaceAwareElement(withinCodePointcut);
        if (result == null) result = caseConditionalExpressionChild(withinCodePointcut);
        if (result == null) result = caseAssignmentExpressionChild(withinCodePointcut);
        if (result == null) result = caseExpression(withinCodePointcut);
        if (result == null) result = caseArrayInitializationValue(withinCodePointcut);
        if (result == null) result = caseAnnotationValue(withinCodePointcut);
        if (result == null) result = caseCommentable(withinCodePointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.THIS_POINTCUT:
      {
        ThisPointcut thisPointcut = (ThisPointcut)theEObject;
        T result = caseThisPointcut(thisPointcut);
        if (result == null) result = casePrimitivePointcut(thisPointcut);
        if (result == null) result = caseAspectMember(thisPointcut);
        if (result == null) result = casePointcutExpressionType(thisPointcut);
        if (result == null) result = caseNamespaceAwareElement(thisPointcut);
        if (result == null) result = caseConditionalExpressionChild(thisPointcut);
        if (result == null) result = caseAssignmentExpressionChild(thisPointcut);
        if (result == null) result = caseExpression(thisPointcut);
        if (result == null) result = caseArrayInitializationValue(thisPointcut);
        if (result == null) result = caseAnnotationValue(thisPointcut);
        if (result == null) result = caseCommentable(thisPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.TARGET_POINTCUT:
      {
        TargetPointcut targetPointcut = (TargetPointcut)theEObject;
        T result = caseTargetPointcut(targetPointcut);
        if (result == null) result = casePrimitivePointcut(targetPointcut);
        if (result == null) result = caseAspectMember(targetPointcut);
        if (result == null) result = casePointcutExpressionType(targetPointcut);
        if (result == null) result = caseNamespaceAwareElement(targetPointcut);
        if (result == null) result = caseConditionalExpressionChild(targetPointcut);
        if (result == null) result = caseAssignmentExpressionChild(targetPointcut);
        if (result == null) result = caseExpression(targetPointcut);
        if (result == null) result = caseArrayInitializationValue(targetPointcut);
        if (result == null) result = caseAnnotationValue(targetPointcut);
        if (result == null) result = caseCommentable(targetPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.ARGS_POINTCUT:
      {
        ArgsPointcut argsPointcut = (ArgsPointcut)theEObject;
        T result = caseArgsPointcut(argsPointcut);
        if (result == null) result = casePrimitivePointcut(argsPointcut);
        if (result == null) result = caseAspectMember(argsPointcut);
        if (result == null) result = casePointcutExpressionType(argsPointcut);
        if (result == null) result = caseNamespaceAwareElement(argsPointcut);
        if (result == null) result = caseConditionalExpressionChild(argsPointcut);
        if (result == null) result = caseAssignmentExpressionChild(argsPointcut);
        if (result == null) result = caseExpression(argsPointcut);
        if (result == null) result = caseArrayInitializationValue(argsPointcut);
        if (result == null) result = caseAnnotationValue(argsPointcut);
        if (result == null) result = caseCommentable(argsPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.CFLOW_POINTCUT:
      {
        CFlowPointcut cFlowPointcut = (CFlowPointcut)theEObject;
        T result = caseCFlowPointcut(cFlowPointcut);
        if (result == null) result = casePrimitivePointcut(cFlowPointcut);
        if (result == null) result = caseAspectMember(cFlowPointcut);
        if (result == null) result = casePointcutExpressionType(cFlowPointcut);
        if (result == null) result = caseNamespaceAwareElement(cFlowPointcut);
        if (result == null) result = caseConditionalExpressionChild(cFlowPointcut);
        if (result == null) result = caseAssignmentExpressionChild(cFlowPointcut);
        if (result == null) result = caseExpression(cFlowPointcut);
        if (result == null) result = caseArrayInitializationValue(cFlowPointcut);
        if (result == null) result = caseAnnotationValue(cFlowPointcut);
        if (result == null) result = caseCommentable(cFlowPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.CFLOW_BELOW_POINTCUT:
      {
        CFlowBelowPointcut cFlowBelowPointcut = (CFlowBelowPointcut)theEObject;
        T result = caseCFlowBelowPointcut(cFlowBelowPointcut);
        if (result == null) result = casePrimitivePointcut(cFlowBelowPointcut);
        if (result == null) result = caseAspectMember(cFlowBelowPointcut);
        if (result == null) result = casePointcutExpressionType(cFlowBelowPointcut);
        if (result == null) result = caseNamespaceAwareElement(cFlowBelowPointcut);
        if (result == null) result = caseConditionalExpressionChild(cFlowBelowPointcut);
        if (result == null) result = caseAssignmentExpressionChild(cFlowBelowPointcut);
        if (result == null) result = caseExpression(cFlowBelowPointcut);
        if (result == null) result = caseArrayInitializationValue(cFlowBelowPointcut);
        if (result == null) result = caseAnnotationValue(cFlowBelowPointcut);
        if (result == null) result = caseCommentable(cFlowBelowPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.IF_POINTCUT:
      {
        IfPointcut ifPointcut = (IfPointcut)theEObject;
        T result = caseIfPointcut(ifPointcut);
        if (result == null) result = casePrimitivePointcut(ifPointcut);
        if (result == null) result = caseAspectMember(ifPointcut);
        if (result == null) result = casePointcutExpressionType(ifPointcut);
        if (result == null) result = caseNamespaceAwareElement(ifPointcut);
        if (result == null) result = caseConditionalExpressionChild(ifPointcut);
        if (result == null) result = caseAssignmentExpressionChild(ifPointcut);
        if (result == null) result = caseExpression(ifPointcut);
        if (result == null) result = caseArrayInitializationValue(ifPointcut);
        if (result == null) result = caseAnnotationValue(ifPointcut);
        if (result == null) result = caseCommentable(ifPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.POINTCUT:
      {
        Pointcut pointcut = (Pointcut)theEObject;
        T result = casePointcut(pointcut);
        if (result == null) result = caseAspectMember(pointcut);
        if (result == null) result = caseNamedElement(pointcut);
        if (result == null) result = casePointcutExpressionType(pointcut);
        if (result == null) result = caseNamespaceAwareElement(pointcut);
        if (result == null) result = caseConditionalExpressionChild(pointcut);
        if (result == null) result = caseAssignmentExpressionChild(pointcut);
        if (result == null) result = caseExpression(pointcut);
        if (result == null) result = caseArrayInitializationValue(pointcut);
        if (result == null) result = caseAnnotationValue(pointcut);
        if (result == null) result = caseCommentable(pointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case PointcutsPackage.ASPECT_JPOINTCUT:
      {
        AspectJPointcut aspectJPointcut = (AspectJPointcut)theEObject;
        T result = caseAspectJPointcut(aspectJPointcut);
        if (result == null) result = casePointcut(aspectJPointcut);
        if (result == null) result = caseParametrizable(aspectJPointcut);
        if (result == null) result = caseAspectMember(aspectJPointcut);
        if (result == null) result = caseNamedElement(aspectJPointcut);
        if (result == null) result = casePointcutExpressionType(aspectJPointcut);
        if (result == null) result = caseNamespaceAwareElement(aspectJPointcut);
        if (result == null) result = caseConditionalExpressionChild(aspectJPointcut);
        if (result == null) result = caseAssignmentExpressionChild(aspectJPointcut);
        if (result == null) result = caseExpression(aspectJPointcut);
        if (result == null) result = caseArrayInitializationValue(aspectJPointcut);
        if (result == null) result = caseAnnotationValue(aspectJPointcut);
        if (result == null) result = caseCommentable(aspectJPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitivePointcut(PrimitivePointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Call Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Call Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCallPointcut(CallPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Execution Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Execution Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExecutionPointcut(ExecutionPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Get Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Get Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGetPointcut(GetPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Set Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Set Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSetPointcut(SetPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Handler Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Handler Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHandlerPointcut(HandlerPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Advice Execution Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Advice Execution Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdviceExecutionPointcut(AdviceExecutionPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Static Init Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Static Init Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStaticInitPointcut(StaticInitPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Init Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Init Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitPointcut(InitPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pre Init Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pre Init Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePreInitPointcut(PreInitPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Within Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Within Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWithinPointcut(WithinPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Within Code Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Within Code Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWithinCodePointcut(WithinCodePointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>This Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>This Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThisPointcut(ThisPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Target Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Target Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTargetPointcut(TargetPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Args Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Args Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArgsPointcut(ArgsPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CFlow Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CFlow Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCFlowPointcut(CFlowPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CFlow Below Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CFlow Below Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCFlowBelowPointcut(CFlowBelowPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfPointcut(IfPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePointcut(Pointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Aspect JPointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Aspect JPointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAspectJPointcut(AspectJPointcut object)
  {
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
  public T caseCommentable(Commentable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Namespace Aware Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Namespace Aware Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamespaceAwareElement(NamespaceAwareElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Aspect Member</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Aspect Member</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAspectMember(AspectMember object)
  {
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
  public T caseArrayInitializationValue(ArrayInitializationValue object)
  {
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
  public T caseAnnotationValue(AnnotationValue object)
  {
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
  public T caseExpression(Expression object)
  {
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
  public T caseAssignmentExpressionChild(AssignmentExpressionChild object)
  {
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
  public T caseConditionalExpressionChild(ConditionalExpressionChild object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pointcut Expression Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pointcut Expression Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePointcutExpressionType(PointcutExpressionType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parametrizable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parametrizable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParametrizable(Parametrizable object)
  {
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
  public T defaultCase(EObject object)
  {
    return null;
  }

} //PointcutsSwitch
