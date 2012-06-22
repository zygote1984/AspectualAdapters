/**
 * 
 */
package org.alia4j.liam.signature;


public enum ResolutionStrategy {
    VIRTUAL, SPECIAL, STATIC, INTERFACE;
    
    public static ResolutionStrategy getForOpcode(int opcode) {
        switch (opcode) {
        case 180: // Opcodes.GETFIELD:
        case 181: // Opcodes.PUTFIELD:
        case 182: // Opcodes.INVOKEVIRTUAL:
            return ResolutionStrategy.VIRTUAL;
        case 178: // Opcodes.GETSTATIC:
        case 179: // Opcodes.PUTSTATIC:
        case 184: // Opcodes.INVOKESTATIC:
            return ResolutionStrategy.STATIC;
        case 183: // Opcodes.INVOKESPECIAL:
            return ResolutionStrategy.SPECIAL;
        case 185: // Opcodes.INVOKEINTERFACE:
            return ResolutionStrategy.INTERFACE;
        default:
            throw new Error("Unsupported bytecode instruction at dispatch call site. (" + opcode + ")");
        }
        
    }
}
