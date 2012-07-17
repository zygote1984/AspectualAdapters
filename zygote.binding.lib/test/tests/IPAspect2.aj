package tests;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.WeakHashMap;

import org.alia4j.aspectj.parser.ast.AJPointcutParser;
import org.alia4j.fial.System;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.ScheduleInfo;
import org.alia4j.liam.Specialization;

import zygote.instancepc.lib.alia4j.ALIA4JAttachmentModule;
import zygote.instancepc.lib.alia4j.ALIA4JParser;
import zygote.instancepc.lib.alia4j.ALIA4JSpecializationModule;

public aspect IPAspect2 {
	
//	instance pointcut ipc2<Integer> :
//	IPAspect1.ipc1<Integer>

	private static final Class<?> ipc2_type = Number.class;

	private static Set<Specialization> ipc2_add_before;
	private static Set<Specialization> ipc2_add_after;
	private static Set<Specialization> ipc2_remove_before;
	private static Set<Specialization> ipc2_remove_after;

	public static Set<Specialization> ipc2_add_before() {
		if (ipc2_add_before == null) {
			ipc2_add_before = ALIA4JSpecializationModule.addTypeConstraint(IPAspect1.ipc1_add_before(), TypeHierarchyProvider.findOrCreateFromInternalClassName("java/lang/Integer"));
		}
		return ipc2_add_before;
	}

	public static Set<Specialization> ipc2_add_after() {
		if (ipc2_add_after == null) {
			ipc2_add_after = ALIA4JSpecializationModule.addTypeConstraint(IPAspect1.ipc1_add_after(), TypeHierarchyProvider.findOrCreateFromInternalClassName("java/lang/Integer"));
		}
		return ipc2_add_after;
	}

	public static Set<Specialization> ipc2_remove_before() {
		if (ipc2_remove_before == null) {
			ipc2_remove_before = ALIA4JSpecializationModule.addTypeConstraint(IPAspect1.ipc1_remove_before(), TypeHierarchyProvider.findOrCreateFromInternalClassName("java/lang/Integer"));
		}
		return ipc2_remove_before;
	}

	public static Set<Specialization> ipc2_remove_after() {
		if (ipc2_remove_after == null) {
			ipc2_remove_after = ALIA4JSpecializationModule.addTypeConstraint(IPAspect1.ipc1_remove_after(), TypeHierarchyProvider.findOrCreateFromInternalClassName("java/lang/Integer"));
		}
		return ipc2_remove_after;
	}

	// the first type argument corresponds to ipc2_type
	private static WeakHashMap<Number, Integer> ipc2_data = new WeakHashMap<Number, Integer>();

	public static Set<Number> ipc2() {
		return Collections.unmodifiableSet(ipc2_data.keySet());
	}
	
	
	public static void ipc2_addInstance(Number instance) {
		if (ipc2_data.containsKey(instance)) {
			ipc2_data.put(instance, ipc2_data.get(instance) + 1 );
		}
		else {
			ipc2_data.put(instance, 1);
		}
		ipc2_instanceAdded(instance);
	}
	
	private static void ipc2_instanceAdded(Number instance) {
	}

	public static void ipc2_removeInstance(Number instance) {
		assert ipc2_data.containsKey(instance);
		assert ipc2_data.get(instance) > 0;
		int newCount = ipc2_data.get(instance) - 1;
		if (newCount == 0)
			ipc2_data.remove(instance);
		else
			ipc2_data.put(instance, newCount);
		ipc2_instanceRemoved(instance);
	}
	
	public pointcut ipc2_add(Number instance) : call(private static void IPAspect2.ipc2_instanceAdded(Number)) && args(instance);
	public pointcut ipc2_remove(Number instance) : call(private static void IPAspect2.ipc2_instanceRemoved(Number)) && args(instance);
	
	private static void ipc2_instanceRemoved(Number instance) {
	}

	private static Attachment ipc2_add_before_attachment;
	private static Attachment ipc2_add_after_attachment;
	private static Attachment ipc2_remove_before_attachment;
	private static Attachment ipc2_remove_after_attachment;

	public static void ipc2_deploy() {
		ipc2_add_before_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc2_add_before(), IPAspect2.class, "ipc2_addInstance", new Class[]{Number.class}, void.class, ScheduleInfo.BEFORE);
		ipc2_add_after_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc2_add_after(), IPAspect2.class, "ipc2_addInstance", new Class[]{Number.class}, void.class, ScheduleInfo.AFTER);
		ipc2_remove_before_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc2_remove_before(), IPAspect2.class, "ipc2_removeInstance", new Class[]{Number.class}, void.class, ScheduleInfo.BEFORE);
		ipc2_remove_after_attachment = ALIA4JAttachmentModule.createStaticAttachment(ipc2_remove_after(), IPAspect2.class, "ipc2_removeInstance", new Class[]{Number.class}, void.class, ScheduleInfo.AFTER);
		
		System.deploy(ipc2_add_before_attachment, ipc2_add_after_attachment, ipc2_remove_before_attachment, ipc2_remove_after_attachment);
	}
	
	public static void ipc2_reset() {
		ipc2_data.clear();
	}

}
