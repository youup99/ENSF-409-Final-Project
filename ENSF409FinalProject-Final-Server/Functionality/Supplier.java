package Functionality;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This has information about a supplier
 * @author Youup Kim
 */
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * This is the id of the supplier.
     */
    private String id;
    /**
     * name of the supplier.
     */
    private String name;

    /**
     * Address of the supplier.
     */
    private String address;

    /**
     * Sales contact at the supplier.
     */
    private String salesContact;
    /**
     * tools the supplier supplies.
     */
    private ArrayList<Tool> tools;

    /**
     * Constructor.
     * @param id of supplier.
     * @param name of supplier.
     * @param address of supplier.
     * @param salesContact of supplier.
     */
    public Supplier(String id, String name, String address, String salesContact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salesContact = salesContact;
        tools = new ArrayList<Tool>();
    }

    /**
     * add a tool to the tools list.
     * @param t tool to add to the list.
     */
    public void addTool(Tool t) {
        tools.add(t);
    }
    /**
     * return supplier id.
     * @return supplier id.
     */
    public String getID() {
        return id;
    }
    /**
     * returns the name of the supplier.
     * @return name of the supplier.
     */
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getSalesContact() {
        return salesContact;
    }

    public String toString() {
        return name;
    }
    /**
     * Displays the supplier informtation.
     */
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Sales Contanct: " + salesContact);
    }
}