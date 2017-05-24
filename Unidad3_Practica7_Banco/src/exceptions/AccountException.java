package exceptions;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

@SuppressWarnings("serial")
public class AccountException extends Exception {

	public AccountException() {}
	
	public AccountException(String msg) {
		super(msg);
	}
}

