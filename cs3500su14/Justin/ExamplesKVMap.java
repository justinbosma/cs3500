import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import tester.Tester;

/**
 * 
 * @author Justin Bosma Username: jbosma0
 * @version 5/20/14
 * 
 */
public class ExamplesKVMap {

    private Comparator<Integer> c;
    private ArrayList<Integer> a = new ArrayList<Integer>();
    private ArrayList<Integer> b = new ArrayList<Integer>();
    private KVMap<Integer, String> m0 = new Assign<Integer, String>(3, "Hi",
            new EmptyMap<Integer, String>());
    private KVMap<Integer, String> m1 = new Assign<Integer, String>(5, "Help",
            new EmptyMap<Integer, String>());
    private KVMap<Integer, String> m2 = new Assign<Integer, String>(3, "Hi",
            new EmptyMap<Integer, String>());
    private KVMap<Integer, String> mT = KVMap.emptyMap();
    private KVMap<Integer, String> mT2 = KVMap.emptyMap(c);
    private KVMap<Integer, String> r =  mT2.assign(3, "Hi");

    /**
     * Tests for emptyMap
     * @param t tester
     * @return true if tests pass
     */
    boolean testEmptyMap(Tester t) {
        return t.checkExpect(KVMap.emptyMap().isEmpty())
                && t.checkExpect(m0.isEmpty(), false);
    }
    /**
     * Tests for size
     * @param t tester
     * @return true if tests pass
     */
    boolean testSize(Tester t) {
        return t.checkExpect(KVMap.emptyMap().size() == 0)
                && t.checkExpect(m0.assign(4, "F").size() == m0.size() + 1)
                && t.checkExpect(m0.assign(3, "Hi").size() == m0.size());
    }
    /**
     * Tests for containskey
     * @param t tester
     * @return true if tests pass
     */
    boolean testContainsKey(Tester t) {
        return t.checkExpect(KVMap.emptyMap().containsKey(3), false)
                && t.checkExpect(m0.containsKey(3))
                && t.checkExpect(m0.containsKey(7), false);
    }
    /**
     * Tests for containsvalue
     * @param t tester
     * @return true if tests pass
     */
    boolean testContainsValue(Tester t) {
        return t.checkExpect(KVMap.emptyMap().containsValue("Hi"), false)
                && t.checkExpect(m0.containsValue("Hi"))
                && t.checkExpect(m0.containsValue("Arf"), false);
    }
    /**
     * Exception Tests for get
     * @param t tester
     * 
     */
    public void testGet2(Tester t) {
        try {
            t.checkExpect(KVMap.emptyMap().get(3), false);
            t.checkExpect(mT.iterator().hasNext(),true);
        } 
        catch (Exception e) {
            System.out.println("Exception for testGet passed");
            System.out.println("Exception for hasNext() passed");
        }
    }
    /**
     * Tests for get
     * @param t tester
     * @return true if tests pass
     */
    boolean testGet(Tester t) {
        return t.checkExpect(m0.assign(9, "a").get(9).equals("a"))
                && t.checkExpect(m0.assign(9, "a").get(3).equals(m0.get(3)));
    }
    /**
     * Tests for tostring
     * @param t tester
     * @return true if tests pass
     */
    boolean testToString(Tester t) {
        return t.checkExpect(m0.toString(), "{...[There are " + m0.size()
                + " unique key(s) mapped to value(s) in this KVMap]...}");
    }
    /**
     * Tests for equals
     * @param t tester
     * @return true if tests pass
     */
    boolean testEquals(Tester t) {
        return t.checkExpect(m1.equals(m1), true)
                && t.checkExpect(m1.assign(3, "Hi")
                        .equals(m2.assign(5, "Help")), true)
                && t.checkExpect(m0.equals(m1.assign(99, "w")), false)
                && t.checkExpect(m0.equals("Meow"), false)
                && t.checkExpect(m0.equals(KVMap.emptyMap()), false) &&
                t.checkExpect(mT.equals(mT2));

    }

    
    /**
     * Tests for iterator
     * @param t tester
     * @return true if tests pass
     */
    boolean testIterator(Tester t) {

        return t.checkExpect(m0.iterator(),
                new KVMapIterator<Integer>(m0.doer(a))) &&
                 t.checkExpect(m0.iterator(c), new KVMapIterator<Integer>(c,
                        m0.doer(b))) &&
                   t.checkExpect(mT.iterator(), new KVMapIterator<Integer>(
                           new ArrayList<Integer>())) &&
                   t.checkExpect(mT.iterator(c), new KVMapIterator<Integer>(
                           new ArrayList<Integer>())) &&
                           t.checkExpect(m0.iterator().next(),3) &&
                           t.checkExpect(m0.iterator().hasNext(),true);
    }
    /**
     * Tests for getrest
     * @param t tester
     * @return true if tests pass
     */
    boolean testGetRest(Tester t) {
        return t.checkExpect(m0.getRest(), new EmptyMap<String, Integer>()) &&
                 t.checkExpect(m0.assign(1, "!").getRest(), m0) &&
                 t.checkExpect(mT.getRest(), mT);
    }
    /**
     * Tests for hashCode
     * @param t tester
     * @return true if tests pass
     */
    boolean testHashCode(Tester t) {
        return t.checkExpect(m0.hashCode(), 2341) &&
                 t.checkExpect(m0.assign(4, "!").hashCode(), 2378) &&
                 t.checkExpect(new EmptyMap<String, Integer>().hashCode(), 1) &&
                 t.checkExpect(m0.assign(
                         4, "!").assign(4, "h").hashCode(), 2449);
    }
    /**
     * Tests for doer
     * @param t tester
     * @return true if tests pass
     */
    boolean testDoer(Tester t) {
        return t.checkExpect(mT.doer(new ArrayList<Integer>()),
                new ArrayList<Integer>());
    }

}
