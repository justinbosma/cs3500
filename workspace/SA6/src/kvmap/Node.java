package kvmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Node class
 * Implementation class for non-empty Binary Search Tree structure
 * Subclass of BST
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 19, 2014
 * @param <K>
 * @param <V>
 */
public class Node<K, V> extends BST<K, V> {
    private K k0;
    private V v0;
    private KVMap<K, V> leftMap; 
    private KVMap<K, V> rightMap;
    private Comparator<? super K> c0;
    private int size;
    /**
     * 
     * Constructor for Node class
     * @param k - the Key
     * @param v - the Value
     * @param left - the left of the tree
     * @param right - the right of the tree
     * @param c - the comparator
     */
    public Node(K k, V v, KVMap<K, V> left, KVMap<K, V> right, 
            Comparator<? super K> c) {
        this.k0 = k;
        this.v0 = v;
        this.leftMap = left;
        this.rightMap = right;
        this.c0 = c;
        //this.size = 1 + this.leftMap.size() + this.rightMap.size();
        this.size = getKeys().size();
    }
    /**
     * Assign method assigns a key to a value and adds to BST
     * @param k - the Key
     * @param v - the Value
     * @return the new KVMap
     */
    @Override
    public KVMap<K, V> assign(K k, V v) {
        
        if (k.equals(this.k0)) {
            return new Node<K, V>(k, v, this.leftMap, this.rightMap, this.c0);
        }
        if (this.c0.compare(k, this.k0) < 0) {
            //this.size = this.size + 1;
            return new Node<K, V>(this.k0, this.v0, this.leftMap.assign(k, v), 
                    this.rightMap, this.c0);
        }
        else {
            //this.size = this.size + 1;
            return new Node<K, V>(this.k0, this.v0, this.leftMap, 
                    this.rightMap.assign(k, v), this.c0);
        }
    }
    /**
     * Is the Map empty?
     * @return false
     */
    @Override
    public boolean isEmpty() {
        return false;
    }
    /**
     * What is the size of the BST?
     * @return the size
     */
    public int size() {
        return this.size;
    }
    /**
     * Does the BST contain the Key?
     * @param k - the Key
     * @return true if contains, false if not contains
     */
    @Override
    public boolean containsKey(K k) {
        if (k.equals(this.k0)) {
            return true;
        }
        else if (this.c0.compare(k, this.k0) < 0) {
            return this.leftMap.containsKey(k);
        }
        else {
            return this.rightMap.containsKey(k);
            
        }
    }
    /**
     * Does the BST contain the Value?
     * @param v - the value
     * @return true if contains, false if not contains
     */
    @Override
    public boolean containsValue(V v) {
//        for (K k: this) {
//            if (this.get(k).equals(v)) {
//                return true;
//            }
//        }
//        return false;
        return this.get(this.k0).equals(v)
                || this.leftMap.containsValue(v) 
                || this.rightMap.containsValue(v);
    }
    /**
     * Get the value of the key
     * @param k - the key
     * @return the value
     */
    @Override
    public V get(K k) {
        if (k.equals(this.k0)) {
            return this.v0;
        }
        else if (this.c0.compare(k, this.k0) < 0) {
            return this.leftMap.get(k);
        }
        else {
            return this.rightMap.get(k);
        }
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
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public boolean equals(Object o) {
        if (o instanceof KVMap) {
            if (o instanceof EmptyNode || o instanceof EmptyMap 
                    || o == null) {
                return false;
            }
            KVMap that = (KVMap) o;
            
            if (this.size() != that.size()) {
                return false;
            }
            
            for (K k: this) {
                if ((!that.containsKey(k)) || 
                        (!this.get(k).equals(that.get(k)))) {
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Generates a hashCode for a KVMap
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        int hc = 37;
        for (K k: this) {
            hc = hc + k.hashCode() + this.get(k).hashCode();
        }
        return hc;
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
        
        HashSet<K> hash = new HashSet<K>();
        hash = getHash(hash);
        ArrayList<K> al = new ArrayList<K>(hash);
        Collections.sort(al, this.c0);
        return al;
    }
    /**
     * Adds keys to a hash Set in order to avoid duplicates
     * @param hash - the hashset
     * @return hash - the hashset
     */
    HashSet<K> getHash(HashSet<K> hash) {
        hash.add(this.k0);
        this.leftMap.getHash(hash);
        this.rightMap.getHash(hash);
        return hash;
    }
    /**
     * Adds BST keys to an arraylist
     * @param al - the arraylist to add keys to
     * @return the arraylist with all the keys
     */
    ArrayList<K> addKeys(ArrayList<K> al) {
        //This used to do things but now its not needed
        return al;
    }
}