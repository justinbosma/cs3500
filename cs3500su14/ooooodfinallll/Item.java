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
    

    //Default constructor
    public Item() {
        
    }
public Item(int id, String name, String cat, double price) {
        this.itemID = id;
        this.itemName = name;
        this.itemDesc = cat;
        this.itemPrice = price;
    }
    
    public int getItemInv() {
        return itemInv;
    }

    public void setItemInv(int itemInv) {
        this.itemInv = itemInv;
    }

    /**
     * Constructor for Item class
     * Creates new Bakery menu items
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
    public Item makeItem(int iID, String iName, String iDesc, 
            double iCost, double iPrice, int inv, int ordQuant) {
        return new Item(iID, iName, iDesc, iCost, iPrice, inv, ordQuant);
    }
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