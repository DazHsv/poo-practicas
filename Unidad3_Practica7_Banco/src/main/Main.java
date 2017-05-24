package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import account.Account;
import account.CreditAccount;
import account.CurrentAccount;
import cards.Card;
import cards.credit.CreditCard;
import cards.debit.DebitCard;
import client.Address;
import client.Client;
import exceptions.InvalidBirthdayException;
import exceptions.InvalidCardTypeException;
import exceptions.InvalidNipException;
import exceptions.InvalidPhoneException;
import exceptions.NoFoundsException;
import exceptions.OverchargedCardException;
import transactions.Charge;
import transactions.Deposit;
import transactions.Payment;
import transactions.Transaction;
import transactions.Withdrawal;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */
public class Main {
	public static ArrayList<Account> accounts;
	
	public static void main(String[] args) {
		String main = "Tipo de usuario:\n" + "1) Banco\n" + "2) Atm\n" + "0) Salir";
		String opt;
		accounts = new ArrayList<>();
		
		try {
			Account a = new CurrentAccount("001", "044",
					new Client("hugo", "mx", "vr", "ft", "12", "12", "12", "2",
							"1234445566", "12/12/1998"));
			accounts.add(a);
			JOptionPane.showMessageDialog(null, a.getNumber() + ": " + a.getCard().getNip());
		} catch (InvalidPhoneException | InvalidBirthdayException e) {
			e.printStackTrace();
		}
		
		while(true) {
			opt = JOptionPane.showInputDialog(main); 
			if(opt.equals("0"))
				break;
			else if(opt.equals("1"))
				bankScreen();
			else if(opt.equals("2"))
				atmScreen();
			else
				JOptionPane.showMessageDialog(null, "Opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void bankScreen() {
		String bank = "Accion:\n" + "1) Creacion de Cuenta\n"+ "2) Buscar cuenta\n" + "0) Salir";
		String opt;
		Account account = null;
		while(true) {
			opt = JOptionPane.showInputDialog(bank); 
			if(opt.equals("0"))
				break;
			else if(opt.equals("1")) {
				account = Bank.createAccountScreen();
				if(!account.equals(null))
					accounts.add(account);				
			} else if(opt.equals("2"))
				Utils.searchAccountScreen(accounts);
			else
				JOptionPane.showMessageDialog(null, "Opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);			
		}
	}
	
	public static void atmScreen() {
		String cardnumber = JOptionPane.showInputDialog("Numero de tarjeta:");
		String opt;
		String creditatm = "Accion:\n1)Cargo\n2)Pago\n0) Salir";
		String debitatm = "Accion:\n1)Retiro\n2)Deposito\n0) Salir";
		int index = 0;
		
		Card card = null;
		Account account = null;
		for (Account a : accounts) {
			if(a.getCard().getCardnumber().equals(cardnumber)) {
				index = accounts.indexOf(a);
			}
		}
		
		account = accounts.get(index);
		card = account.getCard();
		
		byte error = 0;
		while(error < 3) {
			try {
				if(JOptionPane.showInputDialog("NIP:").equals(card.getNip())) {
					break;
				} else {
					error++;
					throw new InvalidNipException("Pin incorrecto.");
				}
			} catch (InvalidNipException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), e.getMessage(),
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if((error < 3) && !card.equals(null)) {
			if(account.getType().equals("credit")) {
				CreditCard creditcard = (CreditCard) card;
				opt = JOptionPane.showInputDialog(creditatm);
				if(opt.equals("0"));
				else if(opt.equals("1"))
					try {
						creditcard.exec(Atm.charge());
					} catch (NumberFormatException e) {
						JOptionPane.showInternalMessageDialog(null, "Cantidad invalida", "Cantidad invalida",
								JOptionPane.ERROR_MESSAGE);
					} catch (OverchargedCardException e) {
						JOptionPane.showInternalMessageDialog(null, "Fondos insuficientes", "Sin fondos",
								JOptionPane.ERROR_MESSAGE);
					}
				else if(opt.equals("2"))
					creditcard.exec(Atm.payment());
				else
					JOptionPane.showMessageDialog(null, "Opcion invalida", "Opcion invalida",
							JOptionPane.ERROR_MESSAGE);
			} else {
				DebitCard debitcard = (DebitCard) card;
				opt = JOptionPane.showInputDialog(debitatm);
				if(opt.equals("0"));
				else if(opt.equals("1"))
					try {
						debitcard.exec(Atm.withdrawal());
					} catch (NumberFormatException e) {
						JOptionPane.showInternalMessageDialog(null, "Cantidad invalida", "Cantidad invalida",
								JOptionPane.ERROR_MESSAGE);
					} catch (NoFoundsException e) {
						JOptionPane.showMessageDialog(null, "Fondos insuficientes", "Sin fondos",
								JOptionPane.ERROR_MESSAGE);
					}
				else if(opt.equals("2"))
					debitcard.exec(Atm.deposit());
				else
					JOptionPane.showMessageDialog(null, "Opcion invalida", "Opcion invalida",
							JOptionPane.ERROR_MESSAGE);
			}
			
			accounts.set(index, account);
		} else {
			JOptionPane.showMessageDialog(null, "Demaciados intentos fallidos.", "NIP bloqueado.",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}

class Bank {
	
	public static Account createAccountScreen() {
		String createAccount = "Tipo de Cuenta:\n" + "1) Cuenta Corriente\n" + "2) Cuenta de Credito\n" + "0) Salir";
		String opt;
		while(true) {
			opt = JOptionPane.showInputDialog(createAccount);
			if(opt.equals("0"))
				break;
			else if(opt.equals("1"))
				return createCurrentAccount();
			else if(opt.equals("2"))
				return createCreditAccount();
			else
				JOptionPane.showMessageDialog(null, "Opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public static Account createCurrentAccount() {
		Client client = createClient();
		CurrentAccount currentAccount = null;
		if(!client.equals(null)) {
			currentAccount = new CurrentAccount("001", "044", client);
			JOptionPane.showMessageDialog(null, "Cuenta: " + currentAccount.getNumber(),
					"Cuenta creada", JOptionPane.INFORMATION_MESSAGE);
		}
		return currentAccount;
	}
	
	public static Account createCreditAccount() {
		CreditAccount creditAccount = null;
		Client client = createClient();
		if(!client.equals(null)) {
			while(true) {
				try {
					creditAccount = new CreditAccount("001", "044", client,
							JOptionPane.showInputDialog("TIpo de tarjeta:\n*) Basic\n*) Plus").toLowerCase(),
							Double.parseDouble(JOptionPane.showInputDialog("Limit de la cuenta:")),
							Double.parseDouble(JOptionPane.showInputDialog("Costo anual:")));
					JOptionPane.showMessageDialog(null, "Cuenta: " + creditAccount.getNumber(),
							"Cuenta creada", JOptionPane.INFORMATION_MESSAGE);
					break;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Cantidad invalida", "Error de cantidad",
							JOptionPane.ERROR_MESSAGE);
				} catch (InvalidCardTypeException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error de tarjeta",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		return creditAccount;
	}
	
	public static Client createClient() {
		Client client = null;
		while(true) {
			try {
				client = new Client(
						JOptionPane.showInputDialog("Nombre:"),
						JOptionPane.showInputDialog("Pais:"),
						JOptionPane.showInputDialog("Estado:"),
						JOptionPane.showInputDialog("Municipio:"),
						JOptionPane.showInputDialog("Calle:"),
						JOptionPane.showInputDialog("Avenida:"),
						JOptionPane.showInputDialog("Numero exterior:"),
						JOptionPane.showInputDialog("Numero interior:"),
						JOptionPane.showInputDialog("Telefono celular:"),
						JOptionPane.showInputDialog("Fecha de nacimiento (dd/mm/yyyy):"));
				break;
			} catch (InvalidPhoneException | InvalidBirthdayException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		return client;
	}
}

class Atm {
	
	public static Charge charge() {
		try {
			return new Charge(JOptionPane.showInputDialog("Origen:"),
					JOptionPane.showInputDialog("Concepto de la compra:"),
					Double.parseDouble(JOptionPane.showInputDialog("Monto de compra:")));
		} catch (NumberFormatException e) {
			JOptionPane.showInternalMessageDialog(null, "Cantidad invalida", "Cantidad invalida",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	public static Payment payment() {
		return new Payment("Pago de tarjeta.",
				Double.parseDouble(JOptionPane.showInputDialog("Monto:")));
	}
	
	public static Deposit deposit() {
		return new Deposit("Deposito a cuenta.",
				Double.parseDouble(JOptionPane.showInputDialog("Monto:")));
	}
	
	public static Withdrawal withdrawal() {
		 return new Withdrawal("Retiro de cuenta.",
				Double.parseDouble(JOptionPane.showInputDialog("Monto:")));
	}
}

class Utils {
	public static void searchAccountScreen(ArrayList<Account> accounts) {
		String accountnumber = JOptionPane.showInputDialog("Numero de cuenta: ");
		Account found = null;
		for (Account account : accounts) {
			if(account.getNumber().equals(accountnumber))
				found = account;
		}
		
		if(!found.equals(null))
			showAccountInfo(found);
		else
			JOptionPane.showMessageDialog(null, "Cuenta no encontrada", "Busqueda sin exito",
					JOptionPane.ERROR_MESSAGE);
		
	}
	
	public static void showAccountInfo(Account account) {
		String info = "Info de la cuenta:\n";
		String transactions = "Transacciones:\n";
		Client client  = account.getOwner();
		Address address = client.getAddress();
		Card card = account.getCard();
		
		info += "Codigo de banco: " + account.getBankcode() + "\n";
		info += "Codigo de area: " + account.getPlacecode() + "\n";
		info += "Numero de cuenta: " + account.getNumber() + "\n";
		info += "Fecha de apertura: " + account.getOpenDate() + "\n";
		info += "CLABE: " + account.getClabe() + "\n";
		info += "-----------------------\n";
		info += "Nombre: " + client.getName() + "\n";
		info += "Telefono: " + client.getPhonenumber() + "\n";
		info += "Fecha de nacimiento: " + client.getBirthday() + "\n";
		info += "Pais: " + address.getCountry() + " | ";
		info += "Estado: " + address.getState() + " | ";
		info += "Municipio:" + address.getDistrict() + "\n";
		info += "Calle: " + address.getStreet() + " | ";
		info += "Avenida: " + address.getAvenue() + " | ";
		info += "Numero externo: " + address.getExternalnumber() + " - ";
		info += "Numero interno: " + address.getInternalnumber() + "\n";
		info += "----------------------\n";
		info += "Tipo de cuenta: " + (account.getType().equals("credit") ? "Credito" : "Corriente") + "\n";
		info += "Tipo de tarjeta: " + (account.getType().equals("credit") ? "Credito" : "Debito") + "\n";
		info += "Tarjeta: " + account.getCardType() + "\n";
		info += "Numero de tarjeta: " + card.getCardnumber() + "\n";
		info += "Fecha de expiracion: " + card.getExpiresDate() + "\n";
		info += "NIP: " + card.getNip() + "\n";
		info += "Balance: " + card.getBalance() + "\n";
		if(account.getType().equals("credit")) {
			CreditCard creditCard = (CreditCard) card;
			info += "Limit de credito: " + creditCard.getCreditLimit() +"\n";
			info += "Costo anual: " + creditCard.getAnualcost() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, info);
		for (Transaction t : card.getTransactions())
			transactions += t.getDate() + " - " + t.getConcept() + " | " +
					t.getAmount() + " | " + t.getBalance() + "\n";
		
		JOptionPane.showMessageDialog(null, transactions);
	}
}