package Functionality;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * This class contains all the orders placed as well as keeping track of
 * dates and orderID
 * @author Youup Kim
 */
public class Order implements Serializable {

    /**
     * The Serializable ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID of the order.
     */
    String orderID;

    /**
     * Date the order is created.
     */
    Date date;

    /**
     * Order parts in the order.
     */
    ArrayList<OrderParts> orderParts;

    /**
     * If the order has been finalized, sent out.
     */
    boolean finalized;
    /**
     * 
     */
    boolean sellOrder = false;
    /**
     * if just fix is false add order to database otherwise don't and just adjust the tool quantities.	
     */
    boolean justFix = false;
    /**
     * Constructor.
     */
    public Order() {
        orderParts = new ArrayList<OrderParts> ();
        date = new Date();
        Random rand = new Random();
        orderID = Integer.toString(rand.nextInt(1000000)); // fix so no 2 r same
    }

    /**
     * This method adds an order part to the order.
     * @param t is the tool.
     * @param amountToOrder is the amount of tool t to order.
     */
    public void addOrderPart(Tool t, int amountToOrder) {
        orderParts.add(new OrderParts(t,amountToOrder));
    }
    /**
     * This method displays the order.
     */
    public void display() {
        System.out.println("\n*******************************************");
        System.out.printf("ORDER ID:	%5d\n", orderID);
        System.out.printf("DATE ORDERED:	%s\n\n\n", date.toString());
        for(OrderParts op : orderParts) {
            op.display();
        }
        System.out.println("*******************************************\n");
    }

    /**
     * This method finalizes the order.
     */
    public void finalizeOrder() {
        if(orderParts.isEmpty()) {
            System.err.println("Can't Finalize the Order as the Order is Empty!");
            return;
        }
        finalized = true;
    }

    /**
     * This method returns finalize variable.
     * @return finalized variable.
     */
    public boolean isFinalized() {
        return finalized;
    }

    /**
     * This method returns order id.
     * @return order id.
     */
    public String getOrderID() {
        return orderID;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<OrderParts> getOrderParts() {
        return orderParts;
    }

	public boolean isSellOrder() {
		return sellOrder;
	}

	public void setSellOrder(boolean sellOrder) {
		this.sellOrder = sellOrder;
	}

	public boolean isJustFix() {
		return justFix;
	}

	public void setJustFix(boolean justFix) {
		this.justFix = justFix;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setOrderParts(ArrayList<OrderParts> orderParts) {
		this.orderParts = orderParts;
	}

	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}
}