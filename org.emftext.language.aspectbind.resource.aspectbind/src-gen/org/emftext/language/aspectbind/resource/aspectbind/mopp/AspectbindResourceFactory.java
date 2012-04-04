/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

public class AspectbindResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public AspectbindResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindResource(uri);
	}
	
}
