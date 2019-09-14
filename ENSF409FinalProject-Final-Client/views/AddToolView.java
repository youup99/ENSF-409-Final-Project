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
 * This class runs the view GUI for add tool.
 * @author Ethan Rigby
 * @since March 31, 2019
 */
public class AddToolView extends JFrame{
	
	/**
	 * Serial ID for the AddToolView view.	
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Label for tool name.
	 */
	private JLabel toolName = new JLabel("Name of Tool:");
	/**
	 * Label for tool ID.
	 */
	private JLabel toolID = new JLabel("ID of Tool:");
	/**
	 * Label for supplier of tool.
	 */
	private JLabel supplier = new JLabel("Tool Supplier:");
	/**
	 * Label for price of tool.
	 */
	private JLabel toolPrice = new JLabel("Price of Tool:");
	
	/**
	 * Text field for name.
	 */
	private JTextField nameOfTool = new JTextField(15);
	/**
	 * Text field for id.
	 */
	private JTextField idOfTool = new JTextField(15);
	/**
	 * Text field for supplier.
	 */
	private JTextField supplierOfTool = new JTextField(15);
	/**
	 * Text field for price.
	 */
	private JTextField priceOfTool = new JTextField(15);
	
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
	public AddToolView()  {
		super("Add Tool");
		
		this.setSize(350, 225);
		this.setResizable(false);
		
		labels.setLayout(layout);
		labels.add(toolName);
		labels.add(toolID);
		labels.add(supplier);
		labels.add(toolPrice);
				
		labels.add(nameOfTool);
		labels.add(idOfTool);
		labels.add(supplierOfTool);
		labels.add(priceOfTool);
		
		layout.putConstraint(SpringLayout.WEST,  toolName, 5, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  toolName, 5, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  nameOfTool, 100, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  nameOfTool, 5, SpringLayout.NORTH, labels);
		
		layout.putConstraint(SpringLayout.WEST,  toolID, 5, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  toolID, 45, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  idOfTool, 100, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  idOfTool, 45, SpringLayout.NORTH, labels);
		
		layout.putConstraint(SpringLayout.WEST,  supplier, 5, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  supplier, 85, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  supplierOfTool, 100, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  supplierOfTool, 85, SpringLayout.NORTH, labels);
		
		layout.putConstraint(SpringLayout.WEST,  toolPrice, 5, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  toolPrice, 125, SpringLayout.NORTH, labels);
		layout.putConstraint(SpringLayout.WEST,  priceOfTool, 100, SpringLayout.WEST, labels);
		layout.putConstraint(SpringLayout.NORTH,  priceOfTool, 125, SpringLayout.NORTH, labels);
		
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
	 * Gets id of tool.
	 * @return id of tool
	 */
	public String getID()  {
		return idOfTool.getText();
	}
	
	/**
	 * Gets name of tool.
	 * @return name of tool.
	 */
	public String getName()  {
		return nameOfTool.getText();
	}
	
	/**
	 * Gets price of tool.
	 * @return price of tool.
	 */
	public double getPrice()  {
		String temp = priceOfTool.getText();
		return Double.parseDouble(temp);
	}
	
	/**
	 * Gets name of supplier.
	 * @return name of supplier.
	 */
	public String getSupplier()  {
		return supplierOfTool.getText();
	}
}
