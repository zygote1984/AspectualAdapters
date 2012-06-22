package org.alia4j.patterns;

import org.alia4j.hierarchy.TypeDescriptor;

// TODO: how should nested classes be matched. At language level they're called Outer.Inner, at VM level Outer$Inner
// we need to define and document this and we need a test case.
public abstract class ClassTypePattern extends TypePattern {
    
    private static final class OrClassTypePattern extends ClassTypePattern {
        
        private final ClassTypePattern right;
        
        private final ClassTypePattern left;
        
        private OrClassTypePattern(final ClassTypePattern right, final ClassTypePattern left) {
            this.right = right;
            this.left = left;
        }
        
        @Override
        public boolean matches(final TypeDescriptor typeDescriptor) {
            return this.left.matches(typeDescriptor) || this.right.matches(typeDescriptor);
        }
        
        @Override
        public String toString() {
            return "(" + this.left.toString() + " || " + this.right.toString() + ")";
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((this.left == null) ? 0 : this.left.hashCode());
            result = prime * result + ((this.right == null) ? 0 : this.right.hashCode());
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
            final OrClassTypePattern other = (OrClassTypePattern) obj;
            if (this.left == null) {
                if (other.left != null)
                    return false;
            } else if (!this.left.equals(other.left))
                return false;
            if (this.right == null) {
                if (other.right != null)
                    return false;
            } else if (!this.right.equals(other.right))
                return false;
            return true;
        }
        
    }
    
    private static final class NotClassTypePattern extends ClassTypePattern {
        
        private final ClassTypePattern operand;
        
        private NotClassTypePattern(final ClassTypePattern operand) {
            this.operand = operand;
        }
        
        @Override
        public boolean matches(final TypeDescriptor typeDescriptor) {
            return !this.operand.matches(typeDescriptor);
        }
        
        @Override
        public String toString() {
            return "!" + this.operand.toString() + "";
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((this.operand == null) ? 0 : this.operand.hashCode());
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
            final NotClassTypePattern other = (NotClassTypePattern) obj;
            if (this.operand == null) {
                if (other.operand != null)
                    return false;
            } else if (!this.operand.equals(other.operand))
                return false;
            return true;
        }
    }
    
    private static final class AndClassTypePattern extends ClassTypePattern {
        
        private final ClassTypePattern left;
        
        private final ClassTypePattern right;
        
        private AndClassTypePattern(final ClassTypePattern left, final ClassTypePattern right) {
            this.left = left;
            this.right = right;
        }
        
        @Override
        public boolean matches(final TypeDescriptor typeDescriptor) {
            return this.left.matches(typeDescriptor) && this.right.matches(typeDescriptor);
        }
        
        @Override
        public String toString() {
            return "(" + this.left.toString() + " && " + this.right.toString() + ")";
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((this.left == null) ? 0 : this.left.hashCode());
            result = prime * result + ((this.right == null) ? 0 : this.right.hashCode());
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
            final OrClassTypePattern other = (OrClassTypePattern) obj;
            if (this.left == null) {
                if (other.left != null)
                    return false;
            } else if (!this.left.equals(other.left))
                return false;
            if (this.right == null) {
                if (other.right != null)
                    return false;
            } else if (!this.right.equals(other.right))
                return false;
            return true;
        }
    }
    
    /**
     * Matches any class type. Array and primitive types are not matched.
     */
    public static final ClassTypePattern ANY = new ClassTypePattern() {
        
        @Override
        public boolean matches(final TypeDescriptor typeDescriptor) {
            return typeDescriptor.isClassType();
        }
        
        @Override
        public String toString() {
            return "*";
        }
        
        @Override
        public boolean equals(final Object obj) {
            return this == obj;
        };
        
        @Override
        public int hashCode() {
            return System.identityHashCode(this);
        };
    };
    
    @Override
    public abstract boolean matches(TypeDescriptor typeDescriptor);
    
    public ClassTypePattern and(final ClassTypePattern other) {
        final ClassTypePattern left = ClassTypePattern.this;
        final ClassTypePattern right = other;
        return new AndClassTypePattern(left, right);
    }
    
    @Override
    public ClassTypePattern not() {
        final ClassTypePattern operand = ClassTypePattern.this;
        return new NotClassTypePattern(operand);
    }
    
    public ClassTypePattern or(final ClassTypePattern other) {
        final ClassTypePattern left = ClassTypePattern.this;
        final ClassTypePattern right = other;
        return new OrClassTypePattern(right, left);
    }
    
    @Override
    abstract public int hashCode();
    
    @Override
    abstract public boolean equals(Object obj);
    
}
