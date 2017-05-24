package exceptions;



public class InvalidNipException extends Exception {
	
	public InvalidNipException() {}
	
	public InvalidNipException(String msg) {
		super(msg);
	}
}
