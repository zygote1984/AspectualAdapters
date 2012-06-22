package org.alia4j.liam;

import java.util.Arrays;
import java.util.HashMap;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.context.StoreHandle;
import org.alia4j.liam.event.EventSignature;
import org.alia4j.util.PairHashMap;
import org.alia4j.util.Tuple;

/**
 * @author Andreas Sewe
 */
public abstract class ContextFactory {
    
    protected ContextFactory() {
        if (ContextFactory.singleton != null)
            throw new IllegalStateException();
        ContextFactory.singleton = this;
    }
    
    private static ContextFactory getInstance() {
        return ContextFactory.singleton;
    }
    
    private static ContextFactory singleton;
    
    /**
     * @param index the index of the argument to be bound. (Negative indices are used to refer to arguments from the right.
     *            Thus, -1 refers to the last argument.)
     */
    public static final Context findOrCreateArgumentContext(final int index) {
        return ContextFactory.findOrCreateArgumentContext(index, -1);
    }
    
    /**
     * @param index the index of the argument to be bound. (Negative indices are used to refer to arguments from the right.
     *            Thus, -1 refers to the last argument.)
     * @param minimumRest the minimal number of arguments that must follow (for positive indexes) or precede (for negative
     *            indexed) the selected argument. Use -1 as "don't care". (This is motivated by the "args" pointcut
     *            designator of AspectJ, see for example the AspectJ importer).
     */
    public static final Context findOrCreateArgumentContext(final int index, final int minimumRest) {
        if (!ContextFactory.canonicalArgumentContexts.containsKeys(index, minimumRest))
            ContextFactory.canonicalArgumentContexts.put(index, minimumRest, ContextFactory.getInstance()
                            .createArgumentContext(index, minimumRest));
        return ContextFactory.canonicalArgumentContexts.get(index, minimumRest);
    }
    
    private static PairHashMap<Integer, Integer, Context> canonicalArgumentContexts =
                    new PairHashMap<Integer, Integer, Context>();
    
    public static final Context findOrCreateArgumentsContext() {
        if (ContextFactory.singletonArgumentsContext == null)
            ContextFactory.singletonArgumentsContext = ContextFactory.getInstance().createArgumentsContext();;
        return ContextFactory.singletonArgumentsContext;
    }
    
    private static Context singletonArgumentsContext = null;
    
    public static final Context findOrCreateCalleeContext() {
        if (ContextFactory.singletonCalleeContext == null)
            ContextFactory.singletonCalleeContext = ContextFactory.getInstance().createCalleeContext();;
        return ContextFactory.singletonCalleeContext;
    }
    
    private static Context singletonCalleeContext = null;
    
    public static final Context findOrCreateCallerContext() {
        if (ContextFactory.singletonCallerContext == null)
            ContextFactory.singletonCallerContext = ContextFactory.getInstance().createCallerContext();;
        return ContextFactory.singletonCallerContext;
    }
    
    private static Context singletonCallerContext = null;
    
    public static final Context findOrCreateDebugInfoContext() {
        if (ContextFactory.singletonDebugInfoContext == null)
            ContextFactory.singletonDebugInfoContext = ContextFactory.getInstance().createDebugInfoContext();
        return ContextFactory.singletonDebugInfoContext;
    }
    
    private static Context singletonDebugInfoContext = null;
    
    public static final Context findOrCreateMethodResultContext() {
        if (ContextFactory.singletonMethodResultContext == null)
            ContextFactory.singletonMethodResultContext = ContextFactory.getInstance().createMethodResultContext();
        return ContextFactory.singletonMethodResultContext;
    }
    
    private static Context singletonMethodResultContext = null;
    
    public static final Context findOrCreateSignatureContext() {
        if (ContextFactory.singletonSignatureContext == null)
            ContextFactory.singletonSignatureContext = ContextFactory.getInstance().createSignatureContext();
        return ContextFactory.singletonSignatureContext;
    }
    
    private static Context singletonSignatureContext = null;
    
    public static final Context findOrCreateThreadContext() {
        if (ContextFactory.singletonThreadContext == null)
            ContextFactory.singletonThreadContext = ContextFactory.getInstance().createThreadContext();
        return ContextFactory.singletonThreadContext;
    }
    
    private static Context singletonThreadContext = null;
    
    public static final Context findOrCreateAddContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalAddContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalAddContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createAddContext(firstOperand, secondOperand));
        return ContextFactory.canonicalAddContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalAddContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateSubtractContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalSubtractContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalSubtractContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createSubtractContext(firstOperand, secondOperand));
        return ContextFactory.canonicalSubtractContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalSubtractContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateMultiplyContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalMultiplyContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalMultiplyContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createMultiplyContext(firstOperand, secondOperand));
        return ContextFactory.canonicalMultiplyContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalMultiplyContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateDivideContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalDivideContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalDivideContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createDivideContext(firstOperand, secondOperand));
        return ContextFactory.canonicalDivideContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalDivideContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateRemainderContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalRemainderContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalRemainderContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createRemainderContext(firstOperand, secondOperand));
        return ContextFactory.canonicalRemainderContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalRemainderContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateNegationContext(final Context operand) {
        if (!ContextFactory.canonicalNegationContexts.containsKey(operand))
            ContextFactory.canonicalNegationContexts.put(operand, ContextFactory.getInstance()
                            .createNegationContext(operand));
        return ContextFactory.canonicalNegationContexts.get(operand);
    }
    
    private static HashMap<Context, Context> canonicalNegationContexts = new HashMap<Context, Context>();
    
    public static final Context findOrCreateLeftShiftContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalLeftShiftContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalLeftShiftContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createLeftShiftContext(firstOperand, secondOperand));
        return ContextFactory.canonicalLeftShiftContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalLeftShiftContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateRightShiftSignExtendContext(final Context firstOperand,
                    final Context secondOperand) {
        if (!ContextFactory.canonicalRightShiftSignExtendContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalRightShiftSignExtendContexts.put(firstOperand, secondOperand, ContextFactory
                            .getInstance().createRightShiftSignExtendContext(firstOperand, secondOperand));
        return ContextFactory.canonicalRightShiftSignExtendContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalRightShiftSignExtendContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateRightShiftZeroExtendContext(final Context firstOperand,
                    final Context secondOperand) {
        if (!ContextFactory.canonicalRightShiftZeroExtendContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalRightShiftZeroExtendContexts.put(firstOperand, secondOperand, ContextFactory
                            .getInstance().createRightShiftZeroExtendContext(firstOperand, secondOperand));
        return ContextFactory.canonicalRightShiftZeroExtendContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalRightShiftZeroExtendContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateBitwiseAndContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalBitwiseAndContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalBitwiseAndContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createBitwiseAndContext(firstOperand, secondOperand));
        return ContextFactory.canonicalBitwiseAndContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalBitwiseAndContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateBitwiseOrContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalBitwiseOrContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalBitwiseOrContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createBitwiseOrContext(firstOperand, secondOperand));
        return ContextFactory.canonicalBitwiseOrContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalBitwiseOrContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateBitwiseXorContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalBitwiseXorContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalBitwiseXorContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createBitwiseXorContext(firstOperand, secondOperand));
        return ContextFactory.canonicalBitwiseXorContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalBitwiseXorContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateBitwiseComplementContext(final Context operand) {
        if (!ContextFactory.canonicalBitwiseComplementContexts.containsKey(operand))
            ContextFactory.canonicalBitwiseComplementContexts.put(operand, ContextFactory.getInstance()
                            .createBitwiseComplementContext(operand));
        return ContextFactory.canonicalBitwiseComplementContexts.get(operand);
    }
    
    private static HashMap<Context, Context> canonicalBitwiseComplementContexts = new HashMap<Context, Context>();
    
    public static final Context findOrCreateToCharCoercionContext(final Context operand) {
        if (!ContextFactory.canonicalToCharCoercionContexts.containsKey(operand))
            ContextFactory.canonicalToCharCoercionContexts.put(operand, ContextFactory.getInstance()
                            .createToCharCoercionContext(operand));
        return ContextFactory.canonicalToCharCoercionContexts.get(operand);
    }
    
    private static HashMap<Context, Context> canonicalToCharCoercionContexts = new HashMap<Context, Context>();
    
    public static final Context findOrCreateToByteCoercionContext(final Context operand) {
        if (!ContextFactory.canonicalToByteCoercionContexts.containsKey(operand))
            ContextFactory.canonicalToByteCoercionContexts.put(operand, ContextFactory.getInstance()
                            .createToByteCoercionContext(operand));
        return ContextFactory.canonicalToByteCoercionContexts.get(operand);
    }
    
    private static HashMap<Context, Context> canonicalToByteCoercionContexts = new HashMap<Context, Context>();
    
    public static final Context findOrCreateToShortCoercionContext(final Context operand) {
        if (!ContextFactory.canonicalToShortCoercionContexts.containsKey(operand))
            ContextFactory.canonicalToShortCoercionContexts.put(operand, ContextFactory.getInstance()
                            .createToShortCoercionContext(operand));
        return ContextFactory.canonicalToShortCoercionContexts.get(operand);
    }
    
    private static HashMap<Context, Context> canonicalToShortCoercionContexts = new HashMap<Context, Context>();
    
    public static final Context findOrCreateToIntCoercionContext(final Context operand) {
        if (!ContextFactory.canonicalToIntCoercionContexts.containsKey(operand))
            ContextFactory.canonicalToIntCoercionContexts.put(operand, ContextFactory.getInstance()
                            .createToIntCoercionContext(operand));
        return ContextFactory.canonicalToIntCoercionContexts.get(operand);
    }
    
    private static HashMap<Context, Context> canonicalToIntCoercionContexts = new HashMap<Context, Context>();
    
    public static final Context findOrCreateToLongCoercionContext(final Context operand) {
        if (!ContextFactory.canonicalToLongCoercionContexts.containsKey(operand))
            ContextFactory.canonicalToLongCoercionContexts.put(operand, ContextFactory.getInstance()
                            .createToLongCoercionContext(operand));
        return ContextFactory.canonicalToLongCoercionContexts.get(operand);
    }
    
    private static HashMap<Context, Context> canonicalToLongCoercionContexts = new HashMap<Context, Context>();
    
    public static final Context findOrCreateToFloatCoercionContext(final Context operand) {
        if (!ContextFactory.canonicalToFloatCoercionContexts.containsKey(operand))
            ContextFactory.canonicalToFloatCoercionContexts.put(operand, ContextFactory.getInstance()
                            .createToFloatCoercionContext(operand));
        return ContextFactory.canonicalToFloatCoercionContexts.get(operand);
    }
    
    private static HashMap<Context, Context> canonicalToFloatCoercionContexts = new HashMap<Context, Context>();
    
    public static final Context findOrCreateToDoubleCoercionContext(final Context operand) {
        if (!ContextFactory.canonicalToDoubleCoercionContexts.containsKey(operand))
            ContextFactory.canonicalToDoubleCoercionContexts.put(operand, ContextFactory.getInstance()
                            .createToDoubleCoercionContext(operand));
        return ContextFactory.canonicalToDoubleCoercionContexts.get(operand);
    }
    
    private static HashMap<Context, Context> canonicalToDoubleCoercionContexts = new HashMap<Context, Context>();
    
    public static final Context findOrCreateEqualContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalEqualContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalEqualContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createEqualContext(firstOperand, secondOperand));
        return ContextFactory.canonicalEqualContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalEqualContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateNotEqualContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalNotEqualContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalNotEqualContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createNotEqualContext(firstOperand, secondOperand));
        return ContextFactory.canonicalNotEqualContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalNotEqualContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateLessContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalLessContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalLessContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createLessContext(firstOperand, secondOperand));
        return ContextFactory.canonicalLessContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalLessContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateGreaterContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalGreaterContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalGreaterContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createGreaterContext(firstOperand, secondOperand));
        return ContextFactory.canonicalGreaterContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalGreaterContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateLessEqualContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalLessEqualContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalLessEqualContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createLessEqualContext(firstOperand, secondOperand));
        return ContextFactory.canonicalLessEqualContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalLessEqualContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateGreaterEqualContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalGreaterEqualContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalGreaterEqualContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createGreaterEqualContext(firstOperand, secondOperand));
        return ContextFactory.canonicalGreaterEqualContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalGreaterEqualContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateAndContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalAndContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalAndContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createAndContext(firstOperand, secondOperand));
        return ContextFactory.canonicalAndContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalAndContexts =
                    new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateOrContext(final Context firstOperand, final Context secondOperand) {
        if (!ContextFactory.canonicalOrContexts.containsKeys(firstOperand, secondOperand))
            ContextFactory.canonicalOrContexts.put(firstOperand, secondOperand, ContextFactory.getInstance()
                            .createOrContext(firstOperand, secondOperand));
        return ContextFactory.canonicalOrContexts.get(firstOperand, secondOperand);
    }
    
    private static PairHashMap<Context, Context, Context> canonicalOrContexts = new PairHashMap<Context, Context, Context>();
    
    public static final Context findOrCreateNotContext(final Context operand) {
        if (!ContextFactory.canonicalNotContexts.containsKey(operand))
            ContextFactory.canonicalNotContexts.put(operand, ContextFactory.getInstance().createNotContext(operand));
        return ContextFactory.canonicalNotContexts.get(operand);
    }
    
    private static HashMap<Context, Context> canonicalNotContexts = new HashMap<Context, Context>();
    
    public static final Context findOrCreateObjectConstantContext(final Object value) {
        if (!ContextFactory.canonicalObjectConstantContexts.containsKey(value))
            ContextFactory.canonicalObjectConstantContexts.put(value, ContextFactory.getInstance()
                            .createObjectConstantContext(value));
        return ContextFactory.canonicalObjectConstantContexts.get(value);
    }
    
    private static HashMap<Object, Context> canonicalObjectConstantContexts = new HashMap<Object, Context>();
    
    /**
     * @param classDescriptor must be a descriptor of a class (not an interface, array or primitive type), and this class
     *            must have a public default constructor.
     * @return
     */
    public static final Context findOrCreateLazyObjectConstantContext(final TypeDescriptor classDescriptor) {
        if (!ContextFactory.canonicalLazyObjectConstantContexts.containsKey(classDescriptor))
            ContextFactory.canonicalLazyObjectConstantContexts.put(classDescriptor, ContextFactory.getInstance()
                            .createLazyObjectConstantContext(classDescriptor));
        return ContextFactory.canonicalLazyObjectConstantContexts.get(classDescriptor);
    }
    
    private static HashMap<TypeDescriptor, Context> canonicalLazyObjectConstantContexts =
                    new HashMap<TypeDescriptor, Context>();
    
    public static final Context findOrCreateBooleanConstantContext(final boolean value) {
        if (!ContextFactory.canonicalBooleanConstantContexts.containsKey(value))
            ContextFactory.canonicalBooleanConstantContexts.put(value, ContextFactory.getInstance()
                            .createBooleanConstantContext(value));
        return ContextFactory.canonicalBooleanConstantContexts.get(value);
    }
    
    private static HashMap<Boolean, Context> canonicalBooleanConstantContexts = new HashMap<Boolean, Context>();
    
    public static final Context findOrCreateIntegerConstantContext(final int value) {
        if (!ContextFactory.canonicalIntegerConstantContexts.containsKey(value))
            ContextFactory.canonicalIntegerConstantContexts.put(value, ContextFactory.getInstance()
                            .createIntegerConstantContext(value));
        return ContextFactory.canonicalIntegerConstantContexts.get(value);
    }
    
    private static HashMap<Integer, Context> canonicalIntegerConstantContexts = new HashMap<Integer, Context>();
    
    public static final Context findOrCreateLongConstantContext(final long value) {
        if (!ContextFactory.canonicalLongConstantContexts.containsKey(value))
            ContextFactory.canonicalLongConstantContexts.put(value,
                            ContextFactory.getInstance().createLongConstantContext(value));
        return ContextFactory.canonicalLongConstantContexts.get(value);
    }
    
    private static HashMap<Long, Context> canonicalLongConstantContexts = new HashMap<Long, Context>();
    
    public static final Context findOrCreateFloatConstantContext(final float value) {
        if (!ContextFactory.canonicalFloatConstantContexts.containsKey(value))
            ContextFactory.canonicalFloatConstantContexts.put(value, ContextFactory.getInstance()
                            .createFloatConstantContext(value));
        return ContextFactory.canonicalFloatConstantContexts.get(value);
    }
    
    private static HashMap<Float, Context> canonicalFloatConstantContexts = new HashMap<Float, Context>();
    
    public static final Context findOrCreateDoubleConstantContext(final double value) {
        if (!ContextFactory.canonicalDoubleConstantValues.containsKey(value))
            ContextFactory.canonicalDoubleConstantValues.put(value, ContextFactory.getInstance()
                            .createDoubleConstantContext(value));
        return ContextFactory.canonicalDoubleConstantValues.get(value);
    }
    
    private static HashMap<Double, Context> canonicalDoubleConstantValues = new HashMap<Double, Context>();
    
    public static final Context findOrCreateWrappingContext(final Context operand) {
        if (!ContextFactory.canonicalWrappingContexts.containsKey(operand))
            ContextFactory.canonicalWrappingContexts.put(operand, ContextFactory.getInstance()
                            .createWrappingContext(operand));
        return ContextFactory.canonicalWrappingContexts.get(operand);
    }
    
    private static HashMap<Context, Context> canonicalWrappingContexts = new HashMap<Context, Context>();
    
    public static final Context findOrCreateToArrayContext(final Context... elements) {
        final Tuple<Context> key = new Tuple<Context>(elements);
        if (!ContextFactory.canonicalToArrayContexts.containsKey(key))
            ContextFactory.canonicalToArrayContexts.put(key, ContextFactory.getInstance().createToArrayContext(elements));
        return ContextFactory.canonicalToArrayContexts.get(key);
    }
    
    private static HashMap<Tuple<Context>, Context> canonicalToArrayContexts = new HashMap<Tuple<Context>, Context>();
    
    /**
     * Creates a PerTupleContext which will implicitly add new instances to the store, i.e., there will always be a value
     * (!=null) for each input tuple at runtime.
     * 
     * @param storeHandle
     * @param boundElements
     * @param resultType
     * @return
     */
    public static final Context findOrCreatePerTupleContext(final StoreHandle storeHandle, final Context[] boundElements,
                    final TypeDescriptor resultType) {
        final PerTupleImplicitKey key = new PerTupleImplicitKey(storeHandle, boundElements, resultType);
        if (!ContextFactory.canonicalPerTupleImplicitContexts.containsKey(key))
            ContextFactory.canonicalPerTupleImplicitContexts
                            .put(key,
                                            ContextFactory.getInstance().createPerTupleContext(storeHandle, boundElements,
                                                            resultType, null));
        return ContextFactory.canonicalPerTupleImplicitContexts.get(key);
    }
    
    private static class PerTupleImplicitKey {
        
        private final StoreHandle storeHandle;
        
        private final Context[] boundElements;
        
        private final TypeDescriptor resultType;
        
        public PerTupleImplicitKey(final StoreHandle storeHandle, final Context[] boundElements,
                        final TypeDescriptor resultType) {
            super();
            this.storeHandle = storeHandle;
            this.boundElements = boundElements;
            this.resultType = resultType;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + Arrays.hashCode(this.boundElements);
            result = prime * result + ((this.resultType == null) ? 0 : this.resultType.hashCode());
            result = prime * result + ((this.storeHandle == null) ? 0 : this.storeHandle.hashCode());
            return result;
        }
        
        @Override
        public boolean equals(final Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (this.getClass() != obj.getClass())
                return false;
            final PerTupleImplicitKey other = (PerTupleImplicitKey) obj;
            if (this.resultType == null) {
                if (other.resultType != null)
                    return false;
            } else if (!this.resultType.equals(other.resultType))
                return false;
            if (this.storeHandle == null) {
                if (other.storeHandle != null)
                    return false;
            } else if (!this.storeHandle.equals(other.storeHandle))
                return false;
            if (!Arrays.equals(this.boundElements, other.boundElements))
                return false;
            return true;
        }
    }
    
    private static HashMap<PerTupleImplicitKey, Context> canonicalPerTupleImplicitContexts =
                    new HashMap<PerTupleImplicitKey, Context>();
    
    /**
     * Creates a PerTupleContext which will only return values that are already in the store, i.e., for some input tuples
     * there may be no value at runtime and this Context returns null.
     * 
     * @param storeHandle
     * @param boundElements
     * @param wildcardPositions
     * @return
     */
    public static final Context findOrCreatePerTupleContext(final StoreHandle storeHandle, final Context[] boundElements,
                    final int[] wildcardPositions) {
        final PerTupleExplicitKey key = new PerTupleExplicitKey(storeHandle, boundElements, wildcardPositions);
        if (!ContextFactory.canonicalPerTupleExplicitContexts.containsKey(key))
            ContextFactory.canonicalPerTupleExplicitContexts.put(
                            key,
                            ContextFactory.getInstance().createPerTupleContext(storeHandle, boundElements, null,
                                            wildcardPositions));
        return ContextFactory.canonicalPerTupleExplicitContexts.get(key);
    }
    
    private static class PerTupleExplicitKey {
        
        StoreHandle storeHandle;
        
        Context[] boundElements;
        
        int[] wildcardPositions;
        
        public PerTupleExplicitKey(final StoreHandle storeHandle, final Context[] boundElements,
                        final int[] wildcardPositions) {
            super();
            this.storeHandle = storeHandle;
            this.boundElements = boundElements;
            this.wildcardPositions = wildcardPositions;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + Arrays.hashCode(this.boundElements);
            result = prime * result + ((this.storeHandle == null) ? 0 : this.storeHandle.hashCode());
            result = prime * result + Arrays.hashCode(this.wildcardPositions);
            return result;
        }
        
        @Override
        public boolean equals(final Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (this.getClass() != obj.getClass())
                return false;
            final PerTupleExplicitKey other = (PerTupleExplicitKey) obj;
            if (this.storeHandle == null) {
                if (other.storeHandle != null)
                    return false;
            } else if (!this.storeHandle.equals(other.storeHandle))
                return false;
            if (!Arrays.equals(this.wildcardPositions, other.wildcardPositions))
                return false;
            if (!Arrays.equals(this.boundElements, other.boundElements))
                return false;
            return true;
        }
    }
    
    private static HashMap<PerTupleExplicitKey, Context> canonicalPerTupleExplicitContexts =
                    new HashMap<PerTupleExplicitKey, Context>();
    
    public static StoreHandle createStoreHandle() {
        return ContextFactory.getInstance().createStoreHandleImpl();
    }
    
    /**
     * The created Context returns the actual to which Java would resolve the the generic function call at which it is used.
     * The type of the result object depends on the generic function call: for method invocations it is
     * {@link java.lang.reflect.Method}, for field accesses it is {@link java.lang.reflec.Field}, for constructor invocations
     * it is {@link java.lang.reflect.Constructor} and for static initializers it is {@link java.lang.Class}.
     * 
     * @return
     */
    public static Context findOrCreateActualMemberContext() {
        if (ContextFactory.singletonActualMemberContext == null) {
            ContextFactory.singletonActualMemberContext = ContextFactory.getInstance().createActualMemberContext();
        }
        return ContextFactory.singletonActualMemberContext;
    }
    
    private static Context singletonActualMemberContext;
    
    /**
     * The created Context returns the "top method" of the generic function call during which it is used. The type of the
     * result object depends on the generic function call: for method invocations it is {@link java.lang.reflect.Method}, for
     * field accesses it is {@link java.lang.reflec.Field}, for constructor invocations it is
     * {@link java.lang.reflect.Constructor} and for static initializers it is {@link java.lang.Class}.
     * 
     * @return
     */
    public static Context findOrCreateTopMemberContext() {
        if (ContextFactory.singletonTopMemberContext == null) {
            ContextFactory.singletonTopMemberContext = ContextFactory.getInstance().createTopMemberContext();
        }
        return ContextFactory.singletonTopMemberContext;
    }
    
    private static Context singletonTopMemberContext;
    
    /**
     * Creates a Context that returns at a dispatch: the resolution strategy with which the implicit action was actually
     * called at the dispatch site, the signature of the accessed generic function and some approximation of caller and
     * callee types. Resolution strategies are static, virtual, special and interface.
     * 
     * @return
     */
    public static Context findOrCreateCallApproximationContext() {
        if (ContextFactory.singletonCallApproximationContext == null) {
            ContextFactory.singletonCallApproximationContext = ContextFactory.getInstance().createCallApproximationContext();
        }
        return ContextFactory.singletonCallApproximationContext;
    }
    
    private static Context singletonCallApproximationContext;
    
    public static Context findOrCreateEventTriggeringContext(EventSignature eventSignature) {
        if (!ContextFactory.canonicalEventTriggeringContexts.containsKey(eventSignature)) {
            ContextFactory.canonicalEventTriggeringContexts.put(eventSignature, ContextFactory.getInstance()
                            .createEventTriggeringContext(eventSignature));
        }
        return ContextFactory.canonicalEventTriggeringContexts.get(eventSignature);
    }
    
    private static HashMap<EventSignature, Context> canonicalEventTriggeringContexts =
                    new HashMap<EventSignature, Context>();
    
    public static Context findOrCreateEventAccessingContext(EventSignature eventSignature) {
        if (!ContextFactory.canonicalEventAccessingContexts.containsKey(eventSignature)) {
            ContextFactory.canonicalEventAccessingContexts.put(eventSignature, ContextFactory.getInstance()
                            .createEventAccessingContext(eventSignature));
        }
        return ContextFactory.canonicalEventAccessingContexts.get(eventSignature);
    }
    
    private static HashMap<EventSignature, Context> canonicalEventAccessingContexts = new HashMap<EventSignature, Context>();
    
    public static Context findOrCreateEventParameterContext(EventSignature eventSignature, String eventParameterName) {
        if (!ContextFactory.canonicalEventParameterContexts.containsKeys(eventSignature, eventParameterName)) {
            ContextFactory.canonicalEventParameterContexts.put(eventSignature, eventParameterName, ContextFactory
                            .getInstance().createEventParameterContext(eventSignature, eventParameterName));
        }
        return ContextFactory.canonicalEventParameterContexts.get(eventSignature, eventParameterName);
    }
    
    private static PairHashMap<EventSignature, String, Context> canonicalEventParameterContexts =
                    new PairHashMap<EventSignature, String, Context>();
    
    protected abstract Context createArgumentContext(int index, int minimumRest);
    
    protected abstract Context createArgumentsContext();
    
    protected abstract Context createCalleeContext();
    
    protected abstract Context createCallerContext();
    
    protected abstract Context createDebugInfoContext();
    
    protected abstract Context createMethodResultContext();
    
    protected abstract Context createSignatureContext();
    
    protected abstract Context createThreadContext();
    
    protected abstract Context createAddContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createSubtractContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createMultiplyContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createDivideContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createRemainderContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createNegationContext(Context operand);
    
    protected abstract Context createLeftShiftContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createRightShiftSignExtendContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createRightShiftZeroExtendContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createBitwiseAndContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createBitwiseOrContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createBitwiseXorContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createBitwiseComplementContext(Context operand);
    
    protected abstract Context createToCharCoercionContext(Context operand);
    
    protected abstract Context createToByteCoercionContext(Context operand);
    
    protected abstract Context createToShortCoercionContext(Context operand);
    
    protected abstract Context createToIntCoercionContext(Context operand);
    
    protected abstract Context createToLongCoercionContext(Context operand);
    
    protected abstract Context createToDoubleCoercionContext(Context operand);
    
    protected abstract Context createToFloatCoercionContext(Context operand);
    
    protected abstract Context createEqualContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createNotEqualContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createLessContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createGreaterContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createLessEqualContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createGreaterEqualContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createAndContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createOrContext(Context firstOperand, Context secondOperand);
    
    protected abstract Context createNotContext(Context operand);
    
    protected abstract Context createObjectConstantContext(Object value);
    
    protected abstract Context createLazyObjectConstantContext(TypeDescriptor classDescriptor);
    
    protected abstract Context createBooleanConstantContext(boolean value);
    
    protected abstract Context createIntegerConstantContext(int value);
    
    protected abstract Context createLongConstantContext(long value);
    
    protected abstract Context createFloatConstantContext(float value);
    
    protected abstract Context createDoubleConstantContext(double value);
    
    protected abstract Context createWrappingContext(Context operand);
    
    protected abstract Context createToArrayContext(Context... elements);
    
    protected abstract Context createPerTupleContext(StoreHandle storeHandle, Context[] boundElements,
                    TypeDescriptor resultType, int[] wildcardPositions);
    
    protected abstract StoreHandle createStoreHandleImpl();
    
    protected abstract Context createActualMemberContext();
    
    protected abstract Context createTopMemberContext();
    
    protected abstract Context createCallApproximationContext();
    
    protected abstract Context createEventTriggeringContext(EventSignature eventSignature);
    
    protected abstract Context createEventAccessingContext(EventSignature eventSignature);
    
    protected abstract Context createEventParameterContext(EventSignature eventSignature, String parameterName);
    
}
