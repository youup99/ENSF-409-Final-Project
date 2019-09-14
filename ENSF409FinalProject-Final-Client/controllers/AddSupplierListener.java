package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Communicator;
import views.AddSupplierView;
import views.MainView;

/**
 * This class is responsible for controlling the add supplier view button.
 * 
 * @author Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class AddSupplierListener extends MainViewController implements ActionListener {
	
	public AddSupplierListener(MainView view, Communicator communicator) {
		super(view, communicator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AddSupplierView asv = new AddSupplierView();
		AddSupplierController asc = new AddSupplierController(asv, communicator);
		asc.addListeners();
		asv.setVisible(true);
	}
}
