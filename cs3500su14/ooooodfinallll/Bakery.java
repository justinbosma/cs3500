import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Bakery {
    
    static ArrayList<Customer> custList = new ArrayList<Customer>();
    static ArrayList<Item> itemList = new ArrayList<Item>();
    static ArrayList<Order> orderList = new ArrayList<Order>();
    static final File ORDERFILE = new File("orders.txt");
    static final File BAKERYFILE = new File("bakeryItems.txt");
    
    public static void main(String[] args) {
        
        //openBakeryFile();
        //openOrderFile();
        makeItemListEx();
        makeCustListEx();
        makeOrderListEx();
        printMainMenu();
    }
    /**
     * Parses the input from the Main Menu
     * makes calls to display sub-menus
     * @param n - the user input
     */
    static void parseMain(int n) {
        switch(n) {
        case 1: printCustMenu();
                break;
        case 2: printItemMenu();
                break;
        case 3: printOrderMenu();
                break;
        case 4: //TODO:getFromFiles();
                break;
        case 5: saveFile();
                break;
        case 9: System.out.println("Good Bye!");
                break;
        default: System.out.println("Invalid Input! Try Again");
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
        case 1: addCustPrompts();break;
        case 2: editCust();break;
        case 3: remCust(0/*Get the Customer ID here*/);break;
        case 4: printMainMenu();break;
        default: System.out.println("Invalid Input! Try Again");
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
        case 1: addItemPrompts();
                break;
        case 2: editItem();
                break;
        case 3: remItem(0/*Get the Customer ID here*/);
                break;
        case 4:
            for(int i = 0; i < itemList.size(); i++) {
                Item it = itemList.get(i);
                it.printItem();
            }
            printItemMenu();
            break;
        case 5: printMainMenu(); break;
        default: System.out.println("Invalid Input! Try Again");
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
        case 1: addOrderPrompts();
                break;
        case 2: editOrd();
                break;
        case 3: remOrd(0/*Get the Customer ID here*/);
                break;
        case 4: viewOrders();break;
        case 5: printMainMenu();break;
        default: System.out.println("Invalid Input! Try Again");
                printItemMenu();
        }
    }
    private static void viewOrders() {
        printViewOrderMenu();
        parseViewOrderMenu(getMenuSel());
        
    }
    /**
     * parses input for order views
     */
    static void parseViewOrders() {
        //TODO: different views
    }
    /**
     * Parses the Choose a Customer Menu
     * @param n - the user input
     */
    static Customer parseCustChoice(int custID) {
        System.out.printf("You Chose Customer: " + custID + " : ");
        if (custID < 0 || custID > custList.size()) {
            System.out.println("Invalid Input! Try Again\n");
            return printAllCustomers(0);
        }
        else {
            Customer ordering = custList.get(custID);
            System.out.printf(ordering.getCustLastName() + "\n");
            return ordering;
        }
    }
    /**
     * Parses the Choose an Order Menu
     * @param n - the user input
     */
    static Order parseOrderChoice(int orderID) {
        System.out.printf("You Chose Order: " + orderID + " : ");
        if (orderID < 0 || orderID > orderList.size()) {
            System.out.println("Invalid Input! Try Again\n");
            return printAllOrders(0);
        }
        else {
            Order ordering = orderList.get(orderID);
            System.out.printf(ordering.getCustLastName() + "\n");
            return ordering;
        }
    }
    /**
     * Parses the Choose an Item Menu
     * @param n - the user input
     */
    static Item parseItemChoice(int itemID) {
        System.out.printf("You Chose Item: " + itemID + " : ");
        if (itemID < 0 || itemID > itemList.size()) {
            System.out.println("Invalid Input! Try Again\n");
            return printAllItems(0);
        }
        else {
            Item it = itemList.get(itemID);
            System.out.printf(it.getItemName() + "\n");
            return it;
        }
    }
    
    /**
     * Parse the edit customer menu
     * @param n menu option 
     */
    private static void parseEditCustomerMenu(int n, Customer cust) {
        switch(n) {
        case 1: editName(cust);
        break;
        case 2: editAddress(cust);
        break;
        case 3: editPhone(cust);
        break;
        case 4: printMainMenu();
        break;
        
        }
    }

    
    /**
     * Edit existing customer's name
     * @ param c Customer to edit
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
     * @ param c Customer to edit
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
     * @ param c Customer to edit
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
     * Parse the edit item menu
     * @param n menu option 
     */
    private static void parseEditItemMenu(int n, Item it) {
        switch(n) {
        case 1: editName(it);
        break;
        case 2: editDescription(it);
        break;
        case 3: editCost(it);
        break;
        case 4: editPrice(it);
        break;
        case 5: editInventory(it);
        break;
        case 6: editQuantity(it);
        break;
        case 7: printMainMenu();
        break;       
        }
    }
    /**
     * edit name of item
     * @param it item to edit
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
     * edit description of item
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
     * edit cost of item
     * @param it item to edit
     */
    private static void editCost(Item it) {
        String head = ":::::::::::::::::::::::::::::::::::\n";
        String s = head + "Enter the Item Purchase Cost";
        double iCost = 0.0;
        while(iCost == 0.0) {
            iCost = validDouble(s);
        }
        it.setItemCost(iCost);
        printEditItemMenu();
        parseEditItemMenu(getMenuSel(), it);
    }
    /**
     * edit price of item
     * @param it item to edit
     */
    private static void editPrice(Item it) {
        String head = ":::::::::::::::::::::::::::::::::::\n";
        String s = head + "Enter the Item Selling Price";
        double iPrice = 0.0;
        while(iPrice == 0.0) {
            iPrice = validDouble(s);
        }
        it.setItemPrice(iPrice);
        printEditItemMenu();
        parseEditItemMenu(getMenuSel(), it);
    }
    /**
     * edit name of inventory
     * @param it item to edit
     */
    private static void editInventory(Item it) {
        String head = ":::::::::::::::::::::::::::::::::::\n";
        String s = head + "Enter the Item Inventory Amount";
        int inv = 0;
        while(inv == 0) {
            inv = validNint(40, s);
        }
        it.setItemInv(inv);
        printEditItemMenu();
        parseEditItemMenu(getMenuSel(), it);
    }
    /**
     * edit quantity of item
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
     * Remove an existing Customer
     */
    private static void remCust(int n) {
        //TODO: Get user input for customer ID or
        //Select from list of customers - will need display list
        //System.out.println("Customer List length =:" + custList.size());
        Customer cust = printAllCustomers(0);
        custList.remove(cust);
        System.out.println("Customer #:" + cust.getCustID() 
                + " removed from the database\n");
        //System.out.println("Customer List length =:" + custList.size());
        printCustMenu();
    }
    /**
     * Edit an existing Customer
     */
    static void editCust() {
        //TODO: Get user input for customer ID or
        //Select from list of customers - will need display list
        Customer cust = printAllCustomers(0);
        printEditCustMenu();
        parseEditCustomerMenu(getMenuSel(), cust);
        
        
        
    }
    
    
    /**
     * Remove an existing Order
     */
    private static void remOrd(int n) {
        //TODO: Get user input for Order ID or
        //Select from list of Orders - will need display list
        Order ord = printAllOrders(0);
        orderList.remove(ord);
        System.out.println("Order #:" + ord.getOrderID() 
                + " removed from the database\n");
        //System.out.println("Customer List length =:" + custList.size());
        printOrderMenu();
        
    }
    /**
     * Edit an existing Order
     */
    static void editOrd() {
        //TODO: Get user input for Order ID or
        //Select from list of Orders - will need display list
        Order ord = printAllOrders(0);
        printEditOrderMenu(ord);
        parseEditOrderMenu(getMenuSel(), ord);
    }
    /**
     * Add a new Order to the Bakery Data
     */
    static void addOrd() {
        //TODO: fill in Order data to constructor here
        //Will need prompts and validation from user input
        Order ord = new Order();
        orderList.add(ord);
    }
    
    /**
     * Remove an existing Item
     */
    private static void remItem(int n) {
        //TODO: Get user input for Item ID or
        //Select from list of customers - will need display list
        Item it = printAllItems(0);
        itemList.remove(it);
        System.out.println("Item #:" + it.getItemID() 
                + " removed from the database\n");
        //System.out.println("Customer List length =:" + custList.size());
        printItemMenu();
        
    }
    /**
     * Edit an existing Customer
     */
    static void editItem() {
        //TODO: Get user input for customer ID or
        //Select from list of customers - will need display list
        Item it = printAllItems(0);
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
        + ":  4 - Main Menu                  :\n"
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
                ""
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
                ""
        + "::::::  Edit Customer Menu  :::::\n"
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
     * print for view order menu
     * @param ord Order selected
     */
    static void printViewOrderMenu() {
        String s = 
                ""
        + "::::::  View Order Menu  :::::\n"
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
     * Add Customer Prompts - Prompts user for new Customer Data
     */
    static void addCustPrompts() {
        boolean lm = false;
        String s;
        int id = custList.size();
        String head = ":::::::::::::::::::::::::::::::::::\n";
        //TODO: Use size of arraylist to generate a user ID here
        s = head + "Enter Customer First Name         :";
        String fn = validString(40, s);
        s = head + "Enter Customer Middle Name        :";
        String mn = validString(40, s);
        s = head + "Enter Customer Last Name          :";
        String ln = validString(40, s);
        String loy = "";
        while (!loy.equals("Y") && !loy.equals("N")) {
            System.out.println(head + "Enroll the customer in the \n"
                    + "Loyalty Program?\n"
                    + "Enter Y for Yes, N for No");
            loy = validString(2, s);
            if (loy.equals("Y")) {
                lm = true;
            }
        }
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
        //TODO: Call makeNewCust(data...) here
        Customer cust = new Customer();
        custList.add(cust.makeNewCust(id, lm, fn, mn, ln, ad, city, state, 
                zip, pac, pex, pnum));
        ((Customer) custList.get(0)).printCust();
        printCustMenu();
    }
    /**
     * Add Item Prompts - Prompts user for new Item Data
     */
    static void addItemPrompts() {
        //TODO: Needs a lot of work
        int iID = itemList.size();
        String head = "Add an Item::::::::::::::::::::::::\n";
        String s = head + "Enter the Item Name";
        String iName = validString(40, s);
        s = head + "Enter the Item Category";
        String iCat = validString(40, s);
        s = head + "Enter the Item Purchase Cost";
        double iCost = 0.0;
        while(iCost == 0.0) {
            iCost = validDouble(s);
        }
        s = head + "Enter the Item Selling Price";
        double iPrice = 0.0;
        while(iPrice == 0.0) {
            iPrice = validDouble(s);
        }
        s = head + "Enter the Item Inventory Amount";
        int inv = 0;
        while(inv == 0) {
            inv = validNint(40, s);
        }
        s = head + "Enter the Item Order Quantity";
        int ordQuant = 0; 
        while (ordQuant == 0) {
            ordQuant = validNint(40, s);
        }
        
        Item it = new Item();
        itemList.add(it.makeItem(iID, iName, iCat, iCost, iPrice, inv, 
                ordQuant));
        ((Item) itemList.get(itemList.size() - 1)).printItem();
        printItemMenu();
    }
    /**
     * Add Order Prompts - Prompts user for new Order Data
     */
    static void addOrderPrompts() {
        //TODO: Needs a lot of work
        String s = "";
        int id = orderList.size();
        System.out.println("Add an Order");
        String head = ":::::::::::::::::::::::::::::::::::\n";
        Customer cust = new Customer();
        cust = printAllCustomers(0);
        Order ord = new Order();
        Scanner ob = new Scanner(System.in);
        String yORN;
        
        s = "Enter the Pickup date in the following format: MM/DD/YYYY";
        Date pickup = validDate(s);
        String comments = "";
        s = "Enter any additional comments for the order";
        comments = validString(200, s);
        ord = ord.makeOrder(cust, id, pickup, comments);
        //TODO fix while loop
       // while (!yORN.equals("e") || yORN.equals("E")) {
            s = "Press 1 to add from the inventory list\n"
                    + "Press 2 to add a new item to the inventory list";
            int choice = validNint(1, s);
            if (choice == 1) {
                //TODO print an inventory list from here and allow a choice of 
                //item, add an item to the order, add a quantity and dates/cust 
                //info also 
                //ADD TO BOTH custList AND orderList in customer class
                int i = printAllItems(0).getItemID();
                System.out.println("Enter Quantity");
                int q = ob.nextInt();
                ord.addItem(i, q);
                
            }       
            if (choice == 2) {
            //TODO add a new item to order form with quantity
            //ADD TO BOTH custList AND orderList in customer class
            }
       // System.out.println("Press E to end order. Any other"
       //         + " key to continue");
       // yORN = ob.nextLine();
        //System.out.println(yORN);
        //}
        
        //TODO Add items and quantities to order here
        
        orderList.add(ord);
        ArrayList<Order> custHist = cust.getCustOrdHist();
        custHist.add(ord);
        cust.setCustOrdHist(custHist);
        cust.printCust();
        System.out.println("Order Added::");
        ord.printOrder();
        printOrderMenu();
    }
    
    /**
     * 
     * Validate user input - n digit integers
     * Only accepting n digit integers
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
    static Date validDate(String msg) {
        Date date1 = new Date();
        try {
            
            String d = validString(11, msg);
            date1 = new SimpleDateFormat("MM/dd/yy").parse(d);
            System.out.println("You Entered:" + date1);
            
          } catch (ParseException e) {
            validDate(msg);
          }
        return date1;
    }
    
    
    static Customer printAllCustomers(int start) {
        int end = start + 10;
        String head = ":::::::::::::::::::::::::::::::::::::::::::::::::::\n";
        String s = head + head + "Choose a Customer\n";
        String colHead = "CustID Phone         Last Name  First Name  Address\n";
        System.out.println(s + colHead);
        for (int i = start; i < end; i++) {
            
            if (custList.size() - 1 >= i) {
                Customer current = custList.get(i);
                String custData = current.getCustID() + ",     "
                + current.getCustPhone() + "    "
                + current.getCustLastName() + ",  "
                + current.getCustFirstName() + ",  "
                + current.getCustAddress();
                System.out.println(custData);
            }
            
        }
        int choice = -1;
        while (choice == -1 || choice < start || choice > end) {
            choice = chooseFromList("CustID", "customer");
            if (choice == 999) {
                break;
            }
        }
        if (choice == 999) {
            return printAllCustomers(start + 10);
        }
        else {
            return parseCustChoice(choice);
        }
    }
    static Order printAllOrders(int start) {
        int end = start + 10;
        String head = ":::::::::::::::::::::::::::::::::::::::::::::::::::\n";
        String s = head + head + "Choose an Order\n";
        String colHead = "OrderID";
        System.out.println(s + colHead);
        for (int i = start; i < end; i++) {
            
            if (orderList.size() - 1 >= i) {
                Order ord = orderList.get(i);
                String custData = ord.getCustID() + ",     "
                + ord.getCustLastName() + ",  "
                + ord.getCustAddress();
                System.out.println(custData);
            }
            
        }
        int choice = -1;
        while (choice == -1 || choice < start || choice > end) {
            choice = chooseFromList("OrderID", "customer");
            if (choice == 999) {
                break;
            }
        }
        if (choice == 999) {
            return printAllOrders(start + 10);
        }
        else {
            return parseOrderChoice(choice);
        }
    }
    static Item printAllItems(int start) {
        int end = start + 10;
        String head = ":::::::::::::::::::::::::::::::::::::::::::::::::::\n";
        String s = head + head + "Choose an Item\n";
        String colHead = "ItemID";
        System.out.println(s + colHead);
        for (int i = start; i < end; i++) {
            
            if (itemList.size() - 1 >= i) {
                Item it = itemList.get(i);
                String itemData = it.getItemID() + ",     "
                + it.getItemName() + ",  "
                + it.getItemDesc();
                System.out.println(itemData);
            }
            
        }
        int choice = -1;
        while (choice == -1 || choice < start || choice > end) {
            choice = chooseFromList("ItemID", "item");
            if (choice == 999) {
                break;
            }
        }
        if (choice == 999) {
            return printAllItems(start + 10);
        }
        else {
            return parseItemChoice(choice);
        }
    }
    static int chooseFromList(String s1, String s2) {
        String s = "Enter " + s1 + " to choose a " + s2 + 
                ", 999 to view next page";
        return validNint(5, s);
    }
    static void makeCustListEx() {
        Customer c = new Customer();
        for (int i = 0; i < 103; i++) {
            custList.add(c.makeNewCust(i, false, "Nick", "A", "Scheuring" + i, 
                    "15 Winter Street", 
                    "Salem", "MA", "01970", 978, 530, 1234));
        }
    }
    static void makeOrderListEx() {
        Order c = new Order();
        for (int i = 0; i < 103; i++) {
            orderList.add(c.makeOrder(custList.get(i), i, new Date(), "Comm"));
        }
    }
    static void makeItemListEx() {
        Item c = new Item();
        for (int i = 0; i < 103; i++) {
            itemList.add(c.makeItem(i, "Namen" + i, "Category" + i, 
                    i + 1, i + 2, i + 3, i + 4));
        }
    }
    
    static void openOrderFile() {
        try {
            Scanner orderFile = new Scanner(ORDERFILE).useDelimiter("\\t");
            
            //System.out.println("Order File Contents:::::::::::::");
            String head = orderFile.nextLine();
            //System.out.println("Order Head::" + head);
            int custID, ordID, bakeID, quant;
            custID = ordID = bakeID = quant = 0;
            String lastName, address, city, state, zip, paid, itName, itCat = "";
            lastName = address = city = state = zip = paid = itName = itCat = "";
            double price, total, discUsed, totDue, availDisc;
            price = total = discUsed = totDue = availDisc = 0.0;
            Date ordDate = new Date();
            Date pickupDate = new Date();
            boolean curLoy = false;
            
            while (orderFile.hasNextLine()) {
                if (orderFile.hasNextInt()) {
                    custID = orderFile.nextInt();
                }
                if (orderFile.hasNext()) {
                lastName = orderFile.next();
                }
                if (orderFile.hasNext()) {
                    address = orderFile.next();
                }
                if (orderFile.hasNext()) {
                    city = orderFile.next();
                }
                if (orderFile.hasNext()) {
                    state = orderFile.next();
                }
                if (orderFile.hasNext()) {
                    zip = orderFile.next();
                }
                if (orderFile.hasNextInt()) {
                    ordID = orderFile.nextInt();
                }
                if (orderFile.hasNext()) {
                    paid = orderFile.next();
                }
                if (orderFile.hasNext()) {
                    //ordDate = orderFile.next();
                    String temp1 = orderFile.next();
                }
                if (orderFile.hasNext()) {
                    //pickupDate = orderFile.next();
                    String temp2 = orderFile.next();
                }
                if (orderFile.hasNextInt()) {
                    bakeID = orderFile.nextInt();
                }
                if (orderFile.hasNext()) {
                    itName = orderFile.next();
                }
                if (orderFile.hasNext()) {
                    itCat = orderFile.next();
                }
                if (orderFile.hasNextInt()) {
                    quant = orderFile.nextInt();
                }
                if (orderFile.hasNextDouble()) {
                    price = orderFile.nextDouble();
                }
                if (orderFile.hasNextDouble()) {
                    total = orderFile.nextDouble();
                }
                if (orderFile.hasNextDouble()) {
                    discUsed = orderFile.nextDouble();
                }
                if (orderFile.hasNextDouble()) {
                    totDue = orderFile.nextDouble();
                }
                if (orderFile.hasNextDouble()) {
                    availDisc = orderFile.nextDouble();
                }
                if (orderFile.hasNextBoolean()) {
                    curLoy = orderFile.nextBoolean();
                }
//                System.out.println("ID=" + custID + " ::lastName=" + lastName 
//                        + " ::Address=" + address + " ::state=" + state
//                        + " ::Zip=" + zip + " ::orderID=" + ordID + 
//                        " ::Paid?=" + paid + " ::orderDate=" + ordDate
//                        + " ::pickupDate=" + pickupDate
//                        + " ::BakeryID=" + bakeID + " ::BakeryItName=" + itName
//                        + " ::BakeryItemCat=" + itCat + " ::Quantity=" + quant
//                        + " ::Price=" + price + " ::Total=" + total 
//                        + " ::DiscountUsed=" + discUsed + " ::totalDue=" + totDue
//                        + " ::AvailDiscount=" + availDisc + " ::CurrentLoyalty=" 
//                        + curLoy + "\n");
                orderFile.nextLine();
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static void openBakeryFile() {
        Scanner bakeryFile;
        try {
            bakeryFile = new Scanner(BAKERYFILE).useDelimiter("\\t");
            //System.out.println("BakeryItems File Contents:::::::::::::");
            String head = bakeryFile.nextLine();
            //System.out.println("HEAD::" + head);
            
            int id = 0;
            String name, cat;
            name = cat = "yyy";
            double price = 0.0;
            
            if (bakeryFile.hasNextInt()) {
                id = bakeryFile.nextInt();
            }
            int idUpdate = id;
            while(bakeryFile.hasNextLine()) {
                id = idUpdate;
                //System.out.println("id ::" + id);
                if (bakeryFile.hasNext()) {
                    name = bakeryFile.next();
                    //System.out.println("nam::" + name);
                }
                if (bakeryFile.hasNext()) {
                    cat = bakeryFile.next();
                    
                    //System.out.println("cat::" + cat);
                }
                if (bakeryFile.hasNext()) {
                    String temp = bakeryFile.next();
                    String dub, strID;
                    dub = strID = "999999999";
                    
                    for(int i = 0; i < temp.length(); i++) {
                        if(temp.charAt(i) == '\n') {
                            dub = temp.substring(0, i);
                            price = Double.parseDouble(dub);
                            if (temp.length() == dub.length()) {
                                strID = temp.substring(i + 1);
                                idUpdate = Integer.valueOf(strID);
                            }
                        }
                    }
                    //System.out.println("pri::" + dub);
                }
                itemList.add(new Item(id, name, cat, price));
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        catch (InputMismatchException e) {
            System.out.println("Error on Input");
        }
        
        
    }
    static void saveFile() {
        
    }
    /**
     * parse edit ORder menu
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
        }
            
    }
    /**
     * parse view Order menu
     */
    static void parseViewOrderMenu(int n) {
        Scanner sc = new Scanner(System.in);
        String s;
        Date d;
        ArrayList<Order> newOrd = new ArrayList<Order>();
        switch(n) {
        case 1:
            int id = printAllCustomers(0).getCustID();
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getCustID() == id) {
                    newOrd.add(orderList.get(i));
                }
            }
            orderViewHelp(newOrd);

            break;
        case 2:
            s = "Enter the desired date in the following format: MM/DD/YYYY";
            d = validDate(s);
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getOrdDate() == d) {
                    newOrd.add(orderList.get(i));
                }
            }
            orderViewHelp(newOrd);

            break;
        
        case 3:
            s = "Enter the desired date in the following format: MM/DD/YYYY";
            d = validDate(s);
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getOrdDatePickup() == d) {
                    newOrd.add(orderList.get(i));
                }
            }
            orderViewHelp(newOrd);

            break;
        case 4:
            Item it = printAllItems(0);
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getOrdItems().containsKey(it.getItemID())) {
                    newOrd.add(orderList.get(i));
                }
            }
            orderViewHelp(newOrd);
            break;
        
        case 5:
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).isPaid() == false) {
                    newOrd.add(orderList.get(i));
                }
            }
            orderViewHelp(newOrd);
            break;
        case 6: 
            printOrderMenu();
            break;
        }
        
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
}