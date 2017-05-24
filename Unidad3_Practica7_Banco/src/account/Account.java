package account;

import cards.Card;
import client.Client;
import utils.DateHelper;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */
public abstract class Account {
	protected final String bankcode;
	protected final String placecode;
	protected final String number;
	protected final String openDate;
	protected final String clabe;
	protected final Client owner;
	protected final String type;
	protected final String cardType;
	
	public Account(String bankcode, String placecode, Client owner, String type, String cardType) {
		this.bankcode = bankcode;
		this.placecode = placecode;
		this.number = createAccountnumber();
		this.openDate = new DateHelper().getDate();
		this.clabe = createClabe();
		this.owner = owner;
		this.type = type;
		this.cardType = cardType;
	}
	
	public String getBankcode() {
		return bankcode;
	}
	public String getPlacecode() {
		return placecode;
	}
	public String getNumber() {
		return number;
	}
	public String getOpenDate() {
		return openDate;
	}
	public String getClabe() {
		return clabe;
	}
	public Client getOwner() {
		return owner;
	}
	public String getType() {
		return type;
	}
	public String getCardType() {
		return cardType;
	}

	public abstract Card getCard();
	
	protected abstract double getBalance();
	
	private String createClabe() {
		String clabe = "";
		for(byte x = 0; x < 19; x++)
			clabe += Math.round(Math.random() * 10);
		return clabe;
	}
	
	private String createAccountnumber() {
		String accountnumber = "";
		for(byte x = 0; x < 11; x++)
			accountnumber += Math.round(Math.random() * 10);
		return accountnumber;
	}
}
