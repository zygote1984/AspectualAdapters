package org.alia4j.noirin.transform;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Modifier;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.alia4j.noirin.Interpreter;
import org.alia4j.noirin.InterpreterConstants;
import org.alia4j.noirin.transform.analysis.Analyzer;
import org.alia4j.noirin.transform.analysis.BasicInterpreter;
import org.alia4j.noirin.transform.analysis.BasicValue;
import org.alia4j.noirin.transform.analysis.Frame;
import org.alia4j.noirin.transform.analysis.ValueKind;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.LocalVariableNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.tree.analysis.BasicVerifier;
import org.objectweb.asm.util.AbstractVisitor;

public class InterpreterCallbackInserter implements ClassFileTransformer {
    
    private static final Type INTERPRETER_CONSTANTS_TYPE = Type.getType(InterpreterConstants.class);
    
    private static final String LOCAL_SLOT_UNINITIALIZED_FIELD = "LOCAL_SLOT_UNINITIALIZED";
    
    private static final String LOCAL_SLOT_RETURN_ADDRESS_FIELD = "LOCAL_SLOT_RETURN_ADDRESS";
    
    private static final String UNINITIALIZED_THIS_FIELD = "UNINITIALIZED_THIS";
    
    private static final Type OBJECT_TYPE = Type.getType(Object.class);
    
    private static final String INVOKESPECIAL_PREFIX = "invoke$pecial_";
    
    public static final int NO_LINE_NUMBER = -1;
    
    private static class GFCall {
        
        public final String declaringClassInternalName;
        
        public final String name;
        
        public final int opcode;
        
        public final String descriptor;
        
        public GFCall(final String declaringClassInternalName, final String name, final String descriptor, final int opcode) {
            super();
            this.declaringClassInternalName = declaringClassInternalName;
            this.name = name;
            this.descriptor = descriptor;
            this.opcode = opcode;
        }
        
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public byte[] transform(final ClassLoader loader, final String className, final Class<?> classBeingRedefined,
                    final ProtectionDomain protectionDomain, final byte[] classfileBuffer)
                    throws IllegalClassFormatException {
        // TODO unify the excludes criteria (see SiRIn and ERIn)
        // exclude some types to avoid recursion.
        // all ALIA4J classes are critical
        // the set of excluded types can be minimized, but to keep it simple, they are excluded by package at the moment
        
        // sun.reflect is excluded because instrumenting this leat to a SecurityException ("Unsafe")
        
        // java.lang.VerifyError: (class: org/apache/maven/surefire/booter/IsolatedClassLoader, method: <init> signature:
        // (Ljava/lang/ClassLoader;)V) Expecting to find object/array on stack
        if (this.isExcludedFromTransformation(className))
            return null;
        // if (className.startsWith("org/alia4j/") || className.startsWith("java/util/") ||
        // className.startsWith("java/lang/")
        // || className.startsWith("sun/reflect/") || className.startsWith("org/apache/maven/surefire/"))
        // return null;
        
        try {
            final ClassReader reader = new ClassReader(classfileBuffer);
            final ClassWriter writer = new ClassWriterWithoutClassLoading(reader, ClassWriter.COMPUTE_FRAMES);
            final ClassNode classNode = new ClassNode();
            reader.accept(classNode, 0);
            
            final List<LabelNode> passedLabels = new ArrayList<LabelNode>();
            final List<MethodNode> methods = classNode.methods;
            final ArrayList<MethodNode> addedMethods = new ArrayList<MethodNode>();
            
            final List<FieldNode> fields = classNode.fields;
            for (final FieldNode field : fields) {
            	if (Modifier.isFinal(field.access) && !Modifier.isStatic(field.access)) {
            		field.access = field.access & ~Modifier.FINAL;
            		TransformationSummary.addFinalField(className, field.name, field.desc);
            	}
            }

            
            for (final MethodNode method : methods) {
                if (!Modifier.isInterface(classNode.access) && !Modifier.isStatic(method.access)
                                && !method.name.equals("<init>") && !method.name.equals("<clinit>")) {
                    addedMethods.add(this.createInvokeStaticMethodNode(method, classNode));
                }
                final InsnList insns = method.instructions;
                AbstractInsnNode insnNode = insns.getFirst();
                int currentLineNumber = InterpreterCallbackInserter.NO_LINE_NUMBER;
                
                Frame<BasicValue>[] frames;
                try {
                    frames = new Analyzer<BasicValue>(new BasicInterpreter()).analyze(className, method);
                } catch (AnalyzerException e) {
                    throw e;
                }
                Map<AbstractInsnNode, Frame<BasicValue>> insn2Frame = new HashMap<AbstractInsnNode, Frame<BasicValue>>();
                ListIterator<AbstractInsnNode> it = insns.iterator();
                while (it.hasNext()) {
                    AbstractInsnNode insn = it.next();
                    insn2Frame.put(insn, frames[insns.indexOf(insn)]);
                }
                
                while (insnNode != null) {
                    if (insnNode instanceof LabelNode) {
                        passedLabels.add((LabelNode) insnNode);
                    } else if (insnNode instanceof LineNumberNode) {
                        currentLineNumber = ((LineNumberNode) insnNode).line;
                    } else if (insnNode.getOpcode() == Opcodes.INVOKESPECIAL
                                    && this.isExcludedFromTransformation(((MethodInsnNode) insnNode).owner)
                                    || (insnNode instanceof MethodInsnNode && ((MethodInsnNode) insnNode).owner
                                                    .startsWith("org/alia4j/"))) {
                        // do nothing
                    } else if (insnNode instanceof MethodInsnNode && ((MethodInsnNode) insnNode).name.equals("<init>")) {
                        if (frames == null)
                            throw new IllegalArgumentException("No frames have been computed.");
                        
                        final MethodInsnNode methodInsn = (MethodInsnNode) insnNode;
                        int index = insns.indexOf(insnNode);
                        int argumentsSize = Type.getArgumentTypes(methodInsn.desc).length;
                        
                        Frame<BasicValue> frame = insn2Frame.get(insnNode);
                        int stackIndex = frame.getStackSize() - argumentsSize - 1;
                        BasicValue receiverValue = frame.getStack(stackIndex);
                        if (receiverValue.valueKind == ValueKind.UNINITIALIZED_NEW_OBJECT) {
                            boolean removedNew = false;
                            int numberOfRemovedDup = 0;
                            while (receiverValue != null) {
                                Set<AbstractInsnNode> sourceInsns = receiverValue.insns;
                                if (sourceInsns.size() != 1)
                                    throw new IllegalArgumentException(
                                                    "Unrecognized usage of uninitialized new object. More than one source instructions. ("
                                                                    + className + ", " + method.name + " , " + method.desc
                                                                    + ", " + index + ")");
                                AbstractInsnNode sourceInsn = sourceInsns.iterator().next();
                                if (sourceInsn.getOpcode() == Opcodes.DUP) {
                                    insns.remove(sourceInsn);
                                    numberOfRemovedDup++;
                                } else if (sourceInsn.getOpcode() == Opcodes.NEW) {
                                    if (removedNew == true)
                                        throw new IllegalArgumentException(
                                                        "Unrecognized usage of uninitialized new object. More than one new instruction. ("
                                                                        + className + ", " + method.name + " , "
                                                                        + method.desc + ", " + index + ")");
                                    insns.remove(sourceInsn);
                                    removedNew = true;
                                } else {
                                    throw new IllegalArgumentException(
                                                    "Unrecognized usage of uninitialized new object. Opcode "
                                                                    + sourceInsn.getOpcode()
                                                                    + " uses uninitialized new object. (" + className + ", "
                                                                    + method.name + " , " + method.desc + ", " + index + ")");
                                }
                                if (receiverValue.sourceValues.size() > 1)
                                    throw new IllegalArgumentException(
                                                    "Unrecognized usage of uninitialized new object (multiple source values). Opcode "
                                                                    + sourceInsn.getOpcode()
                                                                    + " uses uninitialized new object. (" + className + ", "
                                                                    + method.name + " , " + method.desc + ", " + index + ")");
                                if (receiverValue.sourceValues.isEmpty())
                                    break;
                                
                                receiverValue = receiverValue.sourceValues.iterator().next();
                            }
                            if (!removedNew)
                                throw new IllegalArgumentException(
                                                "Unrecognized usage of uninitialized new object. No new instruction was found. ("
                                                                + className + ", " + method.name + " , " + method.desc
                                                                + ", " + index + ")");
                            
                            final GFCall call =
                                            new GFCall(methodInsn.owner, methodInsn.name, methodInsn.desc,
                                                            methodInsn.getOpcode());
                            
                            final InsnList list = new InsnList();
                            this.createInterpreterCallback(list, call, method, classNode, currentLineNumber, passedLabels,
                                            insn2Frame.get(insnNode));
                            if (numberOfRemovedDup == 0) {
                                list.add(new InsnNode(Opcodes.POP));
                            } else {
                                for (int i = 0; i < numberOfRemovedDup - 1; i++) {
                                    list.add(new InsnNode(Opcodes.DUP));
                                }
                            }
                            
                            insnNode = list.getLast();
                            insns.insertBefore(methodInsn, list);
                            insns.remove(methodInsn);
                        }
                    } else if (insnNode instanceof MethodInsnNode && !((MethodInsnNode) insnNode).name.equals("<init>")) {
                        final MethodInsnNode methodInsn = (MethodInsnNode) insnNode;
                        
                        final GFCall call =
                                        new GFCall(methodInsn.owner, methodInsn.name, methodInsn.desc,
                                                        methodInsn.getOpcode());
                        
                        final InsnList list = new InsnList();
                        this.createInterpreterCallback(list, call, method, classNode, currentLineNumber, passedLabels,
                                        insn2Frame.get(insnNode));
                        insnNode = list.getLast();
                        insns.insertBefore(methodInsn, list);
                        insns.remove(methodInsn);
                    } else if (insnNode instanceof FieldInsnNode) {
                        final FieldInsnNode fieldInsn = (FieldInsnNode) insnNode;
                        
                        // TODO: document the following:
                        // we need to skip write access to final fields because this cannot be performed by reflection
                        boolean skip = false;
                        if (fieldInsn.getOpcode() == Opcodes.PUTSTATIC) {
                            if (fieldInsn.owner.equals(classNode.name)) {
                                for (final FieldNode fieldNode : fields) {
                                    if (fieldNode.name.equals(fieldInsn.name) && Modifier.isFinal(fieldNode.access))
                                        skip = true;
                                }
                            }
                        }
                        
                        if (!skip) {
                            GFCall call;
                            if (fieldInsn.getOpcode() == Opcodes.GETFIELD || fieldInsn.getOpcode() == Opcodes.GETSTATIC)
                                call =
                                                new GFCall(fieldInsn.owner, fieldInsn.name, "()" + fieldInsn.desc,
                                                                fieldInsn.getOpcode());
                            else
                                call =
                                                new GFCall(fieldInsn.owner, fieldInsn.name, "(" + fieldInsn.desc + ")V",
                                                                fieldInsn.getOpcode());
                            
                            final InsnList list = new InsnList();
                            this.createInterpreterCallback(list, call, method, classNode, currentLineNumber, passedLabels,
                                            insn2Frame.get(insnNode));
                            insnNode = list.getLast();
                            insns.insertBefore(fieldInsn, list);
                            insns.remove(fieldInsn);
                        }
                    }
                    insnNode = insnNode.getNext();
                }
            }
            
            methods.addAll(addedMethods);
            
            classNode.accept(writer);
            
            // perform some basic verification of the transformed code (without triggering class loading)
            final ClassReader readerVerify = new ClassReader(writer.toByteArray());
            final ClassNode classNodeVerify = new ClassNode();
            readerVerify.accept(classNodeVerify, 0);
            for (int i = 0; i < classNodeVerify.methods.size(); ++i) {
                final MethodNode method = (MethodNode) classNodeVerify.methods.get(i);
                
                final BasicVerifier verifier = new BasicVerifier();
                final org.objectweb.asm.tree.analysis.Analyzer a = new org.objectweb.asm.tree.analysis.Analyzer(verifier);
                try {
                    a.analyze(classNode.name, method);
                } catch (final AnalyzerException e) {
                    e.printStackTrace();
                    System.out.println(className + " " + method.name + " " + method.desc);
                    this.printBytecode(method.instructions);
                    // TraceMethodVisitor tv = new TraceMethodVisitor();
                    // method.accept(tv);
                    // tv.print(new PrintWriter(new OutputStreamWriter(System.out)));
                    throw new RuntimeException(e);
                }
            }
            
            // for debugging purposes, the result can be written to disk
            // FileOutputStream fos = new FileOutputStream(className.replace('/', '.') + ".class");
            // fos.write(writer.toByteArray());
            // fos.close();
            
            return writer.toByteArray();
        } catch (final Throwable t) {
            t.printStackTrace();
            throw new RuntimeException(t);
        }
    }
    
    private boolean isExcludedFromTransformation(String className) {
        return className.startsWith("org/alia4j/") || className.startsWith("java/") || className.startsWith("sun/")
                        || className.startsWith("org/apache/") || className.startsWith("javax/")
                        || className.startsWith("org/dom4j/") || className.startsWith("com/sun/")
                        || className.startsWith("org/eclipse/") || className.startsWith("org/junit/")
                        || className.startsWith("org/hamcrest/")
        // || className.startsWith("$Proxy")
        ;
    }
    
    private void printBytecode(InsnList instructions) {
        AbstractInsnNode current = instructions.getFirst();
        while (current != null) {
            System.out.print(instructions.indexOf(current) + "     ");
            if (current.getOpcode() >= 0)
                System.out.print(AbstractVisitor.OPCODES[current.getOpcode()]);
            else
                System.out.print(current.getOpcode());
            
            if (current.getType() == AbstractInsnNode.INT_INSN) {
                System.out.println(" " + ((IntInsnNode) current).operand);
            } else if (current.getType() == AbstractInsnNode.FIELD_INSN) {
                FieldInsnNode fieldCurrent = (FieldInsnNode) current;
                System.out.println(" " + fieldCurrent.owner + " " + fieldCurrent.name + " " + fieldCurrent.desc);
            } else if (current.getType() == AbstractInsnNode.METHOD_INSN) {
                MethodInsnNode methodCurrent = (MethodInsnNode) current;
                System.out.println(" " + methodCurrent.owner + " " + methodCurrent.name + " " + methodCurrent.desc);
            } else if (current.getType() == AbstractInsnNode.JUMP_INSN) {
                JumpInsnNode jumpCurrent = (JumpInsnNode) current;
                System.out.println(" " + jumpCurrent.label.getLabel());
            } else if (current.getType() == AbstractInsnNode.LABEL) {
                LabelNode labelCurrent = (LabelNode) current;
                System.out.println(" " + labelCurrent.getLabel());
            } else if (current.getType() == AbstractInsnNode.TYPE_INSN) {
                TypeInsnNode typeCurrent = (TypeInsnNode) current;
                System.out.println(" " + typeCurrent.desc);
            } else if (current.getType() == AbstractInsnNode.VAR_INSN) {
                VarInsnNode varCurrent = (VarInsnNode) current;
                System.out.println(" " + varCurrent.var);
            } else {
                System.out.println();
            }
            current = current.getNext();
        }
    }
    
    @SuppressWarnings("unchecked")
    private MethodNode createInvokeStaticMethodNode(final MethodNode method, final ClassNode declaringClass) {
        final String resultDescriptor =
                        "(L" + declaringClass.name + ";" + method.desc.substring(1, method.desc.indexOf(')'))
                                        + method.desc.substring(method.desc.indexOf(')'));
        final MethodNode result =
                        new MethodNode(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
                                        InterpreterCallbackInserter.getInvokeSpecialName(method.name), resultDescriptor,
                                        method.signature, (String[]) method.exceptions.toArray(new String[method.exceptions
                                                        .size()]));
        
        // receiver
        result.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
        // arguments
        final Type[] parameterTypes = Type.getArgumentTypes(method.desc);
        int index = 1;
        for (final Type type : parameterTypes) {
            result.instructions.add(new VarInsnNode(type.getOpcode(Opcodes.ILOAD), index));
            index += type.getSize();
        }
        
        result.instructions.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, declaringClass.name, method.name, method.desc));
        
        final Type returnType = Type.getReturnType(method.desc);
        result.instructions.add(new InsnNode(returnType.getOpcode(Opcodes.IRETURN)));
        
        return result;
    }
    
    public static String getInvokeSpecialName(final String originalName) {
        return InterpreterCallbackInserter.INVOKESPECIAL_PREFIX + originalName;
    }
    
    @SuppressWarnings("unchecked")
    private void createInterpreterCallback(final InsnList list, final GFCall call, final MethodNode methodNode,
                    final ClassNode classNode, final int currentLineNumber, final List<LabelNode> passedLabels,
                    Frame<BasicValue> frame) {
        final List<LocalVariableNode> applicableLocals = new ArrayList<LocalVariableNode>();
        final List<LocalVariableNode> localVariables = methodNode.localVariables;
        for (final LocalVariableNode lv : localVariables) {
            if (passedLabels.contains(lv.start) && !passedLabels.contains(lv.end))
                applicableLocals.add(lv);
        }
        
        final Type[] calledMethodArgumentTypes = Type.getArgumentTypes(call.descriptor);
        
        this.createArgumentsArray(list, call);
        this.possiblyCreateCallee(list, call);
        this.createLocalVariables(list, applicableLocals, frame);
        this.createCalleeClass(list, call);
        this.createCalleeName(list, call);
        this.createCalleeArgumentTypes(list, calledMethodArgumentTypes);
        this.createCalleeReturnType(list, call);
        this.createLocalVariableTypes(list, applicableLocals);
        this.createLocalVariableNames(list, applicableLocals);
        this.createLocalVariableIndexes(list, applicableLocals);
        this.createRawLocalVariables(list, frame);
        this.createLineNumber(list, currentLineNumber);
        this.createCallerClass(list, classNode);
        this.createCallerName(list, methodNode);
        this.createCallerArgumentTypes(list, methodNode);
        this.createCallerReturnType(list, methodNode);
        this.createCallerMethodModifiers(list, methodNode);
        this.createCallerSourceFile(list, classNode);
        this.createCallerThread(list);
        this.createCallOpcode(list, call);
        
        // now call the interpreter method
        final StringBuilder descriptor = new StringBuilder("(");
        descriptor.append("Ljava/lang/Object;");// Object callee,
        descriptor.append("[Ljava/lang/Object;");// Object[] arguments,
        descriptor.append("[Ljava/lang/Object;");// Object[] localVariables,
        descriptor.append("Ljava/lang/String;");// String declaringClassName,
        descriptor.append("Ljava/lang/String;");// String name,
        descriptor.append("[Ljava/lang/String;");// String[] argumentTypes,
        descriptor.append("Ljava/lang/String;");// String returnTypeName,
        descriptor.append("[Ljava/lang/String;");// String[] localVariableTypeNames,
        descriptor.append("[Ljava/lang/String;");// String[] localVariableNames,
        descriptor.append("[I");// int[] localVariableIndexes,
        descriptor.append("[Ljava/lang/Object;");// Object[] rawLocalVariables
        descriptor.append("I");// int lineNumber,
        descriptor.append("Ljava/lang/Class;");// String callingClass,
        descriptor.append("Ljava/lang/String;");// String callingMethodName,
        descriptor.append("[Ljava/lang/String;");// String[] callingMethodArgumentTypeNames,
        descriptor.append("Ljava/lang/String;");// String callingMethodReturnTypeName,
        descriptor.append("I");// int callingMethodModifiers
        descriptor.append("Ljava/lang/String;");// String callingFileName,
        descriptor.append("Ljava/lang/Thread;");// Thread thread)
        descriptor.append("I");// int callOpcode
        descriptor.append(")Ljava/lang/Object;");
        
        list.add(new MethodInsnNode(Opcodes.INVOKESTATIC, Interpreter.class.getName().replace('.', '/'), "callSite",
                        descriptor.toString()));
        this.possiblyUnboxCastOrPop(list, Type.getReturnType(call.descriptor), call);
    }
    
    private void createCallerMethodModifiers(final InsnList list, final MethodNode methodNode) {
        list.add(new LdcInsnNode(methodNode.access));
    }
    
    private void createCallOpcode(final InsnList list, final GFCall call) {
        list.add(new LdcInsnNode(call.opcode));
    }
    
    private void createCallerThread(final InsnList list) {
        list.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "java/lang/Thread", "currentThread", "()Ljava/lang/Thread;"));
    }
    
    private void createCallerSourceFile(final InsnList list, final ClassNode classNode) {
        list.add(classNode.sourceFile == null ? new InsnNode(Opcodes.ACONST_NULL) : new LdcInsnNode(classNode.sourceFile));
    }
    
    private void createCallerReturnType(final InsnList list, final MethodNode methodNode) {
        list.add(new LdcInsnNode(Type.getReturnType(methodNode.desc).getDescriptor()));
    }
    
    private void createCallerArgumentTypes(final InsnList list, final MethodNode methodNode) {
        final Type[] callingMethodArgumentTypes = Type.getArgumentTypes(methodNode.desc);
        this.createCalleeArgumentTypes(list, callingMethodArgumentTypes);
    }
    
    private void createCallerName(final InsnList list, final MethodNode methodNode) {
        list.add(new LdcInsnNode(methodNode.name));
    }
    
    private void createCallerClass(final InsnList list, final ClassNode classNode) {
        list.add(new LdcInsnNode(classNode.name.replace('/', '.')));
        list.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "java/lang/Class", "forName",
                        "(Ljava/lang/String;)Ljava/lang/Class;"));
    }
    
    private void createLineNumber(final InsnList list, final int currentLineNumber) {
        list.add(new LdcInsnNode(currentLineNumber));
    }
    
    private void createLocalVariableNames(final InsnList list, final List<LocalVariableNode> applicableLocals) {
        // see comment on local variables in createLocalVariables
        list.add(new LdcInsnNode(applicableLocals.size()));
        list.add(new TypeInsnNode(Opcodes.ANEWARRAY, Type.getInternalName(String.class)));
        for (int i = 0; i < applicableLocals.size(); i++) {
            final LocalVariableNode local = applicableLocals.get(i);
            list.add(new InsnNode(Opcodes.DUP));
            this.createLineNumber(list, i);
            list.add(new LdcInsnNode(local.name));
            list.add(new InsnNode(Opcodes.AASTORE));
        }
    }
    
    private void createLocalVariableTypes(final InsnList list, final List<LocalVariableNode> applicableLocals) {
        // see comment on local variables in createLocalVariables
        list.add(new LdcInsnNode(applicableLocals.size()));
        list.add(new TypeInsnNode(Opcodes.ANEWARRAY, Type.getInternalName(String.class)));
        for (int i = 0; i < applicableLocals.size(); i++) {
            final LocalVariableNode local = applicableLocals.get(i);
            list.add(new InsnNode(Opcodes.DUP));
            this.createLineNumber(list, i);
            list.add(new LdcInsnNode(local.desc));
            list.add(new InsnNode(Opcodes.AASTORE));
        }
    }
    
    private void createLocalVariableIndexes(final InsnList list, final List<LocalVariableNode> applicableLocals) {
        // see comment on local variables in createLocalVariables
        list.add(new LdcInsnNode(applicableLocals.size()));
        list.add(new IntInsnNode(Opcodes.NEWARRAY, Opcodes.T_INT));
        for (int i = 0; i < applicableLocals.size(); i++) {
            final LocalVariableNode local = applicableLocals.get(i);
            list.add(new InsnNode(Opcodes.DUP));
            this.createLineNumber(list, i);
            list.add(new LdcInsnNode(local.index));
            list.add(new InsnNode(Opcodes.IASTORE));
        }
    }
    
    private void createCalleeReturnType(final InsnList list, final GFCall call) {
        list.add(new LdcInsnNode(Type.getReturnType(call.descriptor).getDescriptor()));
    }
    
    private void createCalleeArgumentTypes(final InsnList list, final Type[] calledMethodArgumentTypes) {
        list.add(new LdcInsnNode(calledMethodArgumentTypes.length));
        list.add(new TypeInsnNode(Opcodes.ANEWARRAY, Type.getInternalName(String.class)));
        for (int i = 0; i < calledMethodArgumentTypes.length; i++) {
            list.add(new InsnNode(Opcodes.DUP));
            this.createLineNumber(list, i);
            list.add(new LdcInsnNode(calledMethodArgumentTypes[i].getDescriptor()));
            list.add(new InsnNode(Opcodes.AASTORE));
        }
    }
    
    private void createCalleeName(final InsnList list, final GFCall call) {
        list.add(new LdcInsnNode(call.name));
    }
    
    private void createCalleeClass(final InsnList list, final GFCall call) {
        list.add(new LdcInsnNode(Type.getObjectType(call.declaringClassInternalName).getDescriptor()));
    }
    
    private void createLocalVariables(final InsnList list, final List<LocalVariableNode> applicableLocals,
                    Frame<BasicValue> frame) {
        // if applicable local variables is empty
        // either the method does not contain local variables or it was compiled
        // without debugging support, i.e., without local-variables-table attribute
        list.add(new LdcInsnNode(applicableLocals.size()));
        list.add(new TypeInsnNode(Opcodes.ANEWARRAY, Type.getInternalName(Object.class)));
        for (int i = 0; i < applicableLocals.size(); i++) {
            final LocalVariableNode local = applicableLocals.get(i);
            final BasicValue localValue = frame.getLocal(local.index);
            
            list.add(new InsnNode(Opcodes.DUP));
            this.createLineNumber(list, i);
            
            if (localValue.valueKind == ValueKind.UNINITIALIZED_SLOT) {
                list.add(new FieldInsnNode(Opcodes.GETSTATIC, InterpreterCallbackInserter.INTERPRETER_CONSTANTS_TYPE
                                .getInternalName(), InterpreterCallbackInserter.LOCAL_SLOT_UNINITIALIZED_FIELD,
                                InterpreterCallbackInserter.OBJECT_TYPE.getDescriptor()));
            } else if (localValue.valueKind == ValueKind.RETURN_ADDRESS) {
                list.add(new FieldInsnNode(Opcodes.GETSTATIC, InterpreterCallbackInserter.INTERPRETER_CONSTANTS_TYPE
                                .getInternalName(), InterpreterCallbackInserter.LOCAL_SLOT_RETURN_ADDRESS_FIELD,
                                InterpreterCallbackInserter.OBJECT_TYPE.getDescriptor()));
            } else if (localValue.valueKind == ValueKind.UNINITIALIZED_THIS) {
                list.add(new FieldInsnNode(Opcodes.GETSTATIC, InterpreterCallbackInserter.INTERPRETER_CONSTANTS_TYPE
                                .getInternalName(), InterpreterCallbackInserter.UNINITIALIZED_THIS_FIELD,
                                InterpreterCallbackInserter.OBJECT_TYPE.getDescriptor()));
            } else {
                final Type localType = Type.getType(local.desc);
                list.add(new VarInsnNode(localType.getOpcode(Opcodes.ILOAD), local.index));
                this.possiblyWrapTopStackItem(list, localType);
            }
            
            list.add(new InsnNode(Opcodes.AASTORE));
        }
    }
    
    private void createRawLocalVariables(final InsnList list, final Frame<BasicValue> frame) {
        // if applicable local variables is empty
        // either the method does not contain local variables or it was compiled
        // without debugging support, i.e., without local-variables-table attribute
        list.add(new LdcInsnNode(frame.getLocals()));
        list.add(new TypeInsnNode(Opcodes.ANEWARRAY, Type.getInternalName(Object.class)));
        for (int i = 0; i < frame.getLocals(); i++) {
            final BasicValue localValue = frame.getLocal(i);
            list.add(new InsnNode(Opcodes.DUP));
            this.createLineNumber(list, i);
            if (localValue.valueKind == ValueKind.UNINITIALIZED_SLOT) {
                list.add(new FieldInsnNode(Opcodes.GETSTATIC, InterpreterCallbackInserter.INTERPRETER_CONSTANTS_TYPE
                                .getInternalName(), InterpreterCallbackInserter.LOCAL_SLOT_UNINITIALIZED_FIELD,
                                InterpreterCallbackInserter.OBJECT_TYPE.getDescriptor()));
            } else if (localValue.valueKind == ValueKind.RETURN_ADDRESS) {
                list.add(new FieldInsnNode(Opcodes.GETSTATIC, InterpreterCallbackInserter.INTERPRETER_CONSTANTS_TYPE
                                .getInternalName(), InterpreterCallbackInserter.LOCAL_SLOT_RETURN_ADDRESS_FIELD,
                                InterpreterCallbackInserter.OBJECT_TYPE.getDescriptor()));
            } else if (localValue.valueKind == ValueKind.UNINITIALIZED_THIS) {
                list.add(new FieldInsnNode(Opcodes.GETSTATIC, InterpreterCallbackInserter.INTERPRETER_CONSTANTS_TYPE
                                .getInternalName(), InterpreterCallbackInserter.UNINITIALIZED_THIS_FIELD,
                                InterpreterCallbackInserter.OBJECT_TYPE.getDescriptor()));
            } else {
                final Type localType = localValue.type;
                list.add(new VarInsnNode(localType.getOpcode(Opcodes.ILOAD), i));
                this.possiblyWrapTopStackItem(list, localType);
            }
            list.add(new InsnNode(Opcodes.AASTORE));
        }
    }
    
    /**
     * If the called method is static, we have to push "null" below the array of argument objects. Otherwise, the callee
     * already is on the stack. This method assumes that the top element on the stack is the arguments array.
     * 
     * @param list
     * @param call
     * @param calleeValue
     */
    private void possiblyCreateCallee(final InsnList list, final GFCall call) {
        if (call.opcode == Opcodes.INVOKESTATIC || call.opcode == Opcodes.GETSTATIC || call.opcode == Opcodes.PUTSTATIC
                        || (call.opcode == Opcodes.INVOKESPECIAL && call.name.equals("<init>"))) {
            list.add(new InsnNode(Opcodes.ACONST_NULL));
            list.add(new InsnNode(Opcodes.DUP_X1));
            list.add(new InsnNode(Opcodes.POP));
        }
    }
    
    /**
     * Create an array of the (possibly boxed) argument values. Assumes that the arguments are on the top of the stack.
     * 
     * @param list
     * @param call
     * @return
     */
    private void createArgumentsArray(final InsnList list, final GFCall call) {
        final Type[] calledMethodArgumentTypes = Type.getArgumentTypes(call.descriptor);
        list.add(new LdcInsnNode(calledMethodArgumentTypes.length));
        list.add(new TypeInsnNode(Opcodes.ANEWARRAY, Type.getInternalName(Object.class)));
        for (int i = calledMethodArgumentTypes.length - 1; i >= 0; i--) {
            // push the array object below the top stack item
            // therefore use duplicate and insert below (i.e., dup_x1 or dup_x2 depending on the value type)
            // and afterward pop the array object of which a duplicate now exists below the top stack item
            // we have to do this twice because the array reference is popped from the stack when a value is stored in it
            if (calledMethodArgumentTypes[i].getSize() == 1) {
                list.add(new InsnNode(Opcodes.DUP_X1));
                list.add(new InsnNode(Opcodes.DUP_X1));
            } else if (calledMethodArgumentTypes[i].getSize() == 2) {
                list.add(new InsnNode(Opcodes.DUP_X2));
                list.add(new InsnNode(Opcodes.DUP_X2));
            } else {
                throw new UnsupportedOperationException();
            }
            list.add(new InsnNode(Opcodes.POP));
            this.createLineNumber(list, i);
            if (calledMethodArgumentTypes[i].getSize() == 1) {
                list.add(new InsnNode(Opcodes.DUP_X1));
            } else if (calledMethodArgumentTypes[i].getSize() == 2) {
                list.add(new InsnNode(Opcodes.DUP_X2));
            }
            list.add(new InsnNode(Opcodes.POP));
            this.possiblyWrapTopStackItem(list, calledMethodArgumentTypes[i]);
            list.add(new InsnNode(Opcodes.AASTORE));
        }
    }
    
    private void possiblyUnboxCastOrPop(final InsnList list, final Type type, GFCall call) {
        String castTarget;
        String unboxClass = null;
        String unboxMethod = null;
        String unboxDescriptor = null;
        if (call.name.equals("<init>")) {
            castTarget = call.declaringClassInternalName;
        } else if (type.getSort() == Type.VOID) {
            list.add(new InsnNode(Opcodes.POP));
            return;
        } else if (type.getSort() == Type.BOOLEAN) {
            castTarget = Type.getType(Boolean.class).getInternalName();
            unboxClass = castTarget;
            unboxMethod = "booleanValue";
            unboxDescriptor = "()Z";
        } else if (type.getSort() == Type.CHAR) {
            castTarget = Type.getType(Character.class).getInternalName();
            unboxClass = castTarget;
            unboxMethod = "charValue";
            unboxDescriptor = "()C";
        } else if (type.getSort() == Type.BYTE) {
            castTarget = Type.getType(Byte.class).getInternalName();
            unboxClass = castTarget;
            unboxMethod = "byteValue";
            unboxDescriptor = "()B";
        } else if (type.getSort() == Type.SHORT) {
            castTarget = Type.getType(Short.class).getInternalName();
            unboxClass = castTarget;
            unboxMethod = "shortValue";
            unboxDescriptor = "()S";
        } else if (type.getSort() == Type.INT) {
            castTarget = Type.getType(Integer.class).getInternalName();
            unboxClass = castTarget;
            unboxMethod = "intValue";
            unboxDescriptor = "()I";
        } else if (type.getSort() == Type.LONG) {
            castTarget = Type.getType(Long.class).getInternalName();
            unboxClass = castTarget;
            unboxMethod = "longValue";
            unboxDescriptor = "()J";
        } else if (type.getSort() == Type.FLOAT) {
            castTarget = Type.getType(Float.class).getInternalName();
            unboxClass = castTarget;
            unboxMethod = "floatValue";
            unboxDescriptor = "()F";
        } else if (type.getSort() == Type.DOUBLE) {
            castTarget = Type.getType(Double.class).getInternalName();
            unboxClass = castTarget;
            unboxMethod = "doubleValue";
            unboxDescriptor = "()D";
        } else {
            castTarget = type.getInternalName();
        }
        list.add(new TypeInsnNode(Opcodes.CHECKCAST, castTarget));
        if (unboxClass != null) {
            list.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, unboxClass, unboxMethod, unboxDescriptor));
        }
    }
    
    private void possiblyWrapTopStackItem(final InsnList list, final Type type) {
        Class<?> wrapperClass;
        Class<?> primitiveType;
        if (type.getSort() == Type.BOOLEAN) {
            wrapperClass = Boolean.class;
            primitiveType = Boolean.TYPE;
        } else if (type.getSort() == Type.CHAR) {
            wrapperClass = Character.class;
            primitiveType = Character.TYPE;
        } else if (type.getSort() == Type.BYTE) {
            wrapperClass = Byte.class;
            primitiveType = Byte.TYPE;
        } else if (type.getSort() == Type.SHORT) {
            wrapperClass = Short.class;
            primitiveType = Short.TYPE;
        } else if (type.getSort() == Type.INT) {
            wrapperClass = Integer.class;
            primitiveType = Integer.TYPE;
        } else if (type.getSort() == Type.LONG) {
            wrapperClass = Long.class;
            primitiveType = Long.TYPE;
        } else if (type.getSort() == Type.FLOAT) {
            wrapperClass = Float.class;
            primitiveType = Float.TYPE;
        } else if (type.getSort() == Type.DOUBLE) {
            wrapperClass = Double.class;
            primitiveType = Double.TYPE;
        } else {
            return;
        }
        list.add(new MethodInsnNode(Opcodes.INVOKESTATIC, Type.getInternalName(wrapperClass), "valueOf", Type
                        .getMethodDescriptor(Type.getType(wrapperClass), new Type[] { Type.getType(primitiveType) })));
    }
    
}
