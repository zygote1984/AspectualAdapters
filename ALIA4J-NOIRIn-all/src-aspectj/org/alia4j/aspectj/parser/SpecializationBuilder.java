package org.alia4j.aspectj.parser;

import java.util.Set;
import org.alia4j.liam.Context;
import org.alia4j.liam.Specialization;

/**
 * Used to build a set of Specializations from a parse tree built from parsing an AspectJ pointcut.
 * 
 * @author Christoph Bockisch
 */
abstract class SpecializationBuilder {
    
    /**
     * @param index the position of the advice parameter as which the specified Context value should be passed
     */
    protected abstract void setContext(int index, Context context);
    
    protected abstract Set<Specialization> getSpecializations();
}
