package kvmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
/**
 * EmptyNode class for BST subclass of BST
 * @param <K> - the Key Type
 * @param <V> - the Value Type
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 22, 2014
 */
public class EmptyNode<K, V> extends BST<K, V> {
    private Comparator<? super K> c0;
    
    /**
     * 
     * Constructor for EmptyNode
     * @param c - the comparator
     */
    public EmptyNode(Comparator<? super K> c) {
        this.c0 = c;
    }
    /**
     * Assign method assigns a key to a value and adds to BST
     * @param k - the Key
     * @param v - the Value
     * @return the new KVMap
     */
    @Override
    public KVMap<K, V> assign(K k, V v) {
        return new Node<K, V>(k, v, this, this, c0);
    }
    /**
     * Is the BST empty?
     * @return true
     */
    @Override
    public boolean isEmpty() {
        return true;
    }
    /**
     * What is the size of the BST?
     * @return 0
     */
    @Override
    public int size() {
        return 0;
    }
    /**
     * Does the BST contain the Key?
     * @param k - the Key
     * @return true if contains, false if not contains
     */
    @Override
    public boolean containsKey(K k) {
        return false;
    }
    /**
     * Does the BST contain the Value?
     * @param v - the value
     * @return true if contains, false if not contains
     */
    @Override
    public boolean containsValue(V v) {
        return false;
    }
    /**
     * Get the value of the key
     * @param k - the key
     * @return the value
     */
    @Override
    public V get(K k) {
        throw new RuntimeException("EmptyNode :: .get(k) :: illegal access::");
    }
    /**
     * toString represents the BST as a string
     * @return the string
     */
    @Override
    public String toString() {
        return "{...[There are " + this.size() + " unique key(s) mapped to "
                + "value(s) in this KVMap]...}";
    }
    /**
     * Compares an object to a KVMap for equality
     * @param o - the object
     * @return true if equal, false if not equal
     */
    @Override
    public boolean equals(Object o) {
        return ((o instanceof EmptyNode) || (o instanceof EmptyMap));
    }
    /**
     * Generates a hashCode for a KVMap
     * @return the hashCode 0 for empty
     */
    @Override
    public int hashCode() {
        return 0;
    }
    /**
     * Iterator method for KVMap
     * @return the Iterator
     */
    @Override
    public Iterator<K> iterator() {
        return new MapIterator<K>(this.getKeys());
    }
    /**
     * Iterator method for KVMap with Comparator
     * @param c - the comparator
     * @return the Iterator
     */
    @Override
    public Iterator<K> iterator(Comparator<? super K> c) {
        return new MapIterator<K>(this.getKeys(), c);
    }
    /**
     * Adds all BST keys to an ArrayList
     * @return al - the arraylist
     */
    @Override
    ArrayList<K> getKeys() {
        return new ArrayList<K>();
    }
    /**
     * Adds BST keys to an arraylist
     * @param al - the arraylist to add keys to
     * @return the arraylist with all the keys
     */
    ArrayList<K> addKeys(ArrayList<K> al) {
        return al;
    }
    /**
     * Gets hashes for BST
     * @param hs - the hashset
     * @return hs - the hashset
     */
    @Override
    HashSet<K> getHash(HashSet<K> hs) {
        return hs;
    }
}