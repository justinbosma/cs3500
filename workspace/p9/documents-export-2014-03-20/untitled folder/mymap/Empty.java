package mymap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

//import java.util.NoSuchElementException;
/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 4 : 1/28/14
 * @param <K>
 *            - The key stored in the map
 * @param <V>
 *            - the the value stored in the map
 */
public class Empty<K, V> extends Alist<K, V> {
    /**
     * Default Constructor
     */
    public Empty() {
        // Empty Constructor
    }

    /**
     * Constructor with 1 parameter - Calls the default constructor
     * 
     * @param c
     *            the comparator object
     */
    /*public Empty(Object c) {
        MyMap.empty();
    }*/

    /**
     * Include Method to add a key and value to a MyMap
     * 
     * @param key
     *            the key stored in the map
     * @param value
     *            the value stored in the map
     * @return a new Include object
     */
    @Override
    public MyMap<K, V> include(K key, V value) {
        return new Include<K, V>(key, value, this);
    }

    /**
     * Include Method to add a key and value to a MyMap
     * 
     * @param key
     *            the key stored in the map
     * @param value
     *            the value stored in the map
     * @param m
     *            - the map
     * @return a new Include object
     */
    //@Override
    //public MyMap<K, V> include(MyMap<K, V> m, K key, V value) {
      //  return new Include<K, V>(key, value, this);
    //}

    /**
     * Is the map empty?
     * 
     * @return true
     */
    @Override
    public boolean isEmpty() {
        return true;
    }

    /**
     * What is the size of the MyMap?
     * 
     * @return 0
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Is the key in the MyMap?
     * 
     * @param key
     *            the key in the map
     * @return false
     */
    @Override
    public boolean containsKey(K key) {
        return false;
    }

    /**
     * Gets the value associated with the key
     * 
     * @param key
     *            the key in the map
     * @return null
     */
    @Override
    public V get(K key) {
        // V v = (V) "empty - get()";
        // throw new RuntimeException("Map is empty");
        return null;
    }

    /**
     * Sets the value at the key
     * 
     * @param key
     *            the key in the map
     * @param value
     *            the value stored in the map
     * @return null
     */
    @Override
    public MyMap<K, V> set(K key, V value) {
        return this.include(key, value);
        // throw new RuntimeException("Map is empty");
    }

    /**
     * Overridden Iterator method
     * 
     * @return null
     */
    @Override
    public Iterator<K> iterator() {
        return new KeyIterator<K>(this);
    }

    /**
     * Overridden Iterator method
     * 
     * @param comp
     *            - the comparison method
     * @return null
     */
    @Override
    public Iterator<K> iterator(Comparator<? super K> comp) {
        return new KeyIterator<K>(this, comp);
    }

    /**
     * Generates an ArrayList from all Map keys
     * 
     * @return ArrayList - new empty one
     */
    ArrayList<K> getAllKeys() {
        return new ArrayList<K>();
    }

    /**
     * Adds keys to the ArrayList
     * 
     * @param ar
     *            - the array passed in
     * @return ArrayList - the parameter - ar
     */
    ArrayList<K> getKeys(ArrayList<K> ar) {
        return ar;
    }

    /**
     * Returns the MyMap as a string
     * 
     * @return String - the message
     */
    @Override
    public String toString() {
        return "{...(" + this.size() + " key(s) mapped to value(s))...}";
    }

    /**
     * Are the two MyMaps equal?
     * 
     * @param x
     *            - the MyMap to compare
     * @return false
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object x) {
        if (x instanceof MyMap) {
            return ((MyMap<K, V>) x).isEmpty();
        } 
        else {
            return false;
        }
    }

    /**
     * Generates a hashCode for each MyMap
     * 
     * @return 0
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * Do both maps contain all the same keys?
     * 
     * @param x
     *            - map 1
     * @param y
     *            - map 2
     * @return boolean - true if yes, false if no
     */
    @Override
    boolean containsAllKeys(MyMap<K, V> x, MyMap<K, V> y) {
        return true;
    }

    /**
     * Do all of the keys map to the same values?
     * 
     * @param x
     *            - map 1
     * @param y
     *            - map 2
     * @return boolean - true if yes, false if no
     */
    @Override
    boolean checkKeys(MyMap<K, V> x, MyMap<K, V> y) {
        return true;
    }

    /**
     * Accept Method
     * 
     * @param m
     *            - MyMapVisitor
     * @return this
     */
    @Override
    public MyMap<K, V> accept(MyMapVisitor<K, V> m) {
        return this;
    }

    /**
     * HashHelper - not used here
     * @param accum - accumulator
     * @return int
     */
    @Override
    int hashHelp(int accum) {
        return 0;
    }
    /**
     * Size helper method
     * n - the accumulator
     * k - the key
     * @return integer rep of size
     */
    int sizeHelp(int n, K k) {
        return 0;
    }
}