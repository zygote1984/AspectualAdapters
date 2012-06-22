package org.alia4j.liam.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.liam.signature.ResolutionStrategy;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public abstract class MethodCallAction extends MemberAction {
    
    private final TypeDescriptor[] parameterTypeNames;
    
    private final TypeDescriptor resultType;
    
    private final ResolutionStrategy invocationType;
    
    private Method method;
    
    protected MethodCallAction(final TypeDescriptor declaringClassName, final CharSequence methodName,
                    final TypeDescriptor[] parameterTypeNames, final TypeDescriptor resultType) {
        this(declaringClassName, methodName, parameterTypeNames, resultType, ResolutionStrategy.VIRTUAL);
    }
    
    protected MethodCallAction(final TypeDescriptor declaringClassName, final CharSequence methodName,
                    final TypeDescriptor[] parameterTypeNames, final TypeDescriptor resultType,
                    final ResolutionStrategy invocationType) {
        super(declaringClassName, methodName);
        this.parameterTypeNames = parameterTypeNames;
        this.resultType = resultType;
        this.invocationType = invocationType;
    }
    
    @Override
    public TypeDescriptor getResultType() {
        return this.resultType;
    }
    
    public TypeDescriptor[] getParameterTypeNames() {
        return this.parameterTypeNames;
    }
    
    public boolean isVirtualInvocation() {
        return this.invocationType == ResolutionStrategy.VIRTUAL;
    }
    
    public boolean isSpecialInvocation() {
        return this.invocationType == ResolutionStrategy.SPECIAL;
    }
    
    public boolean isStaticInvocation() {
        return this.invocationType == ResolutionStrategy.STATIC;
    }
    
    public boolean isInterfaceInvocation() {
        return this.invocationType == ResolutionStrategy.INTERFACE;
    }
    
    @Override
    public TypeDescriptor getRequiredParameterType(final int parameterPosition) {
        assert parameterPosition >= 0
                        && ((!this.isStaticInvocation() && parameterPosition <= this.parameterTypeNames.length) || (this
                                        .isStaticInvocation() && parameterPosition < this.parameterTypeNames.length));
        if (this.isStaticInvocation()) {
            return this.parameterTypeNames[parameterPosition];
        } else {
            if (parameterPosition == 0)
                return this.getDeclaringClassName();
            else
                return this.parameterTypeNames[parameterPosition - 1];
        }
    }
    
    private Method getMethod() throws SecurityException, NoSuchMethodException, ClassNotFoundException {
        if (this.method == null) {
            this.method =
                            this.getDeclaringClass().getDeclaredMethod(this.getName().toString(),
                                            TypeHierarchyProvider.asClasses(this.parameterTypeNames));
            this.method.setAccessible(true);
        }
        return this.method;
    }
    
    public void perform(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        this.invokeReflectively(exposedContextValues);
    }
    
    public boolean performBoolean(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        return ((Boolean) this.invokeReflectively(exposedContextValues)).booleanValue();
    }
    
    public char performChar(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        return ((Character) this.invokeReflectively(exposedContextValues)).charValue();
    }
    
    public byte performByte(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException,
                    Throwable {
        return ((Byte) this.invokeReflectively(exposedContextValues)).byteValue();
    }
    
    public short performShort(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        return ((Short) this.invokeReflectively(exposedContextValues)).shortValue();
    }
    
    public int performInt(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        return ((Integer) this.invokeReflectively(exposedContextValues)).intValue();
    }
    
    public long performLong(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        return ((Long) this.invokeReflectively(exposedContextValues)).longValue();
    }
    
    public float performFloat(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        return ((Float) this.invokeReflectively(exposedContextValues)).floatValue();
    }
    
    public double performDouble(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        return ((Double) this.invokeReflectively(exposedContextValues)).doubleValue();
    }
    
    public Object performObject(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        return this.invokeReflectively(exposedContextValues);
    }
    
    private Object invokeReflectively(Object exposedContextValues) throws IllegalArgumentException, SecurityException,
                    IllegalAccessException, NoSuchMethodException, ClassNotFoundException, Throwable {
        final Object owner;
        final Object[] arguments;
        if (this.isStaticInvocation()) {
            owner = null;
            arguments = (Object[]) exposedContextValues;
        } else {
            Object[] exposedContextValuesArray = (Object[]) exposedContextValues;
            owner = exposedContextValuesArray[0];
            arguments = new Object[exposedContextValuesArray.length - 1];
            System.arraycopy(exposedContextValuesArray, 1, arguments, 0, arguments.length);
        }
        
        try {
            if (this.isSpecialInvocation()) {
                return this.invokeSpecialReflectively(this.getMethod(), owner, arguments);
            } else {
                return this.getMethod().invoke(owner, arguments);
            }
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
    
    /**
     * Exceptions that occur during the reflective invocation should be passed upwards (i.e., should not be handled by this
     * method).
     * 
     * @param method
     * @param owner
     * @param arguments
     * @return
     * @throws Throwable
     */
    abstract protected Object invokeSpecialReflectively(Method method, Object owner, Object[] arguments) throws Throwable;
    
}
