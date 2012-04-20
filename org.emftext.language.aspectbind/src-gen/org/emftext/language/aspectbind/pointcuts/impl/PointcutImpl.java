/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.aspectbind.commons.impl.AspectMemberImpl;

import org.emftext.language.aspectbind.pointcuts.Pointcut;
import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;

import org.emftext.language.java.annotations.AnnotationValue;

import org.emftext.language.java.arrays.ArrayInitializationValue;

import org.emftext.language.java.commons.CommonsPackage;
import org.emftext.language.java.commons.NamedElement;

import org.emftext.language.java.expressions.ConditionalExpression;
import org.emftext.language.java.expressions.Expression;

import org.emftext.language.java.modifiers.Abstract;

import org.emftext.language.java.operators.AssignmentOperator;

import org.emftext.language.java.types.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl#getAssign <em>Assign</em>}</li>
 *   <li>{@link org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PointcutImpl extends AspectMemberImpl implements Pointcut {
	/**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected static final String NAME_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected String name = NAME_EDEFAULT;

	/**
   * The cached value of the '{@link #getAbstract() <em>Abstract</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAbstract()
   * @generated
   * @ordered
   */
	protected Abstract abstract_;

	/**
   * The cached value of the '{@link #getAssign() <em>Assign</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAssign()
   * @generated
   * @ordered
   */
	protected AssignmentOperator assign;

	/**
   * The cached value of the '{@link #getExp() <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getExp()
   * @generated
   * @ordered
   */
	protected ConditionalExpression exp;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected PointcutImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PointcutsPackage.Literals.POINTCUT;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getName() {
    return name;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PointcutsPackage.POINTCUT__NAME, oldName, name));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Abstract getAbstract() {
    return abstract_;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetAbstract(Abstract newAbstract, NotificationChain msgs) {
    Abstract oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PointcutsPackage.POINTCUT__ABSTRACT, oldAbstract, newAbstract);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setAbstract(Abstract newAbstract) {
    if (newAbstract != abstract_)
    {
      NotificationChain msgs = null;
      if (abstract_ != null)
        msgs = ((InternalEObject)abstract_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PointcutsPackage.POINTCUT__ABSTRACT, null, msgs);
      if (newAbstract != null)
        msgs = ((InternalEObject)newAbstract).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PointcutsPackage.POINTCUT__ABSTRACT, null, msgs);
      msgs = basicSetAbstract(newAbstract, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PointcutsPackage.POINTCUT__ABSTRACT, newAbstract, newAbstract));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AssignmentOperator getAssign() {
    return assign;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetAssign(AssignmentOperator newAssign, NotificationChain msgs) {
    AssignmentOperator oldAssign = assign;
    assign = newAssign;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PointcutsPackage.POINTCUT__ASSIGN, oldAssign, newAssign);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setAssign(AssignmentOperator newAssign) {
    if (newAssign != assign)
    {
      NotificationChain msgs = null;
      if (assign != null)
        msgs = ((InternalEObject)assign).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PointcutsPackage.POINTCUT__ASSIGN, null, msgs);
      if (newAssign != null)
        msgs = ((InternalEObject)newAssign).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PointcutsPackage.POINTCUT__ASSIGN, null, msgs);
      msgs = basicSetAssign(newAssign, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PointcutsPackage.POINTCUT__ASSIGN, newAssign, newAssign));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ConditionalExpression getExp() {
    return exp;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetExp(ConditionalExpression newExp, NotificationChain msgs) {
    ConditionalExpression oldExp = exp;
    exp = newExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PointcutsPackage.POINTCUT__EXP, oldExp, newExp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setExp(ConditionalExpression newExp) {
    if (newExp != exp)
    {
      NotificationChain msgs = null;
      if (exp != null)
        msgs = ((InternalEObject)exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PointcutsPackage.POINTCUT__EXP, null, msgs);
      if (newExp != null)
        msgs = ((InternalEObject)newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PointcutsPackage.POINTCUT__EXP, null, msgs);
      msgs = basicSetExp(newExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PointcutsPackage.POINTCUT__EXP, newExp, newExp));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Type getType() {
    return getOneType ( false ) ; 
    
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Type getAlternativeType() {
    return getOneType ( true ) ; 
    
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Type getOneType(boolean alternative) {
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
	public long getArrayDimension() {
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case PointcutsPackage.POINTCUT__ABSTRACT:
        return basicSetAbstract(null, msgs);
      case PointcutsPackage.POINTCUT__ASSIGN:
        return basicSetAssign(null, msgs);
      case PointcutsPackage.POINTCUT__EXP:
        return basicSetExp(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case PointcutsPackage.POINTCUT__NAME:
        return getName();
      case PointcutsPackage.POINTCUT__ABSTRACT:
        return getAbstract();
      case PointcutsPackage.POINTCUT__ASSIGN:
        return getAssign();
      case PointcutsPackage.POINTCUT__EXP:
        return getExp();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case PointcutsPackage.POINTCUT__NAME:
        setName((String)newValue);
        return;
      case PointcutsPackage.POINTCUT__ABSTRACT:
        setAbstract((Abstract)newValue);
        return;
      case PointcutsPackage.POINTCUT__ASSIGN:
        setAssign((AssignmentOperator)newValue);
        return;
      case PointcutsPackage.POINTCUT__EXP:
        setExp((ConditionalExpression)newValue);
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
      case PointcutsPackage.POINTCUT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case PointcutsPackage.POINTCUT__ABSTRACT:
        setAbstract((Abstract)null);
        return;
      case PointcutsPackage.POINTCUT__ASSIGN:
        setAssign((AssignmentOperator)null);
        return;
      case PointcutsPackage.POINTCUT__EXP:
        setExp((ConditionalExpression)null);
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
      case PointcutsPackage.POINTCUT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case PointcutsPackage.POINTCUT__ABSTRACT:
        return abstract_ != null;
      case PointcutsPackage.POINTCUT__ASSIGN:
        return assign != null;
      case PointcutsPackage.POINTCUT__EXP:
        return exp != null;
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
    if (baseClass == NamedElement.class)
    {
      switch (derivedFeatureID)
      {
        case PointcutsPackage.POINTCUT__NAME: return CommonsPackage.NAMED_ELEMENT__NAME;
        default: return -1;
      }
    }
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
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == NamedElement.class)
    {
      switch (baseFeatureID)
      {
        case CommonsPackage.NAMED_ELEMENT__NAME: return PointcutsPackage.POINTCUT__NAME;
        default: return -1;
      }
    }
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //PointcutImpl
