package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class represents the database containing inventory and suppliers
 *
 * @author Kiernan McGuigan
 */
public class Database {

	public Connection getConn() throws ClassNotFoundException, SQLException {	
		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:ToolShop.db");
		c.setAutoCommit(false);
		return c;
	}
}