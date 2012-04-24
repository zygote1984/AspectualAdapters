/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.analysis;

public class IdPatternIdReferenceResolver implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolver<org.emftext.language.aspectbind.patterns.IdPattern, org.emftext.language.java.references.Reference> {
	
	private org.emftext.language.aspectbind.resource.aspectbind.analysis.AspectbindDefaultResolverDelegate<org.emftext.language.aspectbind.patterns.IdPattern, org.emftext.language.java.references.Reference> delegate = new org.emftext.language.aspectbind.resource.aspectbind.analysis.AspectbindDefaultResolverDelegate<org.emftext.language.aspectbind.patterns.IdPattern, org.emftext.language.java.references.Reference>();
	
	public void resolve(String identifier, org.emftext.language.aspectbind.patterns.IdPattern container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolveResult<org.emftext.language.java.references.Reference> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.java.references.Reference element, org.emftext.language.aspectbind.patterns.IdPattern container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
