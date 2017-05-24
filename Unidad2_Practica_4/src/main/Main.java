package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0
 * Grupo 2g2B
 * Sistema de inventario de productos
 * */

public class Main {
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<>(5);
		System.out.println("Sistema de Inventario. Version 1.0.");
		
		try(Scanner s = new Scanner(System.in)){
			while(true) {
				System.out.println("Agregando nuevo producto...");
				Product p = new Product();
				
				System.out.print("Nombre: ");
				p.setName(s.nextLine());
				System.out.print("Clave: ");
				p.setKey(s.nextLine());
				System.out.print("Departamento: ");
				p.setDepartament(s.nextLine());
				System.out.print("Precio: ");
				p.setPrice(Double.parseDouble(s.nextLine()));
				
				if(products.add(p))
					System.out.println("Producto agregado.");
				else
					System.out.println("Problemas agregando el producto.");
				System.out.print("Agregar mas productos? (s/n): ");
				
				if(s.nextLine().equals("n")) break;
			}
		}
		
		System.out.println("\nListado de productos...");
		for (Product product : products) {
			System.out.format("%s %n %s - %s %n Precio: %.02f %n ",
					product.getDepartament(), product.getKey(), product.getName(), product.getPrice());
			System.out.format("IVA: %s %n Subtotal: %.02f%n",
					product.getIva() * 100 + "%",
					product.getPrice() + (product.getPrice() * product.getIva()));
		}
	}
}

class Product {
	private String name;
	private String key;
	private String departament;
	private double price;
	
	public Product() {
		this.name = "";
		this.key = "";
		this.departament = "";
		this.price = 0;
	}
	
	public void setName(String name) { this.name = name; }
	public void setKey(String key) { this.key = key; }
	public void setDepartament(String departament) { this.departament = departament; }
	public void setPrice(double price) { this.price = price; }
	
	public String getName() { return this.name; }
	public String getKey() { return this.key; }
	public String getDepartament() { return this.departament; }
	public double getPrice() { return this.price; }
	public double getIva() { return (this.price < 200 ? 0.10 : 0.15); }
}

