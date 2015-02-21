package c15.refactoring;

/**
 * StackInt represents a stack of ints
 * 
 * @author Jessica Young Schmidt
 * @version 2014-01-08
 */
public class StackInt {
    // /**
    // * Method returns whether the StackInt is empty
    // *
    // * @return boolean stating whether this stack is empty
    // */
    // abstract boolean isEmptyMethod();
    //
    // /**
    // * Method returns the top element of the stack
    // *
    // * @return top element of this stack
    // */
    // abstract int topMethod();
    //
    // /**
    // * Pops the top element off of the stack
    // *
    // * @return this stack without top element
    // */
    // abstract StackInt popMethod();
    //
    // /**
    // * Returns the size of the stack
    // *
    // * @return size of this stack
    // */
    // abstract int sizeMethod();

    // private static StackInt theEmptyStackInt = new Empty();
    /**
     * Returns an empty stack
     * 
     * @return empty stack
     */
    public static StackInt empty() {
        // return new Empty();
        // return theEmptyStackInt;
        return null;
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
        return new StackInt(s, n);// Push(s, n);
    }

    /**
     * Method returns whether s is empty
     * 
     * @param s
     *            StackInt to check whether it is empty
     * @return boolean stating whether s is empty
     */
    public static boolean isEmpty(StackInt s) {
        if (s == null) {
            return true;
        }
        else {
            return false;// s.isEmptyMethod();
        }
    }

    /**
     * Method returns the top element of the stack
     * 
     * @param s
     *            StackInt to get top of
     * @return top element of this stack
     */
    public static int top(StackInt s) {
        if (s == null) {
            throw new RuntimeException("top");
        }
        return s.n;// s.topMethod();
    }

    /**
     * Pops the top element off of s
     * 
     * @param s
     *            StackInt to pop top off of
     * @return s without top element
     */
    public static StackInt pop(StackInt s) {
        if (s == null) {
            throw new RuntimeException("pop");
        }
        return s.s;// popMethod();
    }

    /**
     * Returns the size of s
     * 
     * @param s
     *            a StackInt to get size of
     * @return size of s
     */
    public static int size(StackInt s) {
        if (s == null) {
            return 0;
        }
        return 1 + StackInt.size(s.s);// s.sizeMethod();
    }

    // /**
    // * Push represents an non-empty Stack of ints
    // *
    // * @author Jessica Young Schmidt
    // * @version 204-01-08
    // */
    // private static class Push extends StackInt {
    /** other elements of this StackInt */
    private StackInt s;
    /** topmost element of this StackInt */
    private int n;

    /**
     * Push constructor
     * 
     * @param s
     *            the stack without topmost element
     * @param n
     *            the topmost element
     */
    // Push(StackInt s, int n) {
    private StackInt(StackInt s, int n) {
        this.s = s;
        this.n = n;
    }

    StackInt() {
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

    // }

    // /**
    // * Empty represents a stack that contains no ints
    // *
    // * @author Jessica Young Schmidt
    // * @version 2014-01-08
    // */
    // private static class Empty extends StackInt {
    // /**
    // * Constructor for Empty
    // */
    // Empty() {
    //
    // }
    //
    // /**
    // * Method returns whether the StackInt is empty
    // *
    // * @return boolean stating whether this stack is empty
    // */
    // boolean isEmptyMethod() {
    // return true;
    // }
    //
    // /**
    // * Method returns the top element of the stack
    // *
    // * @return top element of this stack
    // */
    // int topMethod() {
    // String msg1 = "attempted to compute the top of an empty StackInt";
    // throw new RuntimeException(msg1);
    // }
    //
    // /**
    // * Pops the top element off of the stack
    // *
    // * @return this stack without top element
    // */
    // StackInt popMethod() {
    // String msg1 = "attempted to pop from an empty StackInt";
    // throw new RuntimeException(msg1);
    // }
    //
    // /**
    // * Returns the size of the stack
    // *
    // * @return size of this stack
    // */
    // int sizeMethod() {
    // return 0;
    // }
    // }
}