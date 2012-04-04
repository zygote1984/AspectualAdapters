/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class AspectbindExpectedCsString extends org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindAbstractExpectedElement {
	
	private org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindKeyword keyword;
	
	public AspectbindExpectedCsString(org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof AspectbindExpectedCsString) {
			return getValue().equals(((AspectbindExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
