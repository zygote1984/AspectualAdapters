/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.ui;

public class AspectbindCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.emftext.language.aspectbind.resource.aspectbind.IAspectbindResourceProvider resourceProvider;
	private org.emftext.language.aspectbind.resource.aspectbind.ui.IAspectbindBracketHandlerProvider bracketHandlerProvider;
	
	public AspectbindCompletionProcessor(org.emftext.language.aspectbind.resource.aspectbind.IAspectbindResourceProvider resourceProvider, org.emftext.language.aspectbind.resource.aspectbind.ui.IAspectbindBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource textResource = resourceProvider.getResource();
		String content = viewer.getDocument().get();
		org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCodeCompletionHelper helper = new org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCodeCompletionHelper();
		org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindProposalPostProcessor proposalPostProcessor = new org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindProposalPostProcessor();
		java.util.List<org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCompletionProposal> finalProposalList = new java.util.ArrayList<org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCompletionProposal>();
		for (org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			org.emftext.language.aspectbind.resource.aspectbind.ui.IAspectbindBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
			String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
