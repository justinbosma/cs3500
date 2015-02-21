/**
 * Abstract Data Type for Race Results
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 7, 2014
 */
public abstract class RaceResults {
    /**
     * Are there any finishers? (Are the results empty?)
     * @return true if none, false if > 0 finishers
     */
    abstract boolean noFinishers();
    /**
     * Returns the number at the place
     * @param n - the place
     * @return the number
     */
    abstract Integer getPlace(int n);
    /**
     * Sets the value at the place
     * @param n - the place
     * @param i - the value
     * @return the new RaceResults
     */
    abstract RaceResults setPlace(int n, Integer i);
    /**
     * Gets the number of runners in a race.
     * @return the number of runners
     */
    abstract int numRunners();
    /**
     * Finish the race
     * @param i - the value
     * @return true if race is finished, false if not
     */
    abstract boolean finishRace(Integer i);
    /**
     * toString method
     * @return the string representation of RaceResults
     */
    public abstract String toString();
    /**
     * equals method override
     * @return o - the object to compare
     */
    public abstract boolean equals(Object o);
    /**
     * hashCode method override
     * @return int - the hashCode
     */
    public abstract int hashCode();
    
    
    
    
    /**
     * toString method
     * @param x the RaceResults object
     * @return the string representation of RaceResults
     */
    public static String toString(RaceResults x) {
        return x.toString();
    }
    
    
    /**
     * Creates a new EmptyResults instance
     * @return the new EmptyResults instance
     */
    public static RaceResults emptyResults() {
        return new EmptyResults();
    }
    /**
     * Creates a new AddRunner instance
     * @param x - the RaceResults
     * @param i - the value
     * @return the new AddRunner instance
     */
    public static RaceResults addRunner(RaceResults x, Integer i) {
        return new AddRunner(x, i);
    }
    /**
     * Are there any finishers? (Are the results empty?)
     * @param x - RaceResults
     * @return true if none, false if > 0 finishers
     */
    public static boolean noFinishers(RaceResults x) {
        return x.noFinishers();
    }
    /**
     * Returns the number at the place
     * @param x - RaceResults
     * @param n - the place
     * @return the number
     */
    public static Integer getPlace(RaceResults x, int n) {
        return x.getPlace(n);
    }
    /**
     * Sets the value at the place
     * @param x - RaceResults
     * @param n - the place
     * @param i - the value
     * @return the new RaceResults
     */
    public static RaceResults setPlace(RaceResults x, int n, Integer i) {
        return x.setPlace(n, i);
    }
    /**
     * Gets the number of runners in a race.
     * @param x - RaceResults
     * @return the number of runners
     */
    public static int numRunners(RaceResults x) {
        return x.numRunners();
    }

    /**
     * Finish the race
     * @param x - RaceResults
     * @param i - the value
     * @return true if race is finished, false if not
     */
    public static boolean finishRace(RaceResults x, Integer i) {
        return x.finishRace(i);
    }
}