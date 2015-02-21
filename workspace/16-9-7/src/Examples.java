import tester.Tester;

/**
 * Testing Class for RaceResults Abstract Data Type
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 7, 2014
 */
public class Examples extends Tester {
    
    /**
     * Tests the valueToString(int n) method in TriSwitch Class
     * @param t - the Tester Object
     */
    public void testValueToString(Tester t) {
        t.checkExpect(TriSwitch.valueToString(1), "* \n");
        t.checkExpect(TriSwitch.valueToString(4), "* * * * \n");
        t.checkExpect(TriSwitch.valueToString(0), "\n");
        
        //Case Exception
        t.checkExpect(TriSwitch.valueToString(-1), 
                "Massive error here, value cannot be negative:"
                + " Error: valueToString() method");
    }
    
}