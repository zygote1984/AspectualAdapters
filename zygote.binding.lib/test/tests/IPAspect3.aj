package tests;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.WeakHashMap;

import org.alia4j.aspectj.parser.ast.AJPointcutParser;
import org.alia4j.fial.System;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.ScheduleInfo;
import org.alia4j.liam.Specialization;

import zygote.instancepc.lib.alia4j.ALIA4JAttachmentModule;
import zygote.instancepc.lib.alia4j.ALIA4JParser;
import zygote.instancepc.lib.alia4j.ALIA4JSpecializationModule;

public aspect IPAspect3 {

//	instance pointcut ipc3<String> :
//	before(call(* *.start2(..)) && returning(instance)) UNTIL 
//	after(call(* *.end2(..)) && target(instance));

	private static final Class<?> ipc3_type = String.class;
	private static Set<Specialization> ipc3_add_before;
	private static Set<Specialization> ipc3_add_after;
	private static Set<Specialization> ipc3_remove_before;
	private static Set<Specialization> ipc3_remove_after;

	public static Set<Specialization> ipc3_add_before() {
		if (ipc3_add_before == null) {
			AJPointcutParser parser = ALIA4JParser.parseExpression("call(* *.start2(..)) && args(instance)");
			HashMap<String, Class<?>> args = new HashMap<String, Class<?>>();
			args.put("instance", ipc3_type);
			ipc3_add_before = ALIA4JSpecializationModule.createFromStaticMethod(parser, args);
		}
		return ipc3_add_before;
	}

	public static Set<Specialization> ipc3_add_after() {
		if (ipc3_add_after == null) {
			ipc3_add_after = Collections.emptySet();
		}
		return ipc3_add_after;
	}

	public static Set<Specialization> ipc3_remove_before() {
		if (ipc3_remove_before == null) {
			ipc3_remove_before = Collections.emptySet();
		}
		return ipc3_remove_before;
	}

	public static Set<Specialization> ipc3_remove_after() {
		if (ipc3_remove_after == null) {
			AJPointcutParser parser = ALIA4JParser.parseExpression("call(* *.end2(..)) && args(instance)");
			HashMap<String, Class<?>> args = new HashMap<String, Class<?>>();
			args.put("instance", ipc3_type);
			ipc3_remove_after = ALIA4JSpecializationModule.createFromStaticMethod(parser, args);
		}
		return ipc3_remove_after;
	}

	// the first type argument corresponds to ipc3_type
	private static WeakHashMap<String, Integer> ipc3_data = new WeakHashMap<String, Integer>();

	public static Set<String> ipc3() {
		return Collections.unmodifiableSet(ipc3_data.keySet());
	}
	
	
	public static void ipc3_addInstance(String instance) {
		if (ipc3_data.containsKey(instance)) {
			ipc3_data.put(instance, ipc3_data.get(instance) + 1 );
		}
		else {
			ipc3_data.put(instance, 1);
		}
		ipc3_instanceAdded(instance);
	}
	
	private static void ipc3_instanceAdded(String instance) {
	}

	public static void ipc3_removeInstance(String instance) {
		assert ipc3_data.containsKey(instance);
		assert ipc3_data.get(instance) > 0;
		int newCount = ipc3_data.get(instance) - 1;
		if (newCount == 0)
			ipc3_data.remove(instance);
		else
			ipc3_data.put(instance, newCount);
		ipc3_instanceRemoved(instance);
	}
	
	public pointcut ipc3_add(String instance) : call(private static void IPAspect3.ipc3_instanceAdded(String)) && args(instance);
	public pointcut ipc3_remove(String instance) : call(private static void IPAspect3.ipc3_instanceRemoved(String)) && args(instance);
	
	private static void ipc3_instanceRemoved(String instance) {
	}

	private static Attachment ipc3_add_before_attachment;
	private static Attachment ipc3_add_after_attachment;
	private static Attachment ipc3_remove_before_attachment;
	private static Attachment ipc3_remove_after_attachment;

	public static void ipc3_deploy() {
		ipc3_add_before_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc3_add_before(), IPAspect3.class, "ipc3_addInstance", new Class[]{String.class}, void.class, ScheduleInfo.BEFORE);
		ipc3_add_after_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc3_add_after(), IPAspect3.class, "ipc3_addInstance", new Class[]{String.class}, void.class, ScheduleInfo.AFTER);
		ipc3_remove_before_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc3_remove_before(), IPAspect3.class, "ipc3_removeInstance", new Class[]{String.class}, void.class, ScheduleInfo.BEFORE);
		ipc3_remove_after_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc3_remove_after(), IPAspect3.class, "ipc3_removeInstance", new Class[]{String.class}, void.class, ScheduleInfo.AFTER);
		
		System.deploy(ipc3_add_before_attachment, ipc3_add_after_attachment, ipc3_remove_before_attachment, ipc3_remove_after_attachment);
	}
	
	public static void ipc3_reset() {
		ipc3_data.clear();
	}

}
