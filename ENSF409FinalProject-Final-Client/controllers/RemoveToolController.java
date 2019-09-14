package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Functionality.Tool;
import client.Communicator;
import views.RemoveToolView;

/**
 * This class is the controller for the RemoveToolView GUI.
 * @author Ethan Rigby
 * @since March 31, 2019
 */
public class RemoveToolController {


	/**
	 * Connects to the view class.
	 */
	private RemoveToolView view;
	
	/**
	 * This is the I/O stream that the controller should use to communicate.	
	 */
	private Communicator communicator;
	
	/**
	 * Constructor for RemoveToolController
	 * @param v the view (GUI).
	 */
	public RemoveToolController(RemoveToolView v, Communicator com)  {
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
			String name = view.getTool();
			try {
				communicator.sendString("remove tool");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				communicator.sendString(name);
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
						Tool removed = communicator.getTool();
						JOptionPane.showMessageDialog(view, "Tool successfully removed.");
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
