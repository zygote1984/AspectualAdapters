/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.aspectbind.pointcuts.impl;

import org.eclipse.emf.ecore.EClass;

import org.emftext.language.aspectbind.commons.impl.AspectMemberImpl;

import org.emftext.language.aspectbind.pointcuts.PointcutsPackage;
import org.emftext.language.aspectbind.pointcuts.PrimitivePointcut;

import org.emftext.language.java.types.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class PrimitivePointcutImpl extends AspectMemberImpl implements PrimitivePointcut
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimitivePointcutImpl()
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
    return PointcutsPackage.Literals.PRIMITIVE_POINTCUT;
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

} //PrimitivePointcutImpl
