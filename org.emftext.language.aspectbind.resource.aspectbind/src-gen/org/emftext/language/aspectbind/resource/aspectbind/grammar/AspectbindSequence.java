/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.grammar;

public class AspectbindSequence extends org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement {
	
	public AspectbindSequence(org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.language.aspectbind.resource.aspectbind.util.AspectbindStringUtil.explode(getChildren(), " ");
	}
	
}
