package org.zygote.aspectbind.generator.codegen

import java.util.HashMap
import org.emftext.language.aspectbind.commons.Aspect
import org.eclipse.emf.ecore.resource.Resource
import org.emftext.language.aspectbind.commons.impl.AspectImpl
import org.emftext.language.aspectbind.declaration.impl.AdapterDeclarationImpl
import org.eclipse.emf.ecore.InternalEObject
import org.emftext.language.aspectbind.binding.InstancePointcut
import java.util.ArrayList

class AdapterRegistry {
	
	static HashMap<String, HashMap<InstancePointcut,ArrayList<AdapterRecord>> > map =  new HashMap<String,HashMap<InstancePointcut,ArrayList<AdapterRecord>>>()

	def static registerAdapters(Resource resource)
	{
		var aspect = resource.allContents.filter(typeof(AspectImpl)).toList
		
		for(k:aspect)
		{	
			var HashMap<InstancePointcut,ArrayList<AdapterRecord>> ipadapter = new HashMap<InstancePointcut,ArrayList<AdapterRecord>>()
			var adapters = k.eContents.filter(typeof(AdapterDeclarationImpl)).toList
			for(h:adapters)
			{
				var instanceType = ""
				var ArrayList<AdapterRecord> list =  new ArrayList<AdapterRecord>()
				if (h.adapteeSub == null)
				{
					var ip = Utility::resolveReference(h.adaptee as InternalEObject, resource) as InstancePointcut

					instanceType = Utility::resolveReference(ip.instanceType)
					if(ipadapter.containsKey(ip))
						ipadapter.get(ip).add(new AdapterRecord(h.adapter.name, instanceType, false, null))
					else
						list.add(new AdapterRecord(h.adapter.name, instanceType, false, null))
					ipadapter.put(ip, list )
				}	
				else
				{
					var ip = Utility::resolveReference(h.adaptee as InternalEObject, resource) as InstancePointcut
					var superType = Utility::resolveReference(ip.instanceType)
					System::out.println("[ADAPTER REGISTRY]: SuperType ->" + superType)
					instanceType =  Utility::resolveReference(h.adapteeSub)
					System::out.println("[ADAPTER REGISTRY]: Instance Type ->" + instanceType)
					if(ipadapter.containsKey(ip))
						ipadapter.get(ip).add(new AdapterRecord(h.adapter.name, instanceType, true, superType))
					else
					{
						list.add(new AdapterRecord(h.adapter.name, instanceType, true, superType))
						ipadapter.put(ip, list)
					}
				}	
				
			}
			
			map.put(k.name, ipadapter)
		}
		
	}
	
	def static getAdaptersForAspectip(Aspect a, InstancePointcut p)
	{
		return map.get(a.name).get(p)
	}	
	
	
	
}