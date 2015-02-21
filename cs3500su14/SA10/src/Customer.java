
import java.util.HashMap;

/**
 * Customer Class for Bakery Program
 * Stores customer data
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @author Justin Bosma - bosma.j@husky.neu.edu - u/n bosmaj
 * @version Jun 18, 2014
 */
public class Customer {
    private int custID;
    //The unique ID for each customer (PK)
    private double loyaltyMember;
    //Is the Customer a Loyalty Card Member?
    private String custFirstName;
    //First Name
    private String custMidName;
    //Middle Name
    private String custLastName;
    //Last Name
    private String custAddress;
    //Street Address
    private String custCity;
    //City
    private String custState;
    //State
    private String custZIP;
    //Zip Code
    private int custPhoneAC;
    //Phone Area Code (3 digits)
    private int custPhoneEX;
    //Phone Exchange (3 digits)
    private int custPhoneNum;
    //Phone Number (4 digits)
    /**
     * Hashmap stores customer order history
     */
    static HashMap<Integer, Order> orderList;
    /**
     * Customer Balance
     */
    double custBalance;

    /**
     * 
     * Constructor for Customer Class
     */
    public Customer() {
        // empty constructor
    }
    /**
     * Constructor for Customer Class
     * @param id customer id
     * @param lm loyalty status
     * @param fn first name
     * @param mn middle name
     * @param ln last name
     * @param ad address
     * @param city the place
     * @param state where the city should be
     * @param zip the numbers
     * @param pac area code
     * @param pex first 3 of phone#
     * @param pnum last four of fone#
     */
    public Customer(int id, double lm, String fn, String mn, String ln, 
            String ad, String city, String state, String zip,
            int pac, int pex, int pnum) {
        this.custID = id;
        this.loyaltyMember = lm;
        this.custFirstName = fn;
        this.custMidName = mn;
        this.custLastName = ln;
        this.custAddress = ad;
        this.custCity = city;
        this.custState = state;
        this.custZIP = zip;
        this.custPhoneAC = pac;
        this.custPhoneEX = pex;
        this.custPhoneNum = pnum;
        orderList = new HashMap<Integer, Order>();
        this.custBalance = 0;

    }
    /**
     * Get the Customer ID
     * @return the ID
     */
    public int getCustID() {
        return custID;
    }
    /**
     * Set the Customer ID
     * @param custID customr id
     */
    public void setCustID(int custID) {
        this.custID = custID;
    }
    /**
     * Get the Loyalty Membership Status
     * returns the status true if member/false if not
     * @return number representation for loyalty
     */
    public double getLoyaltyMember() {
        return loyaltyMember;
    }
    /**
     * Set the Loyalty Membership status
     * @param loyaltyMember true if loyalty member
     */
    public void setLoyaltyMember(double loyaltyMember) {
        this.loyaltyMember = loyaltyMember;
    }
    /**
     * Get the Customer First Name
     * @return the First Name
     */
    public String getCustFirstName() {
        return custFirstName;
    }
    /**
     * Set the Customer First Name
     * @param custFirstName the first name
     */
    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }
    /**
     * Get the Customer Middle Name
     * @return the Middle Name
     */
    public String getCustMidName() {
        return custMidName;
    }
    /**
     * Set the Customer Middle Name
     * @param custMidName middle name
     */
    public void setCustMidName(String custMidName) {
        this.custMidName = custMidName;
    }
    /**
     * Get the Customer Last Name
     * @return the Last Name
     */
    public String getCustLastName() {
        return custLastName;
    }
    /**
     * Set the Customer Last Name
     * @param custLastName the last name
     */
    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }
    /**
     * Get the Customer Address
     * @return the Address
     */
    public String getCustAddress() {
        return custAddress;
    }
    /**
     * Set the Customer Address
     * @param custAddress the customers address
     */
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    /**
     * Get the Customer City
     * @return the City
     */
    public String getCustCity() {
        return custCity;
    }
    /**
     * Set the Customer City
     * @param custCity the city
     */
    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }
    /**
     * Get the Customer ZIP code
     * @return the ZIP
     */
    public String getCustZIP() {
        return custZIP;
    }
    /**
     * Set the Customer ZIP
     * @param custZIP the zip code
     */
    public void setCustZIP(String custZIP) {
        this.custZIP = custZIP;
    }
    /**
     * Get the Customer Phone Area Code
     * @return the Area Code
     */
    public int getCustPhoneAC() {
        return custPhoneAC;
    }
    /**
     * Set the Customer Phone Area Code
     * @param custPhoneAC the area code to fhone
     */
    public void setCustPhoneAC(int custPhoneAC) {
        this.custPhoneAC = custPhoneAC;
    }
    /**
     * Get the Customer Phone Exchange
     * @return the Exchange
     */
    public int getCustPhoneEX() {
        return custPhoneEX;
    }
    /**
     * Set the Customer Phone Exchange
     * @param custPhoneEX the phoone exchange
     */
    public void setCustPhoneEX(int custPhoneEX) {
        this.custPhoneEX = custPhoneEX;
    }
    /**
     * Get the Customer Phone Number
     * @return the Number
     */
    public int getCustPhoneNum() {
        return custPhoneNum;
    }
    /**
     * Get the Customer Phone Number
     * @return the Number
     */
    public String getCustPhone() {
        return this.custPhoneAC + "-" + this.custPhoneEX + "-" 
            + this.custPhoneNum;
    }
    /**
     * Set the Customer Phone Number
     * @param custPhoneNum the last 4 digits
     */
    public void setCustPhoneNum(int custPhoneNum) {
        this.custPhoneNum = custPhoneNum;
    }
    /**
     * Get the Customer Order History
     * @return the ArrayList of Order
     */
    public HashMap<Integer, Order> getCustOrdHist() {
        return orderList;
    }
    /**
     * Set the Customer Order History
     * @param custOrdHist the order history hashmap
     */
    public void setCustOrdHist(HashMap<Integer, Order> custOrdHist) {
        orderList = custOrdHist;
    }
    /**
     * Get the Customer Outstanding Balance
     * @return the Balance
     */
    public double getCustBalance() {
        return custBalance;
    }
    /**
     * Set the Customer Outstanding Balance
     * (Manual Override of calculation method)
     * @param custBalance what they owe
     */
    public void setCustBalance(double custBalance) {
        this.custBalance = custBalance;
    }
    /**
     * Gets the Customers State
     * @return the state
     */
    public String getCustState() {
        return custState;
    }
    /**
     * Sets the customer state field
     * @param custState the state to set the field to
     */
    public void setCustState(String custState) {
        this.custState = custState;
    }
    /**
     * Static method to return the customers order history
     * @return the orderList HashMap
     */
    public static HashMap<Integer, Order> getOrderList() {
        return orderList;
    }
    /**
     * Sets the Customers order history to a given HashMap
     * @param orderList the orderlist to set
     */
    public static void setOrderList(HashMap<Integer, Order> orderList) {
        Customer.orderList = orderList;
    }
    /**
     * Gets a printout of the customers contact information
     */
    public void getCustContact() {
        String s = "" + getCustFirstName() + " " + getCustMidName() + " " + 
            getCustLastName() + " " + getCustAddress() + " " +
            getCustCity() + " " + 
            getCustZIP() + " " + getCustPhone();
        System.out.println(s);
    }
    //END GETTERS/SETTERS
    /**
     * Make a new Customer
     * Calls Constructor for Customer class and populates fields
     * @param id - the Customer ID
     * @param lm - Loyalty Membership status 
     * @param fn - the Customer First Name
     * @param mn - the Customer Middle Name
     * @param ln - the Customer Last Name
     * @param ad - the Customer Address
     * @param city - the Customer City
     * @param state - the Customer state
     * @param zip - the Customer ZIP code
     * @param pac - the Customer Phone Area Code
     * @param pex - the Customer Phone Exchange
     * @param pnum - the Customer Phone Number
     * @return - the New Customer 
     */
    public Customer makeNewCust(int id, double lm, String fn, String mn, 
            String ln, String ad, String city, String state, String zip,
            int pac, int pex, int pnum) {
        return new Customer(id, lm, fn, mn, ln, 
                ad, city, state, zip, pac, pex, pnum);
    }
    /**
     * Prints the customer information to the console
     */
    public void printCust() {
        String s = "::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
                + "Customer ID:          " + getCustID() + "\n"
                + "Loyalty Member:       " + getLoyaltyMember() + "\n"
                + "Customer First Name:  " + getCustFirstName() + "\n"
                + "Customer Middle Name: " + getCustMidName() + "\n"
                + "Customer Last Name:   " + getCustLastName() + "\n"
                + "Customer Address:     " + getCustAddress() + "\n"
                + "Customer City:        " + getCustCity() + "\n"
                + "Customer ZIP Code:    " + getCustZIP() + "\n"
                + "Customer Phone:       " + getCustPhoneAC() + "-" 
                + getCustPhoneEX() + "-" + getCustPhoneNum() + "\n"
                + "Customer Balance:     " + getCustBalance() + "\n";
        System.out.println(s);
    }
}
