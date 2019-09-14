package User;

import Functionality.Order;
import Functionality.Supplier;
import Functionality.Tool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * This class is responsible for getting input from client communicator
 * 
 * @author Youup Kim, Kiernan McGuigan
 */
public class Communicator {
	private ObjectOutputStream objOut;
	private Socket aSocket;
	private ObjectInputStream objIn;

	public Communicator(Socket socket) throws IOException {
		this.aSocket = socket;
		objOut = new ObjectOutputStream(aSocket.getOutputStream());
		objIn = new ObjectInputStream(aSocket.getInputStream());
	}

	/**
	 * Sends the op String to the server.
	 * 
	 * @param s is the String to send.
	 * @throws IOException if the String fails to send.
	 */
	public void sendString(String s) throws IOException {
		objOut.reset();
		objOut.writeObject(s);
		objOut.flush();
	}

	public String getString() throws ClassNotFoundException, IOException {
		String s = (String) objIn.readObject();
		return s;
	}

	/**
	 * Gets the list of all tools from the database.
	 * 
	 * @return readObject the tool database.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void getAllTools(ArrayList<Tool> tools) throws ClassNotFoundException, IOException {
		objOut.reset();
		objOut.writeObject(tools);
		objOut.flush();
	}

	/**
	 * Gets the list of all suppliers from the database.
	 * 
	 * @return readObject the supplier database.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void  getAllSuppliers(ArrayList<Supplier> suppliers) throws ClassNotFoundException, IOException {
		objOut.reset();
		objOut.writeObject(suppliers);
		objOut.flush();
	}
	
	public Integer getInteger() throws ClassNotFoundException, IOException {
		Integer i = (Integer)objIn.readObject();
		return i;
	}

	/**
	 * Sends a tool to the Tool client.
	 * 
	 * @param add tool to add.
	 * @throws IOException
	 */
	public void sendTool(Tool tool) throws IOException {
		objOut.reset();
		objOut.writeObject(tool);
		objOut.flush();
	}

	public Tool getTool() throws ClassNotFoundException, IOException {
		Tool tool = (Tool) objIn.readObject();
		return tool;
	}

	/**
	 * Sends a supplier to the Supplier database.
	 * 
	 * @param supplier supplier to add.
	 * @throws IOException
	 */
	public void sendSupplier(Supplier supplier) throws IOException {
		objOut.reset();
		objOut.writeObject(supplier);
		objOut.flush();
	}

	public Supplier getSupplier() throws ClassNotFoundException, IOException {
		Supplier supplier = (Supplier) objIn.readObject();
		return supplier;
	}

	public void sendOrder(Order order) throws IOException {
		objOut.reset();
		objOut.writeObject(order);
		objOut.flush();
	}

	public Order getOrder() throws ClassNotFoundException, IOException {
		Order order = (Order) objIn.readObject();
		return order;
	}

}
