package mymap;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 4 : 1/28/14
 * @param <K>
 *            - The key stored in the map
 * @param <V>
 *            - the the value stored in the map
 * 
 */
public class Include<K, V> extends Alist<K, V> {
    private K k0;
    private V v0;
    private MyMap<K, V> m0;
    private int size;
    // private boolean containsKey = false;
    private ArrayList<K> arr = new ArrayList<K>();

    /**
     * Constructor for Include class
     * 
     * @param key
     *            - the key stored in the map
     * @param value
     *            - the value stored in the map
     * @param m
     *            - the map
     */
    public Include(K key, V value, MyMap<K, V> m) {
        this.k0 = key;
        this.v0 = value;
        this.m0 = m;
        this.size = sizeHelp(size, this.k0);
        // this.containsKey = m.containsK(key);
        this.arr.add(key);
        // System.out.println(arr);

    }

    /**
     * Constructor for Include class
     * 
     * @param key
     *            - the key stored in the map
     * @param value
     *            - the value stored in the map
     * @param m
     *            - the map
     */
    /*
     * public Include(K key, V value) { this.k0 = key; this.v0 = value;
     * this.size = size + 1; this.containsKey = this.containsK(key);
     * 
     * }
     */
    /**
     * Include method with two parameters
     * 
     * @param key
     *            - the key stored in the map
     * @param value
     *            - the value store in the map
     * @return a new Include object
     */
    public MyMap<K, V> include(K key, V value) {
        return new Include<K, V>(key, value, this);
    }

    /**
     * Add a key/value pair to the MyMap
     * 
     * @param key
     *            the key stored in the map
     * @param value
     *            the value stored in the map
     * @param m
     *            the map
     * @return new Include object
     */
    @Override
    public MyMap<K, V> include(MyMap<K, V> m, K key, V value) {
        return new Include<K, V>(key, value, this);
    }
    /**
     * Size Helper
     * @param n - the size
     * @param k - the key
     * @return the new size
     */
    int sizeHelp(int n, K k) {
        if (this.m0.containsKey(this.k0)) {
            return this.m0.sizeHelp(n, this.k0);
        }
        else {
            return 1 + this.m0.sizeHelp(n, this.k0);
        }
    }

    /**
     * Is the map empty?
     * 
     * @return false
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * What is the size of the MyMap?
     * 
     * @return int
     */
    @Override
    public int size() {
        /*
         * if (this.m0.containsKey(this.k0)) { return this.m0.size(); } else {
         * return 1 + this.m0.size(); }
         */
        return size;
    }

    /**
     * Is the key in the map?
     * 
     * @param k
     *            - the key
     * @return boolean
     */
    @Override
    public boolean containsKey(K k) {
        if (this.k0.equals(k)) {
            return true;
        }
        else {
            return this.m0.containsKey(k);
        }

    }

    /**
     * Gets the value associated with the key
     * 
     * @param k
     *            - the key
     * @return the value
     */
    @Override
    public V get(K k) {
        if (this.k0.equals(k)) {
            return this.v0;
        }
        else {
            return this.m0.get(k);
        }
    }

    /**
     * Sets the value in the MyMap
     * 
     * @param k
     *            - the key
     * @param v
     *            - the value
     * @return a new MyMap
     */
    @Override
    public MyMap<K, V> set(K k, V v) {
        if (this.k0.equals(k)) {
            return this.m0.include(this.m0, k, v);
        }
        else {
            return this.m0.set(k0, v0).include(this.m0, k, v);
        }
    }

    /**
     * Returns the MyMap as a string value
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
     *            - MyMap
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object x) {
        boolean thisValid = this instanceof MyMap;
        boolean thatValid = x instanceof MyMap;
        // x1 = (MyMap<K, V>) x;

        if (!thisValid || !thatValid || this.k0 == null) {
            return false;
        }
        if (thisValid && thatValid) {
            MyMap<K, V> mx = (MyMap<K, V>) x;
            if (this.containsAllKeys(this, mx) 
                    && mx.containsAllKeys(mx, this)) {
                return (this.checkKeys(this, mx) && 
                        (mx.checkKeys(mx, this)));
            }
        }
        return false;
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
        if (x.containsKey(k0) == y.containsKey(k0)) {
            return this.m0.containsAllKeys(x, y);
        }
        else {
            return true;
        }
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
        if (x.get(this.k0).equals(y.get(this.k0))) {
            return this.m0.checkKeys(x, y);
        }
        else {
            return false;
        }
    }

    /**
     * Generates a hashCode for each MyMap
     * 
     * @return 1
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * (hash + this.size());
        return hash;
    }

    /**
     * Overridden Iterator method
     * 
     * @return new Iterator object
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
     * @return a new Iterator
     */
    @Override
    public Iterator<K> iterator(Comparator<? super K> comp) {
        return new KeyIterator<K>(this, comp);
    }

    /**
     * Places all MyMap elements in an ArrayList
     * 
     * @return ArrayList with keys from the map
     */
    ArrayList<K> getAllKeys() {
        ArrayList<K> arra = new ArrayList<K>();
        arra = this.getKeys(arra);
        return arra;
    }

    /**
     * Get the keys and add to array
     * 
     * @param ar
     *            - the array being populated
     * @return Arraylist with keys from the map
     */
    ArrayList<K> getKeys(ArrayList<K> ar) {
        if (this.m0.containsKey(this.k0)) {
            return this.m0.getKeys(ar);
        }
        else {
            ar.add(this.k0);
            return this.m0.getKeys(ar);
        }
    }

    /**
     * Accept method
     * 
     * @param m
     *            - the Visitor
     * @return - this
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
}