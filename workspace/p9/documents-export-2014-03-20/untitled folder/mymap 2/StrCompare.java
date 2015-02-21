package mymap;
import java.util.Comparator;

/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 5 : 2/10/14
 */
public class StrCompare implements Comparator<String> {
    /**
     * Compares two Strings
     * @param s - first String
     * @param t - second String
     * @return 0 if equal, -1 if less than, 1 if greater than
     */
    public int compare(String s, String t) {
        //System.out.println("StrCompare :: comparing :" + s + " : 
        //to :" + t +"::= " + s.compareTo(t) + "::");
        
        return s.compareTo(t);
    }
}