package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * This Class is responsible for displaying the buttons that allow the cart to have
 * functionality to add items, finalize a sale, and to clear the cart.	 
 * @author kiernan mcguigan
 *
 */
public class SellViewMenu extends JPanel {

	/**
	 * Serial ID for the view.	
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Button to add Item/Tool to the cart.	
	 */
	private JButton addItemButton = new JButton("Add Item To Cart");
	/**
	 * Button to Finalize a sale, calculates sum and sells items.	
	 */
	private JButton makeSaleButton = new JButton("Make Sale");
	/**
	 * Button to clear the current cart.	
	 */
	private JButton clearCartButton = new JButton("Clear Cart");
	/**
	 * Constructor, sets up the menu that holds the buttons to be selected from.	
	 */
	public SellViewMenu() {
		super();
		this.setLayout(new GridLayout(1,3));
		
		this.add(addItemButton);
		this.add(makeSaleButton);
		this.add(clearCartButton);
	}
	
	public void addItemListener(ActionListener al) {
		addItemButton.addActionListener(al);
	}
	public void makeSaleListener(ActionListener al) {
		makeSaleButton.addActionListener(al);
	}
	public void clearCartListener(ActionListener al) {
		clearCartButton.addActionListener(al);
	}
}
