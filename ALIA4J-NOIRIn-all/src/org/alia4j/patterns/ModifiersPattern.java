package org.alia4j.patterns;

public abstract class ModifiersPattern {
    
    private static final class OrModifiersPattern extends ModifiersPattern {
        
        private final ModifiersPattern right;
        
        private final ModifiersPattern left;
        
        private OrModifiersPattern(final ModifiersPattern right, final ModifiersPattern left) {
            this.right = right;
            this.left = left;
        }
        
        @Override
        public boolean matches(final int modifier) {
            return this.left.matches(modifier) || this.right.matches(modifier);
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
            final OrModifiersPattern other = (OrModifiersPattern) obj;
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
    
    private static final class NotModifiersPattern extends ModifiersPattern {
        
        private final ModifiersPattern operand;
        
        private NotModifiersPattern(final ModifiersPattern operand) {
            this.operand = operand;
            
        }
        
        @Override
        public boolean matches(final int modifier) {
            return !this.operand.matches(modifier);
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
            final NotModifiersPattern other = (NotModifiersPattern) obj;
            if (this.operand == null) {
                if (other.operand != null)
                    return false;
            } else if (!this.operand.equals(other.operand))
                return false;
            return true;
        }
    }
    
    private static final class AndModifiersPattern extends ModifiersPattern {
        
        private final ModifiersPattern left;
        
        private final ModifiersPattern right;
        
        private AndModifiersPattern(final ModifiersPattern left, final ModifiersPattern right) {
            this.left = left;
            this.right = right;
        }
        
        @Override
        public boolean matches(final int modifier) {
            return this.left.matches(modifier) && this.right.matches(modifier);
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
            final AndModifiersPattern other = (AndModifiersPattern) obj;
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
    
    public static final ModifiersPattern ANY = new ModifiersPattern() {
        
        @Override
        public boolean matches(final int modifier) {
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
    
    public abstract boolean matches(int modifier);
    
    public ModifiersPattern and(final ModifiersPattern other) {
        final ModifiersPattern left = ModifiersPattern.this;
        final ModifiersPattern right = other;
        return new AndModifiersPattern(left, right);
    }
    
    public ModifiersPattern not() {
        return new NotModifiersPattern(this);
    }
    
    public ModifiersPattern or(final ModifiersPattern other) {
        final ModifiersPattern left = ModifiersPattern.this;
        final ModifiersPattern right = other;
        return new OrModifiersPattern(right, left);
    }
    
    @Override
    abstract public int hashCode();
    
    @Override
    abstract public boolean equals(Object obj);
    
}
