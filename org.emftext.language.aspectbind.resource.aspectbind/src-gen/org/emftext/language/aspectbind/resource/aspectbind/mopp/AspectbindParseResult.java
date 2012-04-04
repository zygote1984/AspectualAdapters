/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

public class AspectbindParseResult implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindCommand<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource>> commands = new java.util.ArrayList<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindCommand<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource>>();
	
	public AspectbindParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindCommand<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
