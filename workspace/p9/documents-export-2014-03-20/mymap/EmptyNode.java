package mymap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 5 : 2/10/14
 * @param <K> - The key stored in the map 
 * @param <V> - the the value stored in the map
 */
public class EmptyNode<K, V> extends BST<K, V> {
    private Comparator<? super K> c0;
    private boolean black = false;
    private boolean color = black;
    /**
     * Default Constructor Instantiates an Empty MyMap
     * with no properties
     */
    /*public EmptyNode() {
        //Default Constructor
        c0 = new KCompare<K>();
    }*/
    /**
     * Constructor with 1 parameter - 
     * @param comp the comparator object
     */
    public EmptyNode(Comparator<? super K> comp) {
        this.c0 = comp;
    }
    /**
     * Include Method to add a key and value to a MyMap
     * @param key the key stored in the map
     * @param value the value stored in the map
     * @return a new Include object
     */
    @Override
    public MyMap<K, V> include(K key, V value) {
        return new Node<K, V>(key, value, this, this, c0, color);
    }
    /**
     * Is the MyMap empty?
     * @return true
     */
    @Override
    public boolean isEmpty() {
        return true;
    }
    /**
     * What is the size of the MyMap?
     * @return 0
     */
    @Override
    public int size() {
        return 0;
    }
    /**
     * Is the key in the MyMap?
     * @param key the key in the MyMap
     * @return false
     */
    @Override
    public boolean containsKey(K key) {
        //System.out.println("EmptyNode- .containsKey() called :return false");
        return false;
        
        //throw new RuntimeException("incorrect containsKey() method");
    }
    /**
     * Gets the value associated with the key
     * @param key the key in the map
     * @return null
     */
    @Override
    public V get(K key) {
        //return null;
        throw new IllegalArgumentException("Can't get() from an empty list");
    }
    /**
     * Sets the value at the key
     * @param key the key in the map
     * @param value the value stored in the map
     * @return null
     */
    @Override
    public MyMap<K, V> set(K key, V value) {
        return this.include(key, value);
    }
    /**
     * Returns the MyMap as a string
     * @return String - the message
     */
    @Override
    public String toString() {
        String msg1 = "{...(" + this.size() + 
                " key(s) mapped to value(s))...}";
        //String msg2 = "[EMPTY NODE]";
        return msg1;
    }
    /**
     * Are the two MyMap equal?
     * @param x - the MyMap to compare
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
     * @return 0
     */
    @Override
    public int hashCode() {
        return 37;
    }
    /**
     * Generates an ArrayList from all keys
     * @return ArrayList - new empty one
     */
    @Override
    
    ArrayList<K> getAllKeys() {
        return new ArrayList<K>();
    }
    /**
     * Adds keys to the ArrayList
     * @param ar - the array passed in
     * @return ArrayList -  the parameter - ar
     */
    @Override
    ArrayList<K> getKeys(ArrayList<K> ar) {
        return ar;
    }
    /**
     * Do both MyMaps contain all the same keys?
     * @param x - map 1
     * @param y - map 2
     * @return boolean - true if yes, false if no
     */
    boolean containsAllKeys(MyMap<K, V> x, MyMap<K, V> y) {
        return true;
    }
    /**
     * Do all of the keys map to the same values?
     * @param x - map 1
     * @param y - map 2
     * @return boolean - true if yes, false if no
     */
    boolean checkKeys(MyMap<K, V> x, MyMap<K, V> y) {
        return true;
    }
    /**
     * Overridden Iterator method
     * @return new KeyIterator
     */
    @Override
    public Iterator<K> iterator() {
        return new KeyIterator<K>(this);
    }
    /**
     * Overridden Iterator method
     * @param comp - the comparison method
     * @return new KeyIterator
     */
    @Override
    public Iterator<K> iterator(Comparator<? super K> comp) {
        return new KeyIterator<K>(this, comp);
    }
    
    @Override
    K getKey() {
        throw new IllegalArgumentException("Can't- empty list");
    }
    @Override
    V getValue() {
        throw new IllegalArgumentException("Can't- empty list");
    }
    @Override
    boolean getColor() {
        return false;
    }
    @Override
    BST<K, V> getLeftMap() {
        throw new IllegalArgumentException("Can't- empty list");
    }
    @Override
    BST<K, V> getRightMap() {
        throw new IllegalArgumentException("Can't- empty list");
    }
    @Override
    Node<K, V> redll(Node<K, V> n) {
        throw new IllegalArgumentException("Can't- empty list");
    }
    @Override
    Node<K, V> redlr(Node<K, V> n) {
        throw new IllegalArgumentException("Can't- empty list");
    }
    @Override
    Node<K, V> redrl(Node<K, V> n) {
        throw new IllegalArgumentException("Can't- empty list");
    }
    @Override
    Node<K, V> redrr(Node<K, V> n) {
        throw new IllegalArgumentException("Can't- empty list");
    }
    /**
     * Accept Method
     * @param m - The Visitor
     * @return this
     */
    @Override
    public MyMap<K, V> accept(MyMapVisitor<K, V> m) {
        //m.visit(null, null);
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
     * @param n - the accumulator
     * @param k - the key
     * @return integer rep of size
     */
    int sizeHelp(int n, K k) {
        return 0;
    }
}