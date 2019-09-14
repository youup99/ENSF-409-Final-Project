package client;

import java.io.IOException;
import java.net.Socket;

import controllers.LoginController;
import controllers.MainViewController;
import views.LoginView;
import views.MainView;

/**
 * The user class of this client side.
 * @author Ethan Rigby
 * @since April 3, 2019
 *
 */
public class User {

	/**
	 * The communicator user can talk through.	
	 */
	Communicator communicator;
	
	/**
	 * Constructor
	 * @param serverName name of server
	 * @param portNumber port of server
	 */
	public User(String serverName, int portNumber) {
		try {
			communicator = new Communicator(new Socket(serverName, portNumber));
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}
	
	/**
	 * Login for user.
	 */
	public void login()  {
		LoginView lv = new LoginView();
		LoginController lc = new LoginController(lv, this);
		lc.addListeners();
		lv.setVisible(true);
	}

	/**
	 * Starts the gui.
	 */
	public void start()  {
		MainView mv = new MainView();
		MainViewController mvc = new MainViewController(mv,communicator);
		mvc.addListeners();
		mv.setResizable(false);
		mv.setVisible(true);
	}
	
}
