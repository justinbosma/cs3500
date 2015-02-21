

/**
 * An interface for a visitor that performs on int and R
 * 
 * @author Jessica Young Schmidt
 */
public interface IntVisitorR<R> {

    /**
     * Performs some arbitrary operation with an int and an object of the type R
     * as parameters, and returns an instance of the type R as its result.
     * 
     * @param s
     *            StackInt that will be used by the arbitrary operation
     *            within visit
     * @param x
     *            int that will be used by the arbitrary operation within visit
     * @return output of arbitrary operation on r and x
     */
    public R visit(StackInt s, int x);

    /**
     * @return the base value for this operation
     */
    public R getBase();
}
