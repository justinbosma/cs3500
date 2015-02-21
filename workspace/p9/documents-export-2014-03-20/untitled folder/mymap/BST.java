package mymap;
//import java.util.Comparator;

/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 5 : 2/10/14
 * @param <K> - The key stored in the map 
 * @param <V> - the the value stored in the map
 */
public abstract class BST<K, V> extends MyMap<K, V> {

    /**
     * gets the key of the BST
     * @return K
     */
    abstract K getKey();
    /**
     * gets the value of the BST
     * @return V
     */
    abstract V getValue();
    /**
     * gets the color of the BST
     * @return boolean
     */
    abstract boolean getColor();
    /**
     * gets the left map of the BST
     * @return BST
     */
    abstract BST<K, V> getLeftMap();
    /**
     * gets the right map of the BST
     * @return BST
     */
    abstract BST<K, V> getRightMap();
    /**
     * reorganizes the Red - left left case
     * @param n - the node
     * @return Node
     */
    abstract Node<K, V> redll(Node<K, V> n);
    /**
     * reorganizes the Red - left right case
     * @param n - the node
     * @return Node
     */
    abstract Node<K, V> redlr(Node<K, V> n);
    /**
     * reorganizes the Red -  right left case
     * @param n - the node
     * @return Node
     */
    abstract Node<K, V> redrl(Node<K, V> n);
    /**
     * reorganizes the Red - right right case
     * @param n - the node
     * @return Node
     */
    abstract Node<K, V> redrr(Node<K, V> n);
}