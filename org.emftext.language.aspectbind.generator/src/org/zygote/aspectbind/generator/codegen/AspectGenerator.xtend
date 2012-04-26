package org.zygote.aspectbind.generator.codegen

import com.google.inject.Inject
import java.io.FileOutputStream
import java.io.OutputStream
import org.eclipse.emf.ecore.resource.Resource
import org.emftext.language.aspectbind.binding.impl.InstancePointcutImpl
import org.emftext.language.aspectbind.commons.impl.AspectImpl
import org.emftext.language.aspectbind.pcexp.PointcutExpression
import org.emftext.language.aspectbind.pointcuts.AspectJPointcut
import org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl
import org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindPrinter
import org.emftext.language.java.imports.Import
import org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource
import java.io.ByteArrayOutputStream
import org.emftext.language.aspectbind.commons.Aspect
import java.util.HashMap
import org.emftext.language.aspectbind.binding.InstancePointcut
import org.emftext.language.aspectbind.patterns.ConstructorPattern
import org.emftext.language.aspectbind.pointcuts.TargetPointcut
import org.emftext.language.aspectbind.pointcuts.impl.TargetPointcutImpl
import org.emftext.language.aspectbind.patterns.impl.ConstructorPatternImpl
import java.util.ArrayList
import org.emftext.language.aspectbind.pointcuts.PrimitivePointcut
import org.emftext.language.aspectbind.pointcuts.CallPointcut


class AspectGenerator{
	
	
	boolean print = true

	ByteArrayOutputStream output =  new ByteArrayOutputStream()
	AspectBindPrinterSub printer 
	Resource resource
	Aspect aspect
	
	new(Resource resource)
	{
		this.resource = resource
		printer = new AspectBindPrinterSub(output,resource as IAspectbindTextResource)
		

	}
	
	def setAspect(Aspect aspect)
	{
		this.aspect = aspect;
	}
	
	//ASPECT GENERATION ENTRY
	def generateAspect() '''
	«IF aspect.getPackage != null»
	«packagePrinter(aspect.getPackage)»
	«ENDIF»
	
	«Utility::generateImports(aspect.getPackage.imports)»
	
	«IF aspect.priviliged» "privileged" «ELSE»  «ENDIF» aspect «aspect.name» «IF aspect.extend != null» extends «aspect.extend» «ENDIF»
	{
		«var pcs = aspect.members.filter(typeof(PointcutImpl))»
		«FOR p:pcs»
		«generatePointcut(p)»
		«ENDFOR»
	}
	'''
	
	//ASPECTJ POINTCUT GENERATOR
	def dispatch generatePointcut(AspectJPointcut pc)
	'''
	«IF pc.abstract != null»«printer.print(pc.abstract)»«output»«ENDIF»pointcut «pc.name»(«Utility::parameterExpand(pc.parameters)») «IF pc.exp !=null» : «generateExpression(pc.exp as PointcutExpression)» «ENDIF» ;
	'''
	
	//INSTANCE POINTCUT GENERATOR
	def dispatch generatePointcut(InstancePointcut pc)
	'''
	«var instanceType = Utility::resolveReference(pc.instanceType.type.pureClassifierReference)»
	«IF !pc.exp.eAllContents.filter(typeof(ConstructorPatternImpl)).toList.empty  && !pc.exp.eAllContents.filter(typeof(TargetPointcutImpl)).toList.empty»
	«IF pc.abstract != null»«printer.print(pc.abstract)»«output»«ENDIF»pointcut «pc.name»() «IF pc.exp!=null» : «generatePointcut(pc.exp.eAllContents.filter(typeof(CallPointcut)).toList.head)» «ENDIF» ;
	«ELSE»
	«IF pc.abstract != null»«printer.print(pc.abstract)»«output»«ENDIF»pointcut «pc.name»(«instanceType» instance) «IF pc.exp!=null» : «generateExpression(pc.exp as PointcutExpression)» «ENDIF» ;
	«ENDIF»
	«IF AdapterRegistry::getAdaptersForAspectip(aspect,pc) != null»
		«generateHashMap(pc as InstancePointcut)»
		«generateAdvice(pc as InstancePointcut)»
	«ENDIF»
	'''
	
	def generateAdvice(InstancePointcut pc)
	{
		
		'''
		«IF pc.exp != null»
			«IF !pc.exp.eAllContents.filter(typeof(ConstructorPatternImpl)).toList.empty  && !pc.exp.eAllContents.filter(typeof(TargetPointcutImpl)).toList.empty»
			 after() returning(«Utility::resolveReference(pc.instanceType)» instance): «pc.name»()
			«ELSE»
			 after(«Utility::resolveReference(pc.instanceType)» instance): «pc.name»(instance)	
			«ENDIF»
		«ENDIF»
		{
			«generateAdapterInit(pc)»
		}
		'''	
	}
	
	
	def generateHashMap(InstancePointcut pc){
		
		var ArrayList<AdapterRecord> list = AdapterRegistry::getAdaptersForAspectip(aspect,pc)
		var CharSequence ra
		for(r:list)
		{
			var mapName = r.instanceType + "_" + r.adapterName + "_map"
				ra = '''WeakHashMap<«r.instanceType», «r.adapterName»>  «mapName» = new WeakHashMap<«r.instanceType», «r.adapterName»>(); '''
		}	
		return ra
	}
	
	
	def generateAdapterInit(InstancePointcut pc){
		var ArrayList<AdapterRecord> list = AdapterRegistry::getAdaptersForAspectip(aspect,pc)
		var  ra = " "
	
			for(r:list)
			{
				var mapName = r.instanceType + "_" + r.adapterName + "_map"
				if(r.isSubtype)
				{
					//System::out.println("R is subtype")
					ra =  ra + " if(instance instanceof " +  r.instanceType + ")\n" +
							mapName + ".put((" + r.instanceType + ")instance, new " + r.adapterName + "((" + r.instanceType + ")instance));\n"
				}
				else
				{
					ra = ra + mapName + ".put(instance, new " + r.adapterName + "(instance));\n"
				}
					
			}
			return ra
	}
	
	def packagePrinter(org.emftext.language.java.containers.Package p)
	{
		printer.print(p)
		var value = output.toString
		output.reset	
		printer = new AspectBindPrinterSub(output,resource as IAspectbindTextResource)
		return value
	}
	
	
	//PRIMITIVE POINTCUT PRINTER
	def dispatch generatePointcut(PrimitivePointcut exp)
	{
		printer.print(exp)
		var value = output.toString
		output.reset	
		printer = new AspectBindPrinterSub(output,resource as IAspectbindTextResource)
		return value
	}
	
	//EXPRESSION PRINTER
	def generateExpression(PointcutExpression exp)
	{
		printer.print(exp)
		var value = output.toString
		output.reset	
		printer = new AspectBindPrinterSub(output,resource as IAspectbindTextResource)
		return value
	}
	
	
	
	
	
}