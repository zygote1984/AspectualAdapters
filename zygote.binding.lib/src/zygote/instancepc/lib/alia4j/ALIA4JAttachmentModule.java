package zygote.instancepc.lib.alia4j;

import java.util.Set;

import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.ActionFactory;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.DebugInfo;
import org.alia4j.liam.ScheduleInfo;
import org.alia4j.liam.Specialization;
import org.alia4j.liam.signature.ResolutionStrategy;

public class ALIA4JAttachmentModule {
	
	
	public static Attachment createStaticAttachment(Set<Specialization> parsedPointcut, Class<? extends Object> type, String method, Class[] args, Class<?> resultType, ScheduleInfo info)
	{
		
        Attachment attachment = new Attachment(parsedPointcut, ActionFactory
                .findOrCreateMethodCallAction(
                		TypeHierarchyProvider.findOrCreateFromClass(type),
                		method,
                		TypeHierarchyProvider.findOrCreateFromClasses(args),
                		TypeHierarchyProvider.findOrCreateFromClass(resultType),
                		ResolutionStrategy.STATIC),
                info, DebugInfo.UNKNOWN_INFO);
        
        return attachment;
	}
	
	public static Attachment createVirtualAttachment(Set<Specialization> parsedPointcut, String type, String method, String[] args, ScheduleInfo info )
	{
		Attachment attachment = new Attachment(parsedPointcut, ActionFactory
                .findOrCreateMethodCallAction(
                		type,
                		method,
                		args, "boolean"),
                info, DebugInfo.UNKNOWN_INFO);
        
        return attachment;
	}

	
	
	
	

}
