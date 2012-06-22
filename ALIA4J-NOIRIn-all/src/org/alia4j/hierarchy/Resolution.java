package org.alia4j.hierarchy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Resolution {
    
    /**
     * @see <a href="http://java.sun.com/docs/books/jvms/second_edition/html/ConstantPool.doc.html#71685">5.4.3.2 Field
     *      Resolution</a>
     */
    public static Field resolveField(final Class<?> dynamicReceiverType, final CharSequence name,
                    final TypeDescriptor fieldType) {
        if (dynamicReceiverType == null)
            return null; // Exhausted super class chain
            
        // 1. If c declares a field with the name and descriptor specified by the field reference, field lookup succeeds. The
        // declared field is the result of the field lookup.
        
        for (final Field field : dynamicReceiverType.getDeclaredFields()) {
            if (field.getName().contentEquals(name)
                            && fieldType.equals(TypeHierarchyProvider.findOrCreateFromClass(field.getType())))
                return field;
        }
        
        // 2. Otherwise, field lookup is applied recursively to the direct superinterfaces of the specified class or
        // interface c.
        
        for (final Class<?> superInterface : dynamicReceiverType.getInterfaces()) {
            final Field field = Resolution.resolveField(superInterface, name, fieldType);
            if (field != null)
                return field;
        }
        
        // 3. Otherwise, if c has a superclass s, field lookup is applied recursively to s.
        
        final Class<?> s = dynamicReceiverType.getSuperclass();
        final Field field = Resolution.resolveField(s, name, fieldType);
        if (field != null)
            return field;
        
        // 4. Otherwise, field lookup fails.
        
        return null;
    }
    
    /**
     * This method must only be used for virtual methods, it does not return private or static methods.
     * 
     * @see <a href="http://java.sun.com/docs/books/jvms/second_edition/html/ConstantPool.doc.html#86899">5.4.3.3 Method
     *      Resolution</a>
     */
    public static Method resolveTopMethod(final Class<?> dynamicReceiverType, final CharSequence name,
                    final TypeDescriptor returnType, final TypeDescriptor[] parameterTypes) {
        
        // Search superclasses first
        if (dynamicReceiverType.getSuperclass() != null) {
            Method method =
                            Resolution.resolveTopMethod(dynamicReceiverType.getSuperclass(), name, returnType,
                                            parameterTypes);
            if (method != null)
                return method;
        }
        
        // If the method was not found in the super classes, search in this class
        for (final Method method : dynamicReceiverType.getDeclaredMethods()) {
            if (method.getName().contentEquals(name)
                            && TypeHierarchyProvider.findOrCreateFromClass(method.getReturnType()).equals(returnType)
                            && Arrays.equals(TypeHierarchyProvider.findOrCreateFromClasses(method.getParameterTypes()),
                                            parameterTypes)
                            && (method.getModifiers() & (Modifier.PRIVATE | Modifier.STATIC)) == 0)
                return method;
        }
        
        // Method was not found in super classes and this class
        return null;
    }
    
    /**
     * @see <a href="http://java.sun.com/docs/books/jvms/second_edition/html/ConstantPool.doc.html#86899">5.4.3.3 Method
     *      Resolution</a>
     */
    public static Member resolveActualMethod(Class<?> lookUpReceiverType, CharSequence name, TypeDescriptor returnType,
                    TypeDescriptor[] parameterTypes) {
        
        // First search in this class
        for (final Method method : lookUpReceiverType.getDeclaredMethods()) {
            if (method.getName().contentEquals(name)
                            && TypeHierarchyProvider.findOrCreateFromClass(method.getReturnType()).equals(returnType)
                            && Arrays.equals(TypeHierarchyProvider.findOrCreateFromClasses(method.getParameterTypes()),
                                            parameterTypes))
                return method;
        }
        
        // If the method was not found in this class, search superclasses last
        if (lookUpReceiverType.getSuperclass() != null) {
            Member method =
                            Resolution.resolveActualMethod(lookUpReceiverType.getSuperclass(), name, returnType,
                                            parameterTypes);
            if (method != null)
                return method;
        }
        
        // Method was not found in super classes and this class
        return null;
    }
    
    /**
     * @see <a href="http://java.sun.com/docs/books/jvms/second_edition/html/ConstantPool.doc.html#71685">5.4.3.2 Field
     *      Resolution</a>
     */
    public static Constructor<?> resolveConstructor(final TypeDescriptor declaringClass,
                    final TypeDescriptor[] parameterTypes) {
        try {
            for (Constructor<?> constructor : declaringClass.asClass().getDeclaredConstructors()) {
                if (Arrays.equals(TypeHierarchyProvider.findOrCreateFromClasses(constructor.getParameterTypes()),
                                parameterTypes))
                    return constructor;
            }
            return null;
        } catch (SecurityException e) {
            throw new Error(e);
        } catch (ClassNotFoundException e) {
            throw new Error(e);
        }
    }
    
}
