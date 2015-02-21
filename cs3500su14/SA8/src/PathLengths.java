import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import kvmap.KVMap;
import kvmap.RBTVisitor;
/**
 * PathLengths implements RBTVisitor such that 
 * the visit methods produce an ArrayList of the lengths of the paths 
 * from the root to each empty
 * ---the length should not include the empty
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version Jun 3, 2014
 * @param <K> - the key type
 * @param <V> - the Value type
 */
public class PathLengths<K, V> implements 
    RBTVisitor<K, V, ArrayList<Integer>> {
    //ArrayList al = new ArrayList();
    /**
     * Override of RBTVisitor visitEmpty method
     * Adds a zero if an empty node
     * @param comp - the comparator
     * @param color - the color
     * @return the arraylist
     */
    @Override
    public ArrayList<Integer> visitEmpty(Comparator<? super K> comp, 
            String color) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(0);
        return al;
    }
    /**
     * Override of RBTVisitor visitNode method
     * @param comp - the comparator
     * @param color - the color
     * @param k - the Key
     * @param v - the Value
     * @param left - the left tree
     * @param right - the right tree
     * @return the arraylist
     */
    @Override
    public ArrayList<Integer> visitNode(Comparator<? super K> comp, 
            String color, K k, V v,
            KVMap<K, V> left, KVMap<K, V> right) {
        ArrayList<Integer> al = (ArrayList<Integer>) left.acceptRBT(this);
        al.addAll((Collection<? extends Integer>) right.acceptRBT(this));
        for (int i = 0; i < al.size(); i++) {
            al.set(i, al.get(i) + 1);
        }
        return al;
        //return null;
        //------------------------------------
//        ArrayList al = new ArrayList();
//        
//        if (left.isEmpty()) {
//            al.add(1);
//        }
//        if (right.isEmpty()) {
//            //al.add(right.acceptRBT(this));
//            al.add(1);
//        }
//        al.add(left.acceptRBT(this));
//        al.add(right.acceptRBT(this));
//        
//        return al;
        //------------------------------------
    }
}