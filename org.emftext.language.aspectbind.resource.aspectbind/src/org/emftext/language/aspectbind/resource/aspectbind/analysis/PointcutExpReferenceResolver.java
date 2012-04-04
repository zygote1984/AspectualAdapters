/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.analysis;

public class PointcutExpReferenceResolver implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolver<org.emftext.language.aspectbind.pointcuts.Pointcut, org.emftext.language.aspectbind.pcexp.PointcutExpression> {
	
	private org.emftext.language.aspectbind.resource.aspectbind.analysis.AspectbindDefaultResolverDelegate<org.emftext.language.aspectbind.pointcuts.Pointcut, org.emftext.language.aspectbind.pcexp.PointcutExpression> delegate = new org.emftext.language.aspectbind.resource.aspectbind.analysis.AspectbindDefaultResolverDelegate<org.emftext.language.aspectbind.pointcuts.Pointcut, org.emftext.language.aspectbind.pcexp.PointcutExpression>();
	
	public void resolve(String identifier, org.emftext.language.aspectbind.pointcuts.Pointcut container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolveResult<org.emftext.language.aspectbind.pcexp.PointcutExpression> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.aspectbind.pcexp.PointcutExpression element, org.emftext.language.aspectbind.pointcuts.Pointcut container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
