package exceptions;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

@SuppressWarnings("serial")
public class InvalidNipLengthException extends CardException {
	
	public InvalidNipLengthException() {}
	
	public InvalidNipLengthException(String msg) {
		super(msg);
	}
}