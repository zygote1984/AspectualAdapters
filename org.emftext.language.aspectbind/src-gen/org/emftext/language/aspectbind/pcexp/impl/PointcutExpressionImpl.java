/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pcexp.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.aspectbind.commons.impl.AspectMemberImpl;
import org.emftext.language.aspectbind.commons.AspectMember;

import org.emftext.language.aspectbind.pcexp.PcexpPackage;
import org.emftext.language.aspectbind.pcexp.PointcutExpression;
import org.emftext.language.aspectbind.pcexp.PointcutExpressionType;

import org.emftext.language.java.annotations.AnnotationValue;
import org.emftext.language.java.arrays.ArrayInitializationValue;
import org.emftext.language.java.expressions.AssignmentExpressionChild;
import org.emftext.language.java.expressions.ConditionalExpression;
import org.emftext.language.java.expressions.ConditionalExpressionChild;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.ExpressionsPackage;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.classifiers.ConcreteClassifier;

import org.emftext.language.java.commons.CommonsPackage;
import org.emftext.language.java.commons.NamespaceAwareElement;

import org.emftext.language.java.expressions.impl.ExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pointcut Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionImpl#getChild <em>Child</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionImpl#getExpressionIf <em>Expression If</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionImpl#getExpressionElse <em>Expression Else</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.pcexp.impl.PointcutExpressionImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PointcutExpressionImpl extends AspectMemberImpl implements PointcutExpression
{
  /**
   * The cached value of the '{@link #getChild() <em>Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChild()
   * @generated
   * @ordered
   */
  protected ConditionalExpressionChild child;

  /**
   * The cached value of the '{@link #getExpressionIf() <em>Expression If</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionIf()
   * @generated
   * @ordered
   */
  protected Expression expressionIf;

  /**
   * The cached value of the '{@link #getExpressionElse() <em>Expression Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionElse()
   * @generated
   * @ordered
   */
  protected AssignmentExpressionChild expressionElse;

  /**
   * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildren()
   * @generated
   * @ordered
   */
  protected EList<PointcutExpressionType> children;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PointcutExpressionImpl()
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
    return PcexpPackage.Literals.POINTCUT_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalExpressionChild getChild()
  {
    if (child != null && child.eIsProxy())
    {
      InternalEObject oldChild = (InternalEObject)child;
      child = (ConditionalExpressionChild)eResolveProxy(oldChild);
      if (child != oldChild)
      {
        InternalEObject newChild = (InternalEObject)child;
        NotificationChain msgs = oldChild.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__CHILD, null, null);
        if (newChild.eInternalContainer() == null)
        {
          msgs = newChild.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__CHILD, null, msgs);
        }
        if (msgs != null) msgs.dispatch();
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcexpPackage.POINTCUT_EXPRESSION__CHILD, oldChild, child));
      }
    }
    return child;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalExpressionChild basicGetChild()
  {
    return child;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChild(ConditionalExpressionChild newChild, NotificationChain msgs)
  {
    ConditionalExpressionChild oldChild = child;
    child = newChild;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PcexpPackage.POINTCUT_EXPRESSION__CHILD, oldChild, newChild);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChild(ConditionalExpressionChild newChild)
  {
    if (newChild != child)
    {
      NotificationChain msgs = null;
      if (child != null)
        msgs = ((InternalEObject)child).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__CHILD, null, msgs);
      if (newChild != null)
        msgs = ((InternalEObject)newChild).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__CHILD, null, msgs);
      msgs = basicSetChild(newChild, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PcexpPackage.POINTCUT_EXPRESSION__CHILD, newChild, newChild));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpressionIf()
  {
    if (expressionIf != null && expressionIf.eIsProxy())
    {
      InternalEObject oldExpressionIf = (InternalEObject)expressionIf;
      expressionIf = (Expression)eResolveProxy(oldExpressionIf);
      if (expressionIf != oldExpressionIf)
      {
        InternalEObject newExpressionIf = (InternalEObject)expressionIf;
        NotificationChain msgs = oldExpressionIf.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF, null, null);
        if (newExpressionIf.eInternalContainer() == null)
        {
          msgs = newExpressionIf.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF, null, msgs);
        }
        if (msgs != null) msgs.dispatch();
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF, oldExpressionIf, expressionIf));
      }
    }
    return expressionIf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression basicGetExpressionIf()
  {
    return expressionIf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpressionIf(Expression newExpressionIf, NotificationChain msgs)
  {
    Expression oldExpressionIf = expressionIf;
    expressionIf = newExpressionIf;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF, oldExpressionIf, newExpressionIf);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpressionIf(Expression newExpressionIf)
  {
    if (newExpressionIf != expressionIf)
    {
      NotificationChain msgs = null;
      if (expressionIf != null)
        msgs = ((InternalEObject)expressionIf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF, null, msgs);
      if (newExpressionIf != null)
        msgs = ((InternalEObject)newExpressionIf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF, null, msgs);
      msgs = basicSetExpressionIf(newExpressionIf, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF, newExpressionIf, newExpressionIf));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentExpressionChild getExpressionElse()
  {
    if (expressionElse != null && expressionElse.eIsProxy())
    {
      InternalEObject oldExpressionElse = (InternalEObject)expressionElse;
      expressionElse = (AssignmentExpressionChild)eResolveProxy(oldExpressionElse);
      if (expressionElse != oldExpressionElse)
      {
        InternalEObject newExpressionElse = (InternalEObject)expressionElse;
        NotificationChain msgs = oldExpressionElse.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE, null, null);
        if (newExpressionElse.eInternalContainer() == null)
        {
          msgs = newExpressionElse.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE, null, msgs);
        }
        if (msgs != null) msgs.dispatch();
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE, oldExpressionElse, expressionElse));
      }
    }
    return expressionElse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentExpressionChild basicGetExpressionElse()
  {
    return expressionElse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpressionElse(AssignmentExpressionChild newExpressionElse, NotificationChain msgs)
  {
    AssignmentExpressionChild oldExpressionElse = expressionElse;
    expressionElse = newExpressionElse;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE, oldExpressionElse, newExpressionElse);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpressionElse(AssignmentExpressionChild newExpressionElse)
  {
    if (newExpressionElse != expressionElse)
    {
      NotificationChain msgs = null;
      if (expressionElse != null)
        msgs = ((InternalEObject)expressionElse).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE, null, msgs);
      if (newExpressionElse != null)
        msgs = ((InternalEObject)newExpressionElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE, null, msgs);
      msgs = basicSetExpressionElse(newExpressionElse, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE, newExpressionElse, newExpressionElse));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PointcutExpressionType> getChildren()
  {
    if (children == null)
    {
      children = new EObjectContainmentEList<PointcutExpressionType>(PointcutExpressionType.class, this, PcexpPackage.POINTCUT_EXPRESSION__CHILDREN);
    }
    return children;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType()
  {
    return getOneType ( false ) ; 
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getAlternativeType()
  {
    return getOneType ( true ) ; 
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getOneType(boolean alternative)
  {
    org.emftext.language.java.classifiers.Class stringClass = getStringClass ( ) ; 
    org.emftext.language.java.types.Type type = null ; 
    if ( this instanceof org.emftext.language.java.references.Reference ) { 
      org.emftext.language.java.references.Reference reference = ( org.emftext.language.java.references.Reference ) this ; 
      //navigate down references
    while ( reference .getNext ( ) != null ) { 
        reference = reference .getNext ( ) ; 
      } 
      type = reference .getReferencedType ( ) ; 
    } else if ( this instanceof org.emftext.language.java.literals.Literal ) { 
      type = ( ( org.emftext.language.java.literals.Literal ) this ) .getType ( ) ; 
    } else if ( this instanceof org.emftext.language.java.expressions.CastExpression ) { 
      type = ( ( org.emftext.language.java.expressions.CastExpression ) this ) .getTypeReference ( ) .getTarget ( ) ; 
    } else if ( this instanceof org.emftext.language.java.expressions.AssignmentExpression ) { 
      type = ( ( org.emftext.language.java.expressions.AssignmentExpression ) this ) .getChild ( ) .getOneType ( alternative ) ; 
    } else if ( this instanceof org.emftext.language.java.expressions.ConditionalExpression && ( ( org.emftext.language.java.expressions.ConditionalExpression ) this ) .getExpressionIf ( ) != null ) { 
      if ( alternative ) { 
        type = ( ( org.emftext.language.java.expressions.ConditionalExpression ) this ) .getExpressionElse ( ) .getOneType ( alternative ) ; 
      } else { 
        type = ( ( org.emftext.language.java.expressions.ConditionalExpression ) this ) .getExpressionIf ( ) .getOneType ( alternative ) ; 
      } 
    } else if ( this instanceof org.emftext.language.java.expressions.EqualityExpression || this instanceof org.emftext.language.java.expressions.RelationExpression || this instanceof org.emftext.language.java.expressions.ConditionalOrExpression || this instanceof org.emftext.language.java.expressions.ConditionalAndExpression || this instanceof org.emftext.language.java.expressions.InstanceOfExpression ) { 
      type = getLibClass ( "Boolean" ) ; 
    } else if ( this instanceof org.emftext.language.java.expressions.AdditiveExpression || this instanceof org.emftext.language.java.expressions.MultiplicativeExpression || this instanceof org.emftext.language.java.expressions.InclusiveOrExpression || this instanceof org.emftext.language.java.expressions.ExclusiveOrExpression || this instanceof org.emftext.language.java.expressions.AndExpression || this instanceof org.emftext.language.java.expressions.ShiftExpression ) { 
      if ( this instanceof org.emftext.language.java.expressions.AdditiveExpression ) { 
        org.emftext.language.java.expressions.AdditiveExpression additiveExpression = ( org.emftext.language.java.expressions.AdditiveExpression ) this ; 
        for ( org.emftext.language.java.expressions.Expression subExp : additiveExpression .getChildren ( ) ) { 
          if ( stringClass .equals ( subExp .getOneType ( alternative ) ) ) { 
            //special case: string concatenation
    return stringClass ; 
          } 
        } 
      } 
      @ SuppressWarnings ( "unchecked" ) org.emftext.language.java.expressions.Expression subExp = ( ( org.eclipse.emf.common.util.EList < org.emftext.language.java.expressions.Expression > ) this .eGet ( this .eClass ( ) .getEStructuralFeature ( "children" ) ) ) .get ( 0 ) ; 
      return subExp .getOneType ( alternative ) ; 
    } else if ( this instanceof org.emftext.language.java.expressions.UnaryExpression ) { 
      org.emftext.language.java.expressions.Expression subExp = ( ( org.emftext.language.java.expressions.UnaryExpression ) this ) .getChild ( ) ; 
      return subExp .getOneType ( alternative ) ; 
    } else for ( org.eclipse.emf.common.util.TreeIterator < org.eclipse.emf.ecore.EObject > i = this .eAllContents ( ) ; i .hasNext ( ) ; ) { 
      org.eclipse.emf.ecore.EObject next = i .next ( ) ; 
      org.emftext.language.java.types.Type nextType = null ; 
      if ( next instanceof org.emftext.language.java.expressions.PrimaryExpression ) { 
        if ( next instanceof org.emftext.language.java.references.Reference ) { 
          org.emftext.language.java.references.Reference ref = ( org.emftext.language.java.references.Reference ) next ; 
          //navigate down references
    while ( ref .getNext ( ) != null ) { 
            ref = ref .getNext ( ) ; 
          } 
          next = ref ; 
        } 
        if ( next instanceof org.emftext.language.java.literals.Literal ) { 
          nextType = ( ( org.emftext.language.java.literals.Literal ) next ) .getType ( ) ; 
        } else if ( next instanceof org.emftext.language.java.expressions.CastExpression ) { 
          nextType = ( ( org.emftext.language.java.expressions.CastExpression ) next ) .getTypeReference ( ) .getTarget ( ) ; 
        } else { 
          nextType = ( ( org.emftext.language.java.references.Reference ) next ) .getReferencedType ( ) ; 
        } 
        i .prune ( ) ; 
      } 
      if ( nextType != null ) { 
        type = nextType ; 
        //in the special case that this is an expression with
    //some string included, everything is converted to string
    if ( stringClass .equals ( type ) ) { 
          break ; 
        } 
      } 
    } 
    //type can be null in cases of unresolved/unresolvable proxies
    return type ; 
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getArrayDimension()
  {
    long size = 0 ; 
    org.emftext.language.java.arrays.ArrayTypeable arrayType = null ; 
    if ( this instanceof org.emftext.language.java.expressions.NestedExpression && ( ( org.emftext.language.java.expressions.NestedExpression ) this ) .getNext ( ) == null ) { 
      return ( ( org.emftext.language.java.expressions.NestedExpression ) this ) .getExpression ( ) .getArrayDimension ( ) - ( ( org.emftext.language.java.expressions.NestedExpression ) this ) .getArraySelectors ( ) .size ( ) ; 
    } 
    if ( this instanceof org.emftext.language.java.expressions.ConditionalExpression && ( ( org.emftext.language.java.expressions.ConditionalExpression ) this ) .getExpressionIf ( ) != null ) { 
      return ( ( org.emftext.language.java.expressions.ConditionalExpression ) this ) .getExpressionIf ( ) .getArrayDimension ( ) ; 
    } 
    if ( this instanceof org.emftext.language.java.expressions.AssignmentExpression ) { 
      return ( ( org.emftext.language.java.expressions.AssignmentExpression ) this ) .getValue ( ) .getArrayDimension ( ) ; 
    } 
    if ( this instanceof org.emftext.language.java.expressions.InstanceOfExpression ) { 
      return 0 ; 
    } 
    if ( this instanceof org.emftext.language.java.references.Reference ) { 
      org.emftext.language.java.references.Reference reference = ( org.emftext.language.java.references.Reference ) this ; 
      while ( reference .getNext ( ) != null ) { 
        reference = reference .getNext ( ) ; 
      } 
      //an array clone? -> dimension defined by cloned array
    if ( reference instanceof org.emftext.language.java.references.ElementReference && reference .getPrevious ( ) != null ) { 
        org.emftext.language.java.references.ReferenceableElement target = ( ( org.emftext.language.java.references.ElementReference ) reference ) .getTarget ( ) ; 
        if ( target instanceof org.emftext.language.java.members.Method ) { 
          if ( "clone" .equals ( ( ( org.emftext.language.java.members.Method ) target ) .getName ( ) ) ) { 
            reference = ( org.emftext.language.java.references.Reference ) reference .eContainer ( ) ; 
          } 
        } 
      } 
      if ( reference instanceof org.emftext.language.java.references.ElementReference ) { 
        org.emftext.language.java.references.ElementReference elementReference = ( org.emftext.language.java.references.ElementReference ) reference ; 
        if ( elementReference .getTarget ( ) instanceof org.emftext.language.java.arrays.ArrayTypeable ) { 
          arrayType = ( org.emftext.language.java.arrays.ArrayTypeable ) elementReference .getTarget ( ) ; 
        } 
        if ( elementReference .getTarget ( ) instanceof org.emftext.language.java.variables.AdditionalLocalVariable ) { 
          org.emftext.language.java.variables.AdditionalLocalVariable additionalLocalVariable = ( org.emftext.language.java.variables.AdditionalLocalVariable ) elementReference .getTarget ( ) ; 
          arrayType = ( org.emftext.language.java.variables.LocalVariable ) additionalLocalVariable .eContainer ( ) ; 
          size += additionalLocalVariable .getArrayDimensionsAfter ( ) .size ( ) ; 
          size -= arrayType .getArrayDimensionsAfter ( ) .size ( ) ; 
        } 
        if ( elementReference .getTarget ( ) instanceof org.emftext.language.java.members.AdditionalField ) { 
          org.emftext.language.java.members.AdditionalField additionalField = ( org.emftext.language.java.members.AdditionalField ) elementReference .getTarget ( ) ; 
          arrayType = ( org.emftext.language.java.members.Field ) additionalField .eContainer ( ) ; 
          size += additionalField .getArrayDimensionsAfter ( ) .size ( ) ; 
          size -= arrayType .getArrayDimensionsAfter ( ) .size ( ) ; 
        } 
      } else if ( this instanceof org.emftext.language.java.arrays.ArrayTypeable ) { 
        size += ( ( org.emftext.language.java.arrays.ArrayTypeable ) this ) .getArrayDimensionsBefore ( ) .size ( ) + ( ( org.emftext.language.java.arrays.ArrayTypeable ) this ) .getArrayDimensionsAfter ( ) .size ( ) ; 
        if ( this instanceof org.emftext.language.java.parameters.VariableLengthParameter ) { 
          size ++ ; 
        } 
      } 
      size -= reference .getArraySelectors ( ) .size ( ) ; 
    } else if ( this instanceof org.emftext.language.java.arrays.ArrayTypeable ) { 
      size += ( ( org.emftext.language.java.arrays.ArrayTypeable ) this ) .getArrayDimensionsBefore ( ) .size ( ) + ( ( org.emftext.language.java.arrays.ArrayTypeable ) this ) .getArrayDimensionsAfter ( ) .size ( ) ; 
      if ( this instanceof org.emftext.language.java.parameters.VariableLengthParameter ) { 
        size ++ ; 
      } 
    } 
    if ( this instanceof org.emftext.language.java.arrays.ArrayInstantiationBySize ) { 
      size += ( ( org.emftext.language.java.arrays.ArrayInstantiationBySize ) this ) .getSizes ( ) .size ( ) ; 
    } 
    if ( arrayType != null ) { 
      size += arrayType .getArrayDimension ( ) ; 
    } 
    return size ; 
    
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PcexpPackage.POINTCUT_EXPRESSION__CHILD:
        return basicSetChild(null, msgs);
      case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF:
        return basicSetExpressionIf(null, msgs);
      case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE:
        return basicSetExpressionElse(null, msgs);
      case PcexpPackage.POINTCUT_EXPRESSION__CHILDREN:
        return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PcexpPackage.POINTCUT_EXPRESSION__CHILD:
        if (resolve) return getChild();
        return basicGetChild();
      case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF:
        if (resolve) return getExpressionIf();
        return basicGetExpressionIf();
      case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE:
        if (resolve) return getExpressionElse();
        return basicGetExpressionElse();
      case PcexpPackage.POINTCUT_EXPRESSION__CHILDREN:
        return getChildren();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PcexpPackage.POINTCUT_EXPRESSION__CHILD:
        setChild((ConditionalExpressionChild)newValue);
        return;
      case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF:
        setExpressionIf((Expression)newValue);
        return;
      case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE:
        setExpressionElse((AssignmentExpressionChild)newValue);
        return;
      case PcexpPackage.POINTCUT_EXPRESSION__CHILDREN:
        getChildren().clear();
        getChildren().addAll((Collection<? extends PointcutExpressionType>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PcexpPackage.POINTCUT_EXPRESSION__CHILD:
        setChild((ConditionalExpressionChild)null);
        return;
      case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF:
        setExpressionIf((Expression)null);
        return;
      case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE:
        setExpressionElse((AssignmentExpressionChild)null);
        return;
      case PcexpPackage.POINTCUT_EXPRESSION__CHILDREN:
        getChildren().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PcexpPackage.POINTCUT_EXPRESSION__CHILD:
        return child != null;
      case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF:
        return expressionIf != null;
      case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE:
        return expressionElse != null;
      case PcexpPackage.POINTCUT_EXPRESSION__CHILDREN:
        return children != null && !children.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == ArrayInitializationValue.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AnnotationValue.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == Expression.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AssignmentExpressionChild.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ConditionalExpression.class)
    {
      switch (derivedFeatureID)
      {
        case PcexpPackage.POINTCUT_EXPRESSION__CHILD: return ExpressionsPackage.CONDITIONAL_EXPRESSION__CHILD;
        case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF: return ExpressionsPackage.CONDITIONAL_EXPRESSION__EXPRESSION_IF;
        case PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE: return ExpressionsPackage.CONDITIONAL_EXPRESSION__EXPRESSION_ELSE;
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
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == ArrayInitializationValue.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AnnotationValue.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == Expression.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == AssignmentExpressionChild.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    if (baseClass == ConditionalExpression.class)
    {
      switch (baseFeatureID)
      {
        case ExpressionsPackage.CONDITIONAL_EXPRESSION__CHILD: return PcexpPackage.POINTCUT_EXPRESSION__CHILD;
        case ExpressionsPackage.CONDITIONAL_EXPRESSION__EXPRESSION_IF: return PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_IF;
        case ExpressionsPackage.CONDITIONAL_EXPRESSION__EXPRESSION_ELSE: return PcexpPackage.POINTCUT_EXPRESSION__EXPRESSION_ELSE;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //PointcutExpressionImpl
