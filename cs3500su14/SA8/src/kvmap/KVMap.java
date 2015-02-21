package kvmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;


/**
 * KVMap Abstract Data Type
 * @param <K> - The Key Type
 * @param <V> - The Value Type
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 14, 2014
 */
public abstract class KVMap<K, V> implements Iterable<K> {

    /**
     * Assign method assigns a key to a value and adds to map
     * @param k - the Key
     * @param v - the Value
     * @return the new KVMap
     */
    public abstract KVMap<K, V> assign(K k, V v);
    /**
     * Is the map Empty?
     * @return true if empty, false if not empty
     */
    public abstract boolean isEmpty();
    /**
     * What is the size of the Map?
     * @return the size
     */
    public abstract int size();
    /**
     * Does the Map contain the Key?
     * @param k - the Key
     * @return true if contains, false if not contains
     */
    public abstract boolean containsKey(K k);
    /**
     * Does the Map contain the Value?
     * @param v - the value
     * @return true if contains, false if not contains
     */
    public abstract boolean containsValue(V v);
    /**
     * Get the value of the key
     * @param k - the key
     * @return the value
     */
    public abstract V get(K k);
    /**
     * toString represents the map as a string
     * @return the string
     */
    public abstract String toString();
    /**
     * Compares an object to a KVMap for equality
     * @param o - the object
     * @return true if equal, false if not equal
     */
    public abstract boolean equals(Object o);
    /**
     * Generates a hashCode for a KVMap
     * @return the hashCode
     */
    public abstract int hashCode();
    /**
     * Iterator method for KVMap
     * @return the Iterator
     */
    public abstract Iterator<K> iterator();
    /**
     * Iterator method for KVMap with Comparator
     * @param c - the comparator
     * @return the Iterator
     */
    public abstract Iterator<K> iterator(Comparator<? super K> c);
    /**
     * Gets all the keys from the map and adds them to an arraylist
     * @return the arraylist of keys
     */
    abstract ArrayList<K> getKeys();
    /**
     * Adds map keys to an arraylist
     * @param al - the arraylist to add keys to
     * @return the arraylist with all the keys
     */
    abstract ArrayList<K> addKeys(ArrayList<K> al);
    /**
     * Static emptyMap method
     * @param <K> - the Key Type
     * @param <V> - the Value Type
     * @return a new EmptyMap()
     */
    public static <K, V> KVMap<K, V> emptyMap() {
        return new EmptyMap<K, V>();
    }
    /**
     * Static emptyMap method with Comparator 
     * @param <K> - the Key Type
     * @param <V> - the Value Type
     * @param c - the comparator
     * @return a new EmptyMap()
     */
    public static <K, V> KVMap<K, V> emptyMap(Comparator<? super K> c) {
        return new EmptyNode<K, V>(c);
    }
    /**
     * Gets hashes for BST
     * @param hs - the hashset
     * @return hs - the hashset
     */
    abstract HashSet<K> getHash(HashSet<K> hs);
    /**
     * accept method for Visitor pattern
     * @param v - the visitor
     * @return a KVMap
     */
    public abstract KVMap<K, V> accept(KVMapVisitor<K, V> v);
    /**
     * Accept method for Visitor patter
     * @param v - the Visitor
     * @param <R> the return type
     * @return R - the type of elements returned by method
     */
    public abstract <R> R acceptRBT(RBTVisitor<K, V, R> v);
    
}