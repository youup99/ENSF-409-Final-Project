package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Functionality.Order;
import Functionality.Tool;
import client.Communicator;
import views.AddItemToCartView;
/**
 * This is the controller to add items to the cart.
 * @author Kiernan McGuigan
 *@since April 2, 2019
 *
 */
public class AddItemToCartController {
	/**
	 * This is the view that this controller controls.	
	 */
	private AddItemToCartView view;
	/**
	 * This is the communicator the controller communicates to the server over.	
	 */
	private Communicator communicator;
	/**
	 * This is the order we will be 
	 */
	private Order order;
	/**
	 * If this item requires the given stock to add.	
	 */
	private Boolean requiresStock;
	private JTextArea cart;
	/**
	 * This is the constructor for the controller of the search supplier functionality.	
	 * @param view is the view to have this controller control.	
	 */
	public AddItemToCartController(AddItemToCartView view, Communicator communicator, Order order, Boolean requiresStock, JTextArea cart) {
		this.view = view;
		this.communicator = communicator;
		this.order = order;
		this.requiresStock = requiresStock;
		this.cart = cart;
	}
	/**
	 * This method adds the listeners.	
	 */
	public void addListeners() {
		view.addToCartListener(new addItemToCartListener());
	}
	//Note this class gets reused in add tool to cart and add tool to order
	class addItemToCartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String toolStr = view.getSearchField();
			Integer quantity = Integer.parseInt(view.getQuantity());
			System.out.println(quantity);
			String returnString = null;
			try {
				if(requiresStock) {
					communicator.sendString("add tool to cart");
				}else {
					communicator.sendString("add tool to order");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				communicator.sendString(toolStr);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				communicator.sendInteger(quantity);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				returnString = communicator.getString();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			if(returnString != null) {
				if(returnString.contentEquals("added")) {
					try {
						Tool tool = communicator.getTool();
						order.addOrderPart(tool, quantity);
						String data = tool.getID()+" "+tool.getName()+" "+tool.getQuantity() + " " + tool.getPrice();
						cart.append(data);
						JOptionPane.showMessageDialog(view, order + " successfully added!");
					} catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, returnString);
				}
			}else {
				System.err.println("Error, return String null");
			}
		}
	}
}
