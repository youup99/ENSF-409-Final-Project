package User;

import Database.Database;
import Database.SQLDatabase;
import Database.ToolDoesNotExistException;
import Functionality.Order;
import Functionality.Supplier;
import Functionality.Tool;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
//TODO make sure the return strings line up with client side, so if return string is one thing do shit,
//TODO else dont do the shit but take in the exact right amount of info each time.	
/**
 * This class represents users actions on the server side
 */
public class User implements Runnable {

    /**
     * The communicator that talks with client
     */
    Communicator communicator;

    /**
     * operations class
     */
    Operations operations;

    /**
     * Constructor
     *
     * @param aSocket socket
     * @param db      database
     */
    public User(Socket aSocket, SQLDatabase db) {
        try {
            communicator = new Communicator(aSocket);
            operations = new Operations(db);

        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }
    }

    /**
     * This is the main running of the program, it starts the loop.	
     */
    @Override
    public void run() {
        try {
            this.loop();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This is the main loop the server side rusn to get client input and to process requests.	
     * @throws IOException
     */
    public void loop() throws IOException {
        Boolean run = true;
        while (run) {
            String op = "";
            try {
                op = communicator.getString();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

            if (op.contentEquals("")) {
                System.err.println("User failed to get opString");
                run = false;
                break;
            }

            switch (op) {
                case ("get tools"): {
                    try {
                        communicator.getAllTools(operations.getTools());
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case ("get suppliers"): {
                    try{
                        communicator.getAllSuppliers(operations.getSuppliers());
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case ("add tool to cart"): {
                    try {
                        String searchField = communicator.getString();
                        int quantity = communicator.getInteger();
                        Tool temp = operations.sellTool(searchField, quantity);
                        if(temp != null){
                            communicator.sendString("added");
                            communicator.sendTool(temp);
                        }
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                        communicator.sendString("Failed to add");
                    } catch(ToolDoesNotExistException e) {
                    	e.printStackTrace();
                    } catch(SQLException e) {
                    	e.printStackTrace();
                    }
                    break;
                }
                case ("sell order"): {
                    try {
                        Order o = communicator.getOrder();
                        String temp = operations.processOrder(o);
                        if(temp.equals("Order Unfinalized, Action Aborted!")){
                            communicator.sendString("Sale Unsuccessful");
                        }
                        if(temp.equals("Success!")) {
                        	communicator.sendString("Sale Successful");
                        }
                        communicator.sendString("Sale Successful");
                    } catch (ClassNotFoundException e){
                        e.printStackTrace();
                        communicator.sendString("Sale Unsuccessful");
                    }
                    break;
                }
                case ("add tool to order"): {
                    try{
                    	//TODO make client send string data.	
                        String searchField = communicator.getString();
                        Tool temp = operations.getTool(searchField);
                        if(temp != null){
                            communicator.sendString("added");
                            communicator.sendTool(temp);
                        }
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                        communicator.sendString("Tool does not exist");
                    } catch(ToolDoesNotExistException e) {
                    	e.printStackTrace();
                    } catch(SQLException e) {
                    	e.printStackTrace();
                    }
                    break;
                }
                case ("search tool"): {
                    try{
                        String temp = communicator.getString();
                        Tool tool = operations.getTool(temp);
                        if(tool != null){
                            communicator.sendString("added");
                            communicator.sendTool(tool);
                        }
                        else  {
                        	communicator.sendString("Could not find the tool.");
                        }
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    } catch(ToolDoesNotExistException e) {
                    	e.printStackTrace();
                    } catch(SQLException e) {
                    	e.printStackTrace();
                    }
                    break;
                }
                case ("search supplier"): {
                    try{
                        String temp = communicator.getString();
                        Supplier supplier = operations.getSupplier(temp);
                        if(supplier != null){
                            communicator.sendString("added");
                            communicator.sendSupplier(supplier);
                        }
                        else  {
                        	communicator.sendString("Cound not find the supplier.");
                        }
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case ("add tool"): {
                	String success;
                    try{
                        Tool temp = communicator.getTool();
                        String s = communicator.getString();
                        Supplier supplier = operations.getSupplier(s);
                        if (supplier == null)  {
                        	communicator.sendString("Error finding the supplier.");
                        	break;
                        }
                        temp.setSupplier(supplier.getID());
                        success = operations.addTool(temp);
                        if (success.contentEquals("Success!"))  {
                        	communicator.sendString("added");
                        	communicator.sendTool(temp);
                        }
                        else  {
                        	communicator.sendString("Duplicate error adding tool.");
                        }
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case ("add supplier"): {
                	String success;
                    try{
                        Supplier temp = communicator.getSupplier();
                        success = operations.addSupplier(temp);
                        if (success.contentEquals("Success!"))  {
                        	communicator.sendString("added");
                        	communicator.sendSupplier(temp);
                        }
                        else {
                        	communicator.sendString("Duplicate error adding supplier.");
                        }
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case ("remove tool"): {
                    try{
                    	String temp = communicator.getString();
                        Tool t = operations.getTool(temp);
                        if (t == null)  {
                        	communicator.sendString("Error finding tool to delete.");
                        	break;
                        }
                        operations.removeTool(t.getID());
                        communicator.sendString("removed");
                        communicator.sendTool(t);
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    } catch(ToolDoesNotExistException e) {
                    	e.printStackTrace();
                    } catch(SQLException e) {
                    	e.printStackTrace();
                    }
                    break;
                }
                case ("remove supplier"): {
                    try{
                        Supplier s = operations.getSupplier(communicator.getString());
                        if (s == null)  {
                        	communicator.sendString("Error finding supplier to delete.");
                        	break;
                        }
                        operations.removeSupplier(s.getID());
                        communicator.sendString("removed");
                        communicator.sendSupplier(s);
                    } catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }
                }
            }

        }


    }
}
