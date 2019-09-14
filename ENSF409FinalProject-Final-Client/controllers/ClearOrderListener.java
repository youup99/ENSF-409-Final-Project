package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import client.Communicator;
import views.GenerateOrderView;

/**
 * This class is responsible for controlling the clear order button.
 * 
 * @author Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class ClearOrderListener extends GenerateOrderController implements ActionListener {
	
	public ClearOrderListener(GenerateOrderView view, Communicator communicator, JTextArea cart) {
		super(view, communicator, cart);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.clearCart();
	}
}
