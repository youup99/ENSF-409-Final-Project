package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * The menu for generating orders.
 * @author Kiernan McGuigan
 * @since April 2, 2019
 *
 */
public class GenerateOrderMenu extends JPanel {
	/**
	 * Serial ID for this view.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Button to add Item/Tool to the cart.
	 */
	private JButton addItemButton = new JButton("Add Item To Cart");
	/**
	 * Button to Finalize a sale, calculates sum and sells items.
	 */
	private JButton sendOrderButton = new JButton("Make Sale");
	/**
	 * Button to clear the current cart.
	 */
	private JButton clearOrderButton = new JButton("Clear Order");

	/**
	 * Constructor, sets up the menu that holds the buttons to be selected from.
	 */
	public GenerateOrderMenu() {
		super();
		this.setLayout(new GridLayout(1, 3));
		
		this.add(addItemButton);
		this.add(sendOrderButton);
		this.add(clearOrderButton);
	}

	public void addItemListener(ActionListener al) {
		addItemButton.addActionListener(al);
	}

	public void sendOrderListener(ActionListener al) {
		sendOrderButton.addActionListener(al);
	}

	public void clearOrderListener(ActionListener al) {
		clearOrderButton.addActionListener(al);
	}
}
