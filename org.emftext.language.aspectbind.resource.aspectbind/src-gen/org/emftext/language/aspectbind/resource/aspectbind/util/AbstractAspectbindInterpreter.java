/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractAspectbindInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindInterpreterListener> listeners = new java.util.ArrayList<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.emftext.language.aspectbind.patterns.TypePattern) {
			result = interprete_org_emftext_language_aspectbind_patterns_TypePattern((org.emftext.language.aspectbind.patterns.TypePattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.patterns.IdPattern) {
			result = interprete_org_emftext_language_aspectbind_patterns_IdPattern((org.emftext.language.aspectbind.patterns.IdPattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.patterns.TypeOrIdPattern) {
			result = interprete_org_emftext_language_aspectbind_patterns_TypeOrIdPattern((org.emftext.language.aspectbind.patterns.TypeOrIdPattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.CallPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_CallPointcut((org.emftext.language.aspectbind.pointcuts.CallPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.ExecutionPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_ExecutionPointcut((org.emftext.language.aspectbind.pointcuts.ExecutionPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.GetPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_GetPointcut((org.emftext.language.aspectbind.pointcuts.GetPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.SetPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_SetPointcut((org.emftext.language.aspectbind.pointcuts.SetPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.HandlerPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_HandlerPointcut((org.emftext.language.aspectbind.pointcuts.HandlerPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.AdviceExecutionPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_AdviceExecutionPointcut((org.emftext.language.aspectbind.pointcuts.AdviceExecutionPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.StaticInitPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_StaticInitPointcut((org.emftext.language.aspectbind.pointcuts.StaticInitPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.InitPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_InitPointcut((org.emftext.language.aspectbind.pointcuts.InitPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.PreInitPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_PreInitPointcut((org.emftext.language.aspectbind.pointcuts.PreInitPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.WithinPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_WithinPointcut((org.emftext.language.aspectbind.pointcuts.WithinPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.WithinCodePointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_WithinCodePointcut((org.emftext.language.aspectbind.pointcuts.WithinCodePointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.ThisPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_ThisPointcut((org.emftext.language.aspectbind.pointcuts.ThisPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.TargetPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_TargetPointcut((org.emftext.language.aspectbind.pointcuts.TargetPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.ArgsPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_ArgsPointcut((org.emftext.language.aspectbind.pointcuts.ArgsPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.CFlowPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_CFlowPointcut((org.emftext.language.aspectbind.pointcuts.CFlowPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.CFlowBelowPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_CFlowBelowPointcut((org.emftext.language.aspectbind.pointcuts.CFlowBelowPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.IfPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_IfPointcut((org.emftext.language.aspectbind.pointcuts.IfPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.PrimitivePointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_PrimitivePointcut((org.emftext.language.aspectbind.pointcuts.PrimitivePointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.AspectJPointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_AspectJPointcut((org.emftext.language.aspectbind.pointcuts.AspectJPointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pointcuts.Pointcut) {
			result = interprete_org_emftext_language_aspectbind_pointcuts_Pointcut((org.emftext.language.aspectbind.pointcuts.Pointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.commons.AspectMember) {
			result = interprete_org_emftext_language_aspectbind_commons_AspectMember((org.emftext.language.aspectbind.commons.AspectMember) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.commons.Aspect) {
			result = interprete_org_emftext_language_aspectbind_commons_Aspect((org.emftext.language.aspectbind.commons.Aspect) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.commons.PerClause) {
			result = interprete_org_emftext_language_aspectbind_commons_PerClause((org.emftext.language.aspectbind.commons.PerClause) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.binding.InstancePointcut) {
			result = interprete_org_emftext_language_aspectbind_binding_InstancePointcut((org.emftext.language.aspectbind.binding.InstancePointcut) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.binding.Instance) {
			result = interprete_org_emftext_language_aspectbind_binding_Instance((org.emftext.language.aspectbind.binding.Instance) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.declaration.AdapterDeclaration) {
			result = interprete_org_emftext_language_aspectbind_declaration_AdapterDeclaration((org.emftext.language.aspectbind.declaration.AdapterDeclaration) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.declaration.PrecedenceDeclaration) {
			result = interprete_org_emftext_language_aspectbind_declaration_PrecedenceDeclaration((org.emftext.language.aspectbind.declaration.PrecedenceDeclaration) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.declaration.InterTypeDeclaration) {
			result = interprete_org_emftext_language_aspectbind_declaration_InterTypeDeclaration((org.emftext.language.aspectbind.declaration.InterTypeDeclaration) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.declaration.Declaration) {
			result = interprete_org_emftext_language_aspectbind_declaration_Declaration((org.emftext.language.aspectbind.declaration.Declaration) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.declaration.Adapter) {
			result = interprete_org_emftext_language_aspectbind_declaration_Adapter((org.emftext.language.aspectbind.declaration.Adapter) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.declaration.Adaptee) {
			result = interprete_org_emftext_language_aspectbind_declaration_Adaptee((org.emftext.language.aspectbind.declaration.Adaptee) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pcexp.PointcutExpressionChild) {
			result = interprete_org_emftext_language_aspectbind_pcexp_PointcutExpressionChild((org.emftext.language.aspectbind.pcexp.PointcutExpressionChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pcexp.PointcutExpression) {
			result = interprete_org_emftext_language_aspectbind_pcexp_PointcutExpression((org.emftext.language.aspectbind.pcexp.PointcutExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pcexp.PointcutOrExpression) {
			result = interprete_org_emftext_language_aspectbind_pcexp_PointcutOrExpression((org.emftext.language.aspectbind.pcexp.PointcutOrExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pcexp.PointcutAndExpression) {
			result = interprete_org_emftext_language_aspectbind_pcexp_PointcutAndExpression((org.emftext.language.aspectbind.pcexp.PointcutAndExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pcexp.PointcutAndExpressionChild) {
			result = interprete_org_emftext_language_aspectbind_pcexp_PointcutAndExpressionChild((org.emftext.language.aspectbind.pcexp.PointcutAndExpressionChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pcexp.PointcutOrExpressionChild) {
			result = interprete_org_emftext_language_aspectbind_pcexp_PointcutOrExpressionChild((org.emftext.language.aspectbind.pcexp.PointcutOrExpressionChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.pcexp.PcAssignmentOperator) {
			result = interprete_org_emftext_language_aspectbind_pcexp_PcAssignmentOperator((org.emftext.language.aspectbind.pcexp.PcAssignmentOperator) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.patterns.AbstractMethodPattern) {
			result = interprete_org_emftext_language_aspectbind_patterns_AbstractMethodPattern((org.emftext.language.aspectbind.patterns.AbstractMethodPattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.patterns.FieldPattern) {
			result = interprete_org_emftext_language_aspectbind_patterns_FieldPattern((org.emftext.language.aspectbind.patterns.FieldPattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.patterns.ConstructorPattern) {
			result = interprete_org_emftext_language_aspectbind_patterns_ConstructorPattern((org.emftext.language.aspectbind.patterns.ConstructorPattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.patterns.MethodPattern) {
			result = interprete_org_emftext_language_aspectbind_patterns_MethodPattern((org.emftext.language.aspectbind.patterns.MethodPattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.aspectbind.patterns.Pattern) {
			result = interprete_org_emftext_language_aspectbind_patterns_Pattern((org.emftext.language.aspectbind.patterns.Pattern) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_commons_AspectMember(org.emftext.language.aspectbind.commons.AspectMember object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_commons_Aspect(org.emftext.language.aspectbind.commons.Aspect object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_commons_PerClause(org.emftext.language.aspectbind.commons.PerClause object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_binding_InstancePointcut(org.emftext.language.aspectbind.binding.InstancePointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_binding_Instance(org.emftext.language.aspectbind.binding.Instance object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_declaration_AdapterDeclaration(org.emftext.language.aspectbind.declaration.AdapterDeclaration object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_declaration_PrecedenceDeclaration(org.emftext.language.aspectbind.declaration.PrecedenceDeclaration object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_declaration_InterTypeDeclaration(org.emftext.language.aspectbind.declaration.InterTypeDeclaration object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_declaration_Declaration(org.emftext.language.aspectbind.declaration.Declaration object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_declaration_Adapter(org.emftext.language.aspectbind.declaration.Adapter object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_declaration_Adaptee(org.emftext.language.aspectbind.declaration.Adaptee object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pcexp_PointcutExpressionChild(org.emftext.language.aspectbind.pcexp.PointcutExpressionChild object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pcexp_PointcutExpression(org.emftext.language.aspectbind.pcexp.PointcutExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pcexp_PointcutOrExpression(org.emftext.language.aspectbind.pcexp.PointcutOrExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pcexp_PointcutOrExpressionChild(org.emftext.language.aspectbind.pcexp.PointcutOrExpressionChild object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pcexp_PointcutAndExpression(org.emftext.language.aspectbind.pcexp.PointcutAndExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pcexp_PointcutAndExpressionChild(org.emftext.language.aspectbind.pcexp.PointcutAndExpressionChild object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pcexp_PcAssignmentOperator(org.emftext.language.aspectbind.pcexp.PcAssignmentOperator object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_patterns_Pattern(org.emftext.language.aspectbind.patterns.Pattern object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_patterns_AbstractMethodPattern(org.emftext.language.aspectbind.patterns.AbstractMethodPattern object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_patterns_FieldPattern(org.emftext.language.aspectbind.patterns.FieldPattern object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_patterns_ConstructorPattern(org.emftext.language.aspectbind.patterns.ConstructorPattern object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_patterns_MethodPattern(org.emftext.language.aspectbind.patterns.MethodPattern object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_patterns_TypePattern(org.emftext.language.aspectbind.patterns.TypePattern object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_patterns_IdPattern(org.emftext.language.aspectbind.patterns.IdPattern object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_patterns_TypeOrIdPattern(org.emftext.language.aspectbind.patterns.TypeOrIdPattern object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_PrimitivePointcut(org.emftext.language.aspectbind.pointcuts.PrimitivePointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_CallPointcut(org.emftext.language.aspectbind.pointcuts.CallPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_ExecutionPointcut(org.emftext.language.aspectbind.pointcuts.ExecutionPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_GetPointcut(org.emftext.language.aspectbind.pointcuts.GetPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_SetPointcut(org.emftext.language.aspectbind.pointcuts.SetPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_HandlerPointcut(org.emftext.language.aspectbind.pointcuts.HandlerPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_AdviceExecutionPointcut(org.emftext.language.aspectbind.pointcuts.AdviceExecutionPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_StaticInitPointcut(org.emftext.language.aspectbind.pointcuts.StaticInitPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_InitPointcut(org.emftext.language.aspectbind.pointcuts.InitPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_PreInitPointcut(org.emftext.language.aspectbind.pointcuts.PreInitPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_WithinPointcut(org.emftext.language.aspectbind.pointcuts.WithinPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_WithinCodePointcut(org.emftext.language.aspectbind.pointcuts.WithinCodePointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_ThisPointcut(org.emftext.language.aspectbind.pointcuts.ThisPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_TargetPointcut(org.emftext.language.aspectbind.pointcuts.TargetPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_ArgsPointcut(org.emftext.language.aspectbind.pointcuts.ArgsPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_CFlowPointcut(org.emftext.language.aspectbind.pointcuts.CFlowPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_CFlowBelowPointcut(org.emftext.language.aspectbind.pointcuts.CFlowBelowPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_IfPointcut(org.emftext.language.aspectbind.pointcuts.IfPointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_Pointcut(org.emftext.language.aspectbind.pointcuts.Pointcut object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_aspectbind_pointcuts_AspectJPointcut(org.emftext.language.aspectbind.pointcuts.AspectJPointcut object, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (org.emftext.language.aspectbind.resource.aspectbind.IAspectbindInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(org.emftext.language.aspectbind.resource.aspectbind.IAspectbindInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.emftext.language.aspectbind.resource.aspectbind.IAspectbindInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
