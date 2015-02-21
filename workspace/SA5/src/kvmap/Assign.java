package kvmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
/**
 * Assign - basic creator for KVMap class
 * 
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 14, 2014
 * @param <K> - The Key Type
 * @param <V> - The Value Type
 */
public class Assign<K, V> extends KVMap<K, V> {
    private K k0;
    private V v0;
    private KVMap<K, V> m0;
    /**
     * 
     * Constructor for Assign class
     * @param k - the Key
     * @param v - the Value
     * @param m - the map
     */
    public Assign(K k, V v, KVMap<K, V> m) {
        this.k0 = k;
        this.v0 = v;
        this.m0 = m;
    }
    /**
     * Assign method assigns a key to a value and adds to map
     * @param k - the Key
     * @param v - the Value
     * @return the new KVMap
     */
    @Override
    public KVMap<K, V> assign(K k, V v) {
        return new Assign<K, V>(k, v, this);
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
     * What is the size of the Map?
     * @return the size
     */
    @Override
    public int size() {
        if (this.m0.containsKey(k0)) {
            return this.m0.size();
        }
        else {
            return 1 + this.m0.size();
        }
    }
    /**
     * Does the Map contain the Key?
     * @param k - the Key
     * @return true if contains, false if not contains
     */
    @Override
    public boolean containsKey(K k) {
        if (k.equals(this.k0)) {
            return true;
        }
        else {
            return this.m0.containsKey(k);
        }
    }
    /**
     * Does the Map contain the Value?
     * @param v - the value
     * @return true if contains, false if not contains
     */
    @Override
    public boolean containsValue(V v) {
        for (K k: this) {
            if (this.get(k).equals(v)) {
                return true;
            }
        }
        return false;
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
        else {
            return this.m0.get(k);
        }
    }
    /**
     * toString represents the map as a string
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
     * Adds all map keys to an ArrayList
     * @return al - the arraylist
     */
    @Override
    ArrayList<K> getKeys() {
        ArrayList<K> al = new ArrayList<K>();
        al = addKeys(al);
        return al;
    }
    /**
     * Adds map keys to an arraylist
     * @param al - the arraylist to add keys to
     * @return the arraylist with all the keys
     */
    ArrayList<K> addKeys(ArrayList<K> al) {
        if (this.m0.containsKey(this.k0)) {
            return (this.m0).addKeys(al);
        }
        else {
            al.add(this.k0);
            return (this.m0).addKeys(al);
        }
    }
    /**
     * Gets hashes for BST
     * @param hs - the hashSet
     * @return hs - the hashset
     */
    @Override
    HashSet<K> getHash(HashSet<K> hs) {
        return hs;
    }
}