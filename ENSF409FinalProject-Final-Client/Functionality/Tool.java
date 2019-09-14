package Functionality;

import java.io.Serializable;

/**This class all necessary information about the tool
 * @author Youup Kim
 */
public class Tool implements Serializable {
    /**
	 * serial id.	
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Id of the tool.
     */
    private String id;
    /**
     * Name of the tool.
     */
    private String name;
    /**
     * Quatity of the tool.
     */
    private int quantity;
    /**
     * Price of the tool.
     */
    private double price;
    /**
     * Supplier of this tool.
     */
    private String supplier;

    /**
     * Constructor.
     * @param id of the tool.
     * @param str name of the tool.
     * @param quantity of the tool.
     * @param price of the tool.
     */
    public Tool(String id, String str, int quantity, double price) {
        this.id = id;
        this.name = str;
        this.quantity = quantity;
        this.price = price;
    }
    /**
     * This method links the supplier of the tool.
     * @param s supplier to link to the tool.
     */
    public void linkSupplier(String s) {
        this.supplier = s;
    }

    /**
     * This method sells  quantity of tools.
     * @param numberToSell number of tools to sell.
     */
    public boolean sellQuantity(int numberToSell) {
        if(this.quantity < numberToSell) {
            System.err.println("Not Enough Stock To Complete This Sale");
            return false;
        }
        this.quantity = this.quantity - numberToSell;
        return true;
    }
    /**
     * Check stock.
     * @return number of stock to add to get to 50 if stock below 40.
     */
    public int lowStock(){
        if(this.quantity < 40) {
            return (50 - this.quantity);
        }
        return 0;
    }
    /**
     * This method displays the tool.
     */
    public void display() {
        System.out.println("ID: " + this.id);
        System.out.println("Tool: " + this.name);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Price: " + this.price);
        System.out.println("Supplier: " + this.supplier);
    }
    //getters and setters
    public String getID() {
        return id;
    }

    public String getSupplier() {
    	if (this.supplier != null)
    		return this.supplier;
    	return "0000";
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    }
    
    public void setSupplier(String supplierID) {
    	this.supplier = supplierID;
    }
}