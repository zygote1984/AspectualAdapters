/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

/**
 * A representation for a range in a document where an enumeration literal (i.e.,
 * a set of static strings) is expected.
 */
public class AspectbindExpectedEnumerationTerminal extends org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindAbstractExpectedElement {
	
	private org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindEnumerationTerminal enumerationTerminal;
	
	public AspectbindExpectedEnumerationTerminal(org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindEnumerationTerminal enumerationTerminal) {
		super(enumerationTerminal.getMetaclass());
		this.enumerationTerminal = enumerationTerminal;
	}
	
	public java.util.Set<String> getTokenNames() {
		// EnumerationTerminals are associated with multiple tokens, one for each literal
		// that was mapped to a string
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>();
		java.util.Map<String, String> mapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : mapping.keySet()) {
			String text = mapping.get(literalName);
			if (text != null && !"".equals(text)) {
				tokenNames.add("'" + text + "'");
			}
		}
		return tokenNames;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindEnumerationTerminal getEnumerationTerminal() {
		return this.enumerationTerminal;
	}
}
