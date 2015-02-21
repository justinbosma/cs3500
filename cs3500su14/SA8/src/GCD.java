import kvmap.KVMapVisitor;


/**
 * GCD Class returns the GCD for visitor Key and Value
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version Jun 3, 2014
 */
public class GCD implements KVMapVisitor<Integer, Integer> {
    /**
     * Override of the KVMapVisitor visit method
     * @param k - the Key
     * @param v - the Value
     * @return the GCD of the Key/Value
     */
    @Override
    public Integer visit(Integer k, Integer v) {
        return gcd(k, v);
    }
    /**
     * Recursively Calculates gcd using Euclid's Algorithm
     * @param a - an Integer
     * @param b - an Integer
     * @return - the GCD
     */
    Integer gcd(Integer a, Integer b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}