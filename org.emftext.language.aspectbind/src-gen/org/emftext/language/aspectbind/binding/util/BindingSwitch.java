/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.binding.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.emftext.language.aspectbind.binding.BindingPackage
 * @generated
 */
public class BindingSwitch<T> extends Switch<T> {
	/**
   * The cached model package
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static BindingPackage modelPackage;

	/**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public BindingSwitch() {
    if (modelPackage == null)
    {
      modelPackage = BindingPackage.eINSTANCE;
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
      case BindingPackage.INSTANCE_POINTCUT:
      {
        InstancePointcut instancePointcut = (InstancePointcut)theEObject;
        T result = caseInstancePointcut(instancePointcut);
        if (result == null) result = casePointcut(instancePointcut);
        if (result == null) result = caseAspectMember(instancePointcut);
        if (result == null) result = caseNamedElement(instancePointcut);
        if (result == null) result = caseExpression(instancePointcut);
        if (result == null) result = caseNamespaceAwareElement(instancePointcut);
        if (result == null) result = caseArrayInitializationValue(instancePointcut);
        if (result == null) result = caseAnnotationValue(instancePointcut);
        if (result == null) result = caseCommentable(instancePointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BindingPackage.INSTANCE:
      {
        Instance instance = (Instance)theEObject;
        T result = caseInstance(instance);
        if (result == null) result = caseTypePattern(instance);
        if (result == null) result = caseTypeOrIdPattern(instance);
        if (result == null) result = casePattern(instance);
        if (result == null) result = caseAspectMember(instance);
        if (result == null) result = caseNamespaceAwareElement(instance);
        if (result == null) result = caseCommentable(instance);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Instance Pointcut</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Pointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseInstancePointcut(InstancePointcut object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Instance</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseInstance(Instance object) {
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
	public T caseNamespaceAwareElement(NamespaceAwareElement object) {
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
	public T caseAspectMember(AspectMember object) {
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
	public T caseNamedElement(NamedElement object) {
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
	public T casePointcut(Pointcut object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Pattern</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePattern(Pattern object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Type Or Id Pattern</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Or Id Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseTypeOrIdPattern(TypeOrIdPattern object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Type Pattern</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseTypePattern(TypePattern object) {
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

} //BindingSwitch
