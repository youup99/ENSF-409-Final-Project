package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Functionality.Tool;
import client.Communicator;
import views.MainView;

/**
 * This class is responsible for controlling the Show Tool button.
 * 
 * @author kiernan mcguigan, Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class ShowToolsListener extends MainViewController implements ActionListener {
	public ShowToolsListener(MainView view, Communicator communicator) {
		super(view, communicator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultListModel<String> listModel = new DefaultListModel<>();
		try {
			communicator.sendString("get tools");
			try {
				ArrayList<Tool> allTools = communicator.getAllTools();
				view.getList().clearSelection();
				String top = String.format("%30s %25s %25s %20s %35s", "NAME", "ID", "PRICE", "QUANTITY", "SUPPLIER");
				listModel.addElement(top);
				for (int i = 0; i < allTools.size(); i ++)  { 
					allTools.get(i).display();
					String name = allTools.get(i).getName();
					String id = allTools.get(i).getID();
					double price = allTools.get(i).getPrice();
					int quan = allTools.get(i).getQuantity();
					String supp = allTools.get(i).getSupplier();
					String str = String.format("%30s %20s %20s %20s %40s", name, id, price, quan, supp);
					listModel.addElement(str);
				}
				view.addList(listModel);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}