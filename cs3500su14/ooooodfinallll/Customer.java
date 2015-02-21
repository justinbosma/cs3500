import java.util.ArrayList;


public class Customer {
    private int custID;
    //The unique ID for each customer (PK)
    private boolean loyaltyMember;
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
    static ArrayList<Order> orderList;
    //Customer Order History {ArrayList(OrdID)}
    double custBalance;
    //Customer Billing Balance
    /**
     * 
     * Constructor for Customer Class
     */
    public Customer() {
        
    }
    /**
     * 
     * Constructor for Customer Class
     */
    public Customer(int id, boolean lm, String fn, String mn, String ln, 
            String ad, String city, String state, String zip, int pac, int pex, int pnum) {
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
        this.orderList = new ArrayList<Order>();
        this.custBalance = 0;
        //printCust();
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
     */
    public void setCustID(int custID) {
        this.custID = custID;
    }
    /**
     * Get the Loyalty Membership Status
     * returns the status true if member/false if not
     */
    public boolean isLoyaltyMember() {
        return loyaltyMember;
    }
    /**
     * Set the Loyalty Membership status
     */
    public void setLoyaltyMember(boolean loyaltyMember) {
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
     */
    public void setCustPhoneNum(int custPhoneNum) {
        this.custPhoneNum = custPhoneNum;
    }
    /**
     * Get the Customer Order History
     * @return the ArrayList of Order
     */
    public ArrayList<Order> getCustOrdHist() {
        return orderList;
    }
    /**
     * Set the Customer Order History
     * (Add an entire ArrayList)
     */
    public void setCustOrdHist(ArrayList<Order> custOrdHist) {
        this.orderList = custOrdHist;
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
     */
    public void setCustBalance(double custBalance) {
        this.custBalance = custBalance;
    }
    public String getCustState() {
        return custState;
    }
    public void setCustState(String custState) {
        this.custState = custState;
    }
    public static ArrayList<Order> getOrderList() {
        return orderList;
    }
    public static void setOrderList(ArrayList<Order> orderList) {
        Customer.orderList = orderList;
    }
    //END GETTERS/SETTERS
    /**
     * Make a new Customer
     * Calls Constructor for Customer class and populates fields
     * @param id - the Customer ID
     * @param lm - Loyalty Membership status - true if member/false if not
     * @param fn - the Customer First Name
     * @param mn - the Customer Middle Name
     * @param ln - the Customer Last Name
     * @param ad - the Customer Address
     * @param city - the Customer City
     * @param zip - the Customer ZIP code
     * @param pac - the Customer Phone Area Code
     * @param pex - the Customer Phone Exchange
     * @param pnum - the Customer Phone Number
     * @return - the New Customer 
     */
    public Customer makeNewCust(int id, boolean lm, String fn, String mn, 
            String ln, String ad, String city, String state, String zip, int pac, 
            int pex, int pnum) {
        return new Customer(id, lm, fn, mn, ln, 
                ad, city, state, zip, pac, pex, pnum);
    }
    public void printCust() {
        String s = "::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
                + "Customer ID:          " + getCustID() + "\n"
                + "Loyalty Member:       " + isLoyaltyMember() + "\n"
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
