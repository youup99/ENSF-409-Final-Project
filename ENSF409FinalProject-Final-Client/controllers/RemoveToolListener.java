package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Communicator;
import views.MainView;
import views.RemoveToolView;

/**
 * This class is responsible for controlling the remove tool view button.
 * 
 * @author Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class RemoveToolListener extends MainViewController implements ActionListener {
	
	public RemoveToolListener(MainView view, Communicator communicator) {
		super(view, communicator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RemoveToolView rtv = new RemoveToolView();
		RemoveToolController rtc = new RemoveToolController(rtv, communicator);
		rtc.addListeners();
		rtv.setVisible(true);
	}
}
