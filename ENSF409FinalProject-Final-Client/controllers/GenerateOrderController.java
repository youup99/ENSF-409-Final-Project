package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Functionality.Order;
import client.Communicator;
import views.AddItemToCartView;
import views.GenerateOrderView;

/**
 * This class is responsible for controlling the generate order view.
 * 
 * @author Kiernan McGuigan
 *@since April 2, 2019.
 */
public class GenerateOrderController {
	/**
	 * This is the view the controller controls.
	 */
	protected GenerateOrderView view;
	/**
	 * This is the communicator the controller communicates to the server over.
	 */
	protected Communicator communicator;
	/**
	 * the order to be generated.
	 */
	protected Order order;
	/**
	 * Shows items in cart.
	 */
	protected JTextArea cart;

	/**
	 * Constructor that instantiates the view controller.
	 * 
	 * @param view is the view to initialize the controller with.
	 */
	public GenerateOrderController(GenerateOrderView view, Communicator communicator, JTextArea cart) {
		this.view = view;
		this.communicator = communicator;
		order = new Order();
		this.cart = cart;
	}

	/**
	 * This method adds the listeners to the buttons in the view.
	 */
	public void addListeners() {
		view.getGenerateOrderMenu().addItemListener(new AddItemListener(view, communicator, cart));
		view.getGenerateOrderMenu().sendOrderListener(new SendOrderListener(view, communicator, cart));
		view.getGenerateOrderMenu().clearOrderListener(new ClearOrderListener(view, communicator, cart));
	}
}
