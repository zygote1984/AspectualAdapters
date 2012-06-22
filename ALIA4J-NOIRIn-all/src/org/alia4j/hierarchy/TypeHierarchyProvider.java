package org.alia4j.hierarchy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.alia4j.util.BytecodeConstants;

public abstract class TypeHierarchyProvider {
    
    private static TypeHierarchyProvider singleton;
    
    private static TypeHierarchyProvider getInstance() {
        if (TypeHierarchyProvider.singleton == null)
            throw new IllegalStateException("TypeHierarchyProvider has not been initialized yet");
        return TypeHierarchyProvider.singleton;
    }
    
    static boolean initialized() {
        return TypeHierarchyProvider.singleton != null;
    }
    
    protected TypeHierarchyProvider() {
        synchronized (TypeHierarchyProvider.class) {
            if (TypeHierarchyProvider.singleton != null)
                throw new IllegalStateException("TypeHierarchyProvider has been initialized already");
            
            this.initializeCanonization();
            
            // assigning the singleton sets the type hierarchy provider as initialized
            // therefore it must happen after the canonization is initialized
            TypeHierarchyProvider.singleton = this;
        }
    }
    
    // TODO use varargs (...)
    public static Class<?>[] asClasses(final TypeDescriptor[] parameterTypes) throws ClassNotFoundException {
        final Class<?>[] result = new Class<?>[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            result[i] = parameterTypes[i].asClass();
        }
        return result;
    }
    
    // TODO use varargs (...)
    public static TypeDescriptor[] findOrCreateFromClasses(final Class<?>[] types) {
        final TypeDescriptor[] descriptors = new TypeDescriptor[types.length];
        for (int i = 0; i < types.length; i++)
            descriptors[i] = TypeHierarchyProvider.findOrCreateFromClass(types[i]);
        return descriptors;
    }
    
    // TODO use varargs (...)
    public static TypeDescriptor[] findOrCreateFromNormalTypeNames(final String[] normalNames) {
        final TypeDescriptor[] descriptors = new TypeDescriptor[normalNames.length];
        for (int i = 0; i < normalNames.length; i++)
            descriptors[i] = TypeHierarchyProvider.findOrCreateFromNormalTypeName(normalNames[i]);
        return descriptors;
    }
    
    public static TypeDescriptor findOrCreateFromClass(final Class<?> clazz) {
        if (clazz.isPrimitive()) {
            if (clazz == Boolean.TYPE)
                return TypeDescriptorConstants.BOOLEAN_PRIMITIVE;
            else if (clazz == Character.TYPE)
                return TypeDescriptorConstants.CHAR_PRIMITIVE;
            else if (clazz == Byte.TYPE)
                return TypeDescriptorConstants.BYTE_PRIMITIVE;
            else if (clazz == Short.TYPE)
                return TypeDescriptorConstants.SHORT_PRIMITIVE;
            else if (clazz == Integer.TYPE)
                return TypeDescriptorConstants.INT_PRIMITIVE;
            else if (clazz == Long.TYPE)
                return TypeDescriptorConstants.LONG_PRIMITIVE;
            else if (clazz == Float.TYPE)
                return TypeDescriptorConstants.FLOAT_PRIMITIVE;
            else if (clazz == Double.TYPE)
                return TypeDescriptorConstants.DOUBLE_PRIMITIVE;
            else if (clazz == Void.TYPE)
                return TypeDescriptorConstants.VOID_PRIMITIVE;
            else
                throw new Error("Not a primitive type: " + clazz);
        } else if (!clazz.isArray()) {
            if (clazz == Object.class)
                return TypeDescriptorConstants.OBJECT_CLASS;
            else
                return TypeHierarchyProvider.getInstance().findOrCreateCanonizedTypeDescriptor(
                                TypeHierarchyProvider.toTypeDescriptor(clazz.getName()));
        } else {
            if (clazz == Object[].class)
                return TypeDescriptorConstants.OBJECTARRAY_CLASS;
            else
                return TypeHierarchyProvider.getInstance().findOrCreateCanonizedTypeDescriptor(clazz.getName());
        }
    }
    
    public static TypeDescriptor findOrCreateFromNormalTypeName(final String normalTypeName) {
        return TypeHierarchyProvider.getInstance().findOrCreateCanonizedTypeDescriptor(
                        TypeHierarchyProvider.toTypeDescriptor(normalTypeName));
    }
    
    /**
     * @param normalTypeName must be a normal type name (JLS conform) but not an array.
     * @return
     */
    private static String toTypeDescriptor(final String normalTypeName) {
        if (normalTypeName.equals(BytecodeConstants.NORMAL_TYPE_BOOLEAN))
            return BytecodeConstants.TYPE_DESC_STRING_BOOLEAN;
        else if (normalTypeName.equals(BytecodeConstants.NORMAL_TYPE_CHAR))
            return BytecodeConstants.TYPE_DESC_STRING_CHAR;
        else if (normalTypeName.equals(BytecodeConstants.NORMAL_TYPE_BYTE))
            return BytecodeConstants.TYPE_DESC_STRING_BYTE;
        else if (normalTypeName.equals(BytecodeConstants.NORMAL_TYPE_SHORT))
            return BytecodeConstants.TYPE_DESC_STRING_SHORT;
        else if (normalTypeName.equals(BytecodeConstants.NORMAL_TYPE_INT))
            return BytecodeConstants.TYPE_DESC_STRING_INT;
        else if (normalTypeName.equals(BytecodeConstants.NORMAL_TYPE_LONG))
            return BytecodeConstants.TYPE_DESC_STRING_LONG;
        else if (normalTypeName.equals(BytecodeConstants.NORMAL_TYPE_FLOAT))
            return BytecodeConstants.TYPE_DESC_STRING_FLOAT;
        else if (normalTypeName.equals(BytecodeConstants.NORMAL_TYPE_DOUBLE))
            return BytecodeConstants.TYPE_DESC_STRING_DOUBLE;
        else if (normalTypeName.equals(BytecodeConstants.NORMAL_TYPE_VOID))
            return BytecodeConstants.TYPE_DESC_STRING_VOID;
        else if (normalTypeName.indexOf('[') != -1) {
            final String baseTypeDescriptor =
                            TypeHierarchyProvider.toTypeDescriptor(normalTypeName.substring(0, normalTypeName.indexOf('[')));
            int dimension = (normalTypeName.length() - normalTypeName.indexOf('[')) / 2;
            final StringBuilder typeDescriptorBuilder = new StringBuilder(baseTypeDescriptor.length() + dimension);
            for (; dimension > 0; dimension--)
                typeDescriptorBuilder.append('[');
            typeDescriptorBuilder.append(baseTypeDescriptor);
            return typeDescriptorBuilder.toString();
        } else {
            final StringBuilder typeDescriptorBuilder = new StringBuilder(normalTypeName.length() + 2);
            typeDescriptorBuilder.append('L').append(normalTypeName.replace('.', '/')).append(';');
            return typeDescriptorBuilder.toString();
        }
    }
    
    public static TypeDescriptor findOrCreateFromInternalClassName(final String internalClassName) {
        final StringBuilder typeDescriptorBuilder = new StringBuilder(internalClassName.length() + 2);
        typeDescriptorBuilder.append('L').append(internalClassName).append(';');
        return TypeHierarchyProvider.getInstance().findOrCreateCanonizedTypeDescriptor(typeDescriptorBuilder.toString());
    }
    
    public static TypeDescriptor findOrCreateFromTypeDescriptor(final String typeDescriptor) {
        return TypeHierarchyProvider.getInstance().findOrCreateCanonizedTypeDescriptor(typeDescriptor);
    }
    
    public static TypeDescriptor[] findOrCreateFromTypeDescriptors(final String typeDescriptors) {
        int index = 0;
        final List<TypeDescriptor> result = new ArrayList<TypeDescriptor>();
        while (index < typeDescriptors.length()) {
            final int startIndex = index;
            int elementTypeStartIndex = index;
            while (typeDescriptors.charAt(elementTypeStartIndex) == '[') {
                elementTypeStartIndex++;
            }
            
            int endIndex;
            if (typeDescriptors.charAt(elementTypeStartIndex) == 'L')
                endIndex = typeDescriptors.indexOf(';', elementTypeStartIndex) + 1;
            else
                endIndex = elementTypeStartIndex + 1;
            
            result.add(TypeHierarchyProvider.getInstance().findOrCreateCanonizedTypeDescriptor(
                            typeDescriptors.substring(startIndex, endIndex)));
            index = endIndex;
        }
        
        final TypeDescriptor[] resultArray = new TypeDescriptor[result.size()];
        return result.toArray(resultArray);
    }
    
    /**
     * @param descriptor
     * @return
     * @throws IllegalStateException If the specified class has not been loaded yet
     */
    public static Class<?> getLoadedClass(final TypeDescriptor descriptor) throws IllegalStateException {
        return TypeHierarchyProvider.getInstance().getLoadedClassImpl(descriptor);
    }
    
    /**
     * Returns the descriptors of all super classes and interfaces, including their super classes and interfaces, and so on.
     * 
     * @param descriptor
     * @return
     * @throws IllegalStateException If the specified class has not been loaded yet
     */
    public static TypeDescriptor[] getSuperTypes(final TypeDescriptor descriptor) throws IllegalStateException {
        return TypeHierarchyProvider.getInstance().getSuperTypesImpl(descriptor);
    }
    
    public static boolean isAssignmentCompatible(final TypeDescriptor lhs, final TypeDescriptor rhs) {
        return TypeHierarchyProvider.getInstance().isAssignmentCompatibleImpl(lhs, rhs);
    }
    
    public static String toFieldDescriptor(final TypeDescriptor descriptor) {
        return descriptor.toInternalTypeDescriptor();
    }
    
    // TODO only used in ERIn
    public static String toMethodDescriptor(final Class<?>[] parameterTypes, final Class<?> resultType) {
        return TypeHierarchyProvider.toMethodDescriptor(TypeHierarchyProvider.findOrCreateFromClasses(parameterTypes),
                        TypeHierarchyProvider.findOrCreateFromClass(resultType));
    }
    
    public static String toMethodDescriptor(final TypeDescriptor[] parameterTypes, final TypeDescriptor resultType) {
        final StringBuffer result = new StringBuffer();
        result.append('(');
        for (final TypeDescriptor element : parameterTypes)
            result.append(element.toInternalTypeDescriptor());
        result.append(')');
        result.append(resultType.toInternalTypeDescriptor());
        return result.toString();
    }
    
    protected abstract TypeDescriptor findOrCreateCanonizedTypeDescriptor(String typeDescriptor);
    
    /**
     * @param typeName
     * @return
     * @throws IllegalStateException If the specified class has not been loaded yet
     */
    protected abstract Class<?> getLoadedClassImpl(TypeDescriptor descriptor) throws IllegalStateException;
    
    /**
     * This method is called before the type hierarchy provider is fully initialized, i.e., before the singleton instance is
     * accessible.
     */
    protected abstract void initializeCanonization();
    
    /**
     * Returns the names of all super classes and interfaces, including their super classes and interfaces, and so on.
     * 
     * @param type
     * @return
     * @throws IllegalStateException If the specified class has not been loaded yet
     */
    protected TypeDescriptor[] getSuperTypesImpl(final TypeDescriptor descriptor) throws IllegalStateException {
        final Class<?> type = TypeHierarchyProvider.getLoadedClass(descriptor);
        final Set<Class<?>> temp = new HashSet<Class<?>>();
        this.fillSuperInterfaceNames(type, temp);
        Class<?> currentSuperClass = type.getSuperclass();
        while (currentSuperClass != null) {
            temp.add(currentSuperClass);
            this.fillSuperInterfaceNames(currentSuperClass, temp);
            currentSuperClass = currentSuperClass.getSuperclass();
        }
        final TypeDescriptor[] results = new TypeDescriptor[temp.size()];
        int i = 0;
        for (final Class<?> currentClass : temp) {
            results[i++] = TypeHierarchyProvider.findOrCreateFromClass(currentClass);
        }
        return results;
    }
    
    private void fillSuperInterfaceNames(final Class<?> type, final Set<Class<?>> resultSet) {
        final Class<?>[] interfaces = type.getInterfaces();
        for (final Class<?> element : interfaces) {
            resultSet.add(element);
            this.fillSuperInterfaceNames(element, resultSet);
        }
    }
    
    protected boolean isAssignmentCompatibleImpl(TypeDescriptor lhs, TypeDescriptor rhs) {
        try {
            return lhs.asClass().isAssignableFrom(rhs.asClass());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot determine assignmen compatibility for classes that are not yet loaded", e);
        }
    }
    
    public static int getStackWords(final TypeDescriptor[] types) {
        int stackWords = 0;
        for (final TypeDescriptor type : types)
            stackWords += type.getStackWords();
        return stackWords;
    }
}
