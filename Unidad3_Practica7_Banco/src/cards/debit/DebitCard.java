package cards.debit;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

import account.CurrentAccount;
import cards.Card;
import exceptions.NoFoundsException;
import transactions.Deposit;
import transactions.Withdrawal;

public final class DebitCard extends Card {
	
	public DebitCard(CurrentAccount a) {
		super(a, 0);
	}
	
	private boolean hasFounds() {
		return balance > 0;
	}
	
	public void exec(Deposit d) {
		this.balance += d.getAmount();
		d.setBalance(balance);
		this.transactions.add(d);
	}
	
	public void exec(Withdrawal w) throws NoFoundsException {
		if(hasFounds() && (balance - w.getAmount()) >= 0) {
			balance -= w.getAmount();
			w.setBalance(balance);
			transactions.add(w);
		} else {
			throw new NoFoundsException("Fondos insuficiente.");
		}
	}
}