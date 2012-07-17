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

public aspect IPAspect5 {

//TODO should "instance" binding be allowed in the ip-expr together with subset?
//	instance pointcut ipc5<Object> subsectof ipc1:
//	before(call(* *.start(..)) && returning(instance) && cflow(call(* *.controlflow*(..))));

	// the (inferred) element type
	private static final Class<?> ipc5_type = Object.class;
	
	private static Set<Specialization> ipc5_add_before;
	private static Set<Specialization> ipc5_add_after;
	private static Set<Specialization> ipc5_remove_before;
	private static Set<Specialization> ipc5_remove_after;

	public static Set<Specialization> ipc5_add_before() {
		if (ipc5_add_before == null) {
			AJPointcutParser parser = ALIA4JParser.parseExpression("call(* *.start(..)) && returning(instance) && cflow(call(* *.controlflow*(..)))");
			HashMap<String, Class<?>> args = new HashMap<String, Class<?>>();
			args.put("instance", ipc5_type);
			Set<Specialization> simpleIPExpr = ALIA4JSpecializationModule.createFromStaticMethod(parser, args);
			
			Set<Specialization> ipRefExpr = IPAspect1.ipc1_add_before();
			ipc5_add_before = ALIA4JSpecializationModule.andSpecializations(ipRefExpr, simpleIPExpr);
		}
		return ipc5_add_before;
	}

	public static Set<Specialization> ipc5_add_after() {
		if (ipc5_add_after == null) {
			Set<Specialization> simpleIPExpr = Collections.emptySet();

			Set<Specialization> ipRefExpr = IPAspect1.ipc1_add_after();
			ipc5_add_after = ALIA4JSpecializationModule.andSpecializations(ipRefExpr, simpleIPExpr);
		}
		return ipc5_add_after;
	}

	public static Set<Specialization> ipc5_remove_before() {
		if (ipc5_remove_before == null) {
			Set<Specialization> simpleIPExpr = Collections.emptySet();

			Set<Specialization> ipRefExpr = IPAspect1.ipc1_remove_before();
			ipc5_remove_before = ALIA4JSpecializationModule.orSpecializations(ipRefExpr, simpleIPExpr);
		}
		return ipc5_remove_before;
	}

	public static Set<Specialization> ipc5_remove_after() {
		if (ipc5_remove_after == null) {
			Set<Specialization> simpleIPExpr = Collections.emptySet();

			Set<Specialization> ipRefExpr = IPAspect1.ipc1_remove_after();
			ipc5_remove_after = ALIA4JSpecializationModule.orSpecializations(ipRefExpr, simpleIPExpr);
		}
		return ipc5_remove_after;
	}

	// the first type argument corresponds to ipc5_type
	private static WeakHashMap<Object, Integer> ipc5_data = new WeakHashMap<Object, Integer>();

	public static Set<Object> ipc5() {
		return Collections.unmodifiableSet(ipc5_data.keySet());
	}
	
	
	public static void ipc5_addInstance(Object instance) {
		if (ipc5_data.containsKey(instance)) {
			ipc5_data.put(instance, ipc5_data.get(instance) + 1 );
		}
		else {
			ipc5_data.put(instance, 1);
		}
		ipc5_instanceAdded(instance);
	}
	
	private static void ipc5_instanceAdded(Object instance) {
	}

	public static void ipc5_removeInstance(Object instance) {
//		assert ipc5_data.containsKey(instance);
//		assert ipc5_data.get(instance) > 0;
		if (!ipc5_data.containsKey(instance) || ipc5_data.get(instance) <= 0)
			return;

		int newCount = ipc5_data.get(instance) - 1;
		if (newCount == 0)
			ipc5_data.remove(instance);
		else
			ipc5_data.put(instance, newCount);
		ipc5_instanceRemoved(instance);
	}
	
	public pointcut ipc5_add(Object instance) : call(private static void IPAspect5.ipc5_instanceAdded(Object)) && args(instance);
	public pointcut ipc5_remove(Object instance) : call(private static void IPAspect5.ipc5_instanceRemoved(Object)) && args(instance);
	
	private static void ipc5_instanceRemoved(Object instance) {
	}

	private static Attachment ipc5_add_before_attachment;
	private static Attachment ipc5_add_after_attachment;
	private static Attachment ipc5_remove_before_attachment;
	private static Attachment ipc5_remove_after_attachment;

	public static void ipc5_deploy() {
		ipc5_add_before_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc5_add_before(), IPAspect5.class, "ipc5_addInstance", new Class[]{Object.class}, void.class, ScheduleInfo.BEFORE);
		ipc5_add_after_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc5_add_after(), IPAspect5.class, "ipc5_addInstance", new Class[]{Object.class}, void.class, ScheduleInfo.AFTER);
		ipc5_remove_before_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc5_remove_before(), IPAspect5.class, "ipc5_removeInstance", new Class[]{Object.class}, void.class, ScheduleInfo.BEFORE);
		ipc5_remove_after_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc5_remove_after(), IPAspect5.class, "ipc5_removeInstance", new Class[]{Object.class}, void.class, ScheduleInfo.AFTER);
		
		System.deploy(ipc5_add_before_attachment, ipc5_add_after_attachment, ipc5_remove_before_attachment, ipc5_remove_after_attachment);
	}
	
	public static void ipc5_reset() {
		ipc5_data.clear();
	}

}
