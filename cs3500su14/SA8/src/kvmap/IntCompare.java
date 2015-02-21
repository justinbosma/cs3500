package kvmap;
import java.util.Comparator;

/**
 * Integer Compare class for Testing Examples class
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 22, 2014
 */
public class IntCompare implements Comparator<Integer> {
    /**
     * Compares two Integers
     * @param s - first Integer
     * @param t - second Integer
     * @return 0 if equal, -1 if less than, 1 if greater than
     */
    public int compare(Integer s, Integer t) {
        return s - t;
    }
}