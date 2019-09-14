package Database;

public class ToolDoesNotExistException extends Exception {

	/**
	 * Serial id of the exception.	
	 */
	private static final long serialVersionUID = 1L;

	public ToolDoesNotExistException() {
		super("The Tool Does not Exist");
	}
}
