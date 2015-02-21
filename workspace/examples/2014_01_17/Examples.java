package c04;

import tester.*;

public class Examples {

    // Stacks to test
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

    void init() {

    }

    void testCreation(Tester t) {
        try {
            f0 = StackInt.empty();
            f1 = StackInt.push(f0, 1);
            f12 = StackInt.push(f1, 2);
            f123 = StackInt.push(f12, 3);

            f129 = StackInt.push(f12, 9);
            f193 = StackInt.push(StackInt.push(f1, 9), 3);
            f923 = StackInt
                    .push(StackInt.push(StackInt.push(f0, 9), 2), 3);
        }
        catch (Exception e) {
            t.checkExpect(false, "Exception thrown during creation tests");
        }
    }

    void testAccessors(Tester t) {
        try {
            t.checkExpect(StackInt.isEmpty(f0), "empty");
            t.checkFail(StackInt.isEmpty(f1), "nonempty");
            t.checkFail(StackInt.isEmpty(f12), "nonempty");

            t.checkExpect(StackInt.size(f0) == 0, "f0.size()");
            t.checkExpect(StackInt.size(f1) == 1, "f1.size()");
            t.checkExpect(StackInt.size(f12) == 2, "f12.size()");
            t.checkExpect(StackInt.size(f123) == 3, "f123.size()");
            t.checkExpect(StackInt.size(f129) == 3, "f129.size()");
            t.checkExpect(StackInt.size(f193) == 3, "f193.size()");
            t.checkExpect(StackInt.size(f923) == 3, "f923.size()");
            t.checkFail(StackInt.size(f123) == 1, "f123.size()");
            t.checkFail(StackInt.size(f129) == 2, "f129.size()");
            t.checkFail(StackInt.size(f193) == 6, "f193.size()");
            t.checkFail(StackInt.size(f923) == 7, "f923.size()");

            t.checkExpect((StackInt.top(f1) == 1), "f1.top()");
            t.checkExpect((StackInt.top(f12) == 2), "f12.top()");
            t.checkExpect((StackInt.top(f123) == 3), "f123.top()");
            t.checkExpect((StackInt.top(f923) == 3), "f923.top()");
            t.checkExpect(StackInt.pop(f1).equals(f0), "f1.pop()");
            t.checkExpect(StackInt.pop(f12).equals(f1), "f12.pop()");
            t.checkExpect(StackInt.pop(f123).equals(f12), "f123.pop()");
            t.checkFail(StackInt.pop(f923).equals(f12), "f923.pop()");

        }
        catch (Exception e) {
            System.out.println("Exception thrown during accessors tests:");
            System.out.println(e);
            t.checkExpect(false, "accessors");
        }
    }

    void testUsual(Tester t) {
        try {
            t.checkExpect(f0.hashCode() == f0.hashCode(), "f0.hashCode()");
            t.checkExpect(f1.hashCode() == f1.hashCode(), "f1.hashCode()");
            t.checkExpect(f123.hashCode() == f123.hashCode(),
                    "f123.hashCode()");
            t.checkFail(f0.hashCode() == f1.hashCode(), "f0.f1.hashCode()");
            t.checkFail(f1.hashCode() == f12.hashCode(), "f1.hashCode()");
            t.checkFail(f123.hashCode() == f129.hashCode(),
                    "f123.hashCode()");
            /*
             * t.checkExpect(f0.toString().equals("[]"), "f0.toString()");
             * t.checkExpect(f1.toString().equals("[1]"), "f1.toString()");
             * t.checkExpect(f12.toString().equals("[2, 1]"), "f12.toString()");
             * t.checkExpect(f123.toString().equals("[3, 2, 1]"),
             * "f123.toString()"); t.checkFail(f12.toString().equals("[1, 2]"),
             * "f12.toString()");
             * t.checkFail(f123.toString().equals(f129.toString()),
             * "f123.toString()");
             */
            t.checkExpect(f0.equals(f0), "f0.equals()");
            t.checkExpect(f1.equals(f1), "f1.equals()");
            t.checkExpect(f123.equals(f123), "f123.equals()");
            t.checkFail(f0.equals(null), "f0.equals()");
            t.checkFail(f123.equals(f129), "f123.equals()");
            t.checkFail(f0.equals(12), "f129.equals()");
        }
        catch (Exception e) {
            System.out.println("Exception thrown during usual tests:");
            System.out.println(e);
            t.checkExpect(false, "usual");
        }
    }
}