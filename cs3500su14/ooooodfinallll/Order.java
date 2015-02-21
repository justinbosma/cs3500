import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Order {
    int orderID; //The unique ID for each Order (PK)
    HashMap<Integer, Integer> ordItems; //The items in this order {HashMap(ItemID, quantity)}
    Customer customer;
    Date ordDate; //The date the order is placed
    Date ordDatePickup; //The date the order will be available for pick up
    Time ordTime; //The time the order is placed
    Time ordTimePickup; //The time the order will be available for pick up
    String ordComments; //Additional Comments for this order

    int ordQuantity; //Total Quantity of items in order
    double ordSubTotal;//Gross Price of Items in Order
    double ordTax;//Applicable Tax
    double ordDiscountUsedOnOrder;
    double ordTotal; //The total price of this order
    boolean availableDiscount;//Is a Discount available?
    boolean paid; //Has the balance been payed for this order
    
    //CUSTOMER DATA ********************************
    int custID; //The Customer who is ordering
    String custZipCode;//Customers Zip Code
    String custLastName;//Customers Last Name
    String custAddress;//Customers Address
    String custCity;//Customers City
    String custState;//Customers State
    boolean custCurrentLoyalty;//Is the customer a Current Loyalty Member
    
    public Order() {
        
    }
    /**
     * 
     * Constructor for
     * @param cust
     * @param id
     * @param oi
     */
    public Order(Customer cust, int id, Date pu, String com) {
        this.orderID = id;
        this.ordItems = new HashMap<Integer, Integer>(); //The items in this order {ArrayList(ItemID)}
        this.ordDate = new Date(); //The date the order is placed
        this.ordDatePickup = pu; //The date the order will be available for pick up
        this.ordComments = com; //Additional Comments for this order
        this.customer = cust;
        
        this.ordQuantity = 0;
        this.ordSubTotal = 0.00;
        this.ordTax = 0.00;
        this.ordDiscountUsedOnOrder = 0.00;
        this.ordTotal = 0.00;
        this.availableDiscount = true;
        this.paid = true;
        
        //CUSTOMER DATA ********************************
        custID = cust.getCustID();
        custZipCode = cust.getCustZIP();
        custLastName = cust.getCustLastName();
        custAddress = cust.getCustAddress();
        custCity = cust.getCustCity();
        custState = cust.getCustState();
        custCurrentLoyalty = cust.isLoyaltyMember();
        
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public HashMap<Integer, Integer> getOrdItems() {
        return ordItems;
    }
    public void setOrdItems(HashMap<Integer, Integer> ordItems) {
        this.ordItems = ordItems;
    }
    public Date getOrdDate() {
        return ordDate;
    }
    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }
    public Date getOrdDatePickup() {
        return ordDatePickup;
    }
    public void setOrdDatePickup(Date ordDatePickup) {
        this.ordDatePickup = ordDatePickup;
    }
    public Time getOrdTime() {
        return ordTime;
    }
    public void setOrdTime(Time ordTime) {
        this.ordTime = ordTime;
    }
    public Time getOrdTimePickup() {
        return ordTimePickup;
    }
    public void setOrdTimePickup(Time ordTimePickup) {
        this.ordTimePickup = ordTimePickup;
    }
    public String getOrdComments() {
        return ordComments;
    }
    public void setOrdComments(String ordComments) {
        this.ordComments = ordComments;
    }
    public int getOrdQuantity() {
        return ordQuantity;
    }
    public void setOrdQuantity(int ordQuantity) {
        this.ordQuantity = ordQuantity;
    }
    public double getOrdSubTotal() {
        return ordSubTotal;
    }
    public void setOrdSubTotal(double ordSubTotal) {
        this.ordSubTotal = ordSubTotal;
    }
    public double getOrdTax() {
        return ordTax;
    }
    public void setOrdTax(double ordTax) {
        this.ordTax = ordTax;
    }
    public double getOrdDiscountUsedOnOrder() {
        return ordDiscountUsedOnOrder;
    }
    public void setOrdDiscountUsedOnOrder(double ordDiscountUsedOnOrder) {
        this.ordDiscountUsedOnOrder = ordDiscountUsedOnOrder;
    }
    public double getOrdTotal() {
        return ordTotal;
    }
    public void setOrdTotal(double ordTotal) {
        this.ordTotal = ordTotal;
    }
    public boolean isAvailableDiscount() {
        return availableDiscount;
    }
    public void setAvailableDiscount(boolean availableDiscount) {
        this.availableDiscount = availableDiscount;
    }
    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public int getCustID() {
        return custID;
    }
    public void setCustID(int custID) {
        this.custID = custID;
    }
    public String getCustZipCode() {
        return custZipCode;
    }
    public void setCustZipCode(String custZipCode) {
        this.custZipCode = custZipCode;
    }
    public String getCustLastName() {
        return custLastName;
    }
    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }
    public String getCustAddress() {
        return custAddress;
    }
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    public String getCustCity() {
        return custCity;
    }
    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }
    public String getCustState() {
        return custState;
    }
    public void setCustState(String custState) {
        this.custState = custState;
    }
    public boolean isCustCurrentLoyalty() {
        return custCurrentLoyalty;
    }
    public void setCustCurrentLoyalty(boolean custCurrentLoyalty) {
        this.custCurrentLoyalty = custCurrentLoyalty;
    }
    //*******END GETTERS/SETTERS
    public Order makeOrder(Customer cust, int id, Date pu, String com)  {
        return new Order(cust, id, pu, com) ;
    }
    public void printOrder() {
        String s = ":::::::::::::::::::::::::::::::::::\n"
                +  "Order ID " + orderID + "\n"
                + "Customer " + customer + "\n"
                + "Date ordered " + ordDate + "\n"
                + "Pickup Date " + ordDatePickup + "\n"
                + "Total cost " + ordTotal + "\n";
        System.out.println(s);
        
    }
    /**
     * add item to ordItems
     * @param it Item to add
     * 
     */
    public void addItem(int id, int quantity) {
        this.ordItems.put(id, quantity);
    }
}