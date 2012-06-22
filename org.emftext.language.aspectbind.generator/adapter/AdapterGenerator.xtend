package org.zygote.aspectbind.generator.codegen

import java.io.ByteArrayOutputStream
import java.io.OutputStream
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.Resource
import org.emftext.language.aspectbind.binding.InstancePointcut
import org.emftext.language.aspectbind.declaration.AdapterDeclaration
import org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource
import org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindPrinter
import org.emftext.language.java.imports.Import
import org.emftext.language.aspectbind.declaration.Adapter

class AdapterGenerator {
	
	
	Utility utility =  new Utility()
	ByteArrayOutputStream output =  new ByteArrayOutputStream()
	AspectbindPrinter printer 
	Resource resource
	
		
	new(Resource resource)
	{
		this.resource = resource
		printer = new AspectBindPrinterSub(output,resource as IAspectbindTextResource)
	}
	
	
	def generateAdapter( AdapterDeclaration a, String packa, org.emftext.language.java.containers.Package pack)
	{
		val InstancePointcut adaptee = Utility::resolveReference(a.adaptee as InternalEObject, resource) as InstancePointcut
		var instanceType = ""
		if(a.adapteeSub == null)
			instanceType = Utility::resolveReference(adaptee.instanceType)
		else
			instanceType = Utility::resolveReference(a.adapteeSub)
			
		'''
		«packa»
		«Utility::generateImports(pack.imports)»
		public class «a.adapter.name» «IF a.adapter.extend != null»extends «(Utility::resolveReference(a.adapter.extend as InternalEObject, resource) as Adapter).getName»«ENDIF»
			 «IF a.adapter.references.size > 0» implements «FOR r:a.adapter.references» «IF a.adapter.references.indexOf(r) > 0»,«ENDIF» «Utility::resolveReference(r.type.pureClassifierReference)» «ENDFOR»«ENDIF»{
			
			«instanceType» adaptee;
			
			public «a.adapter.name»(«instanceType» adaptee)
			{
				«IF a.adapter.extend != null»
				super(adaptee);
				«ENDIF»
				this.adaptee = adaptee;
			}
			
			«FOR m:a.members»
			«printer.print(m)»
			«output.toString»
			«output.reset»
			«ENDFOR»
			
			
			
		}
		'''
	}
}