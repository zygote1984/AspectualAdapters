package org.alia4j.patterns;

import org.alia4j.hierarchy.TypeDescriptor;

public abstract class ExceptionsPattern {
    
    private static final class OrExceptionsPattern extends ExceptionsPattern {
        
        private final ExceptionsPattern left;
        
        private final ExceptionsPattern right;
        
        private OrExceptionsPattern(final ExceptionsPattern left, final ExceptionsPattern right) {
            this.left = left;
            this.right = right;
        }
        
        @Override
        public boolean matches(final TypeDescriptor[] typeDescriptor) {
            final boolean leftResult = this.left.matches(typeDescriptor);
            final boolean rightResult = this.right.matches(typeDescriptor);
            return leftResult || rightResult;
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
            final OrExceptionsPattern other = (OrExceptionsPattern) obj;
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
    
    private static final class NotExceptionsPattern extends ExceptionsPattern {
        
        private final ExceptionsPattern operand;
        
        private NotExceptionsPattern(final ExceptionsPattern operand) {
            this.operand = operand;
        }
        
        @Override
        public boolean matches(final TypeDescriptor[] typeDescriptor) {
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
            final NotExceptionsPattern other = (NotExceptionsPattern) obj;
            if (this.operand == null) {
                if (other.operand != null)
                    return false;
            } else if (!this.operand.equals(other.operand))
                return false;
            return true;
        }
    }
    
    private static final class AndExceptionsPattern extends ExceptionsPattern {
        
        private final ExceptionsPattern right;
        
        private final ExceptionsPattern left;
        
        private AndExceptionsPattern(final ExceptionsPattern right, final ExceptionsPattern left) {
            this.right = right;
            this.left = left;
        }
        
        @Override
        public boolean matches(final TypeDescriptor[] typeDescriptor) {
            final boolean leftResult = this.left.matches(typeDescriptor);
            final boolean rightResult = this.right.matches(typeDescriptor);
            return leftResult && rightResult;
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
            final AndExceptionsPattern other = (AndExceptionsPattern) obj;
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
    
    public static final ExceptionsPattern ANY = new ExceptionsPattern() {
        
        @Override
        public boolean matches(final TypeDescriptor[] typeDescriptor) {
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
    
    public abstract boolean matches(TypeDescriptor[] typeDescriptors);
    
    public ExceptionsPattern and(final ExceptionsPattern other) {
        final ExceptionsPattern left = ExceptionsPattern.this;
        final ExceptionsPattern right = other;
        return new AndExceptionsPattern(right, left);
    }
    
    public ExceptionsPattern not() {
        final ExceptionsPattern operand = ExceptionsPattern.this;
        return new NotExceptionsPattern(operand);
    }
    
    public ExceptionsPattern or(final ExceptionsPattern other) {
        final ExceptionsPattern left = ExceptionsPattern.this;
        final ExceptionsPattern right = other;
        return new OrExceptionsPattern(left, right);
    }
    
    @Override
    abstract public int hashCode();
    
    @Override
    abstract public boolean equals(Object obj);
    
}
