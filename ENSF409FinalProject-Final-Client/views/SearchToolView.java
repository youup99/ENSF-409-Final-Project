package views;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * This is the view responsible for searching for a tool.	
 * @author Kiernan McGuigan
 *
 */
public class SearchToolView extends JFrame {

	/**
	 * Serial ID for the view.	
	 */
	private static final long serialVersionUID = 1L;
	private JLabel searchLabel = new JLabel("Search For Tool: ");
	private JTextField searchField = new JTextField("Name or ID", 15);
	private JButton search = new JButton("Search");
	
	public SearchToolView() {
		super("Search for Tool");
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
	public String getSearchFeild() {
		return searchField.getText();
	}
}
