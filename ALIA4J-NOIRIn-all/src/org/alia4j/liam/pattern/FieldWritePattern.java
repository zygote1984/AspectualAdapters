package org.alia4j.liam.pattern;

import org.alia4j.liam.signature.FieldWriteSignature;
import org.alia4j.patterns.ClassTypePattern;
import org.alia4j.patterns.ModifiersPattern;
import org.alia4j.patterns.NamePattern;
import org.alia4j.patterns.TypePattern;

public class FieldWritePattern extends FieldPattern<FieldWriteSignature> {
    
    public static final FieldWritePattern ANY =
                    new FieldWritePattern(ModifiersPattern.ANY, TypePattern.ANY, ClassTypePattern.ANY, NamePattern.ANY);
    
    public FieldWritePattern(final ModifiersPattern modifiersPattern, final TypePattern typePattern,
                    final ClassTypePattern declaringClassPattern, final NamePattern namePattern) {
        super(modifiersPattern, typePattern, declaringClassPattern, namePattern);
    }
    
}
