package org.alia4j.aspectj.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.alia4j.aspectj.parser.ast.ParseException;
import org.alia4j.aspectj.parser.ast.SimpleNode;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.Attachment;
import org.alia4j.patterns.TypePattern;
import org.objectweb.asm.ClassReader;
import org.xml.sax.SAXException;

public abstract class AJProcessor {
    
    private final ClassLoader applicationClassLoader;
    
    protected Map<String, List<Attachment>> aspectName2Attachments;
    
    protected AJProcessor(final ClassLoader applicationClassLoader) {
        this.applicationClassLoader = applicationClassLoader;
    }
    
    /**
     * Reads all aspect definition files from the class path and afterwards imports the aspects. For more documentation on
     * the aspect definition files, see http://www.eclipse.org/aspectj/doc/released/devguide/ltw.html or the DTD for aspect
     * definition files http://www.eclipse.org/aspectj/dtd/aspectj.dtd. Reads the bytecode of classes specified in the aspect
     * definition files (does not trigger class loading), reads their annotations and builds attachments structures according
     * to LIAM. This method respects the include and exclude lists of aspects from the aspect definition files. It does not
     * respect the exclude list of classes into which no aspects should be woven. This is due to the different weaving
     * technique.
     * 
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws ParseException
     * @throws ClassNotFoundException
     */
    // TODO consider excludes list
    public void importAJAspects() throws SAXException, IOException, ParserConfigurationException, ParseException,
                    ClassNotFoundException {
        if (this.aspectName2Attachments != null)
            throw new IllegalStateException("This importer has already performed an import.");
        
        // at the first instantiation the definition reader reads all definition files from the
        // class path and merges their content
        final DefinitionReader definitions = new DefinitionReader(this.applicationClassLoader);
        final AJPointcutToLIAMVisitor converter = new AJPointcutToLIAMVisitor(null, null);
        
        // all the "within"-patterns that specify included and excluded aspect classes
        // are parsed and pattern data structures are generated
        List<TypePattern> aspectsIncludes = null;
        Iterator<SimpleNode> it = definitions.getAspectsIncludes().iterator();
        if (it.hasNext()) {
            aspectsIncludes = new ArrayList<TypePattern>();
            while (it.hasNext()) {
                aspectsIncludes.add((TypePattern) it.next().jjtAccept(converter, null));
            }
        }
        
        List<TypePattern> aspectsExcludes = null;
        it = definitions.getAspectsExcludes().iterator();
        if (it.hasNext()) {
            aspectsExcludes = new ArrayList<TypePattern>();
            while (it.hasNext()) {
                aspectsExcludes.add((TypePattern) it.next().jjtAccept(converter, null));
            }
        }
        
        List<TypePattern> weaverIncludes = null;
        it = definitions.getWeaverIncludes().iterator();
        if (it.hasNext()) {
            weaverIncludes = new ArrayList<TypePattern>();
            while (it.hasNext()) {
                weaverIncludes.add((TypePattern) it.next().jjtAccept(converter, null));
            }
        }
        
        List<TypePattern> weaverExcludes = null;
        it = definitions.getWeaverExcludes().iterator();
        if (it.hasNext()) {
            weaverExcludes = new ArrayList<TypePattern>();
            while (it.hasNext()) {
                weaverExcludes.add((TypePattern) it.next().jjtAccept(converter, null));
            }
        }
        
        List<TypePattern> weaverDumps = null;
        it = definitions.getWeaverDumps().iterator();
        if (it.hasNext()) {
            weaverDumps = new ArrayList<TypePattern>();
            while (it.hasNext()) {
                weaverDumps.add((TypePattern) it.next().jjtAccept(converter, null));
            }
        }
        
        @SuppressWarnings("unused")
        final List<String> weaverOptions = Arrays.asList(definitions.getWeaverOptions().split("[\\s]*"));
        
        final Map<String, List<Attachment>> aspectName2Attachments = new HashMap<String, List<Attachment>>();
        final Iterator<String> aspectNames = definitions.getAspectsAspectNames().iterator();
        while (aspectNames.hasNext()) {
            final String currentAspectName = aspectNames.next();
            if (this.aspectIncluded(currentAspectName, aspectsIncludes, aspectsExcludes)) {
                
                // an ASM class reader representing the current class file
                final ClassReader aspectClassReader = new ClassReader(
                // locate class file on the passed classloader's class path
                                this.applicationClassLoader.getResourceAsStream(
                                // derive class file name from class name
                                                currentAspectName.replace('.', '/') + ".class"));
                
                final AspectClassAnnotationsProcessor aspectClassAnnotationsProcessor =
                                new AspectClassAnnotationsProcessor(currentAspectName);
                aspectClassReader.accept(aspectClassAnnotationsProcessor, ClassReader.SKIP_FRAMES);
                aspectName2Attachments.put(currentAspectName, aspectClassAnnotationsProcessor.getAttachments());
            }
        }
        this.aspectName2Attachments = aspectName2Attachments;
    }
    
    private boolean aspectIncluded(final String currentAspectName, final List<TypePattern> aspectsIncludes,
                    final List<TypePattern> aspectsExcludes) {
        if (aspectsIncludes == null && aspectsExcludes == null) {
            return true;
        }
        
        final TypeDescriptor aspectTypeDescriptor = TypeHierarchyProvider.findOrCreateFromNormalTypeName(currentAspectName);
        if (aspectsExcludes != null) {
            final Iterator<TypePattern> it = aspectsExcludes.iterator();
            while (it.hasNext()) {
                if (it.next().matches(aspectTypeDescriptor))
                    return false;
            }
        }
        
        if (aspectsIncludes != null) {
            final Iterator<TypePattern> it = aspectsIncludes.iterator();
            while (it.hasNext()) {
                if (it.next().matches(aspectTypeDescriptor))
                    return true;
            }
        }
        
        return false;
    }
    
}
