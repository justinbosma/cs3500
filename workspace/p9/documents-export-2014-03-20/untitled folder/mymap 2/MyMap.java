package mymap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 4 : 1/28/14
 * @param <K> - The key stored in the map 
 * @param <V> - the the value stored in the map
 *
 */
public abstract class MyMap<K, V> implements Iterable<K> {
    //private K key;
    //private V value;
    /**
     * Instantiates a new Empty MyMap
     * @return MyMap
     */
    @SuppressWarnings("rawtypes")
    public static MyMap empty() {
        return  new Empty();
    }
    /**
     * Instantiates a new Empty MyMap
     * @param c - the Comparator
     * @return MyMap
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static MyMap empty(Object c) {
        return new EmptyNode((Comparator) c);
    }
    /**
     * Adds values to the MyMap
     * @param key - the key in the map
     * @param value - the value in the map
     * @return a MyMap
     */
    public abstract MyMap<K, V> include(K key, V value);
    /**
     * Adds values to the MyMap
     * @param key - the key in the map
     * @param value - the value in the map
     * @param m - the map
     * @return a MyMap
     */

    /**
     * Is the MyMap empty?
     * @return boolean
     */
    public abstract boolean isEmpty();
    /**
     * What is the size of the MyMap?
     * @return int
     */
    public abstract int size();
    /**
     * Does the MyMap contain the key?
     * @param key - the key in the map
     * @return boolean
     */
    public abstract boolean containsKey(K key);
    /**
     * Get the value associated with the key
     * @param key - the key in the map
     * @return V - the value
     */
    public abstract V get(K key);
    /**
     * Sets a value in the map
     * @param key - the key in the map
     * @param value - the value in the map
     * @return MyMap
     */
    public abstract MyMap<K, V> set(K key, V value);
    /**
     * Returns the MyMap as a string
     * @return MyMap
     */
    public abstract String toString();
    /**
     * Are the two MyMaps equal?
     * @param x - The object to compare
     * @return String
     */
    public abstract boolean equals(Object x);
    /**
     * Generates a hashCode
     * @return boolean
     */
    public abstract int hashCode();
    /**
     * Generates an ArrayList of all map keys
     * @return ArrayList<K>
     */
    abstract ArrayList<K> getAllKeys();
    /**
     * Adds keys to the ArrayList
     * @param ar - the array to be populated
     * @return ArrayList<K>
     */
    abstract ArrayList<K> getKeys(ArrayList<K> ar);
    /**
     * Do both maps contain all the same keys?
     * @param x - map 1
     * @param y - map 2
     * @return boolean - true if yes, false if no
     */
    abstract boolean containsAllKeys(MyMap<K, V> x, MyMap<K, V> y);
    /**
     * Do all of the keys map to the same values?
     * @param x - map 1
     * @param y - map 2
     * @return boolean - true if yes, false if no
     */
    abstract boolean checkKeys(MyMap<K, V> x, MyMap<K, V> y);
    /**
     * Instantiates an iterator object
     * @return Iterator
     */
    public abstract Iterator<K> iterator();
    /**
     * Instantiates an iterator object
     * @param comp - the comparison method
     * @return Iterator
     */
    public abstract Iterator<K> iterator(Comparator<? super K> comp);
    /**
     * Accept Method
     * @param m - The Visitor
     * @return this
     */
    public abstract MyMap<K, V> accept(MyMapVisitor<K, V> m);
    /**
     * Accept Method
     * @param <R>
     * @param m - The Visitor
     * @return this
     */
    //public abstract <R> R acceptRBT(RBTVisitor<K, V, R> m);
    // Static Methods
    /**
     * Adds values to the MyMap
     * @param m - the map
     * @param key - the key in the map
     * @param value - the value in the map
     * @return a MyMap
     */
    public MyMap<K, V> include(MyMap<K, V> m, K key, V value) {
        return m.include(key, value);
    }
    /**
     * Is the MyMap empty?
     * @param m - the map
     * @return boolean
     */
    public boolean isEmpty(MyMap<K, V> m) {
        return m.isEmpty();
    }
    /**
     * What is the size of the MyMap?
     * @param m - the map
     * @return int
     */
    public int size(MyMap<K, V> m) {
        return m.size();
    }
    /**
     * Does the MyMap contain the key?
     * @param m - the map
     * @param key - the key in the map
     * @return boolean
     */
    public boolean containsKey(MyMap<K, V> m, K key) {
        return m.containsKey(key);
    }
    /**
     * Get the value associated with the key
     * @param m - the map
     * @param key - the key in the map
     * @return V - the value
     */
    public V get(MyMap<K, V> m, K key) {
        return m.get(key);
    }
    /**
     * Sets a value in the map
     * @param m - the map
     * @param key - the key in the map
     * @param value - the value in the map
     * @return MyMap
     */
    public MyMap<K, V> set(MyMap<K, V> m, K key, V value) {
        return m.set(key, value);
    }
    /**
     * Generates an ArrayList of all map keys
     * @param m - the map
     * @return ArrayList<K>
     */
    ArrayList<K> getAllKeys(MyMap<K, V> m) {
        return m.getAllKeys();
    }
    /**
     * Adds keys to the ArrayList
     * @param ar - the array to be populated
     * @param m - the map
     * @return ArrayList<K>
     */
    ArrayList<K> getKeys(MyMap<K, V> m, ArrayList<K> ar) {
        return getKeys(ar);
    }
    /**
     * Do both maps contain all the same keys?
     * @param m - the map
     * @param x - map 1
     * @param y - map 2
     * @return boolean - true if yes, false if no
     */
    boolean containsAllKeys(MyMap<K, V> m, MyMap<K, V> x, MyMap<K, V> y) {
        return m.containsAllKeys(x, y);
    }
    /**
     * Do all of the keys map to the same values?
     * @param m - the map
     * @param x - map 1
     * @param y - map 2
     * @return boolean - true if yes, false if no
     */
    boolean checkKeys(MyMap<K, V> m, MyMap<K, V> x, MyMap<K, V> y) {
        return m.checkKeys(x, y);
    }
    /**
     * Instantiates an iterator object
     * @param m - the map
     * @return Iterator
     */
    public Iterator<K> iterator(MyMap<K, V> m) {
        return m.iterator();
    }
    /**
     * Instantiates an iterator object
     * @param m - the map
     * @param comp - the comparison method
     * @return Iterator
     */
    public Iterator<K> iterator(MyMap<K, V> m, Comparator<? super K> comp) {
        return m.iterator(comp);
    }

    /**
     * HashHelper - not used here
     * @param accum - accumulator
     * @return int
     */
    abstract int hashHelp(int accum);
    /**
     * Size helper method
     * n - the accumulator
     * k - the key
     * @return integer rep of size
     */
    abstract int sizeHelp(int n, K k);
    
}