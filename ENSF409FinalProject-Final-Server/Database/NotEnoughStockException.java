package Database;

public class NotEnoughStockException extends Exception{

	/**
	 * Serial id of the exception.	
	 */
	private static final long serialVersionUID = 1L;
	
	public NotEnoughStockException() {
		super("Not Enough Stock to Make this Sale");
	}

}
