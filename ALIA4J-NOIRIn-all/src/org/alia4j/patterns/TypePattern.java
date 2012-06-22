package org.alia4j.patterns;

import org.alia4j.hierarchy.TypeDescriptor;

public abstract class TypePattern {
    
    private static final class OrTypePattern extends TypePattern {
        
        private final TypePattern left;
        
        private final TypePattern right;
        
        private OrTypePattern(final TypePattern left, final TypePattern right) {
            this.left = left;
            this.right = right;
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
            final OrTypePattern other = (OrTypePattern) obj;
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
    
    private static final class NotTypePattern extends TypePattern {
        
        private final TypePattern operand;
        
        private NotTypePattern(final TypePattern operand) {
            this.operand = operand;
        }
        
        @Override
        public boolean matches(final TypeDescriptor typeDescriptor) {
            return !this.operand.matches(typeDescriptor);
        }
        
        @Override
        public String toString() {
            return "!" + this.operand.toString();
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
            final NotTypePattern other = (NotTypePattern) obj;
            if (this.operand == null) {
                if (other.operand != null)
                    return false;
            } else if (!this.operand.equals(other.operand))
                return false;
            return true;
        }
    }
    
    private static final class AndTypePattern extends TypePattern {
        
        private final TypePattern left;
        
        private final TypePattern right;
        
        private AndTypePattern(final TypePattern left, final TypePattern right) {
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
            final AndTypePattern other = (AndTypePattern) obj;
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
    
    public static final TypePattern ANY = new TypePattern() {
        
        @Override
        public boolean matches(final TypeDescriptor typeDescriptor) {
            return true;
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
    
    public abstract boolean matches(TypeDescriptor typeDescriptor);
    
    public TypePattern and(final TypePattern other) {
        final TypePattern left = TypePattern.this;
        final TypePattern right = other;
        return new AndTypePattern(left, right);
    }
    
    public TypePattern not() {
        final TypePattern operand = TypePattern.this;
        return new NotTypePattern(operand);
    }
    
    public TypePattern or(final TypePattern other) {
        final TypePattern left = TypePattern.this;
        final TypePattern right = other;
        return new OrTypePattern(left, right);
    }
    
    @Override
    abstract public int hashCode();
    
    @Override
    abstract public boolean equals(Object obj);
    
}
