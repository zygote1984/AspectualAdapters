package org.alia4j.aspectj.model.context;

import java.util.Arrays;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
final public class ThisJoinPointContext extends Context {
    
    protected ThisJoinPointContext() {
        super(Arrays.asList(AspectJContextFactory.findOrCreateThisJoinPointStaticPartContext(), ContextFactory
                        .findOrCreateCallerContext(), ContextFactory.findOrCreateCalleeContext(), ContextFactory
                        .findOrCreateArgumentsContext()));
    }
    
    public Object getObjectValue(final Object staticPart, final Object caller, final Object callee, final Object arguments) {
        return new JoinPointImpl((StaticPart) staticPart, caller, callee, (Object[]) arguments);
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    @Override
    public Maybe<JoinPoint> computeValueStatically(final List<? extends Signed<?>> callStack) {
        if (this.getContexts().get(0).computeValueStatically(callStack).isUnknown()
                        || this.getContexts().get(1).computeValueStatically(callStack).isUnknown()
                        || this.getContexts().get(2).computeValueStatically(callStack).isUnknown()
                        || this.getContexts().get(3).computeValueStatically(callStack).isUnknown())
            return new Maybe<JoinPoint>();
        
        final StaticPart staticPart = (StaticPart) this.getContexts().get(0).computeValueStatically(callStack).getValue();
        final Object caller = this.getContexts().get(1).computeValueStatically(callStack).getValue();
        final Object callee = this.getContexts().get(2).computeValueStatically(callStack).getValue();
        final Object[] arguments = (Object[]) this.getContexts().get(3).computeValueStatically(callStack).getValue();
        return new Maybe<JoinPoint>((JoinPoint) this.getObjectValue(staticPart, caller, callee, arguments));
    }
    
    @Override
    public TypeDescriptor approximateValueTypeStatically(final List<? extends Signed<?>> callStack) {
        return TypeHierarchyProvider.findOrCreateFromClass(JoinPoint.class);
    }
    
    @Override
    public String toString() {
        return "this join point context";
    }
}
