package views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * This class creates the remove supplier view.
 * @author Ethan Rigby
 * @since March 31, 2019
 */
public class RemoveSupplierView extends JFrame{

	/**
	 * Label for remove.
	 */
	private JLabel removeSup = new JLabel("Name/ID of Supplier:");
	
	/**
	 * Text field for name or ID.
	 */
	private JTextField textField = new JTextField("Name/ID to Remove", 15);
	
	/**
	 * Button to remove by name.
	 */
	private JButton remove = new JButton("Remove");
	
	/**
	 * Panel for layout.
	 */
	private JPanel labels = new JPanel();
	
	/**
	 * Spring layout for panel.
	 */
	private SpringLayout layout = new SpringLayout();
	
	public RemoveSupplierView()  {
		super("Remove Supplier");
		this.setSize(350, 100);
		this.setResizable(false);
		
		labels.setLayout(layout);
		
		labels.add(removeSup);
		labels.add(textField);
		labels.add(remove);
		
		layout.putConstraint(SpringLayout.WEST,  removeSup, 5, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  removeSup, 5, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  textField, 120, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  textField, 5, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  remove, 140, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  remove, 35, SpringLayout.NORTH, labels);
		
		this.add(labels);
	}
	
	/**
	 * Adds an action listener to remove button.
	 * @param al the action listener.
	 */
	public void addCreateListener(ActionListener al)  {
		remove.addActionListener(al);
	}
	
	/**
	 * Gets name or id of supplier.
	 * @return name/id
	 */
	public String getSupplier()  {
		return textField.getText();
	}
}
