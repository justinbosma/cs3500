import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import kvmap.BST;
import kvmap.IntCompare;
import kvmap.KVMap;
import tester.Tester;
/**
 * 
 * 
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version Jun 3, 2014
 */
public class ExamplesSA8BBTests {
    private Comparator<Integer> intComp = new IntCompare();
    private KVMap<Integer, Integer> assignMapMT = KVMap.emptyMap();
    private KVMap<Integer, Integer> assignMap1 = KVMap.emptyMap();
    private KVMap<Integer, Integer> intBSTmt = KVMap.emptyMap(intComp);
    private KVMap<Integer, String> intstrBSTmt = KVMap.emptyMap(intComp);
    private BST<Integer, Integer> rbtree = 
            (BST<Integer, Integer>) intBSTmt.assign(10, 10);
    private BST<Integer, Integer> rbtreegcd = 
            (BST<Integer, Integer>) intBSTmt.assign(10, 5);
    private BST<Integer, Integer> rbtreegcd1 = 
            (BST<Integer, Integer>) intBSTmt.assign(10, 5);
    private BST<Integer, String> swntree = 
            (BST<Integer, String>) intstrBSTmt.assign(10, "100");
    private BST<Integer, String> swntreeswn = 
            (BST<Integer, String>) intstrBSTmt.assign(10, "100 10");
    
    /**
     * Constructor for Black Box Tests
     */
    public ExamplesSA8BBTests() {
        
        rbtree = rbtree.assign(5, 5);
        rbtree = rbtree.assign(4, 4);
        rbtree = rbtree.assign(2, 2);
        rbtree = rbtree.assign(3, 3);
        rbtree = rbtree.assign(15, 15);
        rbtree = rbtree.assign(20, 20);
        rbtree = rbtree.assign(25, 25);
        rbtree = rbtree.assign(22, 22);
        assignMap1.assign(44, 44);
        
    }
    /**
     * tests the Visitor Classes
     * @param t the Tester Object
     */
    public void testVisitorClasses(Tester t) {
        BlackHeight<Integer, Integer> bh = 
                new BlackHeight<Integer, Integer>();
        GCD gcd = new GCD();
        StringWithNumber swn = new StringWithNumber();
        PathLengths<Integer, Integer> pL = new PathLengths<Integer, Integer>();
        ArrayList<Integer> alLengths = 
                new ArrayList<Integer>(
                        Arrays.asList(4, 4, 4, 4, 3, 3, 3, 3, 3, 3));
        
        
        t.checkExpect(assignMapMT.isEmpty(), true);
        t.checkExpect(intBSTmt.accept(gcd), intBSTmt);
        t.checkExpect(rbtree.accept(gcd), rbtree);
        t.checkExpect(rbtreegcd.accept(gcd), rbtreegcd1);
        t.checkExpect(gcd.visit(99, 33), 33);
        t.checkExpect(gcd.visit(189, 33), 3);
        t.checkExpect(assignMap1.accept(gcd), assignMap1);
        t.checkExpect(assignMap1.accept(null), assignMap1);
        
        t.checkExpect(swn.visit(3, "v"), "v 3");
        t.checkExpect(swntree.accept(swn), swntreeswn);
        
        
        t.checkExpect(intBSTmt.acceptRBT(bh), 0);
        t.checkExpect(rbtree.acceptRBT(bh), 3);
        t.checkExpect(bh.visitEmpty(intComp, "BLACK"), 0);
        
        t.checkExpect(rbtree.acceptRBT(pL), alLengths);
    }
}