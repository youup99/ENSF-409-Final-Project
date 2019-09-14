package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * This is the j panel(holds the buttons) for the main view.
 * @author Kiernan McGuigan
 * @since April 2, 2019
 *
 */
public class MainViewMenu extends JPanel {
	
	/**
	 * Default ID for the JPanel.	
	 */
	private static final long serialVersionUID = 1L;

	private JButton sellButton = new JButton("Make Sale");
	private JButton generateOrderButton = new JButton("Generate a New Order");
	private JButton showToolsButton = new JButton("Show Tools");
	private JButton showSuppliersButton = new JButton("Show Suppliers");
	private JButton searchToolButton = new JButton("Search For a Tool");
	private JButton searchSupplierButton = new JButton("Search For a Supplier");
	private JButton addToolButton = new JButton("Add a New Tool");
	private JButton addSupplierButton = new JButton("Add a New Supplier");
	private JButton removeAToolButton = new JButton("Remove a Tool");
	private JButton removeASupplierButton = new JButton("Remove a Supplier");
	
	
	public MainViewMenu() {
		super();
		this.setLayout(new GridLayout(2,5));
		this.add(sellButton);
		this.add(generateOrderButton);
		this.add(showToolsButton);
		this.add(showSuppliersButton);
		this.add(searchToolButton);
		this.add(searchSupplierButton);
		this.add(addToolButton);
		this.add(addSupplierButton);
		this.add(removeAToolButton);
		this.add(removeASupplierButton);	
	}
	
	public void addSellListener(ActionListener al) {
		sellButton.addActionListener(al);
	}
	public void addGenOrderListener(ActionListener al) {
		generateOrderButton.addActionListener(al);
	}
	public void addShowToolsListener(ActionListener al) {
		showToolsButton.addActionListener(al);
	}
	public void addShowSuppliersListener(ActionListener al) {
		showSuppliersButton.addActionListener(al);
	}
	public void searchToolButtonListener(ActionListener al) {
		searchToolButton.addActionListener(al);
	}
	public void searchSupplierButtonListener(ActionListener al) {
		searchSupplierButton.addActionListener(al);
	}
	public void addToolButtonListener(ActionListener al) {
		addToolButton.addActionListener(al);
	}
	public void addSupplierButtonListener(ActionListener al) {
		addSupplierButton.addActionListener(al);
	}
	public void removeAToolButtonListener(ActionListener al) {
		removeAToolButton.addActionListener(al);
	}
	public void removeASupplierButtonListener(ActionListener al) {
		removeASupplierButton.addActionListener(al);
	}
}
