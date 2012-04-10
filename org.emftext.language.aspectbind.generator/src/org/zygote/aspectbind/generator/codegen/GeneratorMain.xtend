package org.zygote.aspectbind.generator.codegen

import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.emftext.language.aspectbind.binding.impl.InstancePointcutImpl
import org.emftext.language.aspectbind.commons.impl.AspectImpl
import org.emftext.language.aspectbind.pointcuts.impl.AspectJPointcutImpl
import org.emftext.language.aspectbind.pointcuts.impl.PointcutImpl
import org.emftext.language.java.imports.Import
import org.emftext.language.java.parameters.Parameter
import org.emftext.language.java.parameters.OrdinaryParameter
import org.emftext.language.java.parameters.impl.OrdinaryParameterImpl
import org.emftext.language.aspectbind.pointcuts.AspectJPointcut
import org.emftext.language.java.types.NamespaceClassifierReference
import org.emftext.language.java.resource.java.analysis.ClassifierReferenceTargetReferenceResolver
import org.emftext.language.java.types.TypeReference
import org.emftext.language.java.types.ClassifierReference
import org.emftext.language.java.expressions.Expression
import org.emftext.language.aspectbind.binding.InstancePointcut

class GeneratorMain implements IGenerator{
	
	
	ClassifierReferenceTargetReferenceResolver refResolver = new ClassifierReferenceTargetReferenceResolver()
	boolean print
	new(boolean print){
		this.print = print;
	}
	
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa)
	{

		var aspect = resource.allContents.filter(typeof(AspectImpl)).toList
		var pc = aspect.get(0).eAllContents.filter(typeof(InstancePointcut)).toList
		
		if(print)
		{	
			System::out.println("[GENERATOR]: Pointcut Expression Contents:" + pc.get(0).exp.child)
	
//				for(g:pc.get(0).exp.child)
//					System::out.println("[GENERATOR]: Pointcut Expression" + o.toString + "Contents:" + g)
			
			for(o:resource.allContents.filter(typeof(Expression)).toList)
			{
				System::out.println("[GENERATOR]: Aspect Contents :" + o)
			}
			
		}
				
		for(k:aspect)
		{
			
			fsa.generateFile(k.name+".aj", generateAspect(k, resource))
		}
	}
	
	def generateImports(List<Import> imports)
	{
		var impstr =  ""
		for(i:imports)
		{	
			impstr = impstr + "import " + i.namespacesAsString
		
			if(impstr.endsWith("."))
				impstr = impstr + "*"
				
			impstr = impstr + ";\n"
		}	
		return impstr
	}
	
	
	def generateAspect(AspectImpl aspect, Resource resource) '''
	«IF aspect.getPackage != null»
	package «aspect.getPackage.name»;
	«ENDIF»
	
	«generateImports(resource.allContents.filter(typeof(Import)).toList)»

	
	«IF aspect.priviliged» "privileged" «ELSE»  «ENDIF» aspect «aspect.name» «IF aspect.extend != null» extends «aspect.extend» «ENDIF»
	{
		«var pcs = aspect.members.filter(typeof(PointcutImpl))»
		«FOR p:pcs»
		«generatePointcut(p)»
		«ENDFOR»
	}
	
	
	'''
	
	
	def dispatch generatePointcut(AspectJPointcut pc)
	'''
	«IF print»
	«System::out.println("[GENERATOR] : Pointcut Parameters:" + pc.parameters)»
	«ENDIF»
	pointcut «pc.name»(«parameterExpand(pc.parameters)») «IF pc.exp == null» ; «ELSE» =; «ENDIF»
	'''
	
	
	def dispatch generatePointcut(InstancePointcutImpl pc)
	'''
	instance pointcut «pc.name»(«resolveReference(pc.instanceType.type.pureClassifierReference)»);
	'''
	
	
	def dispatch parameterExpand(EList<Parameter> params){
		var ps = ""
		if(params.size == 0)
			System::out.println("[GENERATOR] Parameter Expand: No Parameters found")
		else if(params.size == 1)
			ps = ps + parameterExpand(params.get(0))
		else
		{	
			var par = params.last
			params.remove(params.last)
			for(p:params)
				ps = ps + parameterExpand(p) + ", "
		
			ps = ps + parameterExpand(par)
		}
		return ps;
	
	}
//	def dispatch parameterExpand(Parameter param)
//	{
//		var p = " "
//		
//		if(param instanceof OrdinaryParameterImpl)
//		{
//			//System::out.println("[GENERATOR] Ordinary Parameter:" + ((OrdinaryParameterImpl)param).getClassifierReference + "||" + param.name )
//			for(a:param.eAllContents.toList)
//			{
//				System::out.println("[GENERATOR] Ordinary Parameter:" + a.toString )
//			}
//			//p = p + param.typeArguments.get(0).stringClass + " " + param.name
//		}
//		return p
//	}
	
	def dispatch parameterExpand(OrdinaryParameter param)
	{
		var p = ""
		
		if(param.typeReference instanceof NamespaceClassifierReference)
		{
			var NamespaceClassifierReference tr = param.typeReference as NamespaceClassifierReference
			//System::out.println("[GENERATOR] Ordinary Parameter Target: " )
			
			p = p + resolveReference(tr.classifierReferences.get(0)) + " " + param.name
		}	
		
		return p
	}
	
	def resolveReference(ClassifierReference ref)
	{
		return refResolver.deResolve(ref.target,ref,null)
	}
	

}