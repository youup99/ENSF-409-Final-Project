package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Communicator;
import views.AddToolView;
import views.MainView;

/**
 * This class is responsible for controlling the add tool view button.
 * 
 * @author Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class AddToolListener extends MainViewController implements ActionListener {
	
	public AddToolListener(MainView view, Communicator communicator) {
		super(view, communicator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AddToolView atv = new AddToolView();
		AddToolController atc = new AddToolController(atv, communicator);
		atc.addListeners();
		atv.setVisible(true);
	}
}