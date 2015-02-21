/**
 * CS3500 Summer 14 Assignment 1 - Class Roll ADT
 * Immutable Data Type to represent the population of a class of students
 * @author Nicholas Scheuring - UN - nscheu - email nscheu@ccs.neu.edu
 * @version 5/5/14
 */
public class EmptyRoll extends ClassRoll {
    /**
     * Creates a new EmptyRoll object
     * @return an EmptyRoll object
     */
    //@Override
    /*ClassRoll emptyRollMethod() {
        return this;
    }*/
    /**
     * Creates a new Enroll object
     * @param cr - the ClassRoll Object
     * @param s0 - the student to enroll
     * @return - a new ClassRoll Object
     */
    /*@Override
    ClassRoll enrollMethod(ClassRoll cr, Student s0) {
        return new Enroll(cr, s0);
    }*/

    /**
     * returns the number of students enrolled in a ClassRoll object
     * @return integer - the number of students
     */
    @Override
    int numStudents() {
        return 0;
    }
    /**
     * Does the ClassRoll contain no students?
     * @return boolean true if no students, false if yes students
     */
    @Override
    boolean noStudents() {
        return true;
    }
    /**
     * Is the student in this ClassRoll?
     * @param s0 - The student
     * @return boolean - true if in the class, false if not
     */
    @Override
    boolean inClass(Student s0) {
        return false;
    }
    /**
     * Is that ClassRoll a subset of this ClassRoll?
     * @param cr - That ClassRoll
     * @return boolean - true if subset, false if not subset
     */
    @Override
    boolean isSubset(ClassRoll cr) {
        return true;
    }
    /**
     * Drop the Student from the ClassRoll
     * @param s0 - The Student
     * @return a new ClassRoll without the Student
     */
    @Override
    ClassRoll drop(Student s0) {
        return this;
    }
    /**
     * Combines the two ClassRolls
     * @param cr - The ClassRoll to combine with current ClassRoll
     * @return the combined ClassRoll
     */
    @Override
    ClassRoll combine(ClassRoll cr) {
        return cr;
    }
    /**
     * What students are common to both ClassRolls?
     * @param cr - the ClassRoll to compare with current ClassRoll
     * @return a ClassRoll of common students
     */
    @Override
    ClassRoll inCommon(ClassRoll cr) {
        return this;
    }
    /**
     * Swaps one student for another in the ClassRoll
     * @param s0 - a student
     * @param s1 - a student
     * @return the new ClassRoll
     */
    @Override
    ClassRoll swap(Student s0, Student s1) {
        return this;
    }
    /**
     * Override of the toString Method
     * @return a string with the number of students enrolled
     */
    @Override
    public String toString() {
        return "There are " + this.numStudents()
                + " students in this course.";
    }
    /**
     * Are the two objects equal?
     * @param o - the object to compare
     * @return true if yes, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof EmptyRoll && !(o.equals(null))) {
            return ((EmptyRoll) o).isSubset(this);
        }
        else {
            return false;
        }
    }
    /** 
     * Overrides the hashCode method
     * @return the hashCode for the object
     */
    @Override
    public int hashCode() {
        return 0;
    }
}