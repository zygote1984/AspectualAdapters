package org.alia4j.fial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.alia4j.bdd.vertex.Vertex;
import org.alia4j.fial.dispatchfunction.ObddBasedDispatchFunction;
import org.alia4j.liam.Action;
import org.alia4j.liam.AndPredicate;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.BasicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.DebugInfo;
import org.alia4j.liam.FalsePredicate;
import org.alia4j.liam.OrPredicate;
import org.alia4j.liam.Predicate;
import org.alia4j.liam.PredicateProcessor;
import org.alia4j.liam.Specialization;
import org.alia4j.liam.TruePredicate;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.liam.pattern.ConstructorPattern;
import org.alia4j.liam.pattern.FieldReadPattern;
import org.alia4j.liam.pattern.FieldWritePattern;
import org.alia4j.liam.pattern.MethodPattern;
import org.alia4j.liam.pattern.Pattern;
import org.alia4j.liam.pattern.StaticInitializerPattern;
import org.alia4j.liam.signature.ConstructorSignature;
import org.alia4j.liam.signature.FieldReadSignature;
import org.alia4j.liam.signature.FieldWriteSignature;
import org.alia4j.liam.signature.MethodSignature;
import org.alia4j.liam.signature.Signature;
import org.alia4j.liam.signature.SignatureProcessor;
import org.alia4j.liam.signature.Signed;
import org.alia4j.liam.signature.StaticInitializerSignature;
import org.alia4j.patterns.ExceptionsPattern;
import org.alia4j.patterns.ModifiersPattern;
import org.alia4j.patterns.names.ExactNamePattern;
import org.alia4j.patterns.parameters.ExactParametersPattern;
import org.alia4j.patterns.types.ExactClassTypePattern;
import org.alia4j.patterns.types.ExactTypePattern;
import org.alia4j.util.Pair;
import org.alia4j.util.TopologicSorter;

/**
 * The type variable {@code T} can be used to add execution-environment-specific data to the generic function.
 * 
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public abstract class GenericFunction<S extends Signature, T> implements Signed<S> {
    
    private final Map<Attachment, AttachedAction> actions = new IdentityHashMap<Attachment, AttachedAction>();
    
    private final Map<Attachment, Pair<Predicate<AtomicPredicate>, AttachedAction>> eventTriggeringActions =
                    new IdentityHashMap<Attachment, Pair<Predicate<AtomicPredicate>, AttachedAction>>();
    
    private final DispatchFunction dispatchFunction;
    
    private final Attachment implicitAttachment;
    
    protected static class SignatureToSpecializationProcessor implements SignatureProcessor<Specialization> {
        
        protected List<Context> createContexts(boolean hasImplicitThis, int numberOfArguments) {
            List<Context> result = new ArrayList<Context>();
            if (hasImplicitThis)
                result.add(ContextFactory.findOrCreateCalleeContext());
            for (int i = 0; i < numberOfArguments; i++)
                result.add(ContextFactory.findOrCreateArgumentContext(i));
            
            return result;
        }
        
        @Override
        public Specialization process(ConstructorSignature signature) {
            Pattern<?> pattern =
                            new ConstructorPattern(ModifiersPattern.ANY, new ExactClassTypePattern(
                                            signature.getDeclaringClass()), new ExactParametersPattern(
                                            signature.getParameterTypes()), ExceptionsPattern.ANY);
            return new Specialization(pattern, null, this.createContexts(false, signature.getParameterTypes().length));
        }
        
        @Override
        public Specialization process(StaticInitializerSignature signature) {
            Pattern<?> pattern = new StaticInitializerPattern(new ExactClassTypePattern(signature.getDeclaringClass()));
            return new Specialization(pattern, null, Collections.<Context>emptyList());
        }
        
        @Override
        public Specialization process(MethodSignature signature) {
            Pattern<?> pattern =
                            new MethodPattern(ModifiersPattern.ANY, new ExactTypePattern(signature.getReturnType()),
                                            new ExactClassTypePattern(signature.getDeclaringClass()), new ExactNamePattern(
                                                            signature.getName().toString()), new ExactParametersPattern(
                                                            signature.getParameterTypes()), ExceptionsPattern.ANY);
            return new Specialization(pattern, null, this.createContexts(!signature.isStatic(),
                            signature.getParameterTypes().length));
        }
        
        @Override
        public Specialization process(FieldReadSignature signature) {
            Pattern<?> pattern =
                            new FieldReadPattern(ModifiersPattern.ANY, new ExactTypePattern(signature.getType()),
                                            new ExactClassTypePattern(signature.getDeclaringClass()), new ExactNamePattern(
                                                            signature.getName().toString()));
            return new Specialization(pattern, null, this.createContexts(!signature.isStatic(), 0));
        }
        
        @Override
        public Specialization process(FieldWriteSignature signature) {
            Pattern<?> pattern =
                            new FieldWritePattern(ModifiersPattern.ANY, new ExactTypePattern(signature.getType()),
                                            new ExactClassTypePattern(signature.getDeclaringClass()), new ExactNamePattern(
                                                            signature.getName().toString()));
            return new Specialization(pattern, null, this.createContexts(!signature.isStatic(), 1));
        }
        
    }
    
    public GenericFunction(final S signature, final T info) {
        if (signature == null)
            throw new IllegalArgumentException();
        
        this.signature = signature;
        this.info = info;
        this.dispatchFunction = this.createInitialDispatchFunction();
        
        Specialization implicitActionSpecialization = signature.accept(this.getSignatureToImplicitSpecializationProcessor());
        
        final Action implicitAction = signature.accept(this.getSignatureToImplicitActionProcessor());
        
        this.implicitAttachment =
                        new Attachment(Collections.singleton(implicitActionSpecialization), implicitAction,
                                        SystemScheduleInfo.IMPLICIT_ACTION, new DebugInfo("Implicit attachment"));
        
        final AttachedAction implicitAttachedAction =
                        new AttachedAction(this.implicitAttachment.getAction(), implicitActionSpecialization.getContexts(),
                                        this.implicitAttachment.getScheduleInfo(), this.implicitAttachment);
        
        this.attach(this.implicitAttachment, null, implicitAttachedAction);
    }
    
    protected SignatureProcessor<Specialization> getSignatureToImplicitSpecializationProcessor() {
        return new SignatureToSpecializationProcessor();
    }
    
    @Override
    public final S getSignature() {
        return this.signature;
    }
    
    private final S signature;
    
    public final T getImplementationSpecificInfo() {
        return this.info;
    }
    
    private final T info;
    
    protected abstract SignatureProcessor<Action> getSignatureToImplicitActionProcessor();
    
    protected DispatchFunction createInitialDispatchFunction() {
        return new ObddBasedDispatchFunction();
    }
    
    /**
     * @param attachment may not be {@code null}
     * @param predicate may be {@code null}
     * @param action may not be {@code null}
     */
    final protected void attach(final Attachment attachment, final Predicate<AtomicPredicate> predicate,
                    final AttachedAction action) {
        if (attachment == null)
            throw new IllegalArgumentException("Attachment may not be null.");
        if (action == null)
            throw new IllegalArgumentException("Action may not be null.");
        
        if (attachment.getAction().triggersEvent()) {
            this.eventTriggeringActions.put(attachment, new Pair<Predicate<AtomicPredicate>, AttachedAction>(predicate,
                            action));
            this.eventTriggeringActionAttached(action, predicate);
        } else {
            this.actions.put(attachment, action);
            this.dispatchFunction.add(action, predicate);
            this.actionAttached(action, predicate);
        }
    }
    
    protected void actionAttached(final AttachedAction action, final Predicate<AtomicPredicate> predicate) {}
    
    protected void eventTriggeringActionAttached(final AttachedAction action, final Predicate<AtomicPredicate> predicate) {}
    
    final protected void detach(final Attachment attachment) {
        final AttachedAction action = this.actions.get(attachment);
        this.aboutToDetatchAction(action);
        this.dispatchFunction.remove(action);
        this.actions.remove(attachment);
    }
    
    protected void aboutToDetatchAction(final AttachedAction action) {}
    
    protected Collection<AttachedAction> getAllActions() {
        return this.actions.values();
    }
    
    public List<Pair<Predicate<AtomicPredicate>, AttachedAction>> getEventTriggeringActions() {
        Map<EventSignature, Pair<Predicate<AtomicPredicate>, AttachedAction>> event2Producer =
                        new HashMap<EventSignature, Pair<Predicate<AtomicPredicate>, AttachedAction>>();
        for (Pair<Predicate<AtomicPredicate>, AttachedAction> action : this.eventTriggeringActions.values()) {
            Pair<Predicate<AtomicPredicate>, AttachedAction> overridden =
                            event2Producer.put(action.getRight().getAction().getTriggeredEventSignature(), action);
            if (overridden != null)
                throw new IllegalStateException(
                                "There must not be more than one attached action that triggers the same event.");
        }
        
        List<Pair<Set<Pair<Predicate<AtomicPredicate>, AttachedAction>>, Set<Pair<Predicate<AtomicPredicate>, AttachedAction>>>> relations =
                        new ArrayList<Pair<Set<Pair<Predicate<AtomicPredicate>, AttachedAction>>, Set<Pair<Predicate<AtomicPredicate>, AttachedAction>>>>();
        
        for (Pair<Predicate<AtomicPredicate>, AttachedAction> action : this.eventTriggeringActions.values()) {
            Set<EventSignature> eventSignatures = new HashSet<EventSignature>();
            this.collectDependedOnEventSignatures(action.getLeft(), eventSignatures);
            for (EventSignature eventSignature : eventSignatures) {
                Pair<Predicate<AtomicPredicate>, AttachedAction> producer = event2Producer.get(eventSignature);
                relations.add(new Pair<Set<Pair<Predicate<AtomicPredicate>, AttachedAction>>, Set<Pair<Predicate<AtomicPredicate>, AttachedAction>>>(
                                Collections.singleton(producer), Collections.singleton(action)));
            }
        }
        return TopologicSorter.<Pair<Predicate<AtomicPredicate>, AttachedAction>>sort(
                        new HashSet<Pair<Predicate<AtomicPredicate>, AttachedAction>>(event2Producer.values()), relations);
    }
    
    private void collectDependedOnEventSignatures(Predicate<AtomicPredicate> predicate, final Set<EventSignature> result) {
        predicate.accept(new PredicateProcessor<Void, AtomicPredicate>() {
            
            @Override
            public Void process(BasicPredicate<AtomicPredicate> predicate) {
                GenericFunction.this.collectDependedOnEventSignatures(predicate.getAtomicPredicate().getContexts(), result);
                if (predicate.getAtomicPredicate().dependsOnEvent()) {
                    result.add(predicate.getAtomicPredicate().getDependedOnEvent());
                }
                return null;
            }
            
            @Override
            public Void process(AndPredicate<AtomicPredicate> predicate) {
                predicate.getLeftHandSide().accept(this);
                predicate.getRightHandSide().accept(this);
                return null;
            }
            
            @Override
            public Void process(OrPredicate<AtomicPredicate> predicate) {
                predicate.getLeftHandSide().accept(this);
                predicate.getRightHandSide().accept(this);
                return null;
            }
            
            @Override
            public Void process(TruePredicate<AtomicPredicate> predicate) {
                return null;
            }
            
            @Override
            public Void process(FalsePredicate<AtomicPredicate> predicate) {
                return null;
            }
        });
    }
    
    private void collectDependedOnEventSignatures(List<? extends Context> contexts, Set<EventSignature> result) {
        for (Context context : contexts) {
            this.collectDependedOnEventSignatures(context.getContexts(), result);
            if (context.dependsOnEvent())
                result.add(context.getDependedOnEvent());
        }
    }
    
    // FIXME This ought to be a Template Method; the default implementation would use the Strategy pattern
    // to delegate this to a DispatchFunction.
    public Vertex<AtomicPredicate, AttachedAction> getDispatchStrategy() {
        return this.dispatchFunction.getDispatchStrategy();
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        
        builder.append(this.getSignature());
        builder.append(" <= ");
        builder.append(this.dispatchFunction);
        
        return builder.toString();
    }
}
