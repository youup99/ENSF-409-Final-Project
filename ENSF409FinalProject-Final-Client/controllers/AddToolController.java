package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Functionality.Tool;
import client.Communicator;
import views.AddToolView;

/**
 * This class is the controller for the AddToolView GUI.
 * @author Ethan Rigby
 * @since March 31, 2019
 */
public class AddToolController {


	/**
	 * Connects to the view class.
	 */
	private AddToolView view;
	
	/**
	 * This is the I/O stream that the controller should use to communicate.	
	 */
	private Communicator communicator;
	
	/**
	 * Constructor for AddToolController.
	 * @param v the view (GUI).
	 */
	public AddToolController(AddToolView v, Communicator com)  {
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
				communicator.sendString("add tool");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String id = view.getID();
			String name = view.getName();
			double price = view.getPrice();
			Tool newTool = new Tool(id, name, 0, price);
			String supplier = view.getSupplier();
			
			try {
				communicator.sendTool(newTool);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				communicator.sendString(supplier);
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
						newTool = communicator.getTool();
						JOptionPane.showMessageDialog(view, newTool.getName() + " successfully added!");
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
