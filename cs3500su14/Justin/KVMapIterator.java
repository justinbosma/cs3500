import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Justin Bosma Username: jbosma0
 * @version 5/20/14
 * @param <K>
 * 
 */
public class KVMapIterator<K> implements Iterator<K> {
    private int currentPosition;
    private ArrayList<K> list;
    /**
     * new instance of KVMap
     * @param a Arraylist
     */
    public KVMapIterator(ArrayList<K> a) {
        this.list = a;
        this.currentPosition = 0;
    }
    /**
     *new instance of KVMap
     * @param a Arraylist
     * @param c comparator
     */
    public KVMapIterator(Comparator<? super K> c, ArrayList<K> a) {
        this.list = a;
        this.currentPosition = 0;
    }
    /**
     * overridden hasNext
     * @return true if has next
     */
    public boolean hasNext() {
        return currentPosition < list.size();
    }
    /**
     * overridden next method
     * @return returns next key
     */
    public K next() {
        if (this.hasNext()) {
            K k = list.get(currentPosition);
            currentPosition = currentPosition + 1;
            return k;
        }
        else {
            throw new NoSuchElementException();
        }
    }
    /**
     * does nothing but throw exception
     */
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
