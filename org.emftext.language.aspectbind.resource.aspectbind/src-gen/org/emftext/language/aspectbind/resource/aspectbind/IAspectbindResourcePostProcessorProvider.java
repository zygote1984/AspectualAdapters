/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IAspectbindResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindResourcePostProcessor getResourcePostProcessor();
	
}
