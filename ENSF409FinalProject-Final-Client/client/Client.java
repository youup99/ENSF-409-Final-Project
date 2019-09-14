package client;

/**
 * THe main class for the client side.
 * @author Ethan Rigby
 * @since April 3, 2019
 *
 */
public class Client {
	
	public static void main(String[] args) {
		User aUser = new User("localhost", 9090);
		System.out.println("Connected to server.");
		aUser.login();
	}
}
