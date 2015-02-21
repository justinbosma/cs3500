import kvmap.KVMapVisitor;


/**
 * StringWithNumber implements KVMapVisitor<Integer, String> such that the 
 * visit method returns v followed by k with a space in between
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version Jun 3, 2014
 */
public class StringWithNumber implements KVMapVisitor<Integer, String> {
    /**
     * Override of the KVMapVisitor visit method
     * @param k - the Key
     * @param v - the Value
     * @return the K followed by a Space followed by the Value "K V"
     */
    @Override
    public String visit(Integer k, String v) {
        return (v + " " + String.valueOf(k));
    }
}