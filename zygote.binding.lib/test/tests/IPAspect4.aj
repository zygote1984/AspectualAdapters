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

public aspect IPAspect4 {

//	instance pointcut ipc4<Object> :
//	ipc1 || ipc3 ||
//	before(call(* *.start3(..)) && returning(instance)) UNTIL 
//	after(call(* *.end3(..)) && target(instance));

	private static final Class<?> ipc4_type = Object.class;
	private static Set<Specialization> ipc4_add_before;
	private static Set<Specialization> ipc4_add_after;
	private static Set<Specialization> ipc4_remove_before;
	private static Set<Specialization> ipc4_remove_after;

	public static Set<Specialization> ipc4_add_before() {
		if (ipc4_add_before == null) {
			AJPointcutParser parser = ALIA4JParser.parseExpression("call(* *.start3(..)) && args(instance)");
			HashMap<String, Class<?>> args = new HashMap<String, Class<?>>();
			args.put("instance", ipc4_type);
			Set<Specialization> simpleIPExpr = ALIA4JSpecializationModule.createFromStaticMethod(parser, args);
			
			Set<Specialization> ipRefExpr = ALIA4JSpecializationModule.orSpecializations(IPAspect1.ipc1_add_before(), IPAspect3.ipc3_add_before());
			ipc4_add_before = ALIA4JSpecializationModule.orSpecializations(ipRefExpr, simpleIPExpr);
		}
		return ipc4_add_before;
	}

	public static Set<Specialization> ipc4_add_after() {
		if (ipc4_add_after == null) {
			Set<Specialization> simpleIPExpr = Collections.emptySet();

			Set<Specialization> ipRefExpr = ALIA4JSpecializationModule.orSpecializations(IPAspect1.ipc1_add_after(), IPAspect3.ipc3_add_after());
			ipc4_add_after = ALIA4JSpecializationModule.orSpecializations(ipRefExpr, simpleIPExpr);
		}
		return ipc4_add_after;
	}

	public static Set<Specialization> ipc4_remove_before() {
		if (ipc4_remove_before == null) {
			Set<Specialization> simpleIPExpr = Collections.emptySet();

			Set<Specialization> ipRefExpr = ALIA4JSpecializationModule.orSpecializations(IPAspect1.ipc1_remove_before(), IPAspect3.ipc3_remove_before());
			ipc4_remove_before = ALIA4JSpecializationModule.orSpecializations(ipRefExpr, simpleIPExpr);
		}
		return ipc4_remove_before;
	}

	public static Set<Specialization> ipc4_remove_after() {
		if (ipc4_remove_after == null) {
			AJPointcutParser parser = ALIA4JParser.parseExpression("call(* *.end3(..)) && args(instance)");
			HashMap<String, Class<?>> args = new HashMap<String, Class<?>>();
			args.put("instance", ipc4_type);
			Set<Specialization> simpleIPExpr = ALIA4JSpecializationModule.createFromStaticMethod(parser, args);

			Set<Specialization> ipRefExpr = ALIA4JSpecializationModule.orSpecializations(IPAspect1.ipc1_remove_after(), IPAspect3.ipc3_remove_after());
			ipc4_remove_after = ALIA4JSpecializationModule.orSpecializations(ipRefExpr, simpleIPExpr);
		}
		return ipc4_remove_after;
	}

	// the first type argument corresponds to ipc4_type
	private static WeakHashMap<Object, Integer> ipc4_data = new WeakHashMap<Object, Integer>();

	public static Set<Object> ipc4() {
		return Collections.unmodifiableSet(ipc4_data.keySet());
	}
	
	
	public static void ipc4_addInstance(Object instance) {
		if (ipc4_data.containsKey(instance)) {
			ipc4_data.put(instance, ipc4_data.get(instance) + 1 );
		}
		else {
			ipc4_data.put(instance, 1);
		}
		ipc4_instanceAdded(instance);
	}
	
	private static void ipc4_instanceAdded(Object instance) {
	}

	public static void ipc4_removeInstance(Object instance) {
		assert ipc4_data.containsKey(instance);
		assert ipc4_data.get(instance) > 0;
		int newCount = ipc4_data.get(instance) - 1;
		if (newCount == 0)
			ipc4_data.remove(instance);
		else
			ipc4_data.put(instance, newCount);
		ipc4_instanceRemoved(instance);
	}
	
	public pointcut ipc4_add(Object instance) : call(private static void IPAspect4.ipc4_instanceAdded(Object)) && args(instance);
	public pointcut ipc4_remove(Object instance) : call(private static void IPAspect4.ipc4_instanceRemoved(Object)) && args(instance);
	
	private static void ipc4_instanceRemoved(Object instance) {
	}

	private static Attachment ipc4_add_before_attachment;
	private static Attachment ipc4_add_after_attachment;
	private static Attachment ipc4_remove_before_attachment;
	private static Attachment ipc4_remove_after_attachment;

	public static void ipc4_deploy() {
		ipc4_add_before_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc4_add_before(), IPAspect4.class, "ipc4_addInstance", new Class[]{Object.class}, void.class, ScheduleInfo.BEFORE);
		ipc4_add_after_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc4_add_after(), IPAspect4.class, "ipc4_addInstance", new Class[]{Object.class}, void.class, ScheduleInfo.AFTER);
		ipc4_remove_before_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc4_remove_before(), IPAspect4.class, "ipc4_removeInstance", new Class[]{Object.class}, void.class, ScheduleInfo.BEFORE);
		ipc4_remove_after_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc4_remove_after(), IPAspect4.class, "ipc4_removeInstance", new Class[]{Object.class}, void.class, ScheduleInfo.AFTER);
		
		System.deploy(ipc4_add_before_attachment, ipc4_add_after_attachment, ipc4_remove_before_attachment, ipc4_remove_after_attachment);
	}
	
	public static void ipc4_reset() {
		ipc4_data.clear();
	}

}
