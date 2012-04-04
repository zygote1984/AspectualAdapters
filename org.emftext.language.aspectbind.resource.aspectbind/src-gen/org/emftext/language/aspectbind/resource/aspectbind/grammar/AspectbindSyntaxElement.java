/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class AspectbindSyntaxElement {
	
	private AspectbindSyntaxElement[] children;
	private AspectbindSyntaxElement parent;
	private org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality;
	
	public AspectbindSyntaxElement(org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality cardinality, AspectbindSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (AspectbindSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	public void setParent(AspectbindSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	public AspectbindSyntaxElement[] getChildren() {
		if (children == null) {
			return new AspectbindSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.grammar.AspectbindCardinality getCardinality() {
		return cardinality;
	}
	
}
