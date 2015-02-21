package mymap;

//import java.util.Collections;
//import java.util.ArrayList;
import java.util.Comparator;

import tester.*;

/**
 * 
 * @author Nicholas Scheuring nscheu scheuring.n@husky.neu.edu
 * Inside mymap Package
 * @version 3500 Assignment 4 : 1/28/14
 * @param <K>
 * @param <K>
 * 
 */
public class WhiteBox<K> extends Tester {
    /**
     * Constructor for ExamplesMyMap testing class
     */
    public WhiteBox() {
    }
    
    //private Comparator<String> strComp = new StrCompare();
    private Comparator<Integer> intComp = new IntCompare();
    //private Comparator<K> kComp = new KCompare<K>();
    
    public void EmptyNodeTest(Tester t) {
        EmptyNode<Integer, String> en = 
                new EmptyNode<Integer, String>(intComp);
        System.out.println("It's working");
    }
}