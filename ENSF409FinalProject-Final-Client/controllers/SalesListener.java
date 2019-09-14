package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Communicator;
import views.MainView;
import views.SellView;

/**
 * This class is responsible for controlling the sell view button.
 * 
 * @author kiernan mcguigan, Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class SaleListener extends MainViewController implements ActionListener {
	public SaleListener(MainView view, Communicator communicator) {
		super(view, communicator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SellView sv = new SellView();
		SellViewController svc = new SellViewController(sv, communicator,sv.getCart());
		svc.addListeners();
		sv.setVisible(true);
	}
}

