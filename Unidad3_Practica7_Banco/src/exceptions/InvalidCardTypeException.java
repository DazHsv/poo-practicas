package exceptions;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

@SuppressWarnings("serial")
public class InvalidCardTypeException extends CardException {
	
	public InvalidCardTypeException() {}
	
	public InvalidCardTypeException(String msg) {
		super(msg);
	}
}
