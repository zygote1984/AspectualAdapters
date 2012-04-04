/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class AspectbindExpectedStructuralFeature extends org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindAbstractExpectedElement {
	
	private org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindPlaceholder placeholder;
	
	public AspectbindExpectedStructuralFeature(org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof AspectbindExpectedStructuralFeature) {
			return getFeature().equals(((AspectbindExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
}
