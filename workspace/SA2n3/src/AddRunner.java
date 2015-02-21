/**
 * Class contains implementation for RaceResults ADT with data
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @version May 7, 2014
 */
public class AddRunner extends RaceResults {
    private RaceResults f;
    private Integer x;
    
    /**
     * Constructor for AddRunner class
     * @param f - the RaceResults
     * @param x - the Integer
     */
    public AddRunner(RaceResults f, Integer x) {
        this.f = f;
        this.x = x;
    }
    /**
     * Are there any finishers? (Are the results empty?)
     * @return true if none, false if > 0 finishers
     */
    @Override
    boolean noFinishers() {
        return false;
    }
    /**
     * Sets the value at the place
     * @param n - the place
     * @return the new RaceResults
     */
    @Override
    Integer getPlace(int n) {
        if ((n - 1) == 0) {
            return this.x;
        }
        else {
            return RaceResults.getPlace(this.f, n - 1);
        }
    }
    /**
     * Sets the Place of the runner
     * @param n - the place
     * @param y - the runner #
     * @return the number of runners
     */
    @Override
    RaceResults setPlace(int n, Integer y) {
        if ((n - 1) == 0) {
            return RaceResults.addRunner(f, y);
        }
        else {
            return RaceResults.addRunner(
                    RaceResults.setPlace(f, n - 1, y), x);
        }
    }
    /**
     * Gets the number of runners in a race.
     * @return the number of runners
     */
    @Override
    int numRunners() {
        return 1 + RaceResults.numRunners(this.f);
    }
    /**
     * Finish the race
     * @param i - the value
     * @return true if race is finished, false if not
     */
    @Override
    boolean finishRace(Integer i) {
        if (this.x.equals(i)) {
            return true;
        }
        else {
            return RaceResults.finishRace(f, i);
        }
    }
    /**
     * toString method for AddRunner
     * @return the string representation of AddRunner
     */
    @Override
    public String toString() {
        if (RaceResults.noFinishers(this.f)) {
            return "[" + x.toString() + "]";
        }
        else {
            return "[" + x.toString() + ", "
                + f.toString().substring(1, f.toString().length());
        }
    }
    /**
     * Equals method for AddRunner
     * @param o - the object
     * @return boolean true if equal/false if not equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AddRunner)) {
            return false;
        }
        else {
            AddRunner that = (AddRunner) o;
            boolean noFinish = this.noFinishers() == that.noFinishers();
            boolean numRun = this.numRunners() == that.numRunners();
            
            if (noFinish || numRun) {
                for (int i = 1; i <= this.f.numRunners(); i++) {
                    if (getPlace(this, i) != getPlace(that, i)) {
                        return false;
                    }
                }
                return true;
            }
            else {
                return false;
            }
        }
    }
    /**
     * hashCode method for AddRunner
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        return 37 + this.x +  numRunners() + this.f.hashCode();
    }
    
}