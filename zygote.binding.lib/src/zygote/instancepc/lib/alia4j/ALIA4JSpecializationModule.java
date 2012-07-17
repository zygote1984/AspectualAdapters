package zygote.instancepc.lib.alia4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.alia4j.aspectj.parser.AJPointcutToLIAMVisitor;
import org.alia4j.aspectj.parser.ast.AJPointcutParser;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.AndPredicate;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.AtomicPredicateFactory;
import org.alia4j.liam.BasicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.Predicate;
import org.alia4j.liam.Specialization;
import org.alia4j.liam.pattern.ConstructorPattern;
import org.alia4j.liam.pattern.FieldReadPattern;
import org.alia4j.liam.pattern.FieldWritePattern;
import org.alia4j.liam.pattern.MethodPattern;
import org.alia4j.liam.pattern.Pattern;
import org.alia4j.liam.pattern.StaticInitializerPattern;
import org.alia4j.util.Pair;

public class ALIA4JSpecializationModule {
	
	
	
	
	
	//TODO use LinkedMap
	public static Set<Specialization> createFromVirtualMethod(AJPointcutParser parser, HashMap<String, Class<? extends Object>> args )
	{
		Set<Specialization> parsedPointcut;

        final Map<String, Pair<Integer, TypeDescriptor>> argName2IndexType = new HashMap<String, Pair<Integer,TypeDescriptor>>();
        Iterator<Entry<String, Class<? extends Object>>> it = args.entrySet().iterator();

        int count = 0;
        while(it.hasNext())
        {
        	Entry<String, Class<? extends Object>> pairs = (Entry<String, Class<? extends Object>>)it.next();
        	argName2IndexType.put(pairs.getKey(), new Pair<Integer, TypeDescriptor>(count, TypeHierarchyProvider.findOrCreateFromClass(pairs.getValue())));
        	count++;
        }
        
		try {
			parsedPointcut =
                            (Set<Specialization>) parser.getTreeRoot().jjtAccept(
                                            new AJPointcutToLIAMVisitor(argName2IndexType, ContextFactory.findOrCreateObjectConstantContext(null)),
                                            null);
        } catch (final Exception e) {
        	e.printStackTrace();
            throw new RuntimeException("Cannot create specialization");
        }
		return parsedPointcut;
	}
	
	
	public static Set<Specialization> createFromVirtualMethod(AJPointcutParser parser, Class<? extends Object> args )
	{
		Set<Specialization> parsedPointcut;

        final Map<String, Pair<Integer, TypeDescriptor>> argName2IndexType = new HashMap<String, Pair<Integer,TypeDescriptor>>();

    
        argName2IndexType.put(args.getName(), new Pair<Integer, TypeDescriptor>(0, TypeHierarchyProvider.findOrCreateFromClass(args)));
        
        
		try {
			parsedPointcut =
                            (Set<Specialization>) parser.getTreeRoot().jjtAccept(
                                            new AJPointcutToLIAMVisitor(argName2IndexType, ContextFactory.findOrCreateObjectConstantContext(null)),
                                            null);
        } catch (final Exception e) {
        	e.printStackTrace();
            throw new RuntimeException("Cannot create specialization");
        }
		return parsedPointcut;
	}
	
	
	public static Set<Specialization> createFromStaticMethod(AJPointcutParser parser, Class<? extends Object> args )
	{
		Set<Specialization> parsedPointcut;

        final Map<String, Pair<Integer, TypeDescriptor>> argName2IndexType = new HashMap<String, Pair<Integer,TypeDescriptor>>();

    
        argName2IndexType.put(args.getName(), new Pair<Integer, TypeDescriptor>(0, TypeHierarchyProvider.findOrCreateFromClass(args)));
        
        
		try {
			parsedPointcut =
                            (Set<Specialization>) parser.getTreeRoot().jjtAccept(
                                            new AJPointcutToLIAMVisitor(argName2IndexType, ContextFactory.findOrCreateObjectConstantContext(null)),
                                            null);
        
			Specialization specialization = parsedPointcut.iterator().next();
			List<Context> newList = new ArrayList<Context>();
			newList.addAll(specialization.getContexts());
			newList.remove(0);
			Specialization newSpecialization = new Specialization(specialization.getPattern(), specialization.getPredicate(), newList);
			parsedPointcut = Collections.singleton(newSpecialization);
        } catch (final Exception e) {
        	e.printStackTrace();
            throw new RuntimeException("Cannot create specialization");
        }
		return parsedPointcut;
	}
	
	
	
	public static Set<Specialization> createFromStaticMethod(AJPointcutParser parser, HashMap<String, Class<? extends Object>> args )
	{
		Set<Specialization> parsedPointcut;

        final Map<String, Pair<Integer, TypeDescriptor>> argName2IndexType = new HashMap<String, Pair<Integer,TypeDescriptor>>();
        Iterator<Entry<String, Class<? extends Object>>> it = args.entrySet().iterator();

        while(it.hasNext())
        {
        	Entry<String, Class<? extends Object>> pairs = (Entry<String, Class<? extends Object>>)it.next();
        	argName2IndexType.put(pairs.getKey(), new Pair<Integer, TypeDescriptor>(0, TypeHierarchyProvider.findOrCreateFromClass(pairs.getValue())));
        }
        
		try {
			parsedPointcut =
                            (Set<Specialization>) parser.getTreeRoot().jjtAccept(
                                            new AJPointcutToLIAMVisitor(argName2IndexType, ContextFactory.findOrCreateObjectConstantContext(null)),
                                            null);
			
			Specialization specialization = parsedPointcut.iterator().next();
			List<Context> newList = new ArrayList<Context>();
			newList.addAll(specialization.getContexts());
			newList.remove(0);
			Specialization newSpecialization = new Specialization(specialization.getPattern(), specialization.getPredicate(), newList);
			parsedPointcut = Collections.singleton(newSpecialization);
        } catch (final Exception e) {
        	e.printStackTrace();
            throw new RuntimeException("Cannot create specialization");
        }
		return parsedPointcut;
	}
	
	public static Pair<Set<Specialization>, Set<Specialization>> andIPRef(Set<Specialization> before1, Set<Specialization> after1, Set<Specialization> before2, Set<Specialization> after2) {
		Set<Specialization> newBefore = andSpecializations(before1, before2);
		Set<Specialization> newAfter = andSpecializations(before1, before2);
		return new Pair<Set<Specialization>, Set<Specialization>>(newBefore, newAfter);
	}
	
	public static Pair<Set<Specialization>, Set<Specialization>> orIPRef(Set<Specialization> before1, Set<Specialization> after1, Set<Specialization> before2, Set<Specialization> after2) {
		Set<Specialization> newBefore = orSpecializations(before1, before2);
		Set<Specialization> newAfter = orSpecializations(before1, before2);
		return new Pair<Set<Specialization>, Set<Specialization>>(newBefore, newAfter);
	}
	
	private static Set<Specialization> andSpecializations(
			Set<Specialization> specs1, Set<Specialization> specs2) {
		Set<Specialization> result = new HashSet<Specialization>();
		for (Specialization specialization1 : specs1) {
			for (Specialization specialization2 : specs2) {
				Specialization and = andSpecialization(specialization1, specialization2);
				if (and != null)
					result.add(and);
			}
		}
		return result;
	}


	private static Set<Specialization> orSpecializations(Set<Specialization> specs1, Set<Specialization> specs2)
	{
		Set<Specialization> result = new HashSet<Specialization>();
		result.addAll(specs1);
		result.addAll(specs2);
		return result;
	}
	
	private static Specialization andSpecialization(
			Specialization specialization1, Specialization specialization2) {
		assert Arrays.equals(
				specialization1.getContexts().toArray(),
				specialization2.getContexts().toArray());
		
		if (specialization1.getPattern().getClass() != specialization2.getPattern().getClass())
			return null;
		
		final Pattern<?> newPattern;
		if (specialization1.getPattern() instanceof MethodPattern) {
			MethodPattern mpattern1 = (MethodPattern) specialization1.getPattern();
			MethodPattern mpattern2 = (MethodPattern) specialization1.getPattern();
			
			newPattern = new MethodPattern(
					mpattern1.getModifiersPattern().and(mpattern2.getModifiersPattern()),
					mpattern1.getReturnTypePattern().and(mpattern2.getReturnTypePattern()),
					mpattern1.getDeclaringClassPattern().and(mpattern2.getDeclaringClassPattern()),
					mpattern1.getNamePattern().and(mpattern2.getNamePattern()),
					mpattern1.getParametersPattern().and(mpattern2.getParametersPattern()),
					mpattern1.getExceptionsPattern().and(mpattern2.getExceptionsPattern()));
		}
		else if (specialization1.getPattern() instanceof FieldReadPattern) {
			FieldReadPattern mpattern1 = (FieldReadPattern) specialization1.getPattern();
			FieldReadPattern mpattern2 = (FieldReadPattern) specialization1.getPattern();
			newPattern = new FieldReadPattern(mpattern1.getModifiersPattern().and(mpattern2.getModifiersPattern()),
							mpattern1.getTypePattern().and(mpattern2.getTypePattern()),
							mpattern1.getDeclaringClassPattern().and(mpattern2.getDeclaringClassPattern()),
							mpattern1.getNamePattern().and(mpattern2.getNamePattern()));
		}
		else if (specialization1.getPattern() instanceof FieldWritePattern) {
			FieldWritePattern mpattern1 = (FieldWritePattern) specialization1.getPattern();
			FieldWritePattern mpattern2 = (FieldWritePattern) specialization1.getPattern();
			newPattern = new FieldWritePattern(mpattern1.getModifiersPattern().and(mpattern2.getModifiersPattern()),
					mpattern1.getTypePattern().and(mpattern2.getTypePattern()),
					mpattern1.getDeclaringClassPattern().and(mpattern2.getDeclaringClassPattern()),
					mpattern1.getNamePattern().and(mpattern2.getNamePattern()));
		}
		else if (specialization1.getPattern() instanceof ConstructorPattern) {
			ConstructorPattern mpattern1 = (ConstructorPattern) specialization1.getPattern();
			ConstructorPattern mpattern2 = (ConstructorPattern) specialization1.getPattern();
			newPattern = new ConstructorPattern(
					mpattern1.getModifiersPattern().and(mpattern2.getModifiersPattern()),
					mpattern1.getDeclaringClassPattern().and(mpattern2.getDeclaringClassPattern()),
					mpattern1.getParametersPattern().and(mpattern2.getParametersPattern()),
					mpattern1.getExceptionsPattern().and(mpattern2.getExceptionsPattern()));
		}
		else if (specialization1.getPattern() instanceof StaticInitializerPattern) {
			StaticInitializerPattern mpattern1 = (StaticInitializerPattern) specialization1.getPattern();
			StaticInitializerPattern mpattern2 = (StaticInitializerPattern) specialization1.getPattern();
			newPattern = new StaticInitializerPattern(
					mpattern1.getDeclaringClassPattern().and(mpattern2.getDeclaringClassPattern()));
		}
		else {
			throw new UnsupportedOperationException("should not be reached");
		}
	
		Predicate<AtomicPredicate> newPredicate = new AndPredicate<AtomicPredicate>(specialization1.getPredicate(), specialization2.getPredicate());
		Specialization result = new Specialization(newPattern, newPredicate, specialization1.getContexts());
		return result;
	}


	public static Set<Specialization> addTypeConstraint(
			Set<Specialization> parsedPointcut,
			TypeDescriptor expectedType) {
		Set<Specialization> result = new HashSet<Specialization>();
		for (Specialization specialization : parsedPointcut) {
			Predicate<AtomicPredicate> predicate = specialization.getPredicate();
			for (Context context : specialization.getContexts()) {
				predicate = new AndPredicate<AtomicPredicate>(predicate, new BasicPredicate<AtomicPredicate>(AtomicPredicateFactory.findOrCreateInstanceofPredicate(context, expectedType), true));
			}
			result.add(new Specialization(specialization.getPattern(), predicate, specialization.getContexts()));
		}
		return result;
	}


	
	

}
