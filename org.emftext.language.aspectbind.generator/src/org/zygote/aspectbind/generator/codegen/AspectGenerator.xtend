package org.zygote.aspectbind.generator.codegen

import java.io.ByteArrayOutputStream
import java.util.ArrayList
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.Resource
import org.emftext.language.aspectbind.commons.Aspect
import org.emftext.language.aspectbind.pcexp.PointcutExpression
import org.emftext.language.aspectbind.pointcuts.AspectJPointcut
import org.emftext.language.aspectbind.pointcuts.PrimitivePointcut
import org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl
import org.emftext.language.aspectbind.reference.InstancePointcutReference
import org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource
import org.emftext.language.java.containers.Package
import org.emftext.language.aspectbind.instancepointcut.InstancePointcut
import org.emftext.language.aspectbind.instancepointcut.IpReturning
import org.emftext.language.aspectbind.instancepointcut.IpExpression
import org.emftext.language.aspectbind.instancepointcut.BeforeElement
import org.emftext.language.aspectbind.instancepointcut.AfterElement
import org.emftext.language.aspectbind.instancepointcut.IpExpressionAll
import com.google.inject.Inject


class AspectGenerator{
	
	ALIA4JGenerator aliagen = AspectBindGenerator::injector.getInstance(typeof(ALIA4JGenerator))
	boolean print = true
	public static String packageNameAspect 
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
		this.aspect = aspect
		packageNameAspect = aspect.getPackage.name
		
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
	
	def dispatch generatePointcut(InstancePointcut pc)	
	{

		'''
		«generateInstancePc(pc, PcExpType::SELECT)»
		«IF pc.removeExp != null»
			«generateInstancePc(pc, PcExpType::REMOVE)»
		«ENDIF»				
	

		'''
	}
	
	
	def boolean checkReturning(PointcutExpression exp)
	{
		return !exp.eAllContents.filter(typeof(InstancePointcutReference)).empty
	}
	
	
	
	def generateIPExpression(PointcutExpression expTemp)
	'''
		«FOR a:expTemp.eAllContents.filter(typeof(PrimitivePointcut)).toList»
			«IF !(a instanceof IpReturning) && !(a instanceof InstancePointcutReference)»
				«generatePointcut(a)»
			«ENDIF»
		«ENDFOR»	
	'''
	
	def generateInstancePc(InstancePointcut pc, PcExpType type)
	{
		var pcname = "" 
		var setOperation = " "
		var setName = pc.name + "_set";
		var IpExpression expTemp;
		var instanceType = Utility::resolveReference(pc.instanceType.type.pureClassifierReference)
		aliagen.setIP(pc);
		//System::out.println("[generate instance pointcut] " + pc.eAllContents.toList)
		switch type{
			 case PcExpType::REMOVE:{
			 	System::out.println("[generate instance pointcut] generate remove expression")
				setOperation = 'remove';
				expTemp = pc.removeExp;
				generateIpExpression(expTemp, "r")
			}
			case PcExpType::SELECT :{
				System::out.println("[generate instance pointcut] generate add expression")
				pcname = pc.name;
				setOperation = 'add';
				expTemp = pc.addExp;
				generateIpExpression(expTemp, "a")
			}
		}
//		'''
//		«IF !expTemp.eAllContents.filter(typeof(IpReturning)).empty»
//		pointcut «pcname»(): «generateIPExpression(expTemp)»	
//		;	
//		
//		after() returning(«instanceType» instance):«pcname»()
//		{
//			«setName».«setOperation»(instance);
//		}
//		«ELSE»
//		pointcut «pcname»(«instanceType» instance): «generateIPExpression(expTemp)»;	
//		after(«instanceType» instance):«pcname»(instance){
//			«setName».«setOperation»(instance);
//		}
//		«ENDIF»
//		'''
	}
	
	//INSTANCE POINTCUT EXPRESSION GENERATOR
	def generateIpExpression(IpExpression exp, String exptype)
	{
		var CharSequence seq = ""
		switch exp
		{
			BeforeElement:
			{
				seq = aliagen.ipToALIA(generateExpression(exp.pcexp as PointcutExpression), "b"+exptype)
				//System::out.println("[generate Before Expression]" + generateExpression(exp.pcexp as PointcutExpression))
			}
			AfterElement:
		 	{
		 		seq = aliagen.ipToALIA(generateExpression(exp.pcexp as PointcutExpression), "a"+exptype)
		 	}	
		 	IpExpressionAll:
			{
				seq = aliagen.ipToALIA(generateExpression(exp.before.pcexp as PointcutExpression), "b"+exptype)
				seq = seq  aliagen.ipToALIA(generateExpression(exp.after.pcexp as PointcutExpression), "a"+exptype)
			}
		}
		return seq
	}
	
	
	
	def preProcessIPcReference(InstancePointcutReference ipc, boolean returning)
	{
		var ip = Utility::resolveReference(ipc.ipc as InternalEObject, resource) as InstancePointcut
		var instanceType = Utility::resolveReference(ip.instanceType.type.pureClassifierReference)
		
		var newpc = ""
		var type = "" 
		var ipname = ""
		if(ipc.refinement != null)
		{

			type = Utility::resolveReference(ipc.refinement)
			var newpcname = ip.name + "_" + type
			if(returning)
			{
				newpcname = newpcname + "_set"
				'''
				Set<«type»> «newpcname» = new TreeSet<«type»>();
				
				after() returning(«instanceType» instance):«ip.name»()
				{
					if(instance instanceof «type»)
						«newpcname».add(instance);
				}
				'''
			}
			else
			{
				'''
				«ip.name»(instance) && if(instance instanceof «type»)
				'''
			}
			
		}

//		if(checkReturning(ip.exp as PointcutExpression))
//			newpc = ipname + "()"
//		else	
//			newpc = ipname + "(instance)";
			
	}
	
//	def generateAdapterHooks(InstancePointcut pc)
//	'''
//		«IF AdapterRegistry::getAdaptersForAspectip(aspect,pc) != null»
//			«generateHashMap(pc as InstancePointcut)»
//			«generateAdvice(pc as InstancePointcut)»
//		«IF pc.removeExp != null»
//			«generateAdviceRemove(pc.removeExp as PointcutExpression, pc as InstancePointcut)»
//		«ENDIF»
//		«ENDIF»
//	'''
	
	
//	def generateAdvice(InstancePointcut pc)
//	{
//		
//		'''
//		«IF pc.exp != null»
//			«IF !pc.exp.eAllContents.filter(typeof(IpReturning)).toList.empty»
//			 after() returning(«Utility::resolveReference(pc.instanceType)» instance): «pc.name»()
//			«ELSE»
//			 after(«Utility::resolveReference(pc.instanceType)» instance): «pc.name»(instance)	
//			«ENDIF»
//		«ENDIF»
//		{
//			«generateAdapterInit(pc)»
//		}
//		'''	
//	}
	
//	def generateAdviceRemove(PointcutExpression exp, InstancePointcut pcut)
//	{
//		
//		'''
//			«IF !exp.eAllContents.filter(typeof(IpReturning)).toList.empty»
//			 after() returning(«Utility::resolveReference(pcut.instanceType)» instance): «pcut.name»_remove()
//			«ELSE»
//			 after(«Utility::resolveReference(pcut.instanceType)» instance): «pcut.name»_remove(instance)	
//			«ENDIF»
//		{
//			«generateAdapterRemove(pcut)»
//		}
//		'''	
//	}
	
	
//	def generateHashMap(InstancePointcut pc){
		
//		var ArrayList<AdapterRecord> list = AdapterRegistry::getAdaptersForAspectip(aspect,pc)
//		var ra = ""
//		for(r:list)
//		{
//			var mapName = r.instanceType + "_" + r.adapterName + "_map"
//				ra = ra + "WeakHashMap<" + r.instanceType + ","  + r.adapterName + "> " + mapName  + "= new WeakHashMap<" + r.instanceType + "," + r.adapterName + ">();\n"
//		}	
//		return ra
//	}
	
	
//	def generateAdapterInit(InstancePointcut pc){
//		var ArrayList<AdapterRecord> list = AdapterRegistry::getAdaptersForAspectip(aspect,pc)
//		var  ra = " "
//	
//			for(r:list)
//			{
//				var mapName = r.instanceType + "_" + r.adapterName + "_map"
//				if(r.isSubtype)
//				{
//					//System::out.println("R is subtype")
//					ra =  ra + " if(instance instanceof " +  r.instanceType + ")\n" +
//							mapName + ".put((" + r.instanceType + ")instance, new " + r.adapterName + "((" + r.instanceType + ")instance));\n"
//				}
//				else
//				{
//					ra = ra + mapName + ".put(instance, new " + r.adapterName + "(instance));\n"
//				}
//					
//			}
//			return ra
//	}
	
//	def generateAdapterRemove(InstancePointcut pc){
//		var ArrayList<AdapterRecord> list = AdapterRegistry::getAdaptersForAspectip(aspect,pc)
//		var  ra = " "
//	
//			for(r:list)
//			{
//				var mapName = r.instanceType + "_" + r.adapterName + "_map"
//		
//					ra = ra + mapName + ".remove(instance);\n"		
//			}
//			return ra
//	}
	
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