/**
 * StackInt represents a stack of ints
 * 
 * @author Jessica Young Schmidt
 * @version 2014-01-08
 */
public abstract class StackInt {
    /**
     * Method returns whether the StackInt is empty
     * 
     * @return boolean stating whether this stack is empty
     */
    abstract boolean isEmptyMethod();

    /**
     * Method returns the top element of the stack
     * 
     * @return top element of this stack
     */
    abstract int topMethod();

    /**
     * Pops the top element off of the stack
     * 
     * @return this stack without top element
     */
    abstract StackInt popMethod();

    /**
     * Returns the size of the stack
     * 
     * @return size of this stack
     */
    abstract int sizeMethod();

    /**
     * Returns an empty stack
     * 
     * @return empty stack
     */
    public static StackInt empty() {
        return new Empty();
    }

    /**
     * Returns a stack where s is the base and n is the top
     * 
     * @param s
     *            a stack that will become base
     * @param n
     *            int that will be top
     * @return a stack where s is the base and n is the top
     */
    public static StackInt push(StackInt s, int n) {
        return new Push(s, n);
    }

    /**
     * Method returns whether s is empty
     * 
     * @param s
     *            StackInt to check whether it is empty
     * @return boolean stating whether s is empty
     */
    public static boolean isEmpty(StackInt s) {
        return s.isEmptyMethod();
    }

    /**
     * Method returns the top element of the stack
     * 
     * @param s
     *            StackInt to get top of
     * @return top element of this stack
     */
    public static int top(StackInt s) {
        return s.topMethod();
    }

    /**
     * Pops the top element off of s
     * 
     * @param s
     *            StackInt to pop top off of
     * @return s without top element
     */
    public static StackInt pop(StackInt s) {
        return s.popMethod();
    }

    /**
     * Returns the size of s
     * 
     * @param s
     *            a StackInt to get size of
     * @return size of s
     */
    public static int size(StackInt s) {
        return s.sizeMethod();
    }
    
    /**
     * 
     * @param v IntVisitor to use traverse StackInt
     * @return results based on IntVisitor
     */
    public abstract StackInt accept(IntVisitor v);
    
    public abstract <R> R acceptR(IntVisitorR<R> v);
    
    /**
     * Empty represents a stack that contains no ints
     * 
     * @author Jessica Young Schmidt
     * @version 2014-01-08
     */
    static class Empty extends StackInt {
        /**
         * Constructor for Empty
         */
        Empty() {

        }

        /**
         * Method returns whether the StackInt is empty
         * 
         * @return boolean stating whether this stack is empty
         */
        boolean isEmptyMethod() {
            return true;
        }

        /**
         * Method returns the top element of the stack
         * 
         * @return top element of this stack
         */
        int topMethod() {
            String msg1 = "attempted to compute the top of an empty StackInt";
            throw new RuntimeException(msg1);
        }

        /**
         * Pops the top element off of the stack
         * 
         * @return this stack without top element
         */
        StackInt popMethod() {
            String msg1 = "attempted to pop from an empty StackInt";
            throw new RuntimeException(msg1);
        }

        /**
         * Returns the size of the stack
         * 
         * @return size of this stack
         */
        int sizeMethod() {
            return 0;
        }

        @Override
        public StackInt accept(IntVisitor v) {
            return this;
        }

        @Override
        public <R> R acceptR(IntVisitorR<R> v) {
            return v.getBase();
        }
    }
    
    /**
     * Push represents an non-empty Stack of ints
     * 
     * @author Jessica Young Schmidt
     * @version 2014-01-08
     */
    static class Push extends StackInt {
        /** other elements of this StackInt */
        StackInt s;
        /** topmost element of this StackInt */
        int n;

        /**
         * Push constructor
         * 
         * @param s
         *            the stack without topmost element
         * @param n
         *            the topmost element
         */
        Push(StackInt s, int n) {
            this.s = s;
            this.n = n;
        }

        /**
         * Method returns whether the StackInt is empty
         * 
         * @return boolean stating whether this stack is empty
         */
        boolean isEmptyMethod() {
            return false;
        }

        /**
         * Method returns the top element of the stack
         * 
         * @return top element of this stack
         */
        int topMethod() {
            return n;
        }

        /**
         * Pops the top element off of the stack
         * 
         * @return this stack without top element
         */
        StackInt popMethod() {
            return s;
        }

        /**
         * Returns the size of the stack
         * 
         * @return size of this stack
         */
        int sizeMethod() {
            return 1 + StackInt.size(s);
        }

        @Override
        public StackInt accept(IntVisitor v) {
            int newTop = v.visit(n);
            StackInt newStack = s.accept(v);
            return StackInt.push(newStack, newTop);
        }

        @Override
        public <R> R acceptR(IntVisitorR<R> v) {
            return v.visit(s.acceptR(v), n);
        }
    }
}