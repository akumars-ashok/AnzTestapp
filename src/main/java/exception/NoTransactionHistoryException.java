package exception;

public class NoTransactionHistoryException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoTransactionHistoryException(String msg){
		super(msg);
	}
}
