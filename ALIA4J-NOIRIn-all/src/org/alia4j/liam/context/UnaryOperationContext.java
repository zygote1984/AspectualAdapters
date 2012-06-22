package org.alia4j.liam.context;

import java.util.Collections;
import org.alia4j.liam.Context;

/**
 * @author Christoph Bockisch
 */
public abstract class UnaryOperationContext extends Context {
    
    public UnaryOperationContext(final Context operand) {
        super(Collections.singletonList(operand));
    }
    
    protected Context getOperand() {
        return this.getContexts().get(0);
    }
}
