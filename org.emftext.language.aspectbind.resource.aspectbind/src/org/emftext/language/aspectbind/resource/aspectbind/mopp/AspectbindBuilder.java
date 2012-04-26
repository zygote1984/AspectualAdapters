/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;


import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;


public class AspectbindBuilder implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		// change this to return true to enable building of all resources
		return true;
	}
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		// set option overrideBuilder to 'false' and then perform build here
//		URI rURI = URI.createURI((CommonPlugin.resolve(resource.getURI()).devicePath()));
//		System.out.println(rURI.devicePath());
//		AspectBindGenerator main = new AspectBindGenerator();
//		
//		if(rURI.fileExtension().equals("aspectbind"))
//		{
//			main.setOutputPath(rURI.trimSegments(2));
//		}
//		else
//		{
//			System.out.println(rURI.fileExtension());
//			throw new RuntimeException();
//		}
//		main.generate(resource);
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
}


