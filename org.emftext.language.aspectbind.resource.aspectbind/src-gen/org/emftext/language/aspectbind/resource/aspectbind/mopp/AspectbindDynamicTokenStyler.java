/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

public class AspectbindDynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenStyle getDynamicTokenStyle(org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource resource, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextToken token, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
}
