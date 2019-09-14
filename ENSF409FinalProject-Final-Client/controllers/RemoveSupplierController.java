package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Functionality.Supplier;
import Functionality.Tool;
import client.Communicator;
import views.RemoveSupplierView;

/**
 * This class is the controller for the RemoveSupplierView GUI.
 * @author Ethan Rigby
 * @since March 31, 2019
 */
public class RemoveSupplierController {


	/**
	 * Connects to the view class.
	 */
	private RemoveSupplierView view;
	
	/**
	 * This is the I/O stream that the controller should use to communicate.	
	 */
	private Communicator communicator;
	
	/**
	 * Constructor for RemoveSupplierController
	 * @param v the view (GUI).
	 */
	public RemoveSupplierController(RemoveSupplierView v, Communicator com)  {
		view = v;
		communicator = com;
	}
	
	/**
	 * Adds action listener.
	 */
	public void addListeners() {
		view.addCreateListener(new RemoveListener());
	}
	
	class RemoveListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			String returnString = null;
			String search = view.getSupplier(); // = searchForTool
			try {
				communicator.sendString("remove supplier");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				communicator.sendString(search);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				returnString = communicator.getString();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			if (returnString != null) {
				if (returnString.contentEquals("removed")) {
					try {
						Supplier removed = communicator.getSupplier();
						JOptionPane.showMessageDialog(view, "Supplier successfully removed.");
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
