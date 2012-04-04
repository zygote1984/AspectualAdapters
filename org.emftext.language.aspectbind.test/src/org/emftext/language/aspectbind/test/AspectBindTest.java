package org.emftext.language.aspectbind.test;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.aspectbind.commons.Aspect;
import org.emftext.language.aspectbind.commons.impl.AspectImpl;
import org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindResource;
import org.junit.Test;
import org.zygote.aspectbind.generator.codegen.AspectBindGenerator;

public class AspectBindTest {
	
	
	
	@Test
	public void testInterpreter() {
		AspectBindGenerator generator = new AspectBindGenerator();
		String templateFile = "input" + File.separator + "example.aspectbind";
		System.out.println(templateFile);
		Resource resource = null;
		try {
			resource = load(templateFile);
		} catch (IOException e) {
			// if the file can not be found, the working directory of
			// the test is probably wrong
			e.printStackTrace();
		}
		
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EList<EObject> clist = resource.getContents();
		for(EObject o:clist)
			System.out.println("[TEST] : Resource Contents " + o.toString());
		Aspect content = (Aspect) resource.getContents().get(0);
		generator.setOutputPath(URI.createURI("D:/Profiles/hatunk/Desktop/EMFTextWS/org.emftext.language.aspectbind.test"));
		System.out.println("[TEST]" + content.toString());
		System.out.println("[TEST]" + ((AspectImpl)content).getPackage());
		System.out.println("[TEST]" + ((AspectImpl)content).getMembers() );
		System.out.println("[TEST]" + content.getNamespaces());
		generator.generate(resource);
	
		
	}

	private Resource load(String templateFile) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		InputStream inputStream = new FileInputStream(templateFile);
		Resource resource = new AspectbindResource();
		resource.setURI(URI.createURI(""));
		resource.load(inputStream, options);
		inputStream.close();
		return resource;
	}
}