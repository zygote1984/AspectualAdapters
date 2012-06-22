package org.zygote.aspectbind.generator.codegen

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.emftext.language.aspectbind.commons.impl.AspectImpl
import org.emftext.language.java.expressions.Expression
import org.emftext.language.aspectbind.declaration.impl.AdapterImpl
import org.emftext.language.aspectbind.commons.Aspect
import org.emftext.language.aspectbind.declaration.Adapter
import org.emftext.language.java.containers.impl.PackageImpl
import org.emftext.language.aspectbind.declaration.AdapterDeclaration
import org.emftext.language.aspectbind.declaration.impl.AdapterDeclarationImpl
import org.eclipse.emf.ecore.EReference
import org.emftext.language.java.imports.ImportingElement
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EObject
import java.util.HashMap
import org.eclipse.xtext.generator.JavaIoFileSystemAccess


class GeneratorMain{

	
	AspectGenerator ajgen
//	AdapterGenerator adgen
	
		
	boolean print
	new(boolean print){
		this.print = print;	
	}
	
	public static Resource resourceMain = null
	
	
	def doGenerate(Resource resource, JavaIoFileSystemAccess fsa)
	{
		resourceMain = resource
//		AdapterRegistry::registerAdapters(resource)
		EcoreUtil::resolveAll(resource)
		ajgen = new AspectGenerator(resource)
//		adgen = new AdapterGenerator(resource)
		var aspect = resource.allContents.filter(typeof(AspectImpl)).toList
		
	//	var pc = aspect.get(0).eAllContents.filter(typeof(InstancePointcut)).toList
		
		if(print)
		{	
			for(o:resource.allContents.filter(typeof(EObject)).toList)
			{
				System::out.println("[GENERATOR]: Aspect Contents :" + o)
			}
			
		}
				
		for(k:aspect)
		{
			ajgen.setAspect(k)
			var packageName = k.getPackage.name 
			fsa.setOutputPath(AspectBindGenerator::getOutputPath.appendSegment(packageName).toString);
			fsa.generateFile(k.name+".aj", ajgen.generateAspect())
//			var adapters = k.eContents.filter(typeof(AdapterDeclarationImpl)).toList
//			for(h:adapters)
//			{
//				fsa.generateFile(packageName + "/" + h.adapter.name+".java",adgen.generateAdapter(h, ajgen.packagePrinter(k.getPackage), k.getPackage))
//			}
		}
		
	}
	
	
	
	



}