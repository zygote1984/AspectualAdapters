package org.alia4j.liam.action;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.Action;

/**
 * @author Christoph Bockisch
 */
public abstract class MemberAction extends Action {
    
    protected MemberAction(final TypeDescriptor declaringClassName, final CharSequence memberName) {
        this.declaringClassName = declaringClassName;
        this.name = memberName;
    }
    
    public TypeDescriptor getDeclaringClassName() {
        return this.declaringClassName;
    }
    
    private final TypeDescriptor declaringClassName;
    
    private Class<?> declaringClass;
    
    public Class<?> getDeclaringClass() throws ClassNotFoundException {
        if (declaringClass == null)
            declaringClass = declaringClassName.asClass();
        return declaringClass;
    }
    
    public CharSequence getName() {
        return this.name;
    }
    
    private final CharSequence name;
}
