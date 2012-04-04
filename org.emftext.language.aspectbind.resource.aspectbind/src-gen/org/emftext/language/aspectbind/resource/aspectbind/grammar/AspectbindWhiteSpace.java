/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.grammar;

public class AspectbindWhiteSpace extends org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindFormattingElement {
	
	private final int amount;
	
	public AspectbindWhiteSpace(int amount, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
