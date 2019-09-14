package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Functionality.Tool;
import client.Communicator;
import views.SearchToolView;

/**
 * The controller class responsible for controlling the view to search for tool.
 * 
 * @author Kiernan McGuigan
 *
 *@since April 2, 2019
 */
public class SearchToolController {
	/**
	 * This is the view that this controller controls.
	 */
	private SearchToolView view;
	/**
	 * This is the communicator the controller communicates to the server over.
	 */
	private Communicator communicator;

	/**
	 * This is the constructor for the controller of the search supplier
	 * functionality.
	 * 
	 * @param view is the view to have this controller control.
	 */
	public SearchToolController(SearchToolView view, Communicator communicator) {
		this.view = view;
		this.communicator = communicator;
	}

	/**
	 * This method adds the listeners.
	 */
	public void addListeners() {
		view.setSearchListener(new SearchToolListener());
	}

	class SearchToolListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String search = view.getSearchFeild();
			String returnString = null;
			try {
				communicator.sendString("search tool");
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
				if (returnString.contentEquals("added")) {
					try {
						Tool tool = communicator.getTool();
						JOptionPane.showMessageDialog(view, "Tool Name: " + tool.getName() + "\n"
								+ "Tool ID: " + tool.getID() + "\n"
										+ "Tool Supplier: " + tool.getSupplier() + "\n"
												+ "Tool Price: " + tool.getPrice() + "\n"
														+ "Tool Quantity: " + tool.getQuantity());
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
