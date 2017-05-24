package exceptions;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

@SuppressWarnings("serial")
public class InvalidPhoneException extends Exception {
	
	public InvalidPhoneException() {}
	
	public InvalidPhoneException(String msg) {
		super(msg);
	}
}