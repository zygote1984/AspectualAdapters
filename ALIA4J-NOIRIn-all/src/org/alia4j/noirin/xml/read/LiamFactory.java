package org.alia4j.noirin.xml.read;

import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.ActionFactory;
import org.alia4j.liam.AtomicPredicateFactory;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.signature.ResolutionStrategy;
import org.dom4j.Element;

public abstract class LiamFactory {
    
    protected LiamFactory() {
        if (LiamFactory.singleton != null)
            throw new RuntimeException("LiamFactory should be initialized");
        this.factoriesInitialization();
        LiamFactory.singleton = this;
    }
    
    private static LiamFactory singleton;
    
    public static Object getObject(Element elm) {
        return LiamFactory.singleton.produce(elm);
    }
    
    public static Context getTargetContext(String targetType, String className) {
        return ContextFactory.findOrCreateLazyObjectConstantContext(LiamFactory.getTypeDescriptor(className));
    }
    
    public static TypeDescriptor getTypeDescriptor(String typeString) {
        return LiamFactory.singleton.string2TypeDescriptor(typeString);
    }
    
    @SuppressWarnings("unchecked")
	protected Object produce(Element elm) {
        Object result = null;
        String type = elm.attribute("type").getValue();
        ExtendedProductionResult epr = this.extendedElementProducer(type, elm);
        if (epr.isExtended()) {
            result = epr.result();
        } else if (type.equals("InstanceofPredicate")) {
            Element ctxElm = elm.element("context");
            Element typeElm = elm.element("requiredTypeName");
            result =
                            AtomicPredicateFactory.findOrCreateInstanceofPredicate((Context) this.produce(ctxElm),
                                            this.string2TypeDescriptor(typeElm.getText()));
        } else if (type.equals("CalleeContext")) {
            result = ContextFactory.findOrCreateCalleeContext();
        } else if (type.equals("CallerContext")) {
            result = ContextFactory.findOrCreateCallerContext();
        } else if (type.equals("MethodCallAction")) {
            
            TypeDescriptor declaringClass = this.string2TypeDescriptor(elm.element("declaringClassName").getText());
            CharSequence methodName = elm.element("methodName").getText();
            
            Element paraElms = elm.element("parameters");
            List<Element> paraElmList = paraElms.elements();
            TypeDescriptor[] parameterTypes = new TypeDescriptor[paraElmList.size()];
            for (int i = 0; i < paraElmList.size(); i++) {
                parameterTypes[i] = this.string2TypeDescriptor(paraElmList.get(i).getText());
            }
            
            TypeDescriptor resultType = this.string2TypeDescriptor(elm.element("returnType").getText());
            
            result =
                            ActionFactory.findOrCreateMethodCallAction(declaringClass, methodName, parameterTypes,
                                            resultType, ResolutionStrategy.VIRTUAL);
            
        } else if (type.equals("ArgumentContext")) {
            Element idxElm = elm.element("index");
            int idx = Integer.parseInt(idxElm.getText());
            result = ContextFactory.findOrCreateArgumentContext(idx);
        } else if (type.equals("MethodResultContext")) {
            result = ContextFactory.findOrCreateMethodResultContext();
        }
        return result;
    }
    
    private TypeDescriptor string2TypeDescriptor(String typeString) {
        return TypeHierarchyProvider.findOrCreateFromNormalTypeName(typeString);
    }
    
    abstract protected void factoriesInitialization();
    
    abstract protected ExtendedProductionResult extendedElementProducer(String type, Element elm);
    
    public static boolean needInitialized = true;
    
}
