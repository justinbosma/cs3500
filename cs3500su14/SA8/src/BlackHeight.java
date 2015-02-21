import java.util.Comparator;

import kvmap.KVMap;
import kvmap.RBTVisitor;

/**
 * BlackHeight implements RBTVisitor such that the visit methods return the 
 * black height of the tree---number of non-empty black node from the root 
 * to any empty node
 * 
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version Jun 3, 2014
 * @param <K> - the Key Type
 * @param <V> - the Value Type
 */
public class BlackHeight<K, V> implements RBTVisitor<K, V, Integer> {
    /**
     * VisitEmpty method for BlackHeight class
     * @param comp - the comparator
     * @param color - the color (a string)
     * @return 0
     */
    @Override
    public Integer visitEmpty(Comparator<? super K> comp, String color) {
        return 0;
    }
    /**
     * VisitNode Method for BlackHEight class
     * @param comp - the comparator
     * @param color - the color
     * @param k - the key
     * @param v - the value
     * @param left - the left tree
     * @param right - the right tree
     * @return the black height of the tree
     */
    @Override
    public Integer visitNode(Comparator<? super K> comp, String color, K k, V v,
            KVMap<K, V> left, KVMap<K, V> right) {
        Integer height = left.acceptRBT(this);
        
        if (color.equals("BLACK")) {
            return 1 + height;
        }
        else {
            return height;
        }
    }
}