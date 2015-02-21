package IntegerIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntegerIterator implements Iterator<Integer> {
    final int MAX = 10;
    int current;// = 0;

    public IntegerIterator() {
        current = 0;
    }

    public boolean hasNext() {
        return current <= MAX;
    }

    public Integer next() {
        if (hasNext()) {
            int ret = current;
            current = current + 1;
            return new Integer(ret);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}