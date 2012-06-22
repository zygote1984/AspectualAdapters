package org.alia4j.fial;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.AttachmentReference;
import org.alia4j.liam.CompositionRule;
import org.alia4j.liam.Context;
import org.alia4j.liam.PrecedenceRule;
import org.alia4j.liam.Specialization;
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
import org.alia4j.liam.signature.Signed;
import org.alia4j.liam.signature.StaticInitializerSignature;
import org.alia4j.util.Pair;
import org.alia4j.util.TopologicSorter;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public abstract class System {
    
    protected System() {
        if (System.singleton != null)
            throw new IllegalStateException("System already initialized.");
        System.singleton = this;
    }
    
    public static System getInstance() {
        return System.singleton;
    }
    
    private static System singleton;
    
    /**
     * @param systemClassLoader
     * @throws RuntimeException if an {@code Importer} could not be loaded, instantiated or executed.
     */
    public final void aboutToStartApplication(final ClassLoader systemClassLoader) {
        try {
            final String[] importerClassNames = java.lang.System.getProperty("org.alia4j.importer", "").split(",");
            for (final String element : importerClassNames) {
                if (element.equals(""))
                    continue;
                
                final Class<?> importerClass = Class.forName(element, true, systemClassLoader);
                final Constructor<?> importerConstructor = importerClass.getDeclaredConstructor(ClassLoader.class);
                final Importer importer = (Importer) importerConstructor.newInstance(systemClassLoader);
                importer.performImport();
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private final Set<GenericFunction<MethodSignature, ?>> methodCalls = new HashSet<GenericFunction<MethodSignature, ?>>();
    
    private final Set<GenericFunction<ConstructorSignature, ?>> constructorCalls =
                    new HashSet<GenericFunction<ConstructorSignature, ?>>();
    
    private final Set<GenericFunction<StaticInitializerSignature, ?>> staticInitializers =
                    new HashSet<GenericFunction<StaticInitializerSignature, ?>>();
    
    private final Set<GenericFunction<FieldWriteSignature, ?>> fieldWrites =
                    new HashSet<GenericFunction<FieldWriteSignature, ?>>();
    
    private final Set<GenericFunction<FieldReadSignature, ?>> fieldReads =
                    new HashSet<GenericFunction<FieldReadSignature, ?>>();
    
    private final Set<PrecedenceRule> deployedPrecedenceRules = new HashSet<PrecedenceRule>();
    
    private final Set<CompositionRule> deployedHealingCompositionRules = new HashSet<CompositionRule>();
    
    private final Set<CompositionRule> deployedNonHealingCompositionRules = new HashSet<CompositionRule>();
    
    private final HashMap<Attachment, Set<Attachment>> partialOrder = new HashMap<Attachment, Set<Attachment>>();
    
    /**
     * Contains all {@code Pattern}s that the {@code System} has seen during deployment of attachments. The patterns are
     * mapped to the specializations (seen by the {@code System}) that refer to them.
     */
    private final Map<Pattern<?>, Set<Specialization>> pattern2Specializations =
                    new IdentityHashMap<Pattern<?>, Set<Specialization>>();
    
    /**
     * Contains all {@code Spacialization}s that the {@code System} has seen during deployment of attachments. The
     * specializations are mapped to the attachments (seen by the {@code System}) that refer to them.
     */
    private final Map<Specialization, Set<Attachment>> specialization2attachments =
                    new IdentityHashMap<Specialization, Set<Attachment>>();
    
    public static void deploy(final Attachment... attachments) {
        System.getInstance().deployImpl(attachments);
    }
    
    private final Set<GenericFunction<?, ?>> modifiedGenericFunctions = new HashSet<GenericFunction<?, ?>>();
    
    protected synchronized void deployImpl(final Attachment... attachments) {
        // since this method is synchronized, it is OK to use the field for storing and reusing the set.
        // I.e., there may not be two instances of this method running at the same time.
        // the same set is used in undeployment which is also OK because the undeploy method is also
        // synchronized, i.e., both methods synchronize on the singleton System instance.
        this.modifiedGenericFunctions.clear();
        for (final Attachment attachment : attachments) {
            
            // TODO throwing this exception will leave the System in a dirty state if multiple attachments
            // are deployed
            if (this.deployedAttachments.containsKey(attachment))
                throw new IllegalStateException("Attachment is already deployed");
            this.deployedAttachments.put(attachment, null);
            
            for (final Specialization currentSpecialization : attachment.getSpecializations()) {
                for (final Signed<?> genericFunction : this.getGenericFunctions(currentSpecialization.getPattern())) {
                    this.attachAttachmentToGenericFunction(attachment, currentSpecialization,
                                    (GenericFunction<?, ?>) genericFunction);
                    this.modifiedGenericFunctions.add((GenericFunction<?, ?>) genericFunction);
                }
                
                if (!this.pattern2Specializations.containsKey(currentSpecialization.getPattern())) {
                    final Set<Specialization> specializations = new HashSet<Specialization>();
                    specializations.add(currentSpecialization);
                    this.pattern2Specializations.put(currentSpecialization.getPattern(), specializations);
                } else
                    this.pattern2Specializations.get(currentSpecialization.getPattern()).add(currentSpecialization);
                
                if (!this.specialization2attachments.containsKey(currentSpecialization)) {
                    final Set<Attachment> mappedAttachments = new HashSet<Attachment>();
                    mappedAttachments.add(attachment);
                    this.specialization2attachments.put(currentSpecialization, mappedAttachments);
                } else
                    this.specialization2attachments.get(currentSpecialization).add(attachment);
            }
        }
        this.substituteModifiedGenericFunctions(this.modifiedGenericFunctions);
    }
    
    private final Map<Attachment, Void> deployedAttachments = new IdentityHashMap<Attachment, Void>();
    
    private final Map<MethodPattern, Set<GenericFunction<MethodSignature, ?>>> matchedMethodCalls =
                    new IdentityHashMap<MethodPattern, Set<GenericFunction<MethodSignature, ?>>>();
    
    private final Map<FieldReadPattern, Set<GenericFunction<FieldReadSignature, ?>>> matchedFieldReads =
                    new IdentityHashMap<FieldReadPattern, Set<GenericFunction<FieldReadSignature, ?>>>();
    
    private final Map<FieldWritePattern, Set<GenericFunction<FieldWriteSignature, ?>>> matchedFieldWrites =
                    new IdentityHashMap<FieldWritePattern, Set<GenericFunction<FieldWriteSignature, ?>>>();
    
    private final Map<ConstructorPattern, Set<GenericFunction<ConstructorSignature, ?>>> matchedConstructorCalls =
                    new IdentityHashMap<ConstructorPattern, Set<GenericFunction<ConstructorSignature, ?>>>();
    
    private final Map<StaticInitializerPattern, Set<GenericFunction<StaticInitializerSignature, ?>>> matchedStaticInitializations =
                    new IdentityHashMap<StaticInitializerPattern, Set<GenericFunction<StaticInitializerSignature, ?>>>();
    
    private Set<? extends GenericFunction<?, ?>> getGenericFunctions(final Pattern<?> pattern) {
        if (pattern instanceof MethodPattern) {
            final MethodPattern methodPattern = (MethodPattern) pattern;
            if (!this.matchedMethodCalls.containsKey(methodPattern)) {
                final Set<GenericFunction<MethodSignature, ?>> matched = new HashSet<GenericFunction<MethodSignature, ?>>();
                for (final GenericFunction<MethodSignature, ?> methodCall : this.methodCalls) {
                    if (methodPattern.match(methodCall.getSignature()))
                        matched.add(methodCall);
                }
                this.matchedMethodCalls.put(methodPattern, matched);
            }
            return this.matchedMethodCalls.get(methodPattern);
        } else if (pattern instanceof FieldReadPattern) {
            final FieldReadPattern fieldReadPattern = (FieldReadPattern) pattern;
            if (!this.matchedFieldReads.containsKey(fieldReadPattern)) {
                final Set<GenericFunction<FieldReadSignature, ?>> matched =
                                new HashSet<GenericFunction<FieldReadSignature, ?>>();
                for (final GenericFunction<FieldReadSignature, ?> fieldRead : this.fieldReads) {
                    if (fieldReadPattern.match(fieldRead.getSignature()))
                        matched.add(fieldRead);
                }
                this.matchedFieldReads.put(fieldReadPattern, matched);
            }
            return this.matchedFieldReads.get(fieldReadPattern);
        } else if (pattern instanceof FieldWritePattern) {
            final FieldWritePattern fieldWritePattern = (FieldWritePattern) pattern;
            if (!this.matchedFieldWrites.containsKey(fieldWritePattern)) {
                final Set<GenericFunction<FieldWriteSignature, ?>> matched =
                                new HashSet<GenericFunction<FieldWriteSignature, ?>>();
                for (final GenericFunction<FieldWriteSignature, ?> fieldWrite : this.fieldWrites) {
                    if (fieldWritePattern.match(fieldWrite.getSignature()))
                        matched.add(fieldWrite);
                }
                this.matchedFieldWrites.put(fieldWritePattern, matched);
            }
            return this.matchedFieldWrites.get(fieldWritePattern);
        } else if (pattern instanceof ConstructorPattern) {
            final ConstructorPattern constructorPattern = (ConstructorPattern) pattern;
            if (!this.matchedConstructorCalls.containsKey(constructorPattern)) {
                final Set<GenericFunction<ConstructorSignature, ?>> matched =
                                new HashSet<GenericFunction<ConstructorSignature, ?>>();
                for (final GenericFunction<ConstructorSignature, ?> constructorCall : this.constructorCalls) {
                    if (constructorPattern.match(constructorCall.getSignature()))
                        matched.add(constructorCall);
                }
                this.matchedConstructorCalls.put(constructorPattern, matched);
            }
            return this.matchedConstructorCalls.get(constructorPattern);
        } else if (pattern instanceof StaticInitializerPattern) {
            final StaticInitializerPattern staticInitializerPattern = (StaticInitializerPattern) pattern;
            if (!this.matchedStaticInitializations.containsKey(staticInitializerPattern)) {
                final Set<GenericFunction<StaticInitializerSignature, ?>> matched =
                                new HashSet<GenericFunction<StaticInitializerSignature, ?>>();
                for (final GenericFunction<StaticInitializerSignature, ?> staticInitialization : this.staticInitializers) {
                    if (staticInitializerPattern.match(staticInitialization.getSignature()))
                        matched.add(staticInitialization);
                }
                this.matchedStaticInitializations.put(staticInitializerPattern, matched);
            }
            return this.matchedStaticInitializations.get(staticInitializerPattern);
        } else {
            throw new Error("Unsupported kind of Pattern.");
        }
    }
    
    // TODO inline
    private void attachAttachmentToGenericFunction(final Attachment attachment, final Specialization specialization,
                    final GenericFunction<?, ?> genericFunction) {
        genericFunction.attach(attachment, specialization.getPredicate(), new AttachedAction(attachment.getAction(),
                        specialization.getContexts(), attachment.getScheduleInfo(), attachment));
    }
    
    public static void undeploy(final Attachment... attachments) {
        System.getInstance().undeployImpl(attachments);
    }
    
    protected synchronized void undeployImpl(final Attachment... attachments) {
        // since this method is synchronized, it is OK to use the field for storing and reusing the set.
        // I.e., there may not be two instances of this method running at the same time.
        // the same set is used in deployment which is also OK because the deploy method is also
        // synchronized, i.e., both methods synchronize on the singleton System instance.
        this.modifiedGenericFunctions.clear();
        
        for (final Attachment attachment : attachments) {
            
            if (!this.deployedAttachments.containsKey(attachment))
                throw new IllegalStateException("Attachment is not yet deployed");
            this.deployedAttachments.remove(attachment);
            
            for (final Specialization currentSpecialization : attachment.getSpecializations()) {
                for (final Signed<?> genericFunction : this.getGenericFunctions(currentSpecialization.getPattern())) {
                    ((GenericFunction<?, ?>) genericFunction).detach(attachment);
                    this.modifiedGenericFunctions.add((GenericFunction<?, ?>) genericFunction);
                }
            }
        }
        
        this.substituteModifiedGenericFunctions(this.modifiedGenericFunctions);
    }
    
    public synchronized void addGenericFunctions(final Set<GenericFunction<ConstructorSignature, ?>> constructorCalls,
                    final Set<GenericFunction<StaticInitializerSignature, ?>> staticInitializers,
                    final Set<GenericFunction<MethodSignature, ?>> methodCalls,
                    final Set<GenericFunction<FieldReadSignature, ?>> fieldReads,
                    final Set<GenericFunction<FieldWriteSignature, ?>> fieldWrites) {
        final Set<GenericFunction<?, ?>> modifiedGenericFunctions = new HashSet<GenericFunction<?, ?>>();
        
        this.<MethodSignature>processAdditionalGenericFunctions(this.matchedMethodCalls, methodCalls,
                        modifiedGenericFunctions);
        this.<FieldReadSignature>processAdditionalGenericFunctions(this.matchedFieldReads, fieldReads,
                        modifiedGenericFunctions);
        this.<FieldWriteSignature>processAdditionalGenericFunctions(this.matchedFieldWrites, fieldWrites,
                        modifiedGenericFunctions);
        this.<ConstructorSignature>processAdditionalGenericFunctions(this.matchedConstructorCalls, constructorCalls,
                        modifiedGenericFunctions);
        this.<StaticInitializerSignature>processAdditionalGenericFunctions(this.matchedStaticInitializations,
                        staticInitializers, modifiedGenericFunctions);
        
        this.constructorCalls.addAll(constructorCalls);
        this.staticInitializers.addAll(staticInitializers);
        this.methodCalls.addAll(methodCalls);
        this.fieldReads.addAll(fieldReads);
        this.fieldWrites.addAll(fieldWrites);
        
        this.substituteModifiedGenericFunctions(modifiedGenericFunctions);
    }
    
    private <S extends Signature> void processAdditionalGenericFunctions(
                    final Map<? extends Pattern<S>, Set<GenericFunction<S, ?>>> matchedGenericFunctions,
                    final Set<GenericFunction<S, ?>> additionalGenericFunctions,
                    final Set<GenericFunction<?, ?>> modifiedGenericFunctions) {
        for (final Pattern<S> pattern : matchedGenericFunctions.keySet()) {
            final Set<GenericFunction<S, ?>> matched = matchedGenericFunctions.get(pattern);
            for (final GenericFunction<S, ?> genericFunction : additionalGenericFunctions) {
                if (pattern.match(genericFunction.getSignature())) {
                    matched.add(genericFunction);
                    modifiedGenericFunctions.add(genericFunction);
                    for (final Specialization specialization : this.pattern2Specializations.get(pattern)) {
                        for (final Attachment attachment : this.specialization2attachments.get(specialization))
                            if (this.deployedAttachments.containsKey(attachment))
                                this.attachAttachmentToGenericFunction(attachment, specialization, genericFunction);
                    }
                }
            }
        }
    }
    
    public synchronized void addConstructorCalls(final Set<GenericFunction<ConstructorSignature, ?>> genericFunctions) {
        this.addGenericFunctions(genericFunctions, Collections.<GenericFunction<StaticInitializerSignature, ?>>emptySet(),
                        Collections.<GenericFunction<MethodSignature, ?>>emptySet(),
                        Collections.<GenericFunction<FieldReadSignature, ?>>emptySet(),
                        Collections.<GenericFunction<FieldWriteSignature, ?>>emptySet());
    }
    
    public synchronized void addStaticInitializers(final Set<GenericFunction<StaticInitializerSignature, ?>> genericFunctions) {
        this.addGenericFunctions(Collections.<GenericFunction<ConstructorSignature, ?>>emptySet(), genericFunctions,
                        Collections.<GenericFunction<MethodSignature, ?>>emptySet(),
                        Collections.<GenericFunction<FieldReadSignature, ?>>emptySet(),
                        Collections.<GenericFunction<FieldWriteSignature, ?>>emptySet());
    }
    
    public synchronized void addMethodCalls(final Set<GenericFunction<MethodSignature, ?>> genericFunctions) {
        this.addGenericFunctions(Collections.<GenericFunction<ConstructorSignature, ?>>emptySet(),
                        Collections.<GenericFunction<StaticInitializerSignature, ?>>emptySet(), genericFunctions,
                        Collections.<GenericFunction<FieldReadSignature, ?>>emptySet(),
                        Collections.<GenericFunction<FieldWriteSignature, ?>>emptySet());
    }
    
    public synchronized void addFieldReads(final Set<GenericFunction<FieldReadSignature, ?>> genericFunctions) {
        this.addGenericFunctions(Collections.<GenericFunction<ConstructorSignature, ?>>emptySet(),
                        Collections.<GenericFunction<StaticInitializerSignature, ?>>emptySet(),
                        Collections.<GenericFunction<MethodSignature, ?>>emptySet(), genericFunctions,
                        Collections.<GenericFunction<FieldWriteSignature, ?>>emptySet());
    }
    
    public synchronized void addFieldWrites(final Set<GenericFunction<FieldWriteSignature, ?>> genericFunctions) {
        this.addGenericFunctions(Collections.<GenericFunction<ConstructorSignature, ?>>emptySet(),
                        Collections.<GenericFunction<StaticInitializerSignature, ?>>emptySet(),
                        Collections.<GenericFunction<MethodSignature, ?>>emptySet(),
                        Collections.<GenericFunction<FieldReadSignature, ?>>emptySet(), genericFunctions);
    }
    
    // ////////////////////added by Haihan //////////////////////////
    public Attachment[] deployedAttachments() {
        Set<Attachment> set = this.deployedAttachments.keySet();
        return set.toArray(new Attachment[set.size()]);
    }
    
    public abstract void substituteModifiedGenericFunctions(final Set<GenericFunction<?, ?>> genericFunctions);
    
    public static void deploy(final PrecedenceRule... precedenceRules) {
        System.getInstance().deployImpl(precedenceRules);
    }
    
    protected synchronized void deployImpl(final PrecedenceRule... precedenceRules) {
        // since this method is synchronized, it is OK to use the field for storing and reusing the set.
        // I.e., there may not be two instances of this method running at the same time.
        // the same set is used in undeployment which is also OK because the undeploy method is also
        // synchronized, i.e., both methods synchronize on the singleton System instance.
        this.modifiedGenericFunctions.clear();
        for (final PrecedenceRule precedenceRule : precedenceRules) {
            
            if (this.deployedPrecedenceRules.contains(precedenceRule))
                throw new IllegalStateException("PrecedenceRule is already deployed");
            this.deployedPrecedenceRules.add(precedenceRule);
            for (Attachment preceededAttachment : precedenceRule.getPreceeded()) {
                if (this.deployedAttachments.containsKey(preceededAttachment)) {
                    
                    for (final Specialization currentSpecialization : preceededAttachment.getSpecializations()) {
                        for (final Signed<?> genericFunction : this.getGenericFunctions(currentSpecialization.getPattern())) {
                            this.modifiedGenericFunctions.add((GenericFunction<?, ?>) genericFunction);
                        }
                    }
                    
                }
            }
            for (Attachment preceedingAttachment : precedenceRule.getPreceeding()) {
                if (this.deployedAttachments.containsKey(preceedingAttachment)) {
                    
                    for (final Specialization currentSpecialization : preceedingAttachment.getSpecializations()) {
                        for (final Signed<?> genericFunction : this.getGenericFunctions(currentSpecialization.getPattern())) {
                            this.modifiedGenericFunctions.add((GenericFunction<?, ?>) genericFunction);
                        }
                    }
                    
                }
            }
            
        }
        this.buildPartialOrder();
        this.substituteModifiedGenericFunctions(this.modifiedGenericFunctions);
    }
    
    public static void undeploy(final PrecedenceRule... precedenceRules) {
        System.getInstance().undeployImpl(precedenceRules);
    }
    
    protected void undeployImpl(final PrecedenceRule... precedenceRules) {
        // since this method is synchronized, it is OK to use the field for storing and reusing the set.
        // I.e., there may not be two instances of this method running at the same time.
        // the same set is used in undeployment which is also OK because the undeploy method is also
        // synchronized, i.e., both methods synchronize on the singleton System instance.
        this.modifiedGenericFunctions.clear();
        for (final PrecedenceRule precedenceRule : precedenceRules) {
            
            if (!this.deployedPrecedenceRules.contains(precedenceRule))
                throw new IllegalStateException("PrecedenceRule is not deployed");
            this.deployedPrecedenceRules.remove(precedenceRule);
            for (Attachment preceededAttachment : precedenceRule.getPreceeded()) {
                if (this.deployedAttachments.containsKey(preceededAttachment)) {
                    
                    for (final Specialization currentSpecialization : preceededAttachment.getSpecializations()) {
                        for (final Signed<?> genericFunction : this.getGenericFunctions(currentSpecialization.getPattern())) {
                            this.modifiedGenericFunctions.add((GenericFunction<?, ?>) genericFunction);
                        }
                    }
                    
                }
            }
            for (Attachment preceedingAttachment : precedenceRule.getPreceeding()) {
                if (this.deployedAttachments.containsKey(preceedingAttachment)) {
                    
                    for (final Specialization currentSpecialization : preceedingAttachment.getSpecializations()) {
                        for (final Signed<?> genericFunction : this.getGenericFunctions(currentSpecialization.getPattern())) {
                            this.modifiedGenericFunctions.add((GenericFunction<?, ?>) genericFunction);
                        }
                    }
                    
                }
            }
            
        }
        this.buildPartialOrder();
        this.substituteModifiedGenericFunctions(this.modifiedGenericFunctions);
    }
    
    private void buildPartialOrder() {
        this.partialOrder.clear();
        for (PrecedenceRule precedenceRule : this.deployedPrecedenceRules) {
            for (Attachment preceeding : precedenceRule.getPreceeding()) {
                Set<Attachment> precededSet = this.partialOrder.get(preceeding);
                if (precededSet == null) {
                    precededSet = new HashSet<Attachment>();
                    this.partialOrder.put(preceeding, precededSet);
                }
                precededSet.addAll(precedenceRule.getPreceeded());
            }
        }
    }
    
    public static void deploy(final CompositionRule... compositionRules) {
        System.getInstance().deployImpl(compositionRules);
    }
    
    protected synchronized void deployImpl(final CompositionRule... compositionRules) {
        // since this method is synchronized, it is OK to use the field for storing and reusing the set.
        // I.e., there may not be two instances of this method running at the same time.
        // the same set is used in undeployment which is also OK because the undeploy method is also
        // synchronized, i.e., both methods synchronize on the singleton System instance.
        this.modifiedGenericFunctions.clear();
        for (final CompositionRule compositionRule : compositionRules) {
            
            if ((compositionRule.isHealing() && this.deployedHealingCompositionRules.contains(compositionRule))
                            || (!compositionRule.isHealing() && this.deployedNonHealingCompositionRules
                                            .contains(compositionRule)))
                throw new IllegalStateException("CompositionRule is already deployed");
            
            if (compositionRule.isHealing())
                this.deployedHealingCompositionRules.add(compositionRule);
            else
                this.deployedNonHealingCompositionRules.add(compositionRule);
        }
        this.substituteModifiedGenericFunctions(this.modifiedGenericFunctions);
    }
    
    public static void undeploy(final CompositionRule... compositionRules) {
        System.getInstance().deployImpl(compositionRules);
    }
    
    protected synchronized void undeployImpl(final CompositionRule... compositionRules) {
        // since this method is synchronized, it is OK to use the field for storing and reusing the set.
        // I.e., there may not be two instances of this method running at the same time.
        // the same set is used in undeployment which is also OK because the undeploy method is also
        // synchronized, i.e., both methods synchronize on the singleton System instance.
        this.modifiedGenericFunctions.clear();
        for (final CompositionRule compositionRule : compositionRules) {
            
            if ((compositionRule.isHealing() && !this.deployedHealingCompositionRules.contains(compositionRule))
                            || (!compositionRule.isHealing() && !this.deployedNonHealingCompositionRules
                                            .contains(compositionRule)))
                throw new IllegalStateException("CompositionRule is not deployed");
            
            if (compositionRule.isHealing())
                this.deployedHealingCompositionRules.remove(compositionRule);
            else
                this.deployedNonHealingCompositionRules.remove(compositionRule);
        }
        this.substituteModifiedGenericFunctions(this.modifiedGenericFunctions);
    }
    
    public static Object proceed() throws Throwable {
        return System.getInstance().proceedImpl(Collections.<Context, Object>emptyMap());
    }
    
    public static Object proceed(Map<Context, ? extends Object> modifiedContexts) throws Throwable {
        return System.getInstance().proceedImpl(modifiedContexts);
    }
    
    protected abstract Object proceedImpl(Map<Context, ? extends Object> modifiedContexts) throws Throwable;
    
    public synchronized ActionOrderElement schedule(final Set<AttachedAction> applicableActions) {
        Set<AttachedAction> actionsToExecute = new HashSet<AttachedAction>(applicableActions);
        
        Set<CompositionRule> applicableHealingCompositonRules;
        while (!(applicableHealingCompositonRules =
                        this.findViolatedCompositionRules(this.deployedHealingCompositionRules, actionsToExecute)).isEmpty()) {
            for (CompositionRule compositionRule : applicableHealingCompositonRules) {
                this.applyHealing(actionsToExecute, compositionRule);
            }
        }
        if (!this.findViolatedCompositionRules(this.deployedNonHealingCompositionRules, actionsToExecute).isEmpty()) {
            throw new IllegalArgumentException("CompositionRules are violated.");
        }
        
        Set<AttachedAction> farthestSet = new HashSet<AttachedAction>();
        Set<AttachedAction> userSet = new HashSet<AttachedAction>();
        Set<AttachedAction> closestSet = new HashSet<AttachedAction>();
        Set<AttachedAction> implicitAction = Collections.emptySet();
        Map<Attachment, AttachedAction> attachment2AttachedAction = new HashMap<Attachment, AttachedAction>();
        for (AttachedAction attachedAction : actionsToExecute) {
            attachment2AttachedAction.put(attachedAction.getAttachment(), attachedAction);
            switch (attachedAction.getScheduleInfo().getRule()) {
            case FARTHEST_FROM_IMPLICIT_ACTION:
                farthestSet.add(attachedAction);
                break;
            
            case CLOSEST_TO_IMPLICIT_ACTION:
                closestSet.add(attachedAction);
                break;
            
            case DEFAULT:
                userSet.add(attachedAction);
                break;
            
            case IMPLICIT_ACTION:
                implicitAction = Collections.singleton(attachedAction);
                break;
            
            default:
                throw new IllegalArgumentException();
            }
        }
        
        List<Pair<Set<AttachedAction>, Set<AttachedAction>>> precedenceRelations =
                        new ArrayList<Pair<Set<AttachedAction>, Set<AttachedAction>>>();
        
        precedenceRelations.add(new Pair<Set<AttachedAction>, Set<AttachedAction>>(farthestSet, userSet));
        precedenceRelations.add(new Pair<Set<AttachedAction>, Set<AttachedAction>>(farthestSet, closestSet));
        precedenceRelations.add(new Pair<Set<AttachedAction>, Set<AttachedAction>>(farthestSet, implicitAction));
        
        precedenceRelations.add(new Pair<Set<AttachedAction>, Set<AttachedAction>>(userSet, closestSet));
        precedenceRelations.add(new Pair<Set<AttachedAction>, Set<AttachedAction>>(userSet, implicitAction));
        
        precedenceRelations.add(new Pair<Set<AttachedAction>, Set<AttachedAction>>(closestSet, implicitAction));
        
        for (AttachedAction preceding : actionsToExecute) {
            if (this.partialOrder.containsKey(preceding.getAttachment())) {
                Set<Attachment> preceededSet = this.partialOrder.get(preceding.getAttachment());
                Set<AttachedAction> right = new HashSet<AttachedAction>();
                for (Attachment preceded : preceededSet) {
                    if (attachment2AttachedAction.containsKey(preceded))
                        right.add(attachment2AttachedAction.get(preceded));
                }
                if (!right.isEmpty())
                    precedenceRelations.add(new Pair<Set<AttachedAction>, Set<AttachedAction>>(Collections
                                    .singleton(preceding), right));
            }
        }
        List<AttachedAction> sortedAttachedActions =
                        TopologicSorter.<AttachedAction>sort(actionsToExecute, precedenceRelations);
        final ActionOrderElement first = new ActionOrderElement();
        ActionOrderElement current = first;
        
        int position = 0;
        for (final AttachedAction attachedAction : sortedAttachedActions) {
            position++;
            switch (attachedAction.getScheduleInfo().getTime()) {
            case BEFORE:
                current.getBefore().add(attachedAction);
                break;
            case AFTER:
                current.getAfter().add(0, attachedAction);
                break;
            case AROUND:
                current.around = attachedAction;
                if (position != sortedAttachedActions.size()) {
                    final ActionOrderElement next = new ActionOrderElement();
                    current.inner = next;
                    current = next;
                }
                break;
            default:
                throw new IllegalStateException("Action time not supported. (" + attachedAction.getScheduleInfo().getTime()
                                + ")");
            }
        }
        
        return first;
    }
    
    private void applyHealing(Set<AttachedAction> actions, CompositionRule compositionRule) {
        Set<AttachedAction> forbiddenActions = new HashSet<AttachedAction>();
        for (AttachedAction attachedAction : actions) {
            for (AttachmentReference reference : compositionRule.getForbidden()) {
                if (reference.references(attachedAction.getAttachment()))
                    forbiddenActions.add(attachedAction);
            }
        }
        actions.removeAll(forbiddenActions);
    }
    
    private Set<CompositionRule> findViolatedCompositionRules(Set<CompositionRule> compositionRules,
                    Set<AttachedAction> actions) {
        Set<CompositionRule> result = new HashSet<CompositionRule>();
        findRules: for (CompositionRule compositionRule : compositionRules) {
            
            // first check prerequisites
            
            // check if rule applies
            // first try to find all that should be present
            findPresent: for (AttachmentReference reference : compositionRule.getPresent()) {
                
                for (AttachedAction attachedAction : actions) {
                    if (reference.references(attachedAction.getAttachment()))
                        // found an attachment matching the searched reference
                        break findPresent;
                }
                // did not find the referenced attachment: whole rule does not match
                continue findRules;
            }
            
            // the attachment references that must be present are satisfied
            // now check that there is no attachment that should be absent
            for (AttachmentReference reference : compositionRule.getAbsent()) {
                for (AttachedAction attachedAction : actions) {
                    if (reference.references(attachedAction.getAttachment()))
                        // found an attachment which should be absent for the current
                        // rule. i.e., the rule does not apply
                        continue findRules;
                }
            }
            // did not find an attachment that should be absent for the rule
            // i.e., the rule applies
            
            // we know that the rule applies now, so let's see if it is violated
            
            // first check if all required attachments are present
            
            findRequired: for (AttachmentReference reference : compositionRule.getRequired()) {
                for (AttachedAction attachedAction : actions) {
                    if (reference.references(attachedAction.getAttachment()))
                        continue findRequired;
                }
                // we did not find the current required attachment reference
                // so the rule is violated
                // add it to the result set
                result.add(compositionRule);
                // we don't need to search for further violations
                continue findRules;
            }
            
            // now check if none of the forbiddent attachments is present
            for (AttachmentReference reference : compositionRule.getForbidden()) {
                for (AttachedAction attachedAction : actions) {
                    if (reference.references(attachedAction.getAttachment())) {
                        // we found an attachment which is forbiddent
                        // so the rule is violated
                        // att it to the result set
                        result.add(compositionRule);
                        // we don't need to search for further violations
                        continue findRules;
                    }
                    
                }
            }
            // we did not find a violation, so the rule must not be added to the
            // result set
        }
        return result;
    }
    
}
