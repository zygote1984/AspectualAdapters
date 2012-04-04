/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.grammar;

public class AspectbindChoice extends org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement {
	
	public AspectbindChoice(org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindStringUtil.explode(getChildren(), "|");
	}
	
}
