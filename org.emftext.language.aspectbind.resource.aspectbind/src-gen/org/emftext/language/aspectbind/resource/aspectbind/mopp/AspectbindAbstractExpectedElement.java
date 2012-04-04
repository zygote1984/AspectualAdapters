/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class AspectbindAbstractExpectedElement implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	private java.util.Set<org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindPair<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindPair<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>>();
	
	public AspectbindAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.language.aspectbind.resource.aspectbind.IAspectbindExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path) {
		followers.add(new org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindPair<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindPair<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers() {
		return followers;
	}
	
}
