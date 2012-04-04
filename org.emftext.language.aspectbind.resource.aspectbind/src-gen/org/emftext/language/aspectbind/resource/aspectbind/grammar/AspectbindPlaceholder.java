/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class AspectbindPlaceholder extends org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindTerminal {
	
	private final String tokenName;
	
	public AspectbindPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
