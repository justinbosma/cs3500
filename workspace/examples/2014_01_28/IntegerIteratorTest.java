
/**
 * Tests IntegerIterator, which iterates through Integers 0-MAX
 * @author CS3500sp14 in class on 1/28/2014
 */
public class IntegerIteratorTest {

    public static void main(String[] args) {
        IntegerIterator intIt = new IntegerIterator();

        while(intIt.hasNext()){
            //prints Integers
            System.out.println(intIt.next());
        }
    }

}
