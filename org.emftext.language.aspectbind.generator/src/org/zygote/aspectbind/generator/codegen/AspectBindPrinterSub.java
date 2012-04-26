package org.zygote.aspectbind.generator.codegen;

import java.io.IOException;
import java.io.OutputStream;

import org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTextResource;
import org.emftext.language.aspectbind.resource.aspectbind.mopp.AspectbindPrinter;

public class AspectBindPrinterSub extends AspectbindPrinter {

	public AspectBindPrinterSub(OutputStream outputStream,
			IAspectbindTextResource resource) {
		super(outputStream, resource);
		// TODO Auto-generated constructor stub
	}
	
	public void setOutput(OutputStream outputStream)
	{
		super.outputStream  = outputStream;
	}
	
	public void flushStream()
	{
		try {
			super.outputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void print_org_emftext_language_aspectbind_patterns_MethodPattern(org.emftext.language.aspectbind.patterns.MethodPattern element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__COMMENTS));
		printCountingMap.put("comments", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__NAMESPACES));
		printCountingMap.put("namespaces", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__MODIFIERS));
		printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__RETURN_TYPE));
		printCountingMap.put("returnType", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__DECLARING_TYPE));
		printCountingMap.put("declaringType", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		{
			org.eclipse.emf.ecore.EStructuralFeature feature = element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__COMMENTS);
			Object value = element.eGet(feature);
			if (value instanceof java.util.List) {
				for (Object next : (java.util.List<?>) value) {
					out.print(tokenResolverFactory.createCollectInTokenResolver("comments").deResolve(next, feature, element));
				}
			}
		}
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("modifiers");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__MODIFIERS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("modifiers", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("returnType");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__RETURN_TYPE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("returnType", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("declaringType");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__DECLARING_TYPE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("declaringType", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__NAME));
			if (o != null) {
				org.emftext.language.aspectbind.resource.aspectbind.IAspectbindTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.METHOD_PATTERN__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_aspectbind_patterns_MethodPattern_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	public void print_org_emftext_language_aspectbind_patterns_ConstructorPattern(org.emftext.language.aspectbind.patterns.ConstructorPattern element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.CONSTRUCTOR_PATTERN__COMMENTS));
		printCountingMap.put("comments", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.CONSTRUCTOR_PATTERN__NAMESPACES));
		printCountingMap.put("namespaces", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.CONSTRUCTOR_PATTERN__MODIFIERS));
		printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.CONSTRUCTOR_PATTERN__DECLARING_TYPE));
		printCountingMap.put("declaringType", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.CONSTRUCTOR_PATTERN__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		{
			org.eclipse.emf.ecore.EStructuralFeature feature = element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.CONSTRUCTOR_PATTERN__COMMENTS);
			Object value = element.eGet(feature);
			if (value instanceof java.util.List) {
				for (Object next : (java.util.List<?>) value) {
					out.print(tokenResolverFactory.createCollectInTokenResolver("comments").deResolve(next, feature, element));
				}
			}
		}
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("modifiers");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.CONSTRUCTOR_PATTERN__MODIFIERS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("modifiers", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("declaringType");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.CONSTRUCTOR_PATTERN__DECLARING_TYPE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("declaringType", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print("new");
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.aspectbind.patterns.PatternsPackage.CONSTRUCTOR_PATTERN__PARAMETERS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parameters", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_aspectbind_patterns_ConstructorPattern_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}

}
