package exceptions;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

@SuppressWarnings("serial")
public class ClientException extends Exception {
	
	public ClientException() {}
	
	public ClientException(String msg) {
		super(msg);
	}
}