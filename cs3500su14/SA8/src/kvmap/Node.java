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
    private BST<K, V> leftMap; 
    private BST<K, V> rightMap;
    private Comparator<? super K> c0;
    private int size;
    //color boolean represents node color - Red if True/ Black if False
    private boolean color;
    private boolean red = true;
    private boolean black = false;
    //private final boolean dEBUG = true;
    /**
     * 
     * Constructor for Node class
     * @param k - the Key
     * @param v - the Value
     * @param left - the left of the tree
     * @param right - the right of the tree
     * @param c - the comparator
     * @param colour - the color of the node
     */
    public Node(K k, V v, BST<K, V> left, BST<K, V> right, 
            Comparator<? super K> c, boolean colour) {
        this.k0 = k;
        this.v0 = v;
        this.leftMap = left;
        this.rightMap = right;
        this.c0 = c;
        this.size = 1 + this.leftMap.size() + this.rightMap.size();
        this.color = colour;
    }
    /**
     * Assign method calls ins method and sets the root to black
     * @param k - the Key
     * @param v - the Value
     * @return the new BST
     */
    public BST<K, V> assign(K k, V v) {
        return ins(k, v).reOrder().setBlack();
    }
    /**
     * Ins method assigns a key to a value and adds to BST
     * @param k - the Key
     * @param v - the Value
     * @return the new BST
     */
    @Override
    BST<K, V> ins(K k, V v) {
        if (this.c0.compare(k, this.k0) > 0) {
            //this.size = this.size + 1;
            return new Node<K, V>(this.k0, this.v0, 
                    this.leftMap, this.rightMap.ins(k, v), 
                    this.c0, this.color).reOrder();
        }
        if (this.c0.compare(k, this.k0) < 0) {
            //this.size = this.size + 1;
            return new Node<K, V>(this.k0, this.v0, 
                    this.leftMap.ins(k, v), this.rightMap, 
                    this.c0, this.color).reOrder();
        }
        else {
            return new Node<K, V>(k, v, this.leftMap, this.rightMap, this.c0, 
                    this.color).reOrder();
        }
    }
    /**
     * Sets the Current nodes color to black
     * @return the new black node
     */
    BST<K, V> setBlack() {
        return new Node<K, V>(this.k0, this.v0, this.leftMap,
                              this.rightMap, this.c0, black);
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
        return this.v0.equals(v)
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
//    /**
//     * Prints the Tree - used for debugging
//     * @param n - the size of the tree
//     */
//    private String toString (int n) {
//        String result = "";
//        String color;
//        if (this.color) {
//            color = "Red";
//        }
//        else {
//            color = "Black";
//        }
//        String s = "";
//        if (!this.leftMap.isEmpty()){
//            s = "::L=:" + this.leftMap.getKey();
//        }
//        else {
//            s = "::L=:MT";
//        }
//        if ( !this.rightMap.isEmpty()) {
//            s = s + "::R=:" + this.rightMap.getKey();
//        }
//        else {
//            s = s + "::R=:MT";
//        }
//        for (int i = 0; i < n; i = i + 1)
//        result = result + " ";
//        result = result + " " + k0 + ", " + v0 + "::Col:" + color + s;
//                
//        result = result + "\n";
//        if (rightMap.isEmpty())
//        result = result + "\n";
//        else {
//        Node<K,V> right = (Node<K,V>) this.rightMap;
//        result = result + right.toString (n + 1);
//        }
//        if (leftMap.isEmpty())
//        result = result + "\n";
//        else {
//        Node<K,V> left = (Node<K,V>) this.leftMap;
//        result = result + left.toString (n + 1);
//        }
//        return result;
//        }
    /**
     * toString represents the BST as a string
     * @return the string
     */
    @Override
    public String toString() {
//        if (dEBUG) {
//            return this.toString(1); 
//        }
//        else {
        return "{...[There are " + this.size() + 
                    " unique key(s) mapped to " + "value(s) in this KVMap]...}";
//        }
    }
    /**
     * Compares an object to a BST for equality
     * @param o - the object
     * @return true if equal, false if not equal
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public boolean equals(Object o) {
        if (o instanceof KVMap) {
            if (o instanceof EmptyNode || o instanceof EmptyMap || o == null) {
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
     * Generates a hashCode for a BST
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
     * Iterator method for BST
     * @return the Iterator
     */
    @Override
    public Iterator<K> iterator() {
        return new MapIterator<K>(this.getKeys());
    }
    /**
     * Iterator method for BST with Comparator
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
        ArrayList<K> al = new ArrayList<K>(getHash(new HashSet<K>()));
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
        return this.rightMap.getHash(this.leftMap.getHash(hash));
        //return hash;
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
    /**
     * Returns the left child map of this map
     * @return the left map
     */
    BST<K, V> getLeft() {
        return this.leftMap;
    }
    /**
     * Returns the right child map of this map
     * @return the right map
     */
    BST<K, V> getRight() {
        return this.rightMap;
    }
    /**
     * Returns the current key
     * @return the key
     */
    K getKey() {
        return this.k0;
    }
    /**
     * Returns the current value
     * @return the value
     */
    V getValue() {
        return this.v0;
    }
    /**
     * Balances the tree - Reasssembles the nodes in correct format/order
     * @return the balanced tree
     * @param x - a BST
     * @param y - a BST
     * @param z - a BST
     * @param a - a BST
     * @param b - a BST
     * @param c - a BST
     * @param d - a BST
     * @return
     */
    BST<K, V> reBalance(BST<K, V> x, BST<K, V> y, BST<K, V> z, 
            BST<K, V> a, BST<K, V> b, BST<K, V> c, BST<K, V> d) {
        BST<K, V> left = new Node<K, V>(x.getKey(), x.getValue(), a, b,
                this.c0, black);
        BST<K, V> right = new Node<K, V>(z.getKey(), z.getValue(), c, d,
                this.c0, black);
        BST<K, V> done = new Node<K, V>(y.getKey(), y.getValue(), left,
                right, this.c0, red);
        return done;
    }
    /**
     * Gets the color of the current node
     * @return the color
     */
    boolean getColor() {
        return this.color;
    }
    /**
     * reOrder method checks if tree is one of 4 refactoring conditions
     * and delegates to appropriate case handling method
     * @return the re-ordered BST
     */
    BST<K, V> reOrder() {
        if (this.leftMap.isEmpty() && this.rightMap.isEmpty()) {
            return this;
        }
        else if ((this.leftMap.getColor() == red) && 
            (this.leftMap.getLeft().getColor() == red)) {
            return this.redLL();
        }
        else if ((this.leftMap.getColor() == red) && 
            (this.leftMap.getRight().getColor() == red)) {
            return this.redLR();
        }
        else if (this.rightMap.getColor() == red && 
            this.rightMap.getLeft().getColor() == red) {
            return this.redRL();
        }
        else if (this.rightMap.getColor() == red && 
            this.rightMap.getRight().getColor() == red) {
            return this.redRR();
        }
        else {
            return this;
        }
    }
    /**
     * Case 1 - Black Parent, Red Child on Left, Red Grandchild on Left
     * Calls reBalance method to reassemble the nodes in correct order
     * @return the refactored tree
     */
    BST<K, V> redLL() {
        BST<K, V> x = this.getLeft().getLeft();
        BST<K, V> y = this.getLeft();
        BST<K, V> z = this;
        BST<K, V> a = this.getLeft().getLeft().getLeft();
        BST<K, V> b = this.getLeft().getLeft().getRight();
        BST<K, V> c = this.getLeft().getRight();
        BST<K, V> d = this.getRight();

        return reBalance(x, y, z, a, b, c, d);
    }
    /**
     * Case 1 - Black Parent, Red Child on Left, Red Grandchild on Right
     * Calls reBalance method to reassemble the nodes in correct order
     * @return the refactored tree
     */
    BST<K, V> redLR() {
        BST<K, V> x = this.getLeft();
        BST<K, V> y = this.getLeft().getRight();
        BST<K, V> z = this;
        BST<K, V> a = this.getLeft().getLeft();
        BST<K, V> b = this.getLeft().getRight().getLeft();
        BST<K, V> c = this.getLeft().getRight().getRight();
        BST<K, V> d = this.getRight();

        return reBalance(x, y, z, a, b, c, d);
    }
    /**
     * Case 1 - Black Parent, Red Child on Right, Red Grandchild on Left
     * Calls reBalance method to reassemble the nodes in correct order
     * @return the refactored tree
     */
    BST<K, V> redRL() {
        BST<K, V> x = this;
        BST<K, V> y = this.getRight().getLeft();
        BST<K, V> z = this.getRight();
        BST<K, V> a = this.getLeft();
        BST<K, V> b = this.getRight().getLeft().getLeft();
        BST<K, V> c = this.getRight().getLeft().getRight();
        BST<K, V> d = this.getRight().getRight();

        return reBalance(x, y, z, a, b, c, d);
    }
    /**
     * Case 1 - Black Parent, Red Child on Right, Red Grandchild on Right
     * Calls reBalance method to reassemble the nodes in correct order
     * @return the refactored tree
     */
    BST<K, V> redRR() {
        BST<K, V> x = this;
        BST<K, V> y = this.getRight();
        BST<K, V> z = this.getRight().getRight();
        BST<K, V> a = this.getLeft();
        BST<K, V> b = this.getRight().getLeft();
        BST<K, V> c = this.getRight().getRight().getLeft();
        BST<K, V> d = this.getRight().getRight().getRight();

        return reBalance(x, y, z, a, b, c, d);
    }
    /**
     * accept method for Visitor pattern
     * @param visitor - the visitor
     * @return a KVMap
     */
    @Override
    public KVMap<K, V> accept(KVMapVisitor<K, V> visitor) {
        BST<K, V> left = (BST<K, V>) leftMap.accept(visitor);
        BST<K, V> right = (BST<K, V>) rightMap.accept(visitor);
        return new Node<K, V>(this.k0, visitor.visit(this.k0, this.v0), 
                left, right, this.c0, this.color);
//        if (visitor instanceof KVMapVisitor) {
//            KVMap<K, V> m2 = KVMap.emptyMap();
//            for (K k : this) {
//                V v = visitor.visit(k, this.get(k));
//                m2 = m2.assign(k, v);
//            }
//            return m2;
//        }
//        else {
//            return this;
//        }
    }
    /**
     * Accept method for Visitor patter
     * @param visitor - the Visitor
     * @param <R> - the return type
     * @return R - the type of elements returned by method
     */
    @Override
    public <R> R acceptRBT(RBTVisitor<K, V, R> visitor) {
        String col = strColor(this.getColor());
        return visitor.visitNode(this.c0, col, this.k0, this.v0, 
                this.leftMap, this.rightMap);
    }
    /**
     * Converts Boolean color value to string representation
     * @param c - this nodes color 
     * @return the string representation of this nodes color
     */
    String strColor(boolean c) {
        String col = "";
        if (c) {
            col = "RED";
        }
        else {
            col = "BLACK";
        }
        return col;
    }
}