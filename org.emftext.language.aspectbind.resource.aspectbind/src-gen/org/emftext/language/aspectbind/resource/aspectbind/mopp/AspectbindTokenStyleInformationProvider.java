/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.aspectbind.resource.aspectbind.mopp;

public class AspectbindTokenStyleInformationProvider {
	
	public org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("aspect".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0xFF, 0x00, 0x11}, null, true, false, false, false);
		}
		if ("pointcut".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0xFF, 0x00, 0x11}, null, true, false, false, false);
		}
		if ("instance pointcut".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0xFF, 0x00, 0xAA}, null, true, false, false, false);
		}
		if ("call".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0xFF, 0x00, 0x11}, null, true, false, false, false);
		}
		if ("this".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0xFF, 0x00, 0x11}, null, true, false, false, false);
		}
		if ("args".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0xFF, 0x00, 0x11}, null, true, false, false, false);
		}
		if ("target".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0xFF, 0x00, 0x11}, null, true, false, false, false);
		}
		if ("within".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0xFF, 0x00, 0x11}, null, true, false, false, false);
		}
		if ("adapts".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0xFF, 0x00, 0xAA}, null, true, false, false, false);
		}
		if ("instance".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x11, 0x44, 0x66}, null, false, true, false, false);
		}
		if ("adaptee".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x11, 0xFF, 0x66}, null, false, true, false, false);
		}
		if ("declare adapter:".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0xFF, 0x00, 0xAA}, null, true, false, false, false);
		}
		if ("->".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x00, 0x00, 0x00}, null, true, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, true, false, false);
		}
		if ("SL_COMMENT".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x00, 0x00, 0x80}, null, false, true, false, false);
		}
		if ("STRING_LITERAL".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("IDENTIFIER".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x00, 0x00, 0x00}, null, false, false, false, false);
		}
		if ("abstract".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("assert".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("case".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("catch".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("class".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("continue".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("enum".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("extends".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("import".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("implements".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("interface".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("package".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("super".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("new".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("switch".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("default".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("for".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("if".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("else".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("while".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("try".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("boolean".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("double".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("do".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("instanceof".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("strictfp".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("void".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("throws".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("float".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("final".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("private".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("protected".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("public".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("synchronized".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("int".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("long".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("return".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("static".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("char".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("byte".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("transient".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("null".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("finally".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("throw".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("break".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("native".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("volatile".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("short".equals(tokenName)) {
			return new org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		return null;
	}
	
}
