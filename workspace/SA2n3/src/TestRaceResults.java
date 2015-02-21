/**
 * Black Box Tests for the RaceResults ADT
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 7, 2014
 */
public class TestRaceResults {
    /**
     * Main Method for Black Box Test
     * @param args - Command-line arguments
     */
    public static void main(String[] args) {
        TestRaceResults test = new TestRaceResults();
        test.creation();
        test.testEmptyResults();
        test.testAddRunner();
        //Test multiple times
        test.testEmptyResults();
        test.testAddRunner();
        test.summarize();
    }
    /**
     * Empty Constructor for TestRaceResults class
     */
    public TestRaceResults() {
        //empty constructor
    }
    private RaceResults mtRace;
    private RaceResults oneRace;
    private RaceResults twoRace;
    private RaceResults twoRaceOutOfOrder;
    private RaceResults soloRace;
    private RaceResults soloRaceSet;
    private RaceResults twoRaceSet;
    private String x;
    /**
     * Creates some RaceResults objects
     */
    private void creation() {
        try {
            mtRace = RaceResults.emptyResults();
            oneRace = RaceResults.addRunner(mtRace, 999);
            oneRace = RaceResults.addRunner(oneRace, 888);
            oneRace = RaceResults.addRunner(oneRace, 777);
            twoRace = RaceResults.addRunner(oneRace, 666);
            twoRaceOutOfOrder = RaceResults.addRunner(mtRace,  777);
            twoRaceOutOfOrder = RaceResults.addRunner(twoRaceOutOfOrder, 888);
            twoRaceOutOfOrder = RaceResults.addRunner(twoRaceOutOfOrder, 666);
            twoRaceOutOfOrder = RaceResults.addRunner(twoRaceOutOfOrder, 999);
            soloRace = RaceResults.addRunner(mtRace, 1);
            soloRaceSet = RaceResults.addRunner(mtRace, 9);
            twoRaceSet = RaceResults.addRunner(mtRace, 347);
            twoRaceSet = RaceResults.addRunner(twoRaceSet, 888);
            twoRaceSet = RaceResults.addRunner(twoRaceSet, 777);
            twoRaceSet = RaceResults.addRunner(twoRaceSet, 666);
        }
        catch (Exception e) {
            assertTrue("creation", false);
        }
    }
    /**
     * Prints a summary of the tests.
     */
    private void summarize() {
        System.out.println();
        System.out.println(totalErrors + " errors found in "
                + totalTests + " tests.");
    }

    private int totalTests = 0; // tests run so far
    private int totalErrors = 0; // errors so far
    
    /**
     * Tests the EmptyResults class
     */
    private void testEmptyResults() {
        try {
            assertTrue("noFinishers:mtRace", 
                    RaceResults.noFinishers(mtRace));
            
            assertTrue("numRunners:mtRace", 
                    RaceResults.numRunners(mtRace) == 0);
            
            assertFalse("finishRace:mtRace", 
                    RaceResults.finishRace(mtRace, 9));
            
            assertTrue("toString:mtRace", 
                    RaceResults.emptyResults().toString().equals("[]"));
            
            assertFalse("equals:mtRace::null", mtRace.equals(null));
            assertTrue("equals:mtRace::mtRace", mtRace.equals(mtRace));
            assertFalse("equals:mtRace::String x", mtRace.equals(x));
            
            assertTrue("hashCode::mtRace::mtRace", 
                    mtRace.hashCode() == mtRace.hashCode());
            assertTrue("hashCode::mtRace::mtRace", 
                    mtRace.hashCode() != oneRace.hashCode());
        }
        catch (Exception e) {
            assertTrue("testEmptyResults", false);
        }
    }
    /**
     * Tests the AddRunner Class
     */
    private void testAddRunner() {
        try {
            assertFalse("noFinishers:oneRace", 
                    RaceResults.noFinishers(oneRace));
            
            assertTrue("getPlace:oneRace", 
                    RaceResults.getPlace(oneRace, 2) == 888);
            assertTrue("getPlace:oneRace", 
                    RaceResults.getPlace(oneRace, 1) == 777);
            
            assertTrue("setPlace::soloRace", 
                    RaceResults.setPlace(soloRace, 1, 9).equals(soloRaceSet));
            assertTrue("setPlace::twoRace", 
                    RaceResults.setPlace(twoRace, 4, 347).toString()
                    .equals(twoRaceSet.toString()));
            
            assertTrue("numRunners:oneRace", 
                    RaceResults.numRunners(oneRace) == 3);
            assertTrue("numRunners:soloRace", 
                    RaceResults.numRunners(soloRace) == 1);
            
            assertFalse("finishRace:oneRace",
                    RaceResults.finishRace(oneRace, 2));
            assertTrue("finishRace:soloRace",
                    RaceResults.finishRace(
                            RaceResults.addRunner(mtRace, 1), 1));
            assertFalse("finishRace:soloRace",
                    RaceResults.finishRace(
                            RaceResults.addRunner(mtRace, 1), 2));
            
            assertTrue("toString:oneRace", 
                    oneRace.toString().equals("[777, 888, 999]"));
            assertTrue("toString:noFinishers",
                    RaceResults.addRunner(mtRace, 1).toString().equals("[1]"));
            
            assertTrue("Equals:oneRace::oneRace", oneRace.equals(oneRace));
            assertFalse("Equals:oneRace::mtRace", oneRace.equals(mtRace));
            assertFalse("Equals:oneRace::x", oneRace.equals(x));
            assertFalse("Equals:oneRace::null", oneRace.equals(null));
            assertFalse("Equals:twoRace::twoRaceOutOfOrder", 
                    twoRace.equals(twoRaceOutOfOrder));
            
            assertTrue("hashCode:oneRace::oneRace", 
                    oneRace.hashCode() == oneRace.hashCode());
            assertTrue("hashCode:oneRace::oneRace", 
                    oneRace.hashCode() != twoRace.hashCode());
            
        }
        catch (Exception e) {
            assertTrue("testAddRunner", false);
        }
    }
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
            System.out.println("***** Test " + totalTests + 
                    " failed ***** " + name
                    + ": " + totalTests);
            totalErrors = totalErrors + 1;
        }
        else {
            System.out.println("----- Test " + totalTests + 
                    " passed ----- " + name
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