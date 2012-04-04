/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class AspectbindProposalPostProcessor {
	
	public java.util.List<org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCompletionProposal> process(java.util.List<org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
