package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Communicator;
import views.MainView;
import views.SearchToolView;
/**
 * This class is responsible for controlling the search for tool view button.
 * 
 * @author Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class SearchToolListener extends MainViewController implements ActionListener {
	
	public SearchToolListener(MainView view, Communicator communicator) {
		super(view, communicator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SearchToolView stv = new SearchToolView();
		SearchToolController stc = new SearchToolController(stv, communicator);
		stc.addListeners();
		stv.setVisible(true);
	}
}