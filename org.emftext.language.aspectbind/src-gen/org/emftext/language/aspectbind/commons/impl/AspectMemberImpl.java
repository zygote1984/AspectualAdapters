/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.commons.impl;

import org.eclipse.emf.ecore.EClass;

import org.emftext.language.aspectbind.commons.AspectMember;
import org.emftext.language.aspectbind.commons.CommonsPackage;

import org.emftext.language.java.commons.impl.NamespaceAwareElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aspect Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AspectMemberImpl extends NamespaceAwareElementImpl implements AspectMember
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AspectMemberImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CommonsPackage.Literals.ASPECT_MEMBER;
  }

} //AspectMemberImpl
