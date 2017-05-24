package cards.credit;

import account.CreditAccount;
import cards.Card;
import exceptions.OverchargedCardException;
import transactions.Charge;
import transactions.Payment;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */
public class CreditCard extends Card {
	protected double creditLimit;
	protected double anualcost;
	
	public CreditCard(CreditAccount account, double limit, double anualcost) {
		super(account, 0);
		this.creditLimit = limit;
		this.anualcost = anualcost;
	}
	
	public double getCreditLimit() {
		return creditLimit;
	}
	public double getAnualcost() {
		return anualcost;
	}
	
	protected boolean isOvercharged() {
		return balance > creditLimit;
	}
	
	public void exec(Charge c) throws OverchargedCardException {
		if(!isOvercharged() && (balance + c.getAmount()) < creditLimit) {
			balance += c.getAmount();
			c.setBalance(balance);
			transactions.add(c);
		} else {
			throw new OverchargedCardException("Tarjeta sobre girada.");
		}
	}
	
	public void exec(Payment p) {
		balance += p.getAmount();
		p.setBalance(balance);
		transactions.add(p);
	}
}
