/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pcexp.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.aspectbind.pcexp.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PcexpFactoryImpl extends EFactoryImpl implements PcexpFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static PcexpFactory init() {
    try
    {
      PcexpFactory thePcexpFactory = (PcexpFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/bindingAspect/pcexp"); 
      if (thePcexpFactory != null)
      {
        return thePcexpFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PcexpFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PcexpFactoryImpl() {
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
      case PcexpPackage.POINTCUT_EXPRESSION: return createPointcutExpression();
      case PcexpPackage.POINTCUT_OR_EXPRESSION: return createPointcutOrExpression();
      case PcexpPackage.POINTCUT_AND_EXPRESSION: return createPointcutAndExpression();
      case PcexpPackage.PC_ASSIGNMENT_OPERATOR: return createPcAssignmentOperator();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PointcutExpression createPointcutExpression() {
    PointcutExpressionImpl pointcutExpression = new PointcutExpressionImpl();
    return pointcutExpression;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PointcutOrExpression createPointcutOrExpression() {
    PointcutOrExpressionImpl pointcutOrExpression = new PointcutOrExpressionImpl();
    return pointcutOrExpression;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PointcutAndExpression createPointcutAndExpression() {
    PointcutAndExpressionImpl pointcutAndExpression = new PointcutAndExpressionImpl();
    return pointcutAndExpression;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PcAssignmentOperator createPcAssignmentOperator() {
    PcAssignmentOperatorImpl pcAssignmentOperator = new PcAssignmentOperatorImpl();
    return pcAssignmentOperator;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PcexpPackage getPcexpPackage() {
    return (PcexpPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static PcexpPackage getPackage() {
    return PcexpPackage.eINSTANCE;
  }

} //PcexpFactoryImpl
