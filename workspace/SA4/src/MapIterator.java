import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * MapIterator class - Iterator for KVMap class
 * @param <K> - the Generic Type K for Key
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 14, 2014
 */
public class MapIterator<K> implements Iterator<K> {
    //private Comparator<? super K> c0;
    
    private ArrayList<K> al;
    /**
     * Constructor for MapIterator class
     * @param al - the arraylist
     */
    public MapIterator(ArrayList<K> al) {
        this.al = al;
    }
    /**
     * Constructor for MapIterator class with Comparator
     * @param al1 - the arraylist
     * @param c - the comparator
     */
    public MapIterator(ArrayList<K> al1, Comparator<? super K> c) {
        //this.c0 = c;
        Collections.sort(al1, c);
        this.al = al1;
    }
    /**
     * Does the Map have a next item?
     * @return boolean true if has next, false if not
     */
    @Override
    public boolean hasNext() {
        return (al.size() > 0);
    }
    /**
     * Get the next item
     * @return If hasNext is false (no next element) 
     * throw NoSuchElementException
     */
    @Override
    public K next() {
        if (this.hasNext()) {
            return al.remove(0);
        }
        else {
            throw new NoSuchElementException("::Iterator::next::illegal");
        }
    }
    /**
     * Remove an item
     * Throws an UnsupportedOperationException
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("::Iterator::remove::illegal");
    }
    
}