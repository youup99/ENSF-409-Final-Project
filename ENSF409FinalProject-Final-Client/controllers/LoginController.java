package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import client.Communicator;
import client.User;
import controllers.AddSupplierController.CreateListener;
import views.LoginView;

/**
 * The controller class for login view.
 * @author Ethan
 *
 */
public class LoginController {
	
	/**
	 * Keeps track of the user.
	 */
	private User user;
	
	/**
	 * Connects to the login view.
	 */
	private LoginView view;
	/**
	 * Constructor
	 * @param view 	
	 * @param us
	 */
	public LoginController(LoginView view, User us) {
		this.view = view;
		this.user = us;
	}
	
	/**
	 * Adds listeners to login.
	 */
	public void addListeners() {
		view.addLoginListener(new LoginListener());
	}

	/**
	 * This is the action listener and checks for the correct username and password.
	 * @author Ethan Rigby
	 *
	 */
	class LoginListener implements ActionListener  {
	
		@Override
		public void actionPerformed(ActionEvent arg0) {
			 char[] password = view.getPassword();
			 String username = view.getUsername();
			 
		        if (isPasswordCorrect(password) && isUsernameCorrect(username)) {
		            JOptionPane.showMessageDialog(view,
		                "Logged in.");
		            view.setVisible(false);
		            user.start();
		        } 
		        else {
		            JOptionPane.showMessageDialog(view,
		                "Invalid username or password. Try again.",
		                "Error Message",
		                JOptionPane.ERROR_MESSAGE);
		        }
	
		        //Zero out the possible password, for security.
		        Arrays.fill(password, '0');
		}
		
		private boolean isPasswordCorrect(char[] input) {
		    boolean isCorrect = true;
		    char[] correctPassword = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };
	
		    if (input.length != correctPassword.length) {
		        isCorrect = false;
		    } 
		    else {
		        isCorrect = Arrays.equals (input, correctPassword);
		    }
	
		    //Zero out the password.
		    Arrays.fill(correctPassword,'0');
	
		    return isCorrect;
		}
	
		private boolean isUsernameCorrect(String input)  {
			boolean isCorrect = true;
			char[] correctUsername = {'A', 'd', 'm', 'i', 'n'};
			char[] username = input.toCharArray();
			
			if (username.length != correctUsername.length)  {
				isCorrect = false;
			}
			else  {
				isCorrect = Arrays.equals(username, correctUsername);
			}
			
			Arrays.fill(correctUsername,'0');
			return isCorrect;
		}
	}
}
