package mymap;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 4 : 1/28/14
 * @param <K>
 */
public class KeyIterator<K> implements Iterator<K> {
    //private Iterator<K> it;
    @SuppressWarnings("rawtypes")
    private MyMap m0;
    private ArrayList<K> keys;
    private int n = 0;
    /**
     * Constructor - Initializes the iterator
     * @param m - MyMap object
     */
    @SuppressWarnings("unchecked")
    public KeyIterator(MyMap<K, ?> m) {
        if (m.isEmpty()) {
            this.keys = new ArrayList<K>();
            //this.it = keys.iterator();
        }
        else {
            this.m0 = m;
            this.keys = m0.getAllKeys();
            //this.it = keys.iterator();
        }
    }
    /**
     * Constructor for KeyIterator with comparator
     * @param m - the map
     * @param comp - the method of comparison
     */
    @SuppressWarnings("unchecked")
    public KeyIterator(@SuppressWarnings("rawtypes") MyMap m, 
            Comparator<? super K> comp) {
        if (m.isEmpty()) {
            this.keys = new ArrayList<K>();
            //this.it = keys.iterator();
        }
        else {
            this.m0 = m;
            this.keys = m.getAllKeys();
            Collections.sort(keys, comp);
            //this.it = keys.iterator();
        }
    }
    /**
     * Constructor for KeyIterator
     * @param allKeys - all the keys in the map in an arraylist
     */
    public KeyIterator(ArrayList<K> allKeys) {
        this.keys = allKeys;
        //this.it = keys.iterator();
    }
    @Override
    /**
     * Returns true if the iteration has more elements. 
     * (In other words, returns true if next() would return 
     * an element rather than throwing an exception.)
     */
    public boolean hasNext() {
        
        //return it.hasNext();
        return n < keys.size();
    }
    @Override
    /**
     * Returns the next element in the iteration.
     */
    public K next() {
        //try {
        if (this.hasNext()) {
            //return it.next();
            this.n = n + 1;
            return keys.get(n - 1);
        }
        else {
        //catch (Exception e) {
            throw new NoSuchElementException("next is not here");
        }

    }
    @Override
    /**
     * Throws an Exception
     */
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}