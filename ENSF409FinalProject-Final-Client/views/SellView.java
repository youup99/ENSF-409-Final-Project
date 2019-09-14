package views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * This class is responsible for the view that displays the cart and the
 * contains the JPanel that contains all the buttons for the cart.	
 * @author Kiernan McGuigan
 * @since March 31, 2019
 *
 */
public class SellView extends JFrame {

	/**
	 * Serial ID for the JPanel
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Label above the page.	
	 */
	private JLabel label = new JLabel("Make Sale");
	/**
	 * The cart where the items get stored in.	
	 */
	private JTextArea cart = new JTextArea();
	/**
	 * The sellViewMenu that contains the buttons to manage the cart.	
	 */
	private SellViewMenu sellViewMenu = new SellViewMenu(); 
	
	/**
	 * Constructor that initializes the SellView when the main menu selects this option.	
	 */
	public SellView() {
    
		super("Make Sale");
		this.setLayout(new BorderLayout());
		this.setSize(400,400);
		this.setResizable(false);
		
		this.add(label, BorderLayout.NORTH);
		this.add(cart, BorderLayout.CENTER);
		this.add(sellViewMenu, BorderLayout.SOUTH);
	}

	public SellViewMenu getSellViewMenu() {
		return sellViewMenu;
	}
	
	public JTextArea getCart() {
		return cart;
	}
	
	public void clearCart() {
		cart.setText(null);
	}
}
