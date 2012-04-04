/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class AspectbindContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public AspectbindContextDependentURIFragmentFactory(org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
