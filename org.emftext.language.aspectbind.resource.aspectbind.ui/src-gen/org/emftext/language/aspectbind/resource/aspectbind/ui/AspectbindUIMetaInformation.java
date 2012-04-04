/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.ui;

public class AspectbindUIMetaInformation extends org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindMetaInformation {
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindHoverTextProvider();
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindImageProvider getImageProvider() {
		return org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindImageProvider.INSTANCE;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindColorManager createColorManager() {
		return new org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.language.aspectbind.resource.aspectbind.IAspectbi
	 * ndTextResource,
	 * org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindColorManager)
	 * instead.
	 */
	public org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindTokenScanner createTokenScanner(org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindTokenScanner createTokenScanner(org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource resource, org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindColorManager colorManager) {
		return new org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindTokenScanner(resource, colorManager);
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCodeCompletionHelper();
	}
	
}
