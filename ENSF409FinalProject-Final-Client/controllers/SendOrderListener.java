package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import client.Communicator;
import views.GenerateOrderView;

/**
 * This class is responsible for controlling the send order item to generate order.
 * 
 * @author Kiernan McGuigan
 * @sine April 7, 2019, 2019
 */
class SendOrderListener extends GenerateOrderController implements ActionListener {
	
	public SendOrderListener(GenerateOrderView view, Communicator communicator, JTextArea cart) {
		super(view, communicator, cart);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			communicator.sendString("send order");
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

	}
}
