/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.grammar;

public class AspectbindCompound extends org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement {
	
	public AspectbindCompound(org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindChoice choice, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality) {
		super(cardinality, new org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
