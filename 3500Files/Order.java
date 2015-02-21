import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
/**
 * Order Class for the Bakery Program
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @author Justin Bosma - bosma.j@husky.neu.edu - u/n bosmaj
 * @version Jun 18, 2014
 */
public class Order {
    //The unique ID for each Order (PK)
    private int orderID; 
    //The items in this order {HashMap(ItemID, quantity)}
    private HashMap<Integer, Integer> ordItems;
    private Customer customer;
    
    private Date ordDate; //The date the order is placed
    //The date the order will be available for pick up
    private Date ordDatePickup;
    private Time ordTime; //The time the order is placed
    //The time the order will be available for pick up
    private Time ordTimePickup;
    private String ordComments; //Additional Comments for this order

    private int ordQuantity; //Total Quantity of items in order
    private double ordSubTotal; //Gross Price of Items in Order
    private double ordTax; //Applicable Tax
    private double ordDiscountUsedOnOrder;
    private double ordTotal; //The total price of this order
    private double availableDiscount; //Is a Discount available?
    private double loyalty;
    private boolean paid; //Has the balance been payed for this order
    
    /**
     * 
     * Constructor for Order Class
     */
    public Order() {
        this.ordItems = new HashMap<Integer, Integer>();
        this.customer = new Customer();
        this.ordTotal = 0.0;
    }
    /**
     * 
     * Constructor for Order class
     * @param cust - the customer
     * @param id - the order id
     * @param pu - the pickup date
     * @param com - the order comments
     */
    public Order(Customer cust, int id, Date pu, String com) {
        this.orderID = id;
        //this.ordItems = new HashMap<Integer, Integer>();

        this.ordDate = new Date(); //The date the order is placed
      //The date the order will be available for pick up
        this.ordDatePickup = pu; 
        this.ordComments = com; //Additional Comments for this order
        this.customer = cust;
        
        this.ordQuantity = 0;
        this.ordSubTotal = 0.00;
        this.ordTax = 0.00;
        this.ordDiscountUsedOnOrder = 0.00;
        this.ordTotal = 0.00;
        this.availableDiscount = 0.00;
        this.paid = true;
        
    }
    /**
     * 
     * Constructor for Order class
     * @param cust - the order customer
     * @param oid - the order id
     * @param paid - the order paid boolean
     * @param orderDate - the order date
     * @param pickupDate - the order pickupdate
     * @param it - the order item
     * @param quantity - the order item quantity
     * @param price - the order item price
     * @param total - the order subtotal
     * @param discountUsedOnOrder - the order discount used
     * @param totalDue - the order total due
     * @param availableDiscount - the customers available discount
     * @param currentLoyalty - the order 
     */
    public Order(Customer cust, int oid, boolean paid, Date orderDate,
            Date pickupDate, Item it, int quantity, double price, double total,
            double discountUsedOnOrder, double totalDue,
            double availableDiscount, double currentLoyalty) {
        this.ordItems = new HashMap<Integer, Integer>();
        this.customer = cust;
        this.orderID = oid;
        this.paid = paid;
        this.ordDate = orderDate;
        this.ordDatePickup = pickupDate;
        this.addItem(it.getItemID(), quantity, price);
        
        this.ordSubTotal = total;
        this.ordDiscountUsedOnOrder = discountUsedOnOrder;
        this.ordTotal = totalDue;
        this.availableDiscount = availableDiscount;
        this.loyalty = currentLoyalty;
        
    }
    
    /** 
     * Gets the order id
     * @return the order ID
     */
    public int getOrderID() {
        return orderID;
    }
    /**
     * Sets the order id
     * @param orderID the new id
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    /**
     * Gets the order Item
     * @return the HashMap
     */
    public HashMap<Integer, Integer> getOrdItems() {
        return ordItems;
    }
    /**
     * Sets the order Item
     * @param ordItems the order items
     */
    public void setOrdItems(HashMap<Integer, Integer> ordItems) {
        this.ordItems = ordItems;
    }
    /**
     * Gets the order Date
     * @return the Date
     */
    public Date getOrdDate() {
        return ordDate;
    }
    /**
     * Sets the order Date
     * @param ordDate - the date
     */
    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }
    /**
     * Gets the order pickup date
     * @return the date
     */
    public Date getOrdDatePickup() {
        return ordDatePickup;
    }
    /**
     * Sets the order pickup date
     * @param ordDatePickup - the new date
     */
    public void setOrdDatePickup(Date ordDatePickup) {
        this.ordDatePickup = ordDatePickup;
    }
    /**
     * Gets the order time(deprecated)
     * @return the time
     */
    public Time getOrdTime() {
        return ordTime;
    }
    /**
     * Sets the order time
     * @param ordTime the new time (deprecated)
     */
    public void setOrdTime(Time ordTime) {
        this.ordTime = ordTime;
    }
    /**
     * Gets the order pickup time (deprecated)
     * @return the time
     */
    public Time getOrdTimePickup() {
        return ordTimePickup;
    }
    /**
     * Sets the order pickup time (deprecated)
     * @param ordTimePickup the time 
     */
    public void setOrdTimePickup(Time ordTimePickup) {
        this.ordTimePickup = ordTimePickup;
    }
    /**
     * Gets the order comments
     * @return the order comments
     */
    public String getOrdComments() {
        return ordComments;
    }
    /**
     * Sets the order comments
     * @param ordComments - the new comments
     */
    public void setOrdComments(String ordComments) {
        this.ordComments = ordComments;
    }
    /**
     * Gets the order quantity
     * @return the new quantity
     */
    public int getOrdQuantity() {
        return ordQuantity;
    }
    /**
     * Sets the order quantity
     * @param ordQuantity - the new quantity
     */
    public void setOrdQuantity(int ordQuantity) {
        this.ordQuantity = ordQuantity;
    }
    /**
     * Gets the order subtotal
     * @return the subtotal
     */
    public double getOrdSubTotal() {
        return ordSubTotal;
    }
    /**
     * Sets the order subtotal
     * @param ordSubTotal - the new subtotal
     */
    public void setOrdSubTotal(double ordSubTotal) {
        this.ordSubTotal = ordSubTotal;
    }
    /**
     * Gets the order tax(deprecated)
     * @return the tax
     */
    public double getOrdTax() {
        return ordTax;
    }
    /**
     * Sets the order tax (deprecated)
     * @param ordTax - the new tax
     */
    public void setOrdTax(double ordTax) {
        this.ordTax = ordTax;
    }
    /**
     * Gets the order discount used
     * @return the discount
     */
    public double getOrdDiscountUsedOnOrder() {
        return ordDiscountUsedOnOrder;
    }
    /**
     * Sets the order discount used
     * @param ordDiscountUsedOnOrder - the discount
     */
    public void setOrdDiscountUsedOnOrder(double ordDiscountUsedOnOrder) {
        this.ordDiscountUsedOnOrder = ordDiscountUsedOnOrder;
    }
    /**
     * Gets the order total
     * @return the total
     */
    public double getOrdTotal() {
        return ordTotal;
    }
    /**
     * Sets the order total
     * @param ordTotal - the new total
     */
    public void setOrdTotal(double ordTotal) {
        this.ordTotal = ordTotal;
    }
    /**
     * Gets the order available discount
     * @return the discount
     */
    public double getAvailableDiscount() {
        return availableDiscount;
    }
    /**
     * Sets the available discount
     * @param availableDiscount - the new available discount
     */
    public void setAvailableDiscount(double availableDiscount) {
        this.availableDiscount = availableDiscount;
    }
    /**
     * Gets the order paid boolean
     * @return the paid
     */
    public boolean getPaid() {
        return paid;
    }
    /**
     * sets the order paid boolean
     * @param paid - the new paid
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    /**
     * Gets the order customer (deprecated)
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }
    /**
     * Sets the order customer (deprecated)
     * @param customer - the new customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    //*******END GETTERS/SETTERS
    /**
     * Make a new order with the given fields
     * @param cust - the customer
     * @param id - the order ID
     * @param pu - the pickup date
     * @param com - the order comments
     * @return the order
     */
    public Order makeOrder(Customer cust, int id, Date pu, String com)  {
        return new Order(cust, id, pu, com) ;
    }
    /**
     * Make a new order with the given fields
     * @param cust - the customer
     * @param oid - the order id
     * @param pade - the paid boolean
     * @param orderDate - the order date
     * @param pickupDate - the pickup date
     * @param it - the item
     * @param quantity - the item quantity
     * @param price - the item price
     * @param total - the total for the items
     * @param discountUsedOnOrder - the discount used
     * @param totalDue - the total for the order
     * @param availDiscount - the avaiable discount
     * @param CurrentLoyalty - the current loyalty amount
     * @return - the new order
     */
    public Order makeOrder(Customer cust, int oid, boolean pade,
            Date orderDate, Date pickupDate, Item it,
            int quantity, double price, double total,
            double discountUsedOnOrder,
            double totalDue, double availDiscount, double CurrentLoyalty) {
        return new Order(cust, oid, pade, orderDate, pickupDate, it, quantity,
                price, total, discountUsedOnOrder, totalDue, 
                availDiscount, CurrentLoyalty);
    }
    /**
     * Prints Order data to the console
     */
    public void printOrder() {
        String s = ":::::::::::::::::::::::::::::::::::\n"
                +  "Order ID " + orderID + "\n"
                + "Customer " + customer.getCustLastName() + "\n"
                + "Date ordered " + ordDate + "\n"
                + "Pickup Date " + ordDatePickup + "\n"
                + "Total cost " + this.ordTotal + "\n";
        System.out.println(s);
        
    }
    /**
     * add item to ordItems
     * @param id - the item id
     * @param quantity - the item quantity
     * @param price - the item price
     */
    public void addItem(int id, int quantity, double price) {
//        System.out.println(ordItems.size());
        ordItems.put(id, quantity);
        this.ordTotal = this.ordTotal +
                (price * quantity);
    }
}