package org.alia4j.liam.context;

import java.util.Arrays;
import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public abstract class BinaryOperationContext extends Context {
    
    BinaryOperationContext(final Context lhs, final Context rhs) {
        super(Arrays.asList(lhs, rhs));
        if (lhs == null || rhs == null)
            throw new IllegalArgumentException();
    }
    
    protected Context getFirstOperandContext() {
        return this.getContexts().get(0);
    }
    
    protected Context getSecondOperandContext() {
        return this.getContexts().get(1);
    }
    
    public static final SimpleType getWidestType(final SimpleType s, final SimpleType t) {
        if (s == SimpleType.REFERENCE || t == SimpleType.REFERENCE || s == SimpleType.VOID || t == SimpleType.VOID)
            throw new IllegalArgumentException();
        
        if (s == SimpleType.DOUBLE || t == SimpleType.DOUBLE)
            return SimpleType.DOUBLE;
        else if (s == SimpleType.FLOAT || t == SimpleType.FLOAT)
            return SimpleType.FLOAT;
        else if (s == SimpleType.LONG || t == SimpleType.LONG)
            return SimpleType.LONG;
        else
            return SimpleType.INT;
    }
    
}
