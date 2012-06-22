package org.alia4j.noirin;

import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import org.alia4j.fial.System;
import org.alia4j.fial.predicate.AtomicPredicateFactoryImpl;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.PrecedenceRule;
import org.alia4j.noirin.action.ActionFactoryImpl;
import org.alia4j.noirin.context.ContextFactoryImpl;
import org.alia4j.noirin.debug.connection.AddbServerAgent;
import org.alia4j.noirin.transform.InterpreterCallbackInserter;
import org.alia4j.noirin.typehierarchy.TypeHierarchyProviderImpl;
import org.alia4j.noirin.xml.read.LiamFactory;
import org.alia4j.noirin.xml.read.Xml2LiamModel_Reader;

public class Agent {
    
    private static Instrumentation instrumentation;
    
    public static void premain(final String agentArgs, final Instrumentation inst) {
        Agent.instrumentation = inst;
        
        TypeHierarchyProviderImpl.initialize();
        ActionFactoryImpl.initialize();
        ContextFactoryImpl.initialize();
        AtomicPredicateFactoryImpl.initialize();
        
        SystemImpl.initialize();
        
        Agent.instrumentation.addTransformer(new InterpreterCallbackInserter());
        org.alia4j.fial.System.getInstance().aboutToStartApplication(ClassLoader.getSystemClassLoader());
        
        LiamFactory.needInitialized = false;
        
        URL liamInfoLocation = ClassLoader.getSystemClassLoader().getResource("LiamInfo.xml");
        if (liamInfoLocation != null) {
            Xml2LiamModel_Reader reader = new Xml2LiamModel_Reader(liamInfoLocation.getPath());
            reader.intercept();
            List<Attachment> attaList = reader.getAttachmentList();
            List<PrecedenceRule> pdrList = reader.getPrecedenceRules();
            for (Attachment atta : attaList) {
            	System.getInstance();
                System.deploy(atta);
            }
            for(PrecedenceRule pr : pdrList) {
            	System.getInstance();
                System.deploy(pr);
            }
        }
        
        if (agentArgs != null && agentArgs.contains("=")) {
            String[] args = agentArgs.split(",");
            HashMap<String, String> argMap = new HashMap<String, String>();
            for (String arg : args) {
                int splitorIdx = arg.indexOf("=");
                argMap.put(arg.substring(0, splitorIdx), arg.substring(splitorIdx + 1, arg.length()));
            }
            if (argMap.get("mode").equals("debug")) {
                AddbServerAgent.DEBUG_MODE = true;
                AddbServerAgent.instance().run();
            }
        }
        
    }
    
    public static Class<?>[] getLoadedClasses() {
        return Agent.instrumentation.getAllLoadedClasses();
        
    }
    
}
