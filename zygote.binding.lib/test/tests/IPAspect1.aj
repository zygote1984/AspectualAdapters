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


public aspect IPAspect1 {

//	instance pointcut ipc1<Number> :
//	before(call(java.lang.Object+->new(..)) && returning(instance)) UNTIL 
//	after(call(public void java.lang.Object->notify(..)) && target(instance));

	private static final Class<?> ipc1_type = Number.class;
	private static Set<Specialization> ipc1_add_before;
	private static Set<Specialization> ipc1_add_after;
	private static Set<Specialization> ipc1_remove_before;
	private static Set<Specialization> ipc1_remove_after;

	public static Set<Specialization> ipc1_add_before() {
		if (ipc1_add_before == null) {
			AJPointcutParser parser = ALIA4JParser.parseExpression("call(* *.start(..)) && args(instance)");
			HashMap<String, Class<?>> args = new HashMap<String, Class<?>>();
			args.put("instance", ipc1_type);
			ipc1_add_before = ALIA4JSpecializationModule.createFromStaticMethod(parser, args);
		}
		return ipc1_add_before;
	}

	public static Set<Specialization> ipc1_add_after() {
		if (ipc1_add_after == null) {
			ipc1_add_after = Collections.emptySet();
		}
		return ipc1_add_after;
	}

	public static Set<Specialization> ipc1_remove_before() {
		if (ipc1_remove_before == null) {
			ipc1_remove_before = Collections.emptySet();
		}
		return ipc1_remove_before;
	}

	public static Set<Specialization> ipc1_remove_after() {
		if (ipc1_remove_after == null) {
			AJPointcutParser parser = ALIA4JParser.parseExpression("call(* *.end(..)) && args(instance)");
			HashMap<String, Class<?>> args = new HashMap<String, Class<?>>();
			args.put("instance", ipc1_type);
			ipc1_remove_after = ALIA4JSpecializationModule.createFromStaticMethod(parser, args);
		}
		return ipc1_remove_after;
	}

	// the first type argument corresponds to ipc1_type
	private static WeakHashMap<Number, Integer> ipc1_data = new WeakHashMap<Number, Integer>();

	public static Set<Number> ipc1() {
		return Collections.unmodifiableSet(ipc1_data.keySet());
	}
	
	
	public static void ipc1_addInstance(Number instance) {
		if (ipc1_data.containsKey(instance)) {
			ipc1_data.put(instance, ipc1_data.get(instance) + 1 );
		}
		else {
			ipc1_data.put(instance, 1);
		}
		ipc1_instanceAdded(instance);
	}
	
	private static void ipc1_instanceAdded(Number instance) {
	}

	public static void ipc1_removeInstance(Number instance) {
		assert ipc1_data.containsKey(instance);
		assert ipc1_data.get(instance) > 0;
		int newCount = ipc1_data.get(instance) - 1;
		if (newCount == 0)
			ipc1_data.remove(instance);
		else
			ipc1_data.put(instance, newCount);
		ipc1_instanceRemoved(instance);
	}
	
	public pointcut ipc1_add(Number instance) : call(private static void IPAspect1.ipc1_instanceAdded(Number)) && args(instance);
	public pointcut ipc1_remove(Number instance) : call(private static void IPAspect1.ipc1_instanceRemoved(Number)) && args(instance);
	
	private static void ipc1_instanceRemoved(Number instance) {
	}

	private static Attachment ipc1_add_before_attachment;
	private static Attachment ipc1_add_after_attachment;
	private static Attachment ipc1_remove_before_attachment;
	private static Attachment ipc1_remove_after_attachment;

	public static void ipc1_deploy() {
		ipc1_add_before_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc1_add_before(), IPAspect1.class, "ipc1_addInstance", new Class[]{Number.class}, void.class, ScheduleInfo.BEFORE);
		ipc1_add_after_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc1_add_after(), IPAspect1.class, "ipc1_addInstance", new Class[]{Number.class}, void.class, ScheduleInfo.AFTER);
		ipc1_remove_before_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc1_remove_before(), IPAspect1.class, "ipc1_removeInstance", new Class[]{Number.class}, void.class, ScheduleInfo.BEFORE);
		ipc1_remove_after_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc1_remove_after(), IPAspect1.class, "ipc1_removeInstance", new Class[]{Number.class}, void.class, ScheduleInfo.AFTER);
		
		System.deploy(ipc1_add_before_attachment, ipc1_add_after_attachment, ipc1_remove_before_attachment, ipc1_remove_after_attachment);
	}
	
	public static void ipc1_reset() {
		ipc1_data.clear();
	}
}
