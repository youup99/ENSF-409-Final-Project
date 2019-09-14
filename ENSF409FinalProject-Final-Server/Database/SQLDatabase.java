package Database;

import java.sql.*;
import java.util.ArrayList;

import Functionality.Order;
import Functionality.OrderParts;
import Functionality.Supplier;
import Functionality.Tool;

/**
 * This class represents the SQL Database for toolshop
 * @author Youup Kim
 *
 */
public class SQLDatabase {

    /**
     * This class creates a connection to SQL Database
     * @return Connection to database
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	public Connection getConn() throws ClassNotFoundException, SQLException {
//		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Youup\\eclipse-workspace\\FinalProjectServer\\srcToolShop.db");
		// c.setAutoCommit(false);
		return c;
	}

    /**
     * This class gets a tool from toolshop based on ID or name
     * @param searchField ID or Name of tool
     * @return Tool
     */
	public Tool getTool(String searchField) {
		Connection conn = null;
		PreparedStatement getTool = null;
		String getToolString = "SELECT * FROM TOOL WHERE ID = ? OR name = ?";
		try {
			conn = getConn();
			if (conn != null) {
				getTool = conn.prepareStatement(getToolString);
				getTool.setString(1, searchField);
				getTool.setString(2, searchField);
				ResultSet rs = getTool.executeQuery();
				if (rs.next()) {
					Tool t = new Tool(rs.getString("ID"), rs.getString("name"), rs.getInt("quantity"),
							rs.getDouble("price"));
					t.linkSupplier(rs.getString("supplier"));
					conn.close();
					return t;
				}
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

    /**
     * This class gets a supplier from toolshop based on ID or name
     * @param searchField ID or name of supplier
     * @return Supplier
     */
	public Supplier getSupplier(String searchField) {
		Connection conn = null;
		PreparedStatement getSupplier = null;
		String getSupplierString = "select * from SUPPLIER where ID = ? or name = ?";
		try {
			conn = getConn();
			if (conn != null) {
				getSupplier = conn.prepareStatement(getSupplierString);
				getSupplier.setString(1, searchField);
				getSupplier.setString(2, searchField);
				ResultSet rs = getSupplier.executeQuery();
				if (rs.next()) {
					Supplier s = new Supplier(rs.getString("ID"), rs.getString("name"), rs.getString("address"),
							rs.getString("contact"));
					conn.close();
					return s;
				}
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

    /**
     * This class returns all tools in toolshop
     * @return ArrayList<Tool>
     */
	public ArrayList<Tool> getAllTools() {
		Connection conn = null;
		PreparedStatement getAllTools = null;
		String getAllToolsString = "select * from tool";
		ArrayList<Tool> temp = new ArrayList<Tool>();
		try {
			conn = getConn();
			if (conn != null) {
				getAllTools = conn.prepareStatement(getAllToolsString);
				ResultSet rs = getAllTools.executeQuery();

				while (rs.next()) {
					Tool t = new Tool(rs.getString("ID"), rs.getString("name"), rs.getInt("quantity"),
							rs.getDouble("price"));
					t.linkSupplier(rs.getString("supplier"));
					//t.display();
					temp.add(t);
				}
				conn.close();
				return temp;
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

    /**
     * This class returns all suppliers in toolshop
     * @return ArrayList<Supplier>
     */
	public ArrayList<Supplier> getAllSuppliers() {
		Connection conn = null;
		PreparedStatement getAllSuppliers = null;
		String getAllSuppliersString = "select * from SUPPLIER";
		ArrayList<Supplier> temp = new ArrayList<Supplier>();
		try {
			conn = getConn();
			if (conn != null) {
				getAllSuppliers = conn.prepareStatement(getAllSuppliersString);
				ResultSet rs = getAllSuppliers.executeQuery();

				while (rs.next()) {
					Supplier s = new Supplier(rs.getString("ID"), rs.getString("name"), rs.getString("address"),
							rs.getString("contact"));
					temp.add(s);
				}
				conn.close();
				return temp;
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

    /**
     * This class adds a tool to toolshop
     * @param t Tool
     * @return boolean to see if tool was added correctly
     */
	public boolean addTool(Tool t) {
		boolean success = true;
		Connection conn = null;
		PreparedStatement addTool = null;
		String addToolString = "insert into TOOL values (?, ?, ? ,?, ?)";
		try {
			conn = getConn();
			if (conn != null) {
				addTool = conn.prepareStatement(addToolString);
				addTool.setString(1, t.getID());
				addTool.setString(2, t.getName());
				addTool.setInt(3, t.getQuantity());
				addTool.setDouble(4, t.getPrice());
				addTool.setString(5, t.getSupplier());
				addTool.executeUpdate();
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		return success;
	}

    /**
     * This class adds a supplier to toolshop
     * @param s Supplier
     * @return boolean to see if supplier was added correctly
     */
	public boolean addSupplier(Supplier s) {
		boolean success = true;
		Connection conn = null;
		PreparedStatement addSupplier = null;
		String addSupplierString = "insert into SUPPLIER values (?, ? , ?, ?)";
		try {
			conn = getConn();
			if (conn != null) {
				addSupplier = conn.prepareStatement(addSupplierString);
				addSupplier.setString(1, s.getID());
				addSupplier.setString(2, s.getName());
				addSupplier.setString(3, s.getAddress());
				addSupplier.setString(4, s.getSalesContact());
				addSupplier.executeUpdate();
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		return success;
	}

    /**
     * This class deletes a tool from toolshop
     * @param searchField ID or name of tool to delete
     */
	public boolean deleteTool(String searchField) {
		Connection conn = null;
		PreparedStatement deleteTool = null;
		String deleteToolString = "delete from TOOL where ID = ? or name = ?";
		try {
			conn = getConn();
			if (conn != null) {
				deleteTool = conn.prepareStatement(deleteToolString);
				deleteTool.setString(1, searchField);
				deleteTool.setString(2, searchField);
				deleteTool.executeUpdate();
				conn.close();
				return true;
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

    /**
     * This class deletes a supplier from toolshop
     * @param searchField ID or name of supplier to delete
     */
	public boolean deleteSupplier(String searchField) {
		Connection conn = null;
		PreparedStatement deleteSupplier = null;
		String deleteSupplierString = "delete from SUPPLIER where ID = ? or name = ?";
		try {
			conn = getConn();
			if (conn != null) {
				deleteSupplier = conn.prepareStatement(deleteSupplierString);
				deleteSupplier.setString(1, searchField);
				deleteSupplier.setString(2, searchField);
				deleteSupplier.executeUpdate();
				conn.close();
				return true;
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

    /**
     * This class sells a tool from toolshop by updating its quantity
     * @param id ID of tool
     * @param quantityToSell amount of tool to sell
     * @return Tool
     */
	public Tool sellTool(String id, int quantityToSell) {
		Tool temp;
		temp = getTool(id);
		int previousQuantity = getTool(id).getQuantity();
		int newQuantity = previousQuantity - quantityToSell;
		Connection conn = null;
		PreparedStatement sellTool = null;
		String sellToolString = "update TOOL set quantity = ? where id = ?";
		try {
			conn = getConn();
			if (conn != null) {
				if (temp.sellQuantity(quantityToSell)) {
					sellTool = conn.prepareStatement(sellToolString);
					sellTool.setInt(1, quantityToSell);
					sellTool.setString(2, id);
					sellTool.executeUpdate();
					conn.close();
					return temp;
				}
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

    /**
     * This class adds a buy order into toolshop
     * @param o buyorder
     */
	public void addBuyOrder(Order o) {
		Connection conn = null;
		PreparedStatement addBuyOrder = null;
		String addBuyOrderString = "insert into BUYORDER values (?, ?, ?, ?, ?)";
		try {
			conn = getConn();
			if (conn != null) {
				addBuyOrder = conn.prepareStatement(addBuyOrderString);
				for (OrderParts op : o.getOrderParts()) {

					addBuyOrder.setString(1, o.getOrderID());
					addBuyOrder.setString(2, o.getDate().toString());
					addBuyOrder.setString(3, op.getTool().getName());
					addBuyOrder.setInt(4, op.getAmountToOrder());
					addBuyOrder.setString(5, getSupplier(op.getTool().getSupplier()).getName());
					addBuyOrder.executeUpdate();
					addQuantity(op.getTool(), op.getAmountToOrder());
				}
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}

    /**
     * This class adds quantity of a tool in toolshop
     * @param t Tool
     * @param quantityToAdd amount to add
     */
	public void addQuantity(Tool t, int quantityToAdd) {
		Connection conn = null;
		PreparedStatement addQuantity = null;
		String addQuantityString = "update TOOL set quantity = ? where id = ?";
		int originalQuantity = t.getQuantity();
		int newQuantity = originalQuantity + quantityToAdd;
		try {
			conn = getConn();
			if (conn != null) {
				addQuantity = conn.prepareStatement(addQuantityString);
				addQuantity.setInt(1, newQuantity);
				addQuantity.setString(2, t.getID());
				addQuantity.executeUpdate();
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}

    /**
     * This class adds a sell order into toolshop
     * @param o sellorder
     */
	public void addSellOrder(Order o) {
		Connection conn = null;
		PreparedStatement addSellOrder = null;
		String addSellOrderString = "insert into SELLORDER values (?, ?, ?, ?, ?)";
		try {
			conn = getConn();
			if (conn != null) {
				addSellOrder = conn.prepareStatement(addSellOrderString);
				for (OrderParts op : o.getOrderParts()) {
					addSellOrder.setString(1, o.getOrderID());
					addSellOrder.setString(2, o.getDate().toString());
					addSellOrder.setString(3, op.getTool().getName());
					addSellOrder.setInt(4, op.getAmountToOrder());
					addSellOrder.setString(5, getSupplier(op.getTool().getSupplier()).getName());
					addSellOrder.executeUpdate();
					sellTool(op.getTool().getID(), op.getAmountToOrder());
				}
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}

}
