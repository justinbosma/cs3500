import java.util.Date;
import java.util.HashMap;

import tester.Tester;

/**
 * Tester class for Bakery Operations System
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @author Justin Bosma - bosma.j@husky.neu.edu - u/n bosmaj
 * @version Jun 18, 2014
 */
public class ExamplesBakery {
    private Item it1 = new Item(1, "apple", "fruit", 1.00);
//    private Item it2 = new Item(2, "donut", "bread thing", 2);
//    private Item it3 = new Item(3, "grass", "veggie", 3);
//    private Item it4 = new Item(4, "pear", "banananana", 4);
//    private Item it5 = new Item(5, "dog", "ruff-age", 5);
    private Date d1 = new Date(5);
    
    private Customer c1 = new Customer(111, 3.22, "Joe", "Tu",
            "Donahue", "9", "Smellsville", "SP", "55554",
            612, 560, 9999);
//    private Customer c2 = new Customer(222, 3.22, "Jane", "Tou",
//            "Donnahey", "8", "Smelliersville", "PS", "43254",
//            612, 560, 9911);
    
    private Order o1 = new Order(c1, 1, d1, "Fresh Snakes");
    //private Order o2 = new Order(c2, 3, d1, "Old Snakes");
    
    /**
     * Tests the Get methods for Customer class
     * @param t - the tester object
     */
    void testCustomerGets(Tester t) {
        t.checkExpect(c1.getCustID(), 111);
        t.checkExpect(c1.getCustFirstName(), "Joe");
        t.checkExpect(c1.getCustMidName(), "Tu");
        t.checkExpect(c1.getCustLastName(), "Donahue");
        t.checkExpect(c1.getCustAddress(), "9");
        t.checkExpect(c1.getCustCity(), "Smellsville");
        t.checkExpect(c1.getCustState(), "SP");
        t.checkExpect(c1.getCustZIP(), "55554");
        t.checkExpect(c1.getCustPhone(), "612-560-9999");
        t.checkExpect(c1.getOrderList(), new HashMap());
        t.checkExpect(c1.getCustBalance(), 0.0);
        t.checkExpect(c1.getLoyaltyMember(), 3.22);
    }
    /**
     * Tests the Get methods for the Order class
     * @param t - the tester object
     */
    void testOrderGets(Tester t) {
        t.checkExpect(o1.getOrderID(), 1);
        t.checkExpect(o1.getPaid(), true);
        t.checkExpect(o1.getAvailableDiscount(), 0.0);
        //t.checkExpect(o1.getCustomer(), 2);
        t.checkExpect(o1.getOrdComments(), "Fresh Snakes");
        t.checkExpect(o1.getOrdDate(), new Date());
        t.checkExpect(o1.getOrdDatePickup(), new Date());
        t.checkExpect(o1.getOrdDiscountUsedOnOrder(), 0.0);
        t.checkExpect(o1.getOrdItems(), null);
        t.checkExpect(o1.getOrdQuantity(), 0);
        t.checkExpect(o1.getOrdSubTotal(), 0.0);
        t.checkExpect(o1.getOrdTax(), 0.0);
        t.checkExpect(o1.getOrdTotal(), 0.0);
    }
    /**
     * Tests the Get methods for the Item class
     * @param t - the tester object
     */
    void testItemGets(Tester t) {
        t.checkExpect(it1.getItemID(), 1);
        t.checkExpect(it1.getItemName(), "apple");
        t.checkExpect(it1.getItemDesc(), "fruit");
        t.checkExpect(it1.getItemInv(), 0);
        t.checkExpect(it1.getItemPrice(), 1.0);
        t.checkExpect(it1.getItemCost(), 0.0);
    }
    
    
    
//  /*  boolean testChooseFromList(Tester t) {
//        return t.checkExpect(Bakery.chooseFromList("Arf", "Meow"), )
//    } Scanner Issue????
//    same for getMenuSel, printallorders, printallcustomers, ok so all 
    //prints... */
//    
//    //Test for parseCustChoice
//    void testParseCustChoice(Tester t) {
//        //return t.checkExpect(Bakery.parseCustChoice(111), c1);
//    }
//    //Test for parseOrderChoice
//    void testParseOrderChoice(Tester t) {
//        //return t.checkExpect(Bakery.parseOrderChoice(1), o1);
//    }
//    //Test for parseITemChoice
//    void testParseItemChoice(Tester t) {
//        //return t.checkExpect(Bakery.parseItemChoice(1), it1);
//    }
//   /* //Test for validNInt
//    boolean testValidNInt(Tester t) {
//        return t.checkExpect(Bakery.validNInt(10, "Arf"), );
//    }  MORE SCANNER ISSUES..........*/
//    //Test for outputBakeryItems
//    void testOutputBakeryItems(Tester t) {
////        Bakery.itemList.put(1,it1);
////        t.checkExpect(Bakery.outputBakeryItems(),
////                "BakeryItemID\tBakeryItemName\tCategory\tPrice\n" +
////        1 + "\t" + "apple" + "\t" + "fruit" + "\t" + 1 + "\n");
//    }


}
