package org.alia4j.aspectj.model.context;

import org.alia4j.liam.Context;

/**
 * @author Andreas Sewe
 */
public abstract class AspectJContextFactory {
    
    protected AspectJContextFactory() {
        if (AspectJContextFactory.singleton != null)
            throw new IllegalStateException();
        AspectJContextFactory.singleton = this;
    }
    
    private static AspectJContextFactory getInstance() {
        return AspectJContextFactory.singleton;
    }
    
    protected static AspectJContextFactory singleton;
    
    public static final Context findOrCreateSourceLocationContext() {
        if (AspectJContextFactory.singletonSourceLocationContext == null)
            AspectJContextFactory.singletonSourceLocationContext =
                            AspectJContextFactory.getInstance().createSourceLocationContext();
        return AspectJContextFactory.singletonSourceLocationContext;
    }
    
    private static Context singletonSourceLocationContext = null;
    
    public static final Context findOrCreateThisJoinPointStaticPartContext() {
        if (AspectJContextFactory.singletonThisJoinPointStaticPartContext == null)
            AspectJContextFactory.singletonThisJoinPointStaticPartContext =
                            AspectJContextFactory.getInstance().createThisJoinPointStaticPartContext();
        return AspectJContextFactory.singletonThisJoinPointStaticPartContext;
    }
    
    private static Context singletonThisJoinPointStaticPartContext;
    
    public static final Context findOrCreateThisJoinPointContext() {
        if (AspectJContextFactory.singletonThisJoinPointContext == null)
            AspectJContextFactory.singletonThisJoinPointContext =
                            AspectJContextFactory.getInstance().createThisJoinPointContext();
        return AspectJContextFactory.singletonThisJoinPointContext;
    }
    
    private static Context singletonThisJoinPointContext;
    
    public static final Context findOrCreateAspectJSignatureContext() {
        if (AspectJContextFactory.singletonAspectJSignatureContext == null)
            AspectJContextFactory.singletonAspectJSignatureContext =
                            AspectJContextFactory.getInstance().createAspectJContext();
        return AspectJContextFactory.singletonAspectJSignatureContext;
    }
    
    private static Context singletonAspectJSignatureContext;
    
    public static final Context findOrCreateJoinPointKindContext() {
        if (AspectJContextFactory.singletonJoinPointKindContext == null)
            AspectJContextFactory.singletonJoinPointKindContext =
                            AspectJContextFactory.getInstance().createJoinPointKindContext();
        return AspectJContextFactory.singletonJoinPointKindContext;
    }
    
    private static Context singletonJoinPointKindContext = null;
    
    protected abstract Context createJoinPointKindContext();
    
    protected Context createSourceLocationContext() {
        return new SourceLocationContext();
    }
    
    protected Context createThisJoinPointStaticPartContext() {
        return new ThisJoinPointStaticPartContext();
    }
    
    protected Context createThisJoinPointContext() {
        return new ThisJoinPointContext();
    }
    
    protected Context createAspectJContext() {
        return new AspectJSignatureContext();
    }
    
}
