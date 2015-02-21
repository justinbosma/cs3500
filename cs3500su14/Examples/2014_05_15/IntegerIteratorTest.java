package IntegerIterator;


public class IntegerIteratorTest{
    
    public static void main(String[] args){
        IntegerIterator it = new IntegerIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}