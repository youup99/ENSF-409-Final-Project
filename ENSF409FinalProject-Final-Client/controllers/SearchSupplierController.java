package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

import Functionality.Supplier;
import client.Communicator;
import views.SearchSupplierView;

/**
 * This class is responsible for controlling the view to search for a supplier.
 * 
 * @author Kiernan McGuigan
 *
 *@since April 2, 2019
 */
public class SearchSupplierController {

	/**
	 * This is the view that this controller controls.
	 */
	private SearchSupplierView view;
	/**
	 * This is the communicator the controller communicates to the server over.
	 */
	private Communicator communicator;

	/**
	 * This is the constructor for the controller of the search supplier
	 * functionality.
	 * 
	 * @param view is the view to have this controller control.
	 * @param communicator
	 */
	public SearchSupplierController(SearchSupplierView view, Communicator communicator) {
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
			String search = view.getSearchField();
			String returnString = null;
			try {
				communicator.sendString("search supplier");
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
						Supplier supplier = communicator.getSupplier();
						JOptionPane.showMessageDialog(view, "Supplier Name: " + supplier.getName() + "\n"
								+ "Supplier ID: " + supplier.getID() + "\n"
										+ "Supplier Address: " + supplier.getAddress() + "\n"
												+ "Supplier Contact: " + supplier.getSalesContact());
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
