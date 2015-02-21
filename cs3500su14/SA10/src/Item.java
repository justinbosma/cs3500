/**
 * Item Class for Bakery Program
 * 
 * @author Nicholas Scheuring - scheuring.n@husky.neu.edu - u/n nscheu
 * @author Justin Bosma - bosma.j@husky.neu.edu - u/n bosmaj
 * @version Jun 18, 2014
 */
public class Item {
    private int itemID; 
    //The unique ID for each Item (PK) - BAKERYITEMID
    private String itemName;
    //The name of the item - BAKERYITEMNAME
    private String itemDesc;
    //A description of the item - CATEGORY
    private double itemCost;
    //The cost of the item to the Bakery
    private double itemPrice;
    //The price at which the Bakery sells the item - PRICE
    private int itemInv;
    //The number of available Items - the inventory number
    private int orderQuantity;
    //The number of Items being used in an order
    

    /**
     * Default constructor
     */
    public Item() {
        //empty constructor
    }
    /**
     * 
     * Constructor for Item Class
     * @param id - the item ID
     * @param name - the item name
     * @param cat - the item category/description
     * @param price - the item price
     */
    public Item(int id, String name, String cat, double price) {
        this.itemID = id;
        this.itemName = name;
        this.itemDesc = cat;
        this.itemPrice = price;
    }
    /**
     * Gets the item inventory amount
     * @return - the inventory amount
     */
    public int getItemInv() {
        return itemInv;
    }

    /**
     * Sets the item inventory to a given amount
     * @param itemInv - the given amount
     */
    public void setItemInv(int itemInv) {
        this.itemInv = itemInv;
    }

    /**
     * Constructor for Item class
     * Creates new Bakery menu items
     * @param iID the item ID
     * @param iName the item Name
     * @param iDesc the item category/description
     * @param iCost the item cost
     * @param iPrice the item price
     * @param inv the item inventory
     * @param ordQuant the item order quantity (deprecated)
     */
    public Item(int iID, String iName, String iDesc, 
            double iCost, double iPrice, int inv, int ordQuant) {
        this.itemID = iID;
        this.itemName = iName;
        this.itemDesc = iDesc;
        this.itemCost = iCost;
        this.itemPrice = iPrice;
        this.itemInv = inv;
        this.setOrderQuantity(ordQuant);
        
    }
    
    /**
     * Get Method for ItemID
     * @return the ItemID field Value
     */
    public int getItemID() {
        return itemID;
    }
    /**
     * Set Method for ItemID
     * @param itemID - the given item id
     */
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    /**
     * Get Method for ItemName
     * @return the ItemName field Value
     */
    public String getItemName() {
        return itemName;
    }
    /**
     * Set Method for ItemName
     * @param itemName - the given item name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    /**
     * Get Method for ItemDesc
     * @return the ItemDesc field Value
     */
    public String getItemDesc() {
        return itemDesc;
    }
    /**
     * Set Method for ItemDesc
     * @param itemDesc - the given item description
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
    /**
     * Get Method for ItemCost
     * @return the ItemCost field Value
     */
    public double getItemCost() {
        return itemCost;
    }
    /**
     * Set Method for ItemCost
     * @param itemCost - the given item cost
     */
    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }
    /**
     * Get Method for ItemPrice
     * @return the ItemPrice field Value
     */
    public double getItemPrice() {
        return itemPrice;
    }
    /**
     * Set Method for ItemPrice
     * @param itemPrice - the given item 
     */
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    /**
     * get method for order quantity
     * @return ordQuantity
     */
    public int getOrderQuantity() {
        return orderQuantity;
    }
    /**
     * set method for orderQuantity
     * @param orderQuantity integer
     */
    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
    //END GETTERS/SETTERS*********************************
    /**
     * Make a new Item
     * @param iID - the item ID
     * @param iName - the item name
     * @param iDesc - the item Description
     * @param iCost - the item cost
     * @param iPrice - the item price
     * @param inv - the item inventory
     * @param ordQuant - the item quantity (deprecated)
     * @return a new item!
     */
    public Item makeItem(int iID, String iName, String iDesc, 
            double iCost, double iPrice, int inv, int ordQuant) {
        return new Item(iID, iName, iDesc, iCost, iPrice, inv, ordQuant);
    }
    /**
     * Prints an item values to the console
     */
    public void printItem() {
        String s = ":::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
                + "Item ID #         :" + this.getItemID()
                + "\nItem Name         :" + this.getItemName()
                + "\nItem Category     :" + this.getItemDesc()
                + "\nItem Purchase Cost:" + this.getItemCost()
                + "\nItem Selling Price:" + this.getItemPrice()
                + "\nItem Inventory    :" + this.getItemInv()
                + "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::";
        System.out.println(s);
    }
}