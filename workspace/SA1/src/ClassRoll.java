/**
 * CS3500 Summer 14 Assignment 1 - Class Roll ADT
 * Immutable Data Type to represent the population of a class of students
 * @author Nicholas Scheuring - UN - nscheu - email nscheu@ccs.neu.edu
 * @version 5/5/14
 */
public abstract class ClassRoll {
    /**
     * Creates a new EmptyRoll object
     * @return an EmptyRoll object
     */
    //abstract ClassRoll emptyRollMethod();
    /**
     * Creates a new Enroll object
     * @param cr - the ClassRoll Object
     * @param s0 - the student to enroll
     * @return - a new ClassRoll Object
     */
    //abstract ClassRoll enrollMethod(ClassRoll cr, Student s0);
    /**
     * returns the number of students enrolled in a ClassRoll object
     * @return integer - the number of students
     */
    abstract int numStudents();
    /**
     * Does the ClassRoll contain no students?
     * @return boolean true if no students, false if yes students
     */
    abstract boolean noStudents();
    /**
     * Is the student in this ClassRoll?
     * @param s0 - The student
     * @return boolean - true if in the class, false if not
     */
    abstract boolean inClass(Student s0);
    /**
     * Is that ClassRoll a subset of this ClassRoll?
     * @param cr - That ClassRoll
     * @return boolean - true if subset, false if not subset
     */
    abstract boolean isSubset(ClassRoll cr);
    /**
     * Drop the Student from the ClassRoll
     * @param s0 - The Student
     * @return a new ClassRoll without the Student
     */
    abstract ClassRoll drop(Student s0);
    /**
     * Combines the two ClassRolls
     * @param cr - The ClassRoll to combine with current ClassRoll
     * @return the combined ClassRoll
     */
    abstract ClassRoll combine(ClassRoll cr);
    /**
     * What students are common to both ClassRolls?
     * @param cr - the ClassRoll to compare with current ClassRoll
     * @return a ClassRoll of common students
     */
    abstract ClassRoll inCommon(ClassRoll cr);
    /**
     * Swaps one student for another in the ClassRoll
     * @param s0 - a student
     * @param s1 - a student
     * @return the new ClassRoll
     */
    abstract ClassRoll swap(Student s0, Student s1);
    /**
     * Override of the toString Method
     * @return a string with the number of students enrolled
     */
    public abstract String toString();
    /**
     * Are the two objects equal?
     * @param o - the object to compare
     * @return true if yes, false if not
     */
    public abstract boolean equals(Object o);
    /** 
     * Overrides the hashCode method
     * @return the hashCode for the object
     */
    public abstract int hashCode();
    
    /**
     * Creates a new EmptyRoll object
     * @return an EmptyRoll object
     */
    
    
    
    
    
    
    
    
    
    
    
    
    public static ClassRoll emptyRoll() {
        return new EmptyRoll();
    }
    /**
     * Creates a new Enroll object
     * @param cr - the ClassRoll Object
     * @param s0 - the student to enroll
     * @return - a new ClassRoll Object
     */
    public static ClassRoll enroll(ClassRoll cr, Student s0) {
        return new Enroll(cr, s0);
    }
    /**
     * returns the number of students enrolled in a ClassRoll object
     * @param cr - the ClassRoll
     * @return integer - the number of students
     */
    public static int numStudents(ClassRoll cr) {
        return cr.numStudents();
    }
    /**
     * Does the ClassRoll contain no students?
     * @param cr - the ClassRoll
     * @return boolean true if no students, false if yes students
     */
    public static boolean noStudents(ClassRoll cr) {
        return cr.noStudents();
    }
    /**
     * Is the student in this ClassRoll?
     * @param cr - the ClassRoll
     * @param s0 - The student
     * @return boolean - true if in the class, false if not
     */
    public static boolean inClass(ClassRoll cr, Student s0) {
        return cr.inClass(s0);
    }
    /**
     * Is that ClassRoll a subset of this ClassRoll?
     * @param cr - the ClassRoll
     * @param cr1 - That ClassRoll
     * @return boolean - true if subset, false if not subset
     */
    public static boolean isSubset(ClassRoll cr, ClassRoll cr1) {
        return cr.isSubset(cr1);
    }
    /**
     * Drop the Student from the ClassRoll
     * @param cr - the ClassRoll
     * @param s0 - The Student
     * @return a new ClassRoll without the Student
     */
    public static ClassRoll drop(ClassRoll cr, Student s0) {
        return cr.drop(s0);
    }
    /**
     * Combines the two ClassRolls
     * @param cr - the ClassRoll
     * @param cr1 - The ClassRoll to combine with current ClassRoll
     * @return the combined ClassRoll
     */
    public static ClassRoll combine(ClassRoll cr, ClassRoll cr1) {
        return cr.combine(cr1);
    }
    /**
     * What students are common to both ClassRolls?
     * @param cr - the ClassRoll
     * @param cr1 - the ClassRoll to compare with current ClassRoll
     * @return a ClassRoll of common students
     */
    public static ClassRoll inCommon(ClassRoll cr, ClassRoll cr1) {
        return cr.inCommon(cr1);
    }
    /**
     * Swaps one student for another in the ClassRoll
     * @param cr - the ClassRoll
     * @param s0 - a student
     * @param s1 - a student
     * @return the new ClassRoll
     */
    public static ClassRoll swap(ClassRoll cr, Student s0, Student s1) {
        return cr.swap(s0, s1);
    }
}