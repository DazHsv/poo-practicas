package client;

/**
 * @author HUGO SANCHEZ VELAZQUEZ
 * GRUPO 2G2B
 * @version 1.0
 * */

public class Address {
	private String country;
	private String state;
	private String district;
	private String street;
	private String avenue;
	private String externalnumber;
	private String internalnumber;
	
	public Address(String country, String state, String district, String street,
			String avenue, String extnumber, String intnumber) {
		this.country = country;
		this.state = state;
		this.district = district;
		this.street = street;
		this.avenue = avenue;
		this.externalnumber = extnumber;
		this.internalnumber = intnumber;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getDistrict() {
		return district;
	}

	public String getStreet() {
		return street;
	}

	public String getAvenue() {
		return avenue;
	}

	public String getExternalnumber() {
		return externalnumber;
	}

	public String getInternalnumber() {
		return internalnumber;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setAvenue(String avenue) {
		this.avenue = avenue;
	}

	public void setExternalnumber(String externalnumber) {
		this.externalnumber = externalnumber;
	}

	public void setInternalnumber(String internalnumber) {
		this.internalnumber = internalnumber;
	}
	
	
}
