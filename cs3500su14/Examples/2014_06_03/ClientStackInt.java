

/**
 * Client code using StackInt with IntVisitor
 */

public class ClientStackInt {

    public static void main(String args[]) {
        StackInt s = StackInt.empty();
        s = StackInt.push(s, 1);
        s = StackInt.push(s, 2);
        s = StackInt.push(s, 3);
        s = StackInt.push(s, 4);
        printstack(s);
        System.out.println();
        IntVisitor v5 = new Adder(5);
        IntVisitor v99 = new Adder(99);
        System.out.println("Adder (5)");
        printstack(s.accept(v5));
        System.out.println();
        System.out.println("Adder (99)");
        printstack(s.accept(v99));
        System.out.println();
        
        IntVisitorR<Integer> sum = new SumOfStack();
        System.out.println("Sum of Stack: "+s.acceptR(sum));

    }

    private static void printstack(StackInt s) {
        if (!(StackInt.isEmpty(s))) {
            System.out.println(StackInt.top(s));
            printstack(StackInt.pop(s));
        }
    }

    private static class Adder implements IntVisitor {
        private final int increment;

        Adder(int increment) {
            this.increment = increment;
        }

        public int visit(int n) {
            return n + increment;
        }
    }

    private static class SumOfStack implements IntVisitorR<Integer> {

        @Override
        public Integer visit(StackInt s, int x) {
            return x + s.acceptR(this);
        }

        @Override
        public Integer getBase() {
            return 0;
        }

    }

}
