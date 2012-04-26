package org.zygote.aspectbind.generator.codegen

import java.util.List
import org.emftext.language.java.imports.Import
import org.eclipse.emf.common.util.EList
import org.emftext.language.java.parameters.Parameter
import org.emftext.language.java.parameters.OrdinaryParameter
import org.emftext.language.java.types.NamespaceClassifierReference
import org.emftext.language.java.types.ClassifierReference
import org.emftext.language.aspectbind.resource.aspectbind.analysis.ClassifierReferenceTargetReferenceResolver
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.Resource
import org.emftext.language.aspectbind.patterns.TypePattern
import java.io.ByteArrayOutputStream
import org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource


class Utility {
	
	static ClassifierReferenceTargetReferenceResolver refResolver = new ClassifierReferenceTargetReferenceResolver()
	static ByteArrayOutputStream output =  new ByteArrayOutputStream()
	static AspectBindPrinterSub printer = new AspectBindPrinterSub(output, GeneratorMain::resourceMain as IAspectbindTextResource)
	
	def static generateImports(List<Import> imports)
	{

		var impstr =  "import java.util.WeakHashMap;\n"
		for(i:imports)
		{	
			printer.print(i)
			impstr = impstr + output.toString
			output.reset	
		}	
		return impstr
	}
	
		def static dispatch parameterExpand(EList<Parameter> params){
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
	
	def static dispatch parameterExpand(OrdinaryParameter param)
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
	
	def static dispatch resolveReference(ClassifierReference ref)
	{
		return refResolver.deResolve(ref.target,ref,null)
	}
	
	def static dispatch resolveReference(TypePattern ref)
	{
		return refResolver.deResolve(ref.type.pureClassifierReference.target,ref.type.pureClassifierReference,null)
	}
	
	def static resolveReference(InternalEObject ref, Resource resource)
	{
		return resource.getEObject(ref.eProxyURI.fragment)
	}
	
	
}