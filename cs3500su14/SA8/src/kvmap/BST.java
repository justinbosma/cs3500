package kvmap;
/**
 * BST abstract class
 * Subclass of KVMap
 * Superclass of Node - EmptyNode
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 19, 2014
 * @param <K> the Key Type
 * @param <V> the Value Type
 */
public abstract class BST<K, V> extends KVMap<K, V> {
    /**
     * Assign method assigns a key to a value and adds to map
     * @param k - the Key
     * @param v - the Value
     * @return the new KVMap
     */
    public abstract BST<K, V> assign(K k, V v);
    /**
     * Returns the left child map of this map
     * @return the left map
     */
    abstract BST<K, V> getLeft();
    /**
     * Returns the right child map of this map
     * @return the right map
     */
    abstract BST<K, V> getRight();
    /**
     * Gets the Key of the current node
     * @return the Key
     */
    abstract K getKey();
    /**
     * Gets the Value of the current node
     * @return the Value
     */
    abstract V getValue();
    /**
     * Gets the Color of the current node
     * @return the Color
     */
    abstract boolean getColor();
    /**
     * Ins method Inserts nodes below root node
     * @param k - the Key to insert
     * @param v - the Value to insert
     * @return the new BST
     */
    abstract BST<K, V> ins(K k, V v);
    /**
     * Sets the color of a node to black
     * @return the new BST
     */
    abstract BST<K, V> setBlack();
    /**
     * reOrder method checks if tree is one of 4 refactoring conditions
     * and delegates to appropriate case handling method
     * @return the re-ordered BST
     */
    abstract BST<K, V> reOrder();
//    /**
//    * accept method for Visitor pattern
//    * @param v - the visitor
//    * @return a KVMap
//    */
//    public KVMap<K, V> accept(KVMapVisitor<K, V> visitor) {
//        throw new UnsupportedOperationException("Accept - BST");
//    }
}