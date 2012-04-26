package org.zygote.aspectbind.generator.codegen;

import java.io.File;
import java.io.FileNotFoundException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

public class AspectBindGenerator {

	JavaIoFileSystemAccess fsa = new JavaIoFileSystemAccess();
	GeneratorMain main;
	URI outputPath;
	String genFolder = "output";
	boolean oFlag = false;

	public AspectBindGenerator(boolean print) {
		super();
		main = new GeneratorMain(print);

	}
	

	public AspectBindGenerator() {
		super();
		main = new GeneratorMain(false);

	}

	public void setOutputPath(URI outputPath, boolean segment) {
		if (!oFlag) {
			oFlag = true;
			if(segment)
				this.outputPath = outputPath.appendSegment(genFolder);
			else
				this.outputPath = outputPath;
			
			System.out.println("[Setting generator path]: " + this.outputPath);

			// File file = new File(outputPath);
			//
			// if (!file.isDirectory())
			// try {
			// throw new FileNotFoundException(outputPath);
			// } catch (FileNotFoundException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			fsa.setOutputPath(this.outputPath.toString());
		}
	}
	public URI getOutputPath() {
		return outputPath;
	}

	public void generate(Resource resource) {
		main.doGenerate(resource, fsa);
	}

}
