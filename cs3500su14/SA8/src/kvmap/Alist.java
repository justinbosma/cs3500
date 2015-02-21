package kvmap;

/**
 * Alist abstract class 
 * Subclass of KVMap
 * Superclass of Assign - EmptyMap
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 19, 2014
 * @param <K> the Key Type
 * @param <V> the Value Type
 */
public abstract class Alist<K, V> extends KVMap<K, V> {
    /**
     * Assign method assigns a key to a value and adds to map
     * @param k - the Key
     * @param v - the Value
     * @return the new KVMap
     */
    public abstract Alist<K, V> assign(K k, V v);
    /**
     * Accept method for Visitor patter
     * @param <R> - the generic return type
     * @param v - the Visitor
     * @return R - the type of elements returned by method
     */
    @Override
    public <R> R acceptRBT(RBTVisitor<K, V, R> v) {
        throw new UnsupportedOperationException("AcceptRBT - Alist");
    }
}