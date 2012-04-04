/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class AspectbindKeyword extends org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement {
	
	private final String value;
	
	public AspectbindKeyword(String value, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
