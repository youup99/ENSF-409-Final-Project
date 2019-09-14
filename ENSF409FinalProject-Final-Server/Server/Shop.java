package Server;

import Database.Database;
import Database.SQLDatabase;
import Functionality.Order;
import User.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This method handles all the data and methods of the shop.
 * 
 * @author Youup Kim
 */
public class Shop {
	ServerSocket serverSocket;

	/**
	 * This is the constructor.
	 * 
	 * @throws IOException
	 */
	public Shop() throws IOException {
		serverSocket = new ServerSocket(9090);
	}

	public void start() {
		ExecutorService es = Executors.newFixedThreadPool(5);
		SQLDatabase db = new SQLDatabase();
		try {
			while (true) {
				synchronized (db) {
					Socket aSocket = serverSocket.accept();
					User user = new User(aSocket, db);
					es.execute(user);
				}
			}
		} catch (IOException e) {
			System.err.println("Shop Crashed");
			e.printStackTrace();
		}
	}
}