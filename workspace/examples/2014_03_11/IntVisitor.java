/**
 * An interface for a visitor that performs on ints
 * 
 * @author Jessica Young Schmidt
 */
public interface IntVisitor {

    /**
     * Performs some arbitrary operation with a int as parameter, and returns a
     * int as its result.
     * 
     * @param x
     *            int to perform action on
     * @return result of performing action
     */
    public int visit(int x);
}
