/**
 * Class Contains implementation of RaceResults ADT - empty data
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 7, 2014
 */
public class EmptyResults extends RaceResults {
    /**
     * Default Constructor
     */
    public EmptyResults() {
        //empty constructor
    }
    /**
     * Are there any finishers? (Are the results empty?)
     * @return true if none, false if > 0 finishers
     */
    @Override
    boolean noFinishers() {
        return true;
    }
    /**
     * Sets the value at the place
     * @param n - the place
     * @return Throws Exception
     */
    @Override
    Integer getPlace(int n) {
        throw new RuntimeException("Empty - getPlace() illegal access");
    }
    /**
     * Gets the number of runners in a race.
     * @param n - the place
     * @param i - the runner #
     * @return Throws Exception
     */
    @Override
    RaceResults setPlace(int n, Integer i) {
        throw new RuntimeException("Empty - setPlace() illegal access");
    }
    /**
     * Gets the number of runners in a race.
     * @return the number of runners
     */
    @Override
    int numRunners() {
        return 0;
    }
    /**
     * Finish the race
     * @param i - the runner #
     * @return true if race is finished, false if not
     */
    @Override
    boolean finishRace(Integer i) {
        return false;
    }
    /**
     * toString method for EmptyResults
     * @return the string representation of EmptyResults
     */
    @Override
    public String toString() {
        return "[]";
    }
    /**
     * Equals method for EmptyResults
     * @param o - the object
     * @return boolean true if equal/false if not equal
     */
    @Override
    public boolean equals(Object o) {
        return (o instanceof EmptyResults);
    }
    /**
     * hashCode method for EmptyResults
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        return 0;
    }
}