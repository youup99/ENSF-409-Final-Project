package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import Functionality.Supplier;
import Functionality.Tool;
import client.Communicator;
import views.GenerateOrderView;
import views.AddSupplierView;
import views.AddToolView;
import views.MainView;
import views.RemoveSupplierView;
import views.RemoveToolView;
import views.SearchSupplierView;
import views.SearchToolView;
import views.SellView;

/**
 * This class is responsible for controlling the buttons that manage the
 * MainView buttons.
 * 
 * @author kiernan mcguigan, Ethan Rigby
 * @sine March 31, 2019
 */
public class MainViewController {
	/**
	 * The main view which is controlled by this class.
	 */
	protected MainView view;
	/**
	 * This is the I/O stream that the controller should use to communicate.
	 */
	protected Communicator communicator;

	/**
	 * Constructor that instantiates the view controller.
	 * 
	 * @param view is the view to initialize the controller with.
	 */
	public MainViewController(MainView view, Communicator communicator) {
		this.view = view;
		this.communicator = communicator;
	}

	/**
	 * This method adds all the action listeners to the buttons in the main view.
	 */
	public void addListeners() {
		view.getMainViewMenu().addSellListener(new SaleListener(view, communicator));
		view.getMainViewMenu().addGenOrderListener(new GenOrderListener(view, communicator));
		view.getMainViewMenu().addShowToolsListener(new ShowToolsListener(view, communicator));
		view.getMainViewMenu().addShowSuppliersListener(new ShowSuppliersListener(view, communicator));
		view.getMainViewMenu().addToolButtonListener(new AddToolListener(view, communicator));
		view.getMainViewMenu().addSupplierButtonListener(new AddSupplierListener(view, communicator));
		view.getMainViewMenu().removeAToolButtonListener(new RemoveToolListener(view, communicator));
		view.getMainViewMenu().removeASupplierButtonListener(new RemoveSupplierListener(view, communicator));
		view.getMainViewMenu().searchToolButtonListener(new SearchToolListener(view, communicator));
		view.getMainViewMenu().searchSupplierButtonListener(new SearchSupplierListener(view, communicator));
	}
}
