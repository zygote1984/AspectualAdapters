/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.patterns.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.emftext.language.aspectbind.commons.AspectMember;

import org.emftext.language.aspectbind.patterns.Pattern;
import org.emftext.language.aspectbind.patterns.PatternsPackage;

import org.emftext.language.java.classifiers.ConcreteClassifier;

import org.emftext.language.java.commons.CommonsPackage;
import org.emftext.language.java.commons.NamespaceAwareElement;

import org.emftext.language.java.commons.impl.CommentableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.patterns.impl.PatternImpl#getNamespaces <em>Namespaces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PatternImpl extends CommentableImpl implements Pattern {
	/**
   * The cached value of the '{@link #getNamespaces() <em>Namespaces</em>}' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getNamespaces()
   * @generated
   * @ordered
   */
	protected EList<String> namespaces;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected PatternImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PatternsPackage.Literals.PATTERN;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<String> getNamespaces() {
    if (namespaces == null)
    {
      namespaces = new EDataTypeEList<String>(String.class, this, PatternsPackage.PATTERN__NAMESPACES);
    }
    return namespaces;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getNamespacesAsString() {
    java.lang.String containerName = "" ; 
    for ( java.util.Iterator < java.lang.String > it = getNamespaces ( ) .iterator ( ) ; it .hasNext ( ) ; ) { 
      java.lang.String namespaceFragment = it .next ( ) ; 
      //does it point at a classifier or a package as container?
    java.lang.String assumedPackageName = containerName + namespaceFragment + org.emftext.language.java.JavaUniquePathConstructor .PACKAGE_SEPARATOR ; 
      java.lang.String assumedClassifierName = containerName + namespaceFragment + org.emftext.language.java.JavaUniquePathConstructor .CLASSIFIER_SEPARATOR ; 
      if ( it .hasNext ( ) ) { 
        if ( org.emftext.language.java.JavaClasspath .get ( this ) .existsPackage ( assumedClassifierName ) ) { 
          containerName = assumedClassifierName ; 
        } else { 
          //assume package
    containerName = assumedPackageName ; 
        } 
      } else { 
        if ( org.emftext.language.java.JavaClasspath .get ( this ) .existsPackage ( assumedPackageName ) ) { 
          //a package is always available as key
    containerName = assumedPackageName ; 
        } else { 
          //assume classifier that is not key, but value in the map
    containerName = assumedClassifierName ; 
        } 
      } 
    } 
    return containerName ; 
    
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ConcreteClassifier getClassifierAtNamespaces() {
    java.lang.String fullQualifiedName = getNamespacesAsString ( ) ; 
    if ( fullQualifiedName == null || fullQualifiedName .endsWith ( org.emftext.language.java.JavaUniquePathConstructor .PACKAGE_SEPARATOR ) ) { 
      return null ; 
    } 
    //cut the trailing separator
    fullQualifiedName = fullQualifiedName .substring ( 0 , fullQualifiedName .length ( ) - 1 ) ; 
    return ( org.emftext.language.java.classifiers.ConcreteClassifier ) org.eclipse.emf.ecore.util.EcoreUtil .resolve ( getConcreteClassifierProxy ( fullQualifiedName ) , this ) ; 
    
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case PatternsPackage.PATTERN__NAMESPACES:
        return getNamespaces();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case PatternsPackage.PATTERN__NAMESPACES:
        getNamespaces().clear();
        getNamespaces().addAll((Collection<? extends String>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case PatternsPackage.PATTERN__NAMESPACES:
        getNamespaces().clear();
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case PatternsPackage.PATTERN__NAMESPACES:
        return namespaces != null && !namespaces.isEmpty();
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == NamespaceAwareElement.class)
    {
      switch (derivedFeatureID)
      {
        case PatternsPackage.PATTERN__NAMESPACES: return CommonsPackage.NAMESPACE_AWARE_ELEMENT__NAMESPACES;
        default: return -1;
      }
    }
    if (baseClass == AspectMember.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == NamespaceAwareElement.class)
    {
      switch (baseFeatureID)
      {
        case CommonsPackage.NAMESPACE_AWARE_ELEMENT__NAMESPACES: return PatternsPackage.PATTERN__NAMESPACES;
        default: return -1;
      }
    }
    if (baseClass == AspectMember.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (namespaces: ");
    result.append(namespaces);
    result.append(')');
    return result.toString();
  }

} //PatternImpl
