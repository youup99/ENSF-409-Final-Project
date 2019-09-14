package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Communicator;
import views.GenerateOrderView;
import views.MainView;

/**
 * This class is responsible for controlling the generate new order view button.
 * 
 * @author kiernan mcguigan, Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class GenOrderListener extends MainViewController implements ActionListener {
	public GenOrderListener(MainView view, Communicator communicator) {
		super(view, communicator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GenerateOrderView gov = new GenerateOrderView();
		GenerateOrderController goc = new GenerateOrderController(gov, communicator,gov.getCart());
		goc.addListeners();
		gov.setVisible(true);
	}
}
