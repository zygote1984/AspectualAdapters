package org.alia4j.noirin.xml.read;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.Action;
import org.alia4j.liam.ActionTime;
import org.alia4j.liam.AndPredicate;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.BasicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.DebugInfo;
import org.alia4j.liam.OrPredicate;
import org.alia4j.liam.PrecedenceRule;
import org.alia4j.liam.Predicate;
import org.alia4j.liam.ScheduleInfo;
import org.alia4j.liam.Specialization;
import org.alia4j.liam.pattern.ConstructorPattern;
import org.alia4j.liam.pattern.FieldReadPattern;
import org.alia4j.liam.pattern.FieldWritePattern;
import org.alia4j.liam.pattern.MethodPattern;
import org.alia4j.liam.pattern.Pattern;
import org.alia4j.noirin.debug.data.DebugDataStore;
import org.alia4j.patterns.ClassTypePattern;
import org.alia4j.patterns.ExceptionsPattern;
import org.alia4j.patterns.ModifiersPattern;
import org.alia4j.patterns.NamePattern;
import org.alia4j.patterns.ParametersPattern;
import org.alia4j.patterns.TypePattern;
import org.alia4j.patterns.exceptions.ExactExceptionsPattern;
import org.alia4j.patterns.exceptions.ExceptionsPatternElement;
import org.alia4j.patterns.exceptions.WildcardExceptionsPattern;
import org.alia4j.patterns.modifiers.WildcardModifiersPattern;
import org.alia4j.patterns.names.ExactNamePattern;
import org.alia4j.patterns.names.IdentifierElement;
import org.alia4j.patterns.names.IdentifierWildcard;
import org.alia4j.patterns.names.NameElement;
import org.alia4j.patterns.names.WildcardNamePattern;
import org.alia4j.patterns.parameters.ParametersPatternElement;
import org.alia4j.patterns.parameters.ParametersRest;
import org.alia4j.patterns.parameters.TypePatternElement;
import org.alia4j.patterns.parameters.WildcardParametersPattern;
import org.alia4j.patterns.types.ExactClassTypePattern;
import org.alia4j.patterns.types.ExactTypePattern;
import org.alia4j.patterns.types.NamePatternElement;
import org.alia4j.patterns.types.NamespaceElement;
import org.alia4j.patterns.types.WildcardTypePattern;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

@SuppressWarnings({"unchecked", "rawtypes"})
public class Xml2LiamModel_Reader {
	static{
		LiamDefaultFactory.initialize();
	}
	
	public static void main(String [] args) {
		//use your own path here
		String localPath = "D:\\ecStudio\\runtime-New_configuration\\Example\\bin\\LiamInfo.xml";
		Xml2LiamModel_Reader rd = new Xml2LiamModel_Reader(localPath);
		rd.intercept();
		List<Attachment> attachmentList = rd.getAttachmentList();
		List<PrecedenceRule> precedenceList = rd.getPrecedenceRules();
		System.out.println("Done");
	}
	
	private Document doc;
	private List<Context> contexts;
	private List<String> unitNameList;
	private Map<String, List<String>> importClassesMap;
	private Map<String, List<String>> importPackagesMap;
	private String currentSource;
	private Map<String, Set<Attachment>> attachmentMap;
	private List<Attachment> attachmentList;
	private List<PrecedenceRule> precedenceRuleList;
	
	public Xml2LiamModel_Reader(String fileName) {
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read(new File(fileName));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		this.unitNameList = new LinkedList<String>();
		this.importClassesMap = new HashMap<String, List<String>>();
		this.importPackagesMap = new HashMap<String, List<String>>();
		this.attachmentList = new LinkedList<Attachment>();
		this.precedenceRuleList = new LinkedList<PrecedenceRule>();
		this.attachmentMap = new HashMap<String, Set<Attachment>>();
	}
	
	private void setSourceRoots(String text) {
		String[] sourceRoots = text.split(",");
		DebugDataStore.s().setSourceRoot(sourceRoots[0]);	
	}
	
	private DebugInfo getDebugInfo(Element ele) {
		try{
			String source = ele.attributeValue("source");
			String file = ele.attributeValue("file");
			int startLine = Integer.valueOf(ele.attributeValue("line"));
			int endLine = Integer.valueOf(ele.attributeValue("endLine"));
			
			StringBuffer sb = new StringBuffer();
			int lastDot = source.lastIndexOf('.');
			if(lastDot >=0 ) {
				sb.append(source.substring(0, lastDot));
			} else {
				sb.append(source);
			}
			sb.append("\\").append(file);
			DebugInfo di = new DebugInfo(sb.toString(), startLine, endLine);
			Attribute attr = ele.attribute("sourcePattern");
			if(attr!=null) {
				di.setSourceString(attr.getText());
			}
			return di;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return DebugInfo.UNKNOWN_INFO;
	}
	
	public List<Attachment> getAttachmentList() {
		return this.attachmentList;
	}
	
	public List<PrecedenceRule> getPrecedenceRules() {
		return this.precedenceRuleList;
	}
	
	public void intercept() {
		Element root = doc.getRootElement();	//this is liamModel element
		setSourceRoots(root.attribute("sourceRoots").getText());
		
		interceptImports(root);
		interceptAttachments(root);
		interceptPrecedences(root);
	}

	private void interceptImports(Element parent) {
		List<Element> importElms = parent.elements("import");
		for(Element elm : importElms) {
			String source = elm.attribute("source").getText();
			this.unitNameList.add(source);
			List<String> importClasses = this.importClassesMap.get(source);
			if(importClasses==null) {
				importClasses = new LinkedList<String>();
			}
			List<Element> classes = elm.elements("class");
			for(Element clsElm : classes) {
				importClasses.add(clsElm.getText());
			}
			this.importClassesMap.put(source, importClasses);
			
			List<String> importPackages = this.importPackagesMap.get(source);
			if(importPackages==null) {
				importPackages = new LinkedList<String>();
			}
			elm.elements("package");
			List<Element> packages = elm.elements("package");
			for(Element pkgElm : packages) {
				importPackages.add(pkgElm.getText());
			}
			this.importPackagesMap.put(source, importPackages);
		}
	}
	
	private void interceptAttachments(Element root) {
		List<Element> attaElms = root.elements("attachment");
		
		for(Element atta : attaElms) {
			contexts = new LinkedList<Context>();
			Attachment attachment = interceptAttachment(atta);
			DebugDataStore.s().putDebugInfo(attachment, getDebugInfo(atta));
			attachmentList.add(attachment);
			
			String sourceName = atta.attribute("source").getValue();
			Set<Attachment> atmtSet = attachmentMap.get(sourceName);
			if(atmtSet == null) {
				atmtSet = new HashSet<Attachment>();
			}
			atmtSet.add(attachment);
			attachmentMap.put(sourceName, atmtSet);
		}	
	}
	
	private void interceptPrecedences(Element root) {
		List<Element> pdElms = root.elements("precedence");
		for(Element pd : pdElms) {
			List<Element> ruleElms = pd.elements("rule");
			for(Element rule : ruleElms) {
				interceptPrecedence(rule);
			}
		}
	}
	
	private void interceptPrecedence(Element parent) {
		String rulePattern = parent.getText();
		String[] patterns = rulePattern.split(",");
		List<String> proceedingPatternList = new LinkedList<String>();
		List<String> proceededPatternList = new LinkedList<String>();
		boolean metWildcard = false;
		for(int i=0; i<patterns.length; i++) {
			if(patterns[i].trim().equals("*")) {
				metWildcard = true;
			} else {
				if(!metWildcard) {
					proceedingPatternList.add(findFQN(patterns[i]));
				} else {
					proceededPatternList.add(findFQN(patterns[i]));
				}
			}
		}
		
		if(!metWildcard) {
			addPrecedenceRules(proceedingPatternList);
		} else {
			Set<Attachment> restProceededAttachmentSet = new HashSet<Attachment>();
			for(String fqn : this.unitNameList) {
				if(!proceedingPatternList.contains(fqn)) {
					restProceededAttachmentSet.addAll(this.attachmentMap.get(fqn));
				}
			}
			addPrecedenceRules(proceedingPatternList);
			if(proceedingPatternList.size()>0) {
				this.precedenceRuleList.add(new PrecedenceRule(
						this.attachmentMap.get(proceedingPatternList.get(proceedingPatternList.size()-1)),
						restProceededAttachmentSet));
			}
			
			Set<Attachment> restProceedingAttachmentSet = new HashSet<Attachment>();
			for(String fqn : this.unitNameList) {
				if(!proceededPatternList.contains(fqn)) {
					restProceedingAttachmentSet.addAll(this.attachmentMap.get(fqn));
				}
			}
			if(proceededPatternList.size()>0) {
				this.precedenceRuleList.add(new PrecedenceRule(
						restProceedingAttachmentSet,
						this.attachmentMap.get(proceededPatternList.get(0))));
			}
			addPrecedenceRules(proceededPatternList);
		}
		
	}
	
	private void addPrecedenceRules(List<String> patternList) {
		for(int i=0; i<patternList.size()-1; i++) {
			Set<Attachment> proceeding = this.attachmentMap.get(patternList.get(i));
			Set<Attachment> proceeded = this.attachmentMap.get(patternList.get(i+1));
			this.precedenceRuleList.add(new PrecedenceRule(proceeding, proceeded));
		}
	}

	private String findFQN(String name) {
		name = name.trim();
		if(name.indexOf(".") > 0) {
			return name;
		} else {
			for(String fqn : this.unitNameList) {
				if(fqn.endsWith(name)) {
					return fqn;
				}
			}
		}
		return "null";
	}

	private Attachment interceptAttachment(Element parent) {
		List<Element> specElms = parent.elements("specialization");
		Set<Specialization> specSet = new HashSet<Specialization>();
		for(Element spec : specElms) {
			specSet.add(interceptSpecialization(spec));
		}
		
		Element actElm = parent.element("action");
		Action action = (Action)LiamFactory.getObject(actElm);
		DebugDataStore.s().putDebugInfo(action, getDebugInfo(actElm));
		
		String actionClassName = actElm.element("declaringClassName").getText();
		contexts.add(0, LiamFactory.getTargetContext(null, actionClassName));
		
		Element scheElm = parent.element("scheduleInfo");
		ScheduleInfo scheduleInfo = interceptScheduleInfo(scheElm);
		
		return new Attachment(specSet, action, scheduleInfo, DebugInfo.UNKNOWN_INFO);
	}
	
	private Specialization interceptSpecialization(Element parent) {
		Element ptnElm = parent.element("pattern");
		Pattern pattern = interceptPattern(ptnElm);
		DebugDataStore.s().putDebugInfo(pattern, getDebugInfo(ptnElm));
		
		Element biPredElm = parent.element("predicate");
		Element atPredElm = parent.element("atomicPredicate");
		
		Predicate predicate = null;
		if(biPredElm!=null) {
			predicate = interceptPredicate(biPredElm);
		} else if(atPredElm!=null) {
			predicate = interceptPredicate(atPredElm);
		}
		
		List<Element> ctxElms = parent.elements("context");
		
		for(Element ctx : ctxElms) {
			contexts.add((Context)LiamFactory.getObject(ctx));
		}
		return new Specialization(pattern, predicate, contexts);
	}
	
	//**************************************** Pattern ****************************************//
	private Pattern interceptPattern(Element parent) {
		this.currentSource = parent.attribute("source").getText();
		Element modifiersElm = parent.element("modifiersPattern");
		ModifiersPattern modiPtn = 
			modifiersElm == null ? null : interceptModifiersPattern(modifiersElm);
		
		Element typeElm = parent.element("typePattern");
		TypePattern typePtn = 
			typeElm == null ? null : interceptTypePattern(typeElm);
		
		Element classTypeElm = parent.element("classTypePattern");
		ClassTypePattern clsTpPtn = 
			classTypeElm == null ? null : interceptClassTypePattern(classTypeElm);
		
		Element nameElm = parent.element("namePattern");
		NamePattern namePtn = 
			nameElm == null ? null : interceptNamePattern(nameElm);
		
		Element paraElm = parent.element("parametersPattern");
		ParametersPattern parasPtn = 
			paraElm == null ? null : interceptParametersPattern(paraElm);
		
		Element exptElm = parent.element("exceptionsPattern");
		ExceptionsPattern exptsPtn = 
			exptElm == null ? null : interceptExceptionsPattern(exptElm);
		
		String patternTypeName = parent.attribute("type").getValue();
		Pattern pattern = null;
		if(patternTypeName.equals("methodPattern")) {
			pattern = new MethodPattern(modiPtn, typePtn, clsTpPtn, namePtn, parasPtn, exptsPtn);
		} else if(patternTypeName.equals("fieldReadPattern")) {
			pattern = new FieldReadPattern(modiPtn, typePtn, clsTpPtn, namePtn);
		} else if(patternTypeName.equals("fieldWritePattern")) {
			pattern = new FieldWritePattern(modiPtn, typePtn, clsTpPtn, namePtn);
		} else if(patternTypeName.equals("constructorPattern")) {
			pattern = new ConstructorPattern(modiPtn, clsTpPtn, parasPtn, exptsPtn);
		} 
		return pattern;
	}
	
	private ModifiersPattern interceptModifiersPattern(Element parent) {
		ModifiersPattern pattern = null;
		int count = Integer.parseInt(parent.attribute("count").getText());
		if(count == 0) {
			pattern = ModifiersPattern.ANY;
		} else {
			List<Element> children = parent.elements();
			int patternNum = 0;
			for(Element child : children) {
				String singlePattern = child.getText();
				//TODO: and, or, not
				if(singlePattern.equals("public")) {
					patternNum |= WildcardModifiersPattern.PUBLIC;
				} else if(singlePattern.equals("protected")) {
					patternNum |= WildcardModifiersPattern.PROTECTED;
				} else if(singlePattern.equals("private")) {
					patternNum |= WildcardModifiersPattern.PRIVATE;
				} else if(singlePattern.equals("*")) {
					pattern = WildcardModifiersPattern.ANY;
				}
			}
			if(pattern == null)
				pattern = new WildcardModifiersPattern(patternNum);
		}
		return pattern;
	}

	private TypePattern interceptTypePattern(Element parent) {
		TypePattern pattern = null;
		Attribute biAttr = parent.attribute("binary");
		if(biAttr != null) {
			String biText = biAttr.getText();
			TypePattern ltp = interceptTypePattern((Element) parent.elements().get(0));
			TypePattern rtp = interceptTypePattern((Element) parent.elements().get(1));
			if(biText.equals("AND")) {
				pattern = ltp.and(rtp);
			} else {
				pattern = ltp.or(rtp);
			}
		} else {
			String typeText = parent.getText();
			if(typeText.equals("*")) {
				pattern = TypePattern.ANY;
			} else if(typeText.indexOf("*")<0) {
				if(typeText.equals("boolean") || 
						typeText.equals("byte") ||
						typeText.equals("short") ||
						typeText.equals("int") ||
						typeText.equals("long") ||
						typeText.equals("float") ||
						typeText.equals("double") ||
						typeText.equals("char") ||
						typeText.equals("void")) {
					pattern = new ExactTypePattern(LiamFactory.getTypeDescriptor(typeText));
				} else {
					pattern = interceptClassTypePatternWithImports(typeText);
				}
			}
		}
		return pattern;
	}

	private ClassTypePattern interceptClassTypePattern(Element parent) {
		String clsTpText = parent.getText();
		ClassTypePattern pattern = null;
		if(clsTpText.equals("*")) {
			pattern = ClassTypePattern.ANY;
		} else if (clsTpText.indexOf("*")>=0) { 
			String[] typeParts = clsTpText.split("\\.");
			List<NamespaceElement> nameElmList = new ArrayList<NamespaceElement>();
			for(String typePart : typeParts) {
				nameElmList.add(new NamePatternElement(interceptNamePattern(typePart)));
			}
			pattern = new WildcardTypePattern(nameElmList);
		} else if (clsTpText.indexOf("*")<0) {
			if(clsTpText.indexOf(".")>=0) {
				pattern = new ExactClassTypePattern(LiamFactory.getTypeDescriptor(clsTpText));
			} else {
				pattern = interceptClassTypePatternWithImports(clsTpText);
			}
		} else {
			
		}
		return pattern;
	}
	
	private ClassTypePattern interceptClassTypePatternWithImports(String classTypeName) {
		ClassTypePattern pattern = null;
		List<String> importClasses = this.importClassesMap.get(this.currentSource);
		for(String className : importClasses) {
			if(className.endsWith(classTypeName)) {
				if(pattern == null) {
					pattern = new ExactClassTypePattern(LiamFactory.getTypeDescriptor(className));
				} else {
					pattern = pattern.or(new ExactClassTypePattern(LiamFactory.getTypeDescriptor(className)));
				}
			}
		}
		List<String> importPackages = this.importPackagesMap.get(this.currentSource);
		for(String packageName : importPackages) {
			String fqnClassName = packageName + "." + classTypeName;
			if(pattern == null) {
				pattern = new ExactClassTypePattern(LiamFactory.getTypeDescriptor(fqnClassName));
			} else {
				pattern = pattern.or(new ExactClassTypePattern(LiamFactory.getTypeDescriptor(fqnClassName)));
			}
		}
		return pattern;
	}
	
	private NamePattern interceptNamePattern(Element parent) {
		String nameText = parent.getText();
		return interceptNamePattern(nameText);
	}
	
	private NamePattern interceptNamePattern(String nameText) {
		NamePattern pattern = null;
		if(nameText.equals("*")) {
			pattern = NamePattern.ANY;
		} else if(nameText.indexOf("*")<0) {
			pattern = new ExactNamePattern(nameText);
		} else if(nameText.indexOf("*")>=0) {
			String[] nameParts = nameText.split("\\*");
			List<NameElement> nameElmList = new ArrayList<NameElement>();
			if(nameText.charAt(0) == '*') {
				nameElmList.add(IdentifierWildcard.INSTANCE);
			}
			for(String namePart : nameParts) {
				nameElmList.add(new IdentifierElement(namePart));
				nameElmList.add(IdentifierWildcard.INSTANCE);
			}
			if(!nameText.endsWith("*")) {
				nameElmList.remove(nameElmList.size()-1);
			}
			pattern = new WildcardNamePattern(nameElmList);
		}
		return pattern;
	}
	

	private ParametersPattern interceptParametersPattern(Element parent) {

		List<Element> children = parent.elements();
		List<ParametersPatternElement> paraPtnList = new ArrayList<ParametersPatternElement>();
		for(Element child : children) {
			paraPtnList.add(interceptParameterPattern(child));
		}
		ParametersPattern pattern = new WildcardParametersPattern(paraPtnList);
		return pattern;
	}
	
	private ParametersPatternElement interceptParameterPattern(Element parent) {
		ParametersPatternElement pattern = null;
		String paraText = parent.getText();
		if(paraText.equals("..")) {
			pattern = ParametersRest.INSTANCE;
		} else {
			pattern = new TypePatternElement(interceptTypePattern(parent));
		}
		return pattern;
	}
	
	private ExceptionsPattern interceptExceptionsPattern(Element parent) {
		ExceptionsPattern pattern = null;
		List<Element> children = parent.elements();
		if(children.size()==0) {
			pattern = new ExactExceptionsPattern(new TypeDescriptor[0]);
		} else {
			List<ExceptionsPatternElement> exptPtnList = new ArrayList<ExceptionsPatternElement>();
			for(Element child : children) {
				exptPtnList.add(interceptExceptionPattern(child));
			}
			pattern = new WildcardExceptionsPattern(exptPtnList);
		}
		return pattern;
	}
	
	private ExceptionsPatternElement interceptExceptionPattern(Element child) {
		// TODO Auto-generated method stub
		return null;
	}

	//**************************************** Pattern ****************************************//
	
	
	private Predicate interceptPredicate(Element parent) {
		String parentName = parent.getName();
		Attribute posAttr = parent.attribute("positive");
		Boolean positive = posAttr==null ? true : Boolean.valueOf(posAttr.getValue());
		Predicate predicate = null;
		if(parentName.equals("atomicPredicate")) {
			AtomicPredicate atomicPredicate = (AtomicPredicate) LiamFactory.getObject(parent);
			DebugDataStore.s().putDebugInfo(atomicPredicate, getDebugInfo(parent));
			predicate = new BasicPredicate(atomicPredicate, positive);
		} else {	//parentName.equals("predicate")
			String predType = parent.attribute("binary").getText();
			List<Element> operands = parent.elements();
			Predicate left = interceptPredicate(operands.get(0));
			Predicate right = interceptPredicate(operands.get(1));
			if(predType.equals("AND")) {
				predicate = new AndPredicate(left, right);
			} else {	// predType.equals("OR")
				predicate = new OrPredicate(left, right);
			}
		}
		return predicate;
	}
	
	private ScheduleInfo interceptScheduleInfo(Element parent) {
		String atText = parent.element("actionTime").getText();
//		String srText = parent.element("skipRule").getText();
		ActionTime at = ActionTime.valueOf(atText);
//		SkipRule sr = SkipRule.valueOf(srText);
		
		return ScheduleInfo.findScheduleInfo(at);
	}

}
