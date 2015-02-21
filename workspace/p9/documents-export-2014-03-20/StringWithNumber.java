import mymap.*;
//import mymap.MyMapVisitor;
/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 8 : 3/15/14
 */

public class StringWithNumber implements MyMapVisitor<Integer, String> {

    /**
     * Visit method returns a v followed by a k with 
     * a space in between.
     * @param k - the key
     * @param v - the value
     * @return the string "v k"
     */
    @Override
    public String visit(Integer k, String v) {
        
        
        return "" + v + " " + k + "";
    }
    
}