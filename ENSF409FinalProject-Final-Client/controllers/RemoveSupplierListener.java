package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Communicator;
import views.MainView;
import views.RemoveSupplierView;

/**
 * This class is responsible for controlling the remove supplier view button.
 * 
 * @author Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class RemoveSupplierListener extends MainViewController implements ActionListener {
	
	public RemoveSupplierListener(MainView view, Communicator communicator) {
		super(view, communicator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RemoveSupplierView rsv = new RemoveSupplierView();
		RemoveSupplierController rsc = new RemoveSupplierController(rsv, communicator);
		rsc.addListeners();
		rsv.setVisible(true);
	}
}
