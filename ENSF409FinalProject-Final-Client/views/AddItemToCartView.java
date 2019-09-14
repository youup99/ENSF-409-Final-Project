package views;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * The view for adding an item to the cart.
 * @author Kiernan McGuigan
 * @since April 2, 2019
 *
 */
public class AddItemToCartView extends JFrame {

	/**
	 * Serial ID of the View.	
	 */
	private static final long serialVersionUID = 1L;
	private JLabel searchLabel = new JLabel("Search For Tool: ");
	private JTextField searchField = new JTextField("Name", 15);
	private JLabel quantityLabel = new JLabel("Quantity: ");
	private JTextField quantityField = new JTextField("1", 15);
	private JButton addToCart = new JButton("Add To Cart");
	private JTextArea cart;
	
	public AddItemToCartView(String s) {
		super(s);
		this.setSize(400,100);
		this.setResizable(false);
		
		this.cart = cart;
		this.setLayout(new FlowLayout());
		this.add(searchLabel);
		this.add(searchField);
		this.add(quantityLabel);
		this.add(quantityField);
		this.add(addToCart);
	}
	public void appendCart(String str) {
		cart.append(str);
	}
	public void addToCartListener(ActionListener al) {
		addToCart.addActionListener(al);
	}
	public String getSearchField() {
		return searchField.getText();
	}
	public String getQuantity() {
		return quantityField.getText();
	}
}
