import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import kvmap.KVMap;
import kvmap.Node;
/**
 * Timing Tester - Assignment 6 - Summer 2014
 * Testing harness to test timing of operations on BST implementation
 * from assignment 5.
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 23, 2014
 */
public class A06TimingTester {
    
    private static final String plato = "Apology_Plato.txt";
    private static final String conf = "Confucius_The_Great_Learning.txt";
    private static final String cont = "contains_list.txt";
    private static final String hippo = "hippooath.txt";
    private static final String lex = "lexicographically_ordered.txt";
    private static final String random = "random_order.txt";
    private static final String reverse = "reverse_ordered.txt";
    /**
     * Main Method for Timing Tester Class
     * @param args
     */
    public static void main(String[] args) {
        String[] testList = new String[] 
                {random, reverse, lex};
        String[] testLit = new String[] 
                {plato, conf, hippo};
        String[] listFileNames = new String[] 
                {"Random Order", "Reverse Order", "Lexicographically Ordered"};
        String[] litFileNames = new String[] 
                {"Plato", "Confucious", "Hippocratic Oath"};
        KVMap<String, Integer> maplist = KVMap.emptyMap();
        KVMap<String, Integer> bstSBLex = KVMap.emptyMap(new StringByLex());
        KVMap<String, Integer> bstRBLex = KVMap.emptyMap(new StringReverseByLex());
        @SuppressWarnings("rawtypes")
        KVMap[] maps = new KVMap[] {maplist, bstSBLex, bstRBLex};
        System.out.println(file2map(bstSBLex, reverse).toString());
        System.out.println(bstSBLex instanceof KVMap);
        
        System.out.println(TimingTest(maps, testList, listFileNames));
        //System.out.println(TimingTest(maps, testLit, litFileNames));
        
//        long start = 0;
//        long end = 0;
        
//        for (String s: testList) {
//            start = getTime();
//            count(file2map(maplist, s));
            //System.out.println(count(file2map(maplist, s)));
            //System.out.println(file2map(maplist, s));
            //System.out.println(file2map(bstSBLex, s));
            //System.out.println(file2map(bstRBLex, s));
//            end = getTime();
//            System.out.println("Start @ ::" + start);
//            System.out.println("End @ ::" + end);
//            System.out.println("Total Time = ::" + timeDiff(start, end));
//        }
        
    }
    public static String TimingTest (KVMap[] maps, String[] files, String[] fileNames) {
        String result = "";
        long startTime = 0;
        long endTime = 0;
        String[] testName = new String[] 
                {"Building A Map", "Creating an Iterator", "Iteration", "Map Contians"};
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                startTime = getTime();
                System.out.println("Start :" + i + "::" + startTime);
                file2map(maps[i], files[j]);
                endTime = getTime();
                System.out.println("End :" + endTime);
                System.out.println("Difference :" + timeDiff(startTime, endTime));
                
                result = result + "\nTest File #: " + i + ": file:" + fileNames[i] +
                        "\nStart Time Test #" + j + ":" + startTime +
                        "\nEnd Time Test #: " + j + ":" + endTime +
                        "\nTime Difference : " + timeDiff(startTime, endTime) + "\n";
            }
        }
        return result;
    }
    public static boolean count(KVMap<String, Integer> mm) {
        int countContainsTrue = 0;
        int countContains = 0;
        StringIterator si = new StringIterator("contains_list.txt");
        for (String s : si) {
            if (mm.containsKey(s)) {
                countContainsTrue++;
                }
            countContains++;
            }
        //System.out.println("maplist::containsTrue:" + countContainsTrue);
        //System.out.println("maplist::contains:" + countContains);
        return countContainsTrue == countContains;
    }
    /** 
     * Adds the files data into a map/bst
     * @param mm - the map
     * @param filename - the file to be read
     * @return - the map/bst
     */
    public static KVMap<String, Integer> 
    file2map(KVMap<String, Integer> mm, String filename) {
        Iterator<String> sit = new StringIterator(filename);
        int count = 0;
        while (sit.hasNext()) {
           count++;
           mm = mm.assign(sit.next(), count);
        }
        return mm;
    }
    /**
     * Gets the current system time
     * @return a long representation of system time
     */
    public static long getTime() {
        long time = System.currentTimeMillis();
        return time;
    }
    /**
     * Caclulates the total time from start to finish
     * @param t1 - start time
     * @param t2 - end time
     * @return end time - start time = total time
     */
    public static long timeDiff(long t1, long t2) {
        return t2 - t1;
    }
}