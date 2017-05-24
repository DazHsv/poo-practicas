package main;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * Sistema de Factura de Productos.
 * 
 * */

import java.util.ArrayList;
import java.util.Calendar;

public class Factura {
	private ArrayList<Item> items;
	private final String date;
	private int hasIva;
	private String[] toHasIva;
	
	public Factura(String[] toHasIva) {
		this.items = new ArrayList<>(0);
		this.date = this.createDate();
		this.hasIva = 0;
		this.toHasIva = toHasIva;
	}
	
	public void editProductQuantity(int index, int quantity) {
		this.items.get(index).setQuantity(quantity);
	}
	
	public String getDate() { return date; }
	public ArrayList<Item> getProductos() { return items; }
	public int getHasIva() { return hasIva; }

	public double getSubtotal() {
		double subtotal = 0;
		for (Item item : items)
			subtotal += item.getQuantity() * item.getProducto().getPrice();
		return subtotal;
	}
	public double getTotal() {
		double total = 0;
		for (Item item : items) {
			double price = item.getProducto().getPrice();
			total += item.getQuantity() * (price + (price * item.getProducto().getIvaPercent()) );
		}
		
		return total;
	}

	public boolean addProduct(Producto p, int q) {
		for (String hasIva : this.toHasIva)
			if(hasIva.equals(p.getDepartament()))
				this.hasIva++;
		
		return items.add(new Item(p,q));
	}
	public boolean removeProduct(Item p) { return this.items.remove(p); }
	
	private String createDate() {
		Calendar c = Calendar.getInstance();
		return String.format("Fecha: %d/%d/%d",
				c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
	}
	
}