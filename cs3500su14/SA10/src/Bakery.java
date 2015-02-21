import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Bakery Operations System
 * Contains User Interface System, Customer, Item, and Order Types
 * Operations, File I/O, 
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @author Justin Bosma - bosma.j@husky.neu.edu - u/n bosmaj
 * @version Jun 18, 2014
 */
public class Bakery {
    static private String passWord = "donkey";
    static private HashMap<Integer, Customer> custList = new 
            HashMap<Integer, Customer>();
    //static ArrayList<Customer> custList = new ArrayList<Customer>();
    static private HashMap<Integer, Item> itemList = new 
            HashMap<Integer, Item>();
    static private HashMap<Integer, Order> orderList = new 
            HashMap<Integer, Order>();
    static private final File ORDERFILE = new File("orders.txt");
    static private final File BAKERYFILE = new File("bakeryItems.txt");
    static private int loginAttempts = 0;
    static private final int MAXLOGINS = 15;
    /**
     * Main Method for Bakery Program
     * @param args - command line arguments (not used)
     */
    public static void main(String[] args) {
        passWord = getPass();
        openFiles();
        //generateExamples();
        
        while (!login(validString(15, "Enter the Password!!!"))) {
            loginAttempts++;
            if (loginAttempts == MAXLOGINS) {
                System.out.println("You're a failure and should stop "
                        + "being in the world! Seriously??? "
                        + "\nPlaintext password cracking has perplexed you?"
                        + "\n - Program Out!");
                System.exit(0);
            }
        }
        printMainMenu();
        saveFiles();
    }
    /**
     * Add Customer Prompts - Prompts user for new Customer Data
     */
    static void addCustPrompts() {
        //boolean lm = false;
        String s;
        int id = custList.size();
        String head = ":::::::::::::::::::::::::::::::::::\n";
        s = head + "Enter Customer First Name         :";
        String fn = validString(40, s);
        s = head + "Enter Customer Middle Name        :";
        String mn = validString(40, s);
        s = head + "Enter Customer Last Name          :";
        String ln = validString(40, s);
        //String loy = "";
//        s = head + "Enroll the customer in the \n"
//                + "Loyalty Program?\n"
//                + "Enter Y for Yes, N for No";
//        while (!loy.equals("Y") && !loy.equals("N")) {
//            loy = validString(2, s);
//            if (loy.equals("Y")) {
//                lm = true;
//            }
//        }
        s = head + "Enter Customer Address            :";
        String ad = validString(100, s);
        s = head + "Enter Customer City               :";
        String city = validString(40, s);
        s = head + "Enter Customer State               :";
        String state = validString(40, s);
        s = head + "Enter Customer ZIP Code           :";
        String zip = "";
        while (zip.equals("")) {
            zip = validString(6, s);
        }
        int pac = 0;
        s = head + "Enter Customer Phone Number:      :\n"
                + "3 Digit Area Code                 :";
        while (pac == 0) {
            pac = validNint(3, s);
        }
        int pex = 0;
        s = head + "Customer Phone Number:            :\n"
                + "3 Digit Exchange                  :";
        while (pex == 0) {
            pex = validNint(5, s);
        }
        int pnum = 0;
        s = head + "Customer Phone Number:            :\n"
                + "4 Digit Phone Number              :";
        while (pnum == 0) {
            pnum = validNint(5, s);
        }
        Customer cust = new Customer();
        custList.put(id, cust.makeNewCust(id, 0.0, fn, mn, ln, ad, city, 
                state, zip, pac, pex, pnum));
        custList.get(id).printCust();
        printCustMenu();
    }
    /**
     * Add Item Prompts - Prompts user for new Item Data
     */
    static void addItemPrompts() {
        int iID = itemList.size();
        String head = "Add an Item::::::::::::::::::::::::\n";
        String s = head + "Enter the Item Name";
        String iName = validString(40, s);
        s = head + "Enter the Item Category";
        String iCat = validString(40, s);
        s = head + "Enter the Item Purchase Cost";
        double iCost = 0.0;
        while (iCost == 0.0) {
            iCost = validDouble(s);
        }
        s = head + "Enter the Item Selling Price";
        double iPrice = 0.0;
        while (iPrice == 0.0) {
            iPrice = validDouble(s);
        }
        s = head + "Enter the Item Inventory Amount";
        int inv = 0;
        while (inv == 0) {
            inv = validNint(40, s);
        }
        s = head + "Enter the Item Order Quantity";
        int ordQuant = 0; 
        while (ordQuant == 0) {
            ordQuant = validNint(40, s);
        }
        
        Item it = new Item();
        itemList.put(itemList.size(), it.makeItem(iID, iName, iCat, iCost, 
                iPrice, inv, ordQuant));
        ((Item) itemList.get(itemList.size() - 1)).printItem();
        printItemMenu();
    }
    /**
     * Add Order Prompts - Prompts user for new Order Data
     */
    static void addOrderPrompts() {
        String s = "";
        int id = orderList.size();
        System.out.println("Add an Order");
        String head = ":::::::::::::::::::::::::::::::::::\n";
        Customer cust = new Customer();
        
        s = head + "Press 1 to add from the customer list\n"
                + "Press 2 to add a new customer to the customer list";
        int choice1 = validNint(1, s);
        if (choice1 == 1) {
            cust = printAllCustomers();
        }
        if (choice1 == 2) {
            addCustPrompts();
            cust = custList.get(custList.size());
        }
        
        Order ord = new Order();
        Scanner ob = new Scanner(System.in);
        
        s = "Enter the Pickup date in the following format: MM/DD/YYYY";
        Date pickup = validDate(s);
        String comments = "";
        s = "Enter any additional comments for the order";
        comments = validString(200, s);
        ord = ord.makeOrder(cust, id, pickup, comments);
        int choice = 0;
        while (choice != 9) {
            s = "Press 1 to add from the inventory list\n"
                    + "Press 2 to add a new item to the inventory list";
            choice = validNint(1, s);
            int it = 0;
            if (choice == 1) {
                it = printAllItems().getItemID();
            }       
            if (choice == 2) {
                addItemPrompts();
                it = itemList.size();
            }
            double itPrice = getPrice(it);
            System.out.println("Enter Quantity");
            ord.addItem(it, ob.nextInt(), itPrice);
            s = "Enter 9 to stop adding items to order\nEnter 8 to add "
                    + "more items";
            choice = validNint(1, s);
        }
        cust.setCustBalance(cust.getCustBalance() + ord.getOrdTotal());
        orderList.put(ord.getOrderID(), ord);
        HashMap<Integer, Order> custHist = cust.getCustOrdHist();
        custHist.put(ord.getOrderID(), ord);
        cust.setCustOrdHist(custHist);
        cust.printCust();
        System.out.println("Order Added::");
        ord.printOrder();
        printOrderMenu();
    }
    /**
     * Choose a Customer from a list or by Customer ID
     * @return - the Customer
     */
    static Customer chooseCust() {
        Customer cust = new Customer();
        String s = "Enter 1 to choose from the list of customers\n"
                + "Enter 2 to choose by Customer ID\n"
                + "Enter 3 to enter Customer Last Name";
        int id = validNint(1, s);
        switch(id) {
            case 1:
                cust = printAllCustomers();
                break;
            case 2:
                cust = custList.get(validNint(5, "Enter the Customer "
                    + "ID"));
                break;
            case 3:
                cust = custByLN(validString(25, "Enter the Customers "
                    + "Last Name"));
                break;
            default:
                chooseCust();
        }
        return cust;
    }
    /**
     * Choose a customer by Last Name
     * @param ln - the last name
     * @return - the customer
     */
    static Customer custByLN(String ln) {
        Customer cust = new Customer();
        for (int key: custList.keySet()) {
            if (custList.get(key).getCustLastName().equals(ln)) {
                return custList.get(key);
            }
        }
        return cust;
    }
    /**
     * Choose from a list - abstract - validate an integer choice
     * @param s1 - the user entry
     * @param s2 - the type to chose (customer, item, order)
     * @return the user entry
     */
    static int chooseFromList(String s1, String s2) {
        String s = "Enter " + s1 + " to choose a " + s2;
        return validNint(5, s);
    }
    /**
     * Edit existing customer's name
     * @param c - Customer to edit
     */
    private static void editName(Customer c) {
        String s;
        String head = ":::::::::::::::::::::::::::::::::::\n";
        s = head + "Enter Customer First Name         :";
        String fn = validString(40, s);
        s = head + "Enter Customer Middle Name        :";
        String mn = validString(40, s);
        s = head + "Enter Customer Last Name          :";
        String ln = validString(40, s);
        c.setCustFirstName(fn);
        c.setCustMidName(mn);
        c.setCustLastName(ln);
        printEditCustMenu();
        parseEditCustomerMenu(getMenuSel(), c);
        
    }
    /**
     * Edit existing customer's address
     * @param c Customer to edit
     */
    private static void editAddress(Customer c) {
        String s;
        String head = ":::::::::::::::::::::::::::::::::::\n";
        s = head + "Enter Customer Address            :";
        String ad = validString(100, s);
        s = head + "Enter Customer City               :";
        String city = validString(40, s);
        s = head + "Enter Customer State               :";
        String state = validString(40, s);
        s = head + "Enter Customer ZIP Code           :";
        String zip = "";
        while (zip.equals("")) {
            zip = validString(5, s);
        }
        c.setCustAddress(ad);
        c.setCustCity(city);
        c.setCustState(state);
        c.setCustZIP(zip);
        printEditCustMenu();
        parseEditCustomerMenu(getMenuSel(), c);
        
    }
    /**
     * Edit existing customer's phone
     * @param c Customer to edit
     */
    private static void editPhone(Customer c) {
        String s;
        String head = ":::::::::::::::::::::::::::::::::::\n";
        int pac = 0;
        s = head + "Enter Customer Phone Number:      :\n"
                + "3 Digit Area Code                 :";
        while (pac == 0) {
            pac = validNint(3, s);
        }
        int pex = 0;
        s = head + "Customer Phone Number:            :\n"
                + "3 Digit Exchange                  :";
        while (pex == 0) {
            pex = validNint(5, s);
        }
        int pnum = 0;
        s = head + "Customer Phone Number:            :\n"
                + "4 Digit Phone Number              :";
        while (pnum == 0) {
            pnum = validNint(5, s);
        }
        c.setCustPhoneAC(pac);
        c.setCustPhoneEX(pex);
        c.setCustPhoneNum(pnum);
        printEditCustMenu();
        parseEditCustomerMenu(getMenuSel(), c);
        
    }
    
    /**
     * Edit name of item
     * @param it - item to edit
     */
    private static void editName(Item it) {
        String head = ":::::::::::::::::::::::::::::::::::\n";
        String s = head + "Enter the Item Name";
        String iName = validString(40, s);
        it.setItemName(iName);
        printEditItemMenu();
        parseEditItemMenu(getMenuSel(), it);

    }
    /**
     * Edit description(Category) of item
     * @param it item to edit
     */
    private static void editDescription(Item it) {
        String head = ":::::::::::::::::::::::::::::::::::\n";
        String s = head + "Enter the Item Category";
        String iCat = validString(40, s);
        it.setItemDesc(iCat);
        printEditItemMenu();
        parseEditItemMenu(getMenuSel(), it);
    }
    /**
     * Edit cost of item
     * @param it item to edit
     */
    private static void editCost(Item it) {
        String head = ":::::::::::::::::::::::::::::::::::\n";
        String s = head + "Enter the Item Purchase Cost";
        double iCost = 0.0;
        while (iCost == 0.0) {
            iCost = validDouble(s);
        }
        it.setItemCost(iCost);
        printEditItemMenu();
        parseEditItemMenu(getMenuSel(), it);
    }
    /**
     * Edit price of item
     * @param it item to edit
     */
    private static void editPrice(Item it) {
        String head = ":::::::::::::::::::::::::::::::::::\n";
        String s = head + "Enter the Item Selling Price";
        double iPrice = 0.0;
        while (iPrice == 0.0) {
            iPrice = validDouble(s);
        }
        it.setItemPrice(iPrice);
        printEditItemMenu();
        parseEditItemMenu(getMenuSel(), it);
    }
    /**
     * Edit name of inventory
     * @param it item to edit
     */
    private static void editInventory(Item it) {
        String head = ":::::::::::::::::::::::::::::::::::\n";
        String s = head + "Enter the Item Inventory Amount";
        int inv = 0;
        while (inv == 0) {
            inv = validNint(40, s);
        }
        it.setItemInv(inv);
        printEditItemMenu();
        parseEditItemMenu(getMenuSel(), it);
    }
    /**
     * Edit quantity of item
     * @param it item to edit
     */
    private static void editQuantity(Item it) {
        String head = ":::::::::::::::::::::::::::::::::::\n";
        String s = head + "Enter the Item Order Quantity";
        int ordQuant = 0; 
        while (ordQuant == 0) {
            ordQuant = validNint(40, s);
        }
        it.setOrderQuantity(ordQuant);
        printEditItemMenu();
        parseEditItemMenu(getMenuSel(), it);
    }
    /**
     * Edit an existing Customer
     */
    static void editCust() {
        Customer cust = printAllCustomers();
        printEditCustMenu();
        parseEditCustomerMenu(getMenuSel(), cust);
    }
    /**
     * Edit an existing Order
     */
    static void editOrd() {
        Order ord = printAllOrders();
        printEditOrderMenu(ord);
        parseEditOrderMenu(getMenuSel(), ord);
    }
    /**
     * Edit an existing Customer
     */
    static void editItem() {
        Item it = printAllItems();
        printEditItemMenu();
        parseEditItemMenu(getMenuSel(), it);
    }
    /**
     * Validate user input - menu choices
     * @return the input
     */
    static int getMenuSel() {
        Scanner scan = new Scanner(System.in);
        try {
            int i = scan.nextInt();
            System.out.println("You entered::" + i);
            return i;
        }
        catch (InputMismatchException e) {
            System.out.println("Input entered Not an integer!!!"
                    + "\nPlease enter an integer from the menu");
        }
        return 0;
    }
    
    /**
     * Parses the input from the Main Menu
     * makes calls to display sub-menus
     * @param n - the user input
     */
    static void parseMain(int n) {
        switch(n) {
            case 1:
                printCustMenu();
                break;
            case 2:
                printItemMenu();
                break;
            case 3:
                printOrderMenu();
                break;
            case 4:
                openFiles();
                System.out.println("Files opened successfully!");
                printMainMenu();
                break;
            case 5:
                saveFiles();
                System.out.println("Files saved successfully!");
                printMainMenu();
                break;
            case 6:
                changePW(validString(15, "Enter the new password:"));
                parseMain(9);
                break;
            case 9:
                System.out.println("Good Bye!");
                break;
            default:
                System.out.println("Invalid Input! Try Again");
                printMainMenu();
        }
    }
    /**
     * Parses the input from the CUST Menu
     * makes calls to display sub-menus
     * @param n - the user input
     */
    static void parseCustMenu(int n) {
        switch(n) {
            case 1:
                addCustPrompts();
                break;
            case 2:
                editCust();
                break;
            case 3:
                remCust(0/*Get the Customer ID here*/);
                break;
            case 4:
                printViewCustomerMenu();
                break;
            case 5:
                printMainMenu(); 
                break;
            default:
                System.out.println("Invalid Input! Try Again");
                printCustMenu();
        }
    }
    /**
     * Parses the input from the Order Menu
     * makes calls to display sub-menus
     * @param n - the user input
     */
    static void parseItemMenu(int n) {
        switch(n) {
            case 1:
                addItemPrompts();
                break;
            case 2:
                editItem();
                break;
            case 3:
                remItem(0/*Get the Customer ID here*/);
                break;
            case 4:
                for (int i: itemList.keySet()) {
                    Item it = itemList.get(i);
                    it.printItem();
                }
                printItemMenu();
                break;
            case 5:
                printMainMenu(); 
                break;
            default:
                System.out.println("Invalid Input! Try Again");
                printItemMenu();
        }
    }
    /**
     * Parses the input from the Order Menu
     * makes calls to display sub-menus
     * @param n - the user input
     */
    static void parseOrderMenu(int n) {
        switch(n) {
            case 1: 
                addOrderPrompts();
                break;
            case 2:
                editOrd();
                break;
            case 3:
                remOrd(0/*Get the Customer ID here*/);
                break;
            case 4:
                viewOrders();
                break;
            case 5:
                printMainMenu();
                break;
            default:
                System.out.println("Invalid Input! Try Again");
                printItemMenu();
        }
    }
    /**
     * Parses the Choose a Customer Menu
     * @param custID - the user input
     * @return the chosen customer
     */
    static Customer parseCustChoice(int custID) {
        System.out.printf("You Chose Customer: " + custID + " : ");
        if (!custList.containsKey(custID)) {
            System.out.println("Invalid Input! Try Again\n");
            return printAllCustomers();
        }
        else {
            Customer ordering = custList.get(custID);
            System.out.printf(ordering.getCustLastName() + "\n");
            return ordering;
        }
    }
    /**
     * Parses the Choose an Order Menu
     * @param orderID - the user input
     * @return the Chosen Order
     */
    static Order parseOrderChoice(int orderID) {
        System.out.printf("You Chose Order: " + orderID + " : ");
        if (!orderList.containsKey(orderID)) {
            System.out.println("Invalid Input! Try Again\n");
            return printAllOrders();
        }
        else {
            Order ordering = orderList.get(orderID);
            //System.out.println(ordering);
            //System.out.println(orderList);
            Customer orderer = ordering.getCustomer();
            System.out.println("custLastName+ " + orderer.getCustLastName() + 
                    "\n");
            return ordering;
        }
    }
    /**
     * Parses the Choose an Item Menu
     * @param itemID - the user input
     * @return the chosen item
     */
    static Item parseItemChoice(int itemID) {
        System.out.printf("You Chose Item: " + itemID + " : ");
        if (itemID < 0 || itemID > itemList.size()) {
            System.out.println("Invalid Input! Try Again\n");
            return printAllItems();
        }
        else {
            Item it = itemList.get(itemID);
            System.out.printf(it.getItemName() + "\n");
            return it;
        }
    }
    /**
     * parse edit order menu
     * @param n - the user entry
     * @param ord - the order
     */
    static void parseEditOrderMenu(int n, Order ord) {
        switch(n) {
            case 1:
                ord.setPaid(true);
                printOrderMenu();
                break;
            case 2:
                printOrderMenu();
                break;
            default:
                printEditOrderMenu(ord);
        }
    }
    /**
     * Parse the view customer menu
     * @param n - the user entry
     */
    static void parseViewCustomer(int n) {
        switch(n) {
            case 1:
                printAllCustomers();
                break;
            case 2:
                chooseCust().getLoyaltyMember();
                break;
            case 3:
                chooseCust().getCustContact();
                break;
            case 4:
                printCustMenu();
                break;
            case 5:
                printMainMenu();
                break;
            default:
                System.out.println("Input Error Try Again");
                printViewCustomerMenu();
        }
    }
    /**
     * parse view Order menu
     * @param n - the user entry
     */
    static void parseViewOrderMenu(int n) {
        //Scanner sc = new Scanner(System.in);
        String s;
        Date d;
        ArrayList<Order> newOrd = new ArrayList<Order>();
        switch(n) {
            case 1:
                int id = printAllCustomers().getCustID();
                for (int i: orderList.keySet()) {
                    Customer ordCust = orderList.get(i).getCustomer();
                    if (ordCust.getCustID() == id) {
                        newOrd.add(orderList.get(i));
                    }
                }
                orderViewHelp(newOrd);
                break;
            case 2:
                s = "Enter the desired date in the following format: "
                        + "MM/DD/YYYY";
                d = validDate(s);
                for (int i: orderList.keySet()) {
                    if (orderList.get(i).getOrdDate() == d) {
                        newOrd.add(orderList.get(i));
                    }
                }
                orderViewHelp(newOrd);
                break;
            case 3:
                s = "Enter the desired date in the following format: "
                        + "MM/DD/YYYY";
                d = validDate(s);
                for (int i: orderList.keySet()) {
                    if (orderList.get(i).getOrdDatePickup() == d) {
                        newOrd.add(orderList.get(i));
                    }
                }
                orderViewHelp(newOrd);
                break;
            case 4:
                Item it = printAllItems();
                for (int i: orderList.keySet()) {
                    if (orderList.get(i).getOrdItems().containsKey(
                            it.getItemID())) {
                        newOrd.add(orderList.get(i));
                    }
                }
                orderViewHelp(newOrd);
                break;
                
            case 5:
                for (int i: orderList.keySet()) {
                    if (!orderList.get(i).getPaid()) {
                        newOrd.add(orderList.get(i));
                    }
                }
                orderViewHelp(newOrd);
                break;
            case 6: 
                printOrderMenu();
                break;
            default:
                printViewOrderMenu();
        }
    }
    /**
     * parses input for order views
     */
    static void parseViewOrders() {
        // different views
    }
    /**
     * Parse the edit customer menu
     * @param n menu option
     * @param cust - the customer to edit
     */
    private static void parseEditCustomerMenu(int n, Customer cust) {
        switch(n) {
            case 1:
                editName(cust);
                break;
            case 2:
                editAddress(cust);
                break;
            case 3:
                editPhone(cust);
                break;
            case 4:
                printMainMenu();
                break;
            default:
                printEditCustMenu();
        }
    }
    /**
     * Parse the edit item menu
     * @param n menu option 
     * @param it - the item to edit
     */
    private static void parseEditItemMenu(int n, Item it) {
        switch(n) {
            case 1:
                editName(it);
                break;
            case 2:
                editDescription(it);
                break;
            case 3:
                editCost(it);
                break;
            case 4:
                editPrice(it);
                break;
            case 5:
                editInventory(it);
                break;
            case 6:
                editQuantity(it);
                break;
            case 7:
                printMainMenu();
                break;
            default:
                printEditItemMenu();
        }
    }
    /**
     * Prints a list of all the customers for the user to choose one from
     * @return the chosen customer
     */
    static Customer printAllCustomers() {
        String head = ":::::::::::::::::::::::::::::::::::::::::::::::::::\n";
        String s = head + head + "Choose a Customer or 999 to exit\n";
        String colHead = "CustID Phone         Last Name  First Name  "
                + "Address\n";
        System.out.println(s + colHead);
        for (int i: custList.keySet()) {
            Customer current = custList.get(i);
            String custData = current.getCustID() + ",     "
                + current.getCustPhone() + "    "
                + current.getCustLastName() + ",  "
                + current.getCustFirstName() + ",  "
                + current.getCustAddress();
            System.out.println(custData);
            
        }
        int choice = -1;
        while (!custList.containsKey(choice)) {
            choice = chooseFromList("CustID", "customer");
        }
        
        return parseCustChoice(choice);
        
    }
    /**
     * Prints the list of orders for the user to choose one
     * @return the chosen order
     */
    static Order printAllOrders() {
        String head = ":::::::::::::::::::::::::::::::::::::::::::::::::::\n";
        String s = head + head + "Choose an Order\n";
        String colHead = "OrderID";
        System.out.println(s + colHead);
        for (int i: orderList.keySet()) {
            Order ord = orderList.get(i);
            Customer ordCust = ord.getCustomer();
            String ordData = ord.getOrderID() + ",     "
                + ordCust.getCustLastName() + ",  "
                + ordCust.getCustAddress();
            System.out.println(ordData);
        }
        int choice = -1;
        while (!orderList.containsKey(choice)) {
            choice = chooseFromList("OrderID", "order");
        }
        return parseOrderChoice(choice);
    }
    /**
     * Prints all items in the list so the user can choose one
     * @return the chosen item
     */
    static Item printAllItems() {
        String head = ":::::::::::::::::::::::::::::::::::::::::::::::::::\n";
        String s = head + head + "Choose an Item\n";
        String colHead = "ItemID";
        System.out.println(s + colHead);
        for (int i: itemList.keySet()) {
            Item it = itemList.get(i);
            String itemData = it.getItemID() + ",     "
                + it.getItemName() + ",  "
                + it.getItemDesc();
            System.out.println(itemData);
            
        }
        int choice = -1;
        while (choice < 0 || choice > itemList.size()) {
            choice = chooseFromList("ItemID", "item");
        }
        return parseItemChoice(choice);
    }
    /**
     * Prints the Main Menu to the console
     */
    static void printMainMenu() {
        String s = 
                ""
                + ":::::::::::::::::::::::::::::::::::\n"
                + "::::::::     Main Menu      :::::::\n"
                + "::::::::  Enter Selection   :::::::\n"
                + ":                                 :\n"
                + ":  1 - Customer Options           :\n"
                + ":  2 - Item Options               :\n"
                + ":  3 - Order Options              :\n"
                + ":  4 - Add Data From Files        :\n"
                + ":  5 - Save Data to File          :\n"
                + ":  6 - Change Password            :\n"
                + ":                                 :\n"
                + ":  9 - Quit                       :\n"
                + ":::::::::::::::::::::::::::::::::::\n"
                + ":::::::::::::::::::::::::::::::::::\n"
                + ":::::::::::::::::::::::::::::::::::\n";
        System.out.println(s);
        parseMain(getMenuSel());
    }
    
    /**
     * Prints the Item Menu to the console
     */
    static void printItemMenu() {
        String s = 
            ""
            + "::::::::Item Operations Menu:::::::\n"
            + "::::::::  Enter Selection   :::::::\n"
            + ":                                 :\n"
            + ":  1 - Add a Menu Item            :\n"
            + ":  2 - Edit an existing Menu Item :\n"
            + ":  3 - Remove a Menu Item         :\n"
            + ":                                 :\n"
            + ":      See Item Totals            :\n"
            + ":  4 - Total Inventory            :\n"
            + ":  5 - Main Menu                  :\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n";
        System.out.println(s);
        parseItemMenu(getMenuSel());
    }
    /**
     * Prints the Cust Menu to the console
     */
    static void printCustMenu() {
        String s = 
            ""
            + "::::::Customer Operations Menu:::::\n"
            + "::::::::  Enter Selection   :::::::\n"
            + ":                                 :\n"
            + ":  1 - Add a Customer             :\n"
            + ":  2 - Edit an existing Customer  :\n"
            + ":  3 - Remove a Customer          :\n"
            + ":  4 - View a Customer            :\n"
            + ":  5 - Main Menu                  :\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n";
        System.out.println(s);
        parseCustMenu(getMenuSel());
    }
    /**
     * Prints the Order Menu to the console
     */
    static void printOrderMenu() {
        String s = 
            ""
            + ":::::: Order Operations Menu  :::::\n"
            + "::::::::  Enter Selection   :::::::\n"
            + ":                                 :\n"
            + ":  1 - Add an Order               :\n"
            + ":  2 - Edit an existing Order     :\n"
            + ":  3 - Remove an Order            :\n"
            + ":  4 - View orders                :\n"
            + ":  5 - Main Menu                  :\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n";
        System.out.println(s);
        parseOrderMenu(getMenuSel());
    }
    /**
     * Prints edit customer menu
     * 
     */
    static void printEditCustMenu() {
        String s = 
            "::::::::::::::::::::::::::::::::::\n"
            + "::::::  Edit Customer Menu  :::::\n"
            + "::::::::  Enter Selection   :::::::\n"
            + ":                                 :\n"
            + ":  1 - Edit Name                  :\n"
            + ":  2 - Edit Address               :\n"
            + ":  3 - Edit Phone                 :\n"
            + ":  4 - Main Menu                  :\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n";
        System.out.println(s);
        
    }
    /**
     * Prints edit customer menu
     * 
     */
    static void printEditItemMenu() {
        String s = 
            ":::::::::::::::::::::::::::::::::::\n"
            + "::::::  Edit Item Menu  :::::\n"
            + "::::::::  Enter Selection   :::::::\n"
            + ":                                 :\n"
            + ":  1 - Edit Name                  :\n"
            + ":  2 - Edit Description           :\n"
            + ":  3 - Edit Cost                  :\n"
            + ":  4 - Edit Price                 :\n"
            + ":  5 - Edit Invetory              :\n"
            + ":  6 - Edit Quantity              :\n"
            + ":  7 - Main Menu                  :\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n";
        System.out.println(s);
        
    }
    /**
     * print for edit order menu
     * @param ord Order selected
     */
    static void printEditOrderMenu(Order ord) {
        String s = 
            ""
            + "::::::  Edit Order Menu  :::::\n"
            + "::::::::  Enter Selection   :::::::\n"
            + ":                                 :\n"
            + ":  1 - Edit Paid                  :\n"
            + ":  2 - Order Menu                 :\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n";
        System.out.println(s);        
    }
    /**
     * print for view Customer menu
     */
    static void printViewCustomerMenu() {
        String s = 
            ""
            + "::::::  View Customer Menu  :::::::\n"
            + "::::::::  Enter Selection   :::::::\n"
            + ":                                 :\n"
            + ":  1 - View All Customers         :\n"
            + ":  2 - View Customer Loyalty      :\n"
            + ":  3 - View Contact Information   :\n"
            + ":  4 - Customer Menu              :\n"
            + ":  5 - Main Menu                  :\n"
            + ":                                 :\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n";
        parseViewCustomer(validNint(1, s));
    }
    /**
     * print for view order menu
     */
    static void printViewOrderMenu() {
        String s = 
            ":::::::::::::::::::::::::::::::::::\n"
            + "::::::::  View Order Menu   :::::::\n"
            + "::::::::  Enter Selection   :::::::\n"
            + ":                                 :\n"
            + ":  1 - Customer ID                :\n"
            + ":  2 - Placed date                :\n"
            + ":  3 - Delivery date              :\n"
            + ":  4 - Specific item              :\n"
            + ":  5 - Unpaid                     :\n"
            + ":  6 - Order Menu                 :\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n"
            + ":::::::::::::::::::::::::::::::::::\n";
        System.out.println(s);        
    }
    /**
     * Remove an existing Customer
     * @param n - the user entry
     */
    private static void remCust(int n) {
        Customer cust = printAllCustomers();
        custList.remove(cust.getCustID());
        System.out.println("Customer #:" + cust.getCustID() 
                + " removed from the database\n");
        printCustMenu();
    }
    /**
     * Remove an existing Item
     * @param n - the user entry
     */
    private static void remItem(int n) {
        Item it = printAllItems();
        itemList.remove(it.getItemID());
        System.out.println("Item #:" + it.getItemID() 
                + " removed from the database\n");
        printItemMenu();
    }
    /**
     * Remove an existing Order
     * @param n - the user entry
     */
    private static void remOrd(int n) {
        Order ord = printAllOrders();
        orderList.remove(ord.getOrderID());
        System.out.println("Order #:" + ord.getOrderID() 
                + " removed from the database\n");
        printOrderMenu();
        
    }
    /**
     * Validate user input - n digit integers
     * Only accepting n digit integers
     * @param n - the user entry
     * @param s - the message
     * @return the input
     */
    static int validNint(int n, String s) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println(s);
            int i = scan.nextInt();
            if (i >= Math.pow(10, n)) {
                throw new InputMismatchException();
            }
            System.out.println("You entered::" + i);
            return i;
        }
        catch (InputMismatchException e) {
            System.out.println("Illegal Input! Must be " + n + 
                    " digit integer!!!");
            return 0;
        }
    }
    /**
     * Validate user input - double
     * @param s - the message
     * @return the input
     */
    static double validDouble(String s) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println(s);
            double i = scan.nextDouble();
            System.out.println("You entered::" + i);
            return i;
        }
        catch (InputMismatchException e) {
            System.out.println("Illegal Input! Must be a double!!!");
            return 0;
        }
    }
    /**
     * Validate user input - n length
     * Only accepting n digit integers
     * @param n - the user entry
     * @param msg - the message
     * @return the input
     */
    static String validString(int n, String msg) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println(msg);
            String s = scan.nextLine();
            if (s.length() >= n) {
                throw new InputMismatchException();
            }
            System.out.println("You entered::" + s);
            return s;
        }
        catch (InputMismatchException e) {
            System.out.println("Illegal Input! String must be < " + n + 
                    " characters long!!!");
        }
        return "";
    }
    /**
     * Validates a date
     * @param msg - the message
     * @return the date
     */
    static Date validDate(String msg) {
        Date date1 = new Date();
        try {
            String d = validString(11, msg);
            date1 = new SimpleDateFormat("MM/dd/yy").parse(d);
            System.out.println("You Entered:" + date1);
            
        }
        catch (ParseException e) {
            validDate(msg);
        }
        return date1;
    }
    /**
     * View orders menu calls
     */
    private static void viewOrders() {
        printViewOrderMenu();
        parseViewOrderMenu(getMenuSel());
    }
    /**
     * Saves the files (pw.txt, bakeryItems.txt, orders.txt)
     */
    static void saveFiles() {
        try {
            PrintWriter pWriter = new PrintWriter("pw.txt");
            pWriter.println(passWord);
            pWriter.close();
            pWriter = new PrintWriter("bakeryItems.txt");
            pWriter.println(outputBakeryItems());
            pWriter.close();
            pWriter = new PrintWriter("orders.txt");
            pWriter.println(outputBakeryOrders());
            pWriter.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Output file does not exist");
        }
    }
    /**
     * Saves the program data to the bakeryItems.txt
     * @return the string containing the bakeryItems.txt data
     */
    static String outputBakeryItems() {
        String head = "BakeryItemID\tBakeryItemName\tCategory\tPrice";
        String items = "";
        for (int i: itemList.keySet()) {
            Item it = itemList.get(i);
            int id = it.getItemID();
            String name = it.getItemName();
            String cat = it.getItemDesc();
            double price = it.getItemPrice();
            items = items + "\n" + id + "\t" + name + "\t" + cat + "\t" + 
                    price;
        }
        return head + items;
    }
    /**
     * Saves the program data to the orders.txt file
     * @return the string containing orders.txt data
     */
    static String outputBakeryOrders() {
        String head = "CustomerID\tLastName\tAddress\tCity\tState\tZipCode"
                + "\tOrderID\tPaid?\tOrderDate\tPickupDate\tBakeryItemID"
                + "\tBakeryItemName\tBakeryItemCategory\tQuantity\tPrice"
                + "\tTotal\tDiscountUsedOnOrder\tTotalDue\tAvailableDiscount"
                + "\tCurrentLoyalty";
        
        String orders = "";
        for (int orderKey: orderList.keySet()) {
            Order ord = orderList.get(orderKey);
            for (int itemKey: ord.getOrdItems().keySet()) {
                orders = genOrderFileOutput(orders, orderList.get(orderKey), 
                        orderKey, itemKey);
            }
        }
        return head + orders;
    }
    /**
     * Generates the String to convert program data to the orders.txt file
     * @param orders - the string line by line incremented
     * @param ord - the order object
     * @param orderKey - the order key
     * @param itemKey - the item key
     * @return the string for each line in the file
     */
    static String genOrderFileOutput(String orders, Order ord, int orderKey, 
            int itemKey) {
        
        Customer ordCust = ord.getCustomer();
        Item it = itemList.get(itemKey);
        HashMap<Integer, Integer> ordItems = ord.getOrdItems();
        
        int customerID = ordCust.getCustID();
        String lastName = ordCust.getCustLastName();
        String address = ordCust.getCustAddress();
        String city = ordCust.getCustCity();
        String state = ordCust.getCustState();
        String zipCode = ordCust.getCustZIP();
        int orderID = ord.getOrderID();
        boolean paid = ord.getPaid();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date orderD = ord.getOrdDate();
        String orderDate = sdf.format(orderD);
        Date pickupD = ord.getOrdDatePickup();
        String pickupDate = sdf.format(pickupD);
        int bakeryItemID = it.getItemID();
        String bakeryItemName = it.getItemName();
        String bakeryItemCategory = it.getItemDesc();
        int quantity = ordItems.get(itemKey);
        double price = it.getItemPrice();
        double total = ord.getOrdTotal();
        double discountUsedOnOrder = ord.getOrdDiscountUsedOnOrder();
        double totalDue = ord.getOrdTotal();
        double availableDiscount = ord.getAvailableDiscount();
        double currentLoyalty = ordCust.getLoyaltyMember();
        
        orders = orders + "\n" + customerID + "\t" + lastName + "\t" + address
                + "\t" + city + "\t" + state + "\t" + zipCode
                + "\t" + orderID + "\t" + paid + "\t" + orderDate
                + "\t" + pickupDate + "\t" + bakeryItemID
                + "\t" + bakeryItemName + "\t" + bakeryItemCategory
                + "\t" + quantity + "\t" + price + "\t" + total
                + "\t" + discountUsedOnOrder + "\t" + totalDue
                + "\t" + availableDiscount + "\t" + currentLoyalty;
        
        return orders;
    }
    
    /**
     * Helps by printing new arrays for view orders option
     * @param newOrd new order array list
     */
    static void orderViewHelp(ArrayList<Order> newOrd) {
        for (int k = 0; k < newOrd.size(); k++) {
            newOrd.get(k).printOrder();
        }
        printOrderMenu();
    }
    /**
     * Changes the password for the Program
     * @param pw - the user entry
     */
    static void changePW(String pw) {
        passWord = pw;
        try {
            PrintWriter pWriter = new PrintWriter("pw.txt");
            pWriter.println(passWord);
            pWriter.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Output file does not exist");
        }
    }
    /**
     * Gets the Password from the pw.txt file
     * @return the password
     */
    private static String getPass() {
        Scanner scan;
        String s = "";
        try {
            scan = new Scanner(new File("pw.txt"));
            s = scan.next();
            scan.close();
        }
        catch (FileNotFoundException e) {
            changePW(passWord);
            getPass();
        }
        //System.out.println(s);
        return s;
    }
    /**
     * Login method compares the password to the System Password
     * @param pw - the user entered string
     * @return true if passwords match
     */
    static boolean login(String pw) {
        return (pw.equals(passWord));
    }
    /**
     * Gets the price if item ID's match
     * @param id - the item id
     * @return the price
     */
    static double getPrice(int id) {
        Item it = new Item();
        for (int i: itemList.keySet()) {
            
            if (itemList.get(i).getItemID() == id) {
                it = itemList.get(i);
            } 
        }
        return it.getItemPrice();
    }
    /**
     * Calls the open Files methods
     */
    static void openFiles() {
        openOrderFile();
        openBakeryFile();
    }
    /**
     * Reads from the orders.txt file
     */
    static void openOrderFile() {
        try {
            Scanner scan = new Scanner(ORDERFILE);
            scan.nextLine();
            
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split("\t");
                
                int custID = Integer.parseInt(parts[0]);
                //System.out.println("ID" + custID);
                String lastName = parts[1];
                //System.out.println("LN =" + lastName);
                String address = parts[2];
                //System.out.println("ADDY =" + address);
                String city = parts[3];
                //System.out.println("City =" + city);
                String state = parts[4];
                String zipCode = parts[5];
                int id = Integer.parseInt(parts[6]);
                boolean paid = parts[7].equals("Yes");
                Date orderDate = new SimpleDateFormat("MM/dd/yy").parse(
                        parts[8]);
                Date pickupDate = new SimpleDateFormat("MM/dd/yy").parse(
                        parts[9]);
                
                int bakeryItemID = Integer.valueOf(parts[10]);
                String bakeryItemName = parts[11];
                String bakeryItemCategory = parts[12];
                int quantity = Integer.valueOf(parts[13]);
                double price = Double.valueOf(parts[14]);
                double total = Double.valueOf(parts[15]);
                double discountUsedOnOrder = Double.valueOf(parts[16]);
                double totalDue = Double.valueOf(parts[17]);
                double availableDiscount = Double.valueOf(parts[18]);
                double currentLoyalty = Double.valueOf(parts[19]);
                
                Customer cust = new Customer();
                cust = cust.makeNewCust(custID, currentLoyalty, "", "", 
                        lastName, address, city,
                        state, zipCode, 999, 999, 9999);
                custList.put(custID, cust);
                
                Item it = new Item(bakeryItemID, bakeryItemName, 
                        bakeryItemCategory, price); 
                itemList.put(bakeryItemID, it);
                
                Order ord = new Order();
                ord = ord.makeOrder(cust, id, paid, 
                        orderDate, pickupDate, it, 
                        quantity, price, total, discountUsedOnOrder,
                        totalDue, availableDiscount, currentLoyalty);
                orderList.put(ord.getOrderID(), ord);
            }
            scan.close();
        }
        catch (FileNotFoundException e) {
//            System.out.println("Order File Not Found");
//            e.printStackTrace();
            //printMainMenu();
        }
        catch (ParseException e) {
            System.out.println("Date Parsing Error");
            e.printStackTrace();
        }
    }
    /**
     * Reads from the bakeryItems.txt file
     */
    static void openBakeryFile() {
        try {
            Scanner scan = new Scanner(BAKERYFILE);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split("\t");
                //System.out.println(parts[0]);
                int itemID = Integer.parseInt(parts[0]);
                itemList.put(itemID, new Item(itemID, parts[1], parts[2], 
                        Double.parseDouble(parts[3])));
            }
            scan.close();
        }
        catch (FileNotFoundException e1) {
            //e1.printStackTrace();
        }
        catch (InputMismatchException e) {
            System.out.println("Error on Input");
        }
    }
    /**
     * Generates examples of Customers, Items, Orders
     * for debugging purposes only
     */
    static void generateExamples() {
        makeItemListEx();
        makeCustListEx();
        makeOrderListEx();
    }
    /**
     * Generates a list of customer objects
     * for debugging purposes only
     */
    static void makeCustListEx() {
        Customer c = new Customer();
        for (int i = 0; i < 103; i++) {
            custList.put(i, c.makeNewCust(i, 1.33, "Nick", "A", "Scheuring"
                    + i, i + " Winter St", "Salem", "MA", "01970", 978, 530, 
                    1230 + i));
        }
    }
    /**
     * Generates a list of order objects
     * for debugging purposes only
     */
    static void makeOrderListEx() {
        Order c = new Order();
        for (int i = 0; i < 103; i++) {
            orderList.put(i, c.makeOrder(custList.get(i), i, new Date(), 
                    "Comm"));
        }
    }
    /**
     * Generates a list of item objects
     * for debugging purposes only
     */
    static void makeItemListEx() {
        Item c = new Item();
        for (int i = 0; i < 103; i++) {
            itemList.put(i, c.makeItem(i, "Namen " + i, "Category" + i, 
                    i + 1, i + 2, i + 3, i + 4));
        }
    }
}