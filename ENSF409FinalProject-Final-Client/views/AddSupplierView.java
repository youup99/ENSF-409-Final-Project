package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * This class runs the view GUI for add Supplier.
 * @author Ethan Rigby
 * @since March 31, 2019
 */
public class AddSupplierView extends JFrame {
	
	/**
	 * Serial ID for the AddToolView view.	
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Label for supAddress name.
	 */
	private JLabel supName = new JLabel("Name of Supplier:");
	/**
	 * Label for supAddress ID.
	 */
	private JLabel supID = new JLabel("ID of Supplier:");
	/**
	 * Label for supAddress address.
	 */
	private JLabel supAddress = new JLabel("Address of Supplier:");
	/**
	 * Label for sales contact.
	 */
	private JLabel supContact = new JLabel("Sales Contact:");
	
	/**
	 * Text field for name.
	 */
	private JTextField nameOfSup = new JTextField(15);
	/**
	 * Text field for id.
	 */
	private JTextField idOfSup = new JTextField(15);
	/**
	 * Text field for address.
	 */
	private JTextField addOfSup = new JTextField(15);
	/**
	 * Text field for contact.
	 */
	private JTextField contOfSup = new JTextField(15);
	
	/**
	 * Button to create Tool.
	 */
	private JButton create = new JButton("Create");
	
	/**
	 * Panel for layout.
	 */
	private JPanel labels = new JPanel();
	
	/**
	 * Spring layout for panel.
	 */
	private SpringLayout layout = new SpringLayout();
	
	/**
	 * This constructs the view for add tool.
	 */
	public AddSupplierView()  {
		super("Add Supplier");
		
		this.setSize(350, 225);
		this.setResizable(false);
		
		labels.setLayout(layout);
		labels.add(supName);
		labels.add(supID);
		labels.add(supAddress);
		labels.add(supContact);
				
		labels.add(nameOfSup);
		labels.add(idOfSup);
		labels.add(addOfSup);
		labels.add(contOfSup);
		
		layout.putConstraint(SpringLayout.WEST,  supName, 5, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  supName, 5, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  nameOfSup, 150, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  nameOfSup, 5, SpringLayout.NORTH, labels);
		
		layout.putConstraint(SpringLayout.WEST,  supID, 5, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  supID, 45, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  idOfSup, 150, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  idOfSup, 45, SpringLayout.NORTH, labels);
		
		layout.putConstraint(SpringLayout.WEST,  supAddress, 5, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  supAddress, 85, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  addOfSup, 150, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  addOfSup, 85, SpringLayout.NORTH, labels);
		
		layout.putConstraint(SpringLayout.WEST,  supContact, 5, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  supContact, 125, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  contOfSup, 150, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  contOfSup, 125, SpringLayout.NORTH, labels);
		
		this.add(labels);
		this.add(create, BorderLayout.SOUTH);
	}
	
	/**
	 * Adds an action listener to create button.
	 * @param al the action listener.
	 */
	public void addCreateListener(ActionListener al)  {
		create.addActionListener(al);
	}
	
	/**
	 * Gets ID of supplier.
	 * @return id
	 */
	public String getID()  {
		 return idOfSup.getText();
	}
	
	/**
	 * Gets name of supplier.
	 * @return name
	 */
	public String getName()  {
		return nameOfSup.getText();
	}
	
	/**
	 * Gets address of supplier.
	 * @return address
	 */
	public String getAddress()  {
		return addOfSup.getText();
	}
	
	/**
	 * Gets contact of supplier.
	 * @return contact
	 */
	public String getContact()  {
		return contOfSup.getText();
	}

}
