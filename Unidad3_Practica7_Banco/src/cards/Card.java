package cards;

import java.util.ArrayList;

import account.Account;
import utils.DateHelper;
import transactions.Transaction;
import exceptions.InvalidNipLengthException;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */
public class Card {
	protected final String bankcode;
	protected final String cardnumber;
	protected final String expiresDate;
	protected ArrayList<Transaction> transactions;
	protected final Account owner;
	protected String nip;
	protected double balance;
	
	public Card(Account a, double b) {
		DateHelper dh = new DateHelper();
		this.bankcode = a.getBankcode();
		this.cardnumber = createCardNumber();
		this.owner = a;
		this.transactions = new ArrayList<Transaction>();
		this.expiresDate = dh.getMonth() + "/" + (dh.getYear() + 10);
		this.nip = createNip();
		this.balance = b;
	}
	
	public String getBankcode() { return bankcode; }
	public String getCardnumber() { return cardnumber; }
	public String getExpiresDate() { return expiresDate; }
	public ArrayList<Transaction> getTransactions() { return transactions; }
	public Account getOwner() { return owner; }
	public String getNip() { return nip; }
	
	public void setNip(String nip) throws InvalidNipLengthException {
		if(nip.length() != 4)
			throw new InvalidNipLengthException("La longitud del nip es invalida.");
		else
			this.nip = nip;
	}
	
	private String createNip() {
		String nip = "";
		for(byte i = 0; i < 4; i++)
			nip += Math.round(Math.random() * 10);
		return nip;
	}
	private String createCardNumber() {
		String number = "";
		for(byte i = 0; i < 17; i++)
			number += Math.round(Math.random() * 10);
		return number;
	}

	public double getBalance() {
		return balance;
	}
}