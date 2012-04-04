/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.util;

/**
 * Class AspectbindTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindResourceUtil.
 */
public class AspectbindTextResourceUtil {
	
	@Deprecated	
	public static org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindResource getResource(org.eclipse.core.resources.IFile file) {
		return org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindResourceUtil.getResource(file);
	}
	
	@Deprecated	
	public static org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindResourceUtil.getResource(file, options);
	}
	
	@Deprecated	
	public static org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindResourceUtil.getResource(uri);
	}
	
	@Deprecated	
	public static org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindResourceUtil.getResource(uri, options);
	}
	
}
