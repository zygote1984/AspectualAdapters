package org.alia4j.liam.pattern;

import org.alia4j.liam.signature.FieldReadSignature;
import org.alia4j.patterns.ClassTypePattern;
import org.alia4j.patterns.ModifiersPattern;
import org.alia4j.patterns.NamePattern;
import org.alia4j.patterns.TypePattern;

public class FieldReadPattern extends FieldPattern<FieldReadSignature> {
    
    public static final FieldReadPattern ANY =
                    new FieldReadPattern(ModifiersPattern.ANY, TypePattern.ANY, ClassTypePattern.ANY, NamePattern.ANY);
    
    public FieldReadPattern(final ModifiersPattern modifiersPattern, final TypePattern typePattern,
                    final ClassTypePattern declaringClassPattern, final NamePattern namePattern) {
        super(modifiersPattern, typePattern, declaringClassPattern, namePattern);
    }
    
}
