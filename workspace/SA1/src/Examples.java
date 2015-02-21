import tester.Tester;

/**
 * CS3500 Summer 14 Assignment 1 - Class Roll ADT
 * Immutable Data Type to represent the population of a class of students
 * @author Nicholas Scheuring - UN - nscheu - email nscheu@ccs.neu.edu
 * @version 5/5/14
 */
public class Examples extends Tester {
    private ClassRoll mtRoll = new EmptyRoll();
    //private ClassRoll mtRoll2 = ClassRoll.emptyRoll();
    private Student alice = new Student(1, "Alice", "Wonderland");
    private Student bob = new Student(2, "Bob", "Burger");
    private Student eve = new Student(3, "Eve", "Nsong");
    private ClassRoll ood = new Enroll(mtRoll, alice);
    private ClassRoll fundies2 = new Enroll(mtRoll, bob);
    private ClassRoll fundies1 = new Enroll(mtRoll, alice);
    private ClassRoll classDups = new Enroll(ood, alice);
    private ClassRoll fundies3 = mtRoll;
    private ClassRoll classWap = new Enroll(mtRoll, bob);
    private Enroll oodEn = (Enroll) ood;
    /**
     * Constructor for Examples Class
     */
    public Examples() {
        ood = ClassRoll.enroll(ood, bob);
        ood = ClassRoll.enroll(ood, eve);
        fundies2 = ClassRoll.enroll(fundies2, eve);
        fundies1 = ClassRoll.enroll(fundies1, eve);
        fundies3 = ClassRoll.enroll(fundies1 , bob);
        classWap = ClassRoll.enroll(classWap, eve);
        System.out.println(ood.toString());
    }
    
    /**
     * Tests the EmptyRoll Class
     * @param t - the Tester object
     */
    public void testEmptyRoll(Tester t) {
        t.checkExpect(ClassRoll.emptyRoll(), mtRoll);
        t.checkExpect(mtRoll.numStudents(), 0);
        t.checkExpect(ClassRoll.numStudents(mtRoll), 0);
        t.checkExpect(mtRoll.noStudents(), true);
        t.checkExpect(ClassRoll.noStudents(mtRoll), true);
        t.checkExpect(mtRoll.inClass(alice), false);
        t.checkExpect(mtRoll.isSubset(mtRoll), true);
        t.checkExpect(mtRoll.isSubset(ood), true);
        t.checkExpect(mtRoll.drop(alice), mtRoll);
        t.checkExpect(mtRoll.combine(ood), ood);
        t.checkExpect(mtRoll.inCommon(mtRoll), mtRoll);
        t.checkExpect(mtRoll.inCommon(ood), mtRoll);
        t.checkExpect(mtRoll.swap(bob, eve), mtRoll);
        
        t.checkExpect(mtRoll.toString(), 
                "There are 0 students in this course.");
        t.checkExpect(mtRoll.equals(mtRoll), true);
        t.checkExpect(mtRoll.equals(null), false);
        t.checkExpect(mtRoll.equals(ood), false);
        t.checkExpect(mtRoll.hashCode(), mtRoll.hashCode());
        t.checkFail(mtRoll.hashCode(), ood.hashCode());
    }
    /**
     * Tests the Enroll Class
     * @param t - the Tester Object
     */
    public void testEnroll(Tester t) {
        //ClassRoll.enroll(ood, bob);
        //System.out.println(ood);
        
        t.checkExpect(ood.numStudents(), 3);
        t.checkExpect(fundies1.numStudents(), 2);
        t.checkExpect(fundies2.numStudents(), 2);
        t.checkExpect(classDups.numStudents(), 1);
        t.checkExpect(ood.noStudents(), false);
        t.checkExpect(ood.inClass(alice), true);
        t.checkExpect(ood.isSubset(ood), true);
        t.checkExpect(ood.isSubset(mtRoll), false);
        t.checkExpect(ood.drop(alice), fundies2);
        t.checkExpect(ood.drop(bob), fundies1);
        t.checkExpect(fundies2.combine(fundies1), fundies3);
        t.checkExpect(fundies1.inCommon(fundies2), 
                ClassRoll.enroll(mtRoll, eve));
        t.checkExpect(ood.inCommon(ood), ood);
        t.checkExpect(fundies2.swap(alice, eve), classWap);
        t.checkExpect(ood.toString(), 
                "There are 3 students in this course.");
        t.checkExpect(ood.equals(mtRoll), false);
        t.checkExpect(ood.equals(ood), true);
        t.checkExpect(oodEn.equals(4), false);
        t.checkExpect(ood.hashCode(), ood.hashCode());
        t.checkFail(ood.hashCode(), mtRoll);
    }
}