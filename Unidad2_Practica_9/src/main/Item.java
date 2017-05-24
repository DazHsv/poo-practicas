package main;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * Sistema de Factura de Productos.
 * 
 * */

class Item {
	private final Producto producto;
	private int quantity;
	
	public Item(Producto p, int q) {
		this.quantity = q;
		this.producto = p;
	}
	
	public void setQuantity(int quantity) { this.quantity = quantity; }
	
	public int getQuantity() { return quantity; }
	public Producto getProducto() { return producto; }
}