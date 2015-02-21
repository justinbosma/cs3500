import java.util.ArrayList;
import java.util.Comparator;
import tester.Tester;

/**
 * Testing class for the KVMap Abstract Data Type
 * 
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 14, 2014
 */
public class ExamplesKVMap {
    private Comparator<String> strComp;
    private Comparator<Integer> intComp;
    
    private KVMap<Integer, String> intMap1 = KVMap.emptyMap(intComp);
    private KVMap<Integer, String> intMapMT = KVMap.emptyMap();
    private KVMap<Integer, String> intMap001 = intMapMT.assign(1, "one");
    private KVMap<Integer, String> intMap021 = intMap001.assign(2, "two");
    private KVMap<Integer, String> intMap321 = intMap021.assign(3, "three");
    private KVMap<Integer, String> intMap3321 = intMap321.assign(3, "double");
    
    private KVMap<String, String> strMapMTComp = KVMap.emptyMap(strComp);
    private KVMap<String, String> strMap001Comp = 
            strMapMTComp.assign("1", "uno");
    
    private ArrayList<Integer> alMT = new ArrayList<Integer>();
    private ArrayList<Integer> al1 = new ArrayList<Integer>();
    private ArrayList<Integer> al2 = new ArrayList<Integer>();
    private ArrayList<Integer> al3 = new ArrayList<Integer>();
    private ArrayList<Integer> al2sorted = new ArrayList<Integer>();
    private ArrayList<Integer> al3sorted = new ArrayList<Integer>();
    
    private ArrayList<String> alstrMT = new ArrayList<String>();
    private ArrayList<String> alstr1 = new ArrayList<String>();
    
    
    /**
     * Constructor for Examples Class
     */
    public ExamplesKVMap() {
        al1.add(1);
        
        al2.add(2);
        al2.add(1);
        
        al3.add(3);
        al3.add(2);
        al3.add(1);
        
        al2sorted.add(1);
        al2sorted.add(2);
        
        al3sorted.add(1);
        al3sorted.add(2);
        al3sorted.add(3);
        
        alstr1.add("1");
    }
    /**
     * Tests if the KVMap is Empty
     * @param t - the Tester object
     */
    public void testIsEmpty(Tester t) {
        t.checkExpect(intMap1.isEmpty(), true);
        t.checkExpect(intMapMT.isEmpty(), true);
        t.checkExpect(intMap001.isEmpty(), false);
        t.checkExpect(intMap021.isEmpty(), false);
        t.checkExpect(intMap321.isEmpty(), false);
        
        t.checkExpect(strMapMTComp.isEmpty(), true);
        t.checkExpect(strMap001Comp.isEmpty(), false);
    }
    /**
     * Tests the Size Method
     * @param t - the Tester object
     */
    public void testSize(Tester t) {
        t.checkExpect(intMapMT.size(), 0);
        t.checkExpect(intMap001.size(), 1);
        t.checkExpect(intMap021.size(), 2);
        t.checkExpect(intMap321.size(), 3);
        
        t.checkExpect(strMapMTComp.size(), 0);
        t.checkExpect(strMap001Comp.size(), 1);
    }
    /**
     * Tests the ContainsKey Method
     * @param t - the tester object
     */
    public void testContainsKey(Tester t) {
        t.checkExpect(intMapMT.containsKey(0), false);
        t.checkExpect(intMapMT.containsKey(5), false);
        
        t.checkExpect(intMap001.containsKey(0), false);
        t.checkExpect(intMap001.containsKey(1), true);
        
        t.checkExpect(intMap021.containsKey(0), false);
        t.checkExpect(intMap021.containsKey(1), true);
        t.checkExpect(intMap021.containsKey(2), true);
        t.checkExpect(intMap021.containsKey(3), false);
        
        t.checkExpect(intMap321.containsKey(0), false);
        t.checkExpect(intMap321.containsKey(1), true);
        t.checkExpect(intMap321.containsKey(2), true);
        t.checkExpect(intMap321.containsKey(3), true);
        t.checkExpect(intMap321.containsKey(4), false);
        
        t.checkExpect(strMapMTComp.containsKey("1"), false);
        t.checkExpect(strMap001Comp.containsKey("1"), true);
        t.checkExpect(strMap001Comp.containsKey("one"), false);
    }
    /**
     * Tests the ContainsValue Method
     * @param t - the Tester object
     */
    public void testContainsValue(Tester t) {
        t.checkExpect(intMapMT.containsValue("1"), false);
        
        t.checkExpect(intMap001.containsValue("1"), false);
        t.checkExpect(intMap001.containsValue("one"), true);
        
        t.checkExpect(intMap021.containsValue("1"), false);
        t.checkExpect(intMap021.containsValue("one"), true);
        t.checkExpect(intMap021.containsValue("two"), true);
        t.checkExpect(intMap021.containsValue("three"), false);
        
        t.checkExpect(intMap321.containsValue("1"), false);
        t.checkExpect(intMap321.containsValue("one"), true);
        t.checkExpect(intMap321.containsValue("two"), true);
        t.checkExpect(intMap321.containsValue("three"), true);
        t.checkExpect(intMap321.containsValue("four"), false);
        
        t.checkExpect(strMapMTComp.containsValue("1"), false);
        t.checkExpect(strMap001Comp.containsValue("1"), false);
        t.checkExpect(strMap001Comp.containsValue("uno"), true);
        
        t.checkExpect(intMap3321.containsValue("three"), false);
        t.checkExpect(intMap3321.containsValue("double"), true);
        
        KVMap<Integer, String> da = KVMap.emptyMap();
        da = da.assign(1, "Alice");
        da = da.assign(1, "Dave");
        t.checkExpect(da.containsValue("Alice"), false);
        t.checkExpect(da.containsValue("Dave"), true);
        t.checkExpect(da.containsKey(1), true);
    }
    /**
     * Tests the Get Method
     * @param t - the Tester object
     */
    public void testGet(Tester t) {
        try {
            t.checkExpect(intMapMT.get(1), "one");
        }
        catch (RuntimeException e) {
            System.out.println("::intMT.get():::Exception Test Passed:::");
        }
        catch (Exception e) {
            System.out.println("::intMT.get():::Exception Test Failed:::");
        }
        t.checkExpect(intMap001.get(1), "one");
        t.checkExpect(intMap021.get(1), "one");
        t.checkExpect(intMap321.get(1), "one");
        
        t.checkExpect(intMap021.get(2), "two");
        t.checkExpect(intMap321.get(2), "two");
        
        t.checkExpect(intMap321.get(3), "three");
        
        t.checkExpect(strMap001Comp.get("1"), "uno");
        
        try {
            t.checkExpect(strMapMTComp.get("1"), "uno");
        }
        catch (Exception e) {
            System.out.println("::strMT.get():::Exception Test Passed:::");
        }
    }
    /**
     * Tests the toString Method
     * @param t - the Tester object
     */
    public void testToString(Tester t) {
        t.checkExpect(intMapMT.toString(), "{...[There are 0 unique key(s) "
                + "mapped to value(s) in this KVMap]...}");
        t.checkExpect(intMap001.toString(), "{...[There are 1 unique key(s) "
                + "mapped to value(s) in this KVMap]...}");
        t.checkExpect(intMap021.toString(), "{...[There are 2 unique key(s) "
                + "mapped to value(s) in this KVMap]...}");
        t.checkExpect(intMap321.toString(), "{...[There are 3 unique key(s) "
                + "mapped to value(s) in this KVMap]...}");
        t.checkExpect(strMapMTComp.toString()
                .equals(intMapMT.toString()), true);
        t.checkExpect(strMap001Comp.toString()
                .equals(intMap001.toString()), true);
        t.checkExpect(strMap001Comp.toString()
                .equals(intMapMT.toString()), false);
    }
    /**
     * Tests the equals method
     * @param t - the Tester object
     */
    public void testEquals(Tester t) {
        String x = "";
        t.checkExpect(intMapMT.equals(intMapMT), true);
        t.checkExpect(intMapMT.equals(intMap001), false);
        
        t.checkExpect(intMap001.equals(null), false);
        t.checkExpect(intMap001.equals(x), false);
        t.checkExpect(intMap001.equals(intMap001), true);
        t.checkExpect(intMap021.equals(intMap021), true);
        t.checkExpect(intMap321.equals(intMap321), true);
        
        
        KVMap<Integer, String> cba121 = KVMap.emptyMap();
        cba121 = cba121.assign(1, "Carol");
        cba121 = cba121.assign(2, "Bob");
        cba121 = cba121.assign(1, "Alice");
        KVMap<Integer, String> abc121 = KVMap.emptyMap();
        abc121 = abc121.assign(1, "Alice");
        abc121 = abc121.assign(2, "Bob");
        abc121 = abc121.assign(1, "Carol");
        
        KVMap<Integer, String> a = KVMap.emptyMap();
        a = a.assign(1, "Alice");
        KVMap<Integer, String> b = KVMap.emptyMap();
        b = b.assign(2, "Bob");
        b = b.assign(1, "Alice");
        t.checkExpect(a.equals(b), false);
        
        t.checkExpect(intMap001.equals(intMap021), false);
        t.checkExpect(intMap001.equals(intMap321), false);
        t.checkExpect(intMap021.equals(intMap001), false);
        t.checkExpect(intMap021.equals(intMap321), false);
        t.checkExpect(intMap321.equals(intMap021), false);
        t.checkExpect(intMap321.equals(intMap001), false);
        
        t.checkExpect(strMapMTComp.equals(strMapMTComp), true);
        t.checkExpect(strMapMTComp.equals(intMapMT), true);
        t.checkExpect(strMapMTComp.equals(intMap001), false);
        t.checkExpect(strMap001Comp.equals(strMapMTComp), false);
        t.checkExpect(strMap001Comp.equals(strMap001Comp), true);
    }
    /**
     * Tests the hashCode method
     * @param t - the Tester object
     */
    public void testHashCode(Tester t) {
        t.checkExpect(intMapMT.hashCode(), intMapMT.hashCode());
        t.checkExpect(intMap001.hashCode(), intMap001.hashCode());
        t.checkExpect(intMap021.hashCode(), intMap021.hashCode());
        t.checkExpect(intMap321.hashCode(), intMap321.hashCode());
        
        t.checkExpect(strMapMTComp.hashCode(), strMapMTComp.hashCode());
        t.checkExpect(strMap001Comp.hashCode(), strMap001Comp.hashCode());
    }
    /**
     * Tests the Iterator method
     * @param t - the Tester object
     */
    public void testIterator(Tester t) {
        t.checkExpect(intMapMT.iterator(), new MapIterator<Integer>(alMT));
        t.checkExpect(intMap001.iterator(), new MapIterator<Integer>(al1));
        t.checkExpect(intMap021.iterator(), new MapIterator<Integer>(al2));
        t.checkExpect(intMap321.iterator(), new MapIterator<Integer>(al3));
        
        t.checkExpect(intMap001.iterator().hasNext(), true);
        t.checkExpect(intMap021.iterator().hasNext(), true);
        t.checkExpect(intMap321.iterator().hasNext(), true);
        
        try {
            t.checkExpect(intMap001.iterator().next(), 1);
        }
        catch (Exception e) {
            System.out.println("::intMap001.iterator.next()"
                    + ":::Exception Test Passed:::");
        }
        try {
            intMap001.iterator().remove();
        }
        catch (Exception e) {
            System.out.println("::intMap001.iterator.remove()"
                    + ":::Exception Test Passed:::");
        }
        t.checkExpect(intMap021.iterator().next(), 2);
        t.checkExpect(intMap321.iterator().next(), 3);
        
        t.checkExpect(strMapMTComp.iterator(), 
                new MapIterator<String>(alstrMT));
        t.checkExpect(strMap001Comp.iterator(), 
                new MapIterator<String>(alstr1));
        
    }
    /**
     * Tests the Iterator method with a Comparator
     * @param t - the Tester object
     */
    public void testIteratorWithComparator(Tester t) {
        t.checkExpect(intMapMT.iterator(intComp), 
                new MapIterator<Integer>(alMT));
        t.checkExpect(intMap001.iterator(intComp), 
                new MapIterator<Integer>(al1));
        t.checkExpect(intMap021.iterator(intComp), 
                new MapIterator<Integer>(al2sorted));
        t.checkExpect(intMap321.iterator(intComp), 
                new MapIterator<Integer>(al3sorted));
        
        t.checkExpect(strMapMTComp.iterator(strComp), 
                new MapIterator<String>(alstrMT));
        t.checkExpect(strMap001Comp.iterator(strComp), 
                new MapIterator<String>(alstr1));
    }
    /**
     * Tests the getKeys and addKeys methods
     * @param t - the Tester object
     */
    public void testGetKeys(Tester t) {
        t.checkExpect(intMapMT.getKeys(), alMT);
        t.checkExpect(intMap001.getKeys(), al1);
        t.checkExpect(intMap021.getKeys(), al2);
        t.checkExpect(intMap321.getKeys(), al3);
        
        t.checkExpect(intMap3321.getKeys(), al3);
        
        t.checkExpect(strMapMTComp.getKeys(), alstrMT);
        t.checkExpect(strMap001Comp.getKeys(), alstr1);
    }
}