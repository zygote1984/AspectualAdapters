package org.alia4j.noirin.context;

import org.alia4j.liam.Context;
import org.alia4j.liam.context.ContextFactoryDef;
import org.alia4j.liam.event.EventSignature;

public class ContextFactoryImpl extends ContextFactoryDef {
    
    public static void initialize() {
        new ContextFactoryImpl();
    }
    
    private ContextFactoryImpl() {}
    
    @Override
    protected Context createArgumentsContext() {
        return new ArgumentsContext();
    }
    
    @Override
    protected Context createCalleeContext() {
        return new CalleeContext();
    }
    
    @Override
    protected Context createCallerContext() {
        return new CallerContext();
    }
    
    @Override
    protected Context createDebugInfoContext() {
        return new DebugInfoContext();
    }
    
    @Override
    protected Context createMethodResultContext() {
        return new MethodResultContext();
    }
    
    @Override
    protected Context createSignatureContext() {
        return new SignatureContext();
    }
    
    @Override
    protected Context createToArrayContext(final Context... elements) {
        return new ToArrayContext(elements);
    }
    
    @Override
    protected Context createCallApproximationContext() {
        return new CallApproximationContext();
    }
    
    @Override
    protected Context createEventAccessingContext(EventSignature eventSignature) {
        return new EventAccessingContext(eventSignature);
    }
    
    @Override
    protected Context createEventTriggeringContext(EventSignature eventSignature) {
        return new EventTriggeringContext(eventSignature);
    }
}
