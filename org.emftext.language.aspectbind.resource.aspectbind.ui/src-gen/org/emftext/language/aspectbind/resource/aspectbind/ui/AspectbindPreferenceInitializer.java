/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.ui;

/**
 * A class used to initialize default preference values.
 */
public class AspectbindPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	private final static org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindAntlrTokenHelper tokenHelper = new org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindAntlrTokenHelper();
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindBracketSet bracketSet = new org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindBracketSet(null, null);
		final java.util.Collection<org.emftext.language.aspectbind.resource.aspectbind.IAspectbindBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.emftext.language.aspectbind.resource.aspectbind.IAspectbindBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.language.aspectbind.resource.aspectbind.IAspectbindMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			
			String tokenName = tokenHelper.getTokenName(tokenNames, i);
			if (tokenName == null) {
				continue;
			}
			org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.aspectbind.resource.aspectbind.ui.AspectbindSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
