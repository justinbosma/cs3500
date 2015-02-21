package mymap;
import java.util.Comparator;
/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version (2013-01-31)
 * @param <K>
 */
public class KCompare<K> implements Comparator<K> {
    /**
     * Compares two K's
     * @param o1 - first object
     * @param o2 - second object
     * @return 0 if equal, -1 if less than, 1 if greater than
     */
    @Override
    public int compare(K o1, K o2) {
        System.out.println("comparing :" + o1.toString() + " : to :" 
                + o2.toString());
        if ((o1.hashCode() == o2.hashCode()) && (o1.equals(o2))) {
            
            return 0;
        }
        if (o1.hashCode() < o2.hashCode()) {
            return -1;
        }
        else {
            return 1;
        }
    }
    
}