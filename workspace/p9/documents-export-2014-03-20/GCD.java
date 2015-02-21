import mymap.IntCompare;
import mymap.MyMap;
import mymap.MyMapVisitor;


/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 8 : 3/15/14
 */
public class GCD implements MyMapVisitor<Integer, Integer> {

    @SuppressWarnings("unchecked")
    @Override
    public Integer visit(Integer k, Integer v) {
        IntCompare intComp = new IntCompare();
        MyMap<Integer, Integer> m = MyMap.empty(intComp);
        
        m = m.accept(this);
        v = (Integer) m.get(k);
        int gcd = getGCD(k, v);
        return gcd;
    }
    
    /**
     * Calculates the Greatest Common Divisor
     * @param k - the key
     * @param v - the value
     * @return int
     */
    int getGCD(int k, int v) {
        if (k == v) {
            return k;
        }
        return getGCD(k, v % k);
    }
    
}