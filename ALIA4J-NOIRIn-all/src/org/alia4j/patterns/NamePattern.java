package org.alia4j.patterns;

public abstract class NamePattern {
    
    private static final class OrNamePattern extends NamePattern {
        
        private final NamePattern left;
        
        private final NamePattern right;
        
        private OrNamePattern(final NamePattern left, final NamePattern right) {
            this.left = left;
            this.right = right;
        }
        
        @Override
        public boolean matches(final CharSequence name) {
            return this.left.matches(name) || this.right.matches(name);
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
            final OrNamePattern other = (OrNamePattern) obj;
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
    
    private static final class NotNamePattern extends NamePattern {
        
        private final NamePattern operand;
        
        private NotNamePattern(final NamePattern operand) {
            this.operand = operand;
        }
        
        @Override
        public boolean matches(final CharSequence name) {
            return !this.operand.matches(name);
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
            final NotNamePattern other = (NotNamePattern) obj;
            if (this.operand == null) {
                if (other.operand != null)
                    return false;
            } else if (!this.operand.equals(other.operand))
                return false;
            return true;
        }
    }
    
    private static final class AndNamePattern extends NamePattern {
        
        private final NamePattern left;
        
        private final NamePattern right;
        
        private AndNamePattern(final NamePattern left, final NamePattern right) {
            this.left = left;
            this.right = right;
        }
        
        @Override
        public boolean matches(final CharSequence name) {
            return this.left.matches(name) && this.right.matches(name);
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
            final AndNamePattern other = (AndNamePattern) obj;
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
    
    public static final NamePattern ANY = new NamePattern() {
        
        @Override
        public boolean matches(final CharSequence name) {
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
    
    public abstract boolean matches(CharSequence name);
    
    public NamePattern and(final NamePattern other) {
        final NamePattern left = NamePattern.this;
        final NamePattern right = other;
        return new AndNamePattern(left, right);
    }
    
    public NamePattern not() {
        final NamePattern operand = NamePattern.this;
        return new NotNamePattern(operand);
    }
    
    public NamePattern or(final NamePattern other) {
        final NamePattern left = NamePattern.this;
        final NamePattern right = other;
        return new OrNamePattern(left, right);
    }
    
    @Override
    abstract public int hashCode();
    
    @Override
    abstract public boolean equals(Object obj);
    
}
