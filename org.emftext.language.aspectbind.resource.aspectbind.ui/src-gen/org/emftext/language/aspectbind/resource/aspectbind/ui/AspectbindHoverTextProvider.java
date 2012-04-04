/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.ui;

public class AspectbindHoverTextProvider implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindHoverTextProvider {
	
	private org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindDefaultHoverTextProvider defaultProvider = new org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindDefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject referencedObject) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(referencedObject);
	}
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
