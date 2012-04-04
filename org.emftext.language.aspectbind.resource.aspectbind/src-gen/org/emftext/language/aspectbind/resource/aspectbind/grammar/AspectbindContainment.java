/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.grammar;

public class AspectbindContainment extends org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindTerminal {
	
	public AspectbindContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
	}
	
	public String toString() {
		return getFeature().getName();
	}
	
}
