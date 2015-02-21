package mymap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 5 : 2/10/14
 * @param <K>
 *            - The key stored in the map
 * @param <V>
 *            - the the value stored in the map
 */
public class Node<K, V> extends BST<K, V> {
    private K k0;
    private V v0;
    // left rest - for those smaller than current node
    private MyMap<K, V> l0;
    // right rest - for those larger than current node
    private MyMap<K, V> r0;
    private Comparator<? super K> c0;
    // private boolean DEBUGGING = false;
    private int size;
    private boolean red = true;
    private boolean black = false;
    /**
     * The color of the node
     */
    boolean color;

    // private boolean containsKey = false;
    /**
     * Constructor for Node objects - if the new key is less than the current
     * node key it is
     * 
     * @param key
     *            - the key of the current node
     * @param value
     *            - the value of the current node
     * @param left
     *            - the MyMap that branches left (the rest)
     * @param right
     *            - the MyMap that branches right (the rest)
     * @param comp
     *            - the comparator
     * @param color
     *            - the nodes color
     */
    public Node(K key, V value, MyMap<K, V> left, MyMap<K, V> right,
            Comparator<? super K> comp, boolean color) {
        this.k0 = key;
        this.v0 = value;
        this.l0 = left;
        this.r0 = right;
        this.c0 = comp;
        this.color = color;
        //this.size = 1 + this.l0.size() + this.r0.size();
        this.size = sizeHelp(this.size, this.k0);
        // System.out.println("Node - Constructor - " + k0 + v0 + l0 + r0 + c0);
    }
    /**
     * Include method with two parameters
     * 
     * @param key
     *            - the key stored in the map
     * @param value
     *            - the value store in the map
     * @return a new Node object
     */
    @Override
    public MyMap<K, V> include(K key, V value) {
        if (c0.compare(this.k0, key) < 0) {
            return this.reOrder(new Node<K, V>(key, value, this.l0.include(
                    this.k0, this.v0), this.r0, this.c0, this.color));
        }
        if (c0.compare(this.k0, key) > 0) {
            return this.reOrder(new Node<K, V>(key, value, this.l0, this.r0
                    .include(this.k0, this.v0), this.c0, this.color));
        }
        else {
            return new Node<K, V>(this.k0, value, this.l0, this.r0, this.c0,
                    this.color);
        }
    }
    /**
     * Sets the value at the key
     * 
     * @param key
     *            - the key
     * @param value
     *            - the value
     * @return a new MyMap
     */
    @Override
    public MyMap<K, V> set(K key, V value) {
        int compare = c0.compare(this.k0, key);
        if (compare == 0) {
            return this.include(key, value);
        }
        if (compare < 0) {
            return (MyMap<K, V>) this.r0.set(key, value).include(k0, v0);
        }
        else {
            return (MyMap<K, V>) this.l0.set(key, value).include(k0, v0);
        }
    }
    /**
     * Gets the value associated with the key
     * 
     * @param key
     *            - the key
     * @return the value
     */
    @Override
    public V get(K key) {
        int compare = c0.compare(this.k0, key);
        if (compare > 0 && !l0.isEmpty()) {
            return this.l0.get(key);
        }
        if (compare < 0 && !r0.isEmpty()) {
            return this.r0.get(key);
        }
        else {
            return this.v0;
        }
    }
    /**
     * Is the MyMap empty?
     * @return false
     */
    @Override
    public boolean isEmpty() {
        return false;
    }
    /**
     * What is the size of the MyMap?
     * @return int
     */
    @Override
    public int size() {
        /*if (this.l0.containsKey(this.k0) || this.r0.containsKey(this.k0)) {
            return this.size - 1;
        }
        else {
            return this.size;
        }*/
        return this.size;
    }
    /**
     * Size helper method
     * @param n - the accumulator
     * @param k - the key
     * @return integer rep of size
     */
    int sizeHelp(int n, K k) {
        if (this.l0.containsKey(this.k0) || 
                this.r0.containsKey(this.k0)) {
            return this.l0.sizeHelp(n, this.k0) 
                    + this.r0.sizeHelp(n, this.k0);
        }
        else {
            return 1 + this.l0.sizeHelp(n, this.k0)
                   + this.r0.sizeHelp(n, this.k0);
        }
    }
    /**
     * Is the key in the MyMap? 
     * @param key - the key
     * @return boolean
     */
    @Override
    public boolean containsKey(K key) {
        // System.out.println("containsKey :: this = " + this +
        // ":::Searching for key:" + key);
        int compare = this.c0.compare(k0, key);
        // System.out.println("containsKey :: int compare =" + compare);
        // System.out.println("containsKey : this.k0=" + this.k0 + ":: " +
        // ": key=" + key + ":::compare=" + compare);

        if (compare < 0) {
            // System.out.println("RIGHT =" + r0);
            // System.out.println("containsKey - Recursive call " 
            //+ "on right: Searching for key :"
            // + key);
            return r0.containsKey(key);
        }
        if (compare > 0) {
            // System.out.println("LEFT =" + l0);
            // System.out.println("containsKey - Recursive call on left:"
            //+ " Searching for key :"
            // + key);
            return l0.containsKey(key);
        }
        else {
            // System.out.println("containsKey - Return true - key found");
            return true;
        }
    }
    /**
     * Returns the MyMap as a string value
     * @return String - the message
     */
    @Override
    public String toString() {
        String msg1 = "{...(" + this.size() +
            " key(s) mapped to value(s))...}";
        //String msg2 = "[" + this.k0 + " | " + this.v0 + "]" + "LEFT "
          //      + l0.toString() + "RIGHT" + r0.toString();
        return msg1;
    }
    /**
     * Are the two MyMaps equal?
     * @param x   - MyMap
     * @return boolean
     */
    @Override
    public boolean equals(Object x) {
        boolean thisValid = this instanceof MyMap;
        boolean thatValid = x instanceof MyMap;

        if (!thisValid || !thatValid || this.k0 == null) {
            return false;
        }
        if (thisValid && thatValid) {
            @SuppressWarnings("unchecked")
            MyMap<K, V> mx = (MyMap<K, V>) x;
            // iterator here?
            if (mx.isEmpty()) {
                return false;
            }
            if (this.containsAllKeys(this, mx) && 
                    mx.containsAllKeys(mx, this)) {
                return (this.checkKeys(this, mx) && 
                        (mx.checkKeys(mx, this)));
            }
        }
        return false;
    }
    /**
     * Generates a hashCode for each MyMap
     * @return 1
     */
    @Override
    public int hashCode() {
        int hash = 37;
        int hakey = this.k0.hashCode();
        int haval = this.v0.hashCode();
        //int hasize = 37 * (hash + this.l0.size() + this.r0.size());
        //if a key is repeated, skip
        /*if (this.l0.containsKey(this.k0) || 
                this.r0.containsKey(this.k0)) {
            return hasize + l0.hashCode() + r0.hashCode();
        }
        //else add it
        else {*/
        return hash * hakey + haval + l0.hashCode() + r0.hashCode();
            //return this.hashHelper();
        //}
        //return hashHelper();
        
        
    }
    /**
     * hashCode helper
     * @return int
     */
    int hashHelper() {
        ArrayList<K> keys = new ArrayList<K>();
        this.getKeys(keys);
        Iterator<K> iter = keys.iterator();
        int code = 0;
        //int accum = 1;
        while (iter.hasNext()) {
            K key = iter.next();
            V val = this.get(key);
            code = code * key.hashCode() + val.hashCode();
            /*
            code = code + k.hashCode() + accum + 
                    + this.get(k).hashCode();
            accum = 4 * accum + 1;
            */
        }
        return code;
    }
    /**
     * hashCode helper
     * @param k - an integer
     * @return int
     */
    int hashHelp(int k) {
        int key = this.k0.hashCode();
        int val = this.v0.hashCode();
        int accum = k + 1 + key + val;
        //if (!l0.isEmpty()) {
        return this.l0.hashHelp(accum) + 1 + r0.hashHelp(accum);
        /*}
        else {
            return accum;
        }*/
    }
    /**
     * Places all MyMap elements in an ArrayList
     * @return ArrayList with keys from the map
     */
    @Override
    public ArrayList<K> getAllKeys() {
        ArrayList<K> arr = new ArrayList<K>();
        arr = this.getKeys(arr);
        return arr;
    }
    /**
     * Get the keys and add to array
     * @param ar  - the array being populated
     * @return Arraylist with keys from the map
     */
    @Override
    ArrayList<K> getKeys(ArrayList<K> ar) {
        if (!this.isEmpty()) {
            if (l0.containsKey(this.k0)) {
                return this.l0.getKeys(ar);
            }
            if (r0.containsKey(this.k0)) {
                return this.r0.getKeys(ar);
            }
            else {
                ar.add(this.k0);
                return ar;
            }
        }
        else {
            ar.add(this.k0);
            return ar;
        }
    }
    /**
     * Do both MyMap contain all the same keys?
     * @param x   - map 1
     * @param y   - map 2
     * @return boolean - true if yes, false if no
     */
    @Override
    boolean containsAllKeys(MyMap<K, V> x, MyMap<K, V> y) {
        if (x.containsKey(k0) == y.containsKey(k0)) {
            return (l0.containsAllKeys(x, y) && r0.containsAllKeys(x, y));
        }
        else {
            return false;
        }
    }
    /**
     * Do all of the keys map to the same values?
     * @param x   - map 1
     * @param y   - map 2
     * @return boolean - true if yes, false if no
     */
    @Override
    boolean checkKeys(MyMap<K, V> x, MyMap<K, V> y) {
        if (this.k0 == null) {
            return false;
        }
        if (!x.isEmpty() && !y.isEmpty()) {
            if (x.get(this.k0).equals(y.get(this.k0))) {
                return (l0.checkKeys(x, y) && l0.checkKeys(x, y));
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    /**
     * Overridden Iterator method
     * @return new Iterator object
     */
    @Override
    public Iterator<K> iterator() {
        return new KeyIterator<K>(this.getAllKeys());
    }
    /**
     * Overridden Iterator method
     * @param comp - the comparison method
     * @return a new Iterator
     */
    @Override
    public Iterator<K> iterator(Comparator<? super K> comp) {
        return new KeyIterator<K>(this, comp);
    }
    /**
     * Gets the color of the node
     * @return boolean
     */
    boolean getColor() {
        return color;
    }
    /**
     * Gets the left MyMap
     * @return MyMap
     */
    BST<K, V> getLeftMap() {
        return (BST<K, V>) l0;
    }
    /**
     * Gets the right MyMap
     * @return MyMap
     */
    BST<K, V> getRightMap() {
        return (BST<K, V>) r0;
    }
    /**
     * Gets the Current key
     * @return K key
     */
    K getKey() {
        return k0;
    }
    /**
     * Gets the Current value
     * @return - the value
     */
    V getValue() {
        return v0;
    }
    
    
    /**
     * Re-orders a section of a tree
     * 
     * @param node
     *            - the tree to be reordered
     * @return Node
     */
    Node<K, V> reOrder(Node<K, V> node) {
        if (((node.getLeftMap()).getColor() == red)
                && ((node.getLeftMap()).getLeftMap().getColor() == red)) {
            return node.redll(node);
        }
        if ((node.getLeftMap().getColor() == red)
                && (node.getLeftMap().getRightMap().getColor() == red)) {
            return node.redlr(node);
        }
        if ((node.getRightMap().getColor() == red)
                && (node.getRightMap().getLeftMap().getColor() == red)) {
            return node.redrl(node);
        }
        if ((node.getRightMap().getColor() == red)
                && (node.getRightMap().getRightMap().getColor() == red)) {
            return node.redrr(node);
        }
        else {
            return node;
        }
    }
    /**
     * If the Left child and the child's Left child is red - reorganize
     * 
     * @param tree
     *            - the tree
     * @return the reorganized BST
     */
    Node<K, V> redll(Node<K, V> tree) {
        BST<K, V> x = tree.getLeftMap().getLeftMap();
        BST<K, V> y = tree.getLeftMap();
        BST<K, V> z = tree;
        BST<K, V> a = tree.getLeftMap().getLeftMap().getLeftMap();
        BST<K, V> b = tree.getLeftMap().getLeftMap().getRightMap();
        BST<K, V> c = tree.getLeftMap().getRightMap();
        BST<K, V> d = tree.getRightMap();

        return reBalance(x, y, z, a, b, c, d);
    }
    /**
     * If the Left child and the child's Right child is red - reorganize
     * 
     * @param tree
     *            - the tree
     * @return the reorganized BST
     */
    Node<K, V> redlr(Node<K, V> tree) {
        BST<K, V> x = tree.getLeftMap();
        BST<K, V> y = tree.getLeftMap().getRightMap();
        BST<K, V> z = tree;
        BST<K, V> a = tree.getLeftMap().getLeftMap();
        BST<K, V> b = tree.getLeftMap().getRightMap().getLeftMap();
        BST<K, V> c = tree.getLeftMap().getRightMap().getRightMap();
        BST<K, V> d = tree.getRightMap();

        return reBalance(x, y, z, a, b, c, d);
    }
    /**
     * If the Right child and the child's Left child is red - reorganize
     * @param tree - the tree
     * @return the reorganized BST
     */
    Node<K, V> redrl(Node<K, V> tree) {
        BST<K, V> x = tree;
        BST<K, V> y = tree.getRightMap().getLeftMap();
        BST<K, V> z = tree.getRightMap();
        BST<K, V> a = tree.getLeftMap();
        BST<K, V> b = tree.getRightMap().getLeftMap().getLeftMap();
        BST<K, V> c = tree.getRightMap().getLeftMap().getRightMap();
        BST<K, V> d = tree.getRightMap().getRightMap();

        return reBalance(x, y, z, a, b, c, d);
    }
    /**
     * If the Right child and the child's Right child is red - reorganize
     * @param tree - the tree
     * @return the reorganized BST
     */
    Node<K, V> redrr(Node<K, V> tree) {
        BST<K, V> x = tree;
        BST<K, V> y = tree.getRightMap();
        BST<K, V> z = tree.getRightMap().getRightMap();
        BST<K, V> a = tree.getLeftMap();
        BST<K, V> b = tree.getRightMap().getLeftMap();
        BST<K, V> c = tree.getRightMap().getRightMap().getLeftMap();
        BST<K, V> d = tree.getRightMap().getRightMap().getRightMap();

        return reBalance(x, y, z, a, b, c, d);
    }
    /**
     * Balances the tree
     * @param x - map
     * @param y - map
     * @param z - map
     * @param a - map
     * @param b - map
     * @param c - map
     * @param d - map
     * @return Node
     */
    Node<K, V> reBalance(BST<K, V> x, BST<K, V> y, BST<K, V> z, BST<K, V> a,
            BST<K, V> b, BST<K, V> c, BST<K, V> d) {
        Node<K, V> left = new Node<K, V>(x.getKey(), x.getValue(), a, b,
                this.c0, black);
        Node<K, V> right = new Node<K, V>(z.getKey(), z.getValue(), c, d,
                this.c0, black);
        Node<K, V> balNode = new Node<K, V>(y.getKey(), y.getValue(), left,
                right, this.c0, black);
        return balNode;
    }
    /**
     * Accept Method
     * @param m - The Visitor
     * @return this
     */
    @Override
    public MyMap<K, V> accept(MyMapVisitor<K, V> m) {
        
        //m.visit(k0, v0);
        return this;
    }
    /**
     * Accept Method
     * @param m - The Visitor
     * @return this
     */
    //@Override
    /*public <R> R acceptRBT(RBTVisitor<K, V, R> m) {
        
        m.visitNode(this.c0, this.color, this.k0, this.v0, this.l0, this.r0);
        return this;
    }*/
    
}