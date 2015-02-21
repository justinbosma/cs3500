/**
 * Class that represents a student
 * 
 * @author Jessica Young Schmidt
 * @version Summer 2014
 */
public class Student {
    /** student's unique ID */
    private int studentID;
    /** student's first name */
    private String firstName;
    /** student's last name */
    private String lastName;

    /**
     * Construct a new default student
     */
    public Student() {
        studentID = 0;
        firstName = "Bob";
        lastName = "Smith";
    }

    /**
     * Construct a new student with given parameters
     * 
     * @param studentID
     *            student's ID
     * @param firstName
     *            student's first name
     * @param lastName
     *            student's last name
     */
    public Student(int studentID, String firstName, String lastName) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Accessor method for studentID
     * 
     * @return this student's studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Accessor method for firstName
     * 
     * @return this student's firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Accessor method for lastName
     * 
     * @return this student's lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * String representation of this student
     * 
     * @return String representation of this student
     */
    public String toString() {
        return "[" + studentID + ": " + firstName + " "
                + lastName + "]";
    }

    /**
     * @param o
     *            comparison Object
     * @return whether this and o are equivalent
     */
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student that = (Student) o;
            return this.getStudentID() == that.getStudentID();
        }
        else {
            return false;
        }
    }

    /**
     * @return hashCode for this
     */
    public int hashCode() {
        return studentID;
    }
}
