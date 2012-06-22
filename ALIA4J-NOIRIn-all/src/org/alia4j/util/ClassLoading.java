package org.alia4j.util;

public class ClassLoading {
    
    public static Class<?> classFor(final String typeDescriptor) {
        try {
            if (typeDescriptor.equals("Z"))
                return Boolean.TYPE;
            else if (typeDescriptor.equals("C"))
                return Character.TYPE;
            else if (typeDescriptor.equals("B"))
                return Byte.TYPE;
            else if (typeDescriptor.equals("S"))
                return Short.TYPE;
            else if (typeDescriptor.equals("I"))
                return Integer.TYPE;
            else if (typeDescriptor.equals("J"))
                return Long.TYPE;
            else if (typeDescriptor.equals("F"))
                return Float.TYPE;
            else if (typeDescriptor.equals("D"))
                return Double.TYPE;
            else if (typeDescriptor.equals("V"))
                return Void.TYPE;
            else if (typeDescriptor.startsWith("L"))
                return Class.forName(typeDescriptor.substring(1, typeDescriptor.length() - 1).replace('/', '.'), false,
                                Thread.currentThread().getContextClassLoader());
            else
                return Class
                                .forName(typeDescriptor.replace('/', '.'), false, Thread.currentThread()
                                                .getContextClassLoader());
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }
    
    public static Class<?>[] classesFor(final String[] typeDescriptors) {
        final Class<?>[] parameterTypes = new Class<?>[typeDescriptors.length];
        for (int i = 0; i < typeDescriptors.length; i++) {
            parameterTypes[i] = ClassLoading.classFor(typeDescriptors[i]);
        }
        return parameterTypes;
    }
    
}
