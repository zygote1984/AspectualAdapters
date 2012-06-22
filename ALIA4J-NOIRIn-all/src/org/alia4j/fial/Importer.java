package org.alia4j.fial;

/**
 * Subclasses of {@code Importer} are required to implement a public constructor that takes a single argument of type {@code
 * ClassLoader}. The FIAL {@code System} will call this constructor passing the system class loaded (refer to JVM
 * terminology) and afterwards call the {@code performImport()} method just before the {@code main(String[])} method of the
 * application is called.
 * 
 * @author Christoph Bockisch
 */
public interface Importer {
    
    void performImport();
}
