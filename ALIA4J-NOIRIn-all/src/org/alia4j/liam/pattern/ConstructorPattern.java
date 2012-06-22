package org.alia4j.liam.pattern;

import org.alia4j.liam.signature.ConstructorSignature;
import org.alia4j.patterns.ClassTypePattern;
import org.alia4j.patterns.ExceptionsPattern;
import org.alia4j.patterns.ModifiersPattern;
import org.alia4j.patterns.ParametersPattern;

public class ConstructorPattern extends Pattern<ConstructorSignature> {

	public static final ConstructorPattern ANY = new ConstructorPattern(
			ModifiersPattern.ANY, ClassTypePattern.ANY, ParametersPattern.ANY,
			ExceptionsPattern.ANY);

	private final ModifiersPattern modifiersPattern;

	private final ClassTypePattern declaringClassPattern;

	private final ParametersPattern parametersPattern;

	private final ExceptionsPattern exceptionsPattern;

	public ConstructorPattern(final ModifiersPattern modifiersPattern,
			final ClassTypePattern declaringClassPattern,
			final ParametersPattern parametersPattern,
			final ExceptionsPattern exceptionsPattern) {
		super();
		this.modifiersPattern = modifiersPattern;
		this.declaringClassPattern = declaringClassPattern;
		this.parametersPattern = parametersPattern;
		this.exceptionsPattern = exceptionsPattern;
	}

	public ClassTypePattern getDeclaringClassPattern() {
		return this.declaringClassPattern;
	}

	public ModifiersPattern getModifiersPattern() {
		return this.modifiersPattern;
	}

	public ParametersPattern getParametersPattern() {
		return this.parametersPattern;
	}

	public ExceptionsPattern getExceptionsPattern() {
		return this.exceptionsPattern;
	}

	@Override
	public boolean match(final ConstructorSignature signature) {
		return this.modifiersPattern.matches(signature.getModifiers())
				&& this.declaringClassPattern.matches(signature
						.getDeclaringClass())
				&& this.parametersPattern
						.matches(signature.getParameterTypes())
				&& this.exceptionsPattern
						.matches(signature.getExceptionTypes());
	}

	@Override
	public String toString() {
		return this.modifiersPattern + " " + this.declaringClassPattern
				+ ".new(" + this.parametersPattern + ") throws "
				+ this.exceptionsPattern;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.declaringClassPattern == null) ? 0
						: this.declaringClassPattern.hashCode());
		result = prime
				* result
				+ ((this.exceptionsPattern == null) ? 0
						: this.exceptionsPattern.hashCode());
		result = prime
				* result
				+ ((this.modifiersPattern == null) ? 0 : this.modifiersPattern
						.hashCode());
		result = prime
				* result
				+ ((this.parametersPattern == null) ? 0
						: this.parametersPattern.hashCode());
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
		final ConstructorPattern other = (ConstructorPattern) obj;
		if (this.declaringClassPattern == null) {
			if (other.declaringClassPattern != null)
				return false;
		} else if (!this.declaringClassPattern
				.equals(other.declaringClassPattern))
			return false;
		if (this.exceptionsPattern == null) {
			if (other.exceptionsPattern != null)
				return false;
		} else if (!this.exceptionsPattern.equals(other.exceptionsPattern))
			return false;
		if (this.modifiersPattern == null) {
			if (other.modifiersPattern != null)
				return false;
		} else if (!this.modifiersPattern.equals(other.modifiersPattern))
			return false;
		if (this.parametersPattern == null) {
			if (other.parametersPattern != null)
				return false;
		} else if (!this.parametersPattern.equals(other.parametersPattern))
			return false;
		return true;
	}

}
