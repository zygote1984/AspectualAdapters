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

	private final Number n1 = new Integer(10);
	private final Number n2 = new Float(20);

	@BeforeClass
	public static void setup() {
		IPAspect1.ipc1_deploy();
	}
	
	@Test
	public void adding() {
		IPAspect1.ipc1_reset();
		start(n1);
		assertThat(IPAspect1.ipc1(), is(asSet(n1)));
		start(n2);
		assertThat(IPAspect1.ipc1(), is(asSet(n1, n2)));
	}
	
	private static <T> Set<T> asSet(T... v) {
		return new HashSet<T>(Arrays.asList(v));
	}

	@Test
	public void removing() {
		IPAspect1.ipc1_reset();
		start(n1);
		start(n2);
		end(n1);
		assertThat(IPAspect1.ipc1(), is(asSet(n2)));
		end(n2);
		assertThat(IPAspect1.ipc1(), is(Collections.<Number>emptySet()));
	}
	
	@Test
	public void pointcuts() {
		IPAspect1.ipc1_reset();
		start(n1);
		end(n1);
		assertThat(IPAspect1Advice.addedObjects, hasItem((Object)n1)); 
		assertThat(IPAspect1Advice.removedObjects, hasItem((Object)n2)); 
	}

	private static void start(Object instance) {}
	
	private static void end(Object instance) {}

}
