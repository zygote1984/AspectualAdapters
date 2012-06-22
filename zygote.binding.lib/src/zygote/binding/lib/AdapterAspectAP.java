package zygote.binding.lib;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.util.DeclarationVisitors;
import com.sun.mirror.util.SimpleDeclarationVisitor;

public class AdapterAspectAP implements AnnotationProcessor {

	private final AnnotationProcessorEnvironment env;
	public static final String annotationAdapterAspect= "zygote.binding.lib.AdapterAspect";
	
	public AdapterAspectAP(AnnotationProcessorEnvironment env) {
		this.env = env;
	}

	public void process() {
		for (TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations())
			typeDecl.accept(DeclarationVisitors.getDeclarationScanner(new AdapterAspectVisitor(),
					DeclarationVisitors.NO_OP));
	}
	
	private static class AdapterAspectVisitor extends SimpleDeclarationVisitor {
	    public void visitClassDeclaration(ClassDeclaration d) {
	    	System.out.println("[APT]" + d.getQualifiedName());
	    }
	}

}
