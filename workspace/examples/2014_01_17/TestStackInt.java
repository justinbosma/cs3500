package c04;

/**
 * Simple example test program for StackInt.
 * 
 * @author Schmidt
 * @version 2014-01-08
 */
public class TestStackInt {

    /**
     * Runs the tests.
     * 
     * @param args
     *            the command line arguments
     */
    public static void main(String args[]) {
        TestStackInt test = new TestStackInt();
        test.creation();
        test.accessors();
        test.usual();
        test.summarize();
    }

    /**
     * Prints a summary of the tests.
     */
    private void summarize() {
        System.out.println();
        System.out.println(totalErrors + " errors found in " + totalTests
                + " tests.");
    }

    /**
     * Empty constructor
     */
    public TestStackInt() {
    }

    private StackInt s0;
    private StackInt s1;
    private StackInt s2;
    private StackInt s3;
    private StackInt s4;
    private StackInt s5;
    private StackInt s6;

    /**
     * Creates some StackInt objects
     */
    private void creation() {
        try {
            s0 = StackInt.empty();
            s1 = StackInt.push(s0, 1);
            s2 = StackInt.push(s1, 2);
            s3 = StackInt.push(s2, 3);
            s4 = StackInt.push(s0, 4);
            s5 = StackInt.push(s2, 5);
            s6 = StackInt.push(s5, 6);
        }
        catch (Exception e) {
            assertTrue("creation", false);
        }
    }

    /**
     * Tests the accessors.
     */
    private void accessors() {
        try {
            assertTrue("isEmpty:s0", StackInt.isEmpty(s0));
            assertFalse("isEmpty:s1", StackInt.isEmpty(s1));

            assertTrue("top:s1", StackInt.top(s1) == 1);
            assertTrue("pop:s1", StackInt.isEmpty(StackInt.pop(s1)));

            assertTrue("size:s0", StackInt.size(s0) == 0);
            assertTrue("size:s1", StackInt.size(s1) == 1);
            assertTrue("size:s4", StackInt.size(s4) == 1);
            assertTrue("size:s6", StackInt.size(s6) == 4);
            assertTrue("size:s5", StackInt.size(StackInt.pop(s6)) == 3);

            // This isn't really a test, just an example.

            StackInt s = s6;
            while (!StackInt.isEmpty(s)) {
                System.out.println(StackInt.top(s));
                s = StackInt.pop(s);
            }
            System.out.println();
            s = s6;
            while (!StackInt.isEmpty(s)) {
                System.out.println(StackInt.top(s));
                s = StackInt.pop(s);
            }
        }
        catch (Exception e) {
            assertTrue("accessors", false);
        }
    }

    /**
     * Tests the usual methods from Object.
     */
    private void usual() {
        // test usual methods from Object: toString, equals, hashCode
    }

    private int totalTests = 0; // tests run so far
    private int totalErrors = 0; // errors so far

    /**
     * Prints failure report if the result is not true.
     * 
     * @param name
     *            the name of the test
     * @param result
     *            the result to test
     */
    private void assertTrue(String name, boolean result) {
        if (!result) {
            System.out.println();
            System.out.println("***** Test failed ***** " + name + ": "
                    + totalTests);
            totalErrors = totalErrors + 1;
        }
        else {
            System.out.println("----- Test passed ----- " + name + ": "
                    + totalTests);
        }
        totalTests = totalTests + 1;
    }

    /**
     * Prints failure report if the result is not false.
     * 
     * @param name
     *            the name of the test
     * @param result
     *            the result to test
     */
    private void assertFalse(String name, boolean result) {
        assertTrue(name, !result);
    }

}
