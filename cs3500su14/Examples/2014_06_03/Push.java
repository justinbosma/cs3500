
/**
 * Push represents an non-empty Stack of ints
 * @author Jessica Young Schmidt
 * @version cs3500su14 - c02
 */
class Push extends StackInt{
    /** other elements of this StackInt */
    StackInt s;  
    /** topmost element of this StackInt */
    int n;

    /**
     * Push constructor
     * @param s the stack without topmost element
     * @param n the topmost element
     */
    Push(StackInt s, int n){
        this.s = s;
        this.n = n;
    }


    /**
     * Method returns whether the StackInt is empty
     * @return boolean stating whether this stack is empty
     */
    boolean isEmptyMethod() {
        return false;
    }

    /**
     * Method returns the top element of the stack
     * @return top element of this stack
     */
    int topMethod() {
        return n;
    }

    /**
     * Pops the top element off of the stack
     * @return this stack without top element
     */
    StackInt popMethod() {
        return s;
    }

    /**
     * Returns the size of the stack
     * @return size of this stack
     */
    int sizeMethod() {
        return 1 + StackInt.size(s);
    }
    public  StackInt accept(IntVisitor v){
        int newTop = v.visit(n);
        StackInt newStack = s.accept(v);
        return StackInt.push(newStack, newTop);
    }
    
    public <R> R acceptR(IntVisitorR<R> v){
        return v.visit(s, n);
    }
}