package org.alia4j.aspectj.model.context;

import java.util.Arrays;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;
import org.aspectj.lang.Signature;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.reflect.SourceLocation;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
final public class ThisJoinPointStaticPartContext extends Context {
    
    protected ThisJoinPointStaticPartContext() {
        super(Arrays.asList(AspectJContextFactory.findOrCreateJoinPointKindContext(), AspectJContextFactory
                        .findOrCreateAspectJSignatureContext(), AspectJContextFactory.findOrCreateSourceLocationContext()));
    }
    
    public Object getObjectValue(final Object kind, final Object signature, final Object sourceLocation) {
        return new JoinPointStaticPartImpl((String) kind, (Signature) signature, (SourceLocation) sourceLocation);
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    @Override
    public Maybe<StaticPart> computeValueStatically(final List<? extends Signed<?>> callStack) {
        if (this.getContexts().get(0).computeValueStatically(callStack).isUnknown()
                        || this.getContexts().get(1).computeValueStatically(callStack).isUnknown()
                        || this.getContexts().get(2).computeValueStatically(callStack).isUnknown())
            return new Maybe<StaticPart>();
        
        final String kind = (String) this.getContexts().get(0).computeValueStatically(callStack).getValue();
        final Signature signature = (Signature) this.getContexts().get(1).computeValueStatically(callStack).getValue();
        final SourceLocation sourceLocation =
                        (SourceLocation) this.getContexts().get(2).computeValueStatically(callStack).getValue();
        return new Maybe<StaticPart>((StaticPart) this.getObjectValue(kind, signature, sourceLocation));
    }
    
    @Override
    public TypeDescriptor approximateValueTypeStatically(final List<? extends Signed<?>> callStack) {
        return TypeHierarchyProvider.findOrCreateFromClass(StaticPart.class);
    }
    
    @Override
    public String toString() {
        return "this join point static part context";
    }
}
