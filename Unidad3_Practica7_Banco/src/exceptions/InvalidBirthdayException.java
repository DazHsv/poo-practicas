package exceptions;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

@SuppressWarnings("serial")
public class InvalidBirthdayException extends Exception {
	
	public InvalidBirthdayException() {}
	
	public InvalidBirthdayException(String msg) {
		super(msg);
	}
}