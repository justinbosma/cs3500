package mymap;
import java.util.Comparator;

/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 5 : 2/10/14
 */
public class IntCompare implements Comparator<Integer> {
    /**
     * Compares two Integers
     * @param o1 - first int
     * @param o2 - second int
     * @return 0 if equal, -1 if less than, 1 if greater than
     */
    @Override
    public int compare(Integer o1, Integer o2) {
        //int n1 = o1.intValue();
        //int n2 = o2.intValue();
        return o1.compareTo(o2);
        /*if (o1 == o2) {
            return 0;
        }
        if (o1 < o2) {
            return -1;
        }
        else {
            return 1;
        }*/
    }
}