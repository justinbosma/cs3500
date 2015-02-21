import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
/**
 * EmptyMap Class - subclass of KVMap ADT
 * @param <K> - the Key Type
 * @param <V> - the Value Type
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 14, 2014
 */
public class EmptyMap<K, V> extends KVMap<K, V> {
    /**
     * 
     * Default Constructor for EmptyMap
     */
    public EmptyMap() {
        //empty Constructor
    }
    /**
     * Assign method assigns a key to a value and adds to map
     * @param k - the Key
     * @param v - the Value
     * @return the new KVMap
     */
    @Override
    KVMap<K, V> assign(K k, V v) {
        return new Assign<K, V>(k, v, this);
    }
    /**
     * Is the Map empty?
     * @return true
     */
    @Override
    boolean isEmpty() {
        return true;
    }
    /**
     * What is the size of the Map?
     * @return 0
     */
    @Override
    int size() {
        return 0;
    }
    /**
     * Does the Map contain the Key?
     * @param k - the Key
     * @return true if contains, false if not contains
     */
    @Override
    boolean containsKey(K k) {
        return false;
    }
    /**
     * Does the Map contain the Value?
     * @param v - the value
     * @return true if contains, false if not contains
     */
    @Override
    boolean containsValue(V v) {
        return false;
    }
    /**
     * Get the value of the key
     * @param k - the key
     * @return the value
     */
    @Override
    V get(K k) {
        throw new RuntimeException("EmptyMap :: .get(k) :: illegal access::");
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
    @Override
    public boolean equals(Object o) {
        return o instanceof EmptyMap;
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
     * Adds all map keys to an ArrayList
     * @return al - the arraylist
     */
    @Override
    ArrayList<K> getKeys() {
        return new ArrayList<K>();
    }
    /**
     * Adds map keys to an arraylist
     * @param al - the arraylist to add keys to
     * @return the arraylist with all the keys
     */
    ArrayList<K> addKeys(ArrayList<K> al) {
        return al;
    }
}