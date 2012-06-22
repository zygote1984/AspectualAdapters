package org.alia4j.aspectj.model.context;

import java.util.Arrays;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.DebugInfo;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;
import org.aspectj.lang.reflect.SourceLocation;

/**
 * @author Andreas Sewe
 */
public class SourceLocationContext extends Context {
    
    protected SourceLocationContext() {
        super(Arrays.asList(ContextFactory.findOrCreateCalleeContext(), ContextFactory.findOrCreateDebugInfoContext()));
    }
    
    public Object getObjectValue(final Object callee, final Object infoObject) {
        final DebugInfo info = (DebugInfo) infoObject;
        return new SourceLocation() {
            
            @Override
            public String getFileName() {
                return info.getFileName();
            }
            
            @Override
            public int getLine() {
                return info.getFirstLineNumber();
            }
            
            @Override
            public int getColumn() {
                throw new UnsupportedOperationException();
            }
            
            public Class<?> getWithinType() {
                return callee.getClass();
            }
        };
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    @Override
    public Maybe<SourceLocation> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<SourceLocation>();
    }
    
    @Override
    public TypeDescriptor approximateValueTypeStatically(final List<? extends Signed<?>> callStack) {
        return TypeHierarchyProvider.findOrCreateFromClass(SourceLocation.class);
    }
    
    @Override
    public String toString() {
        return "source location context";
    }
}
