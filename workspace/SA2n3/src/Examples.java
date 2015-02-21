import tester.Tester;

/**
 * Testing Class for RaceResults Abstract Data Type
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 7, 2014
 */
public class Examples extends Tester {
    private RaceResults mtRace = RaceResults.emptyResults();
    private RaceResults oneRace = RaceResults.addRunner(mtRace, 9);
    private RaceResults twoRace = RaceResults.addRunner(oneRace, 3);
    private RaceResults twoRaceOOOrder = RaceResults.addRunner(mtRace, 3);
    
    /**
     * 
     * Constructor for Examples Class initializes fields
     */
    public Examples() {
        twoRaceOOOrder = RaceResults.addRunner(twoRaceOOOrder, 9);
    }
    
    /**
     * Tests the EmptyResults class
     * @param t - the Tester Object
     */
    public void testEmptyResults(Tester t) {
        t.checkExpect(mtRace.noFinishers(), true);
        t.checkExpect(mtRace.numRunners(), 0);
        t.checkExpect(mtRace.finishRace(9), false);
        t.checkExpect(mtRace.toString(), "[]");
        t.checkExpect(mtRace.equals(mtRace), true);
        t.checkExpect(mtRace.equals(oneRace), false);
        t.checkExpect(mtRace.hashCode(), mtRace.hashCode());
        t.checkFail(mtRace.hashCode(), oneRace.hashCode());
    }
    /**
     * Tests the AddRunner class
     * @param t - the Tester Object
     */
    public void testAddRunner(Tester t) {
        
        String x = "";
        t.checkExpect(oneRace.noFinishers(), false);
        t.checkExpect(oneRace.getPlace(1), 9);
        t.checkExpect(oneRace.setPlace(1, 8), RaceResults.addRunner(mtRace, 8));
        
        t.checkExpect(oneRace.numRunners(), 1);
        t.checkExpect(oneRace.finishRace(9), true);
        t.checkExpect(oneRace.toString(), "[9]");
        t.checkExpect(oneRace.equals(oneRace), true);
        t.checkExpect(twoRace.equals(null), false);
        t.checkExpect(twoRace.equals(x), false);
        t.checkExpect(oneRace.equals(mtRace), false);
        System.out.println(twoRace);
        System.out.println(twoRaceOOOrder);
        t.checkExpect(twoRace.equals(twoRaceOOOrder), false);
        t.checkExpect(twoRace.equals(oneRace), false);
        t.checkExpect(oneRace.hashCode(), oneRace.hashCode());
        
    }
}