package Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Creates the database.	
 * @author kiern
 *
 */
public class CreateDataBase {
	/**
	 * Connect to a sample database. This will overwrite an existing database of the
	 * same name.
	 *
	 * @param fileName the database file name
	 */
	public static void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:C:\\Users\\Youup\\eclipse-workspace\\FinalProjectServer\\src" + fileName;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				conn.setAutoCommit(false);
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
				addData(conn);
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This adds the tables needed for the sql database.
	 * @param c the connection to the database
	 */
	public static void addData(Connection c) {
		createToolTable(c);
		createSupplierTable(c);
		createSellOrderTable(c);
		createBuyOrderTable(c);
	}
	
	/**
	 * Thus creates the sell order table.
	 * @param c the connector
	 */
	public static void createSellOrderTable(Connection c) {
		java.sql.Statement stmt = null;

		try {
			stmt = c.createStatement();
			String sql = "CREATE TABLE SELLORDER " + "(ID TEXT PRIMARY KEY     NOT NULL," + " date	DATE	NOT NULL, " + 
			"orderParts	TEXT	NOT NULL);";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}

	/**
	 * This creates the buy order table.
	 * @param c the connection
	 */
	public static void createBuyOrderTable(Connection c) {
		java.sql.Statement stmt = null;

		try {
			stmt = c.createStatement();
			String sql = "CREATE TABLE BUYORDER " + "(ID TEXT PRIMARY KEY     NOT NULL," + " date	DATE	NOT NULL, " + 
			"orderParts	TEXT	NOT NULL);";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}
	
	/**
	 * This creates the tool table.
	 * @param c the connector
	 */
	public static void createToolTable(Connection c) {
		java.sql.Statement stmt = null;

		try {
			stmt = c.createStatement();
			String sql = "CREATE TABLE TOOL " + "(ID TEXT PRIMARY KEY     NOT NULL," + " name		TEXT	NOT NULL, "
					+ " quantity	INT		NOT NULL, " + " price		REAL	NOT NULL, " + " supplier	TEXT);";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
		try {
			addToolData(c);
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This adds tool data to the table.
	 * @param c connector.
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public static void addToolData(Connection c) throws SQLException, FileNotFoundException {
		Scanner scan = new Scanner(new File("setItems.txt"));
		scan.useDelimiter("\n");

		PreparedStatement insertData = null;
		String insertStatement = "INSERT INTO TOOL (ID,name,quantity,price,supplier) VALUES(?,?,?,?,?);";
		String s;
		String[] data;

		while (scan.hasNext()) {
			s = scan.next();
			data = s.split(";");
			insertData = c.prepareStatement(insertStatement);
			insertData.setString(1, data[0]);
			insertData.setString(2, data[1]);
			insertData.setInt(3, Integer.parseInt(data[2]));
			insertData.setDouble(4, Double.parseDouble(data[3]));
			insertData.setString(5, data[4]);
			insertData.executeUpdate();
			c.commit();
		}
		insertData.close();
	}

	/**
	 * This creates the supplier table.
	 * @param c the connector
	 */
	public static void createSupplierTable(Connection c) {
		java.sql.Statement stmt = null;

		try {
			stmt = c.createStatement();
			String sql = "CREATE TABLE SUPPLIER " + "(ID TEXT PRIMARY KEY     NOT NULL,"
					+ " name		TEXT	NOT NULL, " + " address	TEXT	NOT NULL, " + " contact	TEXT	NOT NULL);";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
		try {
			addSupplierData(c);
		} catch (FileNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This adds the supplier data to the table.
	 * @param c the connector
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	public static void addSupplierData(Connection c) throws FileNotFoundException, SQLException {
		Scanner scan = new Scanner(new File("setSuppliers.txt"));
		scan.useDelimiter("\n");

		PreparedStatement insertData = null;
		String insertStatement = "INSERT INTO SUPPLIER (ID,name,address,contact) VALUES(?,?,?,?);";
		String s;
		String[] data;

		while (scan.hasNext()) {
			s = scan.next();
			data = s.split(";");
			insertData = c.prepareStatement(insertStatement);
			insertData.setString(1, data[0]);
			insertData.setString(2, data[1]);
			insertData.setString(3, data[2]);
			insertData.setString(4, data[3]);
			insertData.executeUpdate();
			c.commit();
		}
		insertData.close();
	}

	public static void main(String[] args) {
		createNewDatabase("ToolShop.db");
	}
}
