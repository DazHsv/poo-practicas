package exceptions;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

@SuppressWarnings("serial")
public class CardException extends Exception {
	
	public CardException() {}
	
	public CardException(String msg) {
		super(msg);
	}
}