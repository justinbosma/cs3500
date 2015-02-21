package kvmap;
import java.util.Comparator;

/**
 * String Compare class for Testing Examples class
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 22, 2014
 */
public class StrCompare implements Comparator<String> {
    /**
     * Compares two Strings
     * @param s - first String
     * @param t - second String
     * @return 0 if equal, -1 if less than, 1 if greater than
     */
    public int compare(String s, String t) {
        return s.compareTo(t);
    }
}