package org.alia4j.patterns;

import org.alia4j.hierarchy.TypeDescriptor;

public abstract class ParametersPattern {
    
    private static final class OrParametersPattern extends ParametersPattern {
        
        private final ParametersPattern left;
        
        private final ParametersPattern right;
        
        private OrParametersPattern(final ParametersPattern left, final ParametersPattern right) {
            this.left = left;
            this.right = right;
        }
        
        @Override
        public boolean matches(final TypeDescriptor[] typeDescriptors) {
            return this.left.matches(typeDescriptors) || this.right.matches(typeDescriptors);
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
            final OrParametersPattern other = (OrParametersPattern) obj;
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
    
    private static final class NotParametersPattern extends ParametersPattern {
        
        private final ParametersPattern operand;
        
        private NotParametersPattern(final ParametersPattern operand) {
            this.operand = operand;
        }
        
        @Override
        public boolean matches(final TypeDescriptor[] typeDescriptors) {
            return !this.operand.matches(typeDescriptors);
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
            final NotParametersPattern other = (NotParametersPattern) obj;
            if (this.operand == null) {
                if (other.operand != null)
                    return false;
            } else if (!this.operand.equals(other.operand))
                return false;
            return true;
        }
    }
    
    private static final class AndParametersPattern extends ParametersPattern {
        
        private final ParametersPattern left;
        
        private final ParametersPattern right;
        
        private AndParametersPattern(final ParametersPattern left, final ParametersPattern right) {
            this.left = left;
            this.right = right;
        }
        
        @Override
        public boolean matches(final TypeDescriptor[] typeDescriptors) {
            return this.left.matches(typeDescriptors) && this.right.matches(typeDescriptors);
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
            final AndParametersPattern other = (AndParametersPattern) obj;
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
    
    public static final ParametersPattern ANY = new ParametersPattern() {
        
        @Override
        public boolean matches(final TypeDescriptor[] typeDescriptors) {
            return true;
        }
        
        @Override
        public String toString() {
            return "..";
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
    
    public ParametersPattern and(final ParametersPattern other) {
        final ParametersPattern left = ParametersPattern.this;
        final ParametersPattern right = other;
        return new AndParametersPattern(left, right);
    }
    
    public ParametersPattern not() {
        final ParametersPattern operand = ParametersPattern.this;
        return new NotParametersPattern(operand);
    }
    
    public ParametersPattern or(final ParametersPattern other) {
        final ParametersPattern left = ParametersPattern.this;
        final ParametersPattern right = other;
        return new OrParametersPattern(left, right);
    }
    
    @Override
    abstract public int hashCode();
    
    @Override
    abstract public boolean equals(Object obj);
    
}
