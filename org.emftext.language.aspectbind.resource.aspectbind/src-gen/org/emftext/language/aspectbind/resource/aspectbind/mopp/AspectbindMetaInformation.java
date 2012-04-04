/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

public class AspectbindMetaInformation implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindMetaInformation {
	
	public String getSyntaxName() {
		return "aspectbind";
	}
	
	public String getURI() {
		return "http://www.emftext.org/language/aspectbind";
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextScanner createLexer() {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindAntlrScanner(new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindLexer());
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource resource) {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindReferenceResolverSwitch();
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.language.aspectbind/metamodel/aspectbind.cs";
	}
	
	public String[] getTokenNames() {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindParser(null).getTokenNames();
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindBracketPair> getBracketPairs() {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindResourceFactory();
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "org.emftext.language.aspectbind.resource.aspectbind.ui.launchConfigurationType";
	}
	
}
