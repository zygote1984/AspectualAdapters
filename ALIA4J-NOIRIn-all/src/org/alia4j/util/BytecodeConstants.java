package org.alia4j.util;

import java.lang.reflect.Modifier;

public abstract class BytecodeConstants {
    
    private static final int SIZE_UNUSED = -253;
    
    private static final int SIZE_LOOKUPSWITCH = -255;
    
    private static final int SIZE_TABLESWITCH = -254;
    
    public static final int SIZE_DEPEND_ON_WIDE = -1;
    
    public final static int[] normalInstructionLengths = new int[] { 1, // nop
                    1, // aconst_null
                    1, // iconst_m1
                    1, // iconst_0
                    1, // iconst_1
                    1, // iconst_2
                    1, // iconst_3
                    1, // iconst_4
                    1, // iconst_5
                    1, // lconst_0
                    1, // lconst_1
                    1, // fconst_0
                    1, // fconst_1
                    1, // fconst_2
                    1, // dconst_0
                    1, // dconst_1
                    2, // bipush
                    3, // sipush
                    2, // ldc
                    3, // ldc_w
                    3, // ldc2_w
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // iload
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // lload
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // fload
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // dload
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // aload
                    1, // iload_0
                    1, // iload_1
                    1, // iload_2
                    1, // iload_3
                    1, // lload_0
                    1, // lload_1
                    1, // lload_2
                    1, // lload_3
                    1, // fload_0
                    1, // fload_1
                    1, // fload_2
                    1, // fload_3
                    1, // dload_0
                    1, // dload_1
                    1, // dload_2
                    1, // dload_3
                    1, // aload_0
                    1, // aload_1
                    1, // aload_2
                    1, // aload_3
                    1, // iaload
                    1, // laload
                    1, // faload
                    1, // daload
                    1, // aaload
                    1, // baload
                    1, // caload
                    1, // saload
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // istore
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // lstore
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // fstore
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // dstore
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // astore
                    1, // istore_0
                    1, // istore_1
                    1, // istore_2
                    1, // istore_3
                    1, // lstore_0
                    1, // lstore_1
                    1, // lstore_2
                    1, // lstore_3
                    1, // fstore_0
                    1, // fstore_1
                    1, // fstore_2
                    1, // fstore_3
                    1, // dstore_0
                    1, // dstore_1
                    1, // dstore_2
                    1, // dstore_3
                    1, // astore_0
                    1, // astore_1
                    1, // astore_2
                    1, // astore_3
                    1, // iastore
                    1, // lastore
                    1, // fastore
                    1, // dastore
                    1, // aastore
                    1, // bastore
                    1, // castore
                    1, // sastore
                    1, // pop
                    1, // pop2
                    1, // dup
                    1, // dup_x1
                    1, // dup_x2
                    1, // dup2
                    1, // dup2_x1
                    1, // dup2_x2
                    1, // swap
                    1, // iadd
                    1, // ladd
                    1, // fadd
                    1, // dadd
                    1, // isub
                    1, // lsub
                    1, // fsub
                    1, // dsub
                    1, // imul
                    1, // lmul
                    1, // fmul
                    1, // dmul
                    1, // idiv
                    1, // ldiv
                    1, // fdiv
                    1, // ddiv
                    1, // irem
                    1, // lrem
                    1, // frem
                    1, // drem
                    1, // ineg
                    1, // lneg
                    1, // fneg
                    1, // dneg
                    1, // ishl
                    1, // lshl
                    1, // ishr
                    1, // lshr
                    1, // iushr
                    1, // lushr
                    1, // iand
                    1, // land
                    1, // ior
                    1, // lor
                    1, // ixor
                    1, // lxor
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // iinc
                    1, // i2l
                    1, // i2f
                    1, // i2d
                    1, // l2i
                    1, // l2f
                    1, // l2d
                    1, // f2i
                    1, // f2l
                    1, // f2d
                    1, // d2i
                    1, // d2l
                    1, // d2f
                    1, // i2b
                    1, // i2c
                    1, // i2s
                    1, // lcmp
                    1, // fcmpl
                    1, // fcmpg
                    1, // dcmpl
                    1, // dcmpg
                    3, // ifeq
                    3, // ifne
                    3, // iflt
                    3, // ifge
                    3, // ifgt
                    3, // ifle
                    3, // if_icmpeq
                    3, // if_icmpne
                    3, // if_icmplt
                    3, // if_icmpge
                    3, // if_icmpgt
                    3, // if_icmple
                    3, // if_acmpeq
                    3, // if_acmpne
                    3, // goto
                    3, // jsr
                    BytecodeConstants.SIZE_DEPEND_ON_WIDE, // ret
                    BytecodeConstants.SIZE_TABLESWITCH, // tableswitch
                    BytecodeConstants.SIZE_LOOKUPSWITCH, // lookupswitch
                    1, // ireturn
                    1, // lreturn
                    1, // freturn
                    1, // dreturn
                    1, // areturn
                    1, // return
                    3, // getstatic
                    3, // putstatic
                    3, // getfield
                    3, // putfield
                    3, // invokevirtual
                    3, // invokespecial
                    3, // invokestatic
                    5, // invokeinterface
                    BytecodeConstants.SIZE_UNUSED, // xxxunusedxxx
                    3, // new
                    2, // newarray
                    3, // anewarray
                    1, // arraylength
                    1, // athrow
                    3, // checkcast
                    3, // instanceof
                    1, // monitorenter
                    1, // monitorexit
                    1, // wide
                    4, // multianewarray
                    3, // ifnull
                    3, // ifnonnull
                    5, // goto_w
                    5, // jsr_w
                    1 }; // breakpoint
    
    public final static int[] localsInstructionNoWideLengths = new int[] { BytecodeConstants.SIZE_UNUSED, // nop
                    BytecodeConstants.SIZE_UNUSED, // aconst_null
                    BytecodeConstants.SIZE_UNUSED, // iconst_mSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // bipush
                    BytecodeConstants.SIZE_UNUSED, // sipush
                    BytecodeConstants.SIZE_UNUSED, // ldc
                    BytecodeConstants.SIZE_UNUSED, // ldc_w
                    BytecodeConstants.SIZE_UNUSED, // ldcSIZE_UNUSED_w
                    2, // iload
                    2, // lload
                    2, // fload
                    2, // dload
                    2, // aload
                    BytecodeConstants.SIZE_UNUSED, // iload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // aload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // aload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // aload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // aload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iaload
                    BytecodeConstants.SIZE_UNUSED, // laload
                    BytecodeConstants.SIZE_UNUSED, // faload
                    BytecodeConstants.SIZE_UNUSED, // daload
                    BytecodeConstants.SIZE_UNUSED, // aaload
                    BytecodeConstants.SIZE_UNUSED, // baload
                    BytecodeConstants.SIZE_UNUSED, // caload
                    BytecodeConstants.SIZE_UNUSED, // saload
                    2, // istore
                    2, // lstore
                    2, // fstore
                    2, // dstore
                    2, // astore
                    BytecodeConstants.SIZE_UNUSED, // istore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // istore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // istore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // istore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // astore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // astore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // astore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // astore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iastore
                    BytecodeConstants.SIZE_UNUSED, // lastore
                    BytecodeConstants.SIZE_UNUSED, // fastore
                    BytecodeConstants.SIZE_UNUSED, // dastore
                    BytecodeConstants.SIZE_UNUSED, // aastore
                    BytecodeConstants.SIZE_UNUSED, // bastore
                    BytecodeConstants.SIZE_UNUSED, // castore
                    BytecodeConstants.SIZE_UNUSED, // sastore
                    BytecodeConstants.SIZE_UNUSED, // pop
                    BytecodeConstants.SIZE_UNUSED, // popSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dup
                    BytecodeConstants.SIZE_UNUSED, // dup_xSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dup_xSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dupSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dupSIZE_UNUSED_xSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dupSIZE_UNUSED_xSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // swap
                    BytecodeConstants.SIZE_UNUSED, // iadd
                    BytecodeConstants.SIZE_UNUSED, // ladd
                    BytecodeConstants.SIZE_UNUSED, // fadd
                    BytecodeConstants.SIZE_UNUSED, // dadd
                    BytecodeConstants.SIZE_UNUSED, // isub
                    BytecodeConstants.SIZE_UNUSED, // lsub
                    BytecodeConstants.SIZE_UNUSED, // fsub
                    BytecodeConstants.SIZE_UNUSED, // dsub
                    BytecodeConstants.SIZE_UNUSED, // imul
                    BytecodeConstants.SIZE_UNUSED, // lmul
                    BytecodeConstants.SIZE_UNUSED, // fmul
                    BytecodeConstants.SIZE_UNUSED, // dmul
                    BytecodeConstants.SIZE_UNUSED, // idiv
                    BytecodeConstants.SIZE_UNUSED, // ldiv
                    BytecodeConstants.SIZE_UNUSED, // fdiv
                    BytecodeConstants.SIZE_UNUSED, // ddiv
                    BytecodeConstants.SIZE_UNUSED, // irem
                    BytecodeConstants.SIZE_UNUSED, // lrem
                    BytecodeConstants.SIZE_UNUSED, // frem
                    BytecodeConstants.SIZE_UNUSED, // drem
                    BytecodeConstants.SIZE_UNUSED, // ineg
                    BytecodeConstants.SIZE_UNUSED, // lneg
                    BytecodeConstants.SIZE_UNUSED, // fneg
                    BytecodeConstants.SIZE_UNUSED, // dneg
                    BytecodeConstants.SIZE_UNUSED, // ishl
                    BytecodeConstants.SIZE_UNUSED, // lshl
                    BytecodeConstants.SIZE_UNUSED, // ishr
                    BytecodeConstants.SIZE_UNUSED, // lshr
                    BytecodeConstants.SIZE_UNUSED, // iushr
                    BytecodeConstants.SIZE_UNUSED, // lushr
                    BytecodeConstants.SIZE_UNUSED, // iand
                    BytecodeConstants.SIZE_UNUSED, // land
                    BytecodeConstants.SIZE_UNUSED, // ior
                    BytecodeConstants.SIZE_UNUSED, // lor
                    BytecodeConstants.SIZE_UNUSED, // ixor
                    BytecodeConstants.SIZE_UNUSED, // lxor
                    3, // iinc
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDl
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDf
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDd
                    BytecodeConstants.SIZE_UNUSED, // lSIZE_UNUSEDi
                    BytecodeConstants.SIZE_UNUSED, // lSIZE_UNUSEDf
                    BytecodeConstants.SIZE_UNUSED, // lSIZE_UNUSEDd
                    BytecodeConstants.SIZE_UNUSED, // fSIZE_UNUSEDi
                    BytecodeConstants.SIZE_UNUSED, // fSIZE_UNUSEDl
                    BytecodeConstants.SIZE_UNUSED, // fSIZE_UNUSEDd
                    BytecodeConstants.SIZE_UNUSED, // dSIZE_UNUSEDi
                    BytecodeConstants.SIZE_UNUSED, // dSIZE_UNUSEDl
                    BytecodeConstants.SIZE_UNUSED, // dSIZE_UNUSEDf
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDb
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDc
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDs
                    BytecodeConstants.SIZE_UNUSED, // lcmp
                    BytecodeConstants.SIZE_UNUSED, // fcmpl
                    BytecodeConstants.SIZE_UNUSED, // fcmpg
                    BytecodeConstants.SIZE_UNUSED, // dcmpl
                    BytecodeConstants.SIZE_UNUSED, // dcmpg
                    BytecodeConstants.SIZE_UNUSED, // ifeq
                    BytecodeConstants.SIZE_UNUSED, // ifne
                    BytecodeConstants.SIZE_UNUSED, // iflt
                    BytecodeConstants.SIZE_UNUSED, // ifge
                    BytecodeConstants.SIZE_UNUSED, // ifgt
                    BytecodeConstants.SIZE_UNUSED, // ifle
                    BytecodeConstants.SIZE_UNUSED, // if_icmpeq
                    BytecodeConstants.SIZE_UNUSED, // if_icmpne
                    BytecodeConstants.SIZE_UNUSED, // if_icmplt
                    BytecodeConstants.SIZE_UNUSED, // if_icmpge
                    BytecodeConstants.SIZE_UNUSED, // if_icmpgt
                    BytecodeConstants.SIZE_UNUSED, // if_icmple
                    BytecodeConstants.SIZE_UNUSED, // if_acmpeq
                    BytecodeConstants.SIZE_UNUSED, // if_acmpne
                    BytecodeConstants.SIZE_UNUSED, // goto
                    BytecodeConstants.SIZE_UNUSED, // jsr
                    2, // ret
                    BytecodeConstants.SIZE_UNUSED, // tableswitch
                    BytecodeConstants.SIZE_UNUSED, // lookupswitch
                    BytecodeConstants.SIZE_UNUSED, // ireturn
                    BytecodeConstants.SIZE_UNUSED, // lreturn
                    BytecodeConstants.SIZE_UNUSED, // freturn
                    BytecodeConstants.SIZE_UNUSED, // dreturn
                    BytecodeConstants.SIZE_UNUSED, // areturn
                    BytecodeConstants.SIZE_UNUSED, // return
                    BytecodeConstants.SIZE_UNUSED, // getstatic
                    BytecodeConstants.SIZE_UNUSED, // putstatic
                    BytecodeConstants.SIZE_UNUSED, // getfield
                    BytecodeConstants.SIZE_UNUSED, // putfield
                    BytecodeConstants.SIZE_UNUSED, // invokevirtual
                    BytecodeConstants.SIZE_UNUSED, // invokespecial
                    BytecodeConstants.SIZE_UNUSED, // invokestatic
                    BytecodeConstants.SIZE_UNUSED, // invokeinterface
                    BytecodeConstants.SIZE_UNUSED, // xxxunusedxxx
                    BytecodeConstants.SIZE_UNUSED, // new
                    BytecodeConstants.SIZE_UNUSED, // newarray
                    BytecodeConstants.SIZE_UNUSED, // anewarray
                    BytecodeConstants.SIZE_UNUSED, // arraylength
                    BytecodeConstants.SIZE_UNUSED, // athrow
                    BytecodeConstants.SIZE_UNUSED, // checkcast
                    BytecodeConstants.SIZE_UNUSED, // instanceof
                    BytecodeConstants.SIZE_UNUSED, // monitorenter
                    BytecodeConstants.SIZE_UNUSED, // monitorexit
                    BytecodeConstants.SIZE_UNUSED, // wide
                    BytecodeConstants.SIZE_UNUSED, // multianewarray
                    BytecodeConstants.SIZE_UNUSED, // ifnull
                    BytecodeConstants.SIZE_UNUSED, // ifnonnull
                    BytecodeConstants.SIZE_UNUSED, // goto_w
                    BytecodeConstants.SIZE_UNUSED, // jsr_w
                    BytecodeConstants.SIZE_UNUSED }; // breakpoint
    
    public final static int[] localsInstructionWideLengths = new int[] { BytecodeConstants.SIZE_UNUSED, // nop
                    BytecodeConstants.SIZE_UNUSED, // aconst_null
                    BytecodeConstants.SIZE_UNUSED, // iconst_mSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dconst_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // bipush
                    BytecodeConstants.SIZE_UNUSED, // sipush
                    BytecodeConstants.SIZE_UNUSED, // ldc
                    BytecodeConstants.SIZE_UNUSED, // ldc_w
                    BytecodeConstants.SIZE_UNUSED, // ldcSIZE_UNUSED_w
                    3, // iload
                    3, // lload
                    3, // fload
                    3, // dload
                    3, // aload
                    BytecodeConstants.SIZE_UNUSED, // iload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // aload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // aload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // aload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // aload_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iaload
                    BytecodeConstants.SIZE_UNUSED, // laload
                    BytecodeConstants.SIZE_UNUSED, // faload
                    BytecodeConstants.SIZE_UNUSED, // daload
                    BytecodeConstants.SIZE_UNUSED, // aaload
                    BytecodeConstants.SIZE_UNUSED, // baload
                    BytecodeConstants.SIZE_UNUSED, // caload
                    BytecodeConstants.SIZE_UNUSED, // saload
                    3, // istore
                    3, // lstore
                    3, // fstore
                    3, // dstore
                    3, // astore
                    BytecodeConstants.SIZE_UNUSED, // istore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // istore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // istore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // istore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // lstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // fstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dstore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // astore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // astore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // astore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // astore_SIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // iastore
                    BytecodeConstants.SIZE_UNUSED, // lastore
                    BytecodeConstants.SIZE_UNUSED, // fastore
                    BytecodeConstants.SIZE_UNUSED, // dastore
                    BytecodeConstants.SIZE_UNUSED, // aastore
                    BytecodeConstants.SIZE_UNUSED, // bastore
                    BytecodeConstants.SIZE_UNUSED, // castore
                    BytecodeConstants.SIZE_UNUSED, // sastore
                    BytecodeConstants.SIZE_UNUSED, // pop
                    BytecodeConstants.SIZE_UNUSED, // popSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dup
                    BytecodeConstants.SIZE_UNUSED, // dup_xSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dup_xSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dupSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dupSIZE_UNUSED_xSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // dupSIZE_UNUSED_xSIZE_UNUSED
                    BytecodeConstants.SIZE_UNUSED, // swap
                    BytecodeConstants.SIZE_UNUSED, // iadd
                    BytecodeConstants.SIZE_UNUSED, // ladd
                    BytecodeConstants.SIZE_UNUSED, // fadd
                    BytecodeConstants.SIZE_UNUSED, // dadd
                    BytecodeConstants.SIZE_UNUSED, // isub
                    BytecodeConstants.SIZE_UNUSED, // lsub
                    BytecodeConstants.SIZE_UNUSED, // fsub
                    BytecodeConstants.SIZE_UNUSED, // dsub
                    BytecodeConstants.SIZE_UNUSED, // imul
                    BytecodeConstants.SIZE_UNUSED, // lmul
                    BytecodeConstants.SIZE_UNUSED, // fmul
                    BytecodeConstants.SIZE_UNUSED, // dmul
                    BytecodeConstants.SIZE_UNUSED, // idiv
                    BytecodeConstants.SIZE_UNUSED, // ldiv
                    BytecodeConstants.SIZE_UNUSED, // fdiv
                    BytecodeConstants.SIZE_UNUSED, // ddiv
                    BytecodeConstants.SIZE_UNUSED, // irem
                    BytecodeConstants.SIZE_UNUSED, // lrem
                    BytecodeConstants.SIZE_UNUSED, // frem
                    BytecodeConstants.SIZE_UNUSED, // drem
                    BytecodeConstants.SIZE_UNUSED, // ineg
                    BytecodeConstants.SIZE_UNUSED, // lneg
                    BytecodeConstants.SIZE_UNUSED, // fneg
                    BytecodeConstants.SIZE_UNUSED, // dneg
                    BytecodeConstants.SIZE_UNUSED, // ishl
                    BytecodeConstants.SIZE_UNUSED, // lshl
                    BytecodeConstants.SIZE_UNUSED, // ishr
                    BytecodeConstants.SIZE_UNUSED, // lshr
                    BytecodeConstants.SIZE_UNUSED, // iushr
                    BytecodeConstants.SIZE_UNUSED, // lushr
                    BytecodeConstants.SIZE_UNUSED, // iand
                    BytecodeConstants.SIZE_UNUSED, // land
                    BytecodeConstants.SIZE_UNUSED, // ior
                    BytecodeConstants.SIZE_UNUSED, // lor
                    BytecodeConstants.SIZE_UNUSED, // ixor
                    BytecodeConstants.SIZE_UNUSED, // lxor
                    5, // iinc
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDl
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDf
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDd
                    BytecodeConstants.SIZE_UNUSED, // lSIZE_UNUSEDi
                    BytecodeConstants.SIZE_UNUSED, // lSIZE_UNUSEDf
                    BytecodeConstants.SIZE_UNUSED, // lSIZE_UNUSEDd
                    BytecodeConstants.SIZE_UNUSED, // fSIZE_UNUSEDi
                    BytecodeConstants.SIZE_UNUSED, // fSIZE_UNUSEDl
                    BytecodeConstants.SIZE_UNUSED, // fSIZE_UNUSEDd
                    BytecodeConstants.SIZE_UNUSED, // dSIZE_UNUSEDi
                    BytecodeConstants.SIZE_UNUSED, // dSIZE_UNUSEDl
                    BytecodeConstants.SIZE_UNUSED, // dSIZE_UNUSEDf
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDb
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDc
                    BytecodeConstants.SIZE_UNUSED, // iSIZE_UNUSEDs
                    BytecodeConstants.SIZE_UNUSED, // lcmp
                    BytecodeConstants.SIZE_UNUSED, // fcmpl
                    BytecodeConstants.SIZE_UNUSED, // fcmpg
                    BytecodeConstants.SIZE_UNUSED, // dcmpl
                    BytecodeConstants.SIZE_UNUSED, // dcmpg
                    BytecodeConstants.SIZE_UNUSED, // ifeq
                    BytecodeConstants.SIZE_UNUSED, // ifne
                    BytecodeConstants.SIZE_UNUSED, // iflt
                    BytecodeConstants.SIZE_UNUSED, // ifge
                    BytecodeConstants.SIZE_UNUSED, // ifgt
                    BytecodeConstants.SIZE_UNUSED, // ifle
                    BytecodeConstants.SIZE_UNUSED, // if_icmpeq
                    BytecodeConstants.SIZE_UNUSED, // if_icmpne
                    BytecodeConstants.SIZE_UNUSED, // if_icmplt
                    BytecodeConstants.SIZE_UNUSED, // if_icmpge
                    BytecodeConstants.SIZE_UNUSED, // if_icmpgt
                    BytecodeConstants.SIZE_UNUSED, // if_icmple
                    BytecodeConstants.SIZE_UNUSED, // if_acmpeq
                    BytecodeConstants.SIZE_UNUSED, // if_acmpne
                    BytecodeConstants.SIZE_UNUSED, // goto
                    BytecodeConstants.SIZE_UNUSED, // jsr
                    3, // ret
                    BytecodeConstants.SIZE_UNUSED, // tableswitch
                    BytecodeConstants.SIZE_UNUSED, // lookupswitch
                    BytecodeConstants.SIZE_UNUSED, // ireturn
                    BytecodeConstants.SIZE_UNUSED, // lreturn
                    BytecodeConstants.SIZE_UNUSED, // freturn
                    BytecodeConstants.SIZE_UNUSED, // dreturn
                    BytecodeConstants.SIZE_UNUSED, // areturn
                    BytecodeConstants.SIZE_UNUSED, // return
                    BytecodeConstants.SIZE_UNUSED, // getstatic
                    BytecodeConstants.SIZE_UNUSED, // putstatic
                    BytecodeConstants.SIZE_UNUSED, // getfield
                    BytecodeConstants.SIZE_UNUSED, // putfield
                    BytecodeConstants.SIZE_UNUSED, // invokevirtual
                    BytecodeConstants.SIZE_UNUSED, // invokespecial
                    BytecodeConstants.SIZE_UNUSED, // invokestatic
                    BytecodeConstants.SIZE_UNUSED, // invokeinterface
                    BytecodeConstants.SIZE_UNUSED, // xxxunusedxxx
                    BytecodeConstants.SIZE_UNUSED, // new
                    BytecodeConstants.SIZE_UNUSED, // newarray
                    BytecodeConstants.SIZE_UNUSED, // anewarray
                    BytecodeConstants.SIZE_UNUSED, // arraylength
                    BytecodeConstants.SIZE_UNUSED, // athrow
                    BytecodeConstants.SIZE_UNUSED, // checkcast
                    BytecodeConstants.SIZE_UNUSED, // instanceof
                    BytecodeConstants.SIZE_UNUSED, // monitorenter
                    BytecodeConstants.SIZE_UNUSED, // monitorexit
                    BytecodeConstants.SIZE_UNUSED, // wide
                    BytecodeConstants.SIZE_UNUSED, // multianewarray
                    BytecodeConstants.SIZE_UNUSED, // ifnull
                    BytecodeConstants.SIZE_UNUSED, // ifnonnull
                    BytecodeConstants.SIZE_UNUSED, // goto_w
                    BytecodeConstants.SIZE_UNUSED, // jsr_w
                    BytecodeConstants.SIZE_UNUSED }; // breakpoint
    
    public static final int INSTRUCTION_KIND_DONT_CARE = 0;
    
    public static final int INSTRUCTION_KIND_CP_BYTE = 1;
    
    public static final int INSTRCUTION_KIND_CP_SHORT = 2;
    
    public static final int INSTRUCTION_KIND_LOCAL_GENERAL = 3;
    
    public static final int INSTRUCTION_KIND_LOCAL_SPECIAL = 4;
    
    public static final int INSTRUCTION_KIND_RETURN = 5;
    
    protected final static int[] instructionKinds = new int[] { BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // nop
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // aconst_null
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iconst_m1
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iconst_0
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dconst_INSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // bipush
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // sipush
                    BytecodeConstants.INSTRUCTION_KIND_CP_BYTE, // ldc
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // ldc_w
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // ldc2_w
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_GENERAL, // iload
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_GENERAL, // lload
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_GENERAL, // fload
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_GENERAL, // dload
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_GENERAL, // aload
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // iload_0
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // iload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // iload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // iload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // lload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // lload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // lload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // lload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // fload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // fload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // fload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // fload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // dload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // dload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // dload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // dload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // aload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // aload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // aload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // aload_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iaload
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // laload
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // faload
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // daload
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // aaload
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // baload
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // caload
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // saload
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_GENERAL, // istore
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_GENERAL, // lstore
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_GENERAL, // fstore
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_GENERAL, // dstore
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_GENERAL, // astore
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // istore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // istore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // istore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // istore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // lstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // lstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // lstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // lstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // fstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // fstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // fstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // fstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // dstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // dstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // dstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // dstore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // astore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // astore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // astore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_SPECIAL, // astore_INSTRUCTION_KIND_LOCAL_SPECIAL
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iastore
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lastore
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fastore
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dastore
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // aastore
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // bastore
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // castore
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // sastore
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // pop
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // popINSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dup
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dup_xINSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dup_xINSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dupINSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dupINSTRUCTION_KIND_DONT_CARE_xINSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dupINSTRUCTION_KIND_DONT_CARE_xINSTRUCTION_KIND_DONT_CARE
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // swap
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iadd
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ladd
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fadd
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dadd
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // isub
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lsub
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fsub
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dsub
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // imul
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lmul
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fmul
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dmul
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // idiv
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ldiv
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fdiv
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ddiv
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // irem
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lrem
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // frem
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // drem
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ineg
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lneg
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fneg
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dneg
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ishl
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lshl
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ishr
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lshr
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iushr
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lushr
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iand
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // land
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ior
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lor
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ixor
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lxor
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iinc
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iINSTRUCTION_KIND_DONT_CAREl
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iINSTRUCTION_KIND_DONT_CAREf
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iINSTRUCTION_KIND_DONT_CAREd
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lINSTRUCTION_KIND_DONT_CAREi
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lINSTRUCTION_KIND_DONT_CAREf
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lINSTRUCTION_KIND_DONT_CAREd
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fINSTRUCTION_KIND_DONT_CAREi
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fINSTRUCTION_KIND_DONT_CAREl
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fINSTRUCTION_KIND_DONT_CAREd
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dINSTRUCTION_KIND_DONT_CAREi
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dINSTRUCTION_KIND_DONT_CAREl
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dINSTRUCTION_KIND_DONT_CAREf
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iINSTRUCTION_KIND_DONT_CAREb
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iINSTRUCTION_KIND_DONT_CAREc
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iINSTRUCTION_KIND_DONT_CAREs
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lcmp
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fcmpl
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // fcmpg
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dcmpl
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // dcmpg
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ifeq
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ifne
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // iflt
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ifge
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ifgt
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ifle
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // if_icmpeq
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // if_icmpne
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // if_icmplt
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // if_icmpge
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // if_icmpgt
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // if_icmple
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // if_acmpeq
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // if_acmpne
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // goto
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // jsr
                    BytecodeConstants.INSTRUCTION_KIND_LOCAL_GENERAL, // ret
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // tableswitch
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // lookupswitch
                    BytecodeConstants.INSTRUCTION_KIND_RETURN, // ireturn
                    BytecodeConstants.INSTRUCTION_KIND_RETURN, // lreturn
                    BytecodeConstants.INSTRUCTION_KIND_RETURN, // freturn
                    BytecodeConstants.INSTRUCTION_KIND_RETURN, // dreturn
                    BytecodeConstants.INSTRUCTION_KIND_RETURN, // areturn
                    BytecodeConstants.INSTRUCTION_KIND_RETURN, // return
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // getstatic
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // putstatic
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // getfield
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // putfield
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // invokevirtual
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // invokespecial
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // invokestatic
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // invokeinterface
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // xxxunusedxxx
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // new
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // newarray
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // anewarray
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // arraylength
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // athrow
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // checkcast
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // instanceof
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // monitorenter
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // monitorexit
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // wide
                    BytecodeConstants.INSTRCUTION_KIND_CP_SHORT, // multianewarray
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ifnull
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // ifnonnull
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // goto_w
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE, // jsr_w
                    BytecodeConstants.INSTRUCTION_KIND_DONT_CARE }; // breakpoint
    
    public static final int MethodFlags =
                    Modifier.PUBLIC | Modifier.PRIVATE | Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL
                                    | Modifier.SYNCHRONIZED | Modifier.NATIVE | Modifier.NATIVE | Modifier.STRICT;
    
    public static final int FieldFlags =
                    Modifier.PUBLIC | Modifier.PRIVATE | Modifier.PROTECTED | Modifier.STATIC | Modifier.FINAL
                                    | Modifier.VOLATILE | Modifier.TRANSIENT;
    
    public static final byte OPCODE_NOP = (byte) 0;
    
    public static final byte OPCODE_WIDE = (byte) 196;
    
    public static final byte OPCODE_LOOKUPSWITCH = (byte) 171;
    
    public static final byte OPCODE_TABLESWITCH = (byte) 170;
    
    public static final byte OPCODE_GETSTATIC = (byte) 178;
    
    public static final byte OPCODE_IRETURN = (byte) 172;
    
    public static final byte OPCODE_LRETURN = (byte) 173;
    
    public static final byte OPCODE_FRETURN = (byte) 174;
    
    public static final byte OPCODE_DRETURN = (byte) 175;
    
    public static final byte OPCODE_ARETURN = (byte) 176;
    
    public static final byte OPCODE_ALOAD_0 = (byte) 42;
    
    public static final byte OPCODE_GETFIELD = (byte) 180;
    
    public static final byte OPCODE_DLOAD_0 = (byte) 38;
    
    public static final byte OPCODE_FLOAD_0 = (byte) 34;
    
    public static final byte OPCODE_LLOAD_0 = (byte) 30;
    
    public static final byte OPCODE_ILOAD_0 = (byte) 26;
    
    public static final byte OPCODE_PUTSTATIC = (byte) 179;
    
    public static final byte OPCODE_PUTFIELD = (byte) 181;
    
    public static final byte OPCODE_RETURN = (byte) 177;
    
    public static final byte OPCODE_ILOAD_1 = (byte) 27;
    
    public static final byte OPCODE_LLOAD_1 = (byte) 31;
    
    public static final byte OPCODE_FLOAD_1 = (byte) 35;
    
    public static final byte OPCODE_DLOAD_1 = (byte) 39;
    
    public static final byte OPCODE_ALOAD_1 = (byte) 43;
    
    public static final byte OPCODE_INVOKEVIRTUAL = (byte) 182;
    
    public static final byte OPCODE_INVOKESTATIC = (byte) 184;
    
    public static final byte OPCODE_INVOKESPECIAL = (byte) 183;
    
    public static final byte OPCODE_INSTANCEOF = (byte) 193;
    
    public static final byte OPCODE_IFEQ = (byte) 153;
    
    public static final byte OPCODE_IFNE = (byte) 154;
    
    public static final byte OPCODE_ILOAD = (byte) 21;
    
    public static final byte OPCODE_LLOAD = (byte) 22;
    
    public static final byte OPCODE_FLOAD = (byte) 23;
    
    public static final byte OPCODE_DLOAD = (byte) 24;
    
    public static final byte OPCODE_ALOAD = (byte) 25;
    
    public static final byte OPCODE_ACONST_NULL = (byte) 1;
    
    public static final byte OPCODE_LDC_W = (byte) 19;
    
    public static final byte OPCODE_SIPUSH = (byte) 17;
    
    public static final byte OPCODE_AALOAD = (byte) 50;
    
    public static final byte OPCODE_ICONST_0 = (byte) 3;
    
    public static final byte OPCODE_POP = (byte) 87;
    
    public static final byte OPCODE_CHECKCAST = (byte) 192;
    
    public static final byte OPCODE_ASTORE_0 = (byte) 75;
    
    public static final byte OPCODE_JSR = (byte) 168;
    
    public static final byte OPCODE_ISTORE = (byte) 54;
    
    public static final byte OPCODE_LSTORE = (byte) 55;
    
    public static final byte OPCODE_FSTORE = (byte) 56;
    
    public static final byte OPCODE_DSTORE = (byte) 57;
    
    public static final byte OPCODE_ASTORE = (byte) 58;
    
    public static final byte OPCODE_RET = (byte) 169;
    
    public static final byte OPCODE_GOTO = (byte) 167;
    
    public static final byte OPCODE_IOR = (byte) 0x80;
    
    public static final byte OPCODE_IAND = (byte) 0x7e;
    
    public static final String ATTRIBUTE_NAME_CODE = "Code";
    
    public static final String ATTRIBUTE_NAME_EXCEPTIONS = "Exceptions";
    
    public static final char TYPE_DESC_INT = 'I';
    
    public static final char TYPE_DESC_LONG = 'J';
    
    public static final char TYPE_DESC_BYTE = 'B';
    
    public static final char TYPE_DESC_SHORT = 'S';
    
    public static final char TYPE_DESC_BOOLEAN = 'Z';
    
    public static final char TYPE_DESC_CHAR = 'C';
    
    public static final char TYPE_DESC_FLOAT = 'F';
    
    public static final char TYPE_DESC_DOUBLE = 'D';
    
    public static final char TYPE_DESC_CLASSORINTERFACE = 'L';
    
    public static final char TYPE_DESC_VOID = 'V';
    
    public static final String TYPE_DESC_STRING_INT = Character.toString(BytecodeConstants.TYPE_DESC_INT);
    
    public static final String TYPE_DESC_STRING_LONG = Character.toString(BytecodeConstants.TYPE_DESC_LONG);
    
    public static final String TYPE_DESC_STRING_BYTE = Character.toString(BytecodeConstants.TYPE_DESC_BYTE);
    
    public static final String TYPE_DESC_STRING_SHORT = Character.toString(BytecodeConstants.TYPE_DESC_SHORT);
    
    public static final String TYPE_DESC_STRING_BOOLEAN = Character.toString(BytecodeConstants.TYPE_DESC_BOOLEAN);
    
    public static final String TYPE_DESC_STRING_CHAR = Character.toString(BytecodeConstants.TYPE_DESC_CHAR);
    
    public static final String TYPE_DESC_STRING_FLOAT = Character.toString(BytecodeConstants.TYPE_DESC_FLOAT);
    
    public static final String TYPE_DESC_STRING_DOUBLE = Character.toString(BytecodeConstants.TYPE_DESC_DOUBLE);
    
    public static final String TYPE_DESC_STRING_CLASSORINTERFACE =
                    Character.toString(BytecodeConstants.TYPE_DESC_CLASSORINTERFACE);
    
    public static final String TYPE_DESC_STRING_VOID = Character.toString(BytecodeConstants.TYPE_DESC_VOID);
    
    public static final String NORMAL_TYPE_INT = "int";
    
    public static final String NORMAL_TYPE_LONG = "long";
    
    public static final String NORMAL_TYPE_BYTE = "byte";
    
    public static final String NORMAL_TYPE_SHORT = "short";
    
    public static final String NORMAL_TYPE_BOOLEAN = "boolean";
    
    public static final String NORMAL_TYPE_CHAR = "char";
    
    public static final String NORMAL_TYPE_FLOAT = "float";
    
    public static final String NORMAL_TYPE_DOUBLE = "double";
    
    public static final String NORMAL_TYPE_VOID = "void";
    
    public static final String STATIC_INITIALIZER_NAME = "<clinit>";
    
    public static final String CONSTRUCTOR_NAME = "<init>";
    
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    
    public static int getInstructionLength(final int opcode, final boolean lastWasWide) {
        final int result = BytecodeConstants.normalInstructionLengths[opcode];
        if (result == BytecodeConstants.SIZE_DEPEND_ON_WIDE) {
            if (lastWasWide)
                return BytecodeConstants.localsInstructionWideLengths[opcode];
            else
                return BytecodeConstants.localsInstructionNoWideLengths[opcode];
        } else if (result == BytecodeConstants.SIZE_UNUSED || result == BytecodeConstants.SIZE_LOOKUPSWITCH
                        || result == BytecodeConstants.SIZE_TABLESWITCH) {
            throw new IllegalArgumentException("Opcode \"" + opcode + "\" is either unused, or a switch instruction.");
        } else {
            return BytecodeConstants.normalInstructionLengths[opcode];
        }
    }
}
