package views;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * The view of the main menu.
 * @author Kiernan McGuigan
 * @since April 2, 2019
 *
 */
public class MainView extends JFrame {

	/**
	 * Serial ID for the main view.	
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is the Label that goes on top to say what the application is.	
	 */
	private JLabel title = new JLabel("An Application to Manage a Stores Ressources");
	
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> list = new JList<String>(listModel);
	private JTextArea textArea = new JTextArea();
	private MainViewMenu mainViewMenu = new MainViewMenu();
	private JScrollPane pane = new JScrollPane(list);
	
	public MainView() {
		super("BorderLayout");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 600);
		this.setResizable(false);
		
		this.add(title, BorderLayout.NORTH);
		this.add(pane, BorderLayout.CENTER);
		this.add(mainViewMenu, BorderLayout.SOUTH);
	}
	
	public MainViewMenu getMainViewMenu() {
		return mainViewMenu;
	}
	
	public JTextArea getTextArea()  {
		return textArea;
	}
	
	public JList<String> getList()  {
		return list;
	}
	
	public void addList(DefaultListModel<String> listModel)  {
		list.setModel(listModel);
	}
}
