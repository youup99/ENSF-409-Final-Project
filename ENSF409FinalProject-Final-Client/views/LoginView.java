package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * This is the view for the login.
 * @author Ethan Rigby
 *
 */
public class LoginView extends JFrame{

	/**
	 * Text for username.
	 */
	private JLabel username = new JLabel("Username:");
	/**
	 * Text for password.
	 */
	private JLabel password = new JLabel("Password:");
	
	private JLabel image = new JLabel();
	
	/**
	 * Text field for username.
	 */
	private JTextField textUsername = new JTextField(15);
	/**
	 * Text field for password.
	 */
	private JPasswordField textPassword = new JPasswordField(15);
	
	/**
	 * Button to login Tool.
	 */
	private JButton login = new JButton("Login");
	
	/**
	 * Panel for layout.
	 */
	private JPanel labels = new JPanel();
	
	/**
	 * Spring layout for panel.
	 */
	private SpringLayout layout = new SpringLayout();
	
	/**
	 * Constructor
	 */
	public LoginView()  {
		super("LOGIN");
		this.setSize(400, 300);
		this.setResizable(false);
		this.setBackground(Color.RED);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labels.setBackground(Color.CYAN);
		
		labels.setLayout(layout);
		labels.add(username);
		labels.add(password);
		
		labels.add(textUsername);
		labels.add(textPassword);
		
		image.setIcon(new ImageIcon("shop.jpg"));
		labels.add(image);
		
		layout.putConstraint(SpringLayout.WEST,  username, 5, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  username, 155, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  textUsername, 100, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  textUsername, 155, SpringLayout.NORTH, labels);
		
		layout.putConstraint(SpringLayout.WEST,  password, 5, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  password, 195, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  textPassword, 100, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  textPassword, 195, SpringLayout.NORTH, labels);
		
		layout.putConstraint(SpringLayout.WEST,  image, 95, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  image, 5, SpringLayout.NORTH, labels);
		
		this.add(labels);
		this.add(login, BorderLayout.SOUTH);
	}
	
	/**
	 * Adds an action listener to login button.
	 * @param al the action listener.
	 */
	public void addLoginListener(ActionListener al)  {
		login.addActionListener(al);
		
	}
	
	public String getUsername()  {
		return textUsername.getText();
	}
	
	public char[] getPassword()  {
		return textPassword.getPassword();
	}
}
