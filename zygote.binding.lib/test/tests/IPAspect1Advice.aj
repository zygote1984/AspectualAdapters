package tests;

import java.util.HashSet;
import java.util.Set;

public aspect IPAspect1Advice {
	
	public static Set<Object> addedObjects = new HashSet<Object>();
	public static Set<Object> removedObjects = new HashSet<Object>();
	
	before(Object o) : tests.IPAspect1.ipc1_add(o) {
		addedObjects.add(o);
	}

	before(Object o) : tests.IPAspect1.ipc1_remove(o) {
		removedObjects.add(o);
	}

}
