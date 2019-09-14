package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
/**
 * The view for generating orders.
 * @author Kiernan McGuigan
 * @since April 2, 2019
 *
 */
public class GenerateOrderView extends JFrame {

	/**
	 * Serial ID for this view.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Label above the page.	
	 */
	private JLabel label = new JLabel("Generate Order");
	/**
	 * The cart where the items get stored in.	
	 */
	private JTextArea order = new JTextArea();
	/**
	 * The order menu that contains the buttons to manage the order.	
	 */
	private GenerateOrderMenu menu = new GenerateOrderMenu();
	
	public GenerateOrderView() {
		super("Generate Order");
		this.setLayout(new BorderLayout());
		this.setSize(400,400);
		this.setResizable(false);
		
		this.add(label, BorderLayout.NORTH);
		this.add(order, BorderLayout.CENTER);
		this.add(menu, BorderLayout.SOUTH);
	}
	
	public GenerateOrderMenu getGenerateOrderMenu() {
		return menu;
	}
	public JTextArea getCart() {
		return order;
	}
	
	public void clearCart() {
		order.setText(null);
	}
}
