/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind;

public interface IAspectbindProblem {
	public String getMessage();
	public org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemSeverity getSeverity();
	public org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemType getType();
	public java.util.Collection<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindQuickFix> getQuickFixes();
}
