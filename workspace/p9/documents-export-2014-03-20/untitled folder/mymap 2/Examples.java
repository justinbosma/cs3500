package mymap;

//import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

import mymap.*;
import tester.*;

/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * Outside mymap Package
 * @version 3500 Assignment 4 : 1/28/14
 * @param <K>
 * @param <K>
 * 
 */
public class Examples<K> extends Tester {
    /**
     * Constructor for ExamplesMyMap testing class
     */
    public Examples() {
        // System.out.println(map2double);
        // Default Constructor
        intarr0.add(1);
        intarr1.add(1);
        
        strarr1.add("1");
        strarr2.add("1");
        strarr2.add("2");
    }

    private Comparator<String> strComp = new StrCompare();
    private Comparator<Integer> intComp = new IntCompare();
    private Comparator<K> kComp = new KCompare<K>();
    private MyMap<Integer, String> rbtree = makeRBTree();

    // ArrayList examples
    private ArrayList<String> strarr1 = new ArrayList<String>();
    private ArrayList<String> strarr2 = new ArrayList<String>();
    private ArrayList<Integer> intarr0 = new ArrayList<Integer>();
    private ArrayList<Integer> intarr1 = new ArrayList<Integer>();
    //private ArrayList<Integer> intarr2 = new ArrayList<Integer>(2);

    /**
     * Initializes a Red Black Trees data
     * 
     * @return rbree - the tree
     */
    public MyMap<Integer, String> makeRBTree() {
        @SuppressWarnings("unchecked")
        MyMap<Integer, String> rbtree1 = MyMap.empty(intComp);
        // System.out.println(rbtree.isEmpty());
        rbtree = rbtree1.include(1, "Alice");
        // System.out.println(rbtree.isEmpty());
        rbtree = rbtree1.include(2, "Bob");
        // System.out.println(rbtree.isEmpty());
        rbtree = rbtree1.include(3, "Carol");
        rbtree = rbtree1.include(4, "Denise");
        rbtree = rbtree1.include(5, "Edward");
        rbtree = rbtree1.include(6, "Fritz");
        rbtree = rbtree1.include(7, "Geoffrey");
        rbtree = rbtree1.include(8, "Harrison");
        rbtree = rbtree1.include(9, "Ismail");
        rbtree = rbtree1.include(10, "Joshua");
        System.out.println(rbtree1);
        return rbtree1;
    }
    /**
     * Test the Empty classes methods
     * 
     * @param t
     *            - the tester object
     */
    @SuppressWarnings("unchecked")
    void testEmptyClass(Tester t) {
        MyMap<Integer, String> emptyMap = MyMap.empty();
        MyMap<Integer, String> inclMap5 = emptyMap.include(5, "five");

        // t.checkExpect(.empty(intComp), emptyMap);
        t.checkExpect(emptyMap.isEmpty(), true);
        t.checkExpect(emptyMap.include(5, "BLARGH"), 
                new Include<Integer, String>(5, "BLARGH", emptyMap));
        t.checkExpect(emptyMap.include(5, "BLARGH"),
                emptyMap.include(5, "BLARGH"));
        t.checkExpect(emptyMap.size(), 0);
        t.checkExpect(emptyMap.containsKey(5), false);
        t.checkExpect(emptyMap.get(5), null);
        t.checkExpect(emptyMap.set(5, "five"), inclMap5);
        t.checkExpect(emptyMap.iterator(), 
                new KeyIterator<Integer>(emptyMap));
        t.checkExpect(emptyMap.iterator(intComp), 
                new KeyIterator<Integer>(emptyMap, intComp));
        t.checkExpect(emptyMap.equals(emptyMap), true);
        t.checkExpect(emptyMap.equals(inclMap5), false);
        t.checkExpect(emptyMap.equals(intComp), false);
        t.checkExpect(emptyMap.hashCode(), 0);
        t.checkExpect(emptyMap.accept(null), emptyMap);

    }

    /**
     * Test the Include classes methods
     * 
     * @param t
     *            - the tester object
     */
    @SuppressWarnings("unchecked")
    void testIncludeClass(Tester t) {
        MyMap<Integer, String> emptyMap = MyMap.empty();
        MyMap<Integer, String> inclMap5 = 
                new Include<Integer, String>(5, "five", emptyMap);
        MyMap<Integer, String> inclnull = 
                new Include<Integer, String>(null, "five", emptyMap);

        t.checkExpect(inclMap5.size(), 1);
        System.out.println("inclMap5 is size=" + inclMap5);
        t.checkExpect(inclMap5.containsKey(5), true);
        t.checkExpect(inclMap5.containsKey(99), false);
        t.checkExpect(inclMap5.get(5), "five");
        t.checkExpect(inclMap5.get(99), null);
        t.checkExpect(inclMap5.set(4, "set"), inclMap5.include(4, "set"));
        t.checkExpect(inclMap5.set(5, "set"), 
                new Include<Integer, String>(5, "set", emptyMap));
        t.checkExpect(inclMap5.iterator(), 
                new KeyIterator<Integer>(inclMap5));
        t.checkExpect(inclMap5.iterator(intComp), 
                new KeyIterator<Integer>(inclMap5, intComp));
        t.checkExpect(inclMap5.equals(intComp), false);
        t.checkExpect(inclMap5.equals(inclMap5), true);
        t.checkExpect(inclnull.equals(inclnull), false);
        t.checkExpect(inclMap5.hashCode() == emptyMap.hashCode(), false);
        t.checkExpect(inclMap5.hashCode() == inclMap5.hashCode(), true);

    }

    /**
     * Test the EmptyNode classes methods
     * 
     * @param t
     *            - the tester object
     */
    @SuppressWarnings("unchecked")
    void testEmptyNodeClass(Tester t) {
        MyMap<Integer, String> emptyNode = MyMap.empty(intComp);
        MyMap<String, String> emptyNodestr = MyMap.empty(strComp);
        KeyIterator<Integer> it = new KeyIterator<Integer>(emptyNode, intComp);
        KeyIterator<String> itstr = new KeyIterator<String>(emptyNodestr,
                strComp);

        KeyIterator<Integer> kit = new KeyIterator<Integer>(emptyNode);

        while (kit.hasNext()) {
            System.out.println(kit.next());
        }
        KeyIterator<String> lit = new KeyIterator<String>(emptyNodestr);
        while (lit.hasNext()) {
            System.out.println(lit.next());
        }
        t.checkExpect(emptyNodestr.iterator(), new 
                KeyIterator<String>(emptyNodestr));
        // t.checkExpect(mapMT.iterator(null), new 
        //       KeyIterator<String>(mapMT));

        t.checkExpect(emptyNodestr.include("one", "ones") 
                instanceof MyMap, true);
        t.checkExpect(!(emptyNodestr.include("one", "ones") 
                instanceof MyMap), false);
        t.checkExpect(emptyNode.include(1, "unos") instanceof MyMap, true);
        t.checkExpect(!(emptyNode.include(1, "unos") instanceof MyMap), false);

        t.checkExpect(emptyNode instanceof MyMap, true);
        t.checkExpect(emptyNodestr instanceof MyMap, true);
        // t.checkExpect(!(MyMap.empty() instanceof MyMap), false);
        t.checkExpect(!(emptyNode instanceof MyMap), false);
        t.checkExpect(!(emptyNodestr instanceof MyMap), false);
        t.checkExpect(emptyNode.isEmpty(), true);
        t.checkExpect(emptyNodestr.isEmpty(), true);
        t.checkExpect(!emptyNode.isEmpty(), false);
        t.checkExpect(emptyNode.size(), 0);
        t.checkExpect(emptyNodestr.size(), 0);
        t.checkExpect(emptyNode.containsKey(1), false);
        t.checkExpect(emptyNodestr.containsKey("1"), false);
        try {
            t.checkExpect(emptyNode.get(1), "uno");
        }
        catch (Exception e) {
            System.out
                    .println("an exception was correctly thrown "
                            + "in Node- get()");
        }
        
        t.checkExpect(emptyNodestr.include("4", "four").set("2", "two"),
                emptyNodestr.include("2", "two").include("4", "four"));
        t.checkExpect(emptyNodestr.include("4", "four").set("6", "two"),
                emptyNodestr.include("6", "two").include("4", "four"));
        t.checkExpect(emptyNodestr.toString(),
                "{...(0 key(s) mapped to value(s))...}");
        t.checkExpect(emptyNodestr.equals(null), false);
        t.checkExpect(emptyNodestr.equals(emptyNodestr), true);
        t.checkExpect(emptyNodestr.hashCode(), 37);

        t.checkExpect(emptyNode.iterator(intComp), it);
        t.checkExpect(emptyNodestr.iterator(strComp), itstr);
        t.checkExpect(emptyNode.accept(null), emptyNode);
    }

    /**
     * Test the Node classes methods
     * 
     * @param t
     *            - the tester object
     */
    @SuppressWarnings("unchecked")
    void testNodeClass(Tester t) {
        MyMap<Integer, String> emptyNode = MyMap.empty(intComp);
        MyMap<String, String> emptyNodestr = MyMap.empty(strComp);
        MyMap<String, String> emptyNodeK = MyMap.empty(kComp);
        MyMap<Object, String> emptynull = MyMap.empty(null);
        
        MyMap<Integer, String> catNode = new Node<Integer, String>
        (4, "Dave", emptyNode, emptyNode, intComp, false);
        MyMap<Integer, String> catNodeOrd = catNode.include(3, "Carol");
        MyMap<Integer, String> catNodeTest1 = new Node<Integer, String>
        (1, "Alice", emptyNode, emptyNode, intComp, false);
        catNodeTest1 = catNodeTest1.include(2, "Bob");
        catNodeOrd = catNode.include(2, "Bob");
        catNodeOrd = catNode.include(1, "Alice");
        
        MyMap<Integer, String> catNodeUn = new Node<Integer, String>
        (3, "Carol", emptyNode, emptyNode, intComp, false);
        MyMap<Integer, String> catNodeUnOrd = catNodeUn.include(4, "Dave");
        catNodeUnOrd = catNodeUn.include(2, "Bob");
        catNodeUnOrd = catNodeUn.include(1, "Alice");
        
        MyMap<Integer, String> catNodeDub = new Node<Integer, String>
        (1, "Alice", emptyNode, emptyNode, intComp, false);
        catNodeDub = catNodeDub.include(2, "Bob");
        catNodeDub = catNodeDub.include(2, "dave");
        catNodeDub = catNodeDub.include(1, "dave");
        
        Node<Integer, String> node = new Node<Integer, String>(5, "five",
                emptyNode, emptyNode, intComp, false);
        
        MyMap<Integer, String> node1 = 
                new Node<Integer, String>(1, "one", 
                        emptyNode, emptyNode, intComp, false);
        node1 = node1.include(2, "two");
        node1 = node1.include(3, "three");
        node1 = node1.include(4, "four");
        node1 = node1.include(2, "xtra1");
        node1 = node1.include(2, "xtra2");
        //System.out.println(node1);
        MyMap<String, String> map1 = emptyNodestr.include("1", "one");
        MyMap<String, String> map2 = map1.include("2", "two");
        MyMap<String, String> map22 = map1.include("2", "two");
        MyMap<String, String> mapdouble = map2.include("2", "bob");
        MyMap<String, String> map2double = mapdouble.include("2", "frida");
        MyMap<String, String> map3 = map2.include("3", "three");
        MyMap<Object, String> nodenull = new Node<Object, String>(null,
                "nullset", emptynull, emptynull, null, false);
        
        MyMap<Integer, String> map00 = (MyMap<Integer, String>) MyMap
                .empty(intComp);
        MyMap<Integer, String> map01 = map00.include(1, "uno");
        MyMap<Integer, String> map02 = map01.include(2, "dos");
        MyMap<Integer, String> map002 = map00.include(2, "dos");
        // t.checkExpect(map2.equals(null), false);
        t.checkExpect(map2.equals(map22), true);

        t.checkExpect(nodenull.equals(node1), false);
        t.checkExpect(node1.equals(emptyNode), false);
        t.checkExpect(node1.equals(node1), true);
        t.checkExpect(node1.equals(null), false);
        t.checkExpect(node.equals(node1), false);
        t.checkExpect(map1.equals(map1), true);
        t.checkExpect(map1.equals(null), false);
        t.checkExpect(map1.equals(map2), false);
        t.checkExpect(emptyNodeK.equals(emptyNodeK), true);
        t.checkExpect(map1.size(), 1);
        t.checkExpect(map2.size(), 2);
        t.checkExpect(map3.size(), 3);
        t.checkExpect(emptyNodeK.size(), 0);
        t.checkExpect(mapdouble.size(), 2);
        t.checkExpect(map2double.size(), 2);
        t.checkExpect(node1.size(), 4);
        System.out.println("node1 size check = " + node1);
        t.checkExpect(map1.isEmpty(), false);
        t.checkExpect(!map1.isEmpty(), true);
        t.checkExpect(map1.containsKey("1"), true);
        t.checkExpect(map2.containsKey("1"), true);
        t.checkExpect(map3.containsKey("1"), true);
        t.checkExpect(map1.containsKey("9"), false);
        t.checkExpect(map2.containsKey("2"), true);
        t.checkExpect(map2.containsKey("9"), false);
        t.checkExpect(map3.containsKey("2"), true);
        t.checkExpect(map3.containsKey("3"), true);
        t.checkExpect(map3.containsKey("9"), false);

        //t.checkExpect(map1.hashCode(), 5400807);
        t.checkExpect(catNodeOrd.hashCode() 
                == catNodeUnOrd.hashCode(), false);
        t.checkExpect(catNodeOrd.hashCode(), catNodeOrd.hashCode());
        t.checkExpect(rbtree.hashCode(), 37);
        System.out.println(catNodeDub + "catNodeDub ::");
        //t.checkExpect(catNodeDub.hashCode(), 66428146);
        t.checkExpect(catNodeDub.hashCode() ==
                catNodeDub.hashCode(), true);
        t.checkExpect(catNodeDub.hashCode() ==
                catNodeOrd.hashCode(), false);
        t.checkExpect(catNodeTest1.hashCode() ==
                catNodeDub.hashCode(), false);
        
        t.checkExpect(map1.get("1"), "one");
        // t.checkExpect(map1.get("2"), null);
        t.checkExpect(map2.get("2"), "two");
        t.checkExpect(map2.get("1"), "one");
        t.checkExpect(map3.get("1"), "one");
        t.checkExpect(map3.get("2"), "two");
        t.checkExpect(map3.get("3"), "three");
        t.checkExpect(map02.get(2), "dos");
        t.checkExpect(map02.get(1), "uno");
        t.checkExpect(node1.get(2), "xtra2");
        try {
            t.checkExpect(map002.get(1), "dos");
        }
        catch (Exception e) {
            System.out
                    .println("an exception was correctly thrown "
                            + "in Node- get()");
        }
        t.checkExpect(map1.toString(), "{...(1 key(s) mapped to value(s))...}");
        t.checkExpect(mapdouble.toString(),
                "{...(2 key(s) mapped to value(s))...}");
        rbtree.toString();
        /*
         * try { t.checkExpect(node.get(3), emptyNode); } catch(Exception e) {
         * throw new UnsupportedOperationException(
         * "caught get exception in Node"); }
         */
        
        
        t.checkExpect(nodenull.equals(nodenull), false);
        // t.checkExpect(node1.equals(node1), true);

        //KeyIterator<String> mit = new KeyIterator<String>(map2);
        /*
         * while (mit.hasNext()) { System.out.println(mit.next()); }
         * KeyIterator<Integer> nit = new KeyIterator<Integer>(map02, intComp);
         * while (nit.hasNext()) { System.out.println(nit.next()); }
         * KeyIterator<Integer> oit = new KeyIterator<Integer>(map00, intComp);
         * while (oit.hasNext()) { System.out.println(oit.next()); } try {
         * nit.remove(); } catch (Exception e) {
         * System.out.println("an exception was correctly thrown in remove"); }
         */

        t.checkExpect(map1.iterator(), new KeyIterator<String>(strarr1));
        t.checkExpect(map1.iterator(strComp), 
                new KeyIterator<String>(map1, strComp));
        // t.checkExpect(map2.iterator(), new KeyIterator<String>(map2));
        t.checkExpect(map2.iterator().hasNext(), "2");
        t.checkExpect(map2.iterator().next(), "2");
        t.checkExpect(map00.include(4, "four").isEmpty(), false);
        t.checkExpect(MyMap.empty(strComp).size(), 0);
        // t.checkExpect(map01.include(1, "f").size(), map01.size());
        t.checkExpect(map00.include(4, "f").size(), 1 + map00.size());
        t.checkExpect(MyMap.empty(intComp).containsKey(99), false);
        t.checkExpect(map01.include(2, "f").containsKey(2), true);
        t.checkExpect(map00.include(1, "f").containsKey(99),
                map00.containsKey(99));
        t.checkExpect(map00.include(2, "f").get(2), "f");
        t.checkExpect(MyMap.empty(intComp).set(1, "f"), MyMap.empty(intComp)
                .include(1, "f"));
        t.checkExpect(map00.include(1, "f").set(1, "g"), map00.include(1, "g"));
        t.checkExpect(map00.include(1, "f").set(4, "g"), map00.set(4, "g")
                .include(1, "f"));
        t.checkExpect(emptyNode.accept(null), emptyNode);

    }
    /**
     * Test the MyMap classes methods
     * @param t - the tester object
     */
    @SuppressWarnings("unchecked")
    void testMyMapClass(Tester t) {
        MyMap<Integer, String> emptyNode = MyMap.empty(intComp);
        
        t.checkExpect(emptyNode.isEmpty(emptyNode), true);
        t.checkExpect(emptyNode.size(emptyNode), 0);
        t.checkExpect(emptyNode.containsKey(emptyNode, 1), false);
        try {
            t.checkExpect(emptyNode.get(emptyNode, 1), true);
        }
        catch (Exception e) {
            System.out.println(
                    "MyMap.get() test - Exception handled correctly");
        }
        t.checkExpect(emptyNode.set(emptyNode,  2, "val"), 
                emptyNode.include(2, "val"));
        t.checkExpect(emptyNode.iterator(emptyNode), 
                new KeyIterator<Integer>(emptyNode));
        t.checkExpect(emptyNode.iterator(emptyNode, intComp), 
                new KeyIterator<Integer>(emptyNode, intComp));
    }
    /**
     * Test the KCompare classes methods
     * 
     * @param t
     *            - the tester object
     */
    void testKCompareClass(Tester t) {
        //String s = "wow";
        //K key = (K) s;
        //t.checkExpect(key.compare(key));
    }
    /**
     * Test the KeyIterator classes methods
     * @param t - the tester object
     */
    @SuppressWarnings("unchecked")
    void testKeyIteratorClass(Tester t) {
        //KeyIterator<Integer> it = 
          //      new KeyIterator<Integer>(rbtree, intComp);
        MyMap<Integer, String> emptyNode = MyMap.empty(intComp);
        KeyIterator<Integer> it1 = 
                new KeyIterator<Integer>(emptyNode, intComp);
        
        //t.checkExpect(it.next(), 10);
        try {
            it1.next();
        }
        catch (Exception e) {
            System.out.println("KeyIterator - no next");
        }
        try {
            it1.remove();
        }
        catch (Exception e) {
            System.out.println("KeyIterator - no remove");
        }
    }
    
    /**
     * Test the GCD Class
     * @param t - the Tester
     */
    void testGCDClass(Tester t) {
        //GCD test = new GCD();
        //t.checkExpect(test.visit(25, 20), 5);
    }
}