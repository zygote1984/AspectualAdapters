/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.binding.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.aspectbind.binding.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BindingFactoryImpl extends EFactoryImpl implements BindingFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static BindingFactory init() {
    try
    {
      BindingFactory theBindingFactory = (BindingFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/bindingAspect/binding"); 
      if (theBindingFactory != null)
      {
        return theBindingFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BindingFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public BindingFactoryImpl() {
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
      case BindingPackage.INSTANCE_POINTCUT: return createInstancePointcut();
      case BindingPackage.INSTANCE: return createInstance();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public InstancePointcut createInstancePointcut() {
    InstancePointcutImpl instancePointcut = new InstancePointcutImpl();
    return instancePointcut;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Instance createInstance() {
    InstanceImpl instance = new InstanceImpl();
    return instance;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public BindingPackage getBindingPackage() {
    return (BindingPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static BindingPackage getPackage() {
    return BindingPackage.eINSTANCE;
  }

} //BindingFactoryImpl
