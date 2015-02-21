/**
 * Simple example test program for StackInt.
 * 
 * @author Schmidt
 * @version cs3500su14 - c02
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
        test.testIsEmpty();
        test.testSize();
        //TODO: Add other tests
        
        //Test multiple times
        test.testIsEmpty();
        test.testSize();
        //TODO: Add other tests

        test.summarize();
    }

    /**
     * Prints a summary of the tests.
     */
    private void summarize() {
        System.out.println();
        System.out.println(totalErrors + " errors found in "
                + totalTests + " tests.");
    }

    /**
     * Empty constructor
     */
    public TestStackInt() {
    }

    private StackInt s0;

    // TODO: Add fields

    /**
     * Creates some StackInt objects
     */
    private void creation() {
        try {
            s0 = StackInt.empty();
            // TODO: Initialize other fields
        }
        catch (Exception e) {
            assertTrue("creation", false);
        }
    }

    /**
     * Tests the isEmpty method
     */
    private void testIsEmpty() {
        try {
            assertTrue("isEmpty:s0", StackInt.isEmpty(s0));

            // TODO: Add other tests
        }
        catch (Exception e) {
            assertTrue("testIsEmpty", false);
        }
    }

    /**
     * Tests the size method
     */
    private void testSize() {
        try {
            assertTrue("size:s0", StackInt.size(s0) == 0);

            // TODO: Add other tests
        }
        catch (Exception e) {
            assertTrue("testSize", false);
        }
    }

    // TODO: Add tests for other methods

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
            System.out.println("***** Test failed ***** " + name
                    + ": " + totalTests);
            totalErrors = totalErrors + 1;
        }
        else {
            System.out.println("----- Test passed ----- " + name
                    + ": " + totalTests);
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
