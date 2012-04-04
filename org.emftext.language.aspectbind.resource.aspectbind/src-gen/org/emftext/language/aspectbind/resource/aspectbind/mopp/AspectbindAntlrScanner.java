/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

public class AspectbindAntlrScanner implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextScanner {
	
	private org.antlr.runtime3_3_0.Lexer antlrLexer;
	
	public AspectbindAntlrScanner(org.antlr.runtime3_3_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_3_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextToken result = new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_3_0.ANTLRStringStream(text));
	}
	
}
