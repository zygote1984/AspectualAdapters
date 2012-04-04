/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.patterns.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.aspectbind.patterns.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PatternsFactoryImpl extends EFactoryImpl implements PatternsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PatternsFactory init()
  {
    try
    {
      PatternsFactory thePatternsFactory = (PatternsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/bindingAspect/patterns"); 
      if (thePatternsFactory != null)
      {
        return thePatternsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PatternsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternsFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case PatternsPackage.FIELD_PATTERN: return createFieldPattern();
      case PatternsPackage.CONSTRUCTOR_PATTERN: return createConstructorPattern();
      case PatternsPackage.METHOD_PATTERN: return createMethodPattern();
      case PatternsPackage.TYPE_PATTERN: return createTypePattern();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FieldPattern createFieldPattern()
  {
    FieldPatternImpl fieldPattern = new FieldPatternImpl();
    return fieldPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstructorPattern createConstructorPattern()
  {
    ConstructorPatternImpl constructorPattern = new ConstructorPatternImpl();
    return constructorPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MethodPattern createMethodPattern()
  {
    MethodPatternImpl methodPattern = new MethodPatternImpl();
    return methodPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypePattern createTypePattern()
  {
    TypePatternImpl typePattern = new TypePatternImpl();
    return typePattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternsPackage getPatternsPackage()
  {
    return (PatternsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PatternsPackage getPackage()
  {
    return PatternsPackage.eINSTANCE;
  }

} //PatternsFactoryImpl
