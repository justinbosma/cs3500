import java.util.Date;

import tester.Tester;


public class ExamplesBakery {
    Item it1 = new Item(1, "apple", "fruit", 1.00);
    Item it2 = new Item(2, "donut", "bread thing", 2);
    Item it3 = new Item(3, "grass", "veggie", 3);
    Item it4 = new Item(4, "pear", "banananana", 4);
    Item it5 = new Item(5, "dog", "ruff-age", 5);
    Date d1 = new Date(5);
    
    Customer c1 = new Customer(111, true, "Joe", "Tu",
            "Donahue", "9", "Smellsville", "SP", "55554",
            612, 560, 9999);
    Customer c2 = new Customer(222, false, "Jane", "Tou",
            "Donnahey", "8", "Smelliersville", "PS", "43254",
            612, 560, 9911);
    
    Order o1 = new Order(c1, 1, d1, "Fresh Snakes");
    Order o2 = new Order(c2, 3, d1, "Old Snakes");
    
  /*  boolean testChooseFromList(Tester t) {
        return t.checkExpect(Bakery.chooseFromList("Arf", "Meow"), )
    } Scanner Issue????
    same for getMenuSel, printallorders, printallcustomers, ok so all prints... */
    
    //Test for parseCustChoice
    boolean testParseCustChoice(Tester t) {
        return t.checkExpect(Bakery.parseCustChoice(111), c1);
    }
    //Test for parseOrderChoice
    boolean testParseOrderChoice(Tester t) {
        return t.checkExpect(Bakery.parseOrderChoice(1), o1);
    }
    //Test for parseITemChoice
    boolean testParseItemChoice(Tester t) {
        return t.checkExpect(Bakery.parseItemChoice(1), it1);
    }
   /* //Test for validNInt
    boolean testValidNInt(Tester t) {
        return t.checkExpect(Bakery.validNInt(10, "Arf"), );
    }  MORE SCANNER ISSUES..........*/
    //Test for outputBakeryItems
    boolean testOutputBakeryItems(Tester t) {
        Bakery.itemList.put(1,it1);
        return t.checkExpect(Bakery.outputBakeryItems(),
                "BakeryItemID\tBakeryItemName\tCategory\tPrice\n" +
        1 + "\t" + "apple" + "\t" + "fruit" + "\t" + 1 + "\n");
    }


}
