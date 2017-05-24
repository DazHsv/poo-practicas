package transactions;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

import utils.DateHelper;

public abstract class Transaction {
	protected String date;
	protected double amount;
	protected String concept;
	protected double balance;
	
	public Transaction(String concept, double a) {
		this.amount = a;
		this.concept = concept;
		this.date = new DateHelper().getFullDate();
	}
	
	public String getDate() {
		return date;
	}
	public double getAmount() {
		return amount;
	}
	public String getConcept() {
		return concept;
	}
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double b) {
		this.balance = b;
	}
}
