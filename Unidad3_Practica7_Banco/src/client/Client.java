package client;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

import exceptions.InvalidBirthdayException;
import exceptions.InvalidPhoneException;

public class Client {
	private String name;
	private Address address;
	private String phonenumber;
	private final String birthday;
	
	public Client(String name, String country, String state, String district, String street,
			String avenue, String extnumber, String intnumber, String phoneNumber, String birthday)
			throws InvalidPhoneException, InvalidBirthdayException {
		this.name = name;
		this.address = new Address(country, state, district, street, avenue, extnumber, intnumber);
		
		if(phoneNumber.length() < 10)
			throw new InvalidPhoneException("Numero incompleto.");
		else
			this.phonenumber = phoneNumber;
		
		if(Short.parseShort(birthday.substring(6)) < 1960)
			throw new InvalidBirthdayException("Fecha de nacimiento fuera de rango.");
		else
			this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
}
