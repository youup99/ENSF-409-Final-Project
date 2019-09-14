package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Functionality.Order;
import client.Communicator;
import views.AddItemToCartView;
import views.SellView;
/**
 * This class is responsible for the controllers for the buttons related to sell view.	
 * @author Kiernan McGuigan
 * @since April 2, 2019
 */
public class SellViewController {
	/**
	 * This is the view the controller controls.	
	 */
	private SellView view;
	/**
	 * This is the communicator the controller communicates to the server over.	
	 */
	private Communicator communicator;
	/**
	 * the order to be generated.
	 */
	private Order order;
	private JTextArea cart;

	/**
	 * Constructor that instantiates the view controller.	
	 * @param view is the view to initialize the controller with.	
	 */
	public SellViewController(SellView view, Communicator communicator, JTextArea cart) {
		this.view = view;
		this.communicator = communicator;
		order = new Order();
		this.cart = cart;
	}
	/**
	 * This method adds the listeners to the buttons in the view.	
	 */
	public void addListeners() {
		view.getSellViewMenu().addItemListener(new AddItemListener());
		view.getSellViewMenu().makeSaleListener(new MakeSaleListener());
		view.getSellViewMenu().clearCartListener(new ClearCartListener());
	}
	
	class AddItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			AddItemToCartView aitcv = new AddItemToCartView("Add Item to Cart");
			AddItemToCartController aitcc = new AddItemToCartController(aitcv,communicator,order,true,cart);
			aitcc.addListeners();
			aitcv.setVisible(true);
		}
	}
	class MakeSaleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				communicator.sendString("sell order");
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				communicator.sendOrder(order);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				String message = communicator.getString();
				JOptionPane.showMessageDialog(view, message);
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}	
			cart.setText("");

		}
	}
	class ClearCartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.clearCart();
		}
	}
}
