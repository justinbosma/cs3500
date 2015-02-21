import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * IntegerIterator iterates through Integers 0-MAX
 * 
 * @author CS3500sp14 in class on 1/28/2014
 */
public class IntegerIterator implements Iterator<Integer> {
    int n; // next element
    final int MAX = 10;

    /**
     * Initializes the state of the iterator
     */
    public IntegerIterator() {
        n = 0;
    }

    /**
     * @return whether there is another integer in the iterator
     */
    public boolean hasNext() {
        return n <= MAX;
    }

    /**
     * Returns the next Integer
     * 
     * @return the next Integer
     */
    public Integer next() {
        if (hasNext()) {
            n = n + 1;
            return n - 1;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    /**
     * remove is an Unsupported Operation
     */
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}