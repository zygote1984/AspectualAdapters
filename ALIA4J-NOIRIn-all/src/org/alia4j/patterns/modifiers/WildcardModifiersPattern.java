package org.alia4j.patterns.modifiers;

import java.lang.reflect.Modifier;
import org.alia4j.patterns.ModifiersPattern;

public class WildcardModifiersPattern extends ModifiersPattern {
    
    private static final int NEGATED_SHIFT = 16;
    
    public static final int PUBLIC = 0x00000001;
    
    public static final int PRIVATE = 0x00000002;
    
    public static final int PROTECTED = 0x00000004;
    
    public static final int PACKAGE_VISIBLE = 0x00001000;
    
    public static final int STATIC = 0x00000008;
    
    public static final int FINAL = 0x00000010;
    
    public static final int SYNCHRONIZED = 0x00000020;
    
    public static final int VOLATILE = 0x00000040;
    
    public static final int TRANSIENT = 0x00000080;
    
    public static final int NATIVE = 0x00000100;
    
    public static final int INTERFACE = 0x00000200;
    
    public static final int ABSTRACT = 0x00000400;
    
    public static final int STRICT = 0x00000800;
    
    public static final int NOT_PUBLIC = WildcardModifiersPattern.PUBLIC << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_PRIVATE = WildcardModifiersPattern.PRIVATE << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_PROTECTED = WildcardModifiersPattern.PROTECTED << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_PACKAGE_VISIBLE =
                    WildcardModifiersPattern.PACKAGE_VISIBLE << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_STATIC = WildcardModifiersPattern.STATIC << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_FINAL = WildcardModifiersPattern.FINAL << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_SYNCHRONIZED =
                    WildcardModifiersPattern.SYNCHRONIZED << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_VOLATILE = WildcardModifiersPattern.VOLATILE << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_TRANSIENT = WildcardModifiersPattern.TRANSIENT << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_NATIVE = WildcardModifiersPattern.NATIVE << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_INTERFACE = WildcardModifiersPattern.INTERFACE << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_ABSTRACT = WildcardModifiersPattern.ABSTRACT << WildcardModifiersPattern.NEGATED_SHIFT;
    
    public static final int NOT_STRICT = WildcardModifiersPattern.STRICT << WildcardModifiersPattern.NEGATED_SHIFT;
    
    private final int pattern;
    
    private String modifiersPattern;
    
    public WildcardModifiersPattern(final int pattern) {
        final StringBuffer modifiersPattern = new StringBuffer();
        for (int i = WildcardModifiersPattern.PUBLIC; i <= WildcardModifiersPattern.PACKAGE_VISIBLE; i <<= 1) {
            String modifierName;
            if (i == WildcardModifiersPattern.PACKAGE_VISIBLE)
                modifierName = "package visible";
            else
                modifierName = Modifier.toString(i);
            
            if ((pattern & i) > 0)
                modifiersPattern.append(modifierName).append(' ');
            else if ((pattern & (i << WildcardModifiersPattern.NEGATED_SHIFT)) > 0)
                modifiersPattern.append('!').append(modifierName).append(' ');
            
            if ((pattern & i) > 0 && (pattern & (i << WildcardModifiersPattern.NEGATED_SHIFT)) > 0) {
                throw new IllegalArgumentException(
                                "A modifier can not be expected to be positive and negative at the same time ("
                                                + modifierName + ").");
            }
        }
        if (modifiersPattern.length() == 0)
            this.modifiersPattern = "";
        else {
            if (modifiersPattern.charAt(0) == ' ')
                this.modifiersPattern = modifiersPattern.substring(1);
            else
                this.modifiersPattern = modifiersPattern.toString();
        }
        
        this.pattern = pattern;
    }
    
    @Override
    public boolean matches(final int modifier) {
        if ((this.pattern & WildcardModifiersPattern.PACKAGE_VISIBLE) > 0) {
            if ((modifier & (WildcardModifiersPattern.PUBLIC | WildcardModifiersPattern.PROTECTED | WildcardModifiersPattern.PRIVATE)) > 0)
                return false;
        }
        for (int i = WildcardModifiersPattern.PUBLIC; i <= WildcardModifiersPattern.STRICT; i <<= 1) {
            if ((this.pattern & i) > 0 && (modifier & i) == 0)
                return false;
        }
        
        if ((this.pattern & WildcardModifiersPattern.NOT_PACKAGE_VISIBLE) > 0) {
            if ((modifier & (WildcardModifiersPattern.PUBLIC | WildcardModifiersPattern.PROTECTED | WildcardModifiersPattern.PRIVATE)) == 0)
                return false;
        }
        for (int i = WildcardModifiersPattern.PUBLIC; i <= WildcardModifiersPattern.STRICT; i <<= 1) {
            if ((this.pattern & (i << WildcardModifiersPattern.NEGATED_SHIFT)) > 0 && (modifier & i) > 0)
                return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this.modifiersPattern;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.modifiersPattern == null) ? 0 : this.modifiersPattern.hashCode());
        result = prime * result + this.pattern;
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        final WildcardModifiersPattern other = (WildcardModifiersPattern) obj;
        if (this.modifiersPattern == null) {
            if (other.modifiersPattern != null)
                return false;
        } else if (!this.modifiersPattern.equals(other.modifiersPattern))
            return false;
        if (this.pattern != other.pattern)
            return false;
        return true;
    }
    
}
