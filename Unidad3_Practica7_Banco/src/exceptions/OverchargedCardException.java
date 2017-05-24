package exceptions;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

@SuppressWarnings("serial")
public class OverchargedCardException extends CardException {
	
	public OverchargedCardException() {}
	
	public OverchargedCardException(String msg) {
		super(msg);
	}
}