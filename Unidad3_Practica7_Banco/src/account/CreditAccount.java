package account;

import cards.credit.CreditCard;
import cards.credit.CreditCardBasic;
import cards.credit.CreditCardPlus;
import client.Client;
import exceptions.InvalidCardTypeException;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */
public final class CreditAccount extends Account {
	private CreditCard card;

	public CreditAccount(String bankcode, String placecode, Client owner,
			String type, double limit, double anualcost) throws InvalidCardTypeException {
		
		super(bankcode, placecode, owner, "credit", type);
		switch(type) {
			case "basic":
				this.card = new CreditCardBasic(this, limit, anualcost);
				break;
			case "plus":
				this.card = new CreditCardPlus(this, limit, anualcost);
				break;
			default:
				throw new InvalidCardTypeException("El tipo de tarjeta es invalido.");
		}
	}

	@Override
	protected double getBalance() {
		return card.getBalance();
	}

	@Override
	public CreditCard getCard() {
		return card;
	}

}
