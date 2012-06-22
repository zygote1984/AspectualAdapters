package org.alia4j.aspectj.parser;

import java.util.Collections;
import java.util.List;

class MethodCall {
    
    protected MethodCall(final String fullyQualifiedMethodName, final List<String> arguments) {
        this.fullyQualifiedMethodName = fullyQualifiedMethodName;
        this.arguments = arguments;
    }
    
    public String getFullyQualifiedMethodName() {
        return this.fullyQualifiedMethodName;
    }
    
    private final String fullyQualifiedMethodName;
    
    public List<String> getArguments() {
        return Collections.unmodifiableList(this.arguments);
    }
    
    private final List<String> arguments;
}
