package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Functionality.Supplier;
import client.Communicator;
import views.AddSupplierView;

/**
 * This class is the controller for the AddSupplierView GUI.
 * @author Ethan Rigby
 * @since March 31, 2019
 */
public class AddSupplierController {

	/**
	 * Connects to the view class.
	 */
	private AddSupplierView view;
	
	/**
	 * This is the I/O stream that the controller should use to communicate.	
	 */
	private Communicator communicator;
	
	/**
	 * Constructor for AddSupplierController
	 * @param v the view (GUI).
	 */
	public AddSupplierController(AddSupplierView v, Communicator com)  {
		view = v;
		communicator = com;
	}
	
	/**
	 * Adds action listener.
	 */
	public void addListeners() {
		view.addCreateListener(new CreateListener());
	}
	
	class CreateListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			String returnString = null;
			try {
				communicator.sendString("add supplier");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String id = view.getID();
			String name = view.getName();
			String address = view.getAddress();
			String contact = view.getContact();
			Supplier newSupplier = new Supplier(id, name, address, contact);
			
			try {
				communicator.sendSupplier(newSupplier);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				returnString = communicator.getString();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			if (returnString != null) {
				if (returnString.contentEquals("added")) {
					try {
						newSupplier = communicator.getSupplier();
						JOptionPane.showMessageDialog(view, newSupplier.getName() + " successfully added!");
					} catch (ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(view, returnString);
				}
			}
			
		}
	}
}
