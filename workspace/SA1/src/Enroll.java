/**
 * CS3500 Summer 14 Assignment 1 - Class Roll ADT
 * Immutable Data Type to represent the population of a class of students
 * @author Nicholas Scheuring - UN - nscheu - email nscheu@ccs.neu.edu
 * @version 5/5/14
 */
public class Enroll extends ClassRoll {
    private ClassRoll cr;
    private Student s0;
    
    /**
     * Constructor for Enroll Class
     * @param cr - the ClassRoll object
     * @param s0 - the student to be enrolled
     */
    public Enroll(ClassRoll cr, Student s0) {
        this.cr = cr;
        this.s0 = s0;
    }
        /**
     * Creates a new EmptyRoll object
     * @return an EmptyRoll object
     */
    /*@Override
    ClassRoll emptyRollMethod() {
        return null;
    }*/
    /**
     * Creates a new Enroll object
     * @param cr1 - the ClassRoll Object
     * @param s - the student to enroll
     * @return - a new ClassRoll Object
     */
    /*@Override
    ClassRoll enrollMethod(ClassRoll cr1, Student s) {
        return new Enroll(cr1, s);
    }*/

    /**
     * returns the number of students enrolled in a ClassRoll object
     * @return integer - the number of students
     */
    @Override
    int numStudents() {
        //if (ClassRoll.inClass(this.cr, this.s0)) {
        //    return ClassRoll.numStudents(this.cr);
        //}
        if (!this.cr.inClass(this.s0)) {
            return 1 + this.cr.numStudents();
        }
        else {
            return this.cr.numStudents();
        }
    }
    /**
     * Does the ClassRoll contain no students?
     * @return boolean true if no students, false if yes students
     */
    @Override
    boolean noStudents() {
        return false;
    }
    /**
     * Is the student in this ClassRoll?
     * @param s - The student
     * @return boolean - true if in the class, false if not
     */
    @Override
    boolean inClass(Student s) {
        if (s.equals(this.s0)) {
            return true;
        }
        else {
            return inClass(this.cr, s);
        }
    }
    /**
     * Is that ClassRoll a subset of this ClassRoll?
     * @param cr2 - That ClassRoll
     * @return boolean - true if subset, false if not subset
     */
    @Override
    boolean isSubset(ClassRoll cr2) {
        if (ClassRoll.inClass(cr2, this.s0)) {
            return ClassRoll.isSubset(this.cr, cr2);
        }
        else {
            return false;
        }
    }
    /**
     * Drop the Student from the ClassRoll
     * @param s - The Student
     * @return a new ClassRoll without the Student
     */
    @Override
    ClassRoll drop(Student s) {
        if (s.equals(this.s0)) {
            return ClassRoll.drop(this.cr, s);
        }
        else {
            return ClassRoll.enroll(ClassRoll.drop(this.cr, s), this.s0);
        }
    }
    /**
     * Combines the two ClassRolls
     * @param cr2 - The ClassRoll to combine with current ClassRoll
     * @return the combined ClassRoll
     */
    @Override
    ClassRoll combine(ClassRoll cr2) {
        if (ClassRoll.inClass(cr2, s0)) {
            return ClassRoll.combine(cr, cr2);
        }
        else {
            return ClassRoll.enroll(ClassRoll.combine(cr, cr2), s0);
        }
    }
    /**
     * What students are common to both ClassRolls?
     * @param cr2 - the ClassRoll to compare with current ClassRoll
     * @return a ClassRoll of common students
     */
    @Override
    ClassRoll inCommon(ClassRoll cr2) {
        if (ClassRoll.inClass(cr2, this.s0)) {
            return ClassRoll.enroll(ClassRoll.inCommon(cr, cr2), s0);
        }
        else {
            return ClassRoll.inCommon(cr, cr2);
        }
    }
    /**
     * Swaps one student for another in the ClassRoll
     * @param s1 - a student
     * @param s2 - a student
     * @return the new ClassRoll
     */
    @Override
    ClassRoll swap(Student s1, Student s2) {
        if (s1.equals(this.s0)) {
            return ClassRoll.enroll(ClassRoll.swap(cr, s1, s2), s2);
        }
        else {
            return ClassRoll.enroll(ClassRoll.swap(cr, s1, s2), s0);
        }
    }
    /**
     * Override of the toString Method
     * @return a string with the number of students enrolled
     */
    @Override
    public String toString() {
        //return "There are " + ClassRoll.numStudents(this.cr)
          //      + " students in this course. : ";
        return "There are " + this.numStudents()
                + " students in this course.";
    }
    /**
     * Are the two objects equal?
     * @param o - the Object comparing
     * @return true if yes, false if not
     */
    @Override
    public boolean equals(Object o) {
        return ((o instanceof Enroll) && 
                (ClassRoll.isSubset(this, (ClassRoll) o) &&
                        ClassRoll.isSubset((ClassRoll) o, this)));
        //return ((o instanceof ClassRoll) && 
          //      (this.cr.isSubset((ClassRoll) o) && 
            //            ((ClassRoll) o).isSubset(this.cr) ));
    }
    /** 
     * Overrides the hashCode method
     * @return the hashCode for the object
     */
    @Override
    public int hashCode() {
        if (this.cr.inClass(this.s0)) {
            return cr.hashCode();
        }
        else {
            return this.numStudents() * 37
                    + this.s0.hashCode() * 11 
                    + this.cr.hashCode();
        }
    }
}