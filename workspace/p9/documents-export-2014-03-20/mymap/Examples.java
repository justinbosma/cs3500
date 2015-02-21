package mymap;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

//import tester.Tester;
/**
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * @version 3500 Assignment 9 : 3/21/14 Testing Suite - White Box for mymap
 *          package
 */
public class Examples {
    private Comparator<Integer> intComp = new IntCompare();
    private EmptyNode<Integer, String> emptyNode = 
            new EmptyNode<Integer, String>(
            intComp);
    private Node<Integer, String> node = new Node(99, "vals", emptyNode,
            emptyNode, intComp, false);
    @SuppressWarnings("rawtypes")
    private ArrayList array1 = new ArrayList();
    private ArrayList arrayDub = new ArrayList();
    private Empty<Integer, String> empty = new Empty<Integer, String>();
    private Include<Integer, String> include = new Include<Integer, String>(5,
            "bob", empty);

    private MyMap<Integer, String> includeDub = include.include(5, "bobs");

    /**
     * Tests the Empty class methods
     */
    @Test
    public void testEmpty() {
        assertTrue(empty.getAllKeys().equals(array1));
        assertSame(empty.hashHelp(999), 0);
    }

    /**
     * Tests the Include class methods
     */
    @Test
    public void testInclude() {
        assertSame(includeDub.sizeHelp(5, 5), 1);
        assertTrue(includeDub.equals(includeDub));
        assertFalse(includeDub.equals(include));
        assertFalse(includeDub.equals(null));
        assertTrue(includeDub.containsAllKeys(includeDub, includeDub));
        assertTrue(includeDub.checkKeys(includeDub, includeDub));
        assertFalse(includeDub.checkKeys(includeDub, include));
        // System.out.println(includeDub.getKeys(array1));
        assertTrue(includeDub.getKeys(arrayDub).equals(arrayDub));
        System.out.println(includeDub.getKeys(arrayDub));
        assertTrue(includeDub.accept(null).equals(includeDub));
        assertSame(includeDub.hashHelp(999), 0);
    }

    /**
     * Tests the KCompare class methods
     */
    /*@Test
    public void testKCompare() {
        // empty for further testing
    }*/

    /**
     * Tests the MyMap class methods
     */
    /*@Test
    public void testMyMap() {
        // assertTrue(.get(empty, 3).equals(null));
        // empty for further testing
    }*/

    /**
     * Tests the Node class methods
     */
    @Test
    public void testNode() {
        MyMap map = makeRBTree(emptyNode);
        Node no = (Node) map;

        System.out.println("node.hashHelper() = :" + node.hashHelper());
        assertEquals(node.hashHelper(), 3612018);
        System.out.println("no.hashHelper() = :" + no.hashHelper());
        assertEquals(no.hashHelper(), -1068384299);

        System.out.println("node.hashHelp(99) = :" + node.hashHelp(99));
        assertEquals(node.hashHelp(99), 1);
        System.out.println("no.hashHelp(99) = :" + no.hashHelp(99));
        assertEquals(no.hashHelp(99), 25);
        System.out.println(map);

        assertTrue(no.containsAllKeys(no, no));
        assertFalse(no.containsAllKeys(node, no));

        assertTrue(no.checkKeys(no, no));
        assertFalse(no.checkKeys(node, no));
        // null pointer exception v---
        // assertFalse(no.checkKeys(include, no));
        assertFalse(no.checkKeys(no, emptyNode));
        System.out.println("no.getKey: " + no.getKey());
        assertEquals(no.getKey(), 24);
        System.out.println("no.getValue: " + no.getValue());
        assertEquals(no.getValue(), "more..");
        assertTrue(no.reOrder(no).equals(no));
    }

    /**
     * creates a Red Black Tree for examples
     * @param m - a myMap
     * @return a red black tree
     */
    public MyMap makeRBTree(MyMap<Integer, String> m) {
        for (int i = 0; i < 25; i++) {
            m = m.include(i, "more..");
        }
        return m;
    }

    /**
     * Tests the EmptyNode class methods and calls other methods to test proper
     * Exception handling in EmptyNode class
     */
    @Test
    public void testEmptyNode() {
        assertTrue(emptyNode.getAllKeys().equals(array1));
        assertTrue(emptyNode.getKeys(array1).equals(array1));
        System.out.println("testEmptyNode runs");
        testENgetKey();
        testENgetValue();
        testENgetLeftMap();
        testENgetRightMap();
        testENredll();
        testENredlr();
        testENredrl();
        testENredrr();
        assertEquals(emptyNode.hashHelp(999), 0);

    }

    /**
     * Tests proper Exception handling in EmptyNode class
     */
    public void testENgetKey() {
        boolean thrown = false;
        try {
            emptyNode.getKey();
        } 
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        // System.out.println(thrown);
    }

    /**
     * Tests proper Exception handling in EmptyNode class
     */
    public void testENgetValue() {
        boolean thrown = false;
        try {
            emptyNode.getValue();
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        // System.out.println(thrown);
    }

    /**
     * Tests proper Exception handling in EmptyNode class
     */
    public void testENgetLeftMap() {
        boolean thrown = false;
        try {
            emptyNode.getLeftMap();
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        // System.out.println(thrown);
    }

    /**
     * Tests proper Exception handling in EmptyNode class
     */
    public void testENgetRightMap() {
        boolean thrown = false;
        try {
            emptyNode.getRightMap();
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        // System.out.println(thrown);
    }

    /**
     * Tests proper Exception handling in EmptyNode class
     */
    public void testENredll() {
        boolean thrown = false;
        try {
            emptyNode.redll(null);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        // System.out.println(thrown);
    }

    /**
     * Tests proper Exception handling in EmptyNode class
     */
    public void testENredlr() {
        boolean thrown = false;
        try {
            emptyNode.redlr(null);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        // System.out.println(thrown);
    }

    /**
     * Tests proper Exception handling in EmptyNode class
     */
    public void testENredrl() {
        boolean thrown = false;
        try {
            emptyNode.redrl(null);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        // System.out.println(thrown);
    }

    /**
     * Tests proper Exception handling in EmptyNode class
     */
    public void testENredrr() {
        boolean thrown = false;
        try {
            emptyNode.redrr(null);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        // System.out.println(thrown);
    }

}
