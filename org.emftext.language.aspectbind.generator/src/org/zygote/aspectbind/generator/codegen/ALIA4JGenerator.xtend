package org.zygote.aspectbind.generator.codegen

import org.zygote.aspectbind.generator.di.IALIA4JGenerator
import org.emftext.language.aspectbind.instancepointcut.InstancePointcut
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider

class ALIA4JGenerator implements IALIA4JGenerator {
	
	InstancePointcut ip
	String adviceTarget = ""

	String liam = "org.alia4j.liam."
	String parserfqn = "org.alia4j.aspectj.parser.ast."
	String zygotelib = "zygote.instancepc.lib.alia4j."
		String parserclass = zygotelib + "ALIA4JParser"
	String specclass = zygotelib  + "ALIA4JSpecializationModule"
	String attachclass = zygotelib + "ALIA4JAttachmentModule"
	
	new()
	{

	}
	

	def ipToALIA(String pcexp, String element)
	{
		
		'''
		«generateAdviceTarget»
		public void createAttachmentFor«ip.name.toFirstUpper»«element.toFirstUpper»(){
			«generateParserMethod(pcexp, element)»
			«generateSpecialization(element)»
		}
		'''
	}
	
	
	override setIP(InstancePointcut ip)
	{
		this.ip = ip;
	}


	
	override generateDeploy() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override generateParserMethod(String pcexp, String element) {
		var parser = "parser_" + ip.name + "_" +  element
		var method = "parse"+ip.name.toFirstUpper+element.toFirstUpper
		'''
		«parserfqn»AJPointcutParser «parser» = «parserclass».parseExpression("«pcexp»");
		'''
	}
	
	override generateSpecialization(String element) {
		var specset = "spec_" + ip.name + "_" +  element
		var method = "initSpecialization"+ip.name.toFirstUpper+element.toFirstUpper
		var instanceType = Utility::resolveReference(ip.instanceType.type.pureClassifierReference)
		var parser = "parser_" + ip.name + "_" +  element
		'''
«««		HashMap<String, Class<? extends Object>> args = new HashMap<String,Class<? extends Object>>();
«««		args.put("instance", «instanceType».class);
		Set<«liam»Specialization> «specset» = «specclass».createFromStaticMethod(«parser», «instanceType».class);
		
		«generateAttachment(element)»
		'''
	}
	
	override generateAttachment(String element) {
		var specset = "spec_" + ip.name + "_" +  element
		var adviceMethod = ""
		var scheduleinfo = ""
		var instanceType = Utility::resolveReference(ip.instanceType.type.pureClassifierReference)
		var parser = "parser_" + ip.name + "_" +  element
		var attachment  = "attachment_" + ip.name + "_" +  element
		
		switch element{
			case "ba":
			{
				adviceMethod = "addToSet"
				scheduleinfo =  "ScheduleInfo.BEFORE"
			}
			case "aa":
			{
				adviceMethod = "addToSet"
				scheduleinfo =  "ScheduleInfo.AFTER"
			}
			case "br":
			{
				adviceMethod = "removeFromSet"
				scheduleinfo =  "ScheduleInfo.BEFORE"
			}
			case "ar":
			{
				adviceMethod = "removeFromSet"
				scheduleinfo =  "ScheduleInfo.AFTER"
			}
			
		}
		scheduleinfo = liam + scheduleinfo
		'''
        «liam»Attachment «attachment» = «attachclass».createStaticAttachment(«specset», «adviceTarget».class, 
        							"«adviceMethod»", new Class[] {«instanceType».class}, «scheduleinfo»);

        org.alia4j.fial.System.deploy(«attachment»);
		
		
		'''
	}
	

	override generateAdviceTarget() {
		adviceTarget = ip.name.toFirstUpper + "AdviceTarget"
		AspectBindGenerator::getFSA().generateFile(adviceTarget + ".java", generateMaintenance(adviceTarget))
	}
	
	override generateMaintenance(String adviceTarget) {
		var instanceType = Utility::resolveReference(ip.instanceType.type.pureClassifierReference)
		var setName = ip.name  + "_set"
		
		
		'''
		package «AspectGenerator::packageNameAspect»;
		
		import com.google.common.collect.*;
		
		public class «adviceTarget»
		{
			static Multiset<«instanceType»> «setName» = HashMultiset.create();
			
			public static boolean addToSet(«instanceType» o)
			{
				return «setName».add(o);
			}
			
			public static boolean removeFromSet(«instanceType» o)
			{
				return «setName».remove(o);	
			}
			
		}	
		'''
	}
	


	
}