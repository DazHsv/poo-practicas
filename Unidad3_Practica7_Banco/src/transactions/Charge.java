package transactions;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

public class Charge extends Transaction {
	private final String from;
	
	public Charge(String from, String concept, double amount) {
		super(concept, amount);
		this.from = from;
	}
	
	public String getFrom() {
		return from;
	}
}
