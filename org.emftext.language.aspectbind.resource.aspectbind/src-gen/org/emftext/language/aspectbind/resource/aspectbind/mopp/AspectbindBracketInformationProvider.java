/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

public class AspectbindBracketInformationProvider {
	
	public class BracketPair implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindBracketPair> result = new java.util.ArrayList<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("(", ")", true));
		result.add(new BracketPair("[", "]", true));
		result.add(new BracketPair("<", ">", true));
		return result;
	}
	
}
