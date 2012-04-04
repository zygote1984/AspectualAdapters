/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind;

public interface IAspectbindBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindResource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}
