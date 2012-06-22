package org.alia4j.aspectj.parser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.alia4j.aspectj.parser.ast.AJPointcutParser;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.ActionFactory;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.DebugInfo;
import org.alia4j.liam.ScheduleInfo;
import org.alia4j.liam.Specialization;
import org.alia4j.util.Pair;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.EmptyVisitor;

/**
 * Reads the bytecode of the class whose name is passed to the constructor, reads its annotations and creates an Aspect
 * definition from them. Currently, only the annotations of a before advice are handled correctly. Everything else is
 * ignored. Does not cause class loading.
 *
 * @author Christoph Bockisch
 */
// TODO also support after, around, etc. advice annotations
class AspectClassAnnotationsProcessor extends EmptyVisitor {

    private static enum PointcutUsedBy {
        BEFORE, AFTER, AROUND, AFTER_RETURNING, AFTER_THROWING, NAMED_POINTCUT
    }

    private final List<Attachment> attachments;

    private final String aspectClassName;

    private MethodDescriptor currentMethod;

    private String sourceFileName;

    protected AspectClassAnnotationsProcessor(final String aspectClassName) {
        this.aspectClassName = aspectClassName;
        this.attachments = new ArrayList<Attachment>();
    }

    private class AdviceMethodAnnotationsProcessor extends EmptyVisitor {

        private class AnnotationProcessor extends EmptyVisitor {

            private final Map<String, String> nameValuePairs = new HashMap<String, String>();

            private String annotationName;

            private AnnotationProcessor(final String annotationName) {
                this.annotationName = annotationName.replace('/', '.');
                if (this.annotationName.endsWith(";")) {
                    this.annotationName = this.annotationName.substring(1, this.annotationName.length() - 1);
                }
            }

            @Override
            public void visit(final String name, final Object value) {
                this.nameValuePairs.put(name, value.toString());
            }

            @Override
            public void visitEnd() {
                if (this.annotationName.equals(Before.class.getName())) {
                    AdviceMethodAnnotationsProcessor.this.pointcut = this.nameValuePairs.get("value");
                    AdviceMethodAnnotationsProcessor.this.argNames = this.nameValuePairs.get("argNames");
                    AdviceMethodAnnotationsProcessor.this.pointcutUsedBy = PointcutUsedBy.BEFORE;
                } else if (this.annotationName.equals(Around.class.getName())) {
                    AdviceMethodAnnotationsProcessor.this.pointcut = this.nameValuePairs.get("value");
                    AdviceMethodAnnotationsProcessor.this.argNames = this.nameValuePairs.get("argNames");
                    AdviceMethodAnnotationsProcessor.this.pointcutUsedBy = PointcutUsedBy.AROUND;
                } else if (this.annotationName.equals(After.class.getName())) {
                    AdviceMethodAnnotationsProcessor.this.pointcut = this.nameValuePairs.get("value");
                    AdviceMethodAnnotationsProcessor.this.argNames = this.nameValuePairs.get("argNames");
                    AdviceMethodAnnotationsProcessor.this.pointcutUsedBy = PointcutUsedBy.AFTER;
                } else if (this.annotationName.equals(AfterReturning.class.getName())) {
                    AdviceMethodAnnotationsProcessor.this.pointcut = this.nameValuePairs.get("pointcut");
                    AdviceMethodAnnotationsProcessor.this.argNames = this.nameValuePairs.get("argNames");
                    AdviceMethodAnnotationsProcessor.this.pointcutUsedBy = PointcutUsedBy.AFTER_RETURNING;
                } else if (this.annotationName.equals(AfterThrowing.class.getName())) {
                    AdviceMethodAnnotationsProcessor.this.pointcut = this.nameValuePairs.get("pointcut");
                    AdviceMethodAnnotationsProcessor.this.argNames = this.nameValuePairs.get("argNames");
                    AdviceMethodAnnotationsProcessor.this.pointcutUsedBy = PointcutUsedBy.AFTER_THROWING;
                } else if (this.annotationName.equals(Pointcut.class.getName())) {
                    AdviceMethodAnnotationsProcessor.this.pointcut = this.nameValuePairs.get("value");
                    AdviceMethodAnnotationsProcessor.this.argNames = this.nameValuePairs.get("argNames");
                    AdviceMethodAnnotationsProcessor.this.pointcutUsedBy = PointcutUsedBy.NAMED_POINTCUT;
                } else {
                    return; // annotation not recognized
                }
            }

        }

        private String pointcut;

        private String argNames;

        private PointcutUsedBy pointcutUsedBy;

        @Override
        public AnnotationVisitor visitAnnotation(final String descriptor, final boolean visible) {
            return new AnnotationProcessor(descriptor);
        }

        private int methodFirstLineNumber = Integer.MAX_VALUE;

        private int methodLastLineNumber = Integer.MIN_VALUE;

        @Override
        public void visitLineNumber(final int line, final Label start) {
            if (line > this.methodLastLineNumber)
                this.methodLastLineNumber = line;
            if (line < this.methodFirstLineNumber)
                this.methodFirstLineNumber = line;
        }

        @SuppressWarnings("unchecked")
        @Override
        public void visitEnd() {
            if (this.pointcutUsedBy == null)
                return;

            final Map<String, Pair<Integer, TypeDescriptor>> argName2IndexType =
                            new HashMap<String, Pair<Integer, TypeDescriptor>>();

            final String parameterDescriptorList =
                            AspectClassAnnotationsProcessor.this.currentMethod.getDescriptor().substring(1,
                                            AspectClassAnnotationsProcessor.this.currentMethod.getDescriptor().indexOf(')'));

            final TypeDescriptor[] parameterTypeNames =
                            TypeHierarchyProvider.findOrCreateFromTypeDescriptors(parameterDescriptorList);
            final String[] argNamesArray = this.argNames.trim().equals("") ? new String[] {} : this.argNames.split(",");

            // Note that there may be parameters which are not listed in the annotations argNames property.
            // These are typically the JoinPoint and JoinPoint.StaticPart parameters.
            for (int i = 0; i < parameterTypeNames.length; i++) {
                final String argName;

                if (i < argNamesArray.length)
                    argName = argNamesArray[i];
                else if (parameterTypeNames[i].equals("org.aspectj.lang.JoinPoint"))
                    argName = "thisJoinPoint";
                else if (parameterTypeNames[i].equals("org.aspectj.lang.JoinPoint$StaticPart"))
                    argName = "thisJoinPointStaticPart";
                else
                    throw new IllegalArgumentException(
                                    "Unknown special parameter (only thisJoinPoint and thisJoinPointStaticPart supported): "
                                                    + parameterTypeNames[i]);

                argName2IndexType.put(argName, new Pair<Integer, TypeDescriptor>(i, parameterTypeNames[i]));
            }

            Set<Specialization> parsedPointcut = null;
            if (this.pointcut.equals("")) {
                // The annotation is for an abstract named pointcut; TODO implement support
            } else {
                final AJPointcutParser parser = new AJPointcutParser(new StringReader(this.pointcut));
                try {
                    final Context aspectInstanceContext =
                                    ContextFactory.findOrCreateLazyObjectConstantContext(TypeHierarchyProvider
                                                    .findOrCreateFromNormalTypeName(AspectClassAnnotationsProcessor.this.aspectClassName));
                    parser.PointcutExpression();
                    parsedPointcut =
                                    (Set<Specialization>) parser.getTreeRoot().jjtAccept(
                                                    new AJPointcutToLIAMVisitor(argName2IndexType, aspectInstanceContext),
                                                    null);
                } catch (final Exception e) {
                    throw new RuntimeException("While parsing pointcut " + this.pointcut, e);
                }
            }

            try {
                if (this.pointcutUsedBy == PointcutUsedBy.BEFORE) {
                    AspectClassAnnotationsProcessor.this.attachments.add(new Attachment(parsedPointcut, ActionFactory
                                    .findOrCreateMethodCallAction(AspectClassAnnotationsProcessor.this.aspectClassName,
                                                    AspectClassAnnotationsProcessor.this.currentMethod.getName(),
                                                    AspectClassAnnotationsProcessor.this.currentMethod.getDescriptor()),
                                    ScheduleInfo.BEFORE, new DebugInfo(AspectClassAnnotationsProcessor.this.sourceFileName,
                                                    this.methodFirstLineNumber, this.methodLastLineNumber)));
                } else if (this.pointcutUsedBy == PointcutUsedBy.AROUND) {
                    throw new UnsupportedOperationException("around advice not yet supported (in "
                                    + AspectClassAnnotationsProcessor.this.aspectClassName + "."
                                    + AspectClassAnnotationsProcessor.this.currentMethod.getName()
                                    + AspectClassAnnotationsProcessor.this.currentMethod.getDescriptor() + ")");
                } else if (this.pointcutUsedBy == PointcutUsedBy.AFTER) {
                    AspectClassAnnotationsProcessor.this.attachments.add(new Attachment(parsedPointcut, ActionFactory
                            .findOrCreateMethodCallAction(AspectClassAnnotationsProcessor.this.aspectClassName,
                                            AspectClassAnnotationsProcessor.this.currentMethod.getName(),
                                            AspectClassAnnotationsProcessor.this.currentMethod.getDescriptor()),
                            ScheduleInfo.AFTER, new DebugInfo(AspectClassAnnotationsProcessor.this.sourceFileName,
                                            this.methodFirstLineNumber, this.methodLastLineNumber)));
//                    throw new UnsupportedOperationException("after advice not yet supported (in "
//                                    + AspectClassAnnotationsProcessor.this.aspectClassName + "."
//                                    + AspectClassAnnotationsProcessor.this.currentMethod.getName()
//                                    + AspectClassAnnotationsProcessor.this.currentMethod.getDescriptor() + ")");
                } else if (this.pointcutUsedBy == PointcutUsedBy.AFTER_RETURNING) {
                    throw new UnsupportedOperationException("after returning advice not yet supported (in "
                                    + AspectClassAnnotationsProcessor.this.aspectClassName + "."
                                    + AspectClassAnnotationsProcessor.this.currentMethod.getName()
                                    + AspectClassAnnotationsProcessor.this.currentMethod.getDescriptor() + ")");
                } else if (this.pointcutUsedBy == PointcutUsedBy.AFTER_THROWING) {
                    throw new UnsupportedOperationException("after throwing advice not yet supported (in "
                                    + AspectClassAnnotationsProcessor.this.aspectClassName + "."
                                    + AspectClassAnnotationsProcessor.this.currentMethod.getName()
                                    + AspectClassAnnotationsProcessor.this.currentMethod.getDescriptor() + ")");
                } else if (this.pointcutUsedBy == PointcutUsedBy.NAMED_POINTCUT) {
                    throw new UnsupportedOperationException("named pointcuts not yet supported (in "
                                    + AspectClassAnnotationsProcessor.this.aspectClassName + "."
                                    + AspectClassAnnotationsProcessor.this.currentMethod.getName()
                                    + AspectClassAnnotationsProcessor.this.currentMethod.getDescriptor() + ")");
                } else {
                    return; // not an annotation relevant for AspectJ
                }
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }

        }

    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name, final String descriptor,
                    final String genericTypeSignature, final String[] exceptions) {
        this.currentMethod = new MethodDescriptor(access, name, descriptor, genericTypeSignature, exceptions);

        return new AdviceMethodAnnotationsProcessor();
    }

    @Override
    public void visitSource(final String source, final String debug) {
        this.sourceFileName = source;
    }

    public List<Attachment> getAttachments() {
        return this.attachments;
    }

}
