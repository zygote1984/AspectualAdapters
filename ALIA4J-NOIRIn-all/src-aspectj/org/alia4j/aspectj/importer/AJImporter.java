package org.alia4j.aspectj.importer;

import java.util.List;
import org.alia4j.aspectj.parser.AJProcessor;
import org.alia4j.fial.Importer;
import org.alia4j.fial.System;
import org.alia4j.liam.Attachment;

/**
 * Reads all aspect definition files from the class path. For more documentation, see
 * http://www.eclipse.org/aspectj/doc/released/devguide/ltw.html or the DTD for aspect definition files
 * http://www.eclipse.org/aspectj/dtd/aspectj.dtd.
 */
public class AJImporter extends AJProcessor implements Importer {
    
    public AJImporter(final ClassLoader applicationClassLoader) {
        super(applicationClassLoader);
    }
    
    public void performImport() {
        try {
            this.importAJAspects();
            // AspectJ has only statically deployed aspects, so deploy all loaded aspects
            for (final List<Attachment> attachments : this.aspectName2Attachments.values()) {
                for (final Attachment attachment : attachments)
                    System.deploy(attachment);
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
