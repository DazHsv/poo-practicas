package main;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * Sistema de Factura de Productos.
 * 
 * */

public class Producto {
	private final String cproduct;
	private String name;
	private String departament;
	private double price;
	
	public Producto(String cproduct) {
		this.name = "";
		this.cproduct = cproduct;
		this.departament = "";
		this.price = 0;
	}
	
	public void setName(String name) { this.name = name; }
	public void setDepartament(String departament) { this.departament = departament; }
	public void setPrice(double price) { this.price = price; }
	
	public String getName() { return name; }
	public String getCproduct() { return cproduct; }
	public String getDepartament() { return departament; }
	public double getPrice() { return price; }
	public double getIvaPercent() {
		if(departament.equals("lacteos"))
			return 0.10;
		else if(departament.equals("muebles"))
			return 0.12;
		else if(departament.equals("electronica"))
			return 0.15;
		else
			return 0.16;
	}
}
