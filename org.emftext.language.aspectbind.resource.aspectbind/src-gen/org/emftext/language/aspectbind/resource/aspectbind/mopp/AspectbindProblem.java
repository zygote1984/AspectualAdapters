/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

public class AspectbindProblem implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindProblem {
	
	private String message;
	private org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemType type;
	private org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemSeverity severity;
	private java.util.Collection<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindQuickFix> quickFixes;
	
	public AspectbindProblem(String message, org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemType type, org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindQuickFix>emptySet());
	}
	
	public AspectbindProblem(String message, org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemType type, org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemSeverity severity, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public AspectbindProblem(String message, org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemType type, org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemSeverity severity, java.util.Collection<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemType getType() {
		return type;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.AspectbindEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
