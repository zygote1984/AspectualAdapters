package org.alia4j.noirin.transform;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransformationSummary {

	private static Map<String, Set<String>> finalFields = new HashMap<String, Set<String>>();
	
	public static void addFinalField(String declaringClass, String fieldName, String fieldType) {
		declaringClass = "L" + declaringClass + ";";
		Set<String> fields = finalFields.get(declaringClass);
		if (fields == null) {
			fields = new HashSet<String>();
			finalFields.put(declaringClass, fields);
		}
		fields.add(fieldName);
	}
	
	public static boolean isFinalField(String declaringClass, String fieldName, String fieldType) {
		Set<String> fields = finalFields.get(declaringClass);
		if (fields == null)
			return false;
		return fields.contains(fieldName);		
	}
}
