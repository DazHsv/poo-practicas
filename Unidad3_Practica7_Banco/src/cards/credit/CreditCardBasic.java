package cards.credit;

import account.CreditAccount;
import cards.credit.CreditCard;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */
public class CreditCardBasic extends CreditCard {
	public CreditCardBasic(CreditAccount account, double limit, double anualCost) {
		super(account, limit, anualCost);
	}
}
