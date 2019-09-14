package views;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * This is the view responsible for searching for a supplier.	
 * @author Kiernan McGuigan
 *
 */
public class SearchSupplierView extends JFrame {

	/**
	 * Serial ID for the view.
	 */
	private static final long serialVersionUID = 1L;
	private JLabel searchLabel = new JLabel("Search For Supplier: ");
	private JTextField searchField = new JTextField("Name or ID", 15);
	private JButton search = new JButton("Search");

	public SearchSupplierView() {
			super("Search for Supplier");
			this.setSize(400,100);
			this.setResizable(false);
			
			this.setLayout(new FlowLayout());
			this.add(searchLabel);
			this.add(searchField);
			this.add(search);
	}
	
	public void setSearchListener(ActionListener al) {
		search.addActionListener(al);
	}
	
	public String getSearchField() {
		return searchField.getText();
	}

}
