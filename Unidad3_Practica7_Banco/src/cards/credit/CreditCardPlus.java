package cards.credit;

import account.CreditAccount;
import cards.credit.CreditCard;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */
public class CreditCardPlus extends CreditCard {
	public CreditCardPlus(CreditAccount account, double limit, double anualCost) {
		super(account, limit, anualCost);
	}
}