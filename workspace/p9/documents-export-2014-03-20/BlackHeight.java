import java.util.Comparator;

import mymap.MyMap;
import mymap.RBTVisitor;
/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 8 : 3/15/14
 * @param <Integer> - the integer
 * @param <String> - the value
 */
public class BlackHeight<Integer, String> implements RBTVisitor {

    /**
     * visit methods return the black height of the tree–––
     * number of non-empty black node from the root to any empty node
     * @param comp - the comparator
     * @param color - the color of the node
     * @return the Object
     */
    @Override
    public Object visitEmpty(Comparator comp, java.lang.String color) {
        return null;
    }
    /**
     * visit methods return the black height of the tree–––
     * number of non-empty black node from the root to any empty node
     * @param comp - the comparator
     * @param color - the color of the node
     * @param k - the key
     * @param v - the value
     * @param left - the left MyMap
     * @param right - the right MyMap
     * @return the Object
     */
    @Override
    public Object visitNode(Comparator comp, java.lang.String color, Object k,
            Object v, MyMap left, MyMap right) {
        return null;
    }
    
}