package tests;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matcher;
import org.junit.BeforeClass;
import org.junit.Test;


public class SimpleTest {

	private static final Number integer1 = new Integer(10);
	private static final Number float1 = new Float(20);
	private static final String string1 = "string";
	private static final Character character1 = 'c';

	@BeforeClass
	public static void setup() {
		IPAspect1.ipc1_deploy();
		IPAspect2.ipc2_deploy();
		IPAspect4.ipc4_deploy();
		IPAspect5.ipc5_deploy();
	}
	
	@Test
	public void adding() {
		IPAspect1.ipc1_reset();
		start(integer1);
		assertThat(IPAspect1.ipc1(), is(asSet(integer1)));
		start(float1);
		assertThat(IPAspect1.ipc1(), is(asSet(integer1, float1)));
	}
	
	private static <T> Set<T> asSet(T... v) {
		return new HashSet<T>(Arrays.asList(v));
	}

	@Test
	public void removing() {
		IPAspect1.ipc1_reset();
		start(integer1);
		start(float1);
		end(integer1);
		assertThat(IPAspect1.ipc1(), is(asSet(float1)));
		end(float1);
		assertThat(IPAspect1.ipc1(), is(Collections.<Number>emptySet()));
	}
	
	@Test
	public void pointcuts() {
		IPAspect1.ipc1_reset();
		start(integer1);
		end(integer1);
		assertThat(IPAspect1Advice.addedObjects, hasItem((Object)integer1)); 
		assertThat(IPAspect1Advice.removedObjects, hasItem((Object)float1)); 
	}
	
	@Test
	public void addingRefined() {
		IPAspect2.ipc2_reset();
		start(integer1);
		assertThat(IPAspect2.ipc2(), is(asSet(integer1)));
		start(float1);
		assertThat(IPAspect2.ipc2(), is(asSet(integer1)));
	}

	@Test
	public void removingRefined() {
		IPAspect2.ipc2_reset();
		start(integer1);
		start(float1);
		end(float1);
		assertThat(IPAspect2.ipc2(), is(asSet(integer1)));
		end(integer1);
		assertThat(IPAspect2.ipc2(), is(Collections.<Number>emptySet()));
	}

	@Test
	public void addingOrOr() {
		IPAspect4.ipc4_reset();
		start(integer1);
		assertThat(IPAspect4.ipc4(), is(asSet((Object) integer1)));
		start(float1);
		assertThat(IPAspect4.ipc4(), is(asSet((Object) integer1, (Object) float1)));
		start2(string1);
		assertThat(IPAspect4.ipc4(), is(asSet((Object) integer1, (Object) float1, (Object) string1)));
		start3(character1);
		assertThat(IPAspect4.ipc4(), is(asSet((Object) integer1, (Object) float1, (Object) string1, (Object) character1)));

		end(integer1);
		assertThat(IPAspect4.ipc4(), is(asSet((Object) float1, (Object) string1, (Object) character1)));
		end(float1);
		assertThat(IPAspect4.ipc4(), is(asSet((Object) string1, (Object) character1)));
		end2(string1);
		assertThat(IPAspect4.ipc4(), is(asSet((Object) character1)));
		end3(character1);
		assertThat(IPAspect2.ipc2(), is(Collections.<Number>emptySet()));
	}

	@Test
	public void removingOrOr() {
		IPAspect2.ipc2_reset();
		start(integer1);
		start(float1);
		end(float1);
		assertThat(IPAspect2.ipc2(), is(asSet(integer1)));
		end(integer1);
		assertThat(IPAspect2.ipc2(), is(Collections.<Number>emptySet()));
	}

	@Test
	public void addingSubset() {
		IPAspect5.ipc5_reset();
		controlflow_start(integer1);
		assertThat(IPAspect2.ipc2(), is(asSet(integer1)));
		start(float1);
		assertThat(IPAspect2.ipc2(), is(asSet(integer1)));
	}

	private static void controlflow_start(Number instance) {start(instance);}
	
	private static void controlflow_end(Number instance) {end(instance);}

	private static void start(Number instance) {}
	
	private static void end(Number instance) {}

	private static void start2(String instance) {}
	
	private static void end2(String instance) {}

	private static void start3(Character instance) {}
	
	private static void end3(Character instance) {}
}
