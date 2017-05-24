package exceptions;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

@SuppressWarnings("serial")
public class NoFoundsException extends AccountException {
	
	public NoFoundsException() {}
	
	public NoFoundsException(String msg) {
		super(msg);
	}
}