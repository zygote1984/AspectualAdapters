/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.grammar;

public class AspectbindLineBreak extends org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement {
	
	private final int tabs;
	
	public AspectbindLineBreak(org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
