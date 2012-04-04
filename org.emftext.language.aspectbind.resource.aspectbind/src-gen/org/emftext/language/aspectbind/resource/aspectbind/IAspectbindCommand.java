/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IAspectbindCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
