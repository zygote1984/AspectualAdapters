/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class AspectbindRule extends org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public AspectbindRule(org.eclipse.emf.ecore.EClass metaclass, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindChoice choice, org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality) {
		super(cardinality, new org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindChoice getDefinition() {
		return (org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindChoice) getChildren()[0];
	}
	
}

