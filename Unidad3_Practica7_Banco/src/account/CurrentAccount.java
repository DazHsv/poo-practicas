package account;

import cards.debit.DebitCard;
import client.Client;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */
public final class CurrentAccount extends Account {
	private DebitCard card;

	public CurrentAccount(String bankcode, String placecode, Client owner) {
		super(bankcode, placecode, owner, "current", "debit");
		this.card = new DebitCard(this);
	}
	
	public DebitCard getCard() {
		return card;
	}

	@Override
	protected double getBalance() {
		return card.getBalance();
	}

}