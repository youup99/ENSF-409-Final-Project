package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Communicator;
import views.MainView;
import views.SearchSupplierView;

/**
 * This class is responsible for controlling the search for supplier view button.
 * 
 * @author Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class SearchSupplierListener extends MainViewController implements ActionListener {
	
	public SearchSupplierListener(MainView view, Communicator communicator) {
		super(view, communicator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SearchSupplierView ssv = new SearchSupplierView();
		SearchSupplierController ssc = new SearchSupplierController(ssv, communicator);
		ssc.addListeners();
		ssv.setVisible(true);
	}
}