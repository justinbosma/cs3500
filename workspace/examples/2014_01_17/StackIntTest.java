package c04;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple example JUnit test program for StackInt.
 * 
 * @author Schmidt
 * @version 2014-01-08
 */
public class StackIntTest {

    StackInt f0;
    StackInt f1;
    StackInt f12;
    StackInt f13;
    StackInt f123;
    StackInt f132;
    StackInt f1234;

    StackInt f129;
    StackInt f193;
    StackInt f923;

    /**
     * setUp for the assignment
     */
    @Before
    public void setup() {

        // Stacks to test
        f0 = StackInt.empty();
        f1 = StackInt.push(f0, 1);
        f12 = StackInt.push(f1, 2);
        f123 = StackInt.push(f12, 3);

        f129 = StackInt.push(f12, 9);
        f193 = StackInt.push(StackInt.push(f1, 9), 3);
        f923 = StackInt.push(StackInt.push(StackInt.push(f0, 9), 2), 3);
    }

    /**
     * Tests the accessors.
     */
    @Test
    public void testAccessors() {
        try {
            assertTrue("empty", StackInt.isEmpty(f0));
            assertFalse("nonempty", StackInt.isEmpty(f1));
            assertFalse("nonempty", StackInt.isEmpty(f12));

            assertTrue("f0.size()", StackInt.size(f0) == 0);
            assertTrue("f1.size()", StackInt.size(f1) == 1);
            assertTrue("f12.size()", StackInt.size(f12) == 2);
            assertTrue("f123.size()", StackInt.size(f123) == 3);
            assertTrue("f129.size()", StackInt.size(f129) == 3);
            assertTrue("f193.size()", StackInt.size(f193) == 3);
            assertTrue("f923.size()", StackInt.size(f923) == 3);
            assertFalse("f123.size()", StackInt.size(f123) == 1);
            assertFalse("f129.size()", StackInt.size(f129) == 2);
            assertFalse("f193.size()", StackInt.size(f193) == 6);
            assertFalse("f923.size()", StackInt.size(f923) == 7);

            assertTrue("f1.top()", (StackInt.top(f1) == 1));
            assertTrue("f12.top()", (StackInt.top(f12) == 2));
            assertTrue("f123.top()", (StackInt.top(f123) == 3));
            assertTrue("f923.top()", (StackInt.top(f923) == 3));
            assertTrue("f1.pop()", StackInt.pop(f1).equals(f0));
            assertTrue("f12.pop()", StackInt.pop(f12).equals(f1));
            assertTrue("f123.pop()", StackInt.pop(f123).equals(f12));
            assertFalse("f923.pop()", StackInt.pop(f923).equals(f12));

        }
        catch (Exception e) {
            System.out.println("Exception thrown during accessors tests:");
            System.out.println(e);
            assertTrue("accessors", false);
        }
    }

    /**
     * Tests the usual methods from Object.
     */
    @Test
    public void testUsual() {
        try {
            // test usual methods from Object: toString, equals, hashCode
        }
        catch (Exception e) {
            System.out.println("Exception thrown during usual tests:");
            System.out.println(e);
            assertTrue("usual", false);
        }
    }

}
