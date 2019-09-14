package User;

import Database.Database;
import Database.SQLDatabase;
import Database.ToolDoesNotExistException;
import Functionality.Order;
import Functionality.OrderParts;
import Functionality.Supplier;
import Functionality.Tool;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Operations {
	private SQLDatabase db;

	public Operations(SQLDatabase db) {
		this.db = db;
	}

	public ArrayList<Tool> getTools() throws IOException {
		return db.getAllTools();
	}

	public ArrayList<Supplier> getSuppliers() throws IOException {
		return db.getAllSuppliers();
	}

	/**
	 * This method sells the tool, it is called when adding tools to the cart on the
	 * client side.
	 * 
	 * @param searchField
	 * @param i
	 * @return
	 * @throws IOException
	 * @throws ToolDoesNotExistException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Tool sellTool(String searchField, int i) throws IOException, SQLException, ToolDoesNotExistException, ClassNotFoundException {
		Tool toCart = db.getTool(searchField);
		if (toCart == null) {
			return null;
		} else {
			db.sellTool(toCart.getID(), i);
			return toCart;
		}
	}

	// TODO ensure when tool added to order client side that it call server to make
	// sure it is a real tool.
	/**
	 * assumed that every tool in an order exists and has already been processed
	 * when added.
	 * 
	 * @param o
	 * @return
	 */
	public String processOrder(Order o) {
		if (!o.isFinalized()) {
			return "Order Unfinalized, Action Aborted!";
		}
		String failed = "";
		if (o.isSellOrder()) {
			if (o.isJustFix()) {
				return "Success!";
			} else {
				db.addSellOrder(o);
				return "Success!";
			}
		} else {
			for (OrderParts op : o.getOrderParts()) {
				db.addQuantity(op.getTool(), op.getAmountToOrder());
			}
			if (o.isJustFix()) {
				return "Success!";
			} else {
				db.addBuyOrder(o);
				return "Success!";
			}
		}
	}

	public Tool getTool(String searchField) throws IOException, SQLException, ToolDoesNotExistException {
		return db.getTool(searchField);
	}

	public Supplier getSupplier(String searchField) throws IOException {
		return db.getSupplier(searchField);
	}

	// TODO check the supplier id given is real
	public String addTool(Tool tool) throws IOException {
		if (db.addTool(tool)) {
			return "Success!";
		} else {
			return "Unsuccessful!";
		}
	}

	public String addSupplier(Supplier supplier) throws IOException {
		if (db.addSupplier(supplier)) {
			return "Success!";
		} else {
			return "Unsuccessful!";
		}
	}
	/**
	 * Removes a tool from the database.	
	 * @param searchField is the field to search by.	
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 * @throws ToolDoesNotExistException
	 */
	public String removeTool(String searchField) throws IOException, SQLException, ToolDoesNotExistException {
		Tool toDelete = getTool(searchField);
		if(toDelete != null) {
			if(db.deleteTool(toDelete.getID())) {
				return "Success!";
			}else {
				return "Unsuccessful!";
			}
		}
		return "Unsuccessful!";
	}
	/**
	 * Removes a supplier from the database.	
	 * @param searchField is how you find the tool to remove.	
	 * @return The string if it worked.	
	 * @throws IOException if the I/O is bad.	
	 */
	public String removeSupplier(String searchField) throws IOException {
		Supplier toDelete = getSupplier(searchField);
		if(toDelete != null) {
			if(db.deleteSupplier(toDelete.getID())) {
				return "Success!";
			}else {
				return "Unsuccessful!";
			}
		}
		return "Unsuccessful!";
	}
}
