package org.zygote.aspectbind.generator.di;

import org.emftext.language.aspectbind.instancepointcut.InstancePointcut;

public interface IALIA4JGenerator {
	
	
	public void generateAdviceTarget();
	
	public CharSequence generateMaintenance(String aa);
	
	public CharSequence generateParserMethod(String pcexp, String element);
	
	public CharSequence generateSpecialization(String element);
	
	public CharSequence generateAttachment(String element);
	
	public CharSequence generateDeploy();

	public void setIP(InstancePointcut ip);
	
}
