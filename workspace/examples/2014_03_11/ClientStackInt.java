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
        
        IntVisitorR<Integer> count = new CountNumElements();
        System.out.println("Count: "+s.acceptR(count));

        IntVisitorR<String> list = new ListStack();
        System.out.println("List: "+s.acceptR(list));

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
    
    private static class CountNumElements implements IntVisitorR<Integer>{

        @Override
        public Integer visit(Integer r, int x) {
            return r + 1;
        }

        @Override
        public Integer getBase() {
            return 0;
        }
        
    }
    
    private static class ListStack implements IntVisitorR<String>{

        @Override
        public String visit(String r, int x) {
            if(!r.equals("")) {
                return x+", "+r;
            }
            return ""+x;
        }

        @Override
        public String getBase() {
            return "";
        }
        
    }

}
