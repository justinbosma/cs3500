package c04;

/**
 * Empty represents a stack that contains no ints
 * 
 * @author Jessica Young Schmidt
 * @version 2014-01-08
 */
class Empty extends StackInt {
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
}