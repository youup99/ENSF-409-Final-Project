package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Functionality.Supplier;
import client.Communicator;
import views.MainView;

/**
 * This class is responsible for controlling the Show Supplier button.
 * 
 * @author Ethan Rigby
 * @sine April 7, 2019, 2019
 */
class ShowSuppliersListener extends MainViewController implements ActionListener {
	public ShowSuppliersListener(MainView view, Communicator communicator) {
		super(view, communicator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultListModel<String> listModel = new DefaultListModel<>();
		try {
			communicator.sendString("get suppliers");
			ArrayList<Supplier> allSuppliers = communicator.getAllSuppliers();
			view.getList().clearSelection();
			String top = String.format("%30s %25s %40s %50s", "NAME", "ID", "ADDRESS", "SALES CONTACT");
			listModel.addElement(top);
			view.getTextArea().setText("NAME \t\t ID \t\t ADDRESS \t\t SALES CONTACT \n");
			for (int i = 0; i < allSuppliers.size(); i ++)  { 
				String name = allSuppliers.get(i).getName();
				String id = allSuppliers.get(i).getID();
				String address = allSuppliers.get(i).getAddress();
				String cont = allSuppliers.get(i).getSalesContact();
				String str = String.format("%30s %20s %40s %40s", name, id, address, cont);
				listModel.addElement(str);
			}
			view.addList(listModel);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}