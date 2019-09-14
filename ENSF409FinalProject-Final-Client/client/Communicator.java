package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import Functionality.Order;
import Functionality.Supplier;
import Functionality.Tool;

/**
 * This class is responsible for sending a String operation code to the server then asking
 * for the data expected by the server.		
 * @author Kiernan McGuigan
 *@since April 2, 2019
 */
public class Communicator {
	
	/**
	 * Object output stream.	
	 */
	private ObjectOutputStream objOut;
	/**
	 * Client socket.
	 */
	private Socket aSocket;
	/**
	 * Object input stream.	
	 */
	private ObjectInputStream objIn;
	
	/**
	 * The constructor for the communicator.	
	 * @param aSocket is the socket to communicate over.	
	 * @throws IOException if the i/o streams fail to initialize
	 */
	public Communicator(Socket socket) throws IOException {
		this.aSocket = socket;
		objOut = new ObjectOutputStream(aSocket.getOutputStream());
		objIn = new ObjectInputStream(aSocket.getInputStream());
	}
	/**
	 * Sends the op String to the server.	
	 * @param s is the String to send.	
	 * @throws IOException if the String fails to send.	
	 */
	public void sendString(String s) throws IOException {
		objOut.reset();
		objOut.writeObject(s);
		objOut.flush();
	}
	/**
	 * Gets a string from the server.
	 * @return s is the string being sent to the client.
	 * @throws ClassNotFoundException if the class can't be found.
	 * @throws IOException if the string fails to be read.
	 */
	public String getString() throws ClassNotFoundException, IOException {
		String s = (String)objIn.readObject();
		return s;
	}
	/**
	 * Gets the list of all tools from the database.
	 * @return readObject the tool database.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<Tool> getAllTools() throws ClassNotFoundException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<Tool> readObject = (ArrayList<Tool>) objIn.readObject();
		return readObject;
	}
	/**
	 * Gets the list of all suppliers from the database.
	 * @return readObject the supplier database.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<Supplier> getAllSuppliers() throws ClassNotFoundException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<Supplier> readObject = (ArrayList<Supplier>) objIn.readObject();
		return readObject;
	}
	/**
	 * Sends a tool to the Tool database.
	 * @param add tool to add.
	 * @throws IOException 
	 */
	public void sendTool(Tool tool) throws IOException  {
		objOut.reset();
		objOut.writeObject(tool);
		objOut.flush();
	}
	
	public void sendInteger(Integer i) throws IOException {
		objOut.reset();
		objOut.writeObject(i);
		objOut.flush();
	}
	/**
	 * Gets a tool from the server side.
	 * @return tool a tool object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Tool getTool() throws ClassNotFoundException, IOException {
		Tool tool = (Tool)objIn.readObject();
		return tool;
	}
	/**
	 * Sends a supplier to the Supplier database.
	 * @param add supplier to add.
	 * @throws IOException 
	 */
	public void sendSupplier(Supplier supplier) throws IOException  {
		objOut.reset();
		objOut.writeObject(supplier);
		objOut.flush();
	}
	/**
	 * Gets a supplier from the server side.
	 * @return supplier a supplier object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Supplier getSupplier() throws ClassNotFoundException, IOException {
		Supplier supplier = (Supplier)objIn.readObject();
		return supplier;
	}
	/**
	 * Sends the order to the server side.
	 * @param order the order being sent.
	 * @throws IOException
	 */
	public void sendOrder(Order order) throws IOException {
		objOut.reset();
		objOut.writeObject(order);
		objOut.flush();
	}
	/**
	 * Gets the order from the server side.
	 * @return order the order.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Order getOrder() throws ClassNotFoundException, IOException {
		Order order = (Order)objIn.readObject();
		return order;
	}
}
