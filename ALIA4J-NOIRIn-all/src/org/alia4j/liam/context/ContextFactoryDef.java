package org.alia4j.liam.context;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.event.EventSignature;

/**
 * An Abstract Factory providing default implementations of various <code>Context</code>'s for the benefit of all FIAL
 * instantiations.
 * 
 * @author Andreas Sewe
 */
public abstract class ContextFactoryDef extends ContextFactory {
    
    protected ContextFactoryDef() {
        super();
    }
    
    @Override
    protected Context createArgumentContext(final int index, final int minimumRest) {
        return new ArgumentContext(index, minimumRest);
    }
    
    @Override
    protected Context createThreadContext() {
        return new ThreadContext();
    }
    
    @Override
    protected Context createAddContext(final Context firstOperand, final Context secondOperand) {
        return new AddContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createSubtractContext(final Context firstOperand, final Context secondOperand) {
        return new SubtractContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createMultiplyContext(final Context firstOperand, final Context secondOperand) {
        return new MultiplyContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createDivideContext(final Context firstOperand, final Context secondOperand) {
        return new DivideContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createRemainderContext(final Context firstOperand, final Context secondOperand) {
        return new RemainderContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createNegationContext(final Context operand) {
        return new NegationContext(operand);
    }
    
    @Override
    protected Context createLeftShiftContext(final Context firstOperand, final Context secondOperand) {
        return new LeftShiftContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createRightShiftSignExtendContext(final Context firstOperand, final Context secondOperand) {
        return new RightShiftSignExtendContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createRightShiftZeroExtendContext(final Context firstOperand, final Context secondOperand) {
        return new RightShiftZeroExtendContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createBitwiseAndContext(final Context firstOperand, final Context secondOperand) {
        return new BitwiseAndContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createBitwiseOrContext(final Context firstOperand, final Context secondOperand) {
        return new BitwiseOrContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createBitwiseXorContext(final Context firstOperand, final Context secondOperand) {
        return new BitwiseXorContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createBitwiseComplementContext(final Context operand) {
        return new BitwiseComplementContext(operand);
    }
    
    @Override
    protected Context createToCharCoercionContext(final Context operand) {
        return new ToCharCoercionContext(operand);
    }
    
    @Override
    protected Context createToByteCoercionContext(final Context operand) {
        return new ToByteCoercionContext(operand);
    }
    
    @Override
    protected Context createToShortCoercionContext(final Context operand) {
        return new ToShortCoercionContext(operand);
    }
    
    @Override
    protected Context createToIntCoercionContext(final Context operand) {
        return new ToIntCoercionContext(operand);
    }
    
    @Override
    protected Context createToLongCoercionContext(final Context operand) {
        return new ToLongCoercionContext(operand);
    }
    
    @Override
    protected Context createToDoubleCoercionContext(final Context operand) {
        return new ToDoubleCoercionContext(operand);
    }
    
    @Override
    protected Context createToFloatCoercionContext(final Context operand) {
        return new ToFloatCoercionContext(operand);
    }
    
    @Override
    protected Context createEqualContext(final Context firstOperand, final Context secondOperand) {
        return new EqualContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createNotEqualContext(final Context firstOperand, final Context secondOperand) {
        return new NotEqualContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createLessContext(final Context firstOperand, final Context secondOperand) {
        return new LessContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createGreaterContext(final Context firstOperand, final Context secondOperand) {
        return new GreaterContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createLessEqualContext(final Context firstOperand, final Context secondOperand) {
        return new LessEqualContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createGreaterEqualContext(final Context firstOperand, final Context secondOperand) {
        return new GreaterEqualContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createAndContext(final Context firstOperand, final Context secondOperand) {
        return new AndContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createOrContext(final Context firstOperand, final Context secondOperand) {
        return new OrContext(firstOperand, secondOperand);
    }
    
    @Override
    protected Context createNotContext(final Context operand) {
        return new NotContext(operand);
    }
    
    @Override
    protected Context createObjectConstantContext(final Object value) {
        return new ObjectConstantContext(value);
    }
    
    @Override
    protected Context createLazyObjectConstantContext(final TypeDescriptor classDescriptor) {
        return new LazyObjectConstantContext(classDescriptor);
    }
    
    @Override
    protected Context createBooleanConstantContext(final boolean value) {
        return new BooleanConstantContext(value);
    }
    
    @Override
    protected Context createIntegerConstantContext(final int value) {
        return new IntegerConstantContext(value);
    }
    
    @Override
    protected Context createLongConstantContext(final long value) {
        return new LongConstantContext(value);
    }
    
    @Override
    protected Context createFloatConstantContext(final float value) {
        return new FloatConstantContext(value);
    }
    
    @Override
    protected Context createDoubleConstantContext(final double value) {
        return new DoubleConstantContext(value);
    }
    
    @Override
    protected Context createWrappingContext(final Context operand) {
        return new WrappingContext(operand);
    }
    
    @Override
    protected Context createPerTupleContext(final StoreHandle storeHandle, final Context[] boundElements,
                    final TypeDescriptor resultType, final int[] wildcardPositions) {
        return new PerTupleContext(storeHandle, boundElements, resultType, wildcardPositions);
    }
    
    @Override
    protected StoreHandle createStoreHandleImpl() {
        return new StoreHandleDef();
    }
    
    @Override
    protected Context createActualMemberContext() {
        return new ActualMemberContext();
    };
    
    @Override
    protected Context createTopMemberContext() {
        return new TopMemberContext();
    }
    
    @Override
    protected Context createEventParameterContext(EventSignature eventSignature, String parameterName) {
        return new EventParameterContext(eventSignature, parameterName);
    }
}
