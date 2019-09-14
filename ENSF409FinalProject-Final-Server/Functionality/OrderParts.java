package Functionality;

import java.io.Serializable;

/**
 * This class contains all data and methods used by supplier
 * @author Youup Kim
 *
 */
public class OrderParts implements Serializable {

    /**
	 * Serial ID.	
	 */
	private static final long serialVersionUID = 1L;

	/**
     * This is the tool of the order part.
     */
    Tool tool;

    /**
     * This is the amount of the tool to order.
     */
    int amountToOrder;

    /**
     * Constructor.
     * @param t is the tool.
     * @param amountToOrder is the amount of tool to order.
     */
    public OrderParts(Tool t, int amountToOrder) {
        this.tool = t;
        this.amountToOrder = amountToOrder;
    }

    /**
     * This method displays the order part.
     */
    public void display() {
        System.out.println("\nItem name: 	" + tool.getName());
        System.out.println("Amount ordered:	" + amountToOrder);
        System.out.println("Supplier:	" + tool.getSupplier().toString());
        System.out.println("");
    }

    public Tool getTool() {
        return tool;
    }

    public int getAmountToOrder() {
        return amountToOrder;
    }

}