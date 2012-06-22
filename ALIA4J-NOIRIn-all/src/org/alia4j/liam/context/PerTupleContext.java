package org.alia4j.liam.context;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;
import org.alia4j.util.Tuple;

/**
 * @author Christoph Bockisch
 * @author Andre Loker
 */
public class PerTupleContext extends Context {
    
    private final TypeDescriptor resultType;
    
    private final Context[] boundElements;
    
    private final int[] wildcardPositions;
    
    private final StoreHandle storeHandle;
    
    static final int[] EMPTY_INT_ARRAY = new int[0];
    
    public PerTupleContext(final StoreHandle storeHandle, final Context[] boundElements, final TypeDescriptor resultType,
                    final int[] wildcardPositionsIn) {
        super(Collections.singletonList(ContextFactory.findOrCreateToArrayContext(boundElements)));
        this.resultType = resultType;
        this.storeHandle = storeHandle;
        this.boundElements = boundElements;
        this.wildcardPositions = wildcardPositionsIn != null ? wildcardPositionsIn : PerTupleContext.EMPTY_INT_ARRAY;
        Arrays.sort(this.wildcardPositions);
    }
    
    @Override
    public Maybe<Object> computeValueStatically(final List<? extends Signed<?>> callStack) {
        return new Maybe<Object>();
    }
    
    @Override
    public SimpleType getDeclaredResultType(final Signed<?> call) {
        return SimpleType.REFERENCE;
    }
    
    public final Object getObjectValue(final Object input) {
        final Object[] tuple = (Object[]) input;
        Object[] result = this.storeHandle.getMatched(tuple, this.wildcardPositions);
        if (result.length == 0 && this.resultType != null) {
            assert this.wildcardPositions.length == 0;
            // XXX Add class loader awareness.
            Class<?> clazz;
            try {
                clazz = this.resultType.asClass();
                result = new Object[] { clazz.newInstance() };
            } catch (final ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (final InstantiationException e) {
                throw new RuntimeException(e);
            } catch (final IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            this.storeHandle.add(new Tuple<Object>(tuple), result[0]);
        }
        return result;
    }
    
    @Override
    public String toString() {
        return "${perTuple[store=" + this.storeHandle + ", resultType=" + this.resultType + ", boundElements size="
                        + this.boundElements.length + ", wildcardPositions size" + this.wildcardPositions.length + "]}";
    }
}
