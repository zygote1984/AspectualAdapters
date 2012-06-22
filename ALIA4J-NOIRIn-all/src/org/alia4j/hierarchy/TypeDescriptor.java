package org.alia4j.hierarchy;

public interface TypeDescriptor {
    
    boolean isVoidType();
    
    boolean isIntType();
    
    boolean isLongType();
    
    boolean isFloatType();
    
    boolean isDoubleType();
    
    boolean isBooleanType();
    
    boolean isByteType();
    
    boolean isCharType();
    
    boolean isShortType();
    
    boolean isPrimitiveType();
    
    boolean isReferenceType();
    
    boolean isClassType();
    
    boolean isArrayType();
    
    /**
     * Determines whether this is a primitive type which is handled by the VM as an <code>int</code> (<code>boolean</code>,
     * <code>char</code>, <code>byte</code>, <code>short</code>, <code>int</code>).
     * 
     * @return <code>true</code> if this primitive type is handled by the VM as an <code>int</code>, <code>false</code>
     *         otherwise
     */
    boolean isIntLikeType();
    
    /**
     * Returns the number of words used by the VM to store a value of this type. I.e., 2 for long and double, 0 for void and
     * 1 otherwise.
     * 
     * @return
     */
    int getStackWords();
    
    // TODO what about nested classes? Should Outer$Inner resp. Outer.Inner be two name elements?
    /**
     * Returns an array of the package names and the unqualified class name. May only be used if the type is scalar.
     */
    CharSequence[] getNameElements();
    
    /**
     * May only be used if the type is array.
     */
    TypeDescriptor getInnermostElementType();
    
    /**
     * May only be used if the type is array.
     */
    int getDimensionality();
    
    /**
     * Returns the java.lang.Class object that reflects the described type. If necessary, the class is loaded by the
     * Thread.currentThread().getContextClassLoader().
     * 
     * @return
     */
    Class<?> asClass() throws ClassNotFoundException;
    
    /**
     * Returns the class name in internal representation, i.e., '/' as package separator but no 'L' .. ';'. This may only be
     * called for scalar types.
     * 
     * @return
     */
    String toInternalClassName();
    
    /**
     * Returns any type in internal representation, i.e., '/' as package separator, 'L'..';' for scalar types, starting with
     * '[' for array types and one character for primitive type (e.g., 'I' for int).
     * 
     * @return
     */
    String toInternalTypeDescriptor();
    
    /**
     * Returns the language level representation of this type, i.e., '.' as package separator, trailing "[]" for array, the
     * names of primitive types, e.g. int.
     * 
     * @return
     */
    String toNormalTypeName();
    
    @Override
    /**
     * TypeDescriptors are canonized by the TypeHierarchyProvider and equals should
     * test for identity.
     */
    public boolean equals(Object obj);
    
    @Override
    /**
     * TypeDescriptors are canonized by the TypeHierarchyProvider and hashCode should
     * return the identityHash.
     */
    public int hashCode();
}
