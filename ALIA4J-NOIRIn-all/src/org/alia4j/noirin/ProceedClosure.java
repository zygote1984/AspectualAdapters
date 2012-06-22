package org.alia4j.noirin;

import org.alia4j.fial.ActionOrderElement;
import org.alia4j.fial.GenericFunction;

public class ProceedClosure {
    
    public final GenericFunction<?, ?> callSite;
    
    public final ActionOrderElement proceedToActionOrderElement;
    
    public final CallContext expectedCallContext;
    
    public ProceedClosure(GenericFunction<?, ?> callSite, ActionOrderElement proceedToActionOrderElement,
                    CallContext expectedCallContext) {
        super();
        this.callSite = callSite;
        this.proceedToActionOrderElement = proceedToActionOrderElement;
        this.expectedCallContext = expectedCallContext;
    }
    
}
