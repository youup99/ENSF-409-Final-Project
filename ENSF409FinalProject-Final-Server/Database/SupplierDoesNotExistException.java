package Database;

public class SupplierDoesNotExistException extends Exception {

	/**
	 * Serial id of exception.	
	 */
	private static final long serialVersionUID = 1L;
	
	public SupplierDoesNotExistException() {
		super("The Supplier Does not Exist");
	}

}
