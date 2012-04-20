/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.commons.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.emftext.language.aspectbind.commons.*;

import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.commons.NamespaceAwareElement;

import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.JavaRoot;

import org.emftext.language.java.imports.ImportingElement;

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
 * @see org.emftext.language.aspectbind.commons.CommonsPackage
 * @generated
 */
public class CommonsSwitch<T> extends Switch<T> {
	/**
   * The cached model package
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static CommonsPackage modelPackage;

	/**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CommonsSwitch() {
    if (modelPackage == null)
    {
      modelPackage = CommonsPackage.eINSTANCE;
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
      case CommonsPackage.ASPECT_MEMBER:
      {
        AspectMember aspectMember = (AspectMember)theEObject;
        T result = caseAspectMember(aspectMember);
        if (result == null) result = caseNamespaceAwareElement(aspectMember);
        if (result == null) result = caseCommentable(aspectMember);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonsPackage.ASPECT:
      {
        Aspect aspect = (Aspect)theEObject;
        T result = caseAspect(aspect);
        if (result == null) result = caseCompilationUnit(aspect);
        if (result == null) result = caseJavaRoot(aspect);
        if (result == null) result = caseNamedElement(aspect);
        if (result == null) result = caseNamespaceAwareElement(aspect);
        if (result == null) result = caseImportingElement(aspect);
        if (result == null) result = caseCommentable(aspect);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CommonsPackage.PER_CLAUSE:
      {
        PerClause perClause = (PerClause)theEObject;
        T result = casePerClause(perClause);
        if (result == null) result = caseCommentable(perClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
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
   * Returns the result of interpreting the object as an instance of '<em>Aspect</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Aspect</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAspect(Aspect object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Per Clause</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Per Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePerClause(PerClause object) {
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
   * Returns the result of interpreting the object as an instance of '<em>Importing Element</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Importing Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseImportingElement(ImportingElement object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Java Root</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Java Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseJavaRoot(JavaRoot object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Compilation Unit</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Compilation Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseCompilationUnit(CompilationUnit object) {
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

} //CommonsSwitch
