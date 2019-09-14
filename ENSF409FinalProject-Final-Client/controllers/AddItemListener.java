package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import client.Communicator;
import views.AddItemToCartView;
import views.GenerateOrderView;

/**
 * This class is responsible for controlling the Add item to generate order.
 * 
 * @author Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class AddItemListener extends GenerateOrderController implements ActionListener {
	
	public AddItemListener(GenerateOrderView view, Communicator communicator, JTextArea cart) {
		super(view, communicator, cart);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AddItemToCartView aitcv = new AddItemToCartView("Add Item to Order");
		AddItemToCartController aitcc = new AddItemToCartController(aitcv,communicator,order,false,cart);
		aitcc.addListeners();
		aitcv.setVisible(true);
	}
}
