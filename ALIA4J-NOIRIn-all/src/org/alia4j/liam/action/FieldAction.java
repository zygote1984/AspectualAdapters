package org.alia4j.liam.action;

import java.lang.reflect.Field;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.signature.ResolutionStrategy;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public abstract class FieldAction extends MemberAction {
    
    private Field field;
    
    private final TypeDescriptor fieldTypeName;
    
    private final ResolutionStrategy resolutionStrategy;
    
    protected FieldAction(final TypeDescriptor declaringClassName, final CharSequence memberName,
                    final TypeDescriptor fieldTypeName, final ResolutionStrategy resolutionStrategy) {
        super(declaringClassName, memberName);
        this.fieldTypeName = fieldTypeName;
        this.resolutionStrategy = resolutionStrategy;
    }
    
    public TypeDescriptor getFieldTypeName() {
        return this.fieldTypeName;
    }
    
    public boolean isVirtualAccess() {
        return this.resolutionStrategy == ResolutionStrategy.VIRTUAL;
    }
    
    public boolean isStaticAccess() {
        return this.resolutionStrategy == ResolutionStrategy.STATIC;
    }
    
    protected Field getField() throws ClassNotFoundException, SecurityException, NoSuchFieldException {
        if (this.field == null) {
            this.field = this.getDeclaringClass().getDeclaredField(this.getName().toString());
            this.field.setAccessible(true);
        }
        return this.field;
    }
    
}
