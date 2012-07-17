package pckg;
import java.util.Arrays;
import java.util.Collections;

import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.ActionFactory;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.ScheduleInfo;
import org.alia4j.liam.Specialization;
import org.alia4j.liam.TruePredicate;
import org.alia4j.liam.pattern.FieldWritePattern;
import org.alia4j.liam.signature.ResolutionStrategy;
import org.alia4j.patterns.ClassTypePattern;
import org.alia4j.patterns.ModifiersPattern;
import org.alia4j.patterns.TypePattern;
import org.alia4j.patterns.names.ExactNamePattern;


public class FinalFieldTest {

	public final int x;
	
	public FinalFieldTest() {
		x = 10;
	}
	
	public static void advice(Object target, int value) {
		System.out.println("Write field on " + target + " set value to " + value);
	}
	
	public static void main(String[] args) {
		testSetup3();
		
		FinalFieldTest FFT = new FinalFieldTest();
		
		System.out.println(FFT.x);
	}

	/**
	 * Expected: Error because assignment was prevented
	 */
	private static void testSetup1() {
		FieldWritePattern pattern = new FieldWritePattern(ModifiersPattern.ANY, TypePattern.ANY, ClassTypePattern.ANY, new ExactNamePattern("x"));
		Specialization spec = new Specialization(pattern, TruePredicate.<AtomicPredicate>truePredicate(), Arrays.asList(ContextFactory.findOrCreateCalleeContext(), ContextFactory.findOrCreateArgumentContext(0)));
		Attachment att = new Attachment(Collections.singleton(spec), 
				ActionFactory.findOrCreateMethodCallAction(TypeHierarchyProvider.findOrCreateFromClass(FinalFieldTest.class),
						"advice",
						TypeHierarchyProvider.findOrCreateFromClasses(new Class<?>[]{Object.class, int.class}),
						TypeHierarchyProvider.findOrCreateFromClass(void.class),
						ResolutionStrategy.STATIC),
						ScheduleInfo.AROUND);
		org.alia4j.fial.System.deploy(att);
	}
	
	/**
	 * Expected: error because custom attachment tried to assign
	 */
	private static void testSetup2() {
		FieldWritePattern pattern = new FieldWritePattern(ModifiersPattern.ANY, TypePattern.ANY, ClassTypePattern.ANY, new ExactNamePattern("x"));
		Specialization spec = new Specialization(pattern, TruePredicate.<AtomicPredicate>truePredicate(), Arrays.asList(ContextFactory.findOrCreateCalleeContext(), ContextFactory.findOrCreateArgumentContext(0)));
		Attachment att = new Attachment(Collections.singleton(spec), 
				ActionFactory.findOrCreateFieldWriteAction(TypeHierarchyProvider.findOrCreateFromClass(FinalFieldTest.class),
						"x",
						TypeHierarchyProvider.findOrCreateFromClass(int.class),
						ResolutionStrategy.STATIC),
						ScheduleInfo.BEFORE);
		org.alia4j.fial.System.deploy(att);
	}

	/**
	 * Expected: success
	 */
	private static void testSetup3() {
		FieldWritePattern pattern = new FieldWritePattern(ModifiersPattern.ANY, TypePattern.ANY, ClassTypePattern.ANY, new ExactNamePattern("x"));
		Specialization spec = new Specialization(pattern, TruePredicate.<AtomicPredicate>truePredicate(), Arrays.asList(ContextFactory.findOrCreateCalleeContext(), ContextFactory.findOrCreateArgumentContext(0)));
		Attachment att = new Attachment(Collections.singleton(spec), 
				ActionFactory.findOrCreateMethodCallAction(TypeHierarchyProvider.findOrCreateFromClass(FinalFieldTest.class),
						"advice",
						TypeHierarchyProvider.findOrCreateFromClasses(new Class<?>[]{Object.class, int.class}),
						TypeHierarchyProvider.findOrCreateFromClass(void.class),
						ResolutionStrategy.STATIC),
						ScheduleInfo.BEFORE);
		org.alia4j.fial.System.deploy(att);
	}

}
