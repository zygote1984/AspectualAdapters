package zygote.binding.lib;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

public class AdapterAspectAPFactory implements AnnotationProcessorFactory{
	
	 // Process any set of annotations
    private static final Collection<String> supportedAnnotations = Collections.unmodifiableCollection(Arrays.asList(AdapterAspectAP.annotationAdapterAspect));

    public Collection<String> supportedAnnotationTypes() {
        return supportedAnnotations;
    }


   
    public AnnotationProcessor getProcessorFor( Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env) {
    	System.out.println("Processor Invoked");
        return new AdapterAspectAP(env);
    }

	@Override
	public Collection<String> supportedOptions() {
		// TODO Auto-generated method stub
		return Collections.emptySet();
	}


}
