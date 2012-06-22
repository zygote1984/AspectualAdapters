/**
 * 
 */
package org.alia4j.aspectj.parser;

import org.alia4j.patterns.ClassTypePattern;
import org.alia4j.patterns.NamePattern;

/**
 * Used during the translation of a parse tree for a pointcut to an Execution Model pattern. Used as result for parsing the
 * ClassTypeDotId rule.
 * 
 * @author Christoph Bockisch
 */
class FullyQualifiedMemberPattern {
    
    private final ClassTypePattern declaringClassTypePattern;
    
    private final NamePattern methodNamePattern;
    
    protected FullyQualifiedMemberPattern(final ClassTypePattern declaringClassTypePattern,
                    final NamePattern methodNamePattern) {
        super();
        this.declaringClassTypePattern = declaringClassTypePattern;
        this.methodNamePattern = methodNamePattern;
    }
    
    protected ClassTypePattern getDeclaringClassTypePattern() {
        return this.declaringClassTypePattern;
    }
    
    protected NamePattern getMethodNamePattern() {
        return this.methodNamePattern;
    }
}
