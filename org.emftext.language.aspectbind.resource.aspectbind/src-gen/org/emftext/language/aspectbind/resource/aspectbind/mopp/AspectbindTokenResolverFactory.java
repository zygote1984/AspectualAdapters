/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

/**
 * The AspectbindTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class AspectbindTokenResolverFactory implements org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolverFactory {
	
	private java.util.Map<String, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver defaultResolver = new org.emftext.language.aspectbind.resource.aspectbind.analysis.AspectbindDefaultTokenResolver();
	
	public AspectbindTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver>();
		registerCollectInTokenResolver("comments", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaCOLLECT_commentsTokenResolver());
		registerCollectInTokenResolver("comments", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaCOLLECT_commentsTokenResolver());
		registerTokenResolver("BOOLEAN_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaBOOLEAN_LITERALTokenResolver());
		registerTokenResolver("CHARACTER_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaCHARACTER_LITERALTokenResolver());
		registerTokenResolver("STRING_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaSTRING_LITERALTokenResolver());
		registerTokenResolver("DECIMAL_LONG_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaDECIMAL_LONG_LITERALTokenResolver());
		registerTokenResolver("HEX_FLOAT_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaHEX_FLOAT_LITERALTokenResolver());
		registerTokenResolver("HEX_DOUBLE_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaHEX_DOUBLE_LITERALTokenResolver());
		registerTokenResolver("HEX_LONG_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaHEX_LONG_LITERALTokenResolver());
		registerTokenResolver("HEX_INTEGER_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaHEX_INTEGER_LITERALTokenResolver());
		registerTokenResolver("DECIMAL_FLOAT_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaDECIMAL_FLOAT_LITERALTokenResolver());
		registerTokenResolver("DECIMAL_DOUBLE_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaDECIMAL_DOUBLE_LITERALTokenResolver());
		registerTokenResolver("DECIMAL_INTEGER_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaDECIMAL_INTEGER_LITERALTokenResolver());
		registerTokenResolver("OCTAL_LONG_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaOCTAL_LONG_LITERALTokenResolver());
		registerTokenResolver("OCTAL_INTEGER_LITERAL", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaOCTAL_INTEGER_LITERALTokenResolver());
		registerTokenResolver("IDENTIFIER", new org.emftext.language.aspectbind.resource.aspectbind.analysis.JavaIDENTIFIERTokenResolver());
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver internalCreateResolver(java.util.Map<String, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver> resolverMap, String key, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
